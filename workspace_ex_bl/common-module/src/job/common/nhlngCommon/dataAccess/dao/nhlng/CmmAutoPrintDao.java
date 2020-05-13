package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmAutoPrint;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmAutoPrintExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmAutoPrintMapper;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmAutoPrintDao 自動印刷マスタDAO
 * @author D.Suzuki
 */
public class CmmAutoPrintDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String REPORTKIND_COLUMN_NAME = COLUMNS.REPORT_KIND.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** 帳票区分 */
		REPORT_KIND,
		/** 自動フラグ */
		AUTO_FLAG,
		/** 印刷時刻 */
		PRIN_TTIME;
	}

	static {
		TABLE_NAME = "CmmAutoPrint";
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
	private CmmAutoPrintDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmAutoPrint> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmAutoPrint object = new CmmAutoPrint();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmAutoPrint object) {
		if (map == null) { return; }
		object.setReportKind((String) map.get(COLUMNS.REPORT_KIND));
		object.setAutoFlag((Integer) map.get(COLUMNS.AUTO_FLAG));
		object.setPrintTime((String) map.get(COLUMNS.PRIN_TTIME));
	}
	*/

	private static void convertModelListToMapList(final List<CmmAutoPrint> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmAutoPrint object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmAutoPrint object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getReportKind() != null) {
			data.put(COLUMNS.REPORT_KIND, object.getReportKind());
		}
		if (object.getAutoFlag() != null) {
		data.put(COLUMNS.AUTO_FLAG, object.getAutoFlag());
		}
		if (object.getPrintTime() != null) {
			data.put(COLUMNS.PRIN_TTIME, object.getPrintTime());
		}
	}

	private static CmmAutoPrintExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmAutoPrintExample example = new CmmAutoPrintExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.REPORT_KIND)) {
				String value = (String) searchingOption.get(COLUMNS.REPORT_KIND);
				example.createCriteria().andReportKindEqualTo(value);
			}
		}
		return example;
	}

	private static CmmAutoPrintExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmAutoPrintExample example = new CmmAutoPrintExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.REPORT_KIND)) {
				String value = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.REPORT_KIND));
				example.createCriteria().andReportKindLike(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String reportKind) {
		CmmAutoPrintExample example = new CmmAutoPrintExample();
		example.createCriteria().andReportKindEqualTo(reportKind);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmAutoPrintDao.COLUMNS, Object> searchingOption) {
		CmmAutoPrintExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session, final Map<CmmAutoPrintDao.COLUMNS, Object> searchingOption) {
		CmmAutoPrintExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmAutoPrintExample example = new CmmAutoPrintExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmAutoPrintExample example) {
		CmmAutoPrintMapper mapper = session.getMapper(CmmAutoPrintMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmmAutoPrintDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String reportKind) {
		CmmAutoPrintMapper mapper = session.getMapper(CmmAutoPrintMapper.class);
		CmmAutoPrint record = mapper.selectByPrimaryKey(reportKind);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmAutoPrintDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmAutoPrintDao.COLUMNS, Object> searchingOption) {
		CmmAutoPrintExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmAutoPrintDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session, final Map<CmmAutoPrintDao.COLUMNS, Object> searchingOption) {
		CmmAutoPrintExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmAutoPrintDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmAutoPrintExample example = new CmmAutoPrintExample();
		return select(session, example);
	}

	private static List<Map<CmmAutoPrintDao.COLUMNS, Object>> select(final SqlSession session, final CmmAutoPrintExample example) {
		// ORDER BY clause
		example.setOrderByClause(REPORTKIND_COLUMN_NAME);

		// Select.
		CmmAutoPrintMapper mapper = session.getMapper(CmmAutoPrintMapper.class);
		List<CmmAutoPrint> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<CmmAutoPrintDao.COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
