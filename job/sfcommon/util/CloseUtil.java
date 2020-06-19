package job.sfcommon.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.dao.nhlng.CmmInputDao;
import job.sfcommon.dataaccess.dao.nhlng.CmtCloseDayDao;
import job.sfcommon.dataaccess.dao.nhlng.CmtCloseHourDao;
import job.sfcommon.dataaccess.dao.nhlng.CmtCloseMonDao;
import job.sfcommon.dataaccess.entity.nhlng.CmmInput;
import job.sfcommon.dataaccess.entity.nhlng.CmmInputExample;
import job.sfcommon.dataaccess.entity.nhlng.CmtClose;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDay;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDayExample;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHour;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHourExample;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMon;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMonExample;
import job.sfcommon.dto.CmtCloseDayDto;
import job.sfcommon.function.outputlogs.OutPutLogs;

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

	/** ログカテゴリ*/
	private static final String LOG_CAT = ConstUtil.LOG_COMMON;

	/**
	 * 時締データ読込共通関数
	 *
	 * @param session
	 *            SQLセッション
	 * @param fromDate
	 *            検索日時From
	 * @param toDate
	 *            検索日時To
	 * @return Map<String[],List<CmtCloseHour>> マップ<タグ論理名,リスト<タグNo,値,収集日時>>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Date, List<CmtCloseHour>> nhHourCloseRead(SqlSession session, final Date fromDate,
			final Date toDate) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		// return用オブジェクトをインスタンス
		Map<Date, List<CmtCloseHour>> resultMap = new HashMap();
		List<CmtCloseHour> cmtCloseHourList = new ArrayList();

		CmtCloseHourExample example = new CmtCloseHourExample();
		example.createCriteria();
		if (Objects.isNull(fromDate)) {
			example.addCriteria().andCloseDtimeLessThanOrEqualTo(toDate);
		} else if (Objects.isNull(toDate)) {
			example.addCriteria().andCloseDtimeGreaterThanOrEqualTo(fromDate);
		} else {
			example.addCriteria().andCloseDtimeBetween(fromDate, toDate);
		}
		try {
			cmtCloseHourList = CmtCloseHourDao.select(session, example);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}

		// 戻り値を締め日時でGroupByマッピング
		resultMap = cmtCloseHourList.stream().collect(Collectors.groupingBy(CmtCloseHour::getCloseDtime));

		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return resultMap;
	}

	/**
	 * NH時締めデータ書込共通関数
	 *
	 * @param session
	 *            SQLセッション
	 * @param List<CmtCloseHour>
	 *            NH時締データリスト
	 * @return boolean 書込み結果
	 */
	public static boolean nhHourCloseWrite(SqlSession session, final List<CmtCloseHour> CmtCloseHourList){

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		try {
			CmtCloseHourDao.insertOrUpdate(session, CmtCloseHourList);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return true;
	}

	/**
	 * 日締データ読込共通関数(論理名)
	 * @param session SqlSession
	 * @param logicNameList
	 *            タグ論理名
	 * @return Map<String[],List<CmtCloseDay>> マップ<タグ論理名,リスト<タグNo,値,収集日時>>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String[], List<CmtCloseDay>> nhDayCloseReadByLogicalName(SqlSession session,
			final List<String[]> logicNameList) {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		// return用オブジェクトをインスタンス
		Map<String[], List<CmtCloseDay>> resultMap = new HashMap();

		Date date = new Date();
		DateUtil.moldYYYYMMDD(date);
		List<CmtCloseDay> results = new ArrayList();
		CmtCloseDayExample example = new CmtCloseDayExample();
		example.createCriteria().andCloseDtimeEqualTo(date);
		for (String[] logicName : logicNameList) {
			if (Objects.nonNull(logicName[0])) {
				example.addCriteria().andTagLogicName1EqualTo(logicName[0]);
			}
			if (Objects.nonNull(logicName[1])) {
				example.addCriteria().andTagLogicName2EqualTo(logicName[1]);
			}
			if (Objects.nonNull(logicName[2])) {
				example.addCriteria().andTagLogicName3EqualTo(logicName[2]);
			}
			if (Objects.nonNull(logicName[3])) {
				example.addCriteria().andTagLogicName4EqualTo(logicName[3]);
			}
			try {
				results = CmtCloseDayDao.ExSelect(session, example);
			} catch (Exception e) {
				OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
				throw new RuntimeException(e);
			}
			resultMap.put(logicName, results);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return resultMap;
	}

	/**
	 * NH日締めデータ書込共通関数
	 *
	 * @param session
	 *            SQLセッション
	 * @param List<CmtCloseDay>
	 *            NH日締データリスト
	 * @return boolean 書込み結果
	 */
	public static boolean nhDayCloseWrite(SqlSession session, final List<CmtCloseDay> cmtCloseDayList){

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		try {
			CmtCloseDayDao.insertOrUpdate(session, cmtCloseDayList);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			return false;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return true;
	}

	/**
	 * NH日締めデータ書込共通関数(タグ論理名)
	 *
	 * @param session
	 *            SQLセッション
	 * @param List<CmtCloseDayDto>
	 *            NH日締データリスト
	 * @param String 最終更新者
	 * @return boolean 書込み結果
	 */
	public static boolean nhDayCloseWriteByLogicalName(SqlSession session,
			final List<CmtCloseDayDto> cmtCloseDayDtoList, String lastUpdUser){

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		try {
			CmtCloseDayDao.insertOrUpdateByLogicalName(session, cmtCloseDayDtoList, lastUpdUser);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			return false;
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return true;
	}

	/**
	 * NH月締めデータ読込共通関数
	 *
	 * @param session
	 *            SQLセッション
	 * @param fromDate
	 *            検索条件From日時
	 * @param toDate
	 *            検索条件To日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Date, List<CmtCloseMon>> nhMonCloseRead(SqlSession session, final Date fromDate,
			final Date toDate){

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() + "," + fromDate + "," + toDate };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		// 検索日時を月に丸める
		Date fromDateCorrected = null;
		if (Objects.nonNull(fromDate)) {
			fromDateCorrected = DateUtil.moldYYYYMM(fromDate);
		}
		Date toDateCorrected = null;
		if (Objects.nonNull(toDate)) {
			toDateCorrected = DateUtil.moldYYYYMM(toDate);
		}

		List<CmtCloseMon> results = new ArrayList();
		CmtCloseMonExample example = new CmtCloseMonExample();
		example.createCriteria();
		if (Objects.isNull(fromDateCorrected)) {
			example.addCriteria().andCloseDtimeLessThanOrEqualTo(toDateCorrected);
		} else if (Objects.isNull(toDateCorrected)) {
			example.addCriteria().andCloseDtimeGreaterThanOrEqualTo(fromDateCorrected);
		} else {
			example.addCriteria().andCloseDtimeBetween(fromDateCorrected, toDateCorrected);
		}

		// From日時,To日時でNH日締データテーブル検索
		try {
			results = CmtCloseMonDao.select(session, example);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		// 戻り値を締め日時でGroupByマッピング
		Map<Date, List<CmtCloseMon>> resultMap = results.stream()
				.collect(Collectors.groupingBy(CmtCloseMon::getCloseDtime));

		// 使用済変数を初期化
		fromDateCorrected = null;
		toDateCorrected = null;
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return resultMap;
	}

	/**
	 * NH月締めデータ書込共通関数
	 *
	 * @param session
	 *            SQLセッション
	 * @param List<CmtCloseMon>
	 *            NH月締データリスト
	 * @return boolean 書込み結果
	 */
	public static boolean nhMonCloseWrite(SqlSession session, final List<CmtCloseMon> cmtCloseMonDtoList){

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		try {
			CmtCloseMonDao.insertOrUpdate(session, cmtCloseMonDtoList);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw new RuntimeException(e);
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return true;
	}

	/**
	 * 日締処理
	 *
	 * @param session
	 *            SQLセッション
	 * @param targetDate 対象日時
	 * @param className
	 *            最終更新者(日締処理class名)
	 * @return boolean 処理結果
	 */
	public static boolean execDayClose(SqlSession session, final Date targetDate, final String className) {
		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName() };
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		Date date = DateUtil.moldYYYYMMDD(targetDate);

		// 日締処理
		try {
			CmtCloseDayDao.dayClose(session, date, className);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			return false;
		} finally {
			session.close();
			// 処理終了ログ
			OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		}

		return true;
	}

	/**
	 * 計算処理 TODO テスト中
	 *
	 * @param session
	 *            SQLセッション
	 * @param targetDate
	 *            対象日時
	 * @return histryKind 帳票区分
	 */
	@SuppressWarnings({ "rawtypes" })
	public static boolean calcData(SqlSession session, final Date targetDate, final int histryKind) {

		try {
			// クラス名
			String className = new Object() {
			}.getClass().getSimpleName();

			// 処理開始ログ
			String[] param = { new Object() {
			}.getClass().getEnclosingMethod().getName() };
			OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

			// 引数チェック
			if (Objects.isNull(targetDate)) {
				return false;
			}

			// 入力マスタ検索
			CmmInputExample inputExample = new CmmInputExample();
			inputExample.createCriteria().andHistoryKindEqualTo(histryKind);
			List<CmmInput> cmmInputList = CmmInputDao.ExSelect(session, inputExample);

			// 入力マスタ検索結果を演算順でgrep(tagNoごとにシーケンスNoぶん存在する)
			Map<Integer, List<CmmInput>> calcInfoMap = cmmInputList.stream()
					.collect(Collectors.groupingBy(CmmInput::getCalcPriority));
			// 計算順でソートする
			Object[] inputKey = calcInfoMap.keySet().toArray();
			Arrays.sort(inputKey);

			// 計算順にタグデータ(必要分)を取得し計算を行う
			for (Integer calcPriority : calcInfoMap.keySet()) {

				// 計算種別(calc/user),計算情報(add/sub/mul/div...etc),入力タグNO,DP
				List<String> calcKindList = calcInfoMap.get(calcPriority).stream().map(o -> o.getCalcKind()).distinct()
						.collect(Collectors.toList());
				List<String> calcInfoList = calcInfoMap.get(calcPriority).stream().map(o -> o.getCalcInfo()).distinct()
						.collect(Collectors.toList());
				List<String> tagNoList = calcInfoMap.get(calcPriority).stream().map(o -> o.getTagNo()).distinct()
						.collect(Collectors.toList());
				List<Integer> dpList = calcInfoMap.get(calcPriority).stream().map(o -> o.getDp()).distinct()
						.collect(Collectors.toList());

				// 計算種別,計算情報,入力タグNO,DPが計算ごとに一意にならなければデータ不正
				if (calcKindList.size() != 1 || calcInfoList.size() != 1 || tagNoList.size() != 1
						|| dpList.size() != 1) {
					return false;
				}

				// 総称型で締データを取得
				List<CmtClose> closeDataList = getCloseData(histryKind, session, calcInfoMap.get(calcPriority),
						targetDate);

				// 計算結果を格納するオブジェクトをインスタンス
				BigDecimal result = new BigDecimal(0);

				// 計算種別で処理が異なる
				if (ConstUtil.CALC_KIND_CALC.equals(calcKindList.get(0))) {
					// 計算種別calcの場合は計算情報に対応する処理を行う
					switch (calcInfoList.get(0)) {
					case ConstUtil.CALC_INFO_ADD:
						for (CmtClose cmtClose : closeDataList) {
							BigDecimal v = new BigDecimal(cmtClose.getTagData());
							result = result.add(v);
						}
						break;
					case ConstUtil.CALC_INFO_SUB:
						boolean isFirstSub = true;
						for (CmtClose cmtClose : closeDataList) {
							BigDecimal v = new BigDecimal(cmtClose.getTagData());
							if (isFirstSub) {
								result = result.add(v);
								isFirstSub = false;
							} else {
								result = result.subtract(v);
							}
						}
						break;
					case ConstUtil.CALC_INFO_MUL:
						boolean isFirstMul = true;
						for (CmtClose cmtClose : closeDataList) {
							BigDecimal v = new BigDecimal(cmtClose.getTagData());
							if (isFirstMul) {
								result = result.add(v);
								isFirstMul = false;
							} else {
								result = result.multiply(v);
							}
						}
						break;
					case ConstUtil.CALC_INFO_DIV:
						boolean isFirstDiv = true;
						for (CmtClose cmtClose : closeDataList) {
							BigDecimal v = new BigDecimal(cmtClose.getTagData());
							if (isFirstDiv) {
								result = result.add(v);
								isFirstDiv = false;
							} else {
								result = result.divide(v, dpList.get(0), BigDecimal.ROUND_HALF_UP);
							}
						}
						break;
					case ConstUtil.CALC_INFO_SET:
						result = new BigDecimal(closeDataList.get(0).getTagData());
						break;
					case ConstUtil.CALC_INFO_SUM:
						for (CmtClose cmtClose : closeDataList) {
							BigDecimal v = new BigDecimal(cmtClose.getTagData());
							result.add(v);
						}
						break;
					case ConstUtil.CALC_INFO_AVG:
						for (CmtClose cmtClose : closeDataList) {
							BigDecimal v = new BigDecimal(cmtClose.getTagData());
							result.add(v);
						}
						BigDecimal n = new BigDecimal(closeDataList.size());
						result.divide(n);
						break;
					case ConstUtil.CALC_INFO_MAX:
						Integer max = closeDataList.stream().mapToInt(v -> Integer.parseInt(v.getTagData())).max()
								.orElseThrow(null);
						result = new BigDecimal(max);
						break;
					case ConstUtil.CALC_INFO_MIN:
						Integer min = closeDataList.stream().mapToInt(v -> Integer.parseInt(v.getTagData())).min()
								.orElseThrow(null);
						result = new BigDecimal(min);
						break;
					default:
						// 計算区分と一致しなければデータ不正
						return false;
					}
				} else if (ConstUtil.CALC_KIND_USER.equals(calcKindList.get(0))) {
					// 計算種別userの場合は任意の計算処理を呼び出す
					try {
						Class<?> c = Class.forName(calcInfoList.get(0));
						Object calcClass = c.newInstance();
						Method m = c.getMethod("calculate", String.class);
						m.invoke(calcClass, targetDate, closeDataList, result);
					} catch (InvocationTargetException e) {
						return false;
					} catch (InstantiationException e) {
						return false;
					} catch (ClassNotFoundException e) {
						return false;
					} catch (IllegalAccessException e) {
						return false;
					} catch (NoSuchMethodException e) {
						return false;
					}
				} else {
					// 計算種別がcalcでもuserでもなければデータ不正
					return false;
				}
				// 計算結果をDPで丸める
				result = result.setScale(dpList.get(0), BigDecimal.ROUND_HALF_UP);
				// 計算結果を内部タグに書き込む
				setCalcData(histryKind, session, tagNoList.get(0), result.toPlainString(), targetDate, className);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 締データ(計算元値)検索
	 *
	 * @param histryKind
	 * @param session
	 * @param list
	 * @param targetDate
	 * @return List<T>(総称型:締データ)
	 */
	@SuppressWarnings({ "rawtypes" })
	private static <T> List<CmtClose> getCloseData(final int histryKind, final SqlSession session,
			final List<CmmInput> list, final Date targetDate) {
		// パラメータの締切種別に対応した締データを検索
		switch (histryKind) {
		case 0:
			// 時締めデータ
			List<String> hourTagNoList0 = list.stream().filter(o1 -> o1.getInputType() == 0)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			List<String> hourTagNoList3 = list.stream().filter(o1 -> o1.getInputType() == 3)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			return CmtCloseHourDao.selectClacData(session, hourTagNoList0, hourTagNoList3, targetDate);

		case 1:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			// 日締めデータ
			List<String> dayTagNoList0 = list.stream().filter(o1 -> o1.getInputType() == 0)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			List<String> dayTagNoList1 = list.stream().filter(o1 -> o1.getInputType() == 1)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			List<String> dayTagNoList4 = list.stream().filter(o1 -> o1.getInputType() == 4)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			return CmtCloseDayDao.selectClacData(session, dayTagNoList0, dayTagNoList1, dayTagNoList4, targetDate);

		case 2:
		case 8:
		case 9:
		case 10:
			// 月締めデータ
			List<String> monTagNoList1 = list.stream().filter(o1 -> o1.getInputType() == 1)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			List<String> monTagNoList2 = list.stream().filter(o1 -> o1.getInputType() == 2)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			List<String> monTagNoList5 = list.stream().filter(o1 -> o1.getInputType() == 5)
					.map(o2 -> o2.getInputTagNo()).collect(Collectors.toList());
			return CmtCloseMonDao.selectClacData(session, monTagNoList1, monTagNoList2, monTagNoList5, targetDate);

		default:
			return null;
		}
	}

	/**
	 * 計算結果書込
	 *
	 * @param histryKind
	 * @param session
	 * @param tagNo
	 * @param result
	 * @param targetDate
	 * @param className
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void setCalcData(final int histryKind, final SqlSession session, final String tagNo,
			final String result, final Date targetDate, final String className) {
		// パラメータの締切種別に対応した締データのタグを計算結果で更新
		try {
			switch (histryKind) {
			case 0:
				// 時締
				List<CmtCloseHour> closeHourDataList = new ArrayList();
				CmtCloseHour closeHourData = new CmtCloseHour();
				closeHourData.setCloseDtime(targetDate);
				closeHourData.setTagNo(tagNo);
				closeHourData.setTagData(result);
				closeHourData.setCollDtime(targetDate);
				closeHourData.setLastUpdUser(className);
				closeHourDataList.add(closeHourData);
				// 時締データアップサート
				CmtCloseHourDao.insertOrUpdate(session, closeHourDataList);
				break;
			case 1:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				// 日締
				List<CmtCloseDay> closeDayDataList = new ArrayList();
				CmtCloseDay closeDayData = new CmtCloseDay();
				closeDayData.setCloseDtime(targetDate);
				closeDayData.setTagNo(tagNo);
				closeDayData.setTagData(result);
				closeDayData.setCollDtime(targetDate);
				closeDayData.setLastUpdUser(className);
				closeDayDataList.add(closeDayData);
				// 日締データアップサート
				CmtCloseDayDao.insertOrUpdate(session, closeDayDataList);
				break;
			case 2:
			case 8:
			case 9:
			case 10:
				// 月締めデータ
				List<CmtCloseMon> closeMonDataList = new ArrayList();
				CmtCloseMon closeMonData = new CmtCloseMon();
				closeMonData.setCloseDtime(targetDate);
				closeMonData.setTagNo(tagNo);
				closeMonData.setTagData(result);
				closeMonData.setCollDtime(targetDate);
				closeMonData.setLastUpdUser(className);
				closeMonDataList.add(closeMonData);
				// 月締データアップサート
				CmtCloseMonDao.insertOrUpdate(session, closeMonDataList);
				break;
			default:
				throw new RuntimeException();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** TEST */
	private BigDecimal calculate(Date targetDate, List<CmtClose> closeDataList, BigDecimal result) {

		BigDecimal tesRsl = new BigDecimal(9999);
		return result.add(tesRsl);
	}
}