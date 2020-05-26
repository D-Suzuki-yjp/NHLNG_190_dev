package job.sfcommon.dataaccess.dao.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmtMessage;
import job.sfcommon.dataaccess.entity.nhlng.CmtMessageExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtMessageMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtMessageDao メッセージデータDAO
 * @author D.Suzuki
 */

public class CmtMessageDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SEQNO_COLUMN_NAME = COLUMNS.SEQ_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** シーケンスNO */
		SEQ_NO,
		/** メッセージ日時 */
		MSG_DATETIME,
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
		TABLE_NAME = "CmtMessage";
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
	private CmtMessageDao() {
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

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtMessage object) {
		if (map == null) { return; }
		object.setSeqNo((Integer) map.get(COLUMNS.SEQ_NO));
		object.setMsgDatetime((Date) map.get(COLUMNS.MSG_DATETIME));
		object.setMsgId((String) map.get(COLUMNS.MSG_ID));
		object.setMsgCat((String) map.get(COLUMNS.MSG_CAT));
		object.setMsgKind((String) map.get(COLUMNS.MSG_KIND));
		object.setMsgText((String) map.get(COLUMNS.MSG_TEXT));

	}

	private static void convertModelListToMapList(final List<CmtMessage> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtMessage object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtMessage object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getSeqNo() != null) {
			data.put(COLUMNS.SEQ_NO, object.getSeqNo());
		}
		if (object.getMsgDatetime() != null) {
			data.put(COLUMNS.MSG_DATETIME, object.getMsgDatetime());
		}
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

	private static CmtMessageExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtMessageExample example = new CmtMessageExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SEQ_NO)) {
				Integer value = (Integer) searchingOption.get(COLUMNS.SEQ_NO);
				example.createCriteria().andSeqNoEqualTo(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final Integer seqNo) {
		CmtMessageExample example = new CmtMessageExample();
		example.createCriteria().andSeqNoEqualTo(seqNo);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtMessageExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtMessageExample example = new CmtMessageExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtMessageExample example) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final Integer seqNo, final String msgCat) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		CmtMessage record = mapper.selectByPrimaryKey(seqNo, msgCat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	public static Map<COLUMNS, Object> selectByPrimaryKeyBetweenDB(final SqlSession session, final Integer seqNo, final String msgCat) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		CmtMessage record = mapper.selectByPrimaryKeyBetweenDB(seqNo, msgCat);

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
		CmtMessageExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtMessageExample example = new CmtMessageExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmtMessageExample example) {
		// ORDER BY clause
		example.setOrderByClause(SEQNO_COLUMN_NAME);

		// Select.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		List<CmtMessage> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	/**
	 * メッセージデータinsert
	 * @param session  SQLセッション
	 * @param data  メッセージデータ
	 * @return int insert件数
	 */
	public static int insert(final SqlSession session, final Map<CmtMessageDao.COLUMNS, Object> data) {

		// Make data.
		CmtMessage record = new CmtMessage();
		convertMapToModel(data, record);

		// Insert.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Make data.
		CmtMessage record = new CmtMessage();
		convertMapToModel(data, record);

		// Update.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final Integer seqNo, final String msgCat) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.deleteByPrimaryKey(seqNo, msgCat);
	}
}
