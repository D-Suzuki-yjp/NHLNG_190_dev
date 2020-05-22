package job.sfcommon.dataaccess.dao.nhlng;

import java.util.List;
import java.util.Objects;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterV;
import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterVExample;
import job.sfcommon.dataaccess.mapper.nhlng.CmmTagMasterVMapper;


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
@Dependent
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

	private static long count(final SqlSession session, final CmmTagMasterVExample example) {
		CmmTagMasterVMapper mapper = session.getMapper(CmmTagMasterVMapper.class);
		return mapper.countByExample(example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<CmmTagMaster>
	 */
	public static List<CmmTagMasterV> selectBylogicNameList(final SqlSession session, final String[] logicName) {
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		example.createCriteria();
		if(Objects.nonNull(logicName)){
			if(Objects.nonNull(logicName[0])){
				example.addCriteria().andTagLogicName1EqualTo(logicName[0]);
			}else if(Objects.nonNull(logicName[1])){
				example.addCriteria().andTagLogicName2EqualTo(logicName[1]);
			}else if(Objects.nonNull(logicName[2])){
				example.addCriteria().andTagLogicName3EqualTo(logicName[2]);
			}else if(Objects.nonNull(logicName[3])){
				example.addCriteria().andTagLogicName4EqualTo(logicName[3]);
			}
		}
		return select(session, example);
	}

	/**
	 * @param session
	 * @param tagNoList
	 * @return List<CmmTagMaster>
	 */
	public static List<CmmTagMasterV> selectCmtTagMasterForPrint(final SqlSession session, final List<String> repDivList) {
		CmmTagMasterVExample example = new CmmTagMasterVExample();
		example.createCriteria().andRepoDivIn(repDivList);
		return select(session, example);
	}

	public static List<CmmTagMasterV> select(final SqlSession session, final CmmTagMasterVExample example) {
		// ORDER BY clause
		example.setOrderByClause(CLOSEDTIME_COLUMN_NAME);

		// Select.
		CmmTagMasterVMapper mapper = session.getMapper(CmmTagMasterVMapper.class);
		List<CmmTagMasterV> result = mapper.selectByExample(example);
		return result;
	}
}
