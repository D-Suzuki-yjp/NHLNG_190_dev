package job.sfcommon.dataaccess.dao.looponexcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Converter;
import job.sfcommon.dataaccess.entity.looponexCore.MSubsystem;
import job.sfcommon.dataaccess.entity.looponexCore.MSubsystemExample;
import job.sfcommon.dataaccess.mapper.looponexCore.MSubsystemMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/26 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * MSubsystemDao サブシステムマスタDAO
 * @author D.Suzuki
 */
@Dependent
public class MSubsystemDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CLOSEDTIME_COLUMN_NAME = COLUMNS.SUBSYSTEM_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** サブシステムID */
		SUBSYSTEM_ID,
		/** サブシステム名称 */
		SUBSYSTEM_NAME,
		/** サブシステム種別 */
		SUBSYSTEM_TYPE,
		/** 有効サブシステムの有効無効 */
		IS_ENABLE,
		/** テスト機能利用 */
		IS_TEST,
		/** 備考 */
		MEMO,
		/** サブシステムアドレス */
		SUBSYSTEM_ADDRESS,
		/** サブシステムポート番号 */
		SUBSYSTEM_PORT,
		/** 秘密鍵ストアパス */
		KEY_STORE_PATH,
		/** 秘密鍵パスフレーズ */
		KEY_PASSPHRASE,
		/** トラストストアキーストアパス */
		TRUST_STORE_PATH,
		/** トラストストアパスフレーズ */
		TRUST_PASSPHRASE,
		/** 表示順 */
		DISP_SEQ,
		/** 画面ポート番号 */
		SUBSYSTEM_WEB_PORT;
	}

	static {
		TABLE_NAME = "MSubsystem";
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
	private MSubsystemDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<MSubsystem> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			MSubsystem object = new MSubsystem();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}


	private static void convertMapToModel(final Map<COLUMNS, Object> map, final MSubsystem object) {
		if (map == null) { return; }
		object.setSubsystemId((String) map.get(COLUMNS.SUBSYSTEM_ID));
		object.setSubsystemName((String) map.get(COLUMNS.SUBSYSTEM_NAME));
		object.setSubsystemType((Integer) map.get(COLUMNS.SUBSYSTEM_TYPE));
		object.setIsEnable((boolean) map.get(COLUMNS.IS_ENABLE));
		object.setIsTest((boolean) map.get(COLUMNS.IS_TEST));
		object.setMemo((String) map.get(COLUMNS.MEMO));
		object.setSubsystemAddress((String) map.get(COLUMNS.SUBSYSTEM_ADDRESS));
		object.setSubsystemPort((Integer) map.get(COLUMNS.SUBSYSTEM_PORT));
		object.setKeyStorePath((String) map.get(COLUMNS.KEY_STORE_PATH));
		object.setKeyPassphrase((String) map.get(COLUMNS.KEY_PASSPHRASE));
		object.setTrustStorePath((String) map.get(COLUMNS.TRUST_STORE_PATH));
		object.setTrustPassphrase((String) map.get(COLUMNS.TRUST_PASSPHRASE));
		object.setDispSeq((Integer) map.get(COLUMNS.DISP_SEQ));
		object.setSubsystemPort((Integer) map.get(COLUMNS.SUBSYSTEM_WEB_PORT));
	}
	*/

	private static void convertModelListToMapList(final List<MSubsystem> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (MSubsystem object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final MSubsystem object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getSubsystemId() != null) {
			data.put(COLUMNS.SUBSYSTEM_ID, object.getSubsystemId());
		}
		if (object.getSubsystemName() != null) {
			data.put(COLUMNS.SUBSYSTEM_NAME, object.getSubsystemName());
		}
		if (object.getSubsystemType() != null) {
			data.put(COLUMNS.SUBSYSTEM_TYPE, object.getSubsystemType());
		}
		if (object.getIsEnable() != null) {
			data.put(COLUMNS.IS_ENABLE, object.getIsEnable());
		}
		if (object.getIsTest() != null) {
			data.put(COLUMNS.IS_TEST, object.getIsTest());
		}
		if (object.getMemo() != null) {
			data.put(COLUMNS.MEMO, object.getMemo());
		}
		if (object.getSubsystemAddress() != null) {
			data.put(COLUMNS.SUBSYSTEM_ADDRESS, object.getSubsystemAddress());
		}
		if (object.getSubsystemPort() != null) {
			data.put(COLUMNS.SUBSYSTEM_PORT, object.getSubsystemPort());
		}
		if (object.getKeyStorePath() != null) {
			data.put(COLUMNS.KEY_STORE_PATH, object.getKeyStorePath());
		}
		if (object.getKeyPassphrase() != null) {
			data.put(COLUMNS.KEY_PASSPHRASE, object.getKeyPassphrase());
		}
		if (object.getTrustStorePath() != null) {
			data.put(COLUMNS.TRUST_STORE_PATH, object.getTrustStorePath());
		}
		if (object.getTrustPassphrase() != null) {
			data.put(COLUMNS.TRUST_PASSPHRASE, object.getTrustPassphrase());
		}
		if (object.getDispSeq() != null) {
			data.put(COLUMNS.DISP_SEQ, object.getDispSeq());
		}
		if (object.getSubsystemWebPort() != null) {
			data.put(COLUMNS.SUBSYSTEM_WEB_PORT, object.getSubsystemWebPort());
		}
	}

	private static MSubsystemExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		MSubsystemExample example = new MSubsystemExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SUBSYSTEM_ID)) {
				String value = (String) searchingOption.get(COLUMNS.SUBSYSTEM_ID);
				example.createCriteria().andSubsystemIdEqualTo(value);
			}
		}
		return example;
	}

	private static MSubsystemExample makePartialMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		MSubsystemExample example = new MSubsystemExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SUBSYSTEM_ID)) {
				String value1 = Converter.buildPartialMatchStringInSQL((String) searchingOption.get(COLUMNS.SUBSYSTEM_ID));
				example.createCriteria().andSubsystemIdLike(value1);
			}
		}
		return example;
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countByPrimaryKey(final SqlSession session, final String closeDtime) {
		MSubsystemExample example = new MSubsystemExample();
		example.createCriteria().andSubsystemIdEqualTo(closeDtime);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countEqualToMatching(final SqlSession session, final Map<MSubsystemDao.COLUMNS, Object> searchingOption) {
		MSubsystemExample example = makeEqualToMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static long countPartialMatchingMatching(final SqlSession session, final Map<MSubsystemDao.COLUMNS, Object> searchingOption) {
		MSubsystemExample example = makePartialMatchingExample(searchingOption);
		return count(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static long countAllRecord(final SqlSession session) {
		MSubsystemExample example = new MSubsystemExample();
		return count(session, example);
	}

	private static long count(final SqlSession session, final MSubsystemExample example) {
		MSubsystemMapper mapper = session.getMapper(MSubsystemMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param id
	 * @return
	 */
	public static Map<MSubsystemDao.COLUMNS, Object> selectByPrimaryKey(final SqlSession session, final String subsystemId) {
		MSubsystemMapper mapper = session.getMapper(MSubsystemMapper.class);
		MSubsystem record = mapper.selectByPrimaryKey(subsystemId);

		Map<COLUMNS, Object> result = new HashMap<>();
		convertModelToMap(record, result);
		return result;
	}

	/**
	 * @param session
	 * @param searchingOption
	 * @return
	 */
	public static List<Map<MSubsystemDao.COLUMNS, Object>> selectEqualToMatching(final SqlSession session, final Map<MSubsystemDao.COLUMNS, Object> searchingOption) {
		MSubsystemExample example = makeEqualToMatchingExample(searchingOption);
		return select(session, example);
	}

	/**
	 * @param session
	 * @return
	 */
	public static List<Map<MSubsystemDao.COLUMNS, Object>> selectAllRecord(final SqlSession session) {
		MSubsystemExample example = new MSubsystemExample();
		return select(session, example);
	}

	private static List<Map<COLUMNS, Object>> select(final SqlSession session, final MSubsystemExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		MSubsystemMapper mapper = session.getMapper(MSubsystemMapper.class);
		List<MSubsystem> recordList = mapper.selectByExample(example);

		// Convert and return.
		List<Map<COLUMNS, Object>> result = new ArrayList<>();
		convertModelListToMapList(recordList, result);
		return result;
	}
}
