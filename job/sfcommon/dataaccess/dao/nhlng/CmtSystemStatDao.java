package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtSystemStatDao システム状態DAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtSystemStat;
import job.sfcommon.dataaccess.entity.nhlng.CmtSystemStatExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtSystemStatMapper;

/** システム状態DAO */
public class CmtSystemStatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SCCSERVERNAME_COLUMN_NAME = COLUMNS.SCC_SERVER_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** SCCサーバ名 */
		SCC_SERVER_NAME,
		/** 主従状態 */
		MASTER_STAT,
		/** 処理実行状態 */
		PROC_EXEC_STAT,
		/** 稼働状態 */
		OPE_STAT,
		/** 稼働状態フラグ */
		OPE_STAT_FLAG,
		/** 稼働状態更新日時 */
		OPE_STAT_DTIME,
		/** AP状態 */
		AP_STAT,
		/** OPCサーバ状態 */
		OPC_SERVER_STAT;
	}

	static {
		TABLE_NAME = "CmtSystemStat";
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
	private CmtSystemStatDao() {
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
	public static long count(final SqlSession session, final CmtSystemStatExample example) {
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmtSystemStat> システム状態
	 */
	public static List<CmtSystemStat> select(final SqlSession session, final CmtSystemStatExample example) {
		// ORDER BY clause
		example.setOrderByClause(SCCSERVERNAME_COLUMN_NAME);

		// Select.
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		List<CmtSystemStat> result = mapper.selectByExample(example);
		return result;
	}

	/**
	 * @param session SqlSession
	 * @param data システム状態
	 * @return int 件数
	 */
	public static int insert(final SqlSession session, final CmtSystemStat data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = data.getSccServerName();
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");

		// Insert.
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.insertSelective(data);
	}

	/**
	 * @param session SqlSession
	 * @param dataList システム状態
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int updateByExampleSelective(final SqlSession session, final List<CmtSystemStat> dataList, final CmtSystemStatExample example) {

		// Update.
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		int results = 0;
		for(CmtSystemStat record:dataList){
			example.addCriteria().andSccServerNameEqualTo(record.getSccServerName());
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
	public static int delete(final SqlSession session, CmtSystemStatExample example) {
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.deleteByExample(example);
	}
}
