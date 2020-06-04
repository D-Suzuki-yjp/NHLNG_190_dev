package job.sfcommon.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import biz.grandsight.looponex.LoopOnExException;
import biz.grandsight.looponex.user.api.ITagDataManager;
import biz.grandsight.looponex.user.api.ITrendDataManager;
import biz.grandsight.looponex.user.api.TagDataManager;
import biz.grandsight.looponex.user.api.TrendDataManager;
import biz.grandsight.looponex.user.api.model.HistoryData;
import biz.grandsight.looponex.user.api.model.TagData;
import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterV;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagVal;
import job.sfcommon.dto.CurrentDataDto;
import job.sfcommon.dto.HourHistoryDto;
import job.sfcommon.function.outputlogs.OutPutLogs;

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
@Dependent
public class LoopOnExCoreUtil {

	/**
	 * 瞬時データ読込共通関数
	 * LoopOnExAPIのみ使用しているためアプリケーションでのトランザクション管理不要
	 * @param tagNoList タグNoリスト
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<CurrentDataDto> slgCurrentDataRead(final List<String> tagNoList) throws RuntimeException{

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
		} catch (Exception e){
			throw new RuntimeException(e);
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
	 * 瞬時データ読込共通関数（論理名）
	 * @param session SQLセッション
	 * @param logicNameList タグ論理名
	 * @return Map<String[],List<CurrentDataDto>> マップ<タグ論理名,リスト<タグNo,値,収集日時>>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String[],List<CurrentDataDto>> slgCurrentDataReadByLogicalName(SqlSession session, final List<String[]> logicNameList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// return用オブジェクトをインスタンス
		Map<String[],List<CurrentDataDto>> resultMap = new HashMap();

		Map<String[], List<CmmTagMasterV>>  tagMasterMap = TagUtil.selectCmtTagMasterByLogicalName(session, logicNameList);
		for(String[] logicName : logicNameList){
			List<String> tagNoList = new ArrayList();
			List<CmmTagMasterV> tagMasterList = tagMasterMap.get(logicName);
			for(CmmTagMasterV tagMaster: tagMasterList){
				tagNoList.add(tagMaster.getTagNo());
			}
			List<CurrentDataDto> currentDataList = slgCurrentDataRead(tagNoList);
			resultMap.put(logicName, currentDataList);
		}

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return resultMap;
	}

	/**
	 * 瞬時データ書込共通関数
	 * @param session SQLセッション
	 * @param List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 * @return boolean 更新結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean slgCurrentDataWrite(SqlSession session, final List<CurrentDataDto> CurrentDataDtoList) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// tagNoとlcodeをマッピングしたグローバル変数を取得
		Map<String, String> tagNoToLcodeMap = TagUtil.getTagNoToLcodeMap();

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
		List<CmtTagVal> cmtTagValLsit = new ArrayList();
		cmtTagValLsit = TagUtil.selectCmtTagVal(session, tagNoList);

		//瞬時データ書込用パラメータ作成
		List<TagData> tagDataList = new ArrayList();
		Date date = new Date();
		date = DateUtil.moldYYYYMMDDHHmm(date);
		TagData tagData;
		for(CmtTagVal cmtTagVal : cmtTagValLsit){
			tagData = new TagData();
			tagData.setTagItemName(tagNoToLcodeMap.get(cmtTagVal.getTagNo()));
			/** TODO 品質コードGOOD(192)を定数プロパティ化 */
			tagData.setQualityCode(192);
			/** TODO CALフラグ0/1の定数プロパティ化 */
			if(0 == cmtTagVal.getCalFlag()){
				// CALフラグ無効の場合は引数のvalueをセット
				tagData.setTagValue(parmValueByLcodeMap.get(cmtTagVal.getTagNo()));
			} else if(1 == cmtTagVal.getCalFlag()){
				// CALフラグ有効の場合はタグデータテーブルの定数をセット
				tagData.setTagValue((String) cmtTagVal.getTagData());
			}
			tagData.setCollectDateTime(date);
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
			return false;
		} catch (Exception e){
			return false;
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
	 * 時締データ(CoreDb)読込共通関数
	 * LoopOnExAPIのみ使用しているためアプリケーションでのトランザクション管理不要
	 * @param date 検索日時
	 * @return List<HourHistoryDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<HourHistoryDto> slgHourHistoryRead(final Date date) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		// 検索日時を時に丸める
		Date fromDateCorrected = DateUtil.moldYYYYMMDDHH(DateUtil.addHour(date, -1));
		Date toDateCorrected = DateUtil.moldYYYYMMDDHH(date);

		// 収集グループナンバー,From日時,To日時で瞬時データ検索(LoopOnExAPI)
		List<HistoryData> results = new ArrayList();
		ITrendDataManager iTrendDataManager = new TrendDataManager();
		List<Integer> historyGroupNoList = new ArrayList();
		historyGroupNoList.add(2);
		try {
			// LoopOnExAPI
			results = iTrendDataManager.readHourHistoryDataByHistoryGroupNo(historyGroupNoList, fromDateCorrected, toDateCorrected);
		} catch (LoopOnExException e) {
			/** TODO */
		} catch (Exception e){
			throw new RuntimeException(e);
		}

		// lcodeとtagNoをマッピングしたグローバル変数を取得
		Map<String, String> lcodeToMapTagNo = TagUtil.getLcodeToTagNoMap();

		// トレンドデータ検索結果のlcodeをtagNoへ変換し、return用オブジェクトにラッパー
		List<HourHistoryDto> hourHistoryDtolist = new ArrayList();
		for(HistoryData result : results){
			HourHistoryDto hourHistoryDto = new HourHistoryDto();
			hourHistoryDto.setTagNo(lcodeToMapTagNo.get(result.getTagItemName()));
			hourHistoryDto.setHistoryDate(result.getDateTime());
			hourHistoryDto.setValue(result.getTagValue());
			hourHistoryDto.setQltyCd(result.getQualityCode());
			hourHistoryDto.setCollectDate(result.getCollectDateTime());
			hourHistoryDtolist.add(hourHistoryDto);
		}

		// 使用済変数を初期化
		fromDateCorrected = null;
		toDateCorrected = null;
		results = null;

		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return hourHistoryDtolist;
	}

	/**
	 * TODO ガスクロ正副誤差ニューアラーム<br>
	 * HourHistoryDto.HourHistoryのリストに変換
	 * @param List<HistoryData>
	 * @return List<CurrentTrend>
	 */
}
