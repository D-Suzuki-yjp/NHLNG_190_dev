package job.sfcommon.dataaccess.dao.looponexcore;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SlgCurrentTrendDao 瞬時トレンドDAO
 * @author D.Suzuki
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentTrend;
import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentTrendExample;
import job.sfcommon.dataaccess.mapper.looponexcore.SlgCurrentTrendMapper;

/** 瞬時トレンドDAO */
public class SlgCurrentTrendDao {

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
		TABLE_NAME = "SlgCurrentTrend";
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
	private SlgCurrentTrendDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<SlgCurrentTrend> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			SlgCurrentTrend object = new SlgCurrentTrend();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}


	private static void convertMapToModel(final Map<COLUMNS, Object> map, final SlgCurrentTrend object) {
		if (map == null) { return; }
		object.setHistoryDate((Date) map.get(COLUMNS.HISTORY_DATE));
		object.setLcode((String) map.get(COLUMNS.LCODE));
		object.setValue((String) map.get(COLUMNS.VALUE));
		object.setQuality((int) map.get(COLUMNS.QUALITY));
		object.setCollectDate((Date) map.get(COLUMNS.COLLECT_DATE));
	}
	*/

	/**
	 * @param objectList List<SlgCurrentTrend>
	 * @param mapList List<Map<COLUMNS, Object>>
	 */
	private static void convertModelListToMapList(final List<SlgCurrentTrend> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) {
			return;
		}
		for (SlgCurrentTrend object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	/**
	 * @param object
	 *            SlgCurrentTrend
	 * @param data
	 *            Map<COLUMNS, Object>
	 */
	private static void convertModelToMap(final SlgCurrentTrend object, final Map<COLUMNS, Object> data) {
		if (object == null) {
			return;
		}
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

	/**
	 * @param session SqlSession
	 * @param example SlgCurrentTrendExample
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final SlgCurrentTrendExample example) {
		SlgCurrentTrendMapper mapper = session.getMapper(SlgCurrentTrendMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example SlgCurrentTrendExample
	 * @return List<Map<COLUMNS, Object>>
	 */
	public static List<Map<SlgCurrentTrendDao.COLUMNS, Object>> select(final SqlSession session, final SlgCurrentTrendExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		SlgCurrentTrendMapper mapper = session.getMapper(SlgCurrentTrendMapper.class);
		List<SlgCurrentTrend> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
