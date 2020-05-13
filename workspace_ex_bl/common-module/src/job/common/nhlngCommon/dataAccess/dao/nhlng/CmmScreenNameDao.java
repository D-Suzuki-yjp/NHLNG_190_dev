package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmScreenName;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmScreenNameExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmScreenNameMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmScreenNameDao 画面名マスタDAO
 * @author D.Suzuki
 */
public class CmmScreenNameDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SCREENID_COLUMN_NAME = COLUMNS.SCREEN_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 画面ID */
		SCREEN_ID,
		/** 画面名 */
		SCREEN_NAME;
	}

	static {
		TABLE_NAME = "CmmScreenName";
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
	private CmmScreenNameDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmScreenName> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmScreenName object = new CmmScreenName();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmScreenName object) {
		if (map == null) { return; }
		object.setScreenId((String) map.get(COLUMNS.SCREEN_ID));
		object.setScreenName((String) map.get(COLUMNS.SCREEN_NAME));
	}
	*/

	private static void convertModelListToMapList(final List<CmmScreenName> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmScreenName object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmScreenName object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getScreenId() != null) {
			data.put(COLUMNS.SCREEN_ID, object.getScreenId());
		}
		if (object.getScreenId() != null) {
			data.put(COLUMNS.SCREEN_NAME, object.getScreenName());
		}
	}

	private static CmmScreenNameExample makeEqualToMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmScreenNameExample example = new CmmScreenNameExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCREEN_ID) && searchingOption.containsKey(COLUMNS.SCREEN_NAME)) {
				String value1 = searchingOption.get(COLUMNS.SCREEN_ID);
				String value2 = searchingOption.get(COLUMNS.SCREEN_NAME);
				example.createCriteria().andScreenIdEqualTo(value1).andScreenNameEqualTo(value2);
			}
		}
		return example;
	}

	private static CmmScreenNameExample makePartialMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmScreenNameExample example = new CmmScreenNameExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCREEN_ID) && searchingOption.containsKey(COLUMNS.SCREEN_NAME)) {
				String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.SCREEN_ID));
				String value2 = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.SCREEN_NAME));
				example.createCriteria().andScreenIdLike(value1).andScreenNameLike(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String id) {
		CmmScreenNameExample example = new CmmScreenNameExample();
		example.createCriteria().andScreenIdEqualTo(id);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmScreenNameExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmScreenNameExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmScreenNameExample example = new CmmScreenNameExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmScreenNameExample example) {
		CmmScreenNameMapper mapper = session.getMapper(CmmScreenNameMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String screenId) {
		CmmScreenNameMapper mapper = session.getMapper(CmmScreenNameMapper.class);
		CmmScreenName record = mapper.selectByPrimaryKey(screenId);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmScreenNameExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmScreenNameExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmScreenNameExample example = new CmmScreenNameExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmmScreenNameExample example) {
		// ORDER BY clause
		example.setOrderByClause(SCREENID_COLUMN_NAME);

		// Select.
		CmmScreenNameMapper mapper = session.getMapper(CmmScreenNameMapper.class);
		List<CmmScreenName> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
