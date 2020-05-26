package job.sfcommon.dataaccess.dao.looponexcore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.looponexcore.SlgHourHistory;
import job.sfcommon.dataaccess.entity.looponexcore.SlgHourHistoryExample;
import job.sfcommon.dataaccess.mapper.looponexcore.SlgHourHistoryMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SlgHourHistoryDao システム固有データDAO
 * @author D.Suzuki
 */

public class SlgHourHistoryDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.HISTORY_DATE.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 締め日時 */
		HISTORY_DATE,
		/** タグNO */
		LCODE,
		/** タグ値 */
		VALUE,
		/** 品質コード */
		QUALITY,
		/** 収集日時 */
		COLLECT_DATE;
	}

	static {
		TABLE_NAME = "SlgHourHistory";
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
	private SlgHourHistoryDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<SlgHourHistory> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			SlgHourHistory object = new SlgHourHistory();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}


	private static void convertMapToModel(final Map<COLUMNS, Object> map, final SlgHourHistory object) {
		if (map == null) { return; }
		object.setHistoryDate((Date) map.get(COLUMNS.HISTORY_DATE));
		object.setLcode((String) map.get(COLUMNS.LCODE));
		object.setValue((String) map.get(COLUMNS.VALUE));
		object.setQuality((int) map.get(COLUMNS.QUALITY));
		object.setCollectDate((Date) map.get(COLUMNS.COLLECT_DATE));
	}
	*/

	private static void convertModelListToMapList(final List<SlgHourHistory> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (SlgHourHistory object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final SlgHourHistory object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getHistoryDate() != null) {
			data.put(COLUMNS.HISTORY_DATE, object.getHistoryDate());
		}
		if (object.getLcode() != null) {
			data.put(COLUMNS.LCODE, object.getLcode());
		}
		if (object.getValue() != null) {
			data.put(COLUMNS.VALUE, object.getValue());
		}
		if (object.getQuality() != null) {
			data.put(COLUMNS.QUALITY, object.getQuality());
		}
		if (object.getCollectDate() != null) {
			data.put(COLUMNS.COLLECT_DATE, object.getCollectDate());
		}
	}

	private static SlgHourHistoryExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SlgHourHistoryExample example = new SlgHourHistoryExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.HISTORY_DATE);
			String value2 = (String) searchingOption.get(COLUMNS.LCODE);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andHistoryDateEqualTo(value1).andLcodeEqualTo(value2);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andHistoryDateEqualTo(value1);
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andLcodeEqualTo(value2);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
		}
		return example;
	}


	private static SlgHourHistoryExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SlgHourHistoryExample example = new SlgHourHistoryExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.HISTORY_DATE);
			String value2 = (String) searchingOption.get(COLUMNS.LCODE);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andHistoryDateEqualTo(value1).andLcodeLike(value2);
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andHistoryDateEqualTo(value1);
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andLcodeLike(value2);
			}
		}
		return example;
	}

	private static SlgHourHistoryExample selectFromToMatchingExample(final Map<COLUMNS, Object> searchingOption, final Date toDate) {
		// WHERE clause
		SlgHourHistoryExample example = new SlgHourHistoryExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.HISTORY_DATE);
			String value2 = (String) searchingOption.get(COLUMNS.LCODE);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andHistoryDateBetween(value1, toDate).andLcodeEqualTo(value2);
			}
			else if (Objects.isNull(value2)) {
				example.createCriteria().andHistoryDateBetween(value1, toDate);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countSlgHourHistory(final SqlSession session, final Map<SlgHourHistoryDao.COLUMNS, Object> searchingOption, Date toDate) {

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
		SlgHourHistoryExample example = new SlgHourHistoryExample();
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	private static long countEqualToMatching(final SqlSession session, final Map<SlgHourHistoryDao.COLUMNS, Object> searchingOption) {
		SlgHourHistoryExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static long countFromToMatching(final SqlSession session, final Map<SlgHourHistoryDao.COLUMNS, Object> searchingOption, Date toDate) {
		SlgHourHistoryExample example = selectFromToMatchingExample(searchingOption, toDate);
		return count(session, example);
	}

	private static long count(final SqlSession session, final SlgHourHistoryExample example) {
		SlgHourHistoryMapper mapper = session.getMapper(SlgHourHistoryMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static List<Map<SlgHourHistoryDao.COLUMNS, Object>> selectSlgHourHistory(final SqlSession session, final Map<SlgHourHistoryDao.COLUMNS, Object> searchingOption, Date toDate) {

		List<Map<SlgHourHistoryDao.COLUMNS, Object>> result = new ArrayList();
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
	public static List<Map<SlgHourHistoryDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		SlgHourHistoryExample example = new SlgHourHistoryExample();
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static List<Map<SlgHourHistoryDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<SlgHourHistoryDao.COLUMNS, Object> searchingOption) {
		SlgHourHistoryExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static List<Map<SlgHourHistoryDao.COLUMNS, Object>> selectFromToMatching(final SqlSession session, final Map<SlgHourHistoryDao.COLUMNS, Object> searchingOption, Date toDate) {
		SlgHourHistoryExample example = selectFromToMatchingExample(searchingOption, toDate);
		return select(session, example);
	}

	private static List<Map<SlgHourHistoryDao.COLUMNS, Object>> select(final SqlSession session, final SlgHourHistoryExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		SlgHourHistoryMapper mapper = session.getMapper(SlgHourHistoryMapper.class);
		List<SlgHourHistory> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
