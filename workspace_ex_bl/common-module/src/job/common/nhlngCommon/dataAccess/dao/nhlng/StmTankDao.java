package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.StmTank;
import job.common.nhlngCommon.dataAccess.entity.nhlng.StmTankExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.StmTankMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * StmTankDao タンクマスタDAO
 * @author D.Suzuki
 */
public class StmTankDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TANKNO_COLUMN_NAME = COLUMNS.TANK_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 設定NO */
		TANK_NO,
		/** 書込タグNO */
		LVL_GAUGE_FROM,
		/** 読込タグNO */
		LVL_GAUGE_TO,
		/** 書込タグNO */
		COEF1,
		/** 書込タグNO */
		COEF2;
	}

	static {
		TABLE_NAME = "StmTank";
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
	private StmTankDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<StmTank> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			StmTank object = new StmTank);
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final StmTank object) {
		if (map == null) { return; }
		object.setTankNo((Integer) map.get(COLUMNS.TANK_NO));
		object.setLvlGaugeFrom((Integer) map.get(COLUMNS.LVL_GAUGE_FROM));
		object.setLvlGaugeTo((Integer) map.get(COLUMNS.LVL_GAUGE_TO));
		object.setCoef1((BigDecimal) map.get(COLUMNS.COEF1));
		object.setCoef2((BigDecimal) map.get(COLUMNS.COEF2));
	}

	private static void convertModelListToMapList(final List<StmTank> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (StmTank object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final StmTank object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getLvlGaugeFrom() != null) {
			data.put(COLUMNS.TANK_NO, object.getTankNo());
		}
		if (object.getLvlGaugeFrom() != null) {
			data.put(COLUMNS.LVL_GAUGE_FROM, object.getLvlGaugeFrom());
		}
		if (object.getLvlGaugeTo() != null) {
			data.put(COLUMNS.LVL_GAUGE_TO, object.getLvlGaugeTo());
		}
		if (object.getCoef1() != null) {
			data.put(COLUMNS.COEF1, object.getCoef1());
		}
		if (object.getCoef2() != null) {
			data.put(COLUMNS.COEF2, object.getCoef2());
		}
	}

	private static StmTankExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		StmTankExample example = new StmTankExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TANK_NO) && searchingOption.containsKey(COLUMNS.LVL_GAUGE_FROM)) {
				Integer value1 = (Integer) searchingOption.get(COLUMNS.TANK_NO);
				Integer value2 = (Integer) searchingOption.get(COLUMNS.LVL_GAUGE_FROM);
				example.createCriteria().andTankNoEqualTo(value1).andLvlGaugeFromEqualTo(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final int tankNo) {
		StmTankExample example = new StmTankExample();
		example.createCriteria().andTankNoEqualTo(tankNo);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<StmTankDao.COLUMNS, Object> searchingOption) {
		StmTankExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		StmTankExample example = new StmTankExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final StmTankExample example) {
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<StmTankDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final int tankNo, final BigDecimal lvlGaugeFrom) {
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		StmTank record = mapper.selectByPrimaryKey(tankNo, lvlGaugeFrom);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<StmTankDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<StmTankDao.COLUMNS, Object> searchingOption) {
		StmTankExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<StmTankDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		StmTankExample example = new StmTankExample();
		return select(session, example);
	}

	private static List<Map<StmTankDao.COLUMNS, Object>> select(final SqlSession session, final StmTankExample example) {
		// ORDER BY clause
		example.setOrderByClause(TANKNO_COLUMN_NAME);

		// Select.
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		List<StmTank> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<StmTankDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tankNo = data.get(COLUMNS.TANK_NO).toString();
		String lvlGaugeFrom = data.get(COLUMNS.LVL_GAUGE_FROM).toString();
		Validator.requireNonNullAndNonEmpty(tankNo, "tankNo");
		Validator.requireNonNullAndNonEmpty(lvlGaugeFrom, "lvlGaugeFrom");

		// Make data.
		StmTank record = new StmTank();
		convertMapToModel(data, record);

		// Insert.
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<StmTankDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tankNo = data.get(COLUMNS.TANK_NO).toString();
		String lvlGaugeFrom = data.get(COLUMNS.LVL_GAUGE_FROM).toString();
		Validator.requireNonNullAndNonEmpty(tankNo, "tankNo");
		Validator.requireNonNullAndNonEmpty(lvlGaugeFrom, "lvlGaugeFrom");

		// Make data.
		StmTank record = new StmTank();
		convertMapToModel(data, record);

		// Update.
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final int tankNo, final BigDecimal lvlGaugeFrom) {
		StmTankMapper mapper = session.getMapper(StmTankMapper.class);
		return mapper.deleteByPrimaryKey(tankNo, lvlGaugeFrom);
	}

}
