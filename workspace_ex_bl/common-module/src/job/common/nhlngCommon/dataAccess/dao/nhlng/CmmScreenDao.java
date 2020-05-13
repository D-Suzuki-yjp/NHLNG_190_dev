package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmScreen;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmScreenExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmScreenMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmScreenDao 画面マスタDAO
 * @author D.Suzuki
 */
public class CmmScreenDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SCREENID_COLUMN_NAME = COLUMNS.SCREEN_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** タグNO */
		TAG_NO,
		/** 画面ID */
		SCREEN_ID;
	}

	static {
		TABLE_NAME = "CmmScreen";
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
	private CmmScreenDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmScreen> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmScreen object = new CmmScreen();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmScreen object) {
		if (map == null) { return; }
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		object.setScreenId((String) map.get(COLUMNS.SCREEN_ID));
	}
	*/

	private static void convertModelListToMapList(final List<CmmScreen> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmScreen object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmScreen object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getScreenId() != null) {
			data.put(COLUMNS.SCREEN_ID, object.getScreenId());
		}
	}

	private static CmmScreenExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmScreenExample example = new CmmScreenExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TAG_NO) && searchingOption.containsKey(COLUMNS.SCREEN_ID)) {
				String value1 = (String) searchingOption.get(COLUMNS.TAG_NO);
				String value2 = (String) searchingOption.get(COLUMNS.SCREEN_ID);
				example.createCriteria().andTagNoEqualTo(value1).andScreenIdEqualTo(value2);
			}
		}
		return example;
	}

	private static CmmScreenExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmScreenExample example = new CmmScreenExample();
		if (searchingOption.size() > 0) {
			String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.TAG_NO));
			String value2 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.SCREEN_ID));
			if (searchingOption.containsKey(COLUMNS.TAG_NO) && searchingOption.containsKey(COLUMNS.SCREEN_ID)) {
				example.createCriteria().andTagNoLike(value1).andScreenIdEqualTo(value2);
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
		CmmScreenExample example = new CmmScreenExample();
		example.createCriteria().andTagNoEqualTo(id);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmmScreenExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmmScreenExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmScreenExample example = new CmmScreenExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmScreenExample example) {
		CmmScreenMapper mapper = session.getMapper(CmmScreenMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String tagNo, final String screenId) {
		CmmScreenMapper mapper = session.getMapper(CmmScreenMapper.class);
		CmmScreen record = mapper.selectByPrimaryKey(tagNo, screenId);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmmScreenExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmmScreenExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmScreenExample example = new CmmScreenExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmmScreenExample example) {
		// ORDER BY clause
		example.setOrderByClause(SCREENID_COLUMN_NAME);

		// Select.
		CmmScreenMapper mapper = session.getMapper(CmmScreenMapper.class);
		List<CmmScreen> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
