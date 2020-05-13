package job.common.nhlngCommon.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.dao.nhlng.CmmTagMasterVDao;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtCloseDayDao;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtCloseHourDao;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtCloseMonDao;
import job.common.nhlngCommon.dto.CmtCloseDayDto;
import job.common.nhlngCommon.dto.CmtCloseDayDto.NhCloseDayData;
import job.common.nhlngCommon.dto.CmtCloseHourDto;
import job.common.nhlngCommon.dto.CmtCloseHourDto.NhCloseHourData;
import job.common.nhlngCommon.dto.CmtCloseMonDto;
import job.common.nhlngCommon.dto.CmtCloseMonDto.NhCloseMonData;
import job.common.nhlngCommon.dto.NhTagDataDto;
import job.common.nhlngCommon.function.outPutLogs.OutPutLogs;
import job.common.uiCommon.dataAccess.session.selectDb;

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
@RequestScoped
public class CloseUtil {

	/**
	 * NH時締めデータ読込共通関数
	 *
	 * @param tagNoList タグNoリスト
	 * @param fromDate 検索条件From日時
	 * @param toDate 検索条件To日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseHourDto> nhHourCloseRead(final List<String> tagNoList, final Date fromDate,
			final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// 検索日時を時に丸める
		Date fromDateCorrected = null;
		if(Objects.nonNull(fromDate)){
			fromDateCorrected = DateUtil.moldYYYYMMDDHH(fromDate);
		}
		Date toDateCorrected = null;
		if(Objects.nonNull(toDate)){
			toDateCorrected = DateUtil.moldYYYYMMDDHH(toDate);
		}

		// tagNoListリスト,From日時,To日時でNH時締データテーブル検索
		SqlSession session = selectDb.dbAcssece("nhlng");
		List<Map<CmtCloseHourDao.COLUMNS, Object>> results = new ArrayList();
		try {
			results = CmtCloseHourDao.selectByTagNoListBetweenDate(session, tagNoList, fromDateCorrected,
					toDateCorrected);
		} catch (RuntimeException e) {
			throw(e);
		} finally {
			session.close();
		}
		// 戻り値をGroupByマッピング
		Map<Object, List<Map<CmtCloseHourDao.COLUMNS, Object>>> resultMap = results.stream()
				.collect(Collectors.groupingBy(o -> o.get(CmtCloseHourDao.COLUMNS.TAG_NO)));

		// return用オブジェクトにラッパー
		List<CmtCloseHourDto> cmtCloseHourDtoList = new ArrayList();
		CmtCloseHourDto cmtCloseHourDto;
		for (Object tagNo : resultMap.keySet()) {
			cmtCloseHourDto = new CmtCloseHourDto();
			cmtCloseHourDto.setTagNo((String) tagNo);
			cmtCloseHourDto.setNhCloseHourDataList(closeHourDataConvert(resultMap.get((String) tagNo)));
			cmtCloseHourDtoList.add(cmtCloseHourDto);
			tagNo = null;
			cmtCloseHourDto = null;
		}

		// 使用済変数を初期化
		fromDateCorrected = null;
		toDateCorrected = null;
		results = null;
		resultMap = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);

		return cmtCloseHourDtoList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<NhCloseHourData> closeHourDataConvert(List<Map<CmtCloseHourDao.COLUMNS, Object>> mapList) {
		CmtCloseHourDto nhCloseHourDto = new CmtCloseHourDto();
		List<NhCloseHourData> nhCloseHourDataList = new ArrayList();
		NhCloseHourData nhCloseHourData;
		for (Map<CmtCloseHourDao.COLUMNS, Object> map : mapList) {
			nhCloseHourData = nhCloseHourDto.new NhCloseHourData();
			nhCloseHourData.setCloseDTime(DateUtil.moldYYYYMMDDHH((Date) map.get(CmtCloseHourDao.COLUMNS.CLOSE_DTIME)));
			nhCloseHourData.setTagData((String) map.get(CmtCloseHourDao.COLUMNS.TAG_DATA));
			nhCloseHourData.setQltyCd((Integer) map.get(CmtCloseHourDao.COLUMNS.QLTY_CD));
			nhCloseHourDataList.add(nhCloseHourData);
			nhCloseHourData = null;
			map = null;
		}
		return nhCloseHourDataList;
	}

	/**
	 * TODO スタブ状態
	 * 時締データ読込共通関数(論理名)
	 * @param logicNameList タグNoリスト(論理名)
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<HourHistoryDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseHourDto> nhHourCloseReadByLogicalName(final List<String> logicNameList, final Date fromDate, final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		List<CmtCloseHourDto> cmtCloseHourDtoList = new ArrayList();

		Date date = new Date();
		CmtCloseHourDto cmtCloseHourDto1 = new CmtCloseHourDto();
		List<NhCloseHourData> cmtCloseHourList1 = new ArrayList();

		cmtCloseHourDto1.setTagNo("TL111");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				NhCloseHourData nhCloseHourData = cmtCloseHourDto1.new NhCloseHourData();
				nhCloseHourData.setTagData("1."+i);
				nhCloseHourData.setQltyCd(10*i);
				nhCloseHourData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				cmtCloseHourList1.add(nhCloseHourData);
			}
		}else{
			NhCloseHourData nhCloseHourData = cmtCloseHourDto1.new NhCloseHourData();
			nhCloseHourData.setTagData("1.1");
			nhCloseHourData.setQltyCd(100);
			nhCloseHourData.setCloseDTime(date);
			cmtCloseHourList1.add(nhCloseHourData);
		}
		cmtCloseHourDto1.setNhCloseHourDataList(cmtCloseHourList1);
		cmtCloseHourDtoList.add(cmtCloseHourDto1);

		CmtCloseHourDto cmtCloseHourDto2 = new CmtCloseHourDto();
		List<NhCloseHourData> cmtCloseHourList2 = new ArrayList();

		cmtCloseHourDto2.setTagNo("TL112");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				NhCloseHourData nhCloseHourData = cmtCloseHourDto2.new NhCloseHourData();
				nhCloseHourData.setTagData("1."+i);
				nhCloseHourData.setQltyCd(10*i);
				nhCloseHourData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				cmtCloseHourList2.add(nhCloseHourData);
			}
		}else{
			NhCloseHourData nhCloseHourData = cmtCloseHourDto2.new NhCloseHourData();
			nhCloseHourData.setTagData("1.1");
			nhCloseHourData.setQltyCd(100);
			nhCloseHourData.setCloseDTime(date);
			cmtCloseHourList2.add(nhCloseHourData);
		}
		cmtCloseHourDto2.setNhCloseHourDataList(cmtCloseHourList2);
		cmtCloseHourDtoList.add(cmtCloseHourDto2);

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtCloseHourDtoList;
	}


	/**
	 * NH時締めデータ書込共通関数
	 * @param List<CmtCloseHourDto> NH時締データリスト
	 * @return boolean 書込み結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean nhHourCloseWrite(final List<CmtCloseHourDto> cmtCloseHourDtoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// NH時締めデータ書込用パラメータ作成
		List<Map<CmtCloseHourDao.COLUMNS, Object>> dataList = new ArrayList();
		Map<CmtCloseHourDao.COLUMNS, Object> data;
		for (CmtCloseHourDto cmtCloseHourDto : cmtCloseHourDtoList) {
			for (NhCloseHourData nhCloseHourData : cmtCloseHourDto.getNhCloseHourDataList()) {
				data = new HashMap();
				data.put(CmtCloseHourDao.COLUMNS.CLOSE_DTIME, nhCloseHourData.getCloseDTime());
				data.put(CmtCloseHourDao.COLUMNS.TAG_NO, (Object) cmtCloseHourDto.getTagNo());
				data.put(CmtCloseHourDao.COLUMNS.TAG_DATA, nhCloseHourData.getTagData());
				dataList.add(data);
				data = null;
			}
			cmtCloseHourDto = null;
		}

		SqlSession session = selectDb.dbAcssece("nhlng");
		try {
			CmtCloseHourDao.insertOrUpdate(session, dataList);
			session.commit();
		} catch (RuntimeException e) {
			throw(e);
		} finally {
			session.close();
			// 使用済変数を初期化
			dataList = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}

	/**
	 * NH日締めデータ読込共通関数
	 * @param tagNoList タグNoリスト
	 * @param fromDate 検索条件From日時
	 * @param toDate 検索条件To日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseDayDto> nhDayCloseRead(final List<String> tagNoList, final Date fromDate,
			final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// 検索日時を時に丸める
		Date fromDateCorrected = null;
		if(Objects.nonNull(fromDate)){
			fromDateCorrected = DateUtil.moldYYYYMMDD(fromDate);
		}
		Date toDateCorrected = null;
		if(Objects.nonNull(toDate)){
			toDateCorrected = DateUtil.moldYYYYMMDD(toDate);
		}

		// tagNoListリスト,From日時,To日時でNH日締データテーブル検索
		SqlSession session = selectDb.dbAcssece("nhlng");
		List<Map<CmtCloseDayDao.COLUMNS, Object>> results = new ArrayList();
		try {
			results = CmtCloseDayDao.selectByTagNoListBetweenDate(session, tagNoList, fromDateCorrected,
					toDateCorrected);
		} catch (RuntimeException e) {
			throw(e);
		} finally {
			session.close();
		}
		// 戻り値をGroupByマッピング
		Map<Object, List<Map<CmtCloseDayDao.COLUMNS, Object>>> resultMap = results.stream()
				.collect(Collectors.groupingBy(o -> o.get(CmtCloseDayDao.COLUMNS.TAG_NO)));

		// return用オブジェクトにラッパー
		List<CmtCloseDayDto> cmtCloseDayDtoList = new ArrayList();
		CmtCloseDayDto cmtCloseDayDto;
		for (Object tagNo : resultMap.keySet()) {
			cmtCloseDayDto = new CmtCloseDayDto();
			cmtCloseDayDto.setTagNo((String) tagNo);
			cmtCloseDayDto.setNhCloseDayDataList(closeDayDataConvert(resultMap.get((String) tagNo)));
			cmtCloseDayDtoList.add(cmtCloseDayDto);
			tagNo = null;
			cmtCloseDayDto = null;
		}

		// 使用済変数を初期化
		fromDateCorrected = null;
		toDateCorrected = null;
		results = null;
		resultMap = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtCloseDayDtoList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<NhCloseDayData> closeDayDataConvert(List<Map<CmtCloseDayDao.COLUMNS, Object>> mapList) {
		CmtCloseDayDto nhCloseDayDto = new CmtCloseDayDto();
		List<NhCloseDayData> nhCloseDayDataList = new ArrayList();
		NhCloseDayData nhCloseDayData;
		for (Map<CmtCloseDayDao.COLUMNS, Object> map : mapList) {
			nhCloseDayData = nhCloseDayDto.new NhCloseDayData();
			nhCloseDayData.setCloseDTime(DateUtil.moldYYYYMMDDHH((Date) map.get(CmtCloseDayDao.COLUMNS.CLOSE_DTIME)));
			nhCloseDayData.setTagData((String) map.get(CmtCloseDayDao.COLUMNS.TAG_DATA));
			nhCloseDayData.setQltyCd((Integer) map.get(CmtCloseDayDao.COLUMNS.QLTY_CD));
			nhCloseDayDataList.add(nhCloseDayData);
			nhCloseDayData = null;
			map = null;
		}
		return nhCloseDayDataList;
	}

	/**
	 * TODO スタブ状態
	 * 日締データ読込共通関数(論理名)
	 * @param logicNameList タグNoリスト(論理名)
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<HourHistoryDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseDayDto> nhDayCloseReadByLogicalName(final List<String> logicNameList, final Date fromDate, final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		List<CmtCloseDayDto> cmtCloseDayDtoList = new ArrayList();

		Date date = new Date();
		CmtCloseDayDto cmtCloseDayDto1 = new CmtCloseDayDto();
		List<NhCloseDayData> cmtCloseDayList1 = new ArrayList();

		cmtCloseDayDto1.setTagNo("TL111");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				NhCloseDayData nhCloseDayData = cmtCloseDayDto1.new NhCloseDayData();
				nhCloseDayData.setTagData("1."+i);
				nhCloseDayData.setQltyCd(10*i);
				nhCloseDayData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				cmtCloseDayList1.add(nhCloseDayData);
			}
		}else{
			NhCloseDayData nhCloseDayData = cmtCloseDayDto1.new NhCloseDayData();
			nhCloseDayData.setTagData("1.1");
			nhCloseDayData.setQltyCd(100);
			nhCloseDayData.setCloseDTime(date);
			cmtCloseDayList1.add(nhCloseDayData);
		}
		cmtCloseDayDto1.setNhCloseDayDataList(cmtCloseDayList1);
		cmtCloseDayDtoList.add(cmtCloseDayDto1);

		CmtCloseDayDto cmtCloseDayDto2 = new CmtCloseDayDto();
		List<NhCloseDayData> cmtCloseDayList2 = new ArrayList();

		cmtCloseDayDto2.setTagNo("TL112");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				NhCloseDayData nhCloseDayData = cmtCloseDayDto2.new NhCloseDayData();
				nhCloseDayData.setTagData("1."+i);
				nhCloseDayData.setQltyCd(10*i);
				nhCloseDayData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				cmtCloseDayList2.add(nhCloseDayData);
			}
		}else{
			NhCloseDayData nhCloseDayData = cmtCloseDayDto2.new NhCloseDayData();
			nhCloseDayData.setTagData("1.1");
			nhCloseDayData.setQltyCd(100);
			nhCloseDayData.setCloseDTime(date);
			cmtCloseDayList2.add(nhCloseDayData);
		}
		cmtCloseDayDto2.setNhCloseDayDataList(cmtCloseDayList2);
		cmtCloseDayDtoList.add(cmtCloseDayDto2);

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtCloseDayDtoList;
	}

	/**
	 * NH日締めデータ書込共通関数
	 * @param List<CmtCloseDayDto> NH日締データリスト
	 * @return boolean 書込み結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean nhDayCloseWrite(final List<CmtCloseDayDto> cmtCloseDayDtoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// NH日締めデータ書込用パラメータ作成
		List<Map<CmtCloseDayDao.COLUMNS, Object>> dataList = new ArrayList();
		Map<CmtCloseDayDao.COLUMNS, Object> data;
		for (CmtCloseDayDto cmtCloseDayDto : cmtCloseDayDtoList) {
			for (NhCloseDayData nhCloseDayData : cmtCloseDayDto.getNhCloseDayDataList()) {
				data = new HashMap();
				data.put(CmtCloseDayDao.COLUMNS.CLOSE_DTIME, nhCloseDayData.getCloseDTime());
				data.put(CmtCloseDayDao.COLUMNS.TAG_NO, (Object) cmtCloseDayDto.getTagNo());
				data.put(CmtCloseDayDao.COLUMNS.TAG_DATA, nhCloseDayData.getTagData());
				dataList.add(data);
				data = null;
			}
			cmtCloseDayDto = null;
		}

		SqlSession session = selectDb.dbAcssece("nhlng");
		try {
			CmtCloseDayDao.insertOrUpdate(session, dataList);
			session.commit();
		} catch (RuntimeException e) {
			// 書込み失敗
			throw(e);
		} finally {
			session.close();
			// 使用済変数を初期化
			dataList = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}

	/**
	 * NH月締めデータ読込共通関数
	 * @param tagNoList タグNoリスト
	 * @param fromDate 検索条件From日時
	 * @param toDate 検索条件To日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseMonDto> nhMonCloseRead(final List<String> tagNoList, final Date fromDate,
			final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName(), tagNoList + "," + fromDate + "," + toDate};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// 検索日時を時に丸める
		Date fromDateCorrected = null;
		if(Objects.nonNull(fromDate)){
			fromDateCorrected = DateUtil.moldYYYYMM(fromDate);
		}
		Date toDateCorrected = null;
		if(Objects.nonNull(toDate)){
			toDateCorrected = DateUtil.moldYYYYMM(toDate);
		}

		// tagNoListリスト,From日時,To日時でNH日締データテーブル検索
		SqlSession session = selectDb.dbAcssece("nhlng");
		List<Map<CmtCloseMonDao.COLUMNS, Object>> results = new ArrayList();
		try {
			results = CmtCloseMonDao.selectByTagNoListBetweenDate(session, tagNoList, fromDateCorrected,
					toDateCorrected);
		} catch (RuntimeException e) {
			throw(e);
		} finally {
			session.close();
		}
		// 戻り値をGroupByマッピング
		Map<Object, List<Map<CmtCloseMonDao.COLUMNS, Object>>> resultMap = results.stream()
				.collect(Collectors.groupingBy(o -> o.get(CmtCloseMonDao.COLUMNS.TAG_NO)));

		// return用オブジェクトにラッパー
		List<CmtCloseMonDto> cmtCloseMonthDtoList = new ArrayList();
		CmtCloseMonDto cmtCloseMonthDto;
		for (Object tagNo : resultMap.keySet()) {
			cmtCloseMonthDto = new CmtCloseMonDto();
			cmtCloseMonthDto.setTagNo((String) tagNo);
			cmtCloseMonthDto.setNhCloseMonDataList(closeMonDataConvert(resultMap.get((String) tagNo)));
			cmtCloseMonthDtoList.add(cmtCloseMonthDto);
			tagNo = null;
			cmtCloseMonthDto = null;
		}

		// 使用済変数を初期化
		fromDateCorrected = null;
		toDateCorrected = null;
		results = null;
		resultMap = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtCloseMonthDtoList;
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
	 * @param logicNameList タグNoリスト(論理名)
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<HourHistoryDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CmtCloseMonDto> nhMonCloseReadByLogicalName(final List<String> logicNameList, final Date fromDate, final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		List<CmtCloseMonDto> cmtCloseMonDtoList = new ArrayList();

		Date date = new Date();
		CmtCloseMonDto cmtCloseMonDto1 = new CmtCloseMonDto();
		List<NhCloseMonData> cmtCloseMonList1 = new ArrayList();

		cmtCloseMonDto1.setTagNo("TL111");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				NhCloseMonData nhCloseMonData = cmtCloseMonDto1.new NhCloseMonData();
				nhCloseMonData.setTagData("1."+i);
				nhCloseMonData.setQltyCd(10*i);
				nhCloseMonData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				cmtCloseMonList1.add(nhCloseMonData);
			}
		}else{
			NhCloseMonData nhCloseMonData = cmtCloseMonDto1.new NhCloseMonData();
			nhCloseMonData.setTagData("1.1");
			nhCloseMonData.setQltyCd(100);
			nhCloseMonData.setCloseDTime(date);
			cmtCloseMonList1.add(nhCloseMonData);
		}
		cmtCloseMonDto1.setNhCloseMonDataList(cmtCloseMonList1);
		cmtCloseMonDtoList.add(cmtCloseMonDto1);

		CmtCloseMonDto cmtCloseMonDto2 = new CmtCloseMonDto();
		List<NhCloseMonData> cmtCloseMonList2 = new ArrayList();

		cmtCloseMonDto2.setTagNo("TL112");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				NhCloseMonData nhCloseMonData = cmtCloseMonDto2.new NhCloseMonData();
				nhCloseMonData.setTagData("1."+i);
				nhCloseMonData.setQltyCd(10*i);
				nhCloseMonData.setCloseDTime(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				cmtCloseMonList2.add(nhCloseMonData);
			}
		}else{
			NhCloseMonData nhCloseMonData = cmtCloseMonDto2.new NhCloseMonData();
			nhCloseMonData.setTagData("1.1");
			nhCloseMonData.setQltyCd(100);
			nhCloseMonData.setCloseDTime(date);
			cmtCloseMonList2.add(nhCloseMonData);
		}
		cmtCloseMonDto2.setNhCloseMonDataList(cmtCloseMonList2);
		cmtCloseMonDtoList.add(cmtCloseMonDto2);

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return cmtCloseMonDtoList;
	}

	/**
	 * NH月締めデータ書込共通関数
	 * @param List<CmtCloseMonDto> NH月締データリスト
	 * @return boolean 書込み結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean nhMonCloseWrite(final List<CmtCloseMonDto> cmtCloseMonDtoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// NH月締めデータ書込用パラメータ作成
		List<Map<CmtCloseMonDao.COLUMNS, Object>> dataList = new ArrayList();
		Map<CmtCloseMonDao.COLUMNS, Object> data;
		for (CmtCloseMonDto cmtCloseMonDto : cmtCloseMonDtoList) {
			for (NhCloseMonData nhCloseMonData : cmtCloseMonDto.getNhCloseMonDataList()) {
				data = new HashMap();
				data.put(CmtCloseMonDao.COLUMNS.CLOSE_DTIME, nhCloseMonData.getCloseDTime());
				data.put(CmtCloseMonDao.COLUMNS.TAG_NO, (Object) cmtCloseMonDto.getTagNo());
				data.put(CmtCloseMonDao.COLUMNS.TAG_DATA, nhCloseMonData.getTagData());
				dataList.add(data);
				data = null;
			}
			cmtCloseMonDto = null;
		}
		SqlSession session = selectDb.dbAcssece("nhlng");
		try {
			CmtCloseMonDao.insertOrUpdate(session, dataList);
			session.commit();
		} catch (RuntimeException e) {
			throw(e);
		} finally {
			session.close();
			// 使用済変数を初期化
			dataList = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return true;
	}

	/**
	 * NH日締めデータ(帳票)読込共通関数
	 * @param tagLogicName1 タグ論理名1
	 * @param date 検索条件日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<NhTagDataDto> nhDayCloseInPrintRead(final List<List<String>> logicNameList, final Date date) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// 返却用オブジェクトを宣言
		List<NhTagDataDto> nhTagDataDtoList = new ArrayList();

		// NHタグマスタテーブルをタグ論理名で検索した結果を取得
		List<Map<CmmTagMasterVDao.COLUMNS, Object>> cmtTagValLsit = TagUtil.selectCmtTagMasterByLogicalName(logicNameList);

		// 取得結果からNH日締データ読込共通関数に渡すパラメータのタグNoリストを作成
		List<String> tagList = new ArrayList();
        for(Map<CmmTagMasterVDao.COLUMNS, Object> cmtTagVal : cmtTagValLsit){
        	tagList.add((String) cmtTagVal.get(CmmTagMasterVDao.COLUMNS.TAG_NO));
        	cmtTagVal = null;
        }

        // タグNoリストと日付のパラメータでNH日締データ読込共通関数からNH日締データを取得
        Date toDate = DateUtil.calcDateTime(DateUtil.moldYYYYMMDDHH(date), "HOUR", +1);
        List<CmtCloseDayDto> results = nhDayCloseRead(tagList, date, toDate);

        // 取得結果をNhTagDataDtoのリストに詰替え
        NhTagDataDto nhTagDataDto;
        for(CmtCloseDayDto result : results){
        	nhTagDataDto = new NhTagDataDto();
        	nhTagDataDto.setTagNo(result.getTagNo());
        	nhTagDataDto.setTagData(result.getNhCloseDayDataList().get(0).getTagData());
        	nhTagDataDtoList.add(nhTagDataDto);
        	nhTagDataDto = null;
        	result = null;
        }

        // 使用済変数を初期化
        cmtTagValLsit = null;
        tagList = null;
        results = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return nhTagDataDtoList;
	}

	/**
	 * TODO スタブ状態
	 * 計算処理
	 * @param targetDate 対象日時
	 * @param calcKind 計算種別
	 * @return boolean 処理結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean calcData(final Date targetDate, final int calcKind){
		return true;
	}
}