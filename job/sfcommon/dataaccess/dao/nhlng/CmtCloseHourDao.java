package job.sfcommon.dataaccess.dao.nhlng;
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

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtClose;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHour;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHourExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtCloseHourMapper;

/** NH時締データDAO */
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

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final CmtCloseHourExample example) {
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param fromDate から日時
	 * @param toDate 日時まで
	 * @return List<CmtCloseHour> 時締データリスト
	 */
	public static List<CmtCloseHour> selectBetweenDate(final SqlSession session, Date fromDate, Date toDate) {

		CmtCloseHourExample example = new CmtCloseHourExample();
		example.createCriteria().andCloseDtimeBetween(fromDate, toDate);
		return select(session, example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞込条件
	 * @return List<CmtCloseHour> 時締データリスト
	 */
	public static List<CmtCloseHour> select(final SqlSession session, final CmtCloseHourExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		List<CmtCloseHour> result = mapper.selectByExample(example);
		return result;
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmtCloseHour> 時締データリスト
	 */
	public static List<CmtCloseHour> exSelect(final SqlSession session,
			final CmtCloseHourExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		List<CmtCloseHour> result = mapper.selectByExtendedExample(example);
		return result;
	}

	/**
	 * @param session SqlSession
	 * @param hourTagNoList0 入力タイプ0のtagNo
	 * @param hourTagNoList3 入力タイプ3のtagNo
	 * @param targetDate 対象日時
	 * @return List<CmtClose> 時締データリスト
	 */
	@SuppressWarnings("rawtypes")
	public static List<CmtClose> selectClacData(final SqlSession session, final List<String> hourTagNoList0, final List<String> hourTagNoList3, final Date targetDate) {
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.selectClacData(hourTagNoList0, hourTagNoList3, targetDate);
	}

	/**
	 * @param session SqlSession
	 * @param dataList 時締データ
	 * @return int 件数
	 */
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

	/**
	 * @param session SqlSession
	 * @param dataList 時締データリスト
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int updateByExampleSelective(final SqlSession session, final List<CmtCloseHour> dataList, final CmtCloseHourExample example) {
		// Update.
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		int results = 0;
		for(CmtCloseHour record:dataList){
			example.addCriteria().andCloseDtimeEqualTo(record.getCloseDtime()).andTagNoEqualTo(record.getTagNo());
			int result = mapper.updateByExampleSelective(record, example);
			results = results + result;
		}
		return results;
	}

	/**
	 * @param session SqlSession
	 * @param dataList NH日締データリスト
	 * @return int 件数
	 */
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

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int delete(final SqlSession session, final CmtCloseHourExample example) {
		CmtCloseHourMapper mapper = session.getMapper(CmtCloseHourMapper.class);
		return mapper.deleteByExample(example);
	}
}
