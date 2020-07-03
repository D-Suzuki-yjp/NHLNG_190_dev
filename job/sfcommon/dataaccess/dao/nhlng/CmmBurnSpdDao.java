package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmBurnSpdDao 燃焼速度マスタDAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmBurnSpd;
import job.sfcommon.dataaccess.entity.nhlng.CmmBurnSpdExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmBurnSpdMapper;

/** 燃焼速度マスタDAO */
public class CmmBurnSpdDao {

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
		/** 燃焼速度 */
		BURN_SPD,
		/** 係数1 */
		COEF1,
		/** 係数2 */
		COEF2;
	}

	static {
		TABLE_NAME = "CmmBurnSpd";
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
	private CmmBurnSpdDao() {
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
	public static long count(final SqlSession session, final CmmBurnSpdExample example) {
		CmmBurnSpdMapper mapper = session.getMapper(CmmBurnSpdMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmmBurnSpd> 燃焼速度マスタリスト
	 */
	public static List<CmmBurnSpd> select(final SqlSession session, final CmmBurnSpdExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMPNT_COLUMN_NAME);

		// Select.
		CmmBurnSpdMapper mapper = session.getMapper(CmmBurnSpdMapper.class);
		List<CmmBurnSpd> result = mapper.selectByExample(example);
		return result;
	}
}
