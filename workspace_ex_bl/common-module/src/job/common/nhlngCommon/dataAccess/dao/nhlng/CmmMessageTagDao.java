package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageTag;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageTagExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmMessageTagMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
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
	private static final String MSGID_COLUMN_NAME = COLUMNS.MSG_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージID */
		MSG_ID,
		/** シーケンスNO */
		SEQ_NO,
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_VAL;
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
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmMessageTag> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmMessageTag object = new CmmMessageTag();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageTag object) {
		if (map == null) { return; }
		object.setMsgId((String) map.get(COLUMNS.MSG_ID));
		object.setSeqNo((Integer) map.get(COLUMNS.SEQ_NO));
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		object.setTagVal((BigDecimal) map.get(COLUMNS.TAG_VAL));
	}
	*/

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
			data.put(COLUMNS.MSG_ID, object.getMsgId());
		}
		if (object.getSeqNo() != null) {
			data.put(COLUMNS.SEQ_NO, object.getSeqNo());
		}
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getTagVal() != null) {
			data.put(COLUMNS.TAG_VAL, object.getTagVal());
		}
	}

	private static CmmMessageTagExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmMessageTagExample example = new CmmMessageTagExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSG_ID)) {
				String value1 = (String) searchingOption.get(COLUMNS.MSG_ID);
				example.createCriteria().andMsgIdEqualTo(value1);
			}
			if (searchingOption.containsKey(COLUMNS.SEQ_NO)) {
				Integer value2 = (Integer) searchingOption.get(COLUMNS.SEQ_NO);
				example.createCriteria().andSeqNoEqualTo(value2);
			}
		}
		return example;
	}

	private static CmmMessageTagExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmMessageTagExample example = new CmmMessageTagExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.MSG_ID)) {
				String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.MSG_ID));
				example.createCriteria().andMsgCatLike(value1);
			}
			if (searchingOption.containsKey(COLUMNS.SEQ_NO)) {
				Integer value2 = (Integer) searchingOption.get(COLUMNS.SEQ_NO);
				example.createCriteria().andSeqNoEqualTo(value2);
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
		CmmMessageTagExample example = new CmmMessageTagExample();
		example.createCriteria().andMsgIdEqualTo(msgId);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmMessageTagDao.COLUMNS, Object> searchingOption) {
		CmmMessageTagExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmmMessageTagDao.COLUMNS, Object> searchingOption) {
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
	public static Map<CmmMessageTagDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String msgId, final Integer seqNo, final String msgCat) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		CmmMessageTag record = mapper.selectByPrimaryKey(msgId, seqNo, msgCat);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static List<Map<CmmMessageTagDao.COLUMNS, Object>> selectByMsgId(final SqlSession session, final String msgId, final String msgCat) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		List<CmmMessageTag> recordList = mapper.selectByMsgId(msgId, msgCat);

		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmMessageTagDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmMessageTagDao.COLUMNS, Object> searchingOption) {
		CmmMessageTagExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmMessageTagDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmmMessageTagDao.COLUMNS, Object> searchingOption) {
		CmmMessageTagExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmMessageTagDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmMessageTagExample example = new CmmMessageTagExample();
		return select(session, example);
	}

	private static List<Map<CmmMessageTagDao.COLUMNS, Object>> select(final SqlSession session, final CmmMessageTagExample example) {
		// ORDER BY clause
		example.setOrderByClause(MSGID_COLUMN_NAME);

		// Select.
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		List<CmmMessageTag> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
