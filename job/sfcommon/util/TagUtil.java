package job.sfcommon.util;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.dao.nhlng.CmmTagMasterVDao;
import job.sfcommon.dataaccess.dao.nhlng.CmtTagValDao;
import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterV;
import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterVExample;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagVal;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagValExample;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.function.outputlogs.OutPutLogs;

/** タグマスタ関連ユーティリティ共通クラス */
@Dependent
public class TagUtil {

	/** ログカテゴリ*/
	private static final String LOG_CAT = ConstUtil.LOG_COMMON;

	/**
	 * tagNoとlcode読み替え用マッピンググローバル変数
	 */
	private static Map<String, String> tagNoToLcodeMap;

	/**
	 * lcodeとtagNo読み替え用マッピンググローバル変数
	 */
	private static Map<String, String> lcodeToTagNoMap;

	/**
	 * 複数tagNoによるNHタグマスタテーブル検索結果を返す<br>
	 * @param session SQLセッション
	 * @param tagNoList タグNoリスト
	 * @return Map<String, CmmTagMasterV>
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, CmmTagMasterV> selectCmmTagMaster(SqlSession session, final List<String> tagNoList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		Map<String, CmmTagMasterV> resultMap = new HashMap();

		List<CmmTagMasterV> cmmTagMasterVList = new ArrayList();
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		example.createCriteria().andTagNoIn(tagNoList);
		if(Objects.nonNull(tagNoList)){
			try{
				cmmTagMasterVList = CmmTagMasterVDao.select(session, example);
			}catch(Exception e){
				OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
				throw new RuntimeException(e);
			}
		}
		for(CmmTagMasterV cmmTagMaster : cmmTagMasterVList){
			resultMap.put(cmmTagMaster.getTagNo(), cmmTagMaster);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);

		return resultMap;
	}

	/**
	 * 論理名によるNHタグマスタテーブル検索結果を返す<br>
	 * @param session SQLセッション
	 * @param logicNameList タグ論理名リスト
	 * @return Map<String[], List<CmmTagMasterV>>
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String[], List<CmmTagMasterV>> selectCmtTagMasterByLogicalName(SqlSession session, final List<String[]> logicNameList)
			throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		Map<String[],List<CmmTagMasterV>> resultMap = new HashMap();

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
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);

		return resultMap;
	}

	/**
	 * 複数tagNoによるタグデータテーブル検索結果を返す<br>
	 * @param session SQLセッション
	 * @param tagNoList タグNoリスト
	 * @return List<CmtTagVal>
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<CmtTagVal> selectCmtTagVal(SqlSession session, final List<String> tagNoList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		List<CmtTagVal> cmtTagValLsit = new ArrayList();

		if(Objects.nonNull(tagNoList)){
			try{
				cmtTagValLsit = CmtTagValDao.selectByTagNoList(session, tagNoList);
			}catch(Exception e){
				OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
				throw new RuntimeException(e);
			}
		}

		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);

		return cmtTagValLsit;
	}

	/**
	 * 複数タグ論理名によるタグデータテーブル検索結果を返す<br>
	 * @param session SQLセッション
	 * @param logicNameList タグ論理名リスト
	 * @return Map<String[],List<CmtTagVal>>
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String[],List<CmtTagVal>> selectCmtTagValByLogicalName(SqlSession session, final List<String[]> logicNameList)
			throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		Map<String[],List<CmtTagVal>> resultMap = new HashMap();

		try{
			for(String[] logicName : logicNameList){
				if(4==logicName.length){
					CmtTagValExample example = new CmtTagValExample();
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
					List<CmtTagVal> cmtTagValLsit = CmtTagValDao.exSelect(session, example);
					resultMap.put(logicName, cmtTagValLsit);
				}
			}
		}catch(Exception e){
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);

		return resultMap;
	}

	/**
	 * 複数タグ論理名によるタグデータテーブル検索結果を返す<br>
	 * @param session SQLセッション
	 * @param logicNameList タグ論理名リスト
	 * @return Map<String[],List<CmtTagVal>>
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String[],List<CmtTagVal>> selectConstValByLogicalName(SqlSession session, final List<String[]> logicNameList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		Map<String[],List<CmtTagVal>> resultMap = new HashMap();

		try{
			for(String[] logicName : logicNameList){
				if(4==logicName.length){
					CmtTagValExample example = new CmtTagValExample();
					if(Objects.nonNull(logicName[0])){
						example.createCriteria().andTagKindEqualTo(1).andTagLogicName1EqualTo(logicName[0]);
					}
					if(Objects.nonNull(logicName[1])){
						example.createCriteria().andTagKindEqualTo(1).andTagLogicName2EqualTo(logicName[1]);
					}
					if(Objects.nonNull(logicName[2])){
						example.createCriteria().andTagKindEqualTo(1).andTagLogicName3EqualTo(logicName[2]);
					}
					if(Objects.nonNull(logicName[3])){
						example.createCriteria().andTagKindEqualTo(1).andTagLogicName4EqualTo(logicName[3]);
					}
					List<CmtTagVal> cmtTagValLsit = CmtTagValDao.exSelect(session, example);
					resultMap.put(logicName, cmtTagValLsit);
				}
			}
		}catch(Exception e){
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);

		return resultMap;
	}

	/**
	 * tagNoからtagNoをlcodeに変換したlcodeリストの作成<br>
	 * @param tagNoList tagNoリスト
	 * @return List<String> lcodeリスト
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> tagNoToLcode(List<String> tagNoList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		List<String> lcodeList = new ArrayList();
		for(String tagNo : tagNoList){
			lcodeList.add(tagNoToLcodeMap.get(tagNo));
			tagNo = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return lcodeList;
	}

	/**
	 * tagNoからtagNo,lcode逆変換用にkeyとvalueを入替えたMapの作成<br>
	 * @param tagNoList tagNoリスト
	 * @return Map<String, String> Map<key:lcode value:tagNo>
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, String> lcodeToTagNo(List<String> tagNoList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		Map<String, String> resultMap = new HashMap();
		for(String tagNo : tagNoList){
			resultMap.put(tagNoToLcodeMap.get(tagNo), tagNo);
			tagNo = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return resultMap;
	}

	/**
	 * lcodeとtagNo読み替え用マッピングのグローバル変数作成処理
	 * @throws RuntimeException RuntimeException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void makeTagNoToLcodeMap() throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		tagNoToLcodeMap = new HashMap();
		lcodeToTagNoMap = new HashMap();

		List<CmmTagMasterV> cmmTagMasterVAll = new ArrayList();

		CmmTagMasterVExample example = new CmmTagMasterVExample();

		SqlSession session = SelectDb.dbAcssece("nhlng");
		try{
			cmmTagMasterVAll = CmmTagMasterVDao.select(session, example);
		}catch(Exception e){
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		for(CmmTagMasterV cmmTagMasterV : cmmTagMasterVAll){
			tagNoToLcodeMap.put(cmmTagMasterV.getTagNo(), cmmTagMasterV.getLcode());
			lcodeToTagNoMap.put((cmmTagMasterV.getLcode()),cmmTagMasterV.getTagNo());
		}
		cmmTagMasterVAll = null;
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
	}

	/**
	 * tagNoとlcode読み替え用マップ取得
	 * @return tagNoToLcodeMap
	 */
	public static Map<String, String> getTagNoToLcodeMap(){
		return tagNoToLcodeMap;
	}

	/**
	 * lcodeとtagNo読み替え用マップ取得
	 * @return lcodeToTagNoMap
	 */
	public static Map<String, String> getLcodeToTagNoMap(){
		return lcodeToTagNoMap;
	}
}