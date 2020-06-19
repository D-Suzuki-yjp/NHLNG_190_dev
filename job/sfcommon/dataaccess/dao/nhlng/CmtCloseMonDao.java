package job.sfcommon.dataaccess.dao.nhlng;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtClose;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMon;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMonExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtCloseMonMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtCloseMonDao NH月締データDAO
 * @author D.Suzuki
 */

public class CmtCloseMonDao{

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
		COLL_DTIME,;
	}

	/** テーブル名 */
	public static final String TABLE_NAME;

	static {
		TABLE_NAME = "CmtCloseMon";
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
	private CmtCloseMonDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static long count(final SqlSession session, final CmtCloseMonExample example) {
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<CmtCloseMon> selectByTagNoListBetweenDate(final SqlSession session, final List<String> tagNoList, Date fromDate, Date toDate){

		CmtCloseMonExample example = new CmtCloseMonExample();
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

	public static List<CmtCloseMon> select(final SqlSession session, final CmtCloseMonExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		List<CmtCloseMon> result = mapper.selectByExample(example);
		return result;
	}

	public static List<CmtCloseMon> ExSelect(final SqlSession session,
			final CmtCloseMonExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		List<CmtCloseMon> result = mapper.selectByExtendedExample(example);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static List<CmtClose> selectClacData(final SqlSession session, final List<String> monTagNoList1, final List<String> monTagNoList2, List<String> monTagNoList5, final Date targetDate) {
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.selectClacData(monTagNoList1, monTagNoList2, monTagNoList5,targetDate);
	}

	public static int insert(final SqlSession session, final CmtCloseMon data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		Date closeDtime = data.getCloseDtime();
		String tagNo = data.getTagNo();
		Validator.requireNonNull(closeDtime, "closeDtime");
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Insert.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByExampleSelective(final SqlSession session, final List<CmtCloseMon> dataList, final CmtCloseMonExample example) {
		// Update.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		int results = 0;
		for(CmtCloseMon record:dataList){
			example.addCriteria().andCloseDtimeEqualTo(record.getCloseDtime()).andTagNoEqualTo(record.getTagNo());
			int result = mapper.updateByExampleSelective(record, example);
			results = results + result;
		}
		return results;
	}

	public static int insertOrUpdate(final SqlSession session, final List<CmtCloseMon> dataList) {
		// Validate.
		for (CmtCloseMon data : dataList) {
			Validator.requireNonNull(data, "data");
			Date closeDtime = data.getCloseDtime();
			String tagNo = data.getTagNo();
			Validator.requireNonNull(closeDtime, "closeDtime");
			Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");
		}

		// Update.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.insertOrUpdate(dataList);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final Date closeDtime,final String tagNo) {
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.deleteByPrimaryKey(closeDtime, tagNo);
	}

}
