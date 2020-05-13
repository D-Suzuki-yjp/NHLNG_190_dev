package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtComStat;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtComStatExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtComStatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtComStatDao 通信状態DAO
 * @author D.Suzuki
 */
public class CmtComStatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String COMHOSTNAME_COLUMN_NAME = COLUMNS.COM_HOST_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** SCCサーバ名 */
		SCC_SERVER_NAME,
		/** 通信ホスト名 */
		COM_HOST_NAME,
		/** 通信状態  */
		COM_STAT,
		/** 通信状態更新日時 */
		COM_STATUPD_DTIME,
		/** 監視対象フラグ  */
		WATCH_TARGET_FLAG,;
	}

	static {
		TABLE_NAME = "CmtComStat";
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
	private CmtComStatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmtComStat> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmtComStat object = new CmtComStat();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtComStat object) {
		if (map == null) { return; }
		object.setSccServerName((String) map.get(COLUMNS.SCC_SERVER_NAME));
		object.setComHostName((String) map.get(COLUMNS.COM_HOST_NAME));
		object.setComStat((Integer) map.get(COLUMNS.COM_STAT));
		object.setComStatUpdDtime((Date) map.get(COLUMNS.COM_STATUPD_DTIME));
		object.setWatchTargetFlag((Integer) map.get(COLUMNS.WATCH_TARGET_FLAG));
	}

	private static void convertModelListToMapList(final List<CmtComStat> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtComStat object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtComStat object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getSccServerName() != null) {
			data.put(COLUMNS.SCC_SERVER_NAME, object.getSccServerName());
		}
		if (object.getComHostName() != null) {
			data.put(COLUMNS.COM_HOST_NAME, object.getComHostName());
		}
		if (object.getComStat() != null) {
			data.put(COLUMNS.COM_STAT, object.getComStat());
		}
		if (object.getComStatUpdDtime() != null) {
			data.put(COLUMNS.COM_STATUPD_DTIME, object.getComStatUpdDtime());
		}
		if (object.getWatchTargetFlag() != null) {
			data.put(COLUMNS.WATCH_TARGET_FLAG, object.getWatchTargetFlag());
		}
	}

	private static CmtComStatExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtComStatExample example = new CmtComStatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCC_SERVER_NAME) && searchingOption.containsKey(COLUMNS.COM_HOST_NAME)) {
				String value1 = (String) searchingOption.get(COLUMNS.SCC_SERVER_NAME);
				String value2 = (String) searchingOption.get(COLUMNS.COM_HOST_NAME);
				example.createCriteria().andSccServerNameEqualTo(value1).andComHostNameEqualTo(value2);
			}
		}
		return example;
	}

	private static CmtComStatExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtComStatExample example = new CmtComStatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCC_SERVER_NAME) && searchingOption.containsKey(COLUMNS.COM_HOST_NAME)) {
				String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.SCC_SERVER_NAME));
				String value2 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.COM_HOST_NAME));
				example.createCriteria().andSccServerNameLike(value1).andComHostNameLike(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String comHostName) {
		CmtComStatExample example = new CmtComStatExample();
		example.createCriteria().andSccServerNameEqualTo(comHostName);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtComStatExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtComStatExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtComStatExample example = new CmtComStatExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtComStatExample example) {
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String sccServerName, final String comHostName) {
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		CmtComStat record = mapper.selectByPrimaryKey(sccServerName, comHostName);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtComStatExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<COLUMNS, Object> searchingOption) {
		CmtComStatExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtComStatExample example = new CmtComStatExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmtComStatExample example) {
		// ORDER BY clause
		example.setOrderByClause(COMHOSTNAME_COLUMN_NAME);

		// Select.
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		List<CmtComStat> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = data.get(COLUMNS.SCC_SERVER_NAME).toString();
		String apName = data.get(COLUMNS.COM_HOST_NAME).toString();
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");
		Validator.requireNonNullAndNonEmpty(apName, "apName");


		// Make data.
		CmtComStat record = new CmtComStat();
		convertMapToModel(data, record);

		// Insert.
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = data.get(COLUMNS.SCC_SERVER_NAME).toString();
		String apName = data.get(COLUMNS.COM_HOST_NAME).toString();
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");
		Validator.requireNonNullAndNonEmpty(apName, "apName");

		// Make data.
		CmtComStat record = new CmtComStat();
		convertMapToModel(data, record);

		// Update.
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String sccServerName, final String comHostName) {
		CmtComStatMapper mapper = session.getMapper(CmtComStatMapper.class);
		return mapper.deleteByPrimaryKey(sccServerName, comHostName);
	}

}
