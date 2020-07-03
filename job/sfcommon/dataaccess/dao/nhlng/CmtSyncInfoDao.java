package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtSyncInfoDao 等値化情報DAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtSyncInfo;
import job.sfcommon.dataaccess.entity.nhlng.CmtSyncInfoExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtSyncInfoMapper;

/** 等値化情報DAO */
public class CmtSyncInfoDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TABLENAME_COLUMN_NAME = COLUMNS.TARGET_TABLE.toString();

	/** テーブル名 */
	public static final String TARGET_TABLE;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** テーブル名 */
		TARGET_TABLE,
		/** 最終等値化日時 */
		LAST_SYNC_DTIME,
		/** 等値化種別 */
		SYNC_KND,
		/** 更新日時カラム */
		UPD_DTIME_COL;
	}

	static {
		TARGET_TABLE = "CmtSyncInfo";
	}

	/*--------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/

	/*--------------------------------------------
	|         C O N S T R U C T O R S           |
	============================================*/

	/**
	 * Prevent instantiation.
	 */
	private CmtSyncInfoDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final CmtSyncInfoExample example) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmtSyncInfo> 等値化情報
	 */
	public static List<CmtSyncInfo> select(final SqlSession session, final CmtSyncInfoExample example) {
		// ORDER BY clause
		example.setOrderByClause(TABLENAME_COLUMN_NAME);

		// Select.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		List<CmtSyncInfo> result = mapper.selectByExample(example);
		return result;
	}

	/**
	 * @param session SqlSession
	 * @param data 等値化情報
	 * @return int 件数
	 */
	public static int insert(final SqlSession session, final CmtSyncInfo data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String targetTable = data.getTargetTable();
		Validator.requireNonNullAndNonEmpty(targetTable, "targetTable");

		// Insert.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.insertSelective(data);
	}

	/**
	 * @param session SqlSession
	 * @param dataList 等値化情報
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int updateByExampleSelective(final SqlSession session, final List<CmtSyncInfo> dataList, final CmtSyncInfoExample example) {

		// Update.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		int results = 0;
		for(CmtSyncInfo record:dataList){
			example.addCriteria().andTargetTableEqualTo(record.getTargetTable());
			int result = mapper.updateByExampleSelective(record, example);
			results = results + result;
		}
		return results;
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int delete(final SqlSession session, final CmtSyncInfoExample example) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.deleteByExample(example);
	}

}
