package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtSyncInfo;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtSyncInfoExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtSyncInfoMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtSyncInfoDao 等値化情報DAO
 * @author D.Suzuki
 */
public class CmtSyncInfoDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TABLENAME_COLUMN_NAME = COLUMNS.TABLE_NAME.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** テーブル名 */
		TABLE_NAME,
		/** 最終等値化日時 */
		LAST_SYNC_DTIME,
		/** 等値化種別 */
		SYNC_KND,
		/** 更新日時カラム */
		UPD_DTIME_COL;
	}

	static {
		TABLE_NAME = "CmtSyncInfo";
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
	private CmtSyncInfoDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmtSyncInfo> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmtSyncInfo object = new CmtSyncInfo();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtSyncInfo object) {
		if (map == null) { return; }
		object.setTableName((String) map.get(COLUMNS.TABLE_NAME));
		object.setLastSyncDtime((Date) map.get(COLUMNS.LAST_SYNC_DTIME));
		object.setSyncKnd((int) map.get(COLUMNS.SYNC_KND));
		object.setUpdDtimeCol((String) map.get(COLUMNS.UPD_DTIME_COL));
	}

	private static void convertModelListToMapList(final List<CmtSyncInfo> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtSyncInfo object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtSyncInfo object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getTableName() != null) {
			data.put(COLUMNS.TABLE_NAME, object.getTableName());
		}
		if (object.getLastSyncDtime() != null) {
			data.put(COLUMNS.LAST_SYNC_DTIME, object.getLastSyncDtime());
		}
		if (object.getSyncKnd() != null) {
			data.put(COLUMNS.SYNC_KND, object.getSyncKnd());
		}
		if (object.getUpdDtimeCol() != null) {
			data.put(COLUMNS.UPD_DTIME_COL, object.getUpdDtimeCol());
		}
	}

	private static CmtSyncInfoExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtSyncInfoExample example = new CmtSyncInfoExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TABLE_NAME)) {
				String value = (String) searchingOption.get(COLUMNS.TABLE_NAME);
				example.createCriteria().andTableNameEqualTo(value);
			}
		}
		return example;
	}

	private static CmtSyncInfoExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtSyncInfoExample example = new CmtSyncInfoExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TABLE_NAME)) {
				String value = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.TABLE_NAME));
				example.createCriteria().andTableNameLike(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String tableName) {
		CmtSyncInfoExample example = new CmtSyncInfoExample();
		example.createCriteria().andTableNameEqualTo(tableName);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmtSyncInfoDao.COLUMNS, Object> searchingOption) {
		CmtSyncInfoExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmtSyncInfoDao.COLUMNS, Object> searchingOption) {
		CmtSyncInfoExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtSyncInfoExample example = new CmtSyncInfoExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtSyncInfoExample example) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmtSyncInfoDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String tableName) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		CmtSyncInfo record = mapper.selectByPrimaryKey(tableName);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtSyncInfoDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmtSyncInfoDao.COLUMNS, Object> searchingOption) {
		CmtSyncInfoExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtSyncInfoDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmtSyncInfoDao.COLUMNS, Object> searchingOption) {
		CmtSyncInfoExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmtSyncInfoDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtSyncInfoExample example = new CmtSyncInfoExample();
		return select(session, example);
	}

	private static List<Map<CmtSyncInfoDao.COLUMNS, Object>> select(final SqlSession session, final CmtSyncInfoExample example) {
		// ORDER BY clause
		example.setOrderByClause(TABLENAME_COLUMN_NAME);

		// Select.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		List<CmtSyncInfo> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<CmtSyncInfoDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tableName = (String) data.get(COLUMNS.TABLE_NAME);
		Validator.requireNonNullAndNonEmpty(tableName, "tableName");

		// Make data.
		CmtSyncInfo record = new CmtSyncInfo();
		convertMapToModel(data, record);

		// Insert.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<CmtSyncInfoDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tableName = (String) data.get(COLUMNS.TABLE_NAME);
		Validator.requireNonNullAndNonEmpty(tableName, "tableName");
		// Make data.
		CmtSyncInfo record = new CmtSyncInfo();
		convertMapToModel(data, record);

		// Update.
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String tableName) {
		CmtSyncInfoMapper mapper = session.getMapper(CmtSyncInfoMapper.class);
		return mapper.deleteByPrimaryKey(tableName);
	}

}
