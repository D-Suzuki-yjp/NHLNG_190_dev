package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import javax.enterprise.context.Dependent;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmAutoPrint;
import job.sfcommon.dataaccess.entity.nhlng.CmmAutoPrintExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmAutoPrintMapper;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmAutoPrintDao 自動印刷マスタDAO
 *
 * @author D.Suzuki
 */
@Dependent
public class CmmAutoPrintDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String REPORTKIND_COLUMN_NAME = COLUMNS.REPORT_KIND.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 帳票区分 */
		REPORT_KIND,
		/** 自動フラグ */
		AUTO_FLAG,
		/** 印刷時刻 */
		PRIN_TTIME;
	}

	static {
		TABLE_NAME = "CmmAutoPrint";
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
	private CmmAutoPrintDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmmAutoPrintExample example) {
		CmmAutoPrintMapper mapper = session.getMapper(CmmAutoPrintMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmAutoPrint> select(final SqlSession session, final CmmAutoPrintExample example) {
		// ORDER BY clause
		if (StringUtils.isEmpty(example.getOrderByClause())) {
			example.setOrderByClause(REPORTKIND_COLUMN_NAME);
		}
		// Select.
		CmmAutoPrintMapper mapper = session.getMapper(CmmAutoPrintMapper.class);
		List<CmmAutoPrint> result = mapper.selectByExample(example);
		return result;
	}
}
