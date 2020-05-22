package job.sfcommon.dataaccess.dao.looponexcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.looponexCore.SlgHistoryGroupMaster;
import job.sfcommon.dataaccess.entity.looponexCore.SlgHistoryGroupMasterExample;
import job.sfcommon.dataaccess.mapper.looponexCore.SlgHistoryGroupMasterMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SlgHistoryGroupMasterDao 締切グループマスタDAO
 * @author D.Suzuki
 */
@Dependent
public class SlgHistoryGroupMasterDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.HISTORY_GROUP_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 締切グループNO */
		HISTORY_GROUP_NO,
		/** 分締めタイミング（秒） */
		MINUTE_HISTORY_TIMING,
		/** 時締めタイミング（分） */
		HOUR_HISTORY_TIMING,
		/** 日締めタイミング（時） */
		DAY_HISTORY_TIMING,
		/** 月締めタイミング（日） */
		MONTH_HISTORY_TIMING,
		/** 年締めタイミング（月） */
		YEAR_HISTORY_TIMING,
		/** 時締処理前クラス */
		HOUR_HISTORY_FORTH_CLASS,
		/** 時締処理後クラス */
		HOUR_HISTORY_BACK_CLASS,
		/** 日締処理前クラス */
		DAY_HISTORY_FORTH_CLASS,
		/** 日締処理後クラス */
		DAY_HISTORY_BACK_CLASS,
		/** 月締処理前クラス */
		MONTH_HISTORY_FORTH_CLASS,
		/** 月締処理後クラス */
		MONTH_HISTORY_BACK_CLASS,
		/** 年締処理前クラス */
		YEAR_HISTORY_FORTH_CLASS,
		/** 年締処理後クラス */
		YEAR_HISTORY_BACK_CLASS,
		/** 分締め停止フラグ */
		MINUTE_HISTORY_STOP_FLAG,
		/** 時締め停止フラグ */
		HOUR_HISTORY_STOP_FLAG,
		/** 日締め停止フラグ */
		DAY_HISTORY_STOP_FLAG,
		/** 月締め停止フラグ */
		MONTH_HISTORY_STOP_FLAG,
		/** 年締め停止フラグ */
		YEAR_HISTORY_STOP_FLAG;
	}

	static {
		TABLE_NAME = "SlgHistoryGroupMaster";
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
	private SlgHistoryGroupMasterDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<SlgHistoryGroupMaster> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			SlgHistoryGroupMaster object = new SlgHistoryGroupMaster();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final SlgHistoryGroupMaster object) {
		if (map == null) { return; }
		object.setHistoryGroupNo((Integer) map.get(COLUMNS.HISTORY_GROUP_NO));
		object.setMinuteHistoryTiming((Integer) map.get(COLUMNS.MINUTE_HISTORY_TIMING));
		object.setHourHistoryTiming((Integer) map.get(COLUMNS.HOUR_HISTORY_TIMING));
		object.setDayHistoryTiming((Integer) map.get(COLUMNS.DAY_HISTORY_TIMING));
		object.setMonthHistoryTiming((Integer) map.get(COLUMNS.MONTH_HISTORY_TIMING));
		object.setYearHistoryTiming((Integer) map.get(COLUMNS.YEAR_HISTORY_TIMING));
		object.setHourHistoryForthClass((String) map.get(COLUMNS.HOUR_HISTORY_FORTH_CLASS));
		object.setHourHistoryBackClass((String) map.get(COLUMNS.HOUR_HISTORY_BACK_CLASS));
		object.setDayHistoryForthClass((String) map.get(COLUMNS.DAY_HISTORY_FORTH_CLASS));
		object.setDayHistoryBackClass((String) map.get(COLUMNS.DAY_HISTORY_BACK_CLASS));
		object.setMonthHistoryForthClass((String) map.get(COLUMNS.MONTH_HISTORY_FORTH_CLASS));
		object.setMonthHistoryBackClass((String) map.get(COLUMNS.MONTH_HISTORY_BACK_CLASS));
		object.setYearHistoryForthClass((String) map.get(COLUMNS.YEAR_HISTORY_FORTH_CLASS));
		object.setYearHistoryBackClass((String) map.get(COLUMNS.YEAR_HISTORY_BACK_CLASS));
		object.setMonthHistoryStopFlag((Integer) map.get(COLUMNS.MINUTE_HISTORY_STOP_FLAG));
		object.setHourHistoryStopFlag((Integer) map.get(COLUMNS.HOUR_HISTORY_STOP_FLAG));
		object.setDayHistoryStopFlag((Integer) map.get(COLUMNS.DAY_HISTORY_STOP_FLAG));
		object.setMonthHistoryStopFlag((Integer) map.get(COLUMNS.MONTH_HISTORY_STOP_FLAG));
		object.setYearHistoryStopFlag((Integer) map.get(COLUMNS.YEAR_HISTORY_STOP_FLAG));
	}
	*/

	private static void convertModelListToMapList(final List<SlgHistoryGroupMaster> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (SlgHistoryGroupMaster object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final SlgHistoryGroupMaster object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getHistoryGroupNo() != null) {
			data.put(COLUMNS.HISTORY_GROUP_NO, object.getHistoryGroupNo());
		}
		if (object.getMinuteHistoryTiming() != null) {
			data.put(COLUMNS.MINUTE_HISTORY_TIMING, object.getMinuteHistoryTiming());
		}
		if (object.getHourHistoryTiming() != null) {
			data.put(COLUMNS.HOUR_HISTORY_TIMING, object.getHourHistoryTiming());
		}
		if (object.getDayHistoryTiming() != null) {
			data.put(COLUMNS.DAY_HISTORY_TIMING, object.getDayHistoryTiming());
		}
		if (object.getMonthHistoryTiming() != null) {
			data.put(COLUMNS.MONTH_HISTORY_TIMING, object.getMonthHistoryTiming());
		}
		if (object.getYearHistoryTiming() != null) {
			data.put(COLUMNS.YEAR_HISTORY_TIMING, object.getYearHistoryTiming());
		}
		if (object.getHourHistoryForthClass() != null) {
			data.put(COLUMNS.HOUR_HISTORY_FORTH_CLASS, object.getHourHistoryForthClass());
		}
		if (object.getHourHistoryBackClass() != null) {
			data.put(COLUMNS.HOUR_HISTORY_BACK_CLASS, object.getHourHistoryBackClass());
		}
		if (object.getDayHistoryForthClass() != null) {
			data.put(COLUMNS.DAY_HISTORY_FORTH_CLASS, object.getDayHistoryForthClass());
		}
		if (object.getDayHistoryBackClass() != null) {
			data.put(COLUMNS.DAY_HISTORY_BACK_CLASS, object.getDayHistoryBackClass());
		}
		if (object.getMonthHistoryForthClass() != null) {
			data.put(COLUMNS.MONTH_HISTORY_FORTH_CLASS, object.getMonthHistoryForthClass());
		}
		if (object.getMonthHistoryBackClass() != null) {
			data.put(COLUMNS.MONTH_HISTORY_BACK_CLASS, object.getMonthHistoryBackClass());
		}
		if (object.getYearHistoryForthClass() != null) {
			data.put(COLUMNS.YEAR_HISTORY_FORTH_CLASS, object.getYearHistoryForthClass());
		}
		if (object.getYearHistoryBackClass() != null) {
			data.put(COLUMNS.YEAR_HISTORY_BACK_CLASS, object.getYearHistoryBackClass());
		}
		if (object.getMonthHistoryStopFlag() != null) {
			data.put(COLUMNS.MINUTE_HISTORY_STOP_FLAG, object.getMonthHistoryStopFlag());
		}
		if (object.getDayHistoryStopFlag() != null) {
			data.put(COLUMNS.HOUR_HISTORY_STOP_FLAG, object.getDayHistoryStopFlag());
		}
		if (object.getDayHistoryStopFlag() != null) {
			data.put(COLUMNS.DAY_HISTORY_STOP_FLAG, object.getDayHistoryStopFlag());
		}
		if (object.getMinuteHistoryStopFlag() != null) {
			data.put(COLUMNS.MONTH_HISTORY_STOP_FLAG, object.getMinuteHistoryStopFlag());
		}
		if (object.getYearHistoryStopFlag() != null) {
			data.put(COLUMNS.YEAR_HISTORY_STOP_FLAG, object.getYearHistoryStopFlag());
		}
	}

	private static SlgHistoryGroupMasterExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SlgHistoryGroupMasterExample example = new SlgHistoryGroupMasterExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.HISTORY_GROUP_NO)) {
				Integer value = (Integer) searchingOption.get(COLUMNS.HISTORY_GROUP_NO);
				example.createCriteria().andHistoryGroupNoEqualTo(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final Integer closeDtime) {
		SlgHistoryGroupMasterExample example = new SlgHistoryGroupMasterExample();
		example.createCriteria().andHistoryGroupNoEqualTo(closeDtime);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<SlgHistoryGroupMasterDao.COLUMNS, Object> searchingOption) {
		SlgHistoryGroupMasterExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		SlgHistoryGroupMasterExample example = new SlgHistoryGroupMasterExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final SlgHistoryGroupMasterExample example) {
		SlgHistoryGroupMasterMapper mapper = session.getMapper(SlgHistoryGroupMasterMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<SlgHistoryGroupMasterDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<SlgHistoryGroupMasterDao.COLUMNS, Object> searchingOption) {
		SlgHistoryGroupMasterExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<SlgHistoryGroupMasterDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		SlgHistoryGroupMasterExample example = new SlgHistoryGroupMasterExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final SlgHistoryGroupMasterExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		SlgHistoryGroupMasterMapper mapper = session.getMapper(SlgHistoryGroupMasterMapper.class);
		List<SlgHistoryGroupMaster> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
