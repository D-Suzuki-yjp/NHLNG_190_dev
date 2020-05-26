package job.sfcommon.dataaccess.dao.looponexcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.looponexcore.SlgCollectGroupMaster;
import job.sfcommon.dataaccess.entity.looponexcore.SlgCollectGroupMasterExample;
import job.sfcommon.dataaccess.mapper.looponexcore.SlgCollectGroupMasterMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SlgCollectGroupMasterDao 収集周期グループマスタDAO
 * @author D.Suzuki
 */

public class SlgCollectGroupMasterDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.COLLECT_GROUP_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 収集グループNO */
		COLLECT_GROUP_NO,
		/** サブシステムID */
		SUBSYSTEM_ID,
		/** 収集停止フラグ */
		COLLECT_STOP_FLAG,
		/** 収集元データソース */
		COLLECT_DATASOURCE,
		/** 瞬時処理開始前クラス */
		COLLECT_FORTH_CLASS,
		/** 瞬時処理終了後クラス */
		COLLECT_BACK_CLASS,
		/** 瞬時トレンド処理開始前クラス */
		CURRENT_TREND_FORTH_CLASS,
		/** 瞬時トレンド処理終了後クラス */
		CURRENT_TREND_BACK_CLASS,
		/** 収集周期 */
		COLLECT_CYCLE,
		/** グループ結合NO */
		COLLECT_JOIN_NO,
		/** タグ自動同期フラグ */
		AUTO_TAG_SYNC_FLAG,
		/** MODBUSアドレス自動割付フラグ */
		AUTO_MODBUS_ADDRESS_FLAG,
		/** 収集できなかった瞬時トレンドを保存しないフラグ */
		NOT_COLLECT_DATA_THROW_FLAG;
	}

	static {
		TABLE_NAME = "SlgCollectGroupMaster";
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
	private SlgCollectGroupMasterDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<SlgCollectGroupMaster> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			SlgCollectGroupMaster object = new SlgCollectGroupMaster();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final SlgCollectGroupMaster object) {
		if (map == null) { return; }
		object.setCollectGroupNo((Integer) map.get(COLUMNS.COLLECT_GROUP_NO));
		object.setSubsystemId((String) map.get(COLUMNS.SUBSYSTEM_ID));
		object.setCollectStopFlag((Integer) map.get(COLUMNS.COLLECT_STOP_FLAG));
		object.setCollectDatasource((String) map.get(COLUMNS.COLLECT_DATASOURCE));
		object.setCollectForthClass((String) map.get(COLUMNS.COLLECT_FORTH_CLASS));
		object.setCollectBackClass((String) map.get(COLUMNS.COLLECT_BACK_CLASS));
		object.setCurrentTrendForthClass((String) map.get(COLUMNS.CURRENT_TREND_FORTH_CLASS));
		object.setCurrentTrendBackClass((String) map.get(COLUMNS.CURRENT_TREND_BACK_CLASS));
		object.setCollectCycle((Integer) map.get(COLUMNS.COLLECT_CYCLE));
		object.setCollectJoinNo((Integer) map.get(COLUMNS.COLLECT_JOIN_NO));
		object.setAutoTagSyncFlag((Integer) map.get(COLUMNS.AUTO_TAG_SYNC_FLAG));
		object.setAutoModbusAddressFlag((Integer) map.get(COLUMNS.AUTO_MODBUS_ADDRESS_FLAG));
		object.setNotCollectDataThrowFlag((Integer) map.get(COLUMNS.NOT_COLLECT_DATA_THROW_FLAG));
	}
	*/

	private static void convertModelListToMapList(final List<SlgCollectGroupMaster> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (SlgCollectGroupMaster object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final SlgCollectGroupMaster object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getCollectGroupNo() != null) {
			data.put(COLUMNS.COLLECT_GROUP_NO, object.getCollectGroupNo());
		}
		if (object.getSubsystemId() != null) {
			data.put(COLUMNS.SUBSYSTEM_ID, object.getSubsystemId());
		}
		if (object.getCollectStopFlag() != null) {
			data.put(COLUMNS.COLLECT_STOP_FLAG, object.getCollectStopFlag());
		}
		if (object.getCollectDatasource() != null) {
			data.put(COLUMNS.COLLECT_DATASOURCE, object.getCollectDatasource());
		}
		if (object.getCollectForthClass() != null) {
			data.put(COLUMNS.COLLECT_FORTH_CLASS, object.getCollectForthClass());
		}
		if (object.getCollectBackClass() != null) {
			data.put(COLUMNS.COLLECT_BACK_CLASS, object.getCollectBackClass());
		}
		if (object.getCurrentTrendForthClass() != null) {
			data.put(COLUMNS.CURRENT_TREND_FORTH_CLASS, object.getCurrentTrendForthClass());
		}
		if (object.getCurrentTrendBackClass() != null) {
			data.put(COLUMNS.CURRENT_TREND_BACK_CLASS, object.getCurrentTrendBackClass());
		}
		if (object.getCollectCycle() != null) {
			data.put(COLUMNS.COLLECT_CYCLE, object.getCollectCycle());
		}
		if (object.getCollectJoinNo() != null) {
			data.put(COLUMNS.COLLECT_JOIN_NO, object.getCollectJoinNo());
		}
		if (object.getAutoTagSyncFlag() != null) {
			data.put(COLUMNS.AUTO_TAG_SYNC_FLAG, object.getAutoTagSyncFlag());
		}
		if (object.getAutoModbusAddressFlag() != null) {
			data.put(COLUMNS.AUTO_MODBUS_ADDRESS_FLAG, object.getAutoModbusAddressFlag());
		}
		if (object.getNotCollectDataThrowFlag() != null) {
			data.put(COLUMNS.NOT_COLLECT_DATA_THROW_FLAG, object.getNotCollectDataThrowFlag());
		}
	}

	private static SlgCollectGroupMasterExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SlgCollectGroupMasterExample example = new SlgCollectGroupMasterExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.COLLECT_GROUP_NO)) {
				Integer value = (Integer) searchingOption.get(COLUMNS.COLLECT_GROUP_NO);
				example.createCriteria().andCollectGroupNoEqualTo(value);
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
		SlgCollectGroupMasterExample example = new SlgCollectGroupMasterExample();
		example.createCriteria().andCollectGroupNoEqualTo(closeDtime);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<SlgCollectGroupMasterDao.COLUMNS, Object> searchingOption) {
		SlgCollectGroupMasterExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		SlgCollectGroupMasterExample example = new SlgCollectGroupMasterExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final SlgCollectGroupMasterExample example) {
		SlgCollectGroupMasterMapper mapper = session.getMapper(SlgCollectGroupMasterMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<SlgCollectGroupMasterDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<SlgCollectGroupMasterDao.COLUMNS, Object> searchingOption) {
		SlgCollectGroupMasterExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<SlgCollectGroupMasterDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		SlgCollectGroupMasterExample example = new SlgCollectGroupMasterExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final SlgCollectGroupMasterExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		SlgCollectGroupMasterMapper mapper = session.getMapper(SlgCollectGroupMasterMapper.class);
		List<SlgCollectGroupMaster> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
