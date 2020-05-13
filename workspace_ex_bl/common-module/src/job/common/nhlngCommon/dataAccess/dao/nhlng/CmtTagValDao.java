package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import biz.grandsight.ex.util.Validator;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtTagVal;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtTagValExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmtTagValMapper;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtTagValDao タグデータDAO
 *
 * @author D.Suzuki
 */
public class CmtTagValDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String TAGNO_COLUMN_NAME = COLUMNS.TAG_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_DATA,
		/** CALフラグ */
		CAL_FLAG,
		/** 入力可能フラグ */
		INPUT_FLAG;
	}

	public static enum EX_COLUMNS {
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_DATA,
		/** CALフラグ */
		CAL_FLAG,
		/** 入力可能フラグ */
		INPUT_FLAG,
		/** Lコード */
		LCODE,
		/** コメント */
		COMMENT1,
		/** 工業単位計算機 */
		UNIT_COMPUTER,
		/** DP */
		DP,
		/** 上限値 */
		UPPER_VALUE,
		/** 下限値 */
		LOWER_VALUE,
		/** タグ種別 */
		TAG_KIND,
		/** IO種別 */
		IO_KIND,
		/** 定数区分 */
		CONST_DIV,
		/** 帳票区分 */
		REPO_DIV,
		/** 帳票計算区分 */
		REPO_CALC_DIV,
		/** 公開DB分データ送信フラグ */
		ODB_MIN_SND_FLAG,
		/** 公開DB時締データ送信フラグ */
		ODB_HOUR_SND_FLAG,
		/** 公開DB日締データ送信フラグ */
		ODB_DAY_SND_FLAG,
		/** 積算丸めフラグ */
		ROUND_FLAG,
		/** 残値タグNO */
		REM_TAG_NO,
		/** 画面更新フラグ */
		SCR_UPDATE_FLAG,
		/** タグ論理名1 */
		TAG_LOGIC_NAME1,
		/** タグ論理名2 */
		TAG_LOGIC_NAME2,
		/** タグ論理名3 */
		TAG_LOGIC_NAME3,
		/** タグ論理名4 */
		TAG_LOGIC_NAME4,
		/** 瞬時データフラグ */
		CURRENT_DATA_FLAG,
		/** 時締データフラグ */
		HOURLY_DATA_FLAG,
		/** 日締データフラグ */
		DAILY_DATA_FLAG,
		/** 月締データフラグ */
		MONTHLY_DATA_FLAG,
		/** 締切種別 */
		CLOSE_KIND;
	}

	static {
		TABLE_NAME = "CmtTagVal";
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
	private CmtTagValDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	 * private static void convertMapListToModelList(final List<Map<COLUMNS,
	 * Object>> mapList, final List<CmtTagVal> objectList) throws
	 * InstantiationException, IllegalAccessException { if (mapList == null) {
	 * return; } for (Map<COLUMNS, Object> map : mapList) { CmtTagVal object =
	 * new CmtTagVal(); convertMapToModel(map, object); objectList.add(object);
	 * } }
	 */

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtTagVal object) {
		if (map == null) {
			return;
		}
		if (map.get(COLUMNS.TAG_NO) != null) {
			object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		}
		if (map.get(COLUMNS.TAG_DATA) != null) {
			object.setTagData((String) map.get(COLUMNS.TAG_DATA));
		}
		if (map.get(COLUMNS.CAL_FLAG) != null) {
			object.setCalFlag((int) map.get(COLUMNS.CAL_FLAG));
		}
		if (map.get(COLUMNS.INPUT_FLAG) != null) {
			object.setInputFlag((int) map.get(COLUMNS.INPUT_FLAG));
		}
	}


	private static void convertExMapToModel(final Map<EX_COLUMNS, Object> map, final CmtTagVal object) {
		if (map == null) {
			return;
		}
		if (map.get(EX_COLUMNS.TAG_NO) != null) {
			object.setTagNo((String) map.get(EX_COLUMNS.TAG_NO));
		}
		if (map.get(EX_COLUMNS.TAG_DATA) != null) {
			object.setTagData((String) map.get(EX_COLUMNS.TAG_DATA));
		}
		if (map.get(EX_COLUMNS.CAL_FLAG) != null) {
			object.setCalFlag((int) map.get(EX_COLUMNS.CAL_FLAG));
		}
		if (map.get(EX_COLUMNS.INPUT_FLAG) != null) {
			object.setInputFlag((int) map.get(EX_COLUMNS.INPUT_FLAG));
		}
		if (map.get(EX_COLUMNS.LCODE) != null) {
			object.setLcode((String) map.get(EX_COLUMNS.LCODE));
		}
		if (map.get(EX_COLUMNS.COMMENT1) != null) {
			object.setComment1((String) map.get(EX_COLUMNS.COMMENT1));
		}
		if (map.get(EX_COLUMNS.UNIT_COMPUTER) != null) {
			object.setUnitComputer((String) map.get(EX_COLUMNS.UNIT_COMPUTER));
		}
		if (map.get(EX_COLUMNS.DP) != null) {
			object.setDp((Integer) map.get(EX_COLUMNS.DP));
		}
		if (map.get(EX_COLUMNS.UPPER_VALUE) != null) {
			object.setUpperValue((Float) map.get(EX_COLUMNS.UPPER_VALUE));
		}
		if (map.get(EX_COLUMNS.LOWER_VALUE) != null) {
			object.setLowerValue((Float) map.get(EX_COLUMNS.LOWER_VALUE));
		}
		if (map.get(EX_COLUMNS.TAG_KIND) != null) {
			object.setTagKind((Integer) map.get(EX_COLUMNS.TAG_KIND));
		}
		if (map.get(EX_COLUMNS.IO_KIND) != null) {
			object.setIoKind((String) map.get(EX_COLUMNS.IO_KIND));
		}
		if (map.get(EX_COLUMNS.CONST_DIV) != null) {
			object.setConstDiv((String) map.get(EX_COLUMNS.CONST_DIV));
		}
		if (map.get(EX_COLUMNS.REPO_DIV) != null) {
			object.setRepoDiv((String) map.get(EX_COLUMNS.REPO_DIV));
		}
		if (map.get(EX_COLUMNS.REPO_CALC_DIV) != null) {
			object.setRepoCalcDiv((String) map.get(EX_COLUMNS.REPO_CALC_DIV));
		}
		if (map.get(EX_COLUMNS.ODB_MIN_SND_FLAG) != null) {
			object.setOdbMinSndFlag((Integer) map.get(EX_COLUMNS.ODB_MIN_SND_FLAG));
		}
		if (map.get(EX_COLUMNS.ODB_HOUR_SND_FLAG) != null) {
			object.setOdbHourSndFlag((Integer) map.get(EX_COLUMNS.ODB_HOUR_SND_FLAG));
		}
		if (map.get(EX_COLUMNS.ODB_DAY_SND_FLAG) != null) {
			object.setOdbDaySndFlag((Integer) map.get(EX_COLUMNS.ODB_DAY_SND_FLAG));
		}
		if (map.get(EX_COLUMNS.ROUND_FLAG) != null) {
			object.setRoundFlag((Integer) map.get(EX_COLUMNS.ROUND_FLAG));
		}
		if (map.get(EX_COLUMNS.REM_TAG_NO) != null) {
			object.setRemTagNo((String) map.get(EX_COLUMNS.REM_TAG_NO));
		}
		if (map.get(EX_COLUMNS.SCR_UPDATE_FLAG) != null) {
			object.setScrUpdateFlag((Integer) map.get(EX_COLUMNS.SCR_UPDATE_FLAG));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME1) != null) {
			object.setTagLogicName1((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME1));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME2) != null) {
			object.setTagLogicName2((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME2));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME3) != null) {
			object.setTagLogicName3((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME3));
		}
		if (map.get(EX_COLUMNS.TAG_LOGIC_NAME4) != null) {
			object.setTagLogicName4((String) map.get(EX_COLUMNS.TAG_LOGIC_NAME4));
		}
		if (map.get(EX_COLUMNS.CURRENT_DATA_FLAG) != null) {
			object.setCurrentDataFlag((String) map.get(EX_COLUMNS.CURRENT_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.HOURLY_DATA_FLAG) != null) {
			object.setHourlyDataFlag((String) map.get(EX_COLUMNS.HOURLY_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.DAILY_DATA_FLAG) != null) {
			object.setDailyDataFlag((String) map.get(EX_COLUMNS.DAILY_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.MONTHLY_DATA_FLAG) != null) {
			object.setMonthlyDataFlag((String) map.get(EX_COLUMNS.MONTHLY_DATA_FLAG));
		}
		if (map.get(EX_COLUMNS.CLOSE_KIND) != null) {
			object.setCloseKind((String) map.get(EX_COLUMNS.CLOSE_KIND));
		}
	}

	private static void convertModelListToMapList(final List<CmtTagVal> objectList,
			final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) {
			return;
		}
		for (CmtTagVal object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtTagVal object, final Map<COLUMNS, Object> data) {
		if (object == null) {
			return;
		}
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getTagData() != null) {
			data.put(COLUMNS.TAG_DATA, object.getTagData());
		}
		if (object.getCalFlag() != null) {
			data.put(COLUMNS.CAL_FLAG, object.getCalFlag());
		}
		if (object.getInputFlag() != null) {
			data.put(COLUMNS.INPUT_FLAG, object.getInputFlag());
		}
	}

	private static void convertModelListToExMapList(final List<CmtTagVal> objectList,
			final List<Map<EX_COLUMNS, Object>> mapList) {
		if (objectList == null) {
			return;
		}
		for (CmtTagVal object : objectList) {
			Map<EX_COLUMNS, Object> map = new HashMap<>();
			convertModelToExMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToExMap(final CmtTagVal object, final Map<EX_COLUMNS, Object> data) {
		if (object == null) {
			return;
		}
		if (object.getTagNo() != null) {
			data.put(EX_COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getTagData() != null) {
			data.put(EX_COLUMNS.TAG_DATA, object.getTagData());
		}
		if (object.getCalFlag() != null) {
			data.put(EX_COLUMNS.CAL_FLAG, object.getCalFlag());
		}
		if (object.getInputFlag() != null) {
			data.put(EX_COLUMNS.INPUT_FLAG, object.getInputFlag());
		}
		if (object.getLcode() != null) {
			data.put(EX_COLUMNS.LCODE, object.getLcode());
		}
		if (object.getComment1() != null) {
			data.put(EX_COLUMNS.COMMENT1, object.getComment1());
		}
		if (object.getUnitComputer() != null) {
			data.put(EX_COLUMNS.UNIT_COMPUTER, object.getUnitComputer());
		}
		if (object.getDp() != null) {
			data.put(EX_COLUMNS.DP, object.getDp());
		}
		if (object.getUpperValue() != null) {
			data.put(EX_COLUMNS.UPPER_VALUE, object.getUpperValue());
		}
		if (object.getLowerValue() != null) {
			data.put(EX_COLUMNS.LOWER_VALUE, object.getLowerValue());
		}
		if (object.getTagKind() != null) {
			data.put(EX_COLUMNS.TAG_KIND, object.getTagKind());
		}
		if (object.getIoKind() != null) {
			data.put(EX_COLUMNS.IO_KIND, object.getIoKind());
		}
		if (object.getConstDiv() != null) {
			data.put(EX_COLUMNS.CONST_DIV, object.getConstDiv());
		}
		if (object.getRepoDiv() != null) {
			data.put(EX_COLUMNS.REPO_DIV, object.getRepoDiv());
		}
		if (object.getRepoCalcDiv() != null) {
			data.put(EX_COLUMNS.REPO_CALC_DIV, object.getRepoCalcDiv());
		}
		if (object.getOdbMinSndFlag() != null) {
			data.put(EX_COLUMNS.ODB_MIN_SND_FLAG, object.getOdbMinSndFlag());
		}
		if (object.getOdbHourSndFlag() != null) {
			data.put(EX_COLUMNS.ODB_HOUR_SND_FLAG, object.getOdbHourSndFlag());
		}
		if (object.getOdbDaySndFlag() != null) {
			data.put(EX_COLUMNS.ODB_DAY_SND_FLAG, object.getOdbDaySndFlag());
		}
		if (object.getRoundFlag() != null) {
			data.put(EX_COLUMNS.ROUND_FLAG, object.getRoundFlag());
		}
		if (object.getRemTagNo() != null) {
			data.put(EX_COLUMNS.REM_TAG_NO, object.getRemTagNo());
		}
		if (object.getScrUpdateFlag() != null) {
			data.put(EX_COLUMNS.SCR_UPDATE_FLAG, object.getScrUpdateFlag());
		}
		if (object.getTagLogicName1() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME1, object.getTagLogicName1());
		}
		if (object.getTagLogicName2() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME3, object.getTagLogicName2());
		}
		if (object.getTagLogicName3() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME3, object.getTagLogicName3());
		}
		if (object.getTagLogicName4() != null) {
			data.put(EX_COLUMNS.TAG_LOGIC_NAME4, object.getTagLogicName4());
		}
		if (object.getCurrentDataFlag() != null) {
			data.put(EX_COLUMNS.CURRENT_DATA_FLAG, object.getCurrentDataFlag());
		}
		if (object.getHourlyDataFlag() != null) {
			data.put(EX_COLUMNS.HOURLY_DATA_FLAG, object.getHourlyDataFlag());
		}
		if (object.getDailyDataFlag() != null) {
			data.put(EX_COLUMNS.DAILY_DATA_FLAG, object.getDailyDataFlag());
		}
		if (object.getMonthlyDataFlag() != null) {
			data.put(EX_COLUMNS.MONTHLY_DATA_FLAG, object.getMonthlyDataFlag());
		}
		if (object.getCloseKind() != null) {
			data.put(EX_COLUMNS.CLOSE_KIND, object.getCloseKind());
		}
	}

	private static CmtTagValExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtTagValExample example = new CmtTagValExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TAG_NO)) {
				String value1 = (String) searchingOption.get(COLUMNS.TAG_NO);
				example.createCriteria().andTagNoEqualTo(value1);
			}
		}
		return example;
	}

	private static CmtTagValExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtTagValExample example = new CmtTagValExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TAG_NO)) {
				String value = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.TAG_NO));
				example.createCriteria().andTagNoLike(value);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String tagNo) {
		CmtTagValExample example = new CmtTagValExample();
		example.createCriteria().andTagNoEqualTo(tagNo);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session,
			final Map<CmtTagValDao.COLUMNS, Object> searchingOption) {
		CmtTagValExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static long countPartialMatching(final SqlSession session,
			final Map<CmtTagValDao.COLUMNS, Object> searchingOption) {
		CmtTagValExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmtTagValExample example = new CmtTagValExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmtTagValExample example) {
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.countByExample(example);
	}

	public static long ExCountG0150(final SqlSession session,
			final Map<CmtTagValDao.EX_COLUMNS, Object> searchingOption) {
		CmtTagValExample example = new CmtTagValExample();
		example.createCriteria().andTagKindNotEqualTo(1).andCurrentDataFlagEqualTo(1);
		if(StringUtils.isNotEmpty(searchingOption.get(EX_COLUMNS.TAG_NO).toString())){
			example.addCriteria().andTagNoLike("%"+searchingOption.get(EX_COLUMNS.TAG_NO).toString()+"%");
		}
		if(StringUtils.isNotEmpty(searchingOption.get(EX_COLUMNS.COMMENT1).toString())){
			example.addCriteria().andComment1Like("%"+searchingOption.get(EX_COLUMNS.COMMENT1).toString()+"%");
		}
		if(2 > (Integer) searchingOption.get(EX_COLUMNS.CAL_FLAG)){
			example.addCriteria().andCalFlagEqualTo((Integer) searchingOption.get(EX_COLUMNS.CAL_FLAG));
		}
		return ExCount(session, example);
	}

	private static long ExCount(final SqlSession session, final CmtTagValExample example) {
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.countByExtendedExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<CmtTagValDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String tagNo) {
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		CmtTagVal record = mapper.selectByPrimaryKey(tagNo);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session,
			final Map<CmtTagValDao.COLUMNS, Object> searchingOption) {
		CmtTagValExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectPartialMatching(final SqlSession session,
			final Map<CmtTagValDao.COLUMNS, Object> searchingOption) {
		CmtTagValExample example = makePartialMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 */
	public static List<Map<CmtTagValDao.EX_COLUMNS, Object>> ExSelectG0150(final SqlSession session,
			final Map<CmtTagValDao.EX_COLUMNS, Object> searchingOption) {
		CmtTagValExample example = new CmtTagValExample();
		example.createCriteria().andTagKindNotEqualTo(1).andCurrentDataFlagEqualTo(1);
		if(StringUtils.isNotEmpty(searchingOption.get(EX_COLUMNS.TAG_NO).toString())){
			example.addCriteria().andTagNoLike("%"+searchingOption.get(EX_COLUMNS.TAG_NO).toString()+"%");
		}
		if(StringUtils.isNotEmpty(searchingOption.get(EX_COLUMNS.COMMENT1).toString())){
			example.addCriteria().andComment1Like("%"+searchingOption.get(EX_COLUMNS.COMMENT1).toString()+"%");
		}
		if(0 > (Integer) searchingOption.get(EX_COLUMNS.CAL_FLAG)){
			example.addCriteria().andCalFlagEqualTo((Integer) searchingOption.get(EX_COLUMNS.CAL_FLAG));
		}

		return ExSelect(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmtTagValExample example = new CmtTagValExample();
		return select(session, example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectByTagNoList(final SqlSession session,
			final List<String> tagNoList) {
		CmtTagValExample example = new CmtTagValExample();
		example.createCriteria().andTagNoIn(tagNoList);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<Map<CmtTagValDao.COLUMNS, Object>>
	 */
	public static List<Map<CmtTagValDao.COLUMNS, Object>> selectBylogicNameList(final SqlSession session,
			final List<List<String>> logicNameList) {
		CmtTagValExample example = new CmtTagValExample();
		example.createCriteria();
		for(int i=0; i<4; i++){
			if(Objects.nonNull(logicNameList.get(i))){
				if(0==i){
					example.addCriteria().andTagLogicName1In(logicNameList.get(i));
				}else if(1==i){
					example.addCriteria().andTagLogicName2In(logicNameList.get(i));
				}else if(2==i){
					example.addCriteria().andTagLogicName3In(logicNameList.get(i));
				}else if(3==i){
					example.addCriteria().andTagLogicName4In(logicNameList.get(i));
				}
			}
		}
		return select(session, example);
	}

	private static List<Map<CmtTagValDao.COLUMNS, Object>> select(final SqlSession session,
			final CmtTagValExample example) {
		// ORDER BY clause
		example.setOrderByClause(TAGNO_COLUMN_NAME);

		// Select.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		List<CmtTagVal> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}

	private static List<Map<CmtTagValDao.EX_COLUMNS, Object>> ExSelect(final SqlSession session,
			final CmtTagValExample example) {
		// ORDER BY clause
		example.setOrderByClause(TAGNO_COLUMN_NAME);
		example.setLimitClause(TAGNO_COLUMN_NAME);

		// Select.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		List<CmtTagVal> recordList = mapper.selectByExtendedExample(example);

		// Convert and return.
		List<Map<EX_COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToExMapList(recordList, result);
		return result;
	}

	/**
	 * メッセージデータinsert
	 *
	 * @param session
	 *            SQLセッション
	 * @param data
	 *            メッセージデータ
	 * @return int insert件数
	 */
	public static int insert(final SqlSession session, final Map<CmtTagValDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tagNo = (String) data.get(COLUMNS.TAG_NO);
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Make data.
		CmtTagVal record = new CmtTagVal();
		convertMapToModel(data, record);

		// Insert.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.insertSelective(record);
	}

	public static int updateByPrimaryKey(final SqlSession session, final Map<CmtTagValDao.COLUMNS, Object> data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tagNo = (String) data.get(COLUMNS.TAG_NO);
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Make data.
		CmtTagVal record = new CmtTagVal();
		convertMapToModel(data, record);

		// Update.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String tagNo) {
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.deleteByPrimaryKey(tagNo);
	}

}
