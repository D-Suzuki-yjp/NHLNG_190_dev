package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageDef;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageDefExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmMessageDefMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageDefDao メッセージ定義マスタDAO
 * @author D.Suzuki
 */
public class CmmMessageDefDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CMMMESSAGEDEF_COLUMN_NAME = COLUMNS.MSGID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージID */
		MSGID,
		/** メッセージカテゴリ */
		MSGCAT,
		/** メッセージ種別 */
		MSGKIND,
		/** メッセージテキスト */
		MSGTEXT,
		/** 最終更新者 */
		LASTUPDUSER,
		/** 最終更新日時 */
		LASTUPDDTIME,
		/** 削除フラグ */
		DELETEFLAG,;
		private final String msg_id;

		private COLUMNS() {
			this.msg_id = this.name();
		}

		private COLUMNS(String msg_id) {
			this.msg_id = msg_id;
		}


		/**
		 * カラム名
		 *
		 * @return カラム名
		 */
		@Override
		public String toString() {
			return this.msg_id;
		}
	}

	static {
		TABLE_NAME = "cmmMessageDef";
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
	private CmmMessageDefDao() {
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

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageDef object) {
		if (map == null) { return; }
		object.setMsgId((String) map.get(COLUMNS.MSGID));
		object.setMsgCat((String) map.get(COLUMNS.MSGCAT));
		object.setMsgKind((String) map.get(COLUMNS.MSGKIND));
		object.setMsgText((String) map.get(COLUMNS.MSGTEXT));
	}

	private static void convertModelListToMapList(final List<CmmMessageDef> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmMessageDef object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmMessageDef object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getMsgId() != null) {
			data.put(COLUMNS.MSGID, object.getMsgId());
		}
		if (object.getMsgCat() != null) {
			data.put(COLUMNS.MSGCAT, object.getMsgCat());
		}
		if (object.getMsgKind() != null) {
			data.put(COLUMNS.MSGKIND, object.getMsgKind());
		}
		if (object.getMsgText() != null) {
			data.put(COLUMNS.MSGTEXT, object.getMsgText());
		}
	}

	private static CmmMessageDefExample makeEqualToMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmMessageDefExample example = new CmmMessageDefExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSGID)) {
				String MSGCAT = searchingOption.get(COLUMNS.MSGID);
				example.createCriteria().andMsgIdEqualTo(MSGCAT);
			}
			if (searchingOption.containsKey(COLUMNS.MSGCAT)) {
				String MSGCAT = searchingOption.get(COLUMNS.MSGCAT);
				example.createCriteria().andMsgCatEqualTo(MSGCAT);
			}
		}
		return example;
	}

	private static CmmMessageDefExample makePartialMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmMessageDefExample example = new CmmMessageDefExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSGID)) {
				String MSGCAT = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.MSGID));
				example.createCriteria().andMsgIdLike(MSGCAT);
			}
			if (searchingOption.containsKey(COLUMNS.MSGCAT)) {
				String MSGCAT = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.MSGCAT));
				example.createCriteria().andMsgIdLike(MSGCAT);
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
		CmmMessageDefExample example = new CmmMessageDefExample();
		example.createCriteria().andMsgIdEqualTo(id);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmMessageDefExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmMessageDefExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmMessageDefExample example = new CmmMessageDefExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmMessageDefExample example) {
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String id, final String cat) {
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		CmmMessageDef record = mapper.selectByPrimaryKey(id, cat);

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
		CmmMessageDefExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, String> searchingOption) {
		CmmMessageDefExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmMessageDefExample example = new CmmMessageDefExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmmMessageDefExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMMMESSAGEDEF_COLUMN_NAME);

		// Select.
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		List<CmmMessageDef> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String id = (String) data.get(COLUMNS.MSGID);
		Validator.requireNonNullAndNonEmpty(id, "id");

		// Make data.
		CmmMessageDef record = new CmmMessageDef();
		convertMapToModel(data, record);

		// Insert.
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String id = (String) data.get(COLUMNS.MSGID);
		Validator.requireNonNullAndNonEmpty(id, "id");

		// Make data.
		CmmMessageDef record = new CmmMessageDef();
		convertMapToModel(data, record);

		// Update.
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String id) {
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		return mapper.deleteByPrimaryKey(id);
	}

}
