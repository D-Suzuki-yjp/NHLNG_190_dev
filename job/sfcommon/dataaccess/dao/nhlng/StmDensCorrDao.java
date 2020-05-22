package job.sfcommon.dataaccess.dao.nhlng;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.StmDensCorr;
import job.sfcommon.dataaccess.entity.nhlng.StmDensCorrExample;
import job.sfcommon.dataaccess.mapper.nhlng.StmDensCorrMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * StmDensCorrDao 液密度補正量マスタDAO
 * @author D.Suzuki
 */
@Dependent
public class StmDensCorrDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String DENSFROM_COLUMN_NAME = COLUMNS.DENS_FROM.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 液密度FROM */
		DENS_FROM,
		/** 液密度TO */
		DENS_TO,
		/** 補正量（正） */
		CORR_QTY_MAIN,
		/** 補正量（副） */
		CORR_QTY_SUB;
	}

	static {
		TABLE_NAME = "StmDensCorr";
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
	private StmDensCorrDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final StmDensCorrExample example) {
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.countByExample(example);
	}

	public static List<StmDensCorr> select(final SqlSession session, final StmDensCorrExample example) {
		// ORDER BY clause
		example.setOrderByClause(DENSFROM_COLUMN_NAME);

		// Select.
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		List<StmDensCorr> result = mapper.selectByExample(example);
		return result;
	}

	/**
	 * メッセージデータinsert
	 * @param session  SQLセッション
	 * @param data  メッセージデータ
	 * @return int insert件数
	 */
	public static int insert(final SqlSession session, final StmDensCorr data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		BigDecimal densFrom = data.getDensFrom();
		Validator.requireNonNull(densFrom, "densFrom");

		// Insert.
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByPrimaryKey(final SqlSession session, final StmDensCorr data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		BigDecimal densFrom = data.getDensFrom();
		Validator.requireNonNull(densFrom, "densFrom");

		// Update.
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.updateByPrimaryKeySelective(data);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final BigDecimal densFrom) {
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.deleteByPrimaryKey(densFrom);
	}

}
