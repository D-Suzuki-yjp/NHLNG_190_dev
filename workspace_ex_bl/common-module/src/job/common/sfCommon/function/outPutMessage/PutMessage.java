package job.common.sfCommon.function.outPutMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.yse.gb.sf.frame.demand.servertask.ServerTask;

import biz.grandsight.looponex.user.api.TagDataManager;
import biz.grandsight.looponex.user.api.model.TagValue;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmmMessageDefDao;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmmMessageTagDao;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtMessageDao;
import job.common.sfCommon.dataAccess.session.selectDb;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * PutMessage メッセージ出力デマンドアプリケーション実行クラス
 * @author D.Suzuki
 * @see com.yse.gb.sf.frame.demand.servertask.ServerTask
 */
@RequestScoped
public class PutMessage implements ServerTask {

	@Inject
	TagDataManager TagDataManager;
	@Inject
	SqlSession session = selectDb.dbAcssece("nhlng");

	public PutMessage() {

	}

	/**
	 * メッセージ出力デマンドアプリケーション実行
	 * @param arg0  デマンド呼出元からのparamList
	 * @return null
	 */
	public Object execute(List arg0) throws Throwable {

		String msgId = arg0.get(0).toString();
		String msgCat = arg0.get(1).toString();
		String[] msgParams = {};

		if(3 <= arg0.size()){
			msgParams = (arg0.get(2).toString()).split(",");
		}

		PutMessageMain(msgId, msgCat, msgParams);

		session.close();
		return null;
	}

	@Override
	public void finalMethod() throws Throwable {
		session.close();
	}

	@Override
	public void init() throws Throwable {

	}

	/**
	 * メッセージ出力メイン処理
	 * @param MsgId  メッセージID
	 * @param msgCat  メッセージカテゴリ
	 * @param msgParams  埋込パラメータ
	 * @return
	 */
	public void PutMessageMain(String MsgId, String msgCat, String[] msgParams) {

		// メッセージ定義取得処理呼出
		Map<CmmMessageDefDao.COLUMNS, Object> CmmMessageDef = getMessageDef(MsgId, msgCat, msgParams);

		// メッセージデータ情報書込処理呼出
		putMessage(CmmMessageDef);

		// メッセージタグ出力処理
		List<Integer> writeOPCResultCodeList = writeMessageTag(MsgId, msgCat);
		for (Integer writeOPCResultCode : writeOPCResultCodeList) {
			if (0 != writeOPCResultCode) {
				// メッセージタグ出力処理の戻り値が「0（正常終了）」以外の場合
				// OPC書込異常ログ出力処理呼出
				putMessage(outWriteOPCFailed(writeOPCResultCode, MsgId));
			}
		}
	}

