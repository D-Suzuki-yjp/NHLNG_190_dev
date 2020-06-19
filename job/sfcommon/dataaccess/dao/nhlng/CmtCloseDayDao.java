package job.sfcommon.dataaccess.dao.nhlng;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtClose;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDay;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDayExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtCloseDayMapper;
import job.sfcommon.dto.CmtCloseDayDto;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtCloseDayDao NH日締データDAO
 * @author D.Suzuki
 */

public class CmtCloseDayDao{

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.CLOSE_DTIME.toString();

	/** カラム名を表す変数 */
	public static enum COLUMNS{
		/** 締め日時 */
		CLOSE_DTIME,
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_DATA,
		/** 品質コード */
		QLTY_CD,
		/** 収集日時 */
		COLL_DTIME;
	}

	/** テーブル名 */
	public static final String TABLE_NAME;

	static {
		TABLE_NAME = "CmtCloseDay";
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
	private CmtCloseDayDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmtCloseDayExample example) {
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmtCloseDay> select(final SqlSession session, final CmtCloseDayExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		List<CmtCloseDay> result = mapper.selectByExample(example);
		return result;
	}

	public static List<CmtCloseDay> ExSelect(final SqlSession session,
			final CmtCloseDayExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		List<CmtCloseDay> result = mapper.selectByExtendedExample(example);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static List<CmtClose> selectClacData(final SqlSession session, final List<String> dayTagNoList0, final List<String> dayTagNoList1, List<String> dayTagNoList4, final Date targetDate) {
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.selectClacData(dayTagNoList0, dayTagNoList1, dayTagNoList4, targetDate);
	}

	public static int insert(final SqlSession session, final CmtCloseDay data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		Date closeDtime = data.getCloseDtime();
		String tagNo = data.getTagNo();
		Validator.requireNonNull(closeDtime, "closeDtime");
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Insert.
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByExampleSelective(final SqlSession session, final List<CmtCloseDay> dataList, final CmtCloseDayExample example) {
		// Update.
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		int results = 0;
		for(CmtCloseDay record:dataList){
			example.addCriteria().andCloseDtimeEqualTo(record.getCloseDtime()).andTagNoEqualTo(record.getTagNo());
			int result = mapper.updateByExampleSelective(record, example);
			results = results + result;
		}
		return results;
	}

	public static int insertOrUpdate(final SqlSession session, final List<CmtCloseDay> dataList) {
		// Validate.
		for (CmtCloseDay data : dataList) {
			Validator.requireNonNull(data, "data");
			Date closeDtime = data.getCloseDtime();
			String tagNo = data.getTagNo();
			Validator.requireNonNull(closeDtime, "closeDtime");
			Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");
		}

		// Update.
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.insertOrUpdate(dataList);
	}

	public static int insertOrUpdateByLogicalName(final SqlSession session, final List<CmtCloseDayDto> dataList, final String lastUpdUser) {
		// Validate.
		for (CmtCloseDayDto data : dataList) {
			Validator.requireNonNull(data, "data");
			Date closeDtime = data.getCloseDtime();
			String tagLogicName1 = data.getTagLogicName1();
			Validator.requireNonNull(closeDtime, "closeDtime");
			Validator.requireNonNull(tagLogicName1, "tagLogicName1");
		}

		// Update.
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.insertOrUpdateByLogicalName(dataList, lastUpdUser);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final Date closeDtime,final String tagNo) {
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.deleteByPrimaryKey(closeDtime, tagNo);
	}

	public static int dayClose(final SqlSession session, final Date targetDate,final String className) {
		CmtCloseDayMapper mapper = session.getMapper(CmtCloseDayMapper.class);
		return mapper.dayClose(targetDate, className);
	}

}
