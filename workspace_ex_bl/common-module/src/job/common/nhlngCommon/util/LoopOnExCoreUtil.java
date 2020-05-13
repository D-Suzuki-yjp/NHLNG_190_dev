package job.common.nhlngCommon.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import biz.grandsight.looponex.LoopOnExException;
import biz.grandsight.looponex.user.api.ITagDataManager;
import biz.grandsight.looponex.user.api.ITrendDataManager;
import biz.grandsight.looponex.user.api.TagDataManager;
import biz.grandsight.looponex.user.api.TrendDataManager;
import biz.grandsight.looponex.user.api.model.HistoryData;
import biz.grandsight.looponex.user.api.model.TagData;
import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtTagValDao;
import job.common.nhlngCommon.dto.CurrentDataDto;
import job.common.nhlngCommon.dto.CurrentTrendDto;
import job.common.nhlngCommon.dto.CurrentTrendDto.CurrentTrend;
import job.common.nhlngCommon.dto.HourHistoryDto;
import job.common.nhlngCommon.dto.HourHistoryDto.HourHistory;
import job.common.nhlngCommon.function.outPutLogs.OutPutLogs;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/30 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * LoopOnExCoreUtil CoreDbユーティリティ共通クラス<br>
 * * @author D.Suzuki
 */
@RequestScoped
public class LoopOnExCoreUtil {

