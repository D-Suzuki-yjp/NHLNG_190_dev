package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmScreenName;
import job.sfcommon.dataaccess.entity.nhlng.CmmScreenNameExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmScreenNameMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmScreenNameDao 画面名マスタDAO
 * @author D.Suzuki
 */

public class CmmScreenNameDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SCREENID_COLUMN_NAME = COLUMNS.SCREEN_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 画面ID */
		SCREEN_ID,
		/** 画面名 */
		SCREEN_NAME;
	}

	static {
		TABLE_NAME = "CmmScreenName";
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
	private CmmScreenNameDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmmScreenNameExample example) {
		CmmScreenNameMapper mapper = session.getMapper(CmmScreenNameMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmScreenName> select(final SqlSession session, final CmmScreenNameExample example) {
		// ORDER BY clause
		example.setOrderByClause(SCREENID_COLUMN_NAME);

		// Select.
		CmmScreenNameMapper mapper = session.getMapper(CmmScreenNameMapper.class);
		List<CmmScreenName> result = mapper.selectByExample(example);
		return result;
	}
}
