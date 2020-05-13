package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtSystemStat;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtSystemStatExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtSystemStatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtSystemStatDao システム状態DAO
 * @author D.Suzuki
 */
public class CmtSystemStatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SCCSERVERNAME_COLUMN_NAME = COLUMNS.SCC_SERVER_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** SCCサーバ名 */
		SCC_SERVER_NAME,
		/** 主従状態 */
		MASTER_STAT,
		/** 処理実行状態 */
		PROC_EXEC_STAT,
		/** 稼働状態 */
		OPE_STAT,
		/** 稼働状態フラグ */
		OPE_STAT_FLAG,
		/** 稼働状態更新日時 */
		OPE_STAT_DTIME,
		/** AP状態 */
		AP_STAT,
		/** OPCサーバ状態 */
		OPC_SERVER_STAT;
	}

	static {
		TABLE_NAME = "CmtSystemStat";
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
	private CmtSystemStatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmtSystemStat> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmtSystemStat object = new CmtSystemStat();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtSystemStat object) {
		if (map == null) { return; }
		object.setSccServerName((String) map.get(COLUMNS.SCC_SERVER_NAME));
		object.setMasterStat((Integer) map.get(COLUMNS.MASTER_STAT));
		object.setProcExecStat((Integer) map.get(COLUMNS.PROC_EXEC_STAT));
		object.setOpeStat((Integer) map.get(COLUMNS.OPE_STAT));
		object.setOpeStatFlag((Integer) map.get(COLUMNS.OPE_STAT_FLAG));
		object.setOpeStatDtime((Date) map.get(COLUMNS.OPE_STAT_DTIME));
		object.setApStat((Integer) map.get(COLUMNS.AP_STAT));
		object.setOpcServerStat((Integer) map.get(COLUMNS.OPC_SERVER_STAT));
	}

	private static void convertModelListToMapList(final List<CmtSystemStat> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtSystemStat object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtSystemStat object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getSccServerName() != null) {
			data.put(COLUMNS.SCC_SERVER_NAME, object.getSccServerName());
		}
		if (object.getMasterStat() != null) {
			data.put(COLUMNS.MASTER_STAT, object.getMasterStat());
		}
		if (object.getProcExecStat() != null) {
			data.put(COLUMNS.PROC_EXEC_STAT, object.getProcExecStat());
		}
		if (object.getOpeStat() != null) {
			data.put(COLUMNS.OPE_STAT, object.getOpeStat());
		}
		if (object.getOpeStatFlag() != null) {
			data.put(COLUMNS.OPE_STAT_FLAG, object.getOpeStatFlag());
		}
		if (object.getOpeStatDtime() != null) {
			data.put(COLUMNS.OPE_STAT_DTIME, object.getOpeStatDtime());
		}
		if (object.getApStat() != null) {
			data.put(COLUMNS.AP_STAT, object.getApStat());
		}
		if (object.getOpcServerStat() != null) {
			data.put(COLUMNS.OPC_SERVER_STAT, object.getOpcServerStat());
		}
	}

	private static CmtSystemStatExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtSystemStatExample example = new CmtSystemStatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCC_SERVER_NAME)) {
				String value = (String) searchingOption.get(COLUMNS.SCC_SERVER_NAME);
				example.createCriteria().andSccServerNameEqualTo(value);
			}
		}
		return example;
	}

	private static CmtSystemStatExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtSystemStatExample example = new CmtSystemStatExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SCC_SERVER_NAME)) {
				String value = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.SCC_SERVER_NAME));
				example.createCriteria().andSccServerNameLike(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String sccServerName) {
		CmtSystemStatExample example = new CmtSystemStatExample();
		example.createCriteria().andSccServerNameEqualTo(sccServerName);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmtSystemStatDao.COLUMNS, Object> searchingOption) {
		CmtSystemStatExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmtSystemStatDao.COLUMNS, Object> searchingOption) {
		CmtSystemStatExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtSystemStatExample example = new CmtSystemStatExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtSystemStatExample example) {
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmtSystemStatDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String sccServerName) {
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		CmtSystemStat record = mapper.selectByPrimaryKey(sccServerName);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtSystemStatDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmtSystemStatDao.COLUMNS, Object> searchingOption) {
		CmtSystemStatExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtSystemStatDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmtSystemStatDao.COLUMNS, Object> searchingOption) {
		CmtSystemStatExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmtSystemStatDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtSystemStatExample example = new CmtSystemStatExample();
		return select(session, example);
	}

	private static List<Map<CmtSystemStatDao.COLUMNS, Object>> select(final SqlSession session, final CmtSystemStatExample example) {
		// ORDER BY clause
		example.setOrderByClause(SCCSERVERNAME_COLUMN_NAME);

		// Select.
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		List<CmtSystemStat> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<CmtSystemStatDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = (String) data.get(COLUMNS.SCC_SERVER_NAME);
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");

		// Make data.
		CmtSystemStat record = new CmtSystemStat();
		convertMapToModel(data, record);

		// Insert.
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<CmtSystemStatDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String sccServerName = (String) data.get(COLUMNS.SCC_SERVER_NAME);
		Validator.requireNonNullAndNonEmpty(sccServerName, "sccServerName");

		// Make data.
		CmtSystemStat record = new CmtSystemStat();
		convertMapToModel(data, record);

		// Update.
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String sccServerName) {
		CmtSystemStatMapper mapper = session.getMapper(CmtSystemStatMapper.class);
		return mapper.deleteByPrimaryKey(sccServerName);
	}
}
