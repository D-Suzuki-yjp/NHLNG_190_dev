package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmJisConst;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmJisConstExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmJisConstMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmJisConstDao JIS定数マスタDAO
 * @author D.Suzuki
 */
public class CmmJisConstDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CMPNT_COLUMN_NAME = COLUMNS.CMPNT.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 成分 */
		CMPNT,
		/** 分子量 */
		MOLWT,
		/** 圧縮係数 */
		COMPCOEF,
		/** 総発熱量 */
		HEAT_VAL;
	}

	static {
		TABLE_NAME = "CmmJisConst";
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
	private CmmJisConstDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmJisConst> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmJisConst object = new CmmJisConst();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmJisConst object) {
		if (map == null) { return; }
		object.setCmpnt((Integer) map.get(COLUMNS.CMPNT));
		object.setMolwt((BigDecimal) map.get(COLUMNS.MOLWT));
		object.setCompCoef((BigDecimal) map.get(COLUMNS.COMPCOEF));
		object.setHeatVal((BigDecimal) map.get(COLUMNS.HEAT_VAL));
	}
	*/

	private static void convertModelListToMapList(final List<CmmJisConst> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmJisConst object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmJisConst object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getCmpnt() != null) {
			data.put(COLUMNS.CMPNT, object.getCmpnt());
		}
		if (object.getMolwt() != null) {
			data.put(COLUMNS.MOLWT, object.getMolwt());
		}
		if (object.getCompCoef() != null) {
			data.put(COLUMNS.COMPCOEF, object.getCompCoef());
		}
		if (object.getHeatVal() != null) {
			data.put(COLUMNS.HEAT_VAL, object.getHeatVal());
		}
	}

	private static CmmJisConstExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmJisConstExample example = new CmmJisConstExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.CMPNT)) {
				Integer value = (Integer) searchingOption.get(COLUMNS.CMPNT);
				example.createCriteria().andCmpntEqualTo(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final Integer cmpnt) {
		CmmJisConstExample example = new CmmJisConstExample();
		example.createCriteria().andCmpntEqualTo(cmpnt);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmJisConstDao.COLUMNS, Object> searchingOption) {
		CmmJisConstExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmJisConstExample example = new CmmJisConstExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmJisConstExample example) {
		CmmJisConstMapper mapper = session.getMapper(CmmJisConstMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmmJisConstDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final Integer cmpnt) {
		CmmJisConstMapper mapper = session.getMapper(CmmJisConstMapper.class);
		CmmJisConst record = mapper.selectByPrimaryKey(cmpnt);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmJisConstDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmJisConstDao.COLUMNS, Object> searchingOption) {
		CmmJisConstExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmJisConstDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmJisConstExample example = new CmmJisConstExample();
		return select(session, example);
	}

	private static List<Map<CmmJisConstDao.COLUMNS, Object>> select(final SqlSession session, final CmmJisConstExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMPNT_COLUMN_NAME);

		// Select.
		CmmJisConstMapper mapper = session.getMapper(CmmJisConstMapper.class);
		List<CmmJisConst> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
