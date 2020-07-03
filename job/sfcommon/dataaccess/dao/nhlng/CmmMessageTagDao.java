package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageTagDao メッセージタグ出力マスタDAO
 * @author D.Suzuki
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmMessageTag;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageTagExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmMessageTagMapper;

/** メッセージタグ出力マスタDAO */
public class CmmMessageTagDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String MSGID_COLUMN_NAME = COLUMNS.MSG_ID.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** メッセージID */
		MSG_ID,
		/** シーケンスNO */
		SEQ_NO,
		/** タグNO */
		TAG_NO,
		/** タグ値 */
		TAG_VAL;
	}

	static {
		TABLE_NAME = "CmmMessageTag";
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
	private CmmMessageTagDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<CmmMessageTag> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			CmmMessageTag object = new CmmMessageTag();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmmMessageTag object) {
		if (map == null) { return; }
		object.setMsgId((String) map.get(COLUMNS.MSG_ID));
		object.setSeqNo((Integer) map.get(COLUMNS.SEQ_NO));
		object.setTagNo((String) map.get(COLUMNS.TAG_NO));
		object.setTagVal((BigDecimal) map.get(COLUMNS.TAG_VAL));
	}


	private static void convertModelListToMapList(final List<CmmMessageTag> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmmMessageTag object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmmMessageTag object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getMsgId() != null) {
			data.put(COLUMNS.MSG_ID, object.getMsgId());
		}
		if (object.getSeqNo() != null) {
			data.put(COLUMNS.SEQ_NO, object.getSeqNo());
		}
		if (object.getTagNo() != null) {
			data.put(COLUMNS.TAG_NO, object.getTagNo());
		}
		if (object.getTagVal() != null) {
			data.put(COLUMNS.TAG_VAL, object.getTagVal());
		}
	}
	*/

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final CmmMessageTagExample example) {
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmmMessageTag> メッセージタグ出力マスタ
	 */
	public static List<CmmMessageTag> select(final SqlSession session, final CmmMessageTagExample example) {
		// ORDER BY clause
		example.setOrderByClause(MSGID_COLUMN_NAME);

		// Select.
		CmmMessageTagMapper mapper = session.getMapper(CmmMessageTagMapper.class);
		List<CmmMessageTag> result = mapper.selectByExample(example);

		return result;
	}
}
