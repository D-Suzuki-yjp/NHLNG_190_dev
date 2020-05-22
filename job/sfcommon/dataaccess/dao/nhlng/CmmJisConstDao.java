package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmJisConst;
import job.sfcommon.dataaccess.entity.nhlng.CmmJisConstExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmJisConstMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmJisConstDao JIS定数マスタDAO
 * @author D.Suzuki
 */
@Dependent
public class CmmJisConstDao {

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
		/** 分子量 */
		MOLWT,
		/** 圧縮係数 */
		COMPCOEF,
		/** 総発熱量 */
		HEAT_VAL;
	}

	static {
		TABLE_NAME = "CmmJisConst";
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
	private CmmJisConstDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmmJisConstExample example) {
		CmmJisConstMapper mapper = session.getMapper(CmmJisConstMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmJisConst> select(final SqlSession session, final CmmJisConstExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMPNT_COLUMN_NAME);

		// Select.
		CmmJisConstMapper mapper = session.getMapper(CmmJisConstMapper.class);
		List<CmmJisConst> result = mapper.selectByExample(example);
		return result;
	}
}
