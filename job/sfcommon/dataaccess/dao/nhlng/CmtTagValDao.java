package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;
import java.util.Objects;



import org.apache.ibatis.session.SqlSession;

import biz.grandsight.ex.util.Validator;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagVal;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagValExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmtTagValMapper;

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

	public static long count(final SqlSession session, final CmtTagValExample example) {
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<CmtTagVal>
	 */
	public static List<CmtTagVal> selectByTagNoList(final SqlSession session,
			final List<String> tagNoList) {
		CmtTagValExample example = new CmtTagValExample();
		example.createCriteria().andTagNoIn(tagNoList);
		return select(session, example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<CmtTagVal>
	 */
	public static List<CmtTagVal> selectBylogicNameList(final SqlSession session,
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

	public static List<CmtTagVal> select(final SqlSession session,
			final CmtTagValExample example) {
		// ORDER BY clause
		example.setOrderByClause(TAGNO_COLUMN_NAME);

		// Select.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		List<CmtTagVal> result = mapper.selectByExample(example);
		return result;
	}

	public static List<CmtTagVal> ExSelect(final SqlSession session,
			final CmtTagValExample example) {
		// ORDER BY clause
		example.setOrderByClause(TAGNO_COLUMN_NAME);

		// Select.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		List<CmtTagVal> result = mapper.selectByExtendedExample(example);
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
	public static int insert(final SqlSession session, final CmtTagVal data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tagNo = data.getTagNo();
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Insert.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.insertSelective(data);
	}

	public static int updateByPrimaryKey(final SqlSession session, final CmtTagVal data) {
		// Validate.
		Validator.requireNonNull(data, "data");
		String tagNo = data.getTagNo();
		Validator.requireNonNullAndNonEmpty(tagNo, "tagNo");

		// Update.
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.updateByPrimaryKeySelective(data);
	}

	public static int deleteByPrimaryKey(final SqlSession session, final String tagNo) {
		CmtTagValMapper mapper = session.getMapper(CmtTagValMapper.class);
		return mapper.deleteByPrimaryKey(tagNo);
	}

}
