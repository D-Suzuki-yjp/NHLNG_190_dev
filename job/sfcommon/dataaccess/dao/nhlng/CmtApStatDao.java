package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtApStat;
import job.sfcommon.dataaccess.entity.nhlng.CmtApStatExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtApStatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtApStatDao アプリケーション状態DAO
 * @author D.Suzuki
 */

public class CmtApStatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String APNAME_COLUMN_NAME = COLUMNS.AP_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** SCCサーバ名 */
		SCC_SERVER_NAME,
		/** AP名 */
		AP_NAME,
		/** AP状態 */
		AP_STAT,
		/** AP状態フラグ */
		AP_STAT_FLG,
		/** AP状態更新日時 */
		AP_STAT_UPD_DTIME,
		/** 最終更新者 */
		LAST_UPD_USER,
		/** 最終更新日時 */
		LAST_UPD_DTIME;
	}

	static {
		TABLE_NAME = "CmtApStat";
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
	private CmtApStatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmtApStatExample example) {
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmtApStat> select(final SqlSession session, final CmtApStatExample example) {
		// ORDER BY clause
		example.setOrderByClause(APNAME_COLUMN_NAME);

		// Select.
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		List<CmtApStat> result = mapper.selectByExample(example);
		return result;
	}

	public static int insert(final SqlSession session, final CmtApStat data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = data.getSccServerName();
		String apName = data.getApName();
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");
		Validator.requireNonNullAndNonEmpty(apName, "apName");

		// Insert.
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByExampleSelective(final SqlSession session, final List<CmtApStat> dataList, final CmtApStatExample example) {

		// Update.
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		int results = 0;
		for(CmtApStat record:dataList){
			example.addCriteria().andSccServerNameEqualTo(record.getSccServerName()).andApNameEqualTo(record.getApName());
			int result = mapper.updateByExampleSelective(record, example);
			results = results + result;
		}
		return results;
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String sccServerName, final String apName) {
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.deleteByPrimaryKey(sccServerName, apName);
	}

}
