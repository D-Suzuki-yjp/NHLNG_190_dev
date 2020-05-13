package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtApStat;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtApStatExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtApStatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtApStatDao アプリケーション状態DAO
 * @author D.Suzuki
 */
public class CmtApStatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String APNAME_COLUMN_NAME = COLUMNS.AP_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** SCCサーバ名 */
		SCC_SERVER_NAME,
		/** AP名 */
		AP_NAME,
		/** AP状態 */
		AP_STAT,
		/** AP状態フラグ */
		AP_STAT_FLG,
		/** AP状態更新日時 */
		AP_STAT_UPD_DTIME,;
	}

	static {
		TABLE_NAME = "CmtApStat";
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
	private CmtApStatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmtApStat> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmtApStat object = new CmtApStat();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtApStat object) {
		if (map == null) { return; }
		object.setSccServerName((String) map.get(COLUMNS.SCC_SERVER_NAME));
		object.setApName((String) map.get(COLUMNS.AP_NAME));
		object.setApStat((Integer) map.get(COLUMNS.AP_STAT));
		object.setApStatFlg((Integer) map.get(COLUMNS.AP_STAT_FLG));
		object.setApStatUpdDtime((Date) map.get(COLUMNS.AP_STAT_UPD_DTIME));
	}

	private static void convertModelListToMapList(final List<CmtApStat> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtApStat object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtApStat object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getSccServerName() != null) {
			data.put(COLUMNS.SCC_SERVER_NAME, object.getSccServerName());
		}
		if (object.getApName() != null) {
			data.put(COLUMNS.AP_NAME, object.getApName());
		}
		if (object.getApStat() != null) {
			data.put(COLUMNS.AP_STAT, object.getApStat());
		}
		if (object.getApStatFlg() != null) {
			data.put(COLUMNS.AP_STAT_FLG, object.getApStatFlg());
		}
		if (object.getApStatUpdDtime() != null) {
			data.put(COLUMNS.AP_STAT_UPD_DTIME, object.getApStatUpdDtime());
		}
	}

	private static CmtApStatExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtApStatExample example = new CmtApStatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCC_SERVER_NAME) && searchingOption.containsKey(COLUMNS.AP_NAME)) {
				String value1 = (String) searchingOption.get(COLUMNS.SCC_SERVER_NAME);
				String value2 = (String) searchingOption.get(COLUMNS.AP_NAME);
				example.createCriteria().andSccServerNameEqualTo(value1).andApNameEqualTo(value2);
			}
		}
		return example;
	}

	private static CmtApStatExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtApStatExample example = new CmtApStatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCC_SERVER_NAME) && searchingOption.containsKey(COLUMNS.AP_NAME)) {
				String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.SCC_SERVER_NAME));
				String value2 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.AP_NAME));
				example.createCriteria().andSccServerNameLike(value1).andApNameLike(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String apName) {
		CmtApStatExample example = new CmtApStatExample();
		example.createCriteria().andSccServerNameEqualTo(apName);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmtApStatDao.COLUMNS, Object> searchingOption) {
		CmtApStatExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmtApStatDao.COLUMNS, Object> searchingOption) {
		CmtApStatExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtApStatExample example = new CmtApStatExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtApStatExample example) {
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmtApStatDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String sccServerName, final String apName) {
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		CmtApStat record = mapper.selectByPrimaryKey(sccServerName, apName);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtApStatDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmtApStatDao.COLUMNS, Object> searchingOption) {
		CmtApStatExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtApStatDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmtApStatDao.COLUMNS, Object> searchingOption) {
		CmtApStatExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmtApStatDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtApStatExample example = new CmtApStatExample();
		return select(session, example);
	}

	private static List<Map<CmtApStatDao.COLUMNS, Object>> select(final SqlSession session, final CmtApStatExample example) {
		// ORDER BY clause
		example.setOrderByClause(APNAME_COLUMN_NAME);

		// Select.
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		List<CmtApStat> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<CmtApStatDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = (String) data.get(COLUMNS.SCC_SERVER_NAME);
		String apName = (String) data.get(COLUMNS.AP_NAME);
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");
		Validator.requireNonNullAndNonEmpty(apName, "apName");

		// Make data.
		CmtApStat record = new CmtApStat();
		convertMapToModel(data, record);

		// Insert.
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<CmtApStatDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = data.get(COLUMNS.SCC_SERVER_NAME).toString();
		String apName = (String) data.get(COLUMNS.AP_NAME).toString();
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");
		Validator.requireNonNullAndNonEmpty(apName, "apName");

		// Make data.
		CmtApStat record = new CmtApStat();
		convertMapToModel(data, record);

		// Update.
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String sccServerName, final String apName) {
		CmtApStatMapper mapper = session.getMapper(CmtApStatMapper.class);
		return mapper.deleteByPrimaryKey(sccServerName, apName);
	}

}
