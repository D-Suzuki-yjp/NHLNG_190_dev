package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.StmDensCorr;
import job.common.nhlngCommon.dataAccess.entity.nhlng.StmDensCorrExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.StmDensCorrMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * StmDensCorrDao 液密度補正量マスタDAO
 * @author D.Suzuki
 */
public class StmDensCorrDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String DENSFROM_COLUMN_NAME = COLUMNS.DENS_FROM.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 液密度FROM */
		DENS_FROM,
		/** 液密度TO */
		DENS_TO,
		/** 補正量（正） */
		CORR_QTY_MAIN,
		/** 補正量（副） */
		CORR_QTY_SUB;
	}

	static {
		TABLE_NAME = "StmDensCorr";
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
	private StmDensCorrDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<StmDensCorr> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			StmDensCorr object = new StmDensCorr();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final StmDensCorr object) {
		if (map == null) { return; }
		object.setDensFrom((BigDecimal) map.get(COLUMNS.DENS_FROM));
		object.setDensTo((BigDecimal) map.get(COLUMNS.DENS_TO));
		object.setCorrQtyMain((BigDecimal) map.get(COLUMNS.CORR_QTY_MAIN));
		object.setCorrQtySub((BigDecimal) map.get(COLUMNS.CORR_QTY_SUB));
	}

	private static void convertModelListToMapList(final List<StmDensCorr> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (StmDensCorr object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final StmDensCorr object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getDensFrom() != null) {
			data.put(COLUMNS.DENS_FROM, object.getDensFrom());
		}
		if (object.getDensTo() != null) {
			data.put(COLUMNS.DENS_TO, object.getDensTo());
		}
		if (object.getCorrQtyMain() != null) {
			data.put(COLUMNS.CORR_QTY_MAIN, object.getCorrQtyMain());
		}
		if (object.getCorrQtySub() != null) {
			data.put(COLUMNS.CORR_QTY_SUB, object.getCorrQtySub());
		}
	}

	private static StmDensCorrExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		StmDensCorrExample example = new StmDensCorrExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.DENS_FROM)) {
				BigDecimal value = (BigDecimal) searchingOption.get(COLUMNS.DENS_FROM);
				example.createCriteria().andDensFromEqualTo(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final BigDecimal densFrom) {
		StmDensCorrExample example = new StmDensCorrExample();
		example.createCriteria().andDensFromEqualTo(densFrom);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<StmDensCorrDao.COLUMNS, Object> searchingOption) {
		StmDensCorrExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		StmDensCorrExample example = new StmDensCorrExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final StmDensCorrExample example) {
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<StmDensCorrDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final BigDecimal densFrom) {
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		StmDensCorr record = mapper.selectByPrimaryKey(densFrom);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<StmDensCorrDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<StmDensCorrDao.COLUMNS, Object> searchingOption) {
		StmDensCorrExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<StmDensCorrDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		StmDensCorrExample example = new StmDensCorrExample();
		return select(session, example);
	}

	private static List<Map<StmDensCorrDao.COLUMNS, Object>> select(final SqlSession session, final StmDensCorrExample example) {
		// ORDER BY clause
		example.setOrderByClause(DENSFROM_COLUMN_NAME);

		// Select.
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		List<StmDensCorr> recordList = mapper.selectByExample(example);

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
	public static int insert(final SqlSession session, final Map<StmDensCorrDao.COLUMNS, Object> data) {
		// Make data.
		StmDensCorr record = new StmDensCorr();
		convertMapToModel(data, record);

		// Insert.
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String densFrom = (String) data.get(COLUMNS.DENS_FROM);
		Validator.requireNonNullAndNonEmpty(densFrom, "densFrom");

		// Make data.
		StmDensCorr record = new StmDensCorr();
		convertMapToModel(data, record);

		// Update.
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final BigDecimal densFrom) {
		StmDensCorrMapper mapper = session.getMapper(StmDensCorrMapper.class);
		return mapper.deleteByPrimaryKey(densFrom);
	}

}
