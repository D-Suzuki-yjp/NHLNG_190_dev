package job.sfcommon.dataaccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDef;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDefExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmMessageDefMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageDefDao メッセージ定義マスタDAO
 * @author D.Suzuki
 */
@Dependent
public class CmmMessageDefDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CMMMESSAGEDEF_COLUMN_NAME = COLUMNS.MSG_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージID */
		MSG_ID,
		/** メッセージカテゴリ */
		MSG_CAT,
		/** メッセージ種別 */
		MSG_KIND,
		/** メッセージテキスト */
		MSG_TEXT;
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
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmMessageDef> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmMessageDef object = new CmmMessageDef();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageDef object) {
		if (map == null) { return; }
		object.setMsgId((String) map.get(COLUMNS.MSG_ID));
		object.setMsgCat((String) map.get(COLUMNS.MSG_CAT));
		object.setMsgKind((String) map.get(COLUMNS.MSG_KIND));
		object.setMsgText((String) map.get(COLUMNS.MSG_TEXT));
	}
	*/

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
			data.put(COLUMNS.MSG_ID, object.getMsgId());
		}
		if (object.getMsgCat() != null) {
			data.put(COLUMNS.MSG_CAT, object.getMsgCat());
		}
		if (object.getMsgKind() != null) {
			data.put(COLUMNS.MSG_KIND, object.getMsgKind());
		}
		if (object.getMsgText() != null) {
			data.put(COLUMNS.MSG_TEXT, object.getMsgText());
		}
	}

	private static CmmMessageDefExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmMessageDefExample example = new CmmMessageDefExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSG_ID)) {
				String MSGCAT = (String) searchingOption.get(COLUMNS.MSG_ID);
				example.createCriteria().andMsgIdEqualTo(MSGCAT);
			}
			if (searchingOption.containsKey(COLUMNS.MSG_CAT)) {
				String MSGCAT = (String) searchingOption.get(COLUMNS.MSG_CAT);
				example.createCriteria().andMsgCatEqualTo(MSGCAT);
			}
		}
		return example;
	}

	private static CmmMessageDefExample makePartialMatchingExample(final Map<COLUMNS, String> searchingOption) {
		// WHERE clause
		CmmMessageDefExample example = new CmmMessageDefExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSG_ID)) {
				String MSGCAT = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.MSG_ID));
				example.createCriteria().andMsgIdLike(MSGCAT);
			}
			if (searchingOption.containsKey(COLUMNS.MSG_CAT)) {
				String MSGCAT = Converter.buildPartialMatchStringInSQL(searchingOption.get(COLUMNS.MSG_CAT));
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
	public static long countByPrimaryKey(final SqlSession session, final String msgId) {
		CmmMessageDefExample example = new CmmMessageDefExample();
		example.createCriteria().andMsgIdEqualTo(msgId);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmMessageDefDao.COLUMNS, Object> searchingOption) {
		CmmMessageDefExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmmMessageDefDao.COLUMNS, String> searchingOption) {
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
	public static Map<CmmMessageDefDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String msgId, final String msgCat) {
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		CmmMessageDef record = mapper.selectByPrimaryKey(msgId, msgCat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param cmmMessageDef
	 * @return
	 */
	public static List<Map<CmmMessageDefDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> cmmMessageDef) {
		CmmMessageDefExample example = makeEqualToMatchingExample(cmmMessageDef);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmMessageDefDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmmMessageDefDao.COLUMNS, String> searchingOption) {
		CmmMessageDefExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmMessageDefDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmMessageDefExample example = new CmmMessageDefExample();
		return select(session, example);
	}

	private static List<Map<CmmMessageDefDao.COLUMNS, Object>> select(final SqlSession session, final CmmMessageDefExample example) {
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
}
