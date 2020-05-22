package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtSyncInfo;
import job.sfcommon.dataaccess.entity.nhlng.CmtSyncInfoExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtSyncInfoMapper;


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
@Dependent
public class CmtSyncInfoDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TABLENAME_COLUMN_NAME = COLUMNS.TABLE_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** テーブル名 */
		TABLE_NAME,
		/** 最終等値化日時 */
		LAST_SYNC_DTIME,
		/** 等値化種別 */
		SYNC_KND,
		/** 更新日時カラム */
		UPD_DTIME_COL;
	}

	static {
		TABLE_NAME = "CmtSyncInfo";
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

	public static long count(final SqlSession session, final CmtSyncInfoExample example) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmtSyncInfo> select(final SqlSession session, final CmtSyncInfoExample example) {
		// ORDER BY clause
		example.setOrderByClause(TABLENAME_COLUMN_NAME);

		// Select.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		List<CmtSyncInfo> result = mapper.selectByExample(example);
		return result;
	}

	public static int insert(final SqlSession session, final CmtSyncInfo data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tableName = data.getTableName();
		Validator.requireNonNullAndNonEmpty(tableName, "tableName");

		// Insert.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByPrimaryKey(final SqlSession session, final CmtSyncInfo data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tableName = data.getTableName();
		Validator.requireNonNullAndNonEmpty(tableName, "tableName");

		// Update.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.updateByPrimaryKeySelective(data);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String tableName) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.deleteByPrimaryKey(tableName);
	}

}
