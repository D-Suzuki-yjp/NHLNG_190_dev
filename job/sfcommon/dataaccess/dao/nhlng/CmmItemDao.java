package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmItem;
import job.sfcommon.dataaccess.entity.nhlng.CmmItemExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmItemMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment1
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmItemDao 項目マスタDAO
 * @author D.Suzuki
 */

public class CmmItemDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String ID_COLUMN_NAME = COLUMNS.ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 種別 */
		KIND,
		/** ID */
		ID,
		/** 項目 */
		ITEM,
		/** コメント */
		COMMENT1;
	}

	static {
		TABLE_NAME = "CmmItem";
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
	private CmmItemDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmmItemExample example) {
		CmmItemMapper mapper = session.getMapper(CmmItemMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmItem> select(final SqlSession session, final CmmItemExample example) {
		// ORDER BY clause
		example.setOrderByClause(ID_COLUMN_NAME);

		// Select.
		CmmItemMapper mapper = session.getMapper(CmmItemMapper.class);
		List<CmmItem> result = mapper.selectByExample(example);
		return result;
	}
}
