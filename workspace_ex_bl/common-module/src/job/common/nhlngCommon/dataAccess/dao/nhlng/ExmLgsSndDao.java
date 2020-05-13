package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.ExmLgsSnd;
import job.common.nhlngCommon.dataAccess.entity.nhlng.ExmLgsSndExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.ExmLgsSndMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * ExmLgsSndDao LGS送信マスタDAO
 * @author D.Suzuki
 */
public class ExmLgsSndDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CONFNO_COLUMN_NAME = COLUMNS.CONF_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 設定NO */
		CONF_NO,
		/** 書込タグNO */
		WRITE_TAG_NO,
		/** 読込タグNO */
		READ_TAG_NO;
	}

	static {
		TABLE_NAME = "ExmLgsSnd";
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
	private ExmLgsSndDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<ExmLgsSnd> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			ExmLgsSnd object = new ExmLgsSnd();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final ExmLgsSnd object) {
		if (map == null) { return; }
		object.setConfNo((Integer) map.get(COLUMNS.CONF_NO));
		object.setWriteTagNo((String) map.get(COLUMNS.WRITE_TAG_NO));
		object.setReadTagNo((String) map.get(COLUMNS.READ_TAG_NO));
	}

	private static void convertModelListToMapList(final List<ExmLgsSnd> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (ExmLgsSnd object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final ExmLgsSnd object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getConfNo() != null) {
			data.put(COLUMNS.CONF_NO, object.getConfNo());
		}
		if (object.getWriteTagNo() != null) {
			data.put(COLUMNS.WRITE_TAG_NO, object.getWriteTagNo());
		}
		if (object.getReadTagNo() != null) {
			data.put(COLUMNS.WRITE_TAG_NO, object.getReadTagNo());
		}
	}

	private static ExmLgsSndExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		ExmLgsSndExample example = new ExmLgsSndExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.CONF_NO) && searchingOption.containsKey(COLUMNS.WRITE_TAG_NO)) {
				Integer value1 = (Integer) searchingOption.get(COLUMNS.CONF_NO);
				String value2 = (String) searchingOption.get(COLUMNS.WRITE_TAG_NO);
				example.createCriteria().andConfNoEqualTo(value1).andWriteTagNoEqualTo(value2);
			}
		}
		return example;
	}

	private static ExmLgsSndExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		ExmLgsSndExample example = new ExmLgsSndExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.CONF_NO)) {
				String value2 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.WRITE_TAG_NO));
				example.createCriteria().andWriteTagNoLike(value2);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final int confNo) {
		ExmLgsSndExample example = new ExmLgsSndExample();
		example.createCriteria().andConfNoEqualTo(confNo);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<ExmLgsSndDao.COLUMNS, Object> searchingOption) {
		ExmLgsSndExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<ExmLgsSndDao.COLUMNS, Object> searchingOption) {
		ExmLgsSndExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		ExmLgsSndExample example = new ExmLgsSndExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final ExmLgsSndExample example) {
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<ExmLgsSndDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final int confNo, final String writeTagNo) {
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		ExmLgsSnd record = mapper.selectByPrimaryKey(confNo, writeTagNo);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<ExmLgsSndDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<ExmLgsSndDao.COLUMNS, Object> searchingOption) {
		ExmLgsSndExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<ExmLgsSndDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<ExmLgsSndDao.COLUMNS, Object> searchingOption) {
		ExmLgsSndExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<ExmLgsSndDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		ExmLgsSndExample example = new ExmLgsSndExample();
		return select(session, example);
	}

	private static List<Map<ExmLgsSndDao.COLUMNS, Object>> select(final SqlSession session, final ExmLgsSndExample example) {
		// ORDER BY clause
		example.setOrderByClause(CONFNO_COLUMN_NAME);

		// Select.
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		List<ExmLgsSnd> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	public static int insert(final SqlSession session, final Map<ExmLgsSndDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String confNo = data.get(COLUMNS.CONF_NO).toString();
		String writeTagNo = data.get(COLUMNS.WRITE_TAG_NO).toString();
		Validator.requireNonNullAndNonEmpty(confNo, "confNo");
		Validator.requireNonNullAndNonEmpty(writeTagNo, "writeTagNo");


		// Make data.
		ExmLgsSnd record = new ExmLgsSnd();
		convertMapToModel(data, record);

		// Insert.
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<ExmLgsSndDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String confNo = data.get(COLUMNS.CONF_NO).toString();
		String writeTagNo = data.get(COLUMNS.WRITE_TAG_NO).toString();
		Validator.requireNonNullAndNonEmpty(confNo, "confNo");
		Validator.requireNonNullAndNonEmpty(writeTagNo, "writeTagNo");

		// Make data.
		ExmLgsSnd record = new ExmLgsSnd();
		convertMapToModel(data, record);

		// Update.
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final int confNo, final String writeTagNo) {
		ExmLgsSndMapper mapper = session.getMapper(ExmLgsSndMapper.class);
		return mapper.deleteByPrimaryKey(confNo, writeTagNo);
	}

}
