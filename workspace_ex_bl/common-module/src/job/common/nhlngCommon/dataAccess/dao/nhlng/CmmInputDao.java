package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmInput;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmInputExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmInputMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmInputDao 入力データマスタDAO
 * @author D.Suzuki
 */
public class CmmInputDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String REPORTKIND_COLUMN_NAME = COLUMNS.TAG_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** タグNO */
		TAG_NO,
		/** 締切種別 */
		HISTORY_KIND,
		/** シーケンスNO */
		SEQ_NO,
		/** 入力タイプ */
		INPUT_TYPE,
		/** 入力タグ  */
		INPUT_TAG_NO;
	}

	static {
		TABLE_NAME = "CmmInput";
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
	private CmmInputDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmInput> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmInput object = new CmmInput();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmInput object) {
		if (map == null) { return; }
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		object.setHistoryKind((Integer) map.get(COLUMNS.HISTORY_KIND));
		object.setSeqNo((Integer) map.get(COLUMNS.SEQ_NO));
		object.setInputType((Integer) map.get(COLUMNS.INPUT_TYPE));
		object.setInputTagNo((String) map.get(COLUMNS.INPUT_TAG_NO));
	}
	*/

	private static void convertModelListToMapList(final List<CmmInput> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmInput object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmInput object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getHistoryKind() != null) {
		data.put(COLUMNS.HISTORY_KIND, object.getHistoryKind());
		}
		if (object.getSeqNo() != null) {
		data.put(COLUMNS.SEQ_NO, object.getSeqNo());
		}
		if (object.getInputType() != null) {
		data.put(COLUMNS.INPUT_TYPE, object.getInputType());
		}
		if (object.getInputTagNo() != null) {
			data.put(COLUMNS.INPUT_TAG_NO, object.getInputTagNo());
		}
	}

	private static CmmInputExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmInputExample example = new CmmInputExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TAG_NO)) {
				String value = (String) searchingOption.get(COLUMNS.TAG_NO);
				example.createCriteria().andTagNoEqualTo(value);
			}
		}
		return example;
	}

	private static CmmInputExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmInputExample example = new CmmInputExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TAG_NO)) {
				String value = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.TAG_NO));
				example.createCriteria().andTagNoLike(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String reportKind) {
		CmmInputExample example = new CmmInputExample();
		example.createCriteria().andTagNoEqualTo(reportKind);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmInputDao.COLUMNS, Object> searchingOption) {
		CmmInputExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmmInputDao.COLUMNS, Object> searchingOption) {
		CmmInputExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmInputExample example = new CmmInputExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmInputExample example) {
		CmmInputMapper mapper = session.getMapper(CmmInputMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmInputDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmInputDao.COLUMNS, Object> searchingOption) {
		CmmInputExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmInputDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmmInputDao.COLUMNS, Object> searchingOption) {
		CmmInputExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmInputDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmInputExample example = new CmmInputExample();
		return select(session, example);
	}

	private static List<Map<CmmInputDao.COLUMNS, Object>> select(final SqlSession session, final CmmInputExample example) {
		// ORDER BY clause
		example.setOrderByClause(REPORTKIND_COLUMN_NAME);

		// Select.
		CmmInputMapper mapper = session.getMapper(CmmInputMapper.class);
		List<CmmInput> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<CmmInputDao.COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
