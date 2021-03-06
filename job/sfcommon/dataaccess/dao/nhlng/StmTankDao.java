package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.StmTank;
import job.sfcommon.dataaccess.entity.nhlng.StmTankExample;
import job.sfcommon.dataaccess.mapper.nhlng.StmTankMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * StmTankDao タンクマスタDAO
 * @author D.Suzuki
 */

public class StmTankDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TANKNO_COLUMN_NAME = COLUMNS.TANK_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 設定NO */
		TANK_NO,
		/** 書込タグNO */
		LVL_GAUGE_FROM,
		/** 読込タグNO */
		LVL_GAUGE_TO,
		/** 書込タグNO */
		COEF1,
		/** 書込タグNO */
		COEF2;
	}

	static {
		TABLE_NAME = "StmTank";
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
	private StmTankDao() {
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
	public static long count(final SqlSession session, final StmTankExample example) {
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<StmTank> タンクマスタ
	 */
	public static List<StmTank> select(final SqlSession session, final StmTankExample example) {
		// ORDER BY clause
		example.setOrderByClause(TANKNO_COLUMN_NAME);

		// Select.
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		List<StmTank> result = mapper.selectByExample(example);
		return result;
	}
}
