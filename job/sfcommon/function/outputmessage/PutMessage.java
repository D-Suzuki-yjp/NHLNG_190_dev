package job.sfcommon.function.outputmessage;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki 初版
 * R0.01.02 2020/04/10 30042453/D.Suzuki DDC警報条件追加
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * PutMessage メッセージ出力デマンドアプリケーション
 *
 * @author D.Suzuki
 */

import java.util.ArrayList;
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
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDef;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDefExample;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageTag;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageTagExample;
import job.sfcommon.dataaccess.entity.nhlng.CmtMessage;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.function.outputlogs.OutPutLogs;
import job.sfcommon.util.ConstUtil;
import job.sfcommon.util.SystemUtil;
import job.sfcommon.util.TagUtil;

/**
 * メッセージ出力デマンドアプリケーションクラス
 * @author D.Suzuki
 */
@RequestScoped
public class PutMessage implements ServerTask {

	/** 無条件出力 */
	private final String ABSOLUTE = "0";
	/** ログカテゴリ */
	private static final String LOG_CAT = ConstUtil.LOG_COMMON;
	/** 定義取得失敗ログ文言 */
	private final String FAILER_GETDEF_TEXT = "定義取得失敗";
	/** 出力失敗ログ文言 */
	private final String FAILER_PUTMSG_TEXT = "出力失敗";
	/** アラート状態変化無しパラメータ */
	private final int NO_CHANGE_STAT = 666;

	/**
	 * コンストラクタ
	 */
	public PutMessage() {

	}

