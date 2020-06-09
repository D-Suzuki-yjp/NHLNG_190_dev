package job.sfcommon.function.outputmessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.RequestScoped;

import org.apache.ibatis.session.SqlSession;

import com.yse.gb.sf.frame.demand.servertask.ServerTask;

import biz.grandsight.looponex.LoopOnExException;
import biz.grandsight.looponex.user.api.TagDataManager;
import biz.grandsight.looponex.user.api.model.TagData;
import biz.grandsight.looponex.user.api.model.TagValue;
import job.sfcommon.dataaccess.dao.nhlng.CmmMessageDefDao;
import job.sfcommon.dataaccess.dao.nhlng.CmmMessageTagDao;
import job.sfcommon.dataaccess.dao.nhlng.CmtMessageDao;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.function.outputlogs.OutPutLogs;
import job.sfcommon.util.SystemUtil;
import job.sfcommon.util.TagUtil;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki 初版 R0.01.02 2020/04/10
 * 30042453/D.Suzuki DDC警報条件追加 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * PutMessage メッセージ出力デマンドアプリケーション実行クラス
 *
 * @author D.Suzuki
 * @see com.yse.gb.sf.frame.demand.servertask.ServerTask
 */
@RequestScoped
public class PutMessage implements ServerTask {

	public PutMessage() {

	}

	/**
	 * メッセージ出力デマンドアプリケーション実行
	 *
	 * @param arg0
	 *            デマンド呼出元からのparamList
	 * @return null
	 */
	public Object execute(@SuppressWarnings("rawtypes") List arg0) throws Throwable {

		String msgId = arg0.get(0).toString();
		String msgCat = arg0.get(1).toString();
		boolean absolute = (boolean) arg0.get(2);

		String[] msgParams = {};
		if (4 <= arg0.size()) {
			msgParams = (arg0.get(3).toString()).split(",");
		}

		PutMessageMain(msgId, msgCat, absolute, msgParams);

		return null;
	}

	@Override
	public void finalMethod() throws Throwable {

	}

	@Override
	public void init() throws Throwable {

	}

	/**
	 * メッセージ出力メイン処理
	 *
	 * @param MsgId
	 *            メッセージID
	 * @param msgCat
	 *            メッセージカテゴリ
	 * @param absolute
	 *            無条件出力フラグ
	 * @param msgParams
	 *            埋込パラメータ
	 * @return
	 */
	public void PutMessageMain(String msgId, String msgCat, boolean absolute, String[] msgParams) {

		boolean alarmExistencs = false;
		SqlSession session = SelectDb.dbAcssece("nhlng");

		// メッセージ定義取得処理呼出
		Map<CmmMessageDefDao.COLUMNS, Object> CmmMessageDef = getMessageDef(session, msgId, msgCat, msgParams);

		// メッセージタグ出力処理
		List<Integer> writeOPCResultCodeList = writeMessageTag(session, msgId, msgCat, absolute);

		for (Integer writeOPCResultCode : writeOPCResultCodeList) {
			if (666 == writeOPCResultCode) {
				// 発報済の場合は発報済フラグをtrueにする
				alarmExistencs = true;
			} else if (0 != writeOPCResultCode) {
				// メッセージタグ出力処理の戻り値が「0（正常終了）」以外の場合
				// DDC書込異常をログ出力
				/** TODO ログIDのプロパティ化 */
				String[] param = { msgId };
				OutPutLogs.outPutLogs("CMN", "logId", param);
			}
		}

		// 発報済でなければメッセージデータ情報書込処理呼出
		if (!alarmExistencs) {
			putMessage(session, CmmMessageDef);
		}
		// 最後にセッションクローズ
		session.close();
	}

	/**
	 * メッセージ定義取得処理
	 *
	 * @param session
	 * @param MsgId
	 *            メッセージID
	 * @param msgCat
	 *            メッセージカテゴリ
	 * @param msgParams
	 *            埋込パラメータ
	 * @return CmmMessageDef メッセージ定義情報
	 */
	private Map<CmmMessageDefDao.COLUMNS, Object> getMessageDef(SqlSession session, String msgId, String msgCat,
			String[] msgParams) {

		// メッセージ定義情報テーブルのレコードを格納するobject
		Map<CmmMessageDefDao.COLUMNS, Object> CmmMessageDef = new HashMap<CmmMessageDefDao.COLUMNS, Object>();
		try {
			// 一意のメッセージ定義取得
			CmmMessageDef = CmmMessageDefDao.selectByPrimaryKey(session, msgId, msgCat);

			if (CmmMessageDef.isEmpty()) {
				// テーブル検索結果が0件の場合は固定文言で警告文をセット
				/** TODO 検索結果0件のエラーはlog出力 **/

			} else {
				// 動的パラメータをメッセージに埋込
				if (Objects.nonNull(msgParams)) {
					String msgText = CmmMessageDef.get(CmmMessageDefDao.COLUMNS.MSG_TEXT).toString();
					for (int i = 0; i < msgParams.length; i++) {
						/** 置換用の"$"をプロパティ化 */
						msgText = msgText.replace("$" + (i + 1), msgParams[i]);
					}
					CmmMessageDef.put(CmmMessageDefDao.COLUMNS.MSG_TEXT, msgText);
				}
			}
		} catch (Exception e) {
			String[] param = { msgId };
			/** TODO ログIDのプロパティ化 */
			OutPutLogs.outPutLogs("CMN", "logId", param);
		}
		return CmmMessageDef;
	}

