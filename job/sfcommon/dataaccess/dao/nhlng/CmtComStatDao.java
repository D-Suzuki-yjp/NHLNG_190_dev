package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtComStat;
import job.sfcommon.dataaccess.entity.nhlng.CmtComStatExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtComStatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtComStatDao 通信状態DAO
 * @author D.Suzuki
 */

public class CmtComStatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String COMHOSTNAME_COLUMN_NAME = COLUMNS.COM_HOST_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** SCCサーバ名 */
		SCC_SERVER_NAME,
		/** 通信ホスト名 */
		COM_HOST_NAME,
		/** 通信状態  */
		COM_STAT,
		/** 通信状態更新日時 */
		COM_STATUPD_DTIME,
		/** 監視対象フラグ  */
		WATCH_TARGET_FLAG,;
	}

	static {
		TABLE_NAME = "CmtComStat";
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
	private CmtComStatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmtComStatExample example) {
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmtComStat> select(final SqlSession session, final CmtComStatExample example) {
		// ORDER BY clause
		example.setOrderByClause(COMHOSTNAME_COLUMN_NAME);

		// Select.
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		List<CmtComStat> result = mapper.selectByExample(example);
		return result;
	}

	public static int insert(final SqlSession session, final CmtComStat data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = data.getSccServerName();
		String apName = data.getComHostName();
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");
		Validator.requireNonNullAndNonEmpty(apName, "apName");

		// Insert.
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByExampleSelective(final SqlSession session, final List<CmtComStat> dataList, final CmtComStatExample example) {

		// Update.
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		int results = 0;
		for(CmtComStat record:dataList){
			example.addCriteria().andSccServerNameEqualTo(record.getSccServerName()).andComHostNameEqualTo(record.getComHostName());
			int result = mapper.updateByExampleSelective(record, example);
			results = results + result;
		}
		return results;
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String sccServerName, final String comHostName) {
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.deleteByPrimaryKey(sccServerName, comHostName);
	}

}
