package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmCalc;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmCalcExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmCalcMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmCalcDao 計算マスタDAO
 * @author D.Suzuki
 */
public class CmmCalcDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String REPORTKIND_COLUMN_NAME = COLUMNS.HISTORY_KIND.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 帳票区分 */
		HISTORY_KIND,
		/** 自動フラグ */
		TAG_NO,
		/** 印刷時刻 */
		CALC_KIND,
		/** 係数2 */
		CALC_INFO,
		/** 係数2 */
		CALC_PRIORITY;
	}

	static {
		TABLE_NAME = "CmmCalc";
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
	private CmmCalcDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmCalc> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmCalc object = new CmmCalc();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmCalc object) {
		if (map == null) { return; }
		object.setHistoryKind((Integer) map.get(COLUMNS.HISTORY_KIND));
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		object.setCalcKind((String) map.get(COLUMNS.CALC_KIND));
		object.setCalcInfo((String) map.get(COLUMNS.CALC_INFO));
		object.setCalcPriority((Integer) map.get(COLUMNS.CALC_PRIORITY));
	}
	*/

	private static void convertModelListToMapList(final List<CmmCalc> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmCalc object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmCalc object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getHistoryKind() != null) {
			data.put(COLUMNS.HISTORY_KIND, object.getHistoryKind());
		}
		if (object.getTagNo() != null) {
		data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getCalcKind() != null) {
			data.put(COLUMNS.CALC_KIND, object.getCalcKind());
		}
		if (object.getCalcInfo() != null) {
			data.put(COLUMNS.CALC_INFO, object.getCalcInfo());
		}
		if (object.getCalcPriority() != null) {
			data.put(COLUMNS.CALC_PRIORITY, object.getCalcPriority());
		}
	}

	private static CmmCalcExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmCalcExample example = new CmmCalcExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.HISTORY_KIND)) {
				Integer value = (Integer) searchingOption.get(COLUMNS.HISTORY_KIND);
				example.createCriteria().andHistoryKindEqualTo(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final Integer reportKind) {
		CmmCalcExample example = new CmmCalcExample();
		example.createCriteria().andHistoryKindEqualTo(reportKind);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmCalcDao.COLUMNS, Object> searchingOption) {
		CmmCalcExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmCalcExample example = new CmmCalcExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmCalcExample example) {
		CmmCalcMapper mapper = session.getMapper(CmmCalcMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmCalcDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmCalcDao.COLUMNS, Object> searchingOption) {
		CmmCalcExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmCalcDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmCalcExample example = new CmmCalcExample();
		return select(session, example);
	}

	private static List<Map<CmmCalcDao.COLUMNS, Object>> select(final SqlSession session, final CmmCalcExample example) {
		// ORDER BY clause
		example.setOrderByClause(REPORTKIND_COLUMN_NAME);

		// Select.
		CmmCalcMapper mapper = session.getMapper(CmmCalcMapper.class);
		List<CmmCalc> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<CmmCalcDao.COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
