package job.common.nhlngCommon.dataAccess.dao.nhlng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmTagMasterV;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmTagMasterVExample;
import job.common.nhlngCommon.dataAccess.mapper.nhlng.CmmTagMasterVMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/01 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmTagMasterVDao NHタグマスタ(ビュー)DAO
 * @author D.Suzuki
 */
public class CmmTagMasterVDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.TAG_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** タグNO */
		TAG_NO,
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
		TABLE_NAME = "CmmTagMasterV";
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
	private CmmTagMasterVDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/


	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmTagMasterV> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmTagMasterV object = new CmmTagMasterV();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmTagMasterV object) {
		if (map == null) { return; }
		if (map.get(COLUMNS.TAG_NO) != null) {
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		}
		if (map.get(COLUMNS.LCODE) != null) {
		object.setLcode((String) map.get(COLUMNS.LCODE));
		}
		if (map.get(COLUMNS.COMMENT1) != null) {
		object.setComment1((String) map.get(COLUMNS.COMMENT1));
		}
		if (map.get(COLUMNS.UNIT_COMPUTER) != null) {
		object.setUnitComputer((String) map.get(COLUMNS.UNIT_COMPUTER));
		}
		if (map.get(COLUMNS.DP) != null) {
		object.setDp((Integer) map.get(COLUMNS.DP));
		}
		if (map.get(COLUMNS.UPPER_VALUE) != null) {
		object.setUpperValue((Float) map.get(COLUMNS.UPPER_VALUE));
		}
		if (map.get(COLUMNS.LOWER_VALUE) != null) {
		object.setLowerValue((Float) map.get(COLUMNS.LOWER_VALUE));
		}
		if (map.get(COLUMNS.TAG_KIND) != null) {
		object.setTagKind((Integer) map.get(COLUMNS.TAG_KIND));
		}
		if (map.get(COLUMNS.IO_KIND) != null) {
		object.setIoKind((String) map.get(COLUMNS.IO_KIND));
		}
		if (map.get(COLUMNS.CONST_DIV) != null) {
		object.setConstDiv((String) map.get(COLUMNS.CONST_DIV));
		}
		if (map.get(COLUMNS.REPO_DIV) != null) {
		object.setRepoDiv((String) map.get(COLUMNS.REPO_DIV));
		}
		if (map.get(COLUMNS.REPO_CALC_DIV) != null) {
		object.setRepoCalcDiv((String) map.get(COLUMNS.REPO_CALC_DIV));
		}
		if (map.get(COLUMNS.ODB_MIN_SND_FLAG) != null) {
		object.setOdbMinSndFlag((Integer) map.get(COLUMNS.ODB_MIN_SND_FLAG));
		}
		if (map.get(COLUMNS.ODB_HOUR_SND_FLAG) != null) {
		object.setOdbHourSndFlag((Integer) map.get(COLUMNS.ODB_HOUR_SND_FLAG));
		}
		if (map.get(COLUMNS.ODB_DAY_SND_FLAG) != null) {
		object.setOdbDaySndFlag((Integer) map.get(COLUMNS.ODB_DAY_SND_FLAG));
		}
		if (map.get(COLUMNS.ROUND_FLAG) != null) {
		object.setRoundFlag((Integer) map.get(COLUMNS.ROUND_FLAG));
		}
		if (map.get(COLUMNS.REM_TAG_NO) != null) {
		object.setRemTagNo((String) map.get(COLUMNS.REM_TAG_NO));
		}
		if (map.get(COLUMNS.SCR_UPDATE_FLAG) != null) {
		object.setScrUpdateFlag((Integer) map.get(COLUMNS.SCR_UPDATE_FLAG));
		}
		if (map.get(COLUMNS.TAG_LOGIC_NAME1) != null) {
		object.setTagLogicName1((String) map.get(COLUMNS.TAG_LOGIC_NAME1));
		}
		if (map.get(COLUMNS.TAG_LOGIC_NAME2) != null) {
		object.setTagLogicName2((String) map.get(COLUMNS.TAG_LOGIC_NAME2));
		}
		if (map.get(COLUMNS.TAG_LOGIC_NAME3) != null) {
		object.setTagLogicName3((String) map.get(COLUMNS.TAG_LOGIC_NAME3));
		}
		if (map.get(COLUMNS.TAG_LOGIC_NAME4) != null) {
		object.setTagLogicName4((String) map.get(COLUMNS.TAG_LOGIC_NAME4));
		}
		if (map.get(COLUMNS.CURRENT_DATA_FLAG) != null) {
		object.setCurrentDataFlag((String) map.get(COLUMNS.CURRENT_DATA_FLAG));
		}
		if (map.get(COLUMNS.HOURLY_DATA_FLAG) != null) {
		object.setHourlyDataFlag((String) map.get(COLUMNS.HOURLY_DATA_FLAG));
		}
		if (map.get(COLUMNS.DAILY_DATA_FLAG) != null) {
		object.setDailyDataFlag((String) map.get(COLUMNS.DAILY_DATA_FLAG));
		}
		if (map.get(COLUMNS.MONTHLY_DATA_FLAG) != null) {
		object.setMonthlyDataFlag((String) map.get(COLUMNS.MONTHLY_DATA_FLAG));
		}
		if (map.get(COLUMNS.CLOSE_KIND) != null) {
		object.setCloseKind((String) map.get(COLUMNS.CLOSE_KIND));
		}
	}


	private static void convertModelListToMapList(final List<CmmTagMasterV> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmTagMasterV object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmTagMasterV object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getLcode() != null) {
			data.put(COLUMNS.LCODE, object.getLcode());
		}
		if (object.getComment1() != null) {
			data.put(COLUMNS.COMMENT1, object.getComment1());
		}
		if (object.getUnitComputer() != null) {
			data.put(COLUMNS.UNIT_COMPUTER, object.getUnitComputer());
		}
		if (object.getDp() != null) {
			data.put(COLUMNS.DP, object.getDp());
		}
		if (object.getUpperValue() != null) {
			data.put(COLUMNS.UPPER_VALUE, object.getUpperValue());
		}
		if (object.getLowerValue() != null) {
			data.put(COLUMNS.LOWER_VALUE, object.getLowerValue());
		}
		if (object.getTagKind() != null) {
			data.put(COLUMNS.TAG_KIND, object.getTagKind());
		}
		if (object.getIoKind() != null) {
			data.put(COLUMNS.IO_KIND, object.getIoKind());
		}
		if (object.getConstDiv() != null) {
			data.put(COLUMNS.CONST_DIV, object.getConstDiv());
		}
		if (object.getRepoDiv() != null) {
			data.put(COLUMNS.REPO_DIV, object.getRepoDiv());
		}
		if (object.getRepoCalcDiv() != null) {
			data.put(COLUMNS.REPO_CALC_DIV, object.getRepoCalcDiv());
		}
		if (object.getOdbMinSndFlag() != null) {
			data.put(COLUMNS.ODB_MIN_SND_FLAG, object.getOdbMinSndFlag());
		}
		if (object.getOdbHourSndFlag() != null) {
			data.put(COLUMNS.ODB_HOUR_SND_FLAG, object.getOdbHourSndFlag());
		}
		if (object.getOdbDaySndFlag() != null) {
			data.put(COLUMNS.ODB_DAY_SND_FLAG, object.getOdbDaySndFlag());
		}
		if (object.getRoundFlag() != null) {
			data.put(COLUMNS.ROUND_FLAG, object.getRoundFlag());
		}
		if (object.getRemTagNo() != null) {
			data.put(COLUMNS.REM_TAG_NO, object.getRemTagNo());
		}
		if (object.getScrUpdateFlag() != null) {
			data.put(COLUMNS.SCR_UPDATE_FLAG, object.getScrUpdateFlag());
		}
		if (object.getTagLogicName1() != null) {
			data.put(COLUMNS.TAG_LOGIC_NAME1, object.getTagLogicName1());
		}
		if (object.getTagLogicName2() != null) {
			data.put(COLUMNS.TAG_LOGIC_NAME3, object.getTagLogicName2());
		}
		if (object.getTagLogicName3() != null) {
			data.put(COLUMNS.TAG_LOGIC_NAME3, object.getTagLogicName3());
		}
		if (object.getTagLogicName4() != null) {
			data.put(COLUMNS.TAG_LOGIC_NAME4, object.getTagLogicName4());
		}
		if (object.getCurrentDataFlag() != null) {
			data.put(COLUMNS.CURRENT_DATA_FLAG, object.getCurrentDataFlag());
		}
		if (object.getHourlyDataFlag() != null) {
			data.put(COLUMNS.HOURLY_DATA_FLAG, object.getHourlyDataFlag());
		}
		if (object.getDailyDataFlag() != null) {
			data.put(COLUMNS.DAILY_DATA_FLAG, object.getDailyDataFlag());
		}
		if (object.getMonthlyDataFlag() != null) {
			data.put(COLUMNS.MONTHLY_DATA_FLAG, object.getMonthlyDataFlag());
		}
		if (object.getCloseKind() != null) {
			data.put(COLUMNS.CLOSE_KIND, object.getCloseKind());
		}
	}

	private static CmmTagMasterVExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.TAG_NO)) {
				String value = (String) searchingOption.get(COLUMNS.TAG_NO);
				example.createCriteria().andTagNoEqualTo(value);
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
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		example.createCriteria().andTagNoEqualTo(tagNo);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<CmmTagMasterVDao.COLUMNS, Object> searchingOption) {
		CmmTagMasterVExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final CmmTagMasterVExample example) {
		CmmTagMasterVMapper mapper = session.getMapper(CmmTagMasterVMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<CmmTagMasterVDao.COLUMNS, Object> searchingOption) {
		CmmTagMasterVExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		return select(session, example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<Map<CmmTagMasterVDao.COLUMNS, Object>>
	 */
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectByTagNoList(final SqlSession session, final List<String> tagNoList) {
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		example.createCriteria().andTagNoIn(tagNoList);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<Map<CmmTagMasterVDao.COLUMNS, Object>>
	 */
	public static List<Map<CmmTagMasterVDao.COLUMNS, Object>> selectBylogicNameList(final SqlSession session, final List<List<String>> logicNameList) {
		CmmTagMasterVExample example = new CmmTagMasterVExample();
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

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final CmmTagMasterVExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmmTagMasterVMapper mapper = session.getMapper(CmmTagMasterVMapper.class);
		List<CmmTagMasterV> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
