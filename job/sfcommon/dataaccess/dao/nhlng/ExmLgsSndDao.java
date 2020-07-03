package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * ExmLgsSndDao LGS送信マスタDAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.ExmLgsSnd;
import job.sfcommon.dataaccess.entity.nhlng.ExmLgsSndExample;
import job.sfcommon.dataaccess.mapper.nhlng.ExmLgsSndMapper;

/** LGS送信マスタDAO */
public class ExmLgsSndDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CONFNO_COLUMN_NAME = COLUMNS.CONF_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 設定NO */
		CONF_NO,
		/** 書込タグNO */
		WRITE_TAG_NO,
		/** 読込タグNO */
		READ_TAG_NO;
	}

	static {
		TABLE_NAME = "ExmLgsSnd";
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
	private ExmLgsSndDao() {
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
	public static long count(final SqlSession session, final ExmLgsSndExample example) {
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<ExmLgsSnd> LGS送信マスタ
	 */
	public static List<ExmLgsSnd> select(final SqlSession session, final ExmLgsSndExample example) {
		// ORDER BY clause
		example.setOrderByClause(CONFNO_COLUMN_NAME);

		// Select.
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		List<ExmLgsSnd> result = mapper.selectByExample(example);
		return result;
	}
}
