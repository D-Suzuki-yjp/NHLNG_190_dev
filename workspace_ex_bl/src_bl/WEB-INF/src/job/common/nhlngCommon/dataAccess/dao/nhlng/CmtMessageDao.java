package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtMessage;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtMessageExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtMessageMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
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
	private static final String SEQNO_COLUMN_NAME = COLUMNS.SEQNO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** シーケンスNO */
		SEQNO("seq_no"),
		/** メッセージ日時 */
		MSGDATETIME,
		/** メッセージID */
		MSGID,
		/** メッセージカテゴリ */
		MSGCAT,
		/** メッセージ種別 */
		MSGKIND,
		/** メッセージテキスト */
		MSGTEXT,;

		private final String seq_no;

		private COLUMNS() {
			this.seq_no = this.name();
		}

		private COLUMNS(String seq_no) {
			this.seq_no = seq_no;
		}


		/**
		 * カラム名
		 *
		 * @return カラム名
		 */
		@Override
		public String toString() {
			return this.seq_no;
		}
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
		object.setMsgId((String) map.get(COLUMNS.MSGID));
		object.setMsgCat((String) map.get(COLUMNS.MSGCAT));
		object.setMsgKind((String) map.get(COLUMNS.MSGKIND));
		object.setMsgText((String) map.get(COLUMNS.MSGTEXT));

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
			data.put(COLUMNS.SEQNO, object.getSeqNo());
		}
		if (object.getMsgDatetime() != null) {
			data.put(COLUMNS.MSGDATETIME, object.getMsgDatetime());
		}
		if (object.getMsgId() != null) {
			data.put(COLUMNS.MSGID, object.getMsgId());
		}
		if (object.getMsgCat() != null) {
			data.put(COLUMNS.MSGCAT, object.getMsgCat());
		}
	}

	private static CmtMessageExample makeEqualToMatchingExample(final Map<COLUMNS, Integer> searchingOption) {
		// WHERE clause
		CmtMessageExample example = new CmtMessageExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SEQNO)) {
				Integer value = searchingOption.get(COLUMNS.SEQNO);
				example.createCriteria().andSeqNoEqualTo(value);
			}
		}
		return example;
	}

	private static CmtMessageExample makePartialMatchingExample(final Map<COLUMNS, Integer> searchingOption) {
		// WHERE clause
		CmtMessageExample example = new CmtMessageExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SEQNO)) {
				Integer value = searchingOption.get(COLUMNS.SEQNO);
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
	public static long countByPrimaryKey(final SqlSession session, final Integer id) {
		CmtMessageExample example = new CmtMessageExample();
		example.createCriteria().andSeqNoEqualTo(id);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmtMessageExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmtMessageExample example = makePartialMatchingExample(searchingOption);
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
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String id, String cat) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		CmtMessage record = mapper.selectByPrimaryKey(id,cat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	public static Map<COLUMNS, Object> selectByPrimaryKeyBetweenDB(final SqlSession session, final String id, String cat) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		CmtMessage record = mapper.selectByPrimaryKeyBetweenDB(id,cat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmtMessageExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmtMessageExample example = makePartialMatchingExample(searchingOption);
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
		// Validate.
		Validator.requireNonNull(data, "data");
		String id = (String) data.get(COLUMNS.SEQNO);
		Validator.requireNonNullAndNonEmpty(id, "id");

		// Make data.
		CmtMessage record = new CmtMessage();
		convertMapToModel(data, record);

		// Update.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String id) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.deleteByPrimaryKey(id);
	}

}
