package job.sfcommon.dataaccess.dao.nhlng;

import java.util.Date;
import java.util.List;
import java.util.Objects;



import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHour;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHourExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtCloseHourMapper;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtCloseHourDao NH時締データDAO
 *
 * @author D.Suzuki
 */

public class CmtCloseHourDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.CLOSE_DTIME.toString();

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 締め日時 */
		CLOSE_DTIME,
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_DATA,
		/** 品質コード */
		QLTY_CD,
		/** 収集日時 */
		COLL_DTIME,;
	}

	/** テーブル名 */
	public static final String TABLE_NAME;

	static {
		TABLE_NAME = "CmtCloseHour";
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
	private CmtCloseHourDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmtCloseHourExample example) {
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<CmtCloseHour> selectByTagNoListBetweenDate(final SqlSession session,
			final List<String> tagNoList, Date fromDate, Date toDate) {

		CmtCloseHourExample example = new CmtCloseHourExample();
		example.createCriteria().andTagNoIn(tagNoList);

		if(Objects.isNull(fromDate)){
			example.addCriteria().andCloseDtimeLessThanOrEqualTo(toDate);
		} else if(Objects.isNull(toDate)){
			example.addCriteria().andCloseDtimeGreaterThanOrEqualTo(fromDate);
		}else{
			example.addCriteria().andCloseDtimeBetween(fromDate, toDate);
		}

		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<CmtCloseHour> selectBetweenDate(final SqlSession session, Date fromDate, Date toDate) {

		CmtCloseHourExample example = new CmtCloseHourExample();
		example.createCriteria().andCloseDtimeBetween(fromDate, toDate);
		return select(session, example);
	}

	public static List<CmtCloseHour> select(final SqlSession session, final CmtCloseHourExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		List<CmtCloseHour> result = mapper.selectByExample(example);
		return result;
	}

	public static List<CmtCloseHour> ExSelect(final SqlSession session,
			final CmtCloseHourExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		List<CmtCloseHour> result = mapper.selectByExtendedExample(example);
		return result;
	}

	public static int insert(final SqlSession session, final List<CmtCloseHour> dataList) {
		// Validate.
		for (CmtCloseHour data : dataList) {
			Validator.requireNonNull(data, "data");
			Date closeDtime = data.getCloseDtime();
			String tagNo = data.getTagNo();
			Validator.requireNonNull(closeDtime, "closeDtime");
			Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");
		}

		// Insert.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.insert(dataList);
	}

	public static int updateByPrimaryKey(final SqlSession session, final CmtCloseHour data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		Date closeDtime = data.getCloseDtime();
		String tagNo = data.getTagNo();
		Validator.requireNonNull(closeDtime, "closeDtime");
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Update.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.updateByPrimaryKeySelective(data);
	}

	public static int insertOrUpdate(final SqlSession session, final List<CmtCloseHour> dataList) {
		// Validate.
		for (CmtCloseHour data : dataList) {
			Validator.requireNonNull(data, "data");
			Date closeDtime = data.getCloseDtime();
			String tagNo = data.getTagNo();
			Validator.requireNonNull(closeDtime, "closeDtime");
			Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");
		}

		// Update.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.insertOrUpdate(dataList);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final Date closeDtime,final String tagNo) {
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.deleteByPrimaryKey(closeDtime, tagNo);
	}
}