	/**
	 * メッセージ出力デマンドアプリケーション実行
	 *
	 * @param arg0
	 *            デマンド呼出元からのparamList
	 * @return null
	 * @throws Throwable
	 */
	public Object execute(@SuppressWarnings("rawtypes") List arg0) throws Throwable {

		// メッセージID
		String msgId = arg0.get(0).toString();

		// 条件付きフラグ(true:無条件出力/false:条件付き出力)
		boolean absolute = false;
		if (ABSOLUTE.equals(arg0.get(1).toString())) {
			absolute = true;
		}

		// 埋込パラメータ
		String[] msgParams = {};
		if (3 <= arg0.size()) {
			msgParams = (arg0.get(2).toString()).split(",");
		}
		// 処理実行
		PutMessageMain(msgId, absolute, msgParams);

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
	 * @param absolute
	 *            無条件出力フラグ
	 * @param msgParams
	 *            埋込パラメータ
	 * @return
	 */
	public void PutMessageMain(String msgId, boolean absolute, String[] msgParams) {

		SqlSession session = SelectDb.dbAcssece(ConstUtil.NHLNG);
		try {
			// 発報済フラグ
			boolean alarmExistencs = false;

			// メッセージ定義取得処理呼出
			CmmMessageDef cmmMessageDef = getMessageDef(session, msgId, msgParams);

			// メッセージタグ出力処理
			List<Integer> writeOPCResultCodeList = writeMessageTag(session, msgId, absolute);

			for (Integer writeOPCResultCode : writeOPCResultCodeList) {
				if (NO_CHANGE_STAT == writeOPCResultCode) {
					// 発報済の場合は発報済フラグをtrueにする
					alarmExistencs = true;
				} else if (ConstUtil.LOEX_API_SUCCESS != writeOPCResultCode) {
					// メッセージタグ出力処理の戻り値が「0（正常終了）」以外の場合
					// DDC書込異常をログ出力
					String[] param = { msgId + "のDDC書込み失敗:" + writeOPCResultCode };
					OutPutLogs.outPutLogs(LOG_CAT, "0003", param);
				}
			}

			// 発報済でなければメッセージデータ情報書込処理呼出
			if (!alarmExistencs && Objects.nonNull(cmmMessageDef)) {
				putMessage(session, cmmMessageDef);
			}
		} catch (Exception e) {
			String[] param = { new Object() {
			}.getClass().getEnclosingMethod().getName() };
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
		} finally {
			// 最後にセッションクローズ
			session.close();
		}
	}

	/**
	 * メッセージ定義取得処理
	 *
	 * @param session
	 *            SqlSession
	 * @param MsgId
	 *            メッセージID
	 * @param msgParams
	 *            埋込パラメータ
	 * @return CmmMessageDef メッセージ定義情報
	 */
	private CmmMessageDef getMessageDef(SqlSession session, String msgId, String[] msgParams) {

		// メッセージ定義情報テーブルのレコードを格納するobject
		List<CmmMessageDef> results = new ArrayList<CmmMessageDef>();
		CmmMessageDef cmmMessageDef = new CmmMessageDef();

		try {
			// 一意のメッセージ定義取得
			CmmMessageDefExample example = new CmmMessageDefExample();
			example.createCriteria().andMsgIdEqualTo(msgId);
			results = CmmMessageDefDao.select(session, example);

			if (results.size() != 1) {
				// テーブル検索結果が一意でない場合は固定文言で警告文をセット
				String[] param = { msgId + FAILER_GETDEF_TEXT };
				OutPutLogs.outPutLogs(LOG_CAT, "0003", param);

			} else {
				cmmMessageDef = results.get(0);
				// 動的パラメータをメッセージに埋込
				if (Objects.nonNull(msgParams)) {
					String msgText = cmmMessageDef.getMsgText();
					for (int i = 0; i < msgParams.length; i++) {
						msgText = msgText.replace("$" + (i + 1), msgParams[i].toString());
					}
					cmmMessageDef.setMsgText(msgText);
				}
			}
		} catch (Exception e) {
			String[] param = { msgId + FAILER_GETDEF_TEXT };
			e.printStackTrace();
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw (e);
		}
		return cmmMessageDef;
	}

	/**
	 * メッセージタグ出力処理
	 *
	 * @param session
	 *            SqlSession
	 * @param MsgId
	 *            メッセージID
	 * @param absolute
	 *            無条件出力フラグ
	 * @return writeSubsystemOPCResultCodeList OPC書込結果コードリスト
	 */
	private List<Integer> writeMessageTag(SqlSession session, String msgId, boolean absolute) {
		// tagNoとlcodeをマッピングしたグローバル変数を取得
		Map<String, String> tagNoToLcodeMap = TagUtil.getTagNoToLcodeMap();
		// 書き込み結果コードを格納する変数を初期化
		List<Integer> writeSubsystemOPCResultCodeList = new ArrayList<Integer>();
		// DBからメッセージタグ情報を取得するMapのListを初期化
		List<CmmMessageTag> cmmMessageTagList = new ArrayList<CmmMessageTag>();
		// DBからメッセージタグ情報を取得
		try {
			CmmMessageTagExample example = new CmmMessageTagExample();
			example.createCriteria().andMsgIdEqualTo(msgId);
			cmmMessageTagList = CmmMessageTagDao.select(session, example);
		} catch (Exception e) {
			String[] param = { msgId + FAILER_GETDEF_TEXT };
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
		}
		// メッセージタグ情報検索結果の件数を確認する
		if (0 == cmmMessageTagList.size()) {
			// 検索結果0件ならばOPCタグ書き込み結果に「0（正常終了）」をセット
			writeSubsystemOPCResultCodeList.add(ConstUtil.LOEX_API_SUCCESS);
		} else {
			// 検索結果1件以上ならば全てのメッセージタグ情報をOPCタグに書込む
			TagDataManager tagDataManager = new TagDataManager();
			boolean alarmExistencs = false;
			List<TagValue> tagValueList = new ArrayList<TagValue>();
			TagValue tagValue;
			for (CmmMessageTag cmmMessageTag : cmmMessageTagList) {
				// 無条件出力フラグがtrueでなければ発報済チェック
				TagData tagData = new TagData();
				try {
					tagData = tagDataManager.readCoreTagData(tagNoToLcodeMap.get(cmmMessageTag.getTagNo()));
				} catch (LoopOnExException e) {
					String[] param = { msgId + "警報状態取得失敗" };
					OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
				}
				if ((cmmMessageTag.getTagVal()).equals(tagData.getTagValue())) {
					alarmExistencs = true;
				}
				// 取得したメッセージタグ情報をLoopOnExAPIのパラメータとして送るListに詰替え
				tagValue = new TagValue();
				tagValue.setTagItemName(tagNoToLcodeMap.get(cmmMessageTag.getTagNo()));// タグNO
				tagValue.setValue(cmmMessageTag.getTagVal().toString());// タグ値
				tagValueList.add(tagValue);
			}
			// OPCタグ書込(LoopOnExAPI)
			// ステータス変動が無い場合は出力しない
			if (alarmExistencs && !absolute) {
				writeSubsystemOPCResultCodeList.add(NO_CHANGE_STAT);
			} else {
				// 自身が主系の場合のみDDCに出力
				if (ConstUtil.MASTER_STAT_MAIN == (SystemUtil.getMasterStat(session).getMasterStatOneself())) {
					try {
						// LoopOnExAPI
						writeSubsystemOPCResultCodeList = tagDataManager
								.writeSubsystemTagData(ConstUtil.SUBSYSTEM_ID_DDCOPC, tagValueList);
					} catch (Exception e) {
						// API実行で例外となった場合は「-9（例外終了）」をリターン
						writeSubsystemOPCResultCodeList.add(ConstUtil.LOEX_API_EXCEPTION);
					}
				} else {
					writeSubsystemOPCResultCodeList.add(ConstUtil.LOEX_API_SUCCESS);
				}
			}
		}
		// OPCタグ書込み結果をmainにリターン
		return writeSubsystemOPCResultCodeList;
	}

	/**
	 * メッセージデータ情報書込処理
	 *
	 * @param session SqlSession
	 * @param cmmMessageDef
	 *            メッセージ定義情報
	 */
	private void putMessage(SqlSession session, CmmMessageDef cmmMessageDef) {

		// CMT_MESSAGEにinsertするrecordをインスタンス
		CmtMessage record = new CmtMessage();

		// DBから取得したメッセージ定義のレコードをメッセージ情報テーブルにinsertするレコードに詰替える
		record.setMsgId(cmmMessageDef.getMsgId());
		record.setMsgCat(cmmMessageDef.getMsgCat());
		record.setMsgKind(cmmMessageDef.getMsgKind());
		record.setMsgText(cmmMessageDef.getMsgText());
		record.setLastUpdUser(new Object() {
		}.getClass().getEnclosingMethod().getName());
		// メッセージ情報テーブルにメッセージ追加
		try {
			CmtMessageDao.insert(session, record);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			String[] param = { cmmMessageDef.getMsgId() + FAILER_PUTMSG_TEXT };
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw (e);
		}
	}
}
