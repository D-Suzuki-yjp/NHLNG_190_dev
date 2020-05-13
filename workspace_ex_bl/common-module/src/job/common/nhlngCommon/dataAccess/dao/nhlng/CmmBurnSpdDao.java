package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmBurnSpd;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmBurnSpdExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmBurnSpdMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmBurnSpdDao 燃焼速度マスタDAO
 * @author D.Suzuki
 */
public class CmmBurnSpdDao {

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
		/** 燃焼速度 */
		BURN_SPD,
		/** 係数1 */
		COEF1,
		/** 係数2 */
		COEF2;
	}

	static {
		TABLE_NAME = "CmmBurnSpd";
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
	private CmmBurnSpdDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmBurnSpd> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmBurnSpd object = new CmmBurnSpd();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmBurnSpd object) {
		if (map == null) { return; }
		object.setCmpnt((Integer) map.get(COLUMNS.CMPNT));
		object.setBurnSpd((Integer) map.get(COLUMNS.BURN_SPD));
		object.setCoef1((BigDecimal) map.get(COLUMNS.COEF1));
		object.setCoef2((BigDecimal) map.get(COLUMNS.COEF2));
	}
	*/

	private static void convertModelListToMapList(final List<CmmBurnSpd> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmBurnSpd object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmBurnSpd object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getCmpnt() != null) {
			data.put(COLUMNS.CMPNT, object.getCmpnt());
		}
		if (object.getBurnSpd() != null) {
			data.put(COLUMNS.BURN_SPD, object.getBurnSpd());
		}
		if (object.getCoef1() != null) {
			data.put(COLUMNS.COEF1, object.getCoef1());
		}
		if (object.getCoef2() != null) {
			data.put(COLUMNS.COEF2, object.getCoef2());
		}
	}

	private static CmmBurnSpdExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmBurnSpdExample example = new CmmBurnSpdExample();
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
		CmmBurnSpdExample example = new CmmBurnSpdExample();
		example.createCriteria().andCmpntEqualTo(cmpnt);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmBurnSpdDao.COLUMNS, Object> searchingOption) {
		CmmBurnSpdExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmBurnSpdExample example = new CmmBurnSpdExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmBurnSpdExample example) {
		CmmBurnSpdMapper mapper = session.getMapper(CmmBurnSpdMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmmBurnSpdDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final Integer cmpnt) {
		CmmBurnSpdMapper mapper = session.getMapper(CmmBurnSpdMapper.class);
		CmmBurnSpd record = mapper.selectByPrimaryKey(cmpnt);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmBurnSpdDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmBurnSpdDao.COLUMNS, Object> searchingOption) {
		CmmBurnSpdExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmBurnSpdDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmBurnSpdExample example = new CmmBurnSpdExample();
		return select(session, example);
	}

	private static List<Map<CmmBurnSpdDao.COLUMNS, Object>> select(final SqlSession session, final CmmBurnSpdExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMPNT_COLUMN_NAME);

		// Select.
		CmmBurnSpdMapper mapper = session.getMapper(CmmBurnSpdMapper.class);
		List<CmmBurnSpd> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
