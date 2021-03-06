package job.sfcommon.dataaccess.dao.nhlng;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtMessageDao メッセージデータDAO
 * @author D.Suzuki
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtMessage;
import job.sfcommon.dataaccess.entity.nhlng.CmtMessageExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtMessageMapper;

/** メッセージデータDAO */
public class CmtMessageDao {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** 表示順カラム名 */
	private static final String SEQNO_COLUMN_NAME = COLUMNS.SEQ_NO.toString();

	/** テーブル名 */
	public static final String TABLE_NAME;

	/** カラム名を表す変数 */
	public static enum COLUMNS {
		/** シーケンスNO */
		SEQ_NO,
		/** メッセージ日時 */
		MSG_DATETIME,
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
		TABLE_NAME = "CmtMessage";
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
	private CmtMessageDao() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	/*
	private static void convertMapListToModelList(final List<Map<COLUMNS, Object>> mapList, final List<Users> objectList) throws InstantiationException, IllegalAccessException {
		if (mapList == null) { return; }
		for (Map<COLUMNS, Object> map : mapList) {
			Users object = new Users();
			convertMapToModel(map, object);
			objectList.add(object);
		}
	}

	private static void convertMapToModel(final Map<COLUMNS, Object> map, final CmtMessage object) {
		if (map == null) { return; }
		object.setSeqNo((Integer) map.get(COLUMNS.SEQ_NO));
		object.setMsgDatetime((Date) map.get(COLUMNS.MSG_DATETIME));
		object.setMsgId((String) map.get(COLUMNS.MSG_ID));
		object.setMsgCat((String) map.get(COLUMNS.MSG_CAT));
		object.setMsgKind((String) map.get(COLUMNS.MSG_KIND));
		object.setMsgText((String) map.get(COLUMNS.MSG_TEXT));

	}

	private static void convertModelListToMapList(final List<CmtMessage> objectList, final List<Map<COLUMNS, Object>> mapList) {
		if (objectList == null) { return; }
		for (CmtMessage object : objectList) {
			Map<COLUMNS, Object> map = new HashMap<>();
			convertModelToMap(object, map);
			mapList.add(map);
		}
	}

	private static void convertModelToMap(final CmtMessage object, final Map<COLUMNS, Object> data) {
		if (object == null) { return; }
		if (object.getSeqNo() != null) {
			data.put(COLUMNS.SEQ_NO, object.getSeqNo());
		}
		if (object.getMsgDatetime() != null) {
			data.put(COLUMNS.MSG_DATETIME, object.getMsgDatetime());
		}
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

	private static CmtMessageExample makeEqualToMatchingExample(final Map<COLUMNS, Object> searchingOption) {
		// WHERE clause
		CmtMessageExample example = new CmtMessageExample();
		if (searchingOption.size() > 0) {
			if (searchingOption.containsKey(COLUMNS.SEQ_NO)) {
				Integer value = (Integer) searchingOption.get(COLUMNS.SEQ_NO);
				example.createCriteria().andSeqNoEqualTo(value);
			}
		}
		return example;
	}
	*/

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return long 件数
	 */
	public static long count(final SqlSession session, final CmtMessageExample example) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return List<CmtMessage> メッセージデータ
	 */
	public static List<CmtMessage> select(final SqlSession session, final CmtMessageExample example) {
		// ORDER BY clause
		example.setOrderByClause(SEQNO_COLUMN_NAME);

		// Select.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		List<CmtMessage> result = mapper.selectByExample(example);
		return result;
	}

	/**
	 * @param session SqlSession
	 * @param data メッセージデータ
	 * @return int 件数
	 */
	public static int insert(final SqlSession session, final CmtMessage data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String msgId = data.getMsgId();
		Validator.requireNonNullAndNonEmpty(msgId, "msgId");

		// Insert.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.insertSelective(data);
	}

	/**
	 * @param session SqlSession
	 * @param record メッセージデータリスト
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int updateByExampleSelective(final SqlSession session, final CmtMessage record, final CmtMessageExample example) {
		// Update.
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.updateByExampleSelective(record, example);
	}

	/**
	 * @param session SqlSession
	 * @param example 絞り込み条件
	 * @return int 件数
	 */
	public static int deleteByExample(final SqlSession session, final CmtMessageExample example) {
		CmtMessageMapper mapper = session.getMapper(CmtMessageMapper.class);
		return mapper.deleteByExample(example);
	}
}
