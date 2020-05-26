package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmCalc;
import job.sfcommon.dataaccess.entity.nhlng.CmmCalcExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmCalcMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmCalcDao 計算マスタDAO
 * @author D.Suzuki
 */

public class CmmCalcDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String REPORTKIND_COLUMN_NAME = COLUMNS.HISTORY_KIND.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 帳票区分 */
		HISTORY_KIND,
		/** 自動フラグ */
		TAG_NO,
		/** 印刷時刻 */
		CALC_KIND,
		/** 係数2 */
		CALC_INFO,
		/** 係数2 */
		CALC_PRIORITY;
	}

	static {
		TABLE_NAME = "CmmCalc";
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
	private CmmCalcDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmmCalcExample example) {
		CmmCalcMapper mapper = session.getMapper(CmmCalcMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmCalc> select(final SqlSession session, final CmmCalcExample example) {
		// ORDER BY clause
		example.setOrderByClause(REPORTKIND_COLUMN_NAME);

		// Select.
		CmmCalcMapper mapper = session.getMapper(CmmCalcMapper.class);
		List<CmmCalc> result = mapper.selectByExample(example);
		return result;
	}
}
