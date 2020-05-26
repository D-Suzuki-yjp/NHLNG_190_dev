package job.sfcommon.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.dao.nhlng.CmtCloseMonDao;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDay;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHour;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMon;
import job.sfcommon.dto.CmtCloseDayDto;
import job.sfcommon.dto.CmtCloseMonDto;
import job.sfcommon.dto.CmtCloseMonDto.NhCloseMonData;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/07 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CloseUtil NH締めデータユーティリティ共通クラス<br>
 * * @author D.Suzuki
 */
@Dependent
public class CloseUtil {

	/**
	 * TODO スケルトン
	 * 時締データ読込共通関数
	 * @param session SQLセッション
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return Map<String[],List<CmtCloseHour>> マップ<タグ論理名,リスト<タグNo,値,収集日時>>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Date,List<CmtCloseHour>> nhHourCloseRead(SqlSession session, final Date fromDate, final Date toDate) throws RuntimeException{

//		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		// return用オブジェクトをインスタンス
//		Map<Date,List<CmtCloseHour>> resultMap = new HashMap();
//		List<CmtCloseHour> cmtCloseHourList = new ArrayList();
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try{
//			cmtCloseHourList = CmtCloseHourDao.selectBetweenDate(session, fromDate, toDate);
//		}catch(Exception e){
//			throw new RuntimeException(e);
//		}
//
//		// 戻り値を締め日時でGroupByマッピング
//		resultMap = cmtCloseHourList.stream().collect(Collectors.groupingBy(CmtCloseHour::getCloseDtime));
//
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return null;
	}


	/**
	 * NH時締めデータ書込共通関数
	 *  TODO スケルトン
	 * @param session SQLセッション
	 * @param List<CmtCloseHourDto> NH時締データリスト
	 * @return boolean 書込み結果
	 */
	public static boolean nhHourCloseWrite(SqlSession session, final List<CmtCloseHour> CmtCloseHourList) throws RuntimeException{

		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try {
//			CmtCloseHourDao.insertOrUpdate(session, CmtCloseHourList);
//			session.commit();
//		} catch (Exception e) {
//			session.rollback();
//			throw(new RuntimeException());
//		} finally {
//			session.close();
//		}
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}

	/**
	 * 日締データ読込共通関数(論理名)
	 *  TODO スケルトン
	 * @param logicNameList タグ論理名
	 * @return Map<String[],List<CmtCloseDay>> マップ<タグ論理名,リスト<タグNo,値,収集日時>>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, List<CmtCloseDay>> nhDayCloseReadByLogicalName(SqlSession session, final List<String> logicNameList) throws RuntimeException{

//		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		// return用オブジェクトをインスタンス
//		Map<String, List<CmtCloseDay>> cmtCloseDayMap = new HashMap();
//
//		Date date = new Date();
//		DateUtil.moldYYYYMMDD(date);
//		List<CmtCloseDay> resultList = new ArrayList();
//		CmtCloseDayExample example = new CmtCloseDayExample();
//		example.createCriteria().andCloseDtimeEqualTo(date);
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		for(int i=0; i<ConstUtil.TAGLOGICNAME_ARRAY; i++){
//			if(0==i && Objects.nonNull(logicNameList.get(0))){
//				example.addCriteria().andTagLogicName1EqualTo(logicNameList.get(0));
//			}
//			if(1==i && Objects.nonNull(logicNameList.get(1))){
//				example.addCriteria().andTagLogicName2EqualTo(logicNameList.get(1));
//			}
//			if(2==i && Objects.nonNull(logicNameList.get(2))){
//				example.addCriteria().andTagLogicName3EqualTo(logicNameList.get(2));
//			}
//			if(3==i && Objects.nonNull(logicNameList.get(3))){
//				example.addCriteria().andTagLogicName4EqualTo(logicNameList.get(3));
//			}
//
//			try{
//				resultList = CmtCloseDayDao.ExSelect(session, example);
//			}catch(Exception e){
//				session.close();
//				throw new RuntimeException(e);
//			}
//			cmtCloseDayMap.put(logicNameList.get(i),resultList);
//		}
//
//		session.close();
//
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return null;
	}

	/**
	 * NH日締めデータ書込共通関数
	 *  TODO スケルトン
	 * @param session SQLセッション
	 * @param List<CmtCloseDayDto> NH日締データリスト
	 * @return boolean 書込み結果
	 */
	public static boolean nhDayCloseWrite(SqlSession session, final List<CmtCloseDay> cmtCloseDayList) throws RuntimeException{

//		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try {
//			CmtCloseDayDao.insertOrUpdate(session, cmtCloseDayList);
//			session.commit();
//		} catch (Exception e) {
//			session.rollback();
//			throw(new RuntimeException());
//		} finally {
//			session.close();
//		}
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}


	/**
	 * NH日締めデータ書込共通関数
	 *  TODO 要処理仕様再考
	 * @param session SQLセッション
	 * @param List<CmtCloseDayDto> NH日締データリスト
	 * @return boolean 書込み結果
	 */
	public static boolean nhDayCloseWriteByLogicalName(SqlSession session, final List<CmtCloseDayDto> cmtCloseDayDtoList) throws RuntimeException{

		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		Map<String[], List<CmtCloseDay>> m = new HashMap();
//		List<String[]> logicNameList = new ArrayList();
//		List<CmtCloseDay> cmtCloseDayLsit = new ArrayList();
//		for(CmtCloseDayDto cmtCloseDayDto : cmtCloseDayDtoList){
//			String[] tagLogicName = new String[4];
//			tagLogicName[0] = cmtCloseDayDto.getTagLogicalName1();
//			tagLogicName[1] = null;
//			tagLogicName[2] = null;
//			tagLogicName[3] = null;
//			logicNameList.add(tagLogicName);
//
//			CmtCloseDay cmtCloseDay = new CmtCloseDay();
//			cmtCloseDay.setCloseDtime(cmtCloseDayDto.getCollDTime());
//			cmtCloseDay.setTagData(cmtCloseDayDto.getTagData());
//			cmtCloseDay.setQltyCd(cmtCloseDayDto.getQltyCd());
//
//			/** TODO パラメータでもらわないと不可能 */
//			cmtCloseDay.setLastUpdUser("TEST");
//
//			cmtCloseDayLsit.add(cmtCloseDay);
//			m.put(tagLogicName, cmtCloseDayLsit);
//		}
//
//		Map<String[], List<CmmTagMasterV>> CmmTagMasterVMap = TagUtil.selectCmtTagMasterByLogicalName(logicNameList);
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try {
//			for(String[] LogicName : logicNameList){
//				for(CmmTagMasterV cmmTagMasterV : CmmTagMasterVMap.get(LogicName)){
//					for(CmtCloseDay cmtCloseDay:m.get(LogicName)){
//						cmtCloseDay.setTagNo(cmmTagMasterV.getTagNo());
//					}
//			}
//			CmtCloseDayDao.insertOrUpdate(session, m.get(LogicName));
//			}
//			session.commit();
//		} catch (Exception e) {
//			session.rollback();
//			throw(new RuntimeException());
//		} finally {
//			session.close();
//		}
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}

	/**
	 * NH月締めデータ読込共通関数
	 *  TODO スケルトン
	 * @param session SQLセッション
	 * @param fromDate 検索条件From日時
	 * @param toDate 検索条件To日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Date, List<CmtCloseMon>> nhMonCloseRead(SqlSession session, final Date fromDate, final Date toDate) throws RuntimeException{

		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName() + "," + fromDate + "," + toDate};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		// 検索日時を月に丸める
//		Date fromDateCorrected = null;
//		if(Objects.nonNull(fromDate)){
//			fromDateCorrected = DateUtil.moldYYYYMM(fromDate);
//		}
//		Date toDateCorrected = null;
//		if(Objects.nonNull(toDate)){
//			toDateCorrected = DateUtil.moldYYYYMM(toDate);
//		}
//
//		List<CmtCloseMon> results = new ArrayList();
//		CmtCloseMonExample example = new CmtCloseMonExample();
//		example.createCriteria();
//		if(Objects.isNull(fromDateCorrected)){
//			example.addCriteria().andCloseDtimeLessThanOrEqualTo(toDateCorrected);
//		} else if(Objects.isNull(toDateCorrected)){
//			example.addCriteria().andCloseDtimeGreaterThanOrEqualTo(fromDateCorrected);
//		}else{
//			example.addCriteria().andCloseDtimeBetween(fromDateCorrected, toDateCorrected);
//		}
//
//		//From日時,To日時でNH日締データテーブル検索
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try {
//			results = CmtCloseMonDao.select(session, example);
//		} catch (Exception e) {
//			throw(new RuntimeException());
//		} finally {
//			session.close();
//		}
//
//		// 使用済変数を初期化
//		fromDateCorrected = null;
//		toDateCorrected = null;
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<NhCloseMonData> closeMonDataConvert(List<Map<CmtCloseMonDao.COLUMNS, Object>> mapList) {
		CmtCloseMonDto nhCloseMonDto = new CmtCloseMonDto();
		List<NhCloseMonData> nhCloseMonDataList = new ArrayList();
		NhCloseMonData nhCloseMonData;
		for (Map<CmtCloseMonDao.COLUMNS, Object> map : mapList) {
			nhCloseMonData = nhCloseMonDto.new NhCloseMonData();
			nhCloseMonData.setCloseDTime(DateUtil.moldYYYYMMDDHH((Date) map.get(CmtCloseMonDao.COLUMNS.CLOSE_DTIME)));
			nhCloseMonData.setTagData((String) map.get(CmtCloseMonDao.COLUMNS.TAG_DATA));
			nhCloseMonData.setQltyCd((Integer) map.get(CmtCloseMonDao.COLUMNS.QLTY_CD));
			nhCloseMonDataList.add(nhCloseMonData);
			nhCloseMonData = null;
			map = null;
		}
		return nhCloseMonDataList;
	}

	/**
	 * TODO スタブ状態
	 * 月締データ読込共通関数(論理名)
	 *  TODO スケルトン
	 * @param session SQLセッション
	 * @param logicNameList タグ論理名
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<CmtCloseMonDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseMonDto> nhMonCloseReadByLogicalName(SqlSession session, final List<String> logicNameList, final Date fromDate, final Date toDate) throws RuntimeException{

		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		// return用オブジェクトをインスタンス
//		List<CmtCloseMonDto> cmtCloseMonDtoList = new ArrayList();
//
//		Date date = new Date();
//		CmtCloseMonDto cmtCloseMonDto1 = new CmtCloseMonDto();
//		List<NhCloseMonData> cmtCloseMonList1 = new ArrayList();
//
//		cmtCloseMonDto1.setTagNo("TL111");
//		if(Objects.nonNull(fromDate)){
//			for(int i=1; i<=10; i++){
//				NhCloseMonData nhCloseMonData = cmtCloseMonDto1.new NhCloseMonData();
//				nhCloseMonData.setTagData("1."+i);
//				nhCloseMonData.setQltyCd(10*i);
//				nhCloseMonData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
//				cmtCloseMonList1.add(nhCloseMonData);
//			}
//		}else{
//			NhCloseMonData nhCloseMonData = cmtCloseMonDto1.new NhCloseMonData();
//			nhCloseMonData.setTagData("1.1");
//			nhCloseMonData.setQltyCd(100);
//			nhCloseMonData.setCloseDTime(date);
//			cmtCloseMonList1.add(nhCloseMonData);
//		}
//		cmtCloseMonDto1.setNhCloseMonDataList(cmtCloseMonList1);
//		cmtCloseMonDtoList.add(cmtCloseMonDto1);
//
//		CmtCloseMonDto cmtCloseMonDto2 = new CmtCloseMonDto();
//		List<NhCloseMonData> cmtCloseMonList2 = new ArrayList();
//
//		cmtCloseMonDto2.setTagNo("TL112");
//		if(Objects.nonNull(fromDate)){
//			for(int i=1; i<=10; i++){
//				NhCloseMonData nhCloseMonData = cmtCloseMonDto2.new NhCloseMonData();
//				nhCloseMonData.setTagData("1."+i);
//				nhCloseMonData.setQltyCd(10*i);
//				nhCloseMonData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
//				cmtCloseMonList2.add(nhCloseMonData);
//			}
//		}else{
//			NhCloseMonData nhCloseMonData = cmtCloseMonDto2.new NhCloseMonData();
//			nhCloseMonData.setTagData("1.1");
//			nhCloseMonData.setQltyCd(100);
//			nhCloseMonData.setCloseDTime(date);
//			cmtCloseMonList2.add(nhCloseMonData);
//		}
//		cmtCloseMonDto2.setNhCloseMonDataList(cmtCloseMonList2);
//		cmtCloseMonDtoList.add(cmtCloseMonDto2);
//
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return null;
	}

	/**
	 * NH月締めデータ書込共通関数
	 *  TODO スケルトン
	 * @param session SQLセッション
	 * @param List<CmtCloseMonDto> NH月締データリスト
	 * @param LastUpdUser 最終更新者
	 * @return boolean 書込み結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean nhMonCloseWrite(SqlSession session, final List<CmtCloseMon> cmtCloseMonDtoList, String LastUpdUser) throws RuntimeException{

//		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try {
//			CmtCloseMonDao.insertOrUpdate(session, cmtCloseMonDtoList);
//			session.commit();
//		} catch (Exception e) {
//			session.rollback();
//			throw(new RuntimeException());
//		} finally {
//			session.close();
//		}
//		// 処理終了ログ
//		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}

	/**
	 * 日締処理
	 *  TODO スケルトン
	 * @param session SQLセッション
	 * @param Date targetDate 対象日時
	 * @param LastUpdUser 最終更新者(日締処理class名)
	 * @return boolean 処理結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean execDayClose(SqlSession session, final Date targetDate, final String className) throws RuntimeException{
		// 処理開始ログ
//		String[] param = { new Object() {
//		}.getClass().getEnclosingMethod().getName()};
//		OutPutLogs.outPutLogs("CMN", "001", param);
//
//		Date date = DateUtil.moldYYYYMMDD(targetDate);
//
//		// 日締処理
//		SqlSession session = SelectDb.dbAcssece("nhlng");
//		try{
//		int result = CmtCloseDayDao.dayClose(session, date, className);
//		}catch(Exception e){
//			session.rollback();
//			return false;
//		}finally{
//			session.close();
//			// 処理終了ログ
//			OutPutLogs.outPutLogs("CMN", "002", param);
//		}

		return true;
	}

	/**
	 * TODO スタブ状態
	 * 計算処理
	 * @param targetDate 対象日時
	 * @param calcKind 計算種別
	 * @return boolean 処理結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean calcData(final Date targetDate, final int calcKind) throws RuntimeException{
		return true;
	}
}