	/**
	 * メッセージ出力メイン処理
	 * @param MsgId  メッセージID
	 * @param msgCat  メッセージカテゴリ
	 * @param msgParams  埋込パラメータ
	 * @return CmmMessageDef メッセージ定義情報
	 */
	// メッセージ定義取得処理
	private Map<CmmMessageDefDao.COLUMNS, Object> getMessageDef(String msgId, String msgCat, String[] msgParams) {

		// メッセージ定義情報テーブルのレコードを格納するobject
		Map<CmmMessageDefDao.COLUMNS, Object> CmmMessageDef = new HashMap<CmmMessageDefDao.COLUMNS, Object>();
		try {
			// 一意のメッセージ定義取得
			CmmMessageDef = CmmMessageDefDao.selectByPrimaryKey(session, msgId, msgCat);

			if (CmmMessageDef.isEmpty()) {
				// テーブル検索結果が0件の場合は固定文言で警告文をセット
				/** TODO メッセージ定義取得失敗時の固定文言はプロパティから取得 **/
				CmmMessageDef.put(CmmMessageDefDao.COLUMNS.MSGID, "HO-GE");
				CmmMessageDef.put(CmmMessageDefDao.COLUMNS.MSGCAT, "MSG");
				CmmMessageDef.put(CmmMessageDefDao.COLUMNS.MSGKIND, "E");
				CmmMessageDef.put(CmmMessageDefDao.COLUMNS.MSGTEXT, "const.hoge 存在しません：" + msgId + "," + msgCat);
			} else {
				// 動的パラメータをメッセージに埋込
				if (Objects.nonNull(msgParams)) {
					String msgText = CmmMessageDef.get(CmmMessageDefDao.COLUMNS.MSGTEXT).toString();
					for (int i = 0; i < msgParams.length; i++) {
						msgText = msgText.replace("$"+(i+1), msgParams[i]);
					}
					CmmMessageDef.put(CmmMessageDefDao.COLUMNS.MSGTEXT, msgText);
					session.commit();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return CmmMessageDef;
	}

	/**
	 * メッセージ出力メイン処理
	 * @param cmmMessageDef  メッセージ定義情報
	 * @return
	 */
	private void putMessage(Map<CmmMessageDefDao.COLUMNS, Object> cmmMessageDef) {
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
		}
	}

	/**
	 * メッセージ出力メイン処理
	 * @param MsgId  メッセージID
	 * @param msgCat  メッセージカテゴリ
	 * @return writeSubsystemOPCResultCodeList OPC書込結果コードリスト
	 */
	private List<Integer> writeMessageTag(String MsgId, String msgCat) {
		// 書き込み結果コードを格納する変数を初期化
		List<Integer> writeSubsystemOPCResultCodeList = new ArrayList();
		// DBからメッセージタグ情報を取得するMapのListを初期化
		List<Map<CmmMessageTagDao.COLUMNS, Object>> CmmMessageTagList = new ArrayList();
		// DBからメッセージタグ情報を取得
		try {
			CmmMessageTagList = CmmMessageTagDao.selectByMsgId(session, MsgId, msgCat);
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
			for (Map<CmmMessageTagDao.COLUMNS, Object> CmmMessageTag : CmmMessageTagList) {
				// 取得したメッセージタグ情報をLoopOnExAPIのパラメータとして送るListに詰替え
				List<TagValue> tagValueList = new ArrayList();
				TagValue tagValue = new TagValue();
				tagValue.setTagItemName(CmmMessageTag.get(CmmMessageTagDao.COLUMNS.TAGNO).toString());// タグNO
				tagValue.setValue(CmmMessageTag.get(CmmMessageTagDao.COLUMNS.TAGVAL).toString());// タグ値
				tagValueList.add(tagValue);
				// OPCタグ書込(LoopOnExAPI)
				try {
					writeSubsystemOPCResultCodeList = TagDataManager.writeSubsystemTagData("subSystemId",
							tagValueList);
				} catch (Exception e) {
					// API実行で例外となった場合は「-9（例外終了）」をリターン
					/** TODO APIのリターンコードはマスタを定数に持つようにする **/
					writeSubsystemOPCResultCodeList.add(-9);
				}
			}
		}
		// OPCタグ書込み結果をmainにリターン
		return writeSubsystemOPCResultCodeList;
	}

	/**
	 * メッセージ出力メイン処理
	 * @param writeOPCResultCode  OPC書込結果コード
	 * @param MsgId メッセージID
	 * @return writeSubsystemOPCResultCodeList OPC書込結果コードリスト
	 */
	private Map<CmmMessageDefDao.COLUMNS, Object> outWriteOPCFailed(int writeOPCResultCode, String MsgId) {
		/** TODO 文言はプロパティから取得 **/
		String messageText = null;
		Map<CmmMessageDefDao.COLUMNS, Object> record = new HashMap<CmmMessageDefDao.COLUMNS, Object>();
		try {
			switch (writeOPCResultCode) {
			// 書き込み失敗
			case -1:
				messageText = "const.hoge1 書き込み失敗:" + MsgId;
				break;

			// 該当タグNoなし
			case -2:
				messageText = "const.hoge2 該当タグNoなし:" + MsgId;
				break;

			// Exception発生
			case -9:
				messageText = "const.hoge3 Exception発生:" + MsgId;
				break;

			default:
				messageText = "const.hoge1 書き込み失敗:" + MsgId;
			}
			/** TODO 固定メッセージ定義作成 **/
			record.put(CmmMessageDefDao.COLUMNS.MSGID, "HO-GE");
			record.put(CmmMessageDefDao.COLUMNS.MSGCAT, "OPC");
			record.put(CmmMessageDefDao.COLUMNS.MSGKIND, "E");
			record.put(CmmMessageDefDao.COLUMNS.MSGTEXT, messageText);

			/** TODO ログ出力共通クラスを追加 **/

			putMessage(record);
		} catch (Exception e) {
			record.put(CmmMessageDefDao.COLUMNS.MSGTEXT, "const.hoge");
		}
		return record;
	}
}
