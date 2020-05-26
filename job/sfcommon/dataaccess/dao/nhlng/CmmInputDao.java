package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmInput;
import job.sfcommon.dataaccess.entity.nhlng.CmmInputExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmInputMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmInputDao 入力データマスタDAO
 * @author D.Suzuki
 */

public class CmmInputDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String REPORTKIND_COLUMN_NAME = COLUMNS.TAG_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** タグNO */
		TAG_NO,
		/** 締切種別 */
		HISTORY_KIND,
		/** シーケンスNO */
		SEQ_NO,
		/** 入力タイプ */
		INPUT_TYPE,
		/** 入力タグ  */
		INPUT_TAG_NO;
	}

	static {
		TABLE_NAME = "CmmInput";
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
	private CmmInputDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmmInputExample example) {
		CmmInputMapper mapper = session.getMapper(CmmInputMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmInput> select(final SqlSession session, final CmmInputExample example) {
		// ORDER BY clause
		example.setOrderByClause(REPORTKIND_COLUMN_NAME);

		// Select.
		CmmInputMapper mapper = session.getMapper(CmmInputMapper.class);
		List<CmmInput> result = mapper.selectByExample(example);
		return result;
	}
}
