package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmScreenDao 画面マスタDAO
 * @author D.Suzuki
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmScreen;
import job.sfcommon.dataaccess.entity.nhlng.CmmScreenExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmScreenMapper;

/** 画面マスタ */
public class CmmScreenDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SCREENID_COLUMN_NAME = COLUMNS.SCREEN_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** タグNO */
		TAG_NO,
		/** 画面ID */
		SCREEN_ID;
	}

	static {
		TABLE_NAME = "CmmScreen";
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
	private CmmScreenDao() {
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
	public static long count(final SqlSession session, final CmmScreenExample example) {
		CmmScreenMapper mapper = session.getMapper(CmmScreenMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmmScreen> 画面マスタ
	 */
	public static List<CmmScreen> select(final SqlSession session, final CmmScreenExample example) {
		// ORDER BY clause
		example.setOrderByClause(SCREENID_COLUMN_NAME);

		// Select.
		CmmScreenMapper mapper = session.getMapper(CmmScreenMapper.class);
		List<CmmScreen> result = mapper.selectByExample(example);
		return result;
	}
}
