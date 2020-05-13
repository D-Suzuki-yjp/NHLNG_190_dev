package job.common.nhlngCommon.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.dao.nhlng.CmmTagMasterVDao;
import job.common.uiCommon.dataAccess.session.selectDb;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/1 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * TagMasterUtil タグマスタ関連ユーティリティ共通クラス
 * @author D.Suzuki
 */
public class TagMasterUtil {

	/**
	 * tagNoとlcode読み替え用マッピンググローバル変数
	 */
	Map<String, String> tagNoToLcodeMap;

	/**
	 * 複数tagNoによるNHタグマスタテーブル検索結果を返す
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmmTagMasterVDao.COLUMNS, Object>>
	 */
	public List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectByTagNoList(final List<String> tagNoList) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmmTagMasterVList = new ArrayList();

		if(Objects.nonNull(tagNoList)){
			SqlSession session = selectDb.dbAcssece("nhlng");
			try{
				cmmTagMasterVList = CmmTagMasterVDao.selectByTagNoList(session, tagNoList);
			}catch(Exception e){
				/**TODO 例外処理*/
				System.out.println(e.getMessage());
			}finally{
				session.close();
			}
		}

		return cmmTagMasterVList;
	}

	/**
	 * tagNoとlcode読み替え用マッピングのグローバル変数取得
	 * @return Map<String, String> tagNoToLcodeMap
	 */
	public Map<String, String> callTagNoToLcodeMap() {
		return tagNoToLcodeMap;
	}

	/**
	 * 警告:使用禁止
	 * tagNoとlcode読み替え用マッピングのグローバル変数作成処理
	 * @param tagNoList タグNoリスト
	 * @return List<Map<CmmTagMasterVDao.COLUMNS, Object>>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getTagNoToLcodeMap() {

		tagNoToLcodeMap = new HashMap();

		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmmTagMasterVAll = new ArrayList();

		SqlSession session = selectDb.dbAcssece("nhlng");
		try{
			cmmTagMasterVAll = CmmTagMasterVDao.selectAllRecord(session);
		}catch(Exception e){
			/**TODO 例外処理*/
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		for(Map<CmmTagMasterVDao.COLUMNS, Object> cmmTagMasterV : cmmTagMasterVAll){
			tagNoToLcodeMap.put(((String)cmmTagMasterV.get(CmmTagMasterVDao.COLUMNS.TAG_NO)),(String) cmmTagMasterV.get(CmmTagMasterVDao.COLUMNS.LCODE));
		}
		cmmTagMasterVAll = null;
	}

}
