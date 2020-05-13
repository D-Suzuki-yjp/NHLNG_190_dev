package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmItem;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmItemExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmItemMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment1
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmItemDao 項目マスタDAO
 * @author D.Suzuki
 */
public class CmmItemDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String ID_COLUMN_NAME = COLUMNS.ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 種別 */
		KIND,
		/** ID */
		ID,
		/** 項目 */
		ITEM,
		/** コメント */
		COMMENT1;
	}

	static {
		TABLE_NAME = "CmmItem";
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
	private CmmItemDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmItem> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmItem object = new CmmItem();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmItem object) {
		if (map == null) { return; }
		object.setKind((String) map.get(COLUMNS.KIND));
		object.setId((Integer) map.get(COLUMNS.ID));
		object.setItem((String) map.get(COLUMNS.ITEM));
		object.setComment1((String) map.get(COLUMNS.COMMENT));
	}
	*/

	private static void convertModelListToMapList(final List<CmmItem> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmItem object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmItem object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getKind() != null) {
			data.put(COLUMNS.KIND, object.getKind());
		}
		if (object.getId() != null) {
			data.put(COLUMNS.ID, object.getId());
		}
		if (object.getItem() != null) {
			data.put(COLUMNS.ITEM, object.getItem());
		}
		if (object.getComment1() != null) {
			data.put(COLUMNS.COMMENT1, object.getComment1());
		}
	}

	private static CmmItemExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmItemExample example = new CmmItemExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.KIND) && searchingOption.containsKey(COLUMNS.ID)) {
				example.createCriteria().andKindEqualTo((String) searchingOption.get(COLUMNS.KIND)).andIdEqualTo((Integer) searchingOption.get(COLUMNS.ID));
			}
		}
		return example;
	}

	private static CmmItemExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmItemExample example = new CmmItemExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.KIND)){
				String value = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.KIND));
				example.createCriteria().andKindLike(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param kind
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String kind) {
		CmmItemExample example = new CmmItemExample();
		example.createCriteria().andKindEqualTo(kind);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmItemDao.COLUMNS, Object> searchingOption) {
		CmmItemExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmmItemDao.COLUMNS, Object> searchingOption) {
		CmmItemExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmItemExample example = new CmmItemExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmItemExample example) {
		CmmItemMapper mapper = session.getMapper(CmmItemMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param kind
	 * @param id
	 * @return
	 */
	public static Map<CmmItemDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String kind, final Integer id) {
		CmmItemMapper mapper = session.getMapper(CmmItemMapper.class);
		CmmItem record = mapper.selectByPrimaryKey(kind, id);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmItemDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmItemDao.COLUMNS, Object> searchingOption) {
		CmmItemExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmItemDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmmItemDao.COLUMNS, Object> searchingOption) {
		CmmItemExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 */
	public static List<Map<CmmItemDao.COLUMNS, Object>> selectScreenItem(final SqlSession session, final String kind) {
		CmmItemExample example = new CmmItemExample();
		example.createCriteria().andKindEqualTo(kind);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmItemDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmItemExample example = new CmmItemExample();
		return select(session, example);
	}

	private static List<Map<CmmItemDao.COLUMNS, Object>> select(final SqlSession session, final CmmItemExample example) {
		// ORDER BY clause
		example.setOrderByClause(ID_COLUMN_NAME);

		// Select.
		CmmItemMapper mapper = session.getMapper(CmmItemMapper.class);
		List<CmmItem> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
