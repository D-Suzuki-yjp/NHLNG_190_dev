package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageTag;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageTagExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmMessageTagMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageTagDao メッセージタグ出力マスタDAO
 * @author D.Suzuki
 */
public class CmmMessageTagDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TAGVAL_COLUMN_NAME = COLUMNS.SEQNO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージID */
		MSGID,
		/** シーケンスNO */
		SEQNO("seq_no"),
		/** タグNO */
		TAGNO,
		/** タグ値 */
		TAGVAL,;

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
		TABLE_NAME = "CmmMessageTag";
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
	private CmmMessageTagDao() {
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

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageTag object) {
		if (map == null) { return; }
		object.setMsgId((String) map.get(COLUMNS.MSGID));
		object.setSeqNo((Integer) map.get(COLUMNS.SEQNO));
		object.setTagNo((String) map.get(COLUMNS.TAGNO));
		object.setTagVal((BigDecimal) map.get(COLUMNS.TAGVAL));
	}

	private static void convertModelListToMapList(final List<CmmMessageTag> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmMessageTag object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmMessageTag object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getMsgId() != null) {
			data.put(COLUMNS.MSGID, object.getMsgId());
		}
		if (object.getSeqNo() != null) {
			data.put(COLUMNS.SEQNO, object.getSeqNo());
		}
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAGNO, object.getTagNo());
		}
		if (object.getTagVal() != null) {
			data.put(COLUMNS.TAGVAL, object.getTagVal());
		}
	}

	private static CmmMessageTagExample makeEqualToMatchingExample(final Map<COLUMNS, Integer> searchingOption) {
		// WHERE clause
		CmmMessageTagExample example = new CmmMessageTagExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SEQNO)) {
				Integer value = searchingOption.get(COLUMNS.SEQNO);
				example.createCriteria().andSeqNoEqualTo(value);
			}
		}
		return example;
	}

	private static CmmMessageTagExample makePartialMatchingExample(final Map<COLUMNS, Integer> searchingOption) {
		// WHERE clause
		CmmMessageTagExample example = new CmmMessageTagExample();
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
	public static long countByPrimaryKey(final SqlSession session, final String id) {
		CmmMessageTagExample example = new CmmMessageTagExample();
		example.createCriteria().andMsgIdEqualTo(id);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmmMessageTagExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmmMessageTagExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmMessageTagExample example = new CmmMessageTagExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmMessageTagExample example) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String id, final Integer seq, final String cat) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		CmmMessageTag record = mapper.selectByPrimaryKey(id, seq, cat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectByMsgId(final SqlSession session, final String msgId, final String msgCat) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		List<CmmMessageTag> recordList = mapper.selectByMsgId(msgId, msgCat);

		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static Map<COLUMNS, Object> selectByPrimaryKeyBetweenDB(final SqlSession session, final String id, final Integer seq, final String cat) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		CmmMessageTag record = mapper.selectByPrimaryKeyBetweenDB(id, seq, cat);

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
		CmmMessageTagExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, Integer> searchingOption) {
		CmmMessageTagExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmMessageTagExample example = new CmmMessageTagExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmmMessageTagExample example) {
		// ORDER BY clause
		example.setOrderByClause(TAGVAL_COLUMN_NAME);

		// Select.
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		List<CmmMessageTag> recordList = mapper.selectByExample(example);

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
		CmmMessageTag record = new CmmMessageTag();
		convertMapToModel(data, record);

		// Insert.
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String id = (String) data.get(COLUMNS.MSGID);
		Validator.requireNonNullAndNonEmpty(id, "id");

		// Make data.
		CmmMessageTag record = new CmmMessageTag();
		convertMapToModel(data, record);

		// Update.
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String id) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		return mapper.deleteByPrimaryKey(id);
	}

}
