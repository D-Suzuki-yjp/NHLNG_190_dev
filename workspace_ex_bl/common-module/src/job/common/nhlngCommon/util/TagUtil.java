package job.common.nhlngCommon.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.dao.nhlng.CmmTagMasterVDao;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtTagValDao;
import job.common.nhlngCommon.function.outPutLogs.OutPutLogs;
import job.common.uiCommon.dataAccess.session.selectDb;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/1 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * TagUtil タグマスタ関連ユーティリティ共通クラス
 * @author D.Suzuki
 */
public class TagUtil {

	/**
	 * tagNoとlcode読み替え用マッピンググローバル変数
	 */
	public static Map<String, String> tagNoToLcodeMap;

	/**
	 * 複数tagNoによるNHタグマスタテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmmTagMasterVDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectCmmTagMaster(final List<String> tagNoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmmTagMasterVList = new ArrayList();

		if(Objects.nonNull(tagNoList)){
			SqlSession session = selectDb.dbAcssece("nhlng");
			try{
				cmmTagMasterVList = CmmTagMasterVDao.selectByTagNoList(session, tagNoList);
			}catch(RuntimeException e){
				throw(e);
			}finally{
				session.close();
			}
		}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmmTagMasterVList;
	}

	/**
	 * 論理名によるNHタグマスタテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectCmtTagMasterByLogicalName(final List<List<String>> logicNameList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmtTagValLsit = new ArrayList();

			SqlSession session = selectDb.dbAcssece("nhlng");
			try{
				cmtTagValLsit = CmmTagMasterVDao.selectBylogicNameList(session, logicNameList);
			}catch(RuntimeException e){
				throw(e);
			} finally {
				session.close();
			}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtTagValLsit;
	}

	/**
	 * 帳票区分によるNHタグマスタテーブル検索結果を返す<br>
	 * @param repDivList 帳票区分リスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectCmtTagMasterForPrint(final List<String> repDivList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmtTagValLsit = new ArrayList();

			SqlSession session = selectDb.dbAcssece("nhlng");
			try{
				cmtTagValLsit = CmmTagMasterVDao.selectCmtTagMasterForPrint(session, repDivList);
			}catch(RuntimeException e){
				throw(e);
			} finally {
				session.close();
			}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtTagValLsit;
	}

	/**
	 * 複数tagNoによるタグデータテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectCmtTagVal(final List<String> tagNoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<Map<CmtTagValDao.COLUMNS, Object>> cmtTagValLsit = new ArrayList();

		if(Objects.nonNull(tagNoList)){
			SqlSession session = selectDb.dbAcssece("nhlng");
			try{
				cmtTagValLsit = CmtTagValDao.selectByTagNoList(session, tagNoList);
			}catch(RuntimeException e){
				throw(e);
			} finally {
				session.close();
			}
		}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtTagValLsit;
	}

	/**
	 * TODO 作る
	 * 複数タグ論理名によるタグデータテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectCmtTagValByLogicalName(final List<List<String>> logicNameList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<Map<CmtTagValDao.COLUMNS, Object>> cmtTagValLsit = new ArrayList();

			SqlSession session = selectDb.dbAcssece("nhlng");
			try{
				cmtTagValLsit = CmtTagValDao.selectBylogicNameList(session, logicNameList);
			}catch(RuntimeException e){
				throw(e);
			} finally {
				session.close();
			}


		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtTagValLsit;
	}

	/**
	 * tagNoをlcodeに変換したlcodeリストの作成<br>
	 * @return List<String> lcodeリスト
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> tagNoToLcode(List<String> tagNoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<String> lcodeList = new ArrayList();
		for(String tagNo : tagNoList){
			lcodeList.add(tagNoToLcodeMap.get(tagNo));
			tagNo = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return lcodeList;
	}

	/**
	 * tagNo,lcode逆変換用にkeyとvalueを入替えたMapの作成<br>
	 * @return Map<String, String>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, String> lcodeToTagNo(List<String> tagNoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		Map<String, String> lcodeToTagNoMap = new HashMap();
		for(String tagNo : tagNoList){
			lcodeToTagNoMap.put(tagNoToLcodeMap.get(tagNo), tagNo);
			tagNo = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return lcodeToTagNoMap;
	}

	/**
	 * 警告:使用禁止<br>
	 * tagNoとlcode読み替え用マッピングのグローバル変数作成処理
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void getTagNoToLcodeMap() {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		tagNoToLcodeMap = new HashMap();

		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmmTagMasterVAll = new ArrayList();

		SqlSession session = selectDb.dbAcssece("nhlng");
		try{
			cmmTagMasterVAll = CmmTagMasterVDao.selectAllRecord(session);
		}catch(RuntimeException e){
			throw(e);
		}finally{
			session.close();
		}
		for(Map<CmmTagMasterVDao.COLUMNS, Object> cmmTagMasterV : cmmTagMasterVAll){
				tagNoToLcodeMap.put(((String)cmmTagMasterV.get(CmmTagMasterVDao.COLUMNS.TAG_NO)),(String) cmmTagMasterV.get(CmmTagMasterVDao.COLUMNS.LCODE));
		}
		cmmTagMasterVAll = null;
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
	}
}