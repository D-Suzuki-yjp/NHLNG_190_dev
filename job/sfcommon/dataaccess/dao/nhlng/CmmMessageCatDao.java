package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmMessageCat;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageCatExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmMessageCatMapper;


/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageCatDao メッセージカテゴリマスタDAO
 * @author D.Suzuki
 */

public class CmmMessageCatDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String MSGCAT_COLUMN_NAME = COLUMNS.MSG_CAT.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージカテゴリ */
		MSG_CAT,
		/** カテゴリ名 */
		CAT_NAME;
	}

	static {
		TABLE_NAME = "CmmMessageCat";
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
	private CmmMessageCatDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmMessageCat> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmMessageCat object = new CmmMessageCat();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageCat object) {
		if (map == null) { return; }
		object.setMsgCat((String) map.get(COLUMNS.MSG_CAT));
		object.setCatName((String) map.get(COLUMNS.CAT_NAME));
	}

	private static void convertModelListToMapList(final List<CmmMessageCat> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmMessageCat object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmMessageCat object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getMsgCat() != null) {
			data.put(COLUMNS.MSG_CAT, object.getMsgCat());
		}
		if (object.getCatName() != null) {
			data.put(COLUMNS.CAT_NAME, object.getCatName());
		}
	}
	*/

	public static long count(final SqlSession session, final CmmMessageCatExample example) {
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		return mapper.countByExample(example);
	}

	public static List<CmmMessageCat> select(final SqlSession session, final CmmMessageCatExample example) {
		// ORDER BY clause
		example.setOrderByClause(MSGCAT_COLUMN_NAME);

		// Select.
		CmmMessageCatMapper mapper = session.getMapper(CmmMessageCatMapper.class);
		List<CmmMessageCat> result = mapper.selectByExample(example);
		return result;
	}
}