	/**
	 * 瞬時データ読込共通関数
	 * @param tagNoList タグNoリスト
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CurrentDataDto> slgCurrentDataRead(final List<String> tagNoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		List<CurrentDataDto> currentDataDtoList = new ArrayList();

		// tagNoをlcodeに変換したlcodeリストの作成
		// 同時に逆変換用にkeyとvalueを入替えたMapの作成
		List<String> lcodeList = TagUtil.tagNoToLcode(tagNoList);
		Map<String, String> lcodeToTagNoMap = TagUtil.lcodeToTagNo(tagNoList);

		// lcodeリストで瞬時データ検索(LoopOnExAPI)
		List<TagData> tagDataList = new ArrayList();
		try {
			// LoopOnExAPI
			ITagDataManager iTagDataManager = new TagDataManager();
			tagDataList = iTagDataManager.readCoreTagData(lcodeList);
		} catch (LoopOnExException ex) {
			/** TODO */
		} catch (RuntimeException e){
			throw(e);
		}

		// 瞬時データ検索結果のlcodeを再度tagNoへ変換し、return用オブジェクトにラッパー
		CurrentDataDto currentDataDto;
		for(TagData tagData : tagDataList){
			currentDataDto = new CurrentDataDto();
			currentDataDto.setTagNo(lcodeToTagNoMap.get(tagData.getTagItemName()));
			currentDataDto.setValue(tagData.getTagValue());
			currentDataDto.setCollectDate(tagData.getCollectDateTime());
			currentDataDtoList.add(currentDataDto);
			tagData = null;
			currentDataDto = null;
		}

		// 使用済変数を初期化
		lcodeList = null;
		lcodeToTagNoMap = null;
		tagDataList = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return currentDataDtoList;
	}

	/**
	 * TODO スタブ状態
	 * 瞬時データ読込共通関数（論理名）
	 * @param logicNameList タグNoリスト(論理名)
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CurrentDataDto> slgCurrentDataReadByLogicalName(final List<String> logicNameList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		List<CurrentDataDto> currentDataDtoList = new ArrayList();

		Date date = new Date();
		CurrentDataDto currentDataDto1 = new CurrentDataDto();
		currentDataDto1.setTagNo("TL111");
		currentDataDto1.setValue("1.1");
		currentDataDto1.setQltyCd(100);
		currentDataDto1.setCollectDate(date);
		currentDataDtoList.add(currentDataDto1);

		CurrentDataDto currentDataDto2 = new CurrentDataDto();
		currentDataDto2.setTagNo("TL112");
		currentDataDto2.setValue("1.2");
		currentDataDto2.setQltyCd(100);
		currentDataDto2.setCollectDate(date);
		currentDataDtoList.add(currentDataDto2);

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return currentDataDtoList;
	}

	/**
	 * 瞬時データ書込共通関数
	 * @param List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 * @return boolean 更新結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean slgCurrentDataWrite(final List<CurrentDataDto> CurrentDataDtoList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// tagNoとlcodeをマッピングしたグローバル変数を取得
		Map<String, String> tagNoToLcodeMap = TagUtil.tagNoToLcodeMap;

		// tagNoリスト作成
		// key:tagNo、value:valueのマップを作製
		List<String> tagNoList = new ArrayList();
		Map<String, String> parmValueByLcodeMap = new HashMap();
		for(CurrentDataDto currentDataDto : CurrentDataDtoList){
			tagNoList.add(currentDataDto.getTagNo());
			parmValueByLcodeMap.put(currentDataDto.getTagNo(), currentDataDto.getValue());
			currentDataDto = null;
		}

		//タグデータテーブル検索
		List<Map<CmtTagValDao.COLUMNS, Object>> cmtTagValLsit = new ArrayList();
		cmtTagValLsit = TagUtil.selectCmtTagVal(tagNoList);

		//瞬時データ書込用パラメータ作成
		List<TagData> tagDataList = new ArrayList();
		TagData tagData;
		for(Map<CmtTagValDao.COLUMNS, Object> cmtTagVal : cmtTagValLsit){
			tagData = new TagData();
			tagData.setTagItemName(tagNoToLcodeMap.get((String) cmtTagVal.get(CmtTagValDao.COLUMNS.TAG_NO)));
			/** TODO 品質コードGOOD(192)を定数プロパティ化 */
			tagData.setQualityCode(192);
			/** TODO CALフラグ0/1の定数プロパティ化 */
			if(0 == (Integer) cmtTagVal.get(CmtTagValDao.COLUMNS.CAL_FLAG)){
				// CALフラグ無効の場合は引数のvalueをセット
				tagData.setTagValue(parmValueByLcodeMap.get((String) cmtTagVal.get(CmtTagValDao.COLUMNS.TAG_NO)));
			} else if(1 == (Integer) cmtTagVal.get(CmtTagValDao.COLUMNS.CAL_FLAG)){
				// CALフラグ有効の場合はタグデータテーブルの定数をセット
				tagData.setTagValue((String) cmtTagVal.get(CmtTagValDao.COLUMNS.TAG_DATA));
			}
			tagDataList.add(tagData);
			cmtTagVal = null;
			tagData = null;
		}

		// 瞬時データ書込(LoopOnExAPI)
		try {
			ITagDataManager iTagDataManager = new TagDataManager();
			// LoopOnExAPI
			iTagDataManager.writeCoreTagData(tagDataList, true, false);
		} catch (LoopOnExException e) {
			/** TODO */
		} catch (RuntimeException e){
			throw(e);
		} finally {
			// 使用済変数を初期化
			tagNoToLcodeMap = null;
			tagNoList = null;
			parmValueByLcodeMap = null;
			cmtTagValLsit = null;
			tagDataList = null;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		// 書込み成功
		return true;
	}


	/**
	 * トレンドデータ読込共通関数
	 * @param tagNoList タグNoリスト
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<CurrentTrendDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CurrentTrendDto> slgTrendDataRead(final List<String> tagNoList, final Date fromDate, final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// tagNoをlcodeに変換したlcodeリストの作成
		// 同時に逆変換用にkeyとvalueを入替えたMapの作成
		List<String> lcodeList = TagUtil.tagNoToLcode(tagNoList);
		Map<String, String> lcodeToTagNoMap = TagUtil.lcodeToTagNo(tagNoList);

		// 検索日時を分に丸める
		// 収集データが00分ではないので収集日時Toに1を加算しBetweenで検索可能にする
		Date fromDateCorrected = DateUtil.moldYYYYMMDDHHmm(fromDate);
		Date toDateCorrected = DateUtil.calcDateTime(DateUtil.moldYYYYMMDDHHmm(toDate), "MINUTE", +1);

		// lcodeリスト,From日時,To日時で瞬時データ検索(LoopOnExAPI)
		List<HistoryData> results = new ArrayList();
		ITrendDataManager iTagDataManager = new TrendDataManager();
		try {
			// LoopOnExAPI
			results = iTagDataManager.readTrendData(lcodeList, fromDateCorrected, toDateCorrected, false);
		} catch (LoopOnExException e) {
			/** TODO */
		} catch (RuntimeException e){
          throw(e);
		}
		// APIの戻り値をGroupByマッピング
		Map<String, List<HistoryData>> resultMap = results.stream()
		        .collect(Collectors.groupingBy(o -> o.getTagItemName()));

		// トレンドデータ検索結果のlcodeを再度tagNoへ変換し、return用オブジェクトにラッパー
		List<CurrentTrendDto> currentTrendDtolist = new ArrayList();
		CurrentTrendDto currentTrendDto;
		for(String lcode : resultMap.keySet()){
			currentTrendDto = new CurrentTrendDto();
			currentTrendDto.setTagNo(lcodeToTagNoMap.get(lcode));
			currentTrendDto.setCurrentTrendList(CurrenthistoryDataConvert(resultMap.get(lcode)));
			currentTrendDtolist.add(currentTrendDto);
			lcode = null;
			currentTrendDto = null;
		}

		// 使用済変数を初期化
		lcodeList = null;
		lcodeToTagNoMap = null;
		fromDateCorrected = null;
		toDateCorrected = null;
		results = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return currentTrendDtolist;
	}

	/**
	 * HistoryData(biz.grandsight.looponex.user.api.model)のリストから<br>
	 * TrendDataDto.CurrentTrendのリストに変換
	 * @param List<HistoryData>
	 * @return List<CurrentTrend>
	 */
	private static List<CurrentTrend> CurrenthistoryDataConvert(List<HistoryData> historyDataLsit){
		CurrentTrendDto currentTrendDto = new CurrentTrendDto();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<CurrentTrend> currentTrendList = new ArrayList();
		CurrentTrend currentTrend;
		for(HistoryData historyData : historyDataLsit){
			currentTrend = currentTrendDto.new CurrentTrend();
			currentTrend.setCollectDate(DateUtil.moldYYYYMMDDHHmm(historyData.getCollectDateTime()));
			currentTrend.setValue(historyData.getTagValue());
			currentTrendList.add(currentTrend);
			historyData = null;
			currentTrend = null;
		}
		currentTrendDto = null;
		return currentTrendList;
	}

	/**
	 * 時締データ(CoreDb)読込共通関数
	 * @param tagNoList タグNoリスト
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<HourHistoryDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<HourHistoryDto> slgHourHistoryRead(final List<String> tagNoList, final Date fromDate, final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// tagNoをlcodeに変換したlcodeリストの作成
		// 同時に逆変換用にkeyとvalueを入替えたMapの作成
		List<String> lcodeList = TagUtil.tagNoToLcode(tagNoList);
		Map<String, String> lcodeToTagNoMap = TagUtil.lcodeToTagNo(tagNoList);

		// 検索日時を時に丸める
		Date fromDateCorrected = DateUtil.moldYYYYMMDDHH(fromDate);
		Date toDateCorrected = DateUtil.moldYYYYMMDDHH(toDate);

		// lcodeリスト,From日時,To日時で瞬時データ検索(LoopOnExAPI)
		List<HistoryData> results = new ArrayList();
		ITrendDataManager iTagDataManager = new TrendDataManager();
		try {
			// LoopOnExAPI
			results = iTagDataManager.readHourHistoryData(lcodeList, fromDateCorrected, toDateCorrected, false);
		} catch (LoopOnExException e) {
			/** TODO */
		} catch (RuntimeException e){
			throw(e);
		}
		// APIの戻り値をGroupByマッピング
		Map<String, List<HistoryData>> resultMap = results.stream()
		        .collect(Collectors.groupingBy(o -> o.getTagItemName()));

		// トレンドデータ検索結果のlcodeを再度tagNoへ変換し、return用オブジェクトにラッパー
		List<HourHistoryDto> hourHistoryDtolist = new ArrayList();
		HourHistoryDto hourHistoryDto;
		for(String lcode : resultMap.keySet()){
			hourHistoryDto = new HourHistoryDto();
			hourHistoryDto.setTagNo(lcodeToTagNoMap.get(lcode));
			hourHistoryDto.setCurrentTrendList(historyDataConvert(resultMap.get(lcode)));
			hourHistoryDtolist.add(hourHistoryDto);
			lcode = null;
			hourHistoryDto = null;
		}

		// 使用済変数を初期化
		lcodeList = null;
		lcodeToTagNoMap = null;
		fromDateCorrected = null;
		toDateCorrected = null;
		results = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return hourHistoryDtolist;
	}

	/**
	 * HistoryData(biz.grandsight.looponex.user.api.model)のリストから<br>
	 * HourHistoryDto.HourHistoryのリストに変換
	 * @param List<HistoryData>
	 * @return List<CurrentTrend>
	 */
	private static List<HourHistory> historyDataConvert(List<HistoryData> historyDataLsit){
		HourHistoryDto hourHistoryDto = new HourHistoryDto();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<HourHistory> hourHistoryList = new ArrayList();
		HourHistory hourHistory;
		for(HistoryData historyData : historyDataLsit){
			hourHistory = hourHistoryDto.new HourHistory();
			hourHistory.setCollectDate(DateUtil.moldYYYYMMDDHH(historyData.getCollectDateTime()));
			hourHistory.setValue(historyData.getTagValue());
			hourHistoryList.add(hourHistory);
			historyData = null;
			hourHistory = null;
		}
		hourHistoryDto = null;
		return hourHistoryList;
	}

	/**
	 * TODO スタブ状態
	 * 時締データ(CoreDb)読込共通関数
	 * @param logicNameList タグNoリスト(論理名)
	 * @param fromDate 検索日時From
	 * @param toDate 検索日時To
	 * @return List<HourHistoryDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<HourHistoryDto> slgHourHistoryReadByLogicalName(final List<String> logicNameList, final Date fromDate, final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		List<HourHistoryDto> hourHistoryDtoList = new ArrayList();

		Date date = new Date();
		HourHistoryDto hourHistoryDto1 = new HourHistoryDto();
		List<HourHistory> hourHistoryList1 = new ArrayList();

		hourHistoryDto1.setTagNo("TL111");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				HourHistory hourHistory = hourHistoryDto1.new HourHistory();
				hourHistory.setValue("1."+"i");
				hourHistory.setQltyCd(10*i);
				hourHistory.setCollectDate(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				hourHistoryList1.add(hourHistory);
			}
		}else{
			HourHistory hourHistory = hourHistoryDto1.new HourHistory();
			hourHistory.setValue("1.1");
			hourHistory.setQltyCd(100);
			hourHistory.setCollectDate(date);
			hourHistoryList1.add(hourHistory);
		}
		hourHistoryDto1.setCurrentTrendList(hourHistoryList1);
		hourHistoryDtoList.add(hourHistoryDto1);

		HourHistoryDto hourHistoryDto2 = new HourHistoryDto();
		List<HourHistory> hourHistoryList2 = new ArrayList();

		hourHistoryDto2.setTagNo("TL112");
		if(Objects.nonNull(fromDate)){
			for(int i=1; i<=10; i++){
				HourHistory hourHistory = hourHistoryDto2.new HourHistory();
				hourHistory.setValue("2."+"i");
				hourHistory.setQltyCd(10*i);
				hourHistory.setCollectDate(DateUtil.calcDateTime(fromDate,"HOUR",i-1));
				hourHistoryList2.add(hourHistory);
			}
		}else{
			HourHistory hourHistory = hourHistoryDto2.new HourHistory();
			hourHistory.setValue("2.1");
			hourHistory.setQltyCd(100);
			hourHistory.setCollectDate(date);
			hourHistoryList2.add(hourHistory);
		}
		hourHistoryDto2.setCurrentTrendList(hourHistoryList2);
		hourHistoryDtoList.add(hourHistoryDto2);

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return hourHistoryDtoList;
	}

	/**
	 * TODO ガスクロ正副誤差ニューアラーム<br>
	 * HourHistoryDto.HourHistoryのリストに変換
	 * @param List<HistoryData>
	 * @return List<CurrentTrend>
	 */
}
