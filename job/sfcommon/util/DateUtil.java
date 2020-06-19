package job.sfcommon.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;


/**
 * 日時、日付関連のユーティリティ.
 * 日時データをYYYYMMDDhhmmss形式の文字列として扱うことを基本としたツール.
 * JavaのDate型への変換や各種UserInterface形式への変換をサポートする.
 * YYYY(YY):年(西暦)
 * MM:月
 * DD:日
 * hh:時
 * mm:分
 * ss:秒
 *
 *
 * @author kumagai.
*/
public class DateUtil {

	/** YYYYMMDDhhmmss */
	public static final SimpleDateFormat FM_FULL =
		new SimpleDateFormat("yyyyMMddHHmmss");
	/** YYYYMMDDhhmm */
	public static final SimpleDateFormat FM_YYYYMMDDHHmm =
		new SimpleDateFormat("yyyyMMddHHmm");
	/** YYYYMMDD */
	public static final SimpleDateFormat FM_YYYYMMDD =
		new SimpleDateFormat("yyyyMMdd");
	/** hhmmss */
	public static final SimpleDateFormat FM_HHMMSS =
		new SimpleDateFormat("HHmmss");
	/** YYYY/MM/DD hh:mm:ss */
    public static final SimpleDateFormat FM_YYYY_MM_DD_HH_MM_SS =
    	new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /** YY/MM/DD hh:mm:ss */
    public static final SimpleDateFormat FM_YY_MM_DD_HH_MM_SS =
    	new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    /** YYYY/MM/DD */
    public static final SimpleDateFormat FM_YYYY_MM_DD =
    	new SimpleDateFormat("yyyy/MM/dd");
    /** YY/MM/DD */
    public static final SimpleDateFormat FM_YY_MM_DD =
    	new SimpleDateFormat("yy/MM/dd");
    /** hh:mm:ss */
    public static final SimpleDateFormat FM_HH_MM_SS =
    	new SimpleDateFormat("HH:mm:ss");
    /** YYYYMM */
	public static final SimpleDateFormat FM_YYYYMM =
		new SimpleDateFormat("yyyyMM");
    /** yyyy-MM-dd HH:mm:ss.SSS */
	public static final SimpleDateFormat YYYYhMMhDD_HHcMM =
		new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * 最小の日時(0000年01月01日00:00:00)をYYYYMMDDhhmmss形式で返す.
	 * @return YYYYMMDDhhmmss形式の文字列
	 */
	public static String toMinDate() {
	    return "00000101000000";
	}

	/**
	 * 最大の日時(9999年12月31日23:59:59)をYYYYMMDDhhmmss形式で返す.
	 * @return YYYYMMDDhhmmss形式の文字列
	 */
	public static String toMaxDate(){
	    return "99991231235959";
	}

	/**
	 * 最小の日付(0000年01月01日)をYYYYMMDD形式で返す.
	 * @return YYYYMMDD形式の文字列
	 */
	public static String toMinYYYYMMDD() {
	    return "00000101";
	}

	/**
	 * 最大の日付(9999年12月31日)をYYYYMMDD形式で返す.
	 * @return YYYYMMDD形式の文字列
	 */
	public static String toMaxYYYYMMDD() {
	    return "99991231";
	}

	/**
	 * YYYYMMDDhhmmss形式の文字列へ変換する.
	 * @param dt 日付型
	 * @return 変換した文字列
	 */
	public static String toString(Date dt) {
		if (dt==null) {
			return "";
		}
		synchronized (FM_FULL) {
			return FM_FULL.format(dt);
		}
	}

	/**
	 * 日付と時刻からYYYYMMDDhhmmss形式の文字列へ変換する.
	 * @param yyyymmdd 文字列
	 * @param hhmmss 文字列
	 * @return 変換した文字列
	 */
	public static String toString(String yyyymmdd, String hhmmss) {
	    String dt = StringUtil.toString(yyyymmdd + hhmmss);
	    return (dt.length() == 14 ? dt : "");
	}

	/**
	 * YYYYMMDDhhmmss形式の文字列からDateへ変換する.
	 * @param dt 日付形式の文字列
	 * @return Date型データ
	 * @throws ParseException Parse例外
	 */
	public static Date toDate(String dt)
			throws ParseException {
		int len = StringUtil.length(dt);
		if (len==14) {
			// YYYYMMDDHHmmss
			synchronized (FM_FULL) {
				return FM_FULL.parse(dt);
			}
		} else if (len == 10) {
		    // YYYY/MM/DD
		    synchronized (FM_YYYY_MM_DD) {
                return FM_YYYY_MM_DD.parse(dt);
            }
		} else if (len==8
			    && (2 != dt.indexOf("/"))
			    && (5 != dt.lastIndexOf("/"))) {
			// YYYYMMDD
			synchronized (FM_YYYYMMDD) {
				return FM_YYYYMMDD.parse(dt);
			}
		} else if (len==6) {
			// YYMMDD
			synchronized (FM_YYYYMMDD) {
				return FM_YYYYMMDD.parse(toToday().substring(0,2)+dt);
			}
		} else if (len==12) {
			// YYMMDDHHmmss
			synchronized (FM_FULL) {
				return FM_FULL.parse(toToday().substring(0,2)+dt);
			}
		} else {
			return toDateSplitSCString(dt);
		}
	}

