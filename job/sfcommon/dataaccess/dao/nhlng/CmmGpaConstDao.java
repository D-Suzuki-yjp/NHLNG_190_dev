package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmGpaConstDao GPA定数マスタDAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmGpaConst;
import job.sfcommon.dataaccess.entity.nhlng.CmmGpaConstExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmGpaConstMapper;

/** GPA定数DAO */
public class CmmGpaConstDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CMPNT_COLUMN_NAME = COLUMNS.CMPNT.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 成分 */
		CMPNT,
		/** 総発熱量 */
		HEAT_VAL,
		/** 標準比重 */
		STD_SG,
		/** 標準密度 */
		NOR_DENS;
	}

	static {
		TABLE_NAME = "CmmGpaConst";
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
	private CmmGpaConstDao() {
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
	public static long count(final SqlSession session, final CmmGpaConstExample example) {
		CmmGpaConstMapper mapper = session.getMapper(CmmGpaConstMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmmGpaConst> GPA定数マスタリスト
	 */
	public static List<CmmGpaConst> select(final SqlSession session, final CmmGpaConstExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMPNT_COLUMN_NAME);

		// Select.
		CmmGpaConstMapper mapper = session.getMapper(CmmGpaConstMapper.class);
		List<CmmGpaConst> result = mapper.selectByExample(example);
		return result;
	}
}
