package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmGpaConst;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmGpaConstExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmGpaConstMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmGpaConstDao GPA定数マスタDAO
 * @author D.Suzuki
 */
public class CmmGpaConstDao {

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
		/** 総発熱量 */
		HEAT_VAL,
		/** 標準比重 */
		STD_SG,
		/** 標準密度 */
		NOR_DENS;
	}

	static {
		TABLE_NAME = "CmmGpaConst";
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
	private CmmGpaConstDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmGpaConst> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmGpaConst object = new CmmGpaConst();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmGpaConst object) {
		if (map == null) { return; }
		object.setCmpnt((Integer) map.get(COLUMNS.CMPNT));
		object.setHeatVal((Integer) map.get(COLUMNS.HEAT_VAL));
		object.setStdSg((BigDecimal) map.get(COLUMNS.STD_SG));
		object.setNorDens((BigDecimal) map.get(COLUMNS.NOR_DENS));
	}
	*/

	private static void convertModelListToMapList(final List<CmmGpaConst> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmGpaConst object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmGpaConst object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getCmpnt() != null) {
			data.put(COLUMNS.CMPNT, object.getCmpnt());
		}
		if (object.getHeatVal() != null) {
			data.put(COLUMNS.HEAT_VAL, object.getHeatVal());
		}
		if (object.getStdSg() != null) {
			data.put(COLUMNS.STD_SG, object.getStdSg());
		}
		if (object.getNorDens() != null) {
			data.put(COLUMNS.NOR_DENS, object.getNorDens());
		}
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final Integer cmpnt) {
		CmmGpaConstExample example = new CmmGpaConstExample();
		example.createCriteria().andCmpntEqualTo(cmpnt);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmGpaConstExample example = new CmmGpaConstExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmGpaConstExample example) {
		CmmGpaConstMapper mapper = session.getMapper(CmmGpaConstMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmmGpaConstDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final Integer cmpnt) {
		CmmGpaConstMapper mapper = session.getMapper(CmmGpaConstMapper.class);
		CmmGpaConst record = mapper.selectByPrimaryKey(cmpnt);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmGpaConstDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmGpaConstExample example = new CmmGpaConstExample();
		return select(session, example);
	}

	private static List<Map<CmmGpaConstDao.COLUMNS, Object>> select(final SqlSession session, final CmmGpaConstExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMPNT_COLUMN_NAME);

		// Select.
		CmmGpaConstMapper mapper = session.getMapper(CmmGpaConstMapper.class);
		List<CmmGpaConst> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