	/**
	 * YYYYMMDD形式の文字列からDateへ変換する.
	 * @param dt 日付形式の文字列
	 * @return YYYYMMDD型Date
	 * @throws ParseException Parse例外
	 */
	public static Date toDateYYYYMMDD(String dt)
			throws ParseException {
	    return toDate(dt);
	}

	/**
	 * YYYYMMDD形式の文字列に変換する.
	 * @param dt Date型
	 * @return YYYYMMDD型文字列(nullの場合は空文字)
	 */
	public static String toYYYYMMDD(Date dt) {
		if (dt == null) return "";
		synchronized (FM_YYYYMMDD) {
			return FM_YYYYMMDD.format(dt);
		}
	}

	/**
	 * YYYYMM形式の文字列に変換する.
	 * @param dt Date型
	 * @return YYYYMM型文字列
	 */
	public static String toYYYYMM(Date dt) {
		if (dt == null) return "";
		synchronized (FM_YYYYMM) {
			return FM_YYYYMM.format(dt);
		}
	}

	/**
	 * YYYYMM形式の文字列に変換する.
	 * @param dt Date型
	 * @return YYYYMM型文字列
	 */
	public static String toYYYYhMMhDD_HHcMM(Date dt) {
		if (dt == null) return "";
		synchronized (YYYYhMMhDD_HHcMM) {
			return YYYYhMMhDD_HHcMM.format(dt);
		}
	}

	/**
	 * 年月日文字列を結合する.
	 *
	 * @param y 年
	 * @param m 月
	 * @param d 日
	 * @return YYYYMMDD文字列(エラー時は空文字)
	 */
	public static String toYYYYMMDD(String y, String m, String d) {
	    String st = StringUtil.toString (formYYYY(y) + formNN(m) + formNN(d));
	    return (st.length() == 8 ? st : "");
	}


	/**
	 * 日付型をhhmmss形式の文字列に変換.
	 *
	 * @param dt Date型
	 * @return HHMMSS型文字列(nullの場合は空文字)
	 *
	 */
	public static String toHHMMSS(Date dt) {
		if (dt == null) {
			return "";
		}
	    synchronized (FM_HHMMSS) {
	    	return FM_HHMMSS.format(dt);
	    }
	}

	/**
	 * 時分秒の文字列を結合する.
	 *
	 * @param h 時
	 * @param m 分
	 * @param s 秒
	 * @return hhmmss文字列(エラー時は空文字)
	 */
	public static String toHHMMSS(String h, String m, String s) {
		String st = formNN(h) + formNN(m) + formNN(s);
		return (st.length() == 6 ? st : "");
	}

	/**
	 * 時分秒の文字列を結合する.
	 *
	 * @param h 時
	 * @param m 分
	 * @param s 秒
	 * @return hhmmss文字列(エラー時は空文字)
	 */
	public static String to(String h, String m, String s) {
		String st = formNN(h) + formNN(m) + formNN(s);
		return (st.length() == 6 ? st : "");
	}

