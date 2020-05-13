package job.common.nhlngCommon.dataAccess.dao.looponexcore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.entity.looponexCore.SystemSpecificData;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SystemSpecificDataExample;
import job.common.nhlngCommon.dataAccess.mapper.looponexCore.SystemSpecificDataMapper;


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

	private static void convertModelListToMapList(final List<SystemSpecificData> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (SystemSpecificData object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final SystemSpecificData object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
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

	private static SystemSpecificDataExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SystemSpecificDataExample example = new SystemSpecificDataExample();
		if (searchingOption.size() > 0) {
			String value1 = (String) searchingOption.get(COLUMNS.LCODE);
			String value2 = (String) searchingOption.get(COLUMNS.ID);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andLcodeEqualTo(value1).andIdEqualTo(value2);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andLcodeEqualTo(value1);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andIdEqualTo(value2);
				if (Objects.isNull(example)){
					example = makePartialMatchingExample(searchingOption);
				}
			}
		}
		return example;
	}


	private static SystemSpecificDataExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SystemSpecificDataExample example = new SystemSpecificDataExample();
		if (searchingOption.size() > 0) {
			String value1 = (String) searchingOption.get(COLUMNS.LCODE);
			String value2 = (String) searchingOption.get(COLUMNS.ID);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andLcodeLike(value1).andIdLike(value2);
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andLcodeLike(value1);
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andIdLike(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countSystemSpecificData(final SqlSession session, final Map<SystemSpecificDataDao.COLUMNS, Object> searchingOption) {

			long result = countEqualToMatching(session, searchingOption);

		return result;
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		SystemSpecificDataExample example = new SystemSpecificDataExample();
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	private static long countEqualToMatching(final SqlSession session, final Map<SystemSpecificDataDao.COLUMNS, Object> searchingOption) {
		SystemSpecificDataExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	private static long count(final SqlSession session, final SystemSpecificDataExample example) {
		SystemSpecificDataMapper mapper = session.getMapper(SystemSpecificDataMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static List<Map<SystemSpecificDataDao.COLUMNS, Object>> selectSystemSpecificData(final SqlSession session, final Map<SystemSpecificDataDao.COLUMNS, Object> searchingOption, Date toDate) {

		List<Map<SystemSpecificDataDao.COLUMNS, Object>> result = selectEqualToMatching(session, searchingOption);

		return result;
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<SystemSpecificDataDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		SystemSpecificDataExample example = new SystemSpecificDataExample();
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	private static List<Map<SystemSpecificDataDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<SystemSpecificDataDao.COLUMNS, Object> searchingOption) {
		SystemSpecificDataExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	private static List<Map<SystemSpecificDataDao.COLUMNS, Object>> select(final SqlSession session, final SystemSpecificDataExample example) {
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
