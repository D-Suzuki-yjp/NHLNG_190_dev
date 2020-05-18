package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtCloseMon;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtCloseMonExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtCloseMonMapper;


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

	public static enum EX_COLUMNS {
		/** 締め日時 */
		CLOSE_DTIME,
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_DATA,
		/** 品質コード */
		QLTY_CD,
		/** 収集日時 */
		COLL_DTIME,
		/** Lコード */
		LCODE,
		/** コメント */
		COMMENT1,
		/** 工業単位計算機 */
		UNIT_COMPUTER,
		/** DP */
		DP,
		/** 上限値 */
		UPPER_VALUE,
		/** 下限値 */
		LOWER_VALUE,
		/** タグ種別 */
		TAG_KIND,
		/** IO種別 */
		IO_KIND,
		/** 定数区分 */
		CONST_DIV,
		/** 帳票区分 */
		REPO_DIV,
		/** 帳票計算区分 */
		REPO_CALC_DIV,
		/** 公開DB分データ送信フラグ */
		ODB_MIN_SND_FLAG,
		/** 公開DB時締データ送信フラグ */
		ODB_HOUR_SND_FLAG,
		/** 公開DB日締データ送信フラグ */
		ODB_DAY_SND_FLAG,
		/** 積算丸めフラグ */
		ROUND_FLAG,
		/** 残値タグNO */
		REM_TAG_NO,
		/** 画面更新フラグ */
		SCR_UPDATE_FLAG,
		/** タグ論理名1 */
		TAG_LOGIC_NAME1,
		/** タグ論理名2 */
		TAG_LOGIC_NAME2,
		/** タグ論理名3 */
		TAG_LOGIC_NAME3,
		/** タグ論理名4 */
		TAG_LOGIC_NAME4,
		/** 瞬時データフラグ */
		CURRENT_DATA_FLAG,
		/** 時締データフラグ */
		HOURLY_DATA_FLAG,
		/** 日締データフラグ */
		DAILY_DATA_FLAG,
		/** 月締データフラグ */
		MONTHLY_DATA_FLAG,
		/** 締切種別 */
		CLOSE_KIND;
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

	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmtCloseMon> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmtCloseMon object = new CmtCloseMon();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtCloseMon object) {
		if (map == null) { return; }
		object.setCloseDtime((Date) map.get(COLUMNS.CLOSE_DTIME));
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		if (map.get(COLUMNS.TAG_DATA) != null) {
			object.setTagData((String) map.get(COLUMNS.TAG_DATA));
		}
		if (map.get(COLUMNS.QLTY_CD) != null) {
			object.setQltyCd((int) map.get(COLUMNS.QLTY_CD));
		}
		if (map.get(COLUMNS.COLL_DTIME) != null) {
			object.setCollDtime((Date) map.get(COLUMNS.COLL_DTIME));
		}
	}

	private static void convertExMapToModel(final Map<EX_COLUMNS, Object> map, final CmtCloseMon object) {
		if (map == null) {
			return;
		}
		object.setCloseDtime((Date) map.get(COLUMNS.CLOSE_DTIME));
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		if (map.get(EX_COLUMNS.TAG_DATA) != null) {
			object.setTagData((String) map.get(COLUMNS.TAG_DATA));
		}
		if (map.get(EX_COLUMNS.QLTY_CD) != null) {
			object.setQltyCd((int) map.get(COLUMNS.QLTY_CD));
		}
		if (map.get(EX_COLUMNS.COLL_DTIME) != null) {
			object.setCollDtime((Date) map.get(COLUMNS.COLL_DTIME));
		}
		if (map.get(EX_COLUMNS.LCODE) != null) {
			object.setLcode((String) map.get(EX_COLUMNS.LCODE));
		}
		if (map.get(EX_COLUMNS.COMMENT1) != null) {
			object.setComment1((String) map.get(EX_COLUMNS.COMMENT1));
		}
		if (map.get(EX_COLUMNS.UNIT_COMPUTER) != null) {
			object.setUnitComputer((String) map.get(EX_COLUMNS.UNIT_COMPUTER));
		}
		if (map.get(EX_COLUMNS.DP) != null) {
			object.setDp((Integer) map.get(EX_COLUMNS.DP));
		}
		if (map.get(EX_COLUMNS.UPPER_VALUE) != null) {
			object.setUpperValue((Float) map.get(EX_COLUMNS.UPPER_VALUE));
		}
		if (map.get(EX_COLUMNS.LOWER_VALUE) != null) {
			object.setLowerValue((Float) map.get(EX_COLUMNS.LOWER_VALUE));
		}
		if (map.get(EX_COLUMNS.TAG_KIND) != null) {
			object.setTagKind((Integer) map.get(EX_COLUMNS.TAG_KIND));
		}
		if (map.get(EX_COLUMNS.IO_KIND) != null) {
			object.setIoKind((String) map.get(EX_COLUMNS.IO_KIND));
		}
		if (map.get(EX_COLUMNS.CONST_DIV) != null) {
			object.setConstDiv((String) map.get(EX_COLUMNS.CONST_DIV));
		}
		if (map.get(EX_COLUMNS.REPO_DIV) != null) {
			object.setRepoDiv((String) map.get(EX_COLUMNS.REPO_DIV));
		}
		if (map.get(EX_COLUMNS.REPO_CALC_DIV) != null) {
			object.setRepoCalcDiv((String) map.get(EX_COLUMNS.REPO_CALC_DIV));
		}
		if (map.get(EX_COLUMNS.ODB_MIN_SND_FLAG) != null) {
			object.setOdbMinSndFlag((Integer) map.get(EX_COLUMNS.ODB_MIN_SND_FLAG));
		}
		if (map.get(EX_COLUMNS.ODB_HOUR_SND_FLAG) != null) {
			object.setOdbHourSndFlag((Integer) map.get(EX_COLUMNS.ODB_HOUR_SND_FLAG));
		}
		if (map.get(EX_COLUMNS.ODB_DAY_SND_FLAG) != null) {
			object.setOdbDaySndFlag((Integer) map.get(EX_COLUMNS.ODB_DAY_SND_FLAG));
		}
		if (map.get(EX_COLUMNS.ROUND_FLAG) != null) {
			object.setRoundFlag((Integer) map.get(EX_COLUMNS.ROUND_FLAG));
		}
		if (map.get(EX_COLUMNS.REM_TAG_NO) != null) {
			object.setRemTagNo((String) map.get(EX_COLUMNS.REM_TAG_NO));
		}
		if (map.get(EX_COLUMNS.SCR_UPDATE_FLAG) != null) {
			object.setScrUpdateFlag((Integer) map.get(EX_COLUMNS.SCR_UPDATE_FLAG));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME1) != null) {
			object.setTagLogicName1((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME1));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME2) != null) {
			object.setTagLogicName2((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME2));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME3) != null) {
			object.setTagLogicName3((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME3));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME4) != null) {
			object.setTagLogicName4((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME4));
		}
		if (map.get(EX_COLUMNS.CURRENT_DATA_FLAG) != null) {
			object.setCurrentDataFlag((String) map.get(EX_COLUMNS.CURRENT_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.HOURLY_DATA_FLAG) != null) {
			object.setHourlyDataFlag((String) map.get(EX_COLUMNS.HOURLY_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.DAILY_DATA_FLAG) != null) {
			object.setDailyDataFlag((String) map.get(EX_COLUMNS.DAILY_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.MONTHLY_DATA_FLAG) != null) {
			object.setMonthlyDataFlag((String) map.get(EX_COLUMNS.MONTHLY_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.CLOSE_KIND) != null) {
			object.setCloseKind((String) map.get(EX_COLUMNS.CLOSE_KIND));
		}
	}

	private static void convertModelListToMapList(final List<CmtCloseMon> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtCloseMon object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtCloseMon object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getCloseDtime() != null) {
			data.put(COLUMNS.CLOSE_DTIME, object.getCloseDtime());
		}
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getTagData() != null) {
			data.put(COLUMNS.TAG_DATA, object.getTagData());
		}
		if (object.getQltyCd() != null) {
			data.put(COLUMNS.QLTY_CD, object.getQltyCd());
		}
		if (object.getCollDtime() != null) {
			data.put(COLUMNS.COLL_DTIME, object.getCollDtime());
		}
	}

	private static void convertModelListToExMapList(final List<CmtCloseMon> objectList,
			final List<Map<EX_COLUMNS, Object>> mapList) {
		if (objectList == null) {
			return;
		}
		for (CmtCloseMon object : objectList) {
			Map<EX_COLUMNS, Object> map = new HashMap<>();
			convertModelToExMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToExMap(final CmtCloseMon object, final Map<EX_COLUMNS, Object> data) {
		if (object == null) {
			return;
		}
		if (object.getCloseDtime() != null) {
			data.put(EX_COLUMNS.CLOSE_DTIME, object.getCloseDtime());
		}
		if (object.getTagNo() != null) {
			data.put(EX_COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getTagData() != null) {
			data.put(EX_COLUMNS.TAG_DATA, object.getTagData());
		}
		if (object.getQltyCd() != null) {
			data.put(EX_COLUMNS.QLTY_CD, object.getQltyCd());
		}
		if (object.getCollDtime() != null) {
			data.put(EX_COLUMNS.COLL_DTIME, object.getCollDtime());
		}
		if (object.getLcode() != null) {
			data.put(EX_COLUMNS.LCODE, object.getLcode());
		}
		if (object.getComment1() != null) {
			data.put(EX_COLUMNS.COMMENT1, object.getComment1());
		}
		if (object.getUnitComputer() != null) {
			data.put(EX_COLUMNS.UNIT_COMPUTER, object.getUnitComputer());
		}
		if (object.getDp() != null) {
			data.put(EX_COLUMNS.DP, object.getDp());
		}
		if (object.getUpperValue() != null) {
			data.put(EX_COLUMNS.UPPER_VALUE, object.getUpperValue());
		}
		if (object.getLowerValue() != null) {
			data.put(EX_COLUMNS.LOWER_VALUE, object.getLowerValue());
		}
		if (object.getTagKind() != null) {
			data.put(EX_COLUMNS.TAG_KIND, object.getTagKind());
		}
		if (object.getIoKind() != null) {
			data.put(EX_COLUMNS.IO_KIND, object.getIoKind());
		}
		if (object.getConstDiv() != null) {
			data.put(EX_COLUMNS.CONST_DIV, object.getConstDiv());
		}
		if (object.getRepoDiv() != null) {
			data.put(EX_COLUMNS.REPO_DIV, object.getRepoDiv());
		}
		if (object.getRepoCalcDiv() != null) {
			data.put(EX_COLUMNS.REPO_CALC_DIV, object.getRepoCalcDiv());
		}
		if (object.getOdbMinSndFlag() != null) {
			data.put(EX_COLUMNS.ODB_MIN_SND_FLAG, object.getOdbMinSndFlag());
		}
		if (object.getOdbHourSndFlag() != null) {
			data.put(EX_COLUMNS.ODB_HOUR_SND_FLAG, object.getOdbHourSndFlag());
		}
		if (object.getOdbDaySndFlag() != null) {
			data.put(EX_COLUMNS.ODB_DAY_SND_FLAG, object.getOdbDaySndFlag());
		}
		if (object.getRoundFlag() != null) {
			data.put(EX_COLUMNS.ROUND_FLAG, object.getRoundFlag());
		}
		if (object.getRemTagNo() != null) {
			data.put(EX_COLUMNS.REM_TAG_NO, object.getRemTagNo());
		}
		if (object.getScrUpdateFlag() != null) {
			data.put(EX_COLUMNS.SCR_UPDATE_FLAG, object.getScrUpdateFlag());
		}
		if (object.getTagLogicName1() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME1, object.getTagLogicName1());
		}
		if (object.getTagLogicName2() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME3, object.getTagLogicName2());
		}
		if (object.getTagLogicName3() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME3, object.getTagLogicName3());
		}
		if (object.getTagLogicName4() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME4, object.getTagLogicName4());
		}
		if (object.getCurrentDataFlag() != null) {
			data.put(EX_COLUMNS.CURRENT_DATA_FLAG, object.getCurrentDataFlag());
		}
		if (object.getHourlyDataFlag() != null) {
			data.put(EX_COLUMNS.HOURLY_DATA_FLAG, object.getHourlyDataFlag());
		}
		if (object.getDailyDataFlag() != null) {
			data.put(EX_COLUMNS.DAILY_DATA_FLAG, object.getDailyDataFlag());
		}
		if (object.getMonthlyDataFlag() != null) {
			data.put(EX_COLUMNS.MONTHLY_DATA_FLAG, object.getMonthlyDataFlag());
		}
		if (object.getCloseKind() != null) {
			data.put(EX_COLUMNS.CLOSE_KIND, object.getCloseKind());
		}
	}

	private static CmtCloseMonExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtCloseMonExample example = new CmtCloseMonExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.CLOSE_DTIME);
			String value2 = (String) searchingOption.get(COLUMNS.TAG_NO);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andCloseDtimeEqualTo(value1).andTagNoEqualTo(value2);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andCloseDtimeEqualTo(value1);
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andTagNoEqualTo(value2);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
		}
		return example;
	}


	private static CmtCloseMonExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtCloseMonExample example = new CmtCloseMonExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.CLOSE_DTIME);
			String value2 = (String) searchingOption.get(COLUMNS.TAG_NO);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andCloseDtimeEqualTo(value1).andTagNoLike(value2);
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andCloseDtimeEqualTo(value1);
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andTagNoLike(value2);
			}
		}
		return example;
	}

	private static CmtCloseMonExample selectFromToMatchingExample(final Map<COLUMNS, Object> searchingOption, final Date toDate) {
		// WHERE clause
		CmtCloseMonExample example = new CmtCloseMonExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.CLOSE_DTIME);
			String value2 = (String) searchingOption.get(COLUMNS.TAG_NO);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andCloseDtimeBetween(value1, toDate).andTagNoLike(value2);
			}
			else if (Objects.isNull(value2)) {
				example.createCriteria().andCloseDtimeBetween(value1, toDate);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countCmtCloseMon(final SqlSession session, final Map<COLUMNS, Object> searchingOption, Date toDate) {

		long result = 0;
		if(Objects.isNull(toDate)){
			result = countEqualToMatching(session, searchingOption);
		} else {
			result = countFromToMatching(session, searchingOption, toDate);
		}
		return result;
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtCloseMonExample example = new CmtCloseMonExample();
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	private static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtCloseMonExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static long countFromToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption, Date toDate) {
		CmtCloseMonExample example = selectFromToMatchingExample(searchingOption, toDate);
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtCloseMonExample example) {
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectCmtCloseMon(final SqlSession session, final Map<COLUMNS, Object> searchingOption, Date toDate) {

		List<Map<COLUMNS, Object>> result = new ArrayList();
		if(Objects.isNull(toDate)){
			result = selectEqualToMatching(session, searchingOption);
		} else {
			result = selectFromToMatching(session, searchingOption, toDate);
		}
		return result;
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtCloseMonExample example = new CmtCloseMonExample();
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static List<Map<COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtCloseMonExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static List<Map<COLUMNS, Object>> selectFromToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption, Date toDate) {
		CmtCloseMonExample example = selectFromToMatchingExample(searchingOption, toDate);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectByTagNoListBetweenDate(final SqlSession session, final List<String> tagNoList, Date fromDate, Date toDate){
		CmtCloseMonExample example = new CmtCloseMonExample();

		if(Objects.isNull(fromDate)){
			example.addCriteria().andCloseDtimeLessThanOrEqualTo(toDate);
		} else if(Objects.isNull(toDate)){
			example.addCriteria().andCloseDtimeGreaterThanOrEqualTo(fromDate);
		}else{
			example.addCriteria().andCloseDtimeBetween(fromDate, toDate);
		}

		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmtCloseMonExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		List<CmtCloseMon> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	private static List<Map<CmtCloseMonDao.EX_COLUMNS, Object>> ExSelect(final SqlSession session,
			final CmtCloseMonExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		List<CmtCloseMon> recordList = mapper.selectByExtendedExample(example);

		// Convert and return.
		List<Map<EX_COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToExMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String closeDtime = (String) data.get(COLUMNS.CLOSE_DTIME);
		String tagNo = (String) data.get(COLUMNS.TAG_NO);
		Validator.requireNonNullAndNonEmpty(closeDtime, "closeDtime");
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Make data.
		CmtCloseMon record = new CmtCloseMon();
		convertMapToModel(data, record);

		// Insert.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String closeDtime = (String) data.get(COLUMNS.CLOSE_DTIME);
		String tagNo = (String) data.get(COLUMNS.TAG_NO);
		Validator.requireNonNullAndNonEmpty(closeDtime, "closeDtime");
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Make data.
		CmtCloseMon record = new CmtCloseMon();
		convertMapToModel(data, record);

		// Update.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int insertOrUpdate(final SqlSession session, final List<Map<COLUMNS, Object>> dataList) {
		// Validate.
		for (Map<COLUMNS, Object> data : dataList) {
			Validator.requireNonNull(data, "data");
			Date closeDtime = (Date) data.get(COLUMNS.CLOSE_DTIME);
			String tagNo = (String) data.get(COLUMNS.TAG_NO);
			Validator.requireNonNull(closeDtime, "closeDtime");
			Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");
		}

		// Make data.
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<CmtCloseMon> recordList = new ArrayList();
		try {
			convertMapListToModelList(dataList, recordList);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// Update.
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.insertOrUpdate(recordList);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final Date closeDtime,final String tagNo) {
		CmtCloseMonMapper mapper = session.getMapper(CmtCloseMonMapper.class);
		return mapper.deleteByPrimaryKey(closeDtime, tagNo);
	}

}