	/**
	 * 文字列が日付型に変換できるかチェックする.
	 * @param dt 文字列
	 * @return true:日付型変換可能/false:日付型変換不可
	 */
	public static boolean matchDate(String dt) {
		try {
			String s = dt.replace("/", "").replace(" ", "").replace(":", "");
			Date d = toDate(s);
			if (d == null) {
				return false;
			}
			String x = toString(d);
			return s.equals(x.substring(0, s.length()));
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 文字列がYYYYMMDD形式かチェックする.
	 * nullの場合、falseを返す.
	 * エラーが発生した場合、falseを返す.
	 * @param dt 日付形式の文字列
	 * @return true:YYYYMMDD形式/false:別形式
	 */
	public static boolean matchYYYYMMDD(String dt) {
		try {
			Date d = toDateYYYYMMDD(dt);
			if (d == null) {
				return false;
			}
			String x = toYYYYMMDD(d);
			return dt.equals(x);
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 現在日時のyyyyMMddHHmmss形式の文字列.
	 * @return YYYYMMDDhhmmss型文字列
	 */
	public static String toNow() {
		return toString(new Date());
	}

	/**
	 * 現在日時のyyyyMMdd形式の文字列.
	 * @return YYYYMMDD型文字列
	 */
	public static String toToday() {
		return toYYYYMMDD(new Date());
	}

	/**
	 * 現在日時のHHmmss形式の文字列.
	 * @return HHMMSS型文字列
	 */
	public static String toNowTime() {
		return toHHMMSS(new Date());
	}

	/**
	 * 現時日時からday日とsec秒を加減算したyyyyMMddHHmmss形式の文字列.
	 * @param day 加減算する日数
	 * @param sec 加減算する秒数
	 * @return yyyyMMddHHmmss型の文字列
	 */
	public static String toNow(int day, int sec) {
		Calendar cal = Calendar.getInstance();
		if (day != 0) {
			cal.add(Calendar.DAY_OF_MONTH, day);
		}
		if (sec != 0) {
			cal.add(Calendar.SECOND, sec);
		}
		return toString(cal.getTime());
	}

	/**
	 * 現在日からday日を加減算したyyyyMMdd形式の文字列.
	 * @param day 加減算する日数
	 * @return YYYYMMDD型の文字列
	 */
	public static String toToday(int day) {
		Calendar cal = Calendar.getInstance();
		if (day != 0) {
			cal.add(Calendar.DAY_OF_MONTH, day);
		}
		return toYYYYMMDD(cal.getTime());
	}

	/**
	 * 現在月の最初の日をyyyyMMdd形式の文字列.
	 * @return yyyyMMdd型の文字列
	 */
	public static String toFirstDayOfMonth() {
		return toFirstDayOfMonth(0);
	}

	/**
	 * 現在月の最初の日からmonth月を加減算したyyyyMMdd形式の文字列.
	 * @param month 加減算する月数
	 * @return YYYYMMDD型の文字列
	 */
	public static String toFirstDayOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		if (month != 0) {
			cal.add(Calendar.MONTH, month);
		}
		return toYYYYMMDD(cal.getTime());
	}

	/**
	 * 指定された日付dt8の属する年月の月初日をyyyyMMdd形式の文字列.
	 * エラーが発生した場合、null値を返します.
	 * @param dt8 有効な年月を含んだyyyyMMdd形式の文字列
	 * @return 指定年月の月初日
	 */
	public static String toFirstDayOfMonth(String dt8) {
		try {
			Date dt = toDateYYYYMMDD(dt8);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			return toYYYYMMDD(cal.getTime());
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * 現在月の最後の日をyyyyMMdd形式の文字列.
	 * @return yyyyMMdd型の文字列
	 */
	public static String toLastDayOfMonth() {
		return toLastDayOfMonth(0);
	}

	/**
	 * 現在月の最後の日からmonth月を加減算したyyyyMMdd形式の文字列.
	 * @param month 加減算する月数
	 * @return YYYYMMDD型の文字列
	 */
	public static String toLastDayOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, 1 + month);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return toYYYYMMDD(cal.getTime());
	}

	/**
	 * 指定された日付dt8の属する年月の月末日をyyyyMMdd形式の文字列.
	 * エラーが発生した場合、null値を返します.
	 * @param dt8 有効な年月を含んだyyyyMMdd形式の文字列
	 * @return 指定年月の月末日
	 */
	public static String toLastDayOfMonth(String dt8) {
		try {
			Date dt = toDateYYYYMMDD(dt8);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.add(Calendar.MONTH, 1);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			return toYYYYMMDD(cal.getTime());
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * 指定された日付dt8の属する年月の月初日から月末日までを配列で返す.
	 * エラーが発生した場合、null値を返します.
	 * @param dt8 有効な年月を含んだyyyyMMdd形式の文字列
	 * @return 指定年月の月初日から月末日までを配列
	 */
	public static String[] toDaysOfMonth(String dt8) {
		try {
			Date dt = toDateYYYYMMDD(dt8);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.add(Calendar.MONTH, 1);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			int lastday = cal.get(Calendar.DAY_OF_MONTH);
			String[] days = new String[lastday];
			String base = dt8.substring(0, 6); //年月
			for (int i = 0; i < lastday; ++i) {
				days[i] = base + formNN(String.valueOf(i + 1));
			}
			return days;
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * Date型に対して指定されたレンジを加減算する<br>
	 * @param Date DateTime 日時
	 * @param String range 加減算するレンジ
	 * @param int pram 加減算する値（負の値で減算）
	 * @return 加減算後の日時
	 */
	public static Date calcDateTime(Date DateTime, String range, int pram) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTime);

		switch(range){
		case ConstUtil.MINUTE:
			calendar.add(Calendar.MINUTE, pram);
			break;
		case ConstUtil.HOUR:
			calendar.add(Calendar.HOUR, pram);
			break;
		case ConstUtil.DAY:
			calendar.add(Calendar.DAY_OF_MONTH, pram);
			break;
		case ConstUtil.MONTH:
			calendar.add(Calendar.MONTH, pram);
			break;
		case ConstUtil.YEAR:
			calendar.add(Calendar.YEAR, pram);
			break;
		}
		DateTime = calendar.getTime();
		return DateTime;
	}




	/**
	 * 0や00など1,2桁が不定な場合に2桁に整形する
	 * @param n 文字列
	 * @return 2桁に整形した文字列
	 */
	public static String formNN(String n) {
		if (StringUtil.isEmpty(n)) {
			return "";
		}
		int len = n.length();
		switch (len) {
		case 1:
			return "0" + n;
		case 2:
			return n;
		default:
			return n.substring(len - 2, len);
		}
	}

	/**
	 * 0や00,0000など桁が不定な場合に4桁に整形する。
     * 4桁に満たない場合は2000年ベースで整形する。
	 * @param y 文字列
	 * @return 4桁に整形した文字列
	 */
	public static String formYYYY(String y) {
		if (StringUtil.isEmpty(y)) {
			return "";
		}
		int len = y.length();
		switch (len) {
		case 1:
			return "200" + y;
		case 2:
			return "20" + y;
		case 3:
			return "2" + y;
		case 4:
			return y;
		default:
			return y.substring(len - 4, len);
		}
	}

	/**
	 * yyyyMMdd形式の文字列からYYYY部分を切り出す.
	 * @param dt8 文字列
	 * @return YYYY部分を切り出した文字列
	 */
	public static String getYYYY(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 4) {
			return null;
		}
		return dt8.substring(0, 4);
	}

	/**
	 * yyyyMMdd形式の文字列から下２桁YY部分を切り出す.
	 * @param dt8 文字列
	 * @return 下２桁YY部分を切り出した文字列
	 */
	public static String getYY(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 4) {
			return null;
		}
		return dt8.substring(2, 4);
	}

	/**
	 * yyyyMMdd形式の文字列からYYYYMM部分を切り出す。
	 * @param dt8 文字列
	 * @return YYYYMM部分を切り出した文字列
	 */
	public static String getYYYYMM(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 6) {
			return null;
		}
		return dt8.substring(0, 6);
	}

	/**
	 * yyyyMMdd形式の文字列からYYYYMMDD部分を切り出す。
	 * @param dt8 文字列
	 * @return YYYYMMDD部分を切り出した文字列
	 */
	public static String getYYYYMMDD(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 8) {
			return null;
		}
		return dt8.substring(0, 8);
	}

	/**
	 * getYY()と同じだが結果が空の場合に現在年を返す.
	 * @param dt8 文字列
	 * @return 結果が空の場合に現在年を返す(文字列)
	 */
	public static String getYYDef(String dt8) {
		String yy = getYY(dt8);
		if (StringUtil.isEmpty(yy)) {
			String today = DateUtil.toToday();
			yy = DateUtil.getYY(today);
		}
		return yy;
	}

	/**
	 * Date型のままYYYYMMDDHHに切り捨てる.
	 * @param dt Date型
	 * @return Date(YYYYMMDDHH)
	 * @throws ParseException
	 */
	public static Date moldYYYYMMDDHH(Date dt){
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.HOUR_OF_DAY);
	}

