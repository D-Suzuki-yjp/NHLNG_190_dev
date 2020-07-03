package job.sfcommon.dataaccess.dao.looponexcore;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SystemSpecificDataDao NH月締データDAO
 * @author D.Suzuki
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.looponexcore.SystemSpecificData;
import job.sfcommon.dataaccess.entity.looponexcore.SystemSpecificDataExample;
import job.sfcommon.dataaccess.mapper.looponexcore.SystemSpecificDataMapper;

/** NH月締データDAO */
public class SystemSpecificDataDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.LCODE.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 締め日時 */
		LCODE,
		/** タグNO */
		ID,
		/** タグ値 */
		VALUE,
		/** 品質コード */
		CREATE_DATE;
	}

	static {
		TABLE_NAME = "SystemSpecificData";
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
	private SystemSpecificDataDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<SystemSpecificData> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			SystemSpecificData object = new SystemSpecificData();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final SystemSpecificData object) {
		if (map == null) { return; }
		object.setLcode((String) map.get(COLUMNS.LCODE));
		object.setId((String) map.get(COLUMNS.ID));
		object.setValue((String) map.get(COLUMNS.VALUE));
		object.setCreateDate((Date) map.get(COLUMNS.CREATE_DATE));
	}
	*/

	/**
	 * @param objectList List<SystemSpecificData>
	 * @param mapList List<Map<COLUMNS, Object>>
	 */
	private static void convertModelListToMapList(final List<SystemSpecificData> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) {
			return;
		}
		for (SystemSpecificData object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	/**
	 * @param object
	 *            SystemSpecificData
	 * @param data
	 *            Map<COLUMNS, Object>
	 */
	private static void convertModelToMap(final SystemSpecificData object, final Map<COLUMNS, Object> data) {
		if (object == null) {
			return;
		}
		if (object.getLcode() != null) {
			data.put(COLUMNS.LCODE, object.getLcode());
		}
		if (object.getId() != null) {
			data.put(COLUMNS.ID, object.getId());
		}
		if (object.getValue() != null) {
			data.put(COLUMNS.VALUE, object.getValue());
		}
		if (object.getCreateDate() != null) {
			data.put(COLUMNS.CREATE_DATE, object.getCreateDate());
		}
	}

	/**
	 * @param session SqlSession
	 * @param example SystemSpecificDataExample
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final SystemSpecificDataExample example) {
		SystemSpecificDataMapper mapper = session.getMapper(SystemSpecificDataMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example SystemSpecificDataExample
	 * @return List<Map<COLUMNS, Object>>
	 */
	public static List<Map<SystemSpecificDataDao.COLUMNS, Object>> select(final SqlSession session, final SystemSpecificDataExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		SystemSpecificDataMapper mapper = session.getMapper(SystemSpecificDataMapper.class);
		List<SystemSpecificData> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
