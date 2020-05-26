package job.sfcommon.dataaccess.dao.looponexcore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentData;
import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentDataExample;
import job.sfcommon.dataaccess.mapper.looponexcore.SlgCurrentDataMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SlgCurrentDataDao 瞬時データDAO
 * @author D.Suzuki
 */

public class SlgCurrentDataDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.LCODE.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 締切グループNO */
		LCODE,
		/** 分締めタイミング（秒） */
		VALUE,
		/** 時締めタイミング（分） */
		QUALITY,
		/** 日締めタイミング（時） */
		COLLECT_DATE;
	}

	static {
		TABLE_NAME = "SlgCurrentData";
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
	private SlgCurrentDataDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<SlgCurrentData> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			SlgCurrentData object = new SlgCurrentData();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}
	*/
	private static void convertMapToModel(final Map<COLUMNS, Object> map, final SlgCurrentData object) {
		if (map == null) { return; }
		object.setLcode((String) map.get(COLUMNS.LCODE));
		object.setValue((String) map.get(COLUMNS.VALUE));
		object.setQuality((Integer) map.get(COLUMNS.QUALITY));
		object.setCollectDate((Date) map.get(COLUMNS.COLLECT_DATE));
	}


	private static void convertModelListToMapList(final List<SlgCurrentData> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (SlgCurrentData object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final SlgCurrentData object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getLcode() != null) {
			data.put(COLUMNS.LCODE, object.getLcode());
		}
		if (object.getValue() != null) {
			data.put(COLUMNS.VALUE, object.getValue());
		}
		if (object.getQuality() != null) {
			data.put(COLUMNS.QUALITY, object.getQuality());
		}
		if (object.getCollectDate() != null) {
			data.put(COLUMNS.COLLECT_DATE, object.getCollectDate());
		}
	}


	private static SlgCurrentDataExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		SlgCurrentDataExample example = new SlgCurrentDataExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.COLLECT_DATE);
			String value2 = (String) searchingOption.get(COLUMNS.LCODE);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andCollectDateEqualTo(value1).andLcodeEqualTo(value2);
			}
			else if (Objects.nonNull(value1)) {
				example.createCriteria().andCollectDateEqualTo(value1);
			}
			else if (Objects.nonNull(value2)) {
				example.createCriteria().andLcodeEqualTo(value2);
			}
		}
		return example;
	}

	private static SlgCurrentDataExample selectFromToMatchingExample(final Map<COLUMNS, Object> searchingOption, final Date toDate) {
		// WHERE clause
		SlgCurrentDataExample example = new SlgCurrentDataExample();
		if (searchingOption.size() > 0) {
			Date value1 = (Date) searchingOption.get(COLUMNS.COLLECT_DATE);
			String value2 = (String) searchingOption.get(COLUMNS.LCODE);
			if(Objects.nonNull(value1) && Objects.nonNull(value2)){
				example.createCriteria().andCollectDateBetween(value1, toDate).andLcodeEqualTo(value2);
			}
			else if (Objects.isNull(value2)) {
				example.createCriteria().andCollectDateBetween(value1, toDate);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String lcode) {
		SlgCurrentDataExample example = new SlgCurrentDataExample();
		example.createCriteria().andLcodeEqualTo(lcode);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<SlgCurrentDataDao.COLUMNS, Object> searchingOption) {
		SlgCurrentDataExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		SlgCurrentDataExample example = new SlgCurrentDataExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final SlgCurrentDataExample example) {
		SlgCurrentDataMapper mapper = session.getMapper(SlgCurrentDataMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<SlgCurrentDataDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		SlgCurrentDataExample example = new SlgCurrentDataExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final SlgCurrentDataExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		SlgCurrentDataMapper mapper = session.getMapper(SlgCurrentDataMapper.class);
		List<SlgCurrentData> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}


	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<SlgCurrentDataDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<SlgCurrentDataDao.COLUMNS, Object> searchingOption) {
		SlgCurrentDataExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<SlgCurrentDataDao.COLUMNS, Object>> selectFromToMatching(final SqlSession session, final Map<SlgCurrentDataDao.COLUMNS, Object> searchingOption, Date toDate) {
		SlgCurrentDataExample example = selectFromToMatchingExample(searchingOption, toDate);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param data
	 * @return int
	 */
	public static int updateByPrimaryKey(final SqlSession session, final Map<SlgCurrentDataDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String lcode = data.get(COLUMNS.LCODE).toString();
		Validator.requireNonNullAndNonEmpty(lcode, "lcode");

		// Make data.
		SlgCurrentData record = new SlgCurrentData();
		convertMapToModel(data, record);

		// Update.
		SlgCurrentDataMapper mapper = session.getMapper(SlgCurrentDataMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}
}