	/**
	 * Date型のままYYYYMMDDHHmmに切り捨てる.
	 * @param dt Date型
	 * @return Date(YYYYMMDDHHmm)
	 */
	public static Date moldYYYYMMDDHHmm(Date dt) {
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.MINUTE);
	}

	/**
	 * yyyyMMdd形式の文字列からDD部分を切り出す.
	 * @param dt8 文字列
     * @return DD部分を切り出した文字列
	 */
	public static String getDD(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 8) {
			return null;
		}
		return dt8.substring(6, 8);
	}

	/**
	 * Date型のままYYYYMMDDに切り捨てる.
	 * @param dt Date型
	 * @return Date(YYYYMMDD)
	 * @throws ParseException
	 */
	public static Date moldYYYYMMDD(Date dt){
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.DAY_OF_MONTH);
	}

	/**
	 * yyyyMMdd形式の文字列からMM部分を切り出す.
	 * @param dt8 文字列
	 * @return MM部分を切り出した文字列
	 */
	public static String getMM(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 6) {
			return null;
		}
		return dt8.substring(4, 6);
	}

	/**
	 * Date型のままYYYYMMに切り捨てる.
	 * @param dt Date型
	 * @return Date(YYYYMM)
	 * @throws ParseException
	 */
	public static Date moldYYYYMM(Date dt){
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.MONTH);
	}

	/**
	 * 日付からYYYY部分を切り出す.
	 * @param dt 日付
	 * @return YYYY 整数
	 */
	public static int getYYYY(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 日付からMM部分を切り出す.
	 * @param dt 日付
	 * @return MM 整数
	 */
	public static int getMM(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 日付からDD部分を切り出す.
	 * @param dt 日付
	 * @return  DD 整数
	 */
	public static int getDD(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * yyyyMMdd形式の文字列から曜日(漢字)を返す.
	 * エラーが発生した場合、空文字を返す.
	 * @param dt8 文字列
	 * @return 文字列から曜日(漢字)を返す
	 */
	public static String getWeek(String dt8) {
		if (StringUtil.isEmpty(dt8)) {
			return null;
		}
		try {
			Date dt = toDateYYYYMMDD(dt8);
			return getWeek(dt);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return "";
	}

	/**
	 * 日付から曜日(漢字)を返す.
	 * エラーが発生した場合、空文字を返す.
	 * @param dt Date型
	 * @return 日付から曜日(漢字)を返す
	 */
	public static String getWeek(Date dt) {
		if (dt == null) {
			return null;
		}
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			int wk = cal.get(Calendar.DAY_OF_WEEK);
			switch (wk) {
			case Calendar.SUNDAY:
				return "日";
			case Calendar.MONDAY:
				return "月";
			case Calendar.TUESDAY:
				return "火";
			case Calendar.WEDNESDAY:
				return "水";
			case Calendar.THURSDAY:
				return "木";
			case Calendar.FRIDAY:
				return "金";
			case Calendar.SATURDAY:
				return "土";
			}
			return "";
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return "";
	}

	/**
	 * 曜日(漢字)をhtml形式で返す.
     * 土曜はblueのfontタグ、日曜はredのfontタグを付ける.
     * エラーが発生した場合、空文字を返す.
	 * @param dt8 文字列
	 * @return 曜日(漢字)をhtml形式で返す(文字列)
	 */
	public static String getWeekHtml(String dt8) {
		if (StringUtil.isEmpty(dt8)) {
			return null;
		}
		try {
			Date dt = toDateYYYYMMDD(dt8);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			int wk = cal.get(Calendar.DAY_OF_WEEK);
			switch (wk) {
			case Calendar.SUNDAY:
				return "<font color=\"red\">日</font>";
			case Calendar.MONDAY:
				return "月";
			case Calendar.TUESDAY:
				return "火";
			case Calendar.WEDNESDAY:
				return "水";
			case Calendar.THURSDAY:
				return "木";
			case Calendar.FRIDAY:
				return "金";
			case Calendar.SATURDAY:
				return "<font color=\"blue\">土</font>";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * yyyyMMddHHmmss形式からHHmm部分を切り出す.
	 * @param dt14 文字列
	 * @return HH部分を切り出した文字列
	 */
	public static String getHHmm(String dt14) {
		if (StringUtil.isEmpty(dt14)) {
			return null;
		}
		return dt14.substring(8, 12);
	}

	/**
	 * yyyyMMddHHmmss形式またはHHmmss形式の文字列からHH部分を切り出す.
     * 長さ(14or6)で判断する.
	 * @param dt14 文字列
	 * @return HH部分を切り出した文字列
	 */
	public static String getHH(String dt14) {
		if (StringUtil.isEmpty(dt14)) {
			return null;
		}
		int offset = dt14.length() == 14 ? 8 : 0;
		if (StringUtil.length(dt14) < (offset + 2)) {
			return null;
		}
		return dt14.substring(offset, offset + 2);
	}

	/**
	 * yyyyMMddHHmmss形式またはHHmmss形式の文字列からmm部分を切り出す.
     * 長さ(14or6)で判断する.
	 * @param dt14 文字列
	 * @return mm部分を切り出した文字列
	 */
	public static String getmm(String dt14) {
		if (StringUtil.isEmpty(dt14)) {
			return null;
		}
		int offset = dt14.length() == 14? 10: 2;
		if (StringUtil.length(dt14) < (offset + 2)) {
			return null;
		}
		return dt14.substring(offset, offset + 2);
	}

	/**
	 * yyyyMMddHHmmss形式またはHHmmss形式の文字列からss部分を切り出す.
     * 長さ(14or6)で判断する.
	 * @param dt14 文字列
	 * @return ss部分を切り出した文字列
	 */
	public static String getSS(String dt14) {
		if (StringUtil.isEmpty(dt14)) {
			return null;
		}
		int offset = dt14.length() == 14? 12: 4;
		if (StringUtil.length(dt14) < (offset + 2)) {
			return null;
		}
		return dt14.substring(offset, offset + 2);
	}

	/**
	 * yyyyMMdd形式の文字列スラッシュ区切りにして返却.
     * 8文字：YYYY/MM/DD
     * 6文字：YYYY/MM
     * 4文字：YYYY
	 * @param dt 文字列
	 * @return yyyyMMdd形式をスラッシュ区切りにした文字列
	 */
	public static String getSeparateSlash(String dt) {
		int len = StringUtil.length(dt);
		if (StringUtil.isEmpty(dt) || len < 4) {
			return null;
		}
		switch (len) {
		case 4:
			return dt;
		case 6:
			return getYYYY(dt) + "/" + getMM(dt);
		case 8:
			return getYYYY(dt) + "/" + getMM(dt) + "/" + getDD(dt);
		default:
			return null;
		}
	}


	/**
	 * データ書式を、UI書式(asciiのみ)に変換する.
	 * YYYY/MM/DD HH:mm:SS
	 * YYYY/MM/DD
	 * HH:mm:SS
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toUIAsciiFull(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "/" + getMM(dt) + "/" + getDD(dt) + " " +
			getHH(dt) + ":" + getmm(dt) + ":" + getSS(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "/" + getMM(dt) + "/" + getDD(dt);
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt) + ":" + getSS(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、UI書式(asciiのみ)に変換する.
	 * YYYY/MM/DD HH:mm
	 * YYYY/MM/DD
	 * HH:mm
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toUIAscii(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "/" + getMM(dt) + "/" + getDD(dt) + " " +
			getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "/" + getMM(dt) + "/" + getDD(dt);
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、UI書式(asciiのみ)に変換する.
	 * YY/MM/DD HH:mm:ss
	 * YY/MM/DD
	 * HH:mm:ss
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toUIAsciiYYFull(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYY(dt) + "/" + getMM(dt) + "/" + getDD(dt) + " " +
			getHH(dt) + ":" + getmm(dt) + ":" + getSS(dt);
		} else if (len == 8) {
			return getYY(dt) + "/" + getMM(dt) + "/" + getDD(dt);
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt) + ":" + getSS(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、UI書式(asciiのみ)に変換する.
	 * YY/MM/DD HH:mm
	 * YY/MM/DD
	 * HH:mm
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toUIAsciiYY(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYY(dt) + "/" + getMM(dt) + "/" + getDD(dt) + " " +
			getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYY(dt) + "/" + getMM(dt) + "/" + getDD(dt);
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、UI書式(漢字含む)に変換する.
	 * YYYY年MM月DD日(曜) HH:mm
	 * YYYY年MM月DD日(曜)
	 * HH:mm
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toUI(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "年" + getMM(dt) + "月" + getDD(dt) + "日" + "(" +
			getWeek(dt) + ") " + getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "年" + getMM(dt) + "月" + getDD(dt) + "日" + "(" +
			getWeek(dt) + ")";
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、UI書式(漢字含む、曜日無)に変換する.
	 * YYYY年MM月DD日 HH:mm
	 * YYYY年MM月DD日
	 * HH:mm
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toUINonWeek(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "年" + getMM(dt) + "月" + getDD(dt) + "日" + " " +
			getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "年" + getMM(dt) + "月" + getDD(dt) + "日";
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、html書式(fontタグ付き)に変換する.
	 * YYYY年MM月DD日(曜) HH:mm
	 * YYYY年MM月DD日(曜)
	 * HH:mm.
	 * 曜の部分は、土ならばfontタグでblue、日ならばfontタグでredを返す
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toHtml(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "年" + getMM(dt) + "月" + getDD(dt) + "日" + "(" +
			getWeekHtml(dt) + ") " + getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "年" + getMM(dt) + "月" + getDD(dt) + "日" + "(" +
			getWeekHtml(dt) + ")";
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * データ書式を、年月のUI書式(YYYY年MM月)に変換する.
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toNengetsuUI(String dt) {
		if (StringUtil.isEmpty(dt) || StringUtil.isZero(dt)) {
			return "";
		}
		String y = getYYYY(dt);
		String m = getMM(dt);

		if (StringUtil.isEmpty(y) || StringUtil.isEmpty(m)) {
		    return "";
		}

		return y + "年" + m + "月";
	}

	/**
	 * データ書式を、月日のUI書式(MM/DD)に変換する.
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toGappiUI(String dt) {
		if (StringUtil.isEmpty(dt) || StringUtil.isZero(dt)) {
			return "";
		}

		String m = getMM(dt);
		String d = getDD(dt);
		if (StringUtil.isEmpty(m) || StringUtil.isEmpty(d)) {
		    return "";
		}
		return m + "/" + d;
	}

	/**
	 * データ書式を、時分のUI書式(HH:mm)に変換する.
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toJifunUI(String dt) {
		if (StringUtil.isEmpty(dt) || StringUtil.isZero(dt)) {
			return "";
		}

		String h = getHH(dt);
		String m = getmm(dt);

		if (StringUtil.isEmpty(h) || StringUtil.isEmpty(m)) {
		    return "";
		}
		return h + ":" + m;
	}

	/**
	 * データ書式を、月日のUI書式(MM月DD日)に変換する.
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toGappiUIKanji(String dt) {
		if (StringUtil.isEmpty(dt) || StringUtil.isZero(dt)) {
			return "";
		}

		String m = getMM(dt);
		String d = getDD(dt);

		if (StringUtil.isEmpty(m) || StringUtil.isEmpty(d)) {
		    return "";
		}
		return m + "月" + d + "日";
	}

	/**
	 * データ書式を、時分のUI書式(HH時mm分)に変換する.
	 * @param dt データ書式(yyyyMMddHHmmssなど)
	 * @return UI書式
	 */
	public static String toJifunUIKanji(String dt) {
		if (StringUtil.isEmpty(dt) || StringUtil.isZero(dt)) {
			return "";
		}

		String h = getHH(dt);
		String m = getmm(dt);
		if (StringUtil.isEmpty(h) || StringUtil.isEmpty(m)) {
		    return "";
		}
		return h + "時" + m + "分";
	}

	/**
	 * データ書式 YYYY/MM/DD HH:mm:ssから日付型に変換する.
	 * @param dt (YYYY/MM/DD HH:mm:ssなど)
	 * @return 日付型
	 * @throws ParseException Parse例外
	 *
	 */
	public static Date toDateSplitSCString(String dt)
			throws ParseException {
		int len = StringUtil.length(dt);
		if (len == 19) {
			// YYYY/MM/DD HH:mm:ss の形式
			synchronized (FM_YYYY_MM_DD_HH_MM_SS) {
				return FM_YYYY_MM_DD_HH_MM_SS.parse(dt);
			}
		} else if ((len == 17)
				&& (11 == dt.indexOf(":"))
				&& (5 == dt.lastIndexOf("/"))) {
			// YY/MM/DD HH:mm:ss の形式
			synchronized (FM_YYYY_MM_DD_HH_MM_SS) {
				// XX年が、00XX年と解釈される為、当日の年を設定
				return FM_YYYY_MM_DD_HH_MM_SS.parse(toToday().substring(0,2) + dt);
			}
		} else if (len == 10) {
		    // YYYY/MM/DD
            synchronized (FM_YYYY_MM_DD) {
                return FM_YYYY_MM_DD.parse(dt);
            }
		} else if ((len == 8)
				&& (2 == dt.indexOf("/"))
				&& (5 == dt.lastIndexOf("/"))) {
		    // YY/MM/DD
			synchronized (FM_YY_MM_DD) {
				return FM_YY_MM_DD.parse(dt);
			}
		} else {
			return null;
		}
	}

	/**
	 * 日付型からデータ書式 YYYY/MM/DD HH:mm:ssの文字列に変換する.
	 * nullの場合、nullを返す.
	 * @param dt 対象日付
	 * @return 変換後の文字列
	 */
	public static String toStringSplitSCFull(Date dt){
		if (dt == null) {
			return null;
		} else {
			synchronized (FM_YYYY_MM_DD_HH_MM_SS) {
				return FM_YYYY_MM_DD_HH_MM_SS.format(dt);
			}
		}
	}

	/**
	 * 日付型からデータ書式 YYYY/MM/DDの文字列に変換する.
	 * nullの場合、空文字を返す.
	 * @param dt 対象日付
	 * @return 変換後の文字列
	 */
	public static String toYYYYMMDDSplitS(Date dt){
		if (dt == null) {
			return "";
		} else {
			synchronized (FM_YYYY_MM_DD) {
				return FM_YYYY_MM_DD.format(dt);
			}
		}
	}

	/**
	 * 日付型からデータ書式 YYYY/MM/DDの文字列に変換する.
	 * @param dtStr 対象日付
	 * @return 変換後の文字列
	 * @throws ParseException Parse例外
	 */
    public static String toYYYYMMDDSplitS(String dtStr)
    		throws ParseException{
    	Date wk = toDate(dtStr);
    	return toYYYYMMDDSplitS(wk);
    }

    /**
     * 日付型に対し、加減算を行う.
     * nullの場合、nullを返す.
     * @param targetDate 対象日付
     * @param h 加減算する時間
     * @return 変換後の日時
     */
    public static Date addHour(Date targetDate, int h) {
        if (targetDate == null) {
            return null;
        }
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(targetDate);
    	if (h != 0) {
    		cal.add(Calendar.HOUR_OF_DAY, h);
    	}
    	return cal.getTime();
    }

    /**
     * 日付型に対し、加減算を行う.
     * nullの場合、nullを返す.
     * @param targetDate 対象日付
     * @param day 加減算する日数
     * @return 変換後の日時
     */
    public static Date addDate(Date targetDate, int day) {
        if (targetDate == null) {
            return null;
        }

    	Calendar cal = Calendar.getInstance();
    	cal.setTime(targetDate);
    	if (day != 0) {
    		cal.add(Calendar.DAY_OF_MONTH, day);
    	}
    	return cal.getTime();
    }

    /**
     * 日付型に対し、月の加減算を行う.
     * @param targetDate 対象日付
     * @param month 加減算する月数
     * @return 変換後の日時
     */
    public static Date addMonth(Date targetDate, int month) {
        if (targetDate == null) {
            return null;
        }
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(targetDate);
    	if (month != 0) {
    		cal.add(Calendar.MONTH, month);
    	}
    	return cal.getTime();
    }

    /**
     * システム時間を取得.
     * @return システム時間
     */
	public static Date sysdate() {
		return new Date();
	}

	 /**
     * Date型をString型に変換します.
     * @param date 日付
     * @param datePattern 日付のフォーマット
     * @return String型の日付
     */
	private static String convertDate2String(final Date date, final String datePattern){
		if(date != null) {
			try {
				DateFormat dateFormat = new SimpleDateFormat(datePattern, Locale.JAPAN);
				dateFormat.setTimeZone(TimeZone.getTimeZone("JST"));
				return dateFormat.format(date);
			} catch(Exception e) {
				throw new IllegalArgumentException(e);
			}
		} else return "";
	}

	/**
	 * Date型をString型に変換します.<br>
	 * <br>
	 * <b>目的:</b><br>
	 * Date型をString型に変換します.<br>
	 * <br>
	 * <b>処理概要:</b><br>
	 * Date型をString型に変換します.<br>
	 * @param date Date型日付
	 * @param datePattern フォーマットタイプ
	 * @return 変換後日付文字列
	 */
	public static String convertDate2String(final Date date, final DateFormatType datePattern){
		return convertDate2String(date, datePattern.getFormatString());
	}

	/**
	 * java.sql.TimestampをYYYYMMDDHHMMSS形式の文字列に変換する.<br>
	 * <p>
	 * nullの時はnullを返す.<br>
	 * </p>
	 * @param target 対象のTimestamp
	 * @return 変換後の文字列(YYYYMMDDHHMMSS形式)
	 */
	public static String convTimestampToYYYYMMDDHHMMSS(Timestamp target) {

		if (target == null) {
			return null;
		}

		return FM_FULL.format(target);
	}

	/**
	 * 現在日付を取得する.<br>
	 * @return 現在日付(Timestamp型)
	 */
	public static Timestamp getNow(){
		Calendar cal = Calendar.getInstance();
		return new Timestamp(cal.getTimeInMillis());
	}

	/**
	 * 現在日付テキストを取得する.<br>
	 * @return 現在日付(文字列)
	 */
	public static String getNowTxt(){
		return FM_YYYY_MM_DD_HH_MM_SS.format(getNow());
	}
	/**
	 * 文字列から日付型へ変換する.
	 * nullの場合、nullを返す.
	 * エラーが発生した場合、nullを返す.
	 * @param strTime 変換元文字列
	 * @return 変換後日付型
	 */
	public static Timestamp convStringToTimstamp(String strTime){
		Timestamp time = null;
		try{
			if (strTime == null){
				time = null;
			}else if (strTime.length() == 14 ){
				time = new Timestamp(FM_FULL.parse(strTime).getTime());
			}else if (strTime.length() == 19 ){
				time = new Timestamp(FM_YYYY_MM_DD_HH_MM_SS.parse(strTime).getTime());
			}else if (strTime.length() == 8 ){
				time = new Timestamp(FM_YYYYMMDD.parse(strTime).getTime());
			}else if (strTime.length() == 10 ){
				time = new Timestamp(FM_YYYY_MM_DD.parse(strTime).getTime());
			}
		}catch(Exception e){
			time = null;
		}
		return time;
	}

	/**
	 * YYYY/HH/DD hh:mm:ssをYYYYMMDDhhmmssに編集.
	 * @param date 区切り文字あり日付
	 * @return 区切り文字なし日付(文字列)
	 */
	public static String removeDelimiter(String date) {
	    if (StringUtil.isEmpty(date)) {
	        return "";
	    }
		return date.replaceAll("/","").replaceAll(" ", "").replaceAll(":", "");
	}

	/**
	 * 月末判定.
	 * @param date
	 * @return true:月末日 false:月末以外
	 */
	@SuppressWarnings("static-access")
	public static boolean isEndOfTheMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(getDD(date.toString()).equals(Integer.toString(calendar.getActualMaximum(calendar.DAY_OF_MONTH)))){
			return true;
		}

		return false;
	}

	/**
	 * 時刻フォーマット.
	 */
	public static enum DateFormatType {

		/**
		 * yyyyMMddHHmmssの日付フォーマット.
		 */
		YYYYMMDDHHMMSS("yyyyMMddHHmmss"),

		/**
		 * yyyyMMddHHmmss.SSSの日付フォーマット.
		 */
		YYYYMMDDHHMMSScSSS("yyyyMMddHHmmss.SSS"),

		/**
		 * yyyyMMddHHmmssSSSの日付フォーマット.
		 */
		YYYYMMDDHHMMSSSSS("yyyyMMddHHmmssSSS"),

		/**
		 * yyyyMMddHHmmの日付フォーマット.
		 */
		YYYYMMDDHHMM("yyyyMMddHHmm"),

		/**
		 * yyyyMMddHHの日付フォーマット.
		 */
		YYYYMMDDHH("yyyyMMddHH"),

		/**
		 * yyyyMMddの日付フォーマット.
		 */
		YYYYMMDD("yyyyMMdd"),

		/**
		 * yyyyMMdd HHmmの日付フォーマット.
		 */
		YYYYMMDD_HHMM("yyyyMMdd HHmm"),

		/**
		 * hhmmの日付フォーマット.
		 */
		HHMM("HHmm"),

		/**
		 * yyMMddの日付フォーマット.
		 */
		YYMMDD("yyMMdd"),

		/**
		 * yyMMdd HHmmの日付フォーマット.
		 */
		YYMMDD_HHMM("yyMMdd HHmm"),

		/**
		 * yyyy/MM/dd HHの日付フォーマット.
		 */
		YYYYsMMsDD_HH("yyyy/MM/dd HH"),

		/**
		 * yyyy/MM/dd HH:mmの日付フォーマット.
		 */
		YYYYsMMsDD_HHcMM("yyyy/MM/dd HH:mm"),

		/**
		 * yyyy/MM/dd HH:mm:ssの日付フォーマット.
		 */
		YYYYsMMsDD_HHcMMcSS("yyyy/MM/dd HH:mm:ss"),

		/**
		 * yyyy/MM/dd HH:mm:ss.SSSの日付フォーマット.
		 */
		YYYYsMMsDD_HHcMMcSScSSS("yyyy/MM/dd HH:mm:ss.SSS"),

		/**
		 * yyyy-MM-dd HH:mm:ssの日付フォーマット.
		 */
		YYYYhMMhDD_HHcMMcSS("yyyy-MM-dd HH:mm:ss"),

		/**
		 * yyyy-MM-dd HH:mm:ss.SSSの日付フォーマット.
		 */
		YYYYhMMhDD_HHcMMcSScSSS("yyyy-MM-dd HH:mm:ss.SSS"),

		/**
		 * yyyy/MMの日付フォーマット.
		 */
		YYYYsMM("yyyy/MM"),

		/**
		 * yyyy/MM/dd (E)の日付フォーマット.
		 */
		YYYYsMMsDD_E("yyyy/MM/dd (E)");

		/**
		 * フォーマット文字列(DateFormat指定).
		 */
		private String format ;

		/**
		 * コンストラクタ.
		 * @param format フォーマット文字列
		 */
		private DateFormatType(String format) {
			this.format = format;
		}

		/**
		 * フォーマット文字列取得メソッド.
		 * @return フォーマット文字列
		 */
		public String getFormatString() {
			return format;
		}
	}
}
