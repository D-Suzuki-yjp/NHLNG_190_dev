package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageDefDao メッセージ定義マスタDAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDef;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDefExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmMessageDefMapper;

/** メッセージ定義マスタDAO */
public class CmmMessageDefDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String CMMMESSAGEDEF_COLUMN_NAME = COLUMNS.MSG_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージID */
		MSG_ID,
		/** メッセージカテゴリ */
		MSG_CAT,
		/** メッセージ種別 */
		MSG_KIND,
		/** メッセージテキスト */
		MSG_TEXT;
	}

	static {
		TABLE_NAME = "cmmMessageDef";
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
	private CmmMessageDefDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmMessageDef> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmMessageDef object = new CmmMessageDef();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageDef object) {
		if (map == null) { return; }
		object.setMsgId((String) map.get(COLUMNS.MSG_ID));
		object.setMsgCat((String) map.get(COLUMNS.MSG_CAT));
		object.setMsgKind((String) map.get(COLUMNS.MSG_KIND));
		object.setMsgText((String) map.get(COLUMNS.MSG_TEXT));
	}


	private static void convertModelListToMapList(final List<CmmMessageDef> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmMessageDef object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmMessageDef object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getMsgId() != null) {
			data.put(COLUMNS.MSG_ID, object.getMsgId());
		}
		if (object.getMsgCat() != null) {
			data.put(COLUMNS.MSG_CAT, object.getMsgCat());
		}
		if (object.getMsgKind() != null) {
			data.put(COLUMNS.MSG_KIND, object.getMsgKind());
		}
		if (object.getMsgText() != null) {
			data.put(COLUMNS.MSG_TEXT, object.getMsgText());
		}
	}
	*/

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final CmmMessageDefExample example) {
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmmMessageDef> メッセージ定義マスタ
	 */
	public static List<CmmMessageDef> select(final SqlSession session, final CmmMessageDefExample example) {
		// ORDER BY clause
		example.setOrderByClause(CMMMESSAGEDEF_COLUMN_NAME);

		// Select.
		CmmMessageDefMapper mapper = session.getMapper(CmmMessageDefMapper.class);
		List<CmmMessageDef> result = mapper.selectByExample(example);

		return result;
	}
}
