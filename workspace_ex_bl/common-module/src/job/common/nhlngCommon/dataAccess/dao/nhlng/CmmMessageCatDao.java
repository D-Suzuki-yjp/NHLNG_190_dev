package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageCat;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageCatExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmMessageCatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageCatDao メッセージカテゴリマスタDAO
 * @author D.Suzuki
 */
public class CmmMessageCatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String MSGCAT_COLUMN_NAME = COLUMNS.MSG_CAT.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージカテゴリ */
		MSG_CAT,
		/** カテゴリ名 */
		CAT_NAME;
	}

	static {
		TABLE_NAME = "CmmMessageCat";
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
	private CmmMessageCatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmMessageCat> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmMessageCat object = new CmmMessageCat();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageCat object) {
		if (map == null) { return; }
		object.setMsgCat((String) map.get(COLUMNS.MSG_CAT));
		object.setCatName((String) map.get(COLUMNS.CAT_NAME));
	}
	*/

	private static void convertModelListToMapList(final List<CmmMessageCat> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmMessageCat object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmMessageCat object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getMsgCat() != null) {
			data.put(COLUMNS.MSG_CAT, object.getMsgCat());
		}
		if (object.getCatName() != null) {
			data.put(COLUMNS.CAT_NAME, object.getCatName());
		}
	}

	private static CmmMessageCatExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmMessageCatExample example = new CmmMessageCatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSG_CAT)) {
				String value = (String) searchingOption.get(COLUMNS.MSG_CAT);
				example.createCriteria().andMsgCatEqualTo(value);
			}
			if (searchingOption.containsKey(COLUMNS.CAT_NAME)) {
				String value = (String) searchingOption.get(COLUMNS.CAT_NAME);
				example.createCriteria().andCatNameEqualTo(value);
			}
		}
		return example;
	}

	private static CmmMessageCatExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmMessageCatExample example = new CmmMessageCatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSG_CAT)) {
				String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.MSG_CAT));
				example.createCriteria().andMsgCatLike(value1);
			}
			if (searchingOption.containsKey(COLUMNS.CAT_NAME)) {
				String value2 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.CAT_NAME));
				example.createCriteria().andCatNameLike(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String msgCat) {
		CmmMessageCatExample example = new CmmMessageCatExample();
		example.createCriteria().andMsgCatEqualTo(msgCat);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmMessageCatDao.COLUMNS, Object> searchingOption) {
		CmmMessageCatExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmmMessageCatDao.COLUMNS, Object> searchingOption) {
		CmmMessageCatExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmMessageCatExample example = new CmmMessageCatExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmMessageCatExample example) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmmMessageCatDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String msgCat) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		CmmMessageCat record = mapper.selectByPrimaryKey(msgCat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	public static Map<CmmMessageCatDao.COLUMNS, Object> selectByPrimaryKeyBetweenDB(final SqlSession session, final String msgCat) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		CmmMessageCat record = mapper.selectByPrimaryKeyBetweenDB(msgCat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmMessageCatDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmMessageCatDao.COLUMNS, Object> searchingOption) {
		CmmMessageCatExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmMessageCatDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmmMessageCatDao.COLUMNS, Object> searchingOption) {
		CmmMessageCatExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmMessageCatDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmMessageCatExample example = new CmmMessageCatExample();
		return select(session, example);
	}

	private static List<Map<CmmMessageCatDao.COLUMNS, Object>> select(final SqlSession session, final CmmMessageCatExample example) {
		// ORDER BY clause
		example.setOrderByClause(MSGCAT_COLUMN_NAME);

		// Select.
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		List<CmmMessageCat> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
