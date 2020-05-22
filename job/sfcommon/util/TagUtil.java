package job.sfcommon.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.dao.nhlng.CmmTagMasterVDao;
import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterV;
import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterVExample;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagVal;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.function.outputlogs.OutPutLogs;

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
@Dependent
public class TagUtil {

	/**
	 * tagNoとlcode読み替え用マッピンググローバル変数
	 */
	public static Map<String, String> tagNoToLcodeMap;

	/**
	 * lcodeとtagNo読み替え用マッピンググローバル変数
	 */
	public static Map<String, String> lcodeToTagNoMap;

	/**
	 * TODO スケルトン
	 * 複数tagNoによるNHタグマスタテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmmTagMasterVDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, CmmTagMasterV> selectCmmTagMaster(final List<String> tagNoList) throws RuntimeException{
/*
		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		Map<String, CmmTagMasterV> resultMap = new HashMap();

		List<CmmTagMasterV> cmmTagMasterVList = new ArrayList();
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		example.createCriteria().andTagNoIn(tagNoList);
		if(Objects.nonNull(tagNoList)){
			SqlSession session = SelectDb.dbAcssece("nhlng");
			try{
				cmmTagMasterVList = CmmTagMasterVDao.select(session, example);
			}catch(Exception e){
				throw(e);
			}finally{
				session.close();
			}
		}
		for(CmmTagMasterV cmmTagMaster : cmmTagMasterVList){
			resultMap.put(cmmTagMaster.getTagNo(), cmmTagMaster);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);]
*/
		return null;
	}

	/**
	 * TODO スケルトン
	 * 論理名によるNHタグマスタテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String[], List<CmmTagMasterV>> selectCmtTagMasterByLogicalName(final List<String[]> logicNameList) throws RuntimeException{
/*
		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		Map<String[],List<CmmTagMasterV>> resultMap = new HashMap();

		SqlSession session = SelectDb.dbAcssece("nhlng");
		try{
			for(String[] logicName : logicNameList){
				if(4==logicName.length){
					CmmTagMasterVExample example = new CmmTagMasterVExample();
					example.createCriteria();
					if(Objects.nonNull(logicName[0])){
						example.addCriteria().andTagLogicName1EqualTo(logicName[0]);
					}
					if(Objects.nonNull(logicName[1])){
						example.addCriteria().andTagLogicName2EqualTo(logicName[1]);
					}
					if(Objects.nonNull(logicName[2])){
						example.addCriteria().andTagLogicName3EqualTo(logicName[2]);
					}
					if(Objects.nonNull(logicName[3])){
						example.addCriteria().andTagLogicName4EqualTo(logicName[3]);
					}
					List<CmmTagMasterV> cmtTagValLsit = CmmTagMasterVDao.select(session, example);
					resultMap.put(logicName, cmtTagValLsit);
				}
			}
		}catch(Exception e){
			throw(e);
		} finally {
			session.close();
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
*/
		return null;
	}

	/**
	 * 帳票区分によるNHタグマスタテーブル検索結果を返す<br>
	 * @param repDivList 帳票区分リスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	/*	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<CmmTagMasterV> selectCmtTagMasterForPrint(final List<String> repDivList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<CmmTagMasterV> cmtTagValLsit = new ArrayList();

			SqlSession session = SelectDb.dbAcssece("nhlng");
			try{
				cmtTagValLsit = CmmTagMasterVDao.selectCmtTagMasterForPrint(session, repDivList);
			}catch(Exception e){
				throw(new RuntimeException());
			} finally {
				session.close();
			}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtTagValLsit;
	}*/

	/**
	 * 複数tagNoによるタグデータテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<CmtTagVal> selectCmtTagVal(final List<String> tagNoList) throws RuntimeException{
/*
		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		List<CmtTagVal> cmtTagValLsit = new ArrayList();

		if(Objects.nonNull(tagNoList)){
			SqlSession session = SelectDb.dbAcssece("nhlng");
			try{
				cmtTagValLsit = CmtTagValDao.selectByTagNoList(session, tagNoList);
			}catch(Exception e){
				throw(e);
			} finally {
				session.close();
			}
		}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
*/
		return null;
	}

	/**
	 * 複数タグ論理名によるタグデータテーブル検索結果を返す<br>
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String[],List<CmtTagVal>> selectCmtTagValByLogicalName(final List<String[]> logicNameList) throws RuntimeException{
/*
		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		Map<String[],List<CmtTagVal>> resultMap = new HashMap();


		SqlSession session = SelectDb.dbAcssece("nhlng");
		try{
			for(String[] logicName : logicNameList){
				if(4==logicName.length){
					CmtTagValExample example = new CmtTagValExample();
					if(Objects.nonNull(logicName[0])){
						example.addCriteria().andTagLogicName1EqualTo(logicName[0]);
					}
					if(Objects.nonNull(logicName[1])){
						example.addCriteria().andTagLogicName2EqualTo(logicName[1]);
					}
					if(Objects.nonNull(logicName[2])){
						example.addCriteria().andTagLogicName3EqualTo(logicName[2]);
					}
					if(Objects.nonNull(logicName[3])){
						example.addCriteria().andTagLogicName4EqualTo(logicName[3]);
					}
					List<CmtTagVal> cmtTagValLsit = CmtTagValDao.ExSelect(session, example);
					resultMap.put(logicName, cmtTagValLsit);
				}
			}
		}catch(Exception e){
			throw(e);
		} finally {
			session.close();
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
*/
		return null;
	}

	/**
	 * tagNoからtagNoをlcodeに変換したlcodeリストの作成<br>
	 * @return List<String> lcodeリスト
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> tagNoToLcode(List<String> tagNoList) throws RuntimeException{

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
	 * tagNoからtagNo,lcode逆変換用にkeyとvalueを入替えたMapの作成<br>
	 * @return Map<String, String>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, String> lcodeToTagNo(List<String> tagNoList) throws RuntimeException{

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
	 * lcodeとtagNo読み替え用マッピングのグローバル変数作成処理
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void getTagNoToLcodeMap() throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		lcodeToTagNoMap = new HashMap();
		tagNoToLcodeMap = new HashMap();

		List<CmmTagMasterV> cmmTagMasterVAll = new ArrayList();

		CmmTagMasterVExample example = new CmmTagMasterVExample();

		SqlSession session = SelectDb.dbAcssece("nhlng");
		try{
			cmmTagMasterVAll = CmmTagMasterVDao.select(session, example);
		}catch(Exception e){
			throw(e);
		}finally{
			session.close();
		}
		for(CmmTagMasterV cmmTagMasterV : cmmTagMasterVAll){
			lcodeToTagNoMap.put((cmmTagMasterV.getLcode()),cmmTagMasterV.getTagNo());
			tagNoToLcodeMap.put(cmmTagMasterV.getTagNo(), cmmTagMasterV.getLcode());
		}
		cmmTagMasterVAll = null;
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
	}
}