	/**
	 * メッセージタグ出力処理
	 *
	 * @param session
	 * @param MsgId
	 *            メッセージID
	 * @param msgCat
	 *            メッセージカテゴリ
	 * @param absolute
	 *            無条件出力フラグ
	 * @return writeSubsystemOPCResultCodeList OPC書込結果コードリスト
	 */
	private List<Integer> writeMessageTag(SqlSession session, String msgId, String msgCat, boolean absolute) {
		// tagNoとlcodeをマッピングしたグローバル変数を取得
		Map<String, String> tagNoToLcodeMap = TagUtil.getTagNoToLcodeMap();
		// 書き込み結果コードを格納する変数を初期化
		List<Integer> writeSubsystemOPCResultCodeList = new ArrayList();
		// DBからメッセージタグ情報を取得するMapのListを初期化
		List<Map<CmmMessageTagDao.COLUMNS, Object>> CmmMessageTagList = new ArrayList();
		// DBからメッセージタグ情報を取得
		try {
			CmmMessageTagList = CmmMessageTagDao.selectByMsgId(session, msgId, msgCat);
		} catch (Exception e) {
			/** TODO 例外処理 **/
		}
		// メッセージタグ情報検索結果の件数を確認する
		if (0 == CmmMessageTagList.size()) {
			/** TODO APIのリターンコードはマスタを定数に持つようにする **/
			// 検索結果0件ならばOPCタグ書き込み結果に「0（正常終了）」をセット
			writeSubsystemOPCResultCodeList.add(0);
		} else {
			// 検索結果1件以上ならば全てのメッセージタグ情報をOPCタグに書込む
			TagDataManager tagDataManager = new TagDataManager();
			boolean alarmExistencs = false;
			List<TagValue> tagValueList = new ArrayList();
			TagValue tagValue;
			for (Map<CmmMessageTagDao.COLUMNS, Object> CmmMessageTag : CmmMessageTagList) {
				// 無条件出力フラグがtrueでなければ発報済チェック
				TagData tagData = new TagData();
				try {
					/** TODO サブシステムIDをプロパティ化 */
					tagData = tagDataManager.readCoreTagData(
							tagNoToLcodeMap.get(((String) CmmMessageTag.get(CmmMessageTagDao.COLUMNS.TAG_NO))));
				} catch (LoopOnExException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				if (((CmmMessageTag.get(CmmMessageTagDao.COLUMNS.TAG_VAL)).toString()).equals(tagData.getTagValue())) {
					alarmExistencs = true;
				}
				// 取得したメッセージタグ情報をLoopOnExAPIのパラメータとして送るListに詰替え
				tagValue = new TagValue();
				tagValue.setTagItemName(
						tagNoToLcodeMap.get(((String) CmmMessageTag.get(CmmMessageTagDao.COLUMNS.TAG_NO))));// タグNO
				tagValue.setValue(CmmMessageTag.get(CmmMessageTagDao.COLUMNS.TAG_VAL).toString());// タグ値
				tagValueList.add(tagValue);
			}
			// OPCタグ書込(LoopOnExAPI)
			// ステータス変動が無い場合は出力しない
			if (alarmExistencs && !absolute) {
				writeSubsystemOPCResultCodeList.add(666);
			} else {
				// 自身が主系の場合のみDDCに出力
				/** TODO 主従状態定数のプロパティ化 */
				if (1 == (SystemUtil.getMasterStat(session).getMasterStatOneself())) {
					try {
						/** TODO サブシステムIDをプロパティ化 */
						// LoopOnExAPI
						writeSubsystemOPCResultCodeList = tagDataManager.writeSubsystemTagData("STN0123", tagValueList);
					} catch (Exception e) {
						// API実行で例外となった場合は「-9（例外終了）」をリターン
						/** TODO APIのリターンコード定数のプロパティ化 **/
						writeSubsystemOPCResultCodeList.add(-9);
					}
				} else {
					writeSubsystemOPCResultCodeList.add(0);
				}
			}
		}
		// OPCタグ書込み結果をmainにリターン
		return writeSubsystemOPCResultCodeList;
	}

	/**
	 * メッセージデータ情報書込処理
	 *
	 * @param session
	 * @param cmmMessageDef
	 *            メッセージ定義情報
	 */
	private void putMessage(SqlSession session, Map<CmmMessageDefDao.COLUMNS, Object> cmmMessageDef) {
		// CMT_MESSAGEにinsertするrecordをインスタンス
		Map<CmtMessageDao.COLUMNS, Object> record = new HashMap<CmtMessageDao.COLUMNS, Object>();

		// DBから取得したメッセージ定義のレコードをメッセージ情報テーブルにinsertするレコードに詰替える
		for (CmmMessageDefDao.COLUMNS column : cmmMessageDef.keySet()) {
			record.put(CmtMessageDao.COLUMNS.valueOf(column.toString()), cmmMessageDef.get(column));
		}
		// メッセージ情報テーブルにメッセージ追加
		try {
			CmtMessageDao.insert(session, record);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());

			session.rollback();
			String[] param = { cmmMessageDef.get(CmmMessageDefDao.COLUMNS.MSG_ID).toString() };
			/** TODO ログIDのプロパティ化 */
			OutPutLogs.outPutLogs("CMN", "logId", param);
		} finally {
			session.close();
		}
	}
}
