package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageCat;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageCatExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmMessageCatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtMessageDao メッセージカテゴリマスタDAO
 * @author D.Suzuki
 */
public class CmmMessageCatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String MSGCAT_COLUMN_NAME = COLUMNS.MSGCAT.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージカテゴリ */
		MSGCAT("msg_cat"),
		/** カテゴリ名 */
		CATNAME,
		/** 最終更新者 */
		LASTUPDUSER,
		/** 最終更新日時 */
		LASTUPDDTIME,
		/** 削除フラグ */
		DELETEFLAG,;

		private final String msg_cat;

		private COLUMNS() {
			this.msg_cat = this.name();
		}

		private COLUMNS(String msg_cat) {
			this.msg_cat = msg_cat;
		}


		/**
		 * カラム名
		 *
		 * @return カラム名
		 */
		@Override
		public String toString() {
			return this.msg_cat;
		}
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
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<Users> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			Users object = new Users();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageCat object) {
		if (map == null) { return; }
		object.setMsgCat((String) map.get(COLUMNS.MSGCAT));
		object.setCatName((String) map.get(COLUMNS.CATNAME));
	}

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
			data.put(COLUMNS.MSGCAT, object.getMsgCat());
		}
		if (object.getCatName() != null) {
			data.put(COLUMNS.CATNAME, object.getCatName());
		}
	}

	private static CmmMessageCatExample makeEqualToMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmMessageCatExample example = new CmmMessageCatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSGCAT)) {
				String value = searchingOption.get(COLUMNS.MSGCAT);
				example.createCriteria().andMsgCatEqualTo(value);
			}
			if (searchingOption.containsKey(COLUMNS.CATNAME)) {
				String value = searchingOption.get(COLUMNS.CATNAME);
				example.createCriteria().andCatNameEqualTo(value);
			}
		}
		return example;
	}

	private static CmmMessageCatExample makePartialMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmMessageCatExample example = new CmmMessageCatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSGCAT)) {
				String value = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.MSGCAT));
				example.createCriteria().andMsgCatLike(value);
			}
			if (searchingOption.containsKey(COLUMNS.CATNAME)) {
				String value = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.CATNAME));
				example.createCriteria().andCatNameLike(value);
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
		CmmMessageCatExample example = new CmmMessageCatExample();
		example.createCriteria().andMsgCatEqualTo(id);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmMessageCatExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
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
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String cat) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		CmmMessageCat record = mapper.selectByPrimaryKey(cat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	public static Map<COLUMNS, Object> selectByPrimaryKeyBetweenDB(final SqlSession session, final String cat) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		CmmMessageCat record = mapper.selectByPrimaryKeyBetweenDB(cat);

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
		CmmMessageCatExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmMessageCatExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmMessageCatExample example = new CmmMessageCatExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmmMessageCatExample example) {
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

	public static int insert(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String id = (String) data.get(COLUMNS.MSGCAT);
		Validator.requireNonNullAndNonEmpty(id, "id");

		// Make data.
		CmmMessageCat record = new CmmMessageCat();
		convertMapToModel(data, record);

		// Insert.
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String id = (String) data.get(COLUMNS.MSGCAT);
		Validator.requireNonNullAndNonEmpty(id, "id");

		// Make data.
		CmmMessageCat record = new CmmMessageCat();
		convertMapToModel(data, record);

		// Update.
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String id) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		return mapper.deleteByPrimaryKey(id);
	}

}
