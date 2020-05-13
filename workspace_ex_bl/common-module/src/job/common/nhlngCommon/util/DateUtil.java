package job.common.nhlngCommon.util;

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
 * �����A���t�֘A�̃��[�e�B���e�B.
 * �����f�[�^��YYYYMMDDhhmmss�`���̕�����Ƃ��Ĉ������Ƃ���{�Ƃ����c�[��.
 * Java��Date�^�ւ̕ϊ���e��UserInterface�`���ւ̕ϊ����T�|�[�g����.
 * YYYY(YY):�N(����)
 * MM:��
 * DD:��
 * hh:��
 * mm:��
 * ss:�b
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
	 * �ŏ��̓���(0000�N01��01��00:00:00)��YYYYMMDDhhmmss�`���ŕԂ�.
	 * @return YYYYMMDDhhmmss�`���̕�����
	 */
	public static String toMinDate() {
	    return "00000101000000";
	}

	/**
	 * �ő�̓���(9999�N12��31��23:59:59)��YYYYMMDDhhmmss�`���ŕԂ�.
	 * @return YYYYMMDDhhmmss�`���̕�����
	 */
	public static String toMaxDate(){
	    return "99991231235959";
	}

	/**
	 * �ŏ��̓��t(0000�N01��01��)��YYYYMMDD�`���ŕԂ�.
	 * @return YYYYMMDD�`���̕�����
	 */
	public static String toMinYYYYMMDD() {
	    return "00000101";
	}

	/**
	 * �ő�̓��t(9999�N12��31��)��YYYYMMDD�`���ŕԂ�.
	 * @return YYYYMMDD�`���̕�����
	 */
	public static String toMaxYYYYMMDD() {
	    return "99991231";
	}

	/**
	 * YYYYMMDDhhmmss�`���̕�����֕ϊ�����.
	 * @param dt ���t�^
	 * @return �ϊ�����������
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
	 * ���t�Ǝ�������YYYYMMDDhhmmss�`���̕�����֕ϊ�����.
	 * @param yyyymmdd ������
	 * @param hhmmss ������
	 * @return �ϊ�����������
	 */
	public static String toString(String yyyymmdd, String hhmmss) {
	    String dt = StringUtil.toString(yyyymmdd + hhmmss);
	    return (dt.length() == 14 ? dt : "");
	}

	/**
	 * YYYYMMDDhhmmss�`���̕����񂩂�Date�֕ϊ�����.
	 * @param dt ���t�`���̕�����
	 * @return Date�^�f�[�^
	 * @throws ParseException Parse��O
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
	 * YYYYMMDD�`���̕����񂩂�Date�֕ϊ�����.
	 * @param dt ���t�`���̕�����
	 * @return YYYYMMDD�^Date
	 * @throws ParseException Parse��O
	 */
	public static Date toDateYYYYMMDD(String dt)
			throws ParseException {
	    return toDate(dt);
	}

	/**
	 * YYYYMMDD�`���̕�����ɕϊ�����.
	 * @param dt Date�^
	 * @return YYYYMMDD�^������(null�̏ꍇ�͋󕶎�)
	 */
	public static String toYYYYMMDD(Date dt) {
		if (dt == null) return "";
		synchronized (FM_YYYYMMDD) {
			return FM_YYYYMMDD.format(dt);
		}
	}

	/**
	 * YYYYMM�`���̕�����ɕϊ�����.
	 * @param dt Date�^
	 * @return YYYYMM�^������
	 */
	public static String toYYYYMM(Date dt) {
		if (dt == null) return "";
		synchronized (FM_YYYYMM) {
			return FM_YYYYMM.format(dt);
		}
	}

	/**
	 * YYYYMM�`���̕�����ɕϊ�����.
	 * @param dt Date�^
	 * @return YYYYMM�^������
	 */
	public static String toYYYYhMMhDD_HHcMM(Date dt) {
		if (dt == null) return "";
		synchronized (YYYYhMMhDD_HHcMM) {
			return YYYYhMMhDD_HHcMM.format(dt);
		}
	}

	/**
	 * �N�������������������.
	 *
	 * @param y �N
	 * @param m ��
	 * @param d ��
	 * @return YYYYMMDD������(�G���[���͋󕶎�)
	 */
	public static String toYYYYMMDD(String y, String m, String d) {
	    String st = StringUtil.toString (formYYYY(y) + formNN(m) + formNN(d));
	    return (st.length() == 8 ? st : "");
	}


	/**
	 * ���t�^��hhmmss�`���̕�����ɕϊ�.
	 *
	 * @param dt Date�^
	 * @return HHMMSS�^������(null�̏ꍇ�͋󕶎�)
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
	 * �����b�̕��������������.
	 *
	 * @param h ��
	 * @param m ��
	 * @param s �b
	 * @return hhmmss������(�G���[���͋󕶎�)
	 */
	public static String toHHMMSS(String h, String m, String s) {
		String st = formNN(h) + formNN(m) + formNN(s);
		return (st.length() == 6 ? st : "");
	}

	/**
	 * �����b�̕��������������.
	 *
	 * @param h ��
	 * @param m ��
	 * @param s �b
	 * @return hhmmss������(�G���[���͋󕶎�)
	 */
	public static String to(String h, String m, String s) {
		String st = formNN(h) + formNN(m) + formNN(s);
		return (st.length() == 6 ? st : "");
	}

	/**
	 * �����񂪓��t�^�ɕϊ��ł��邩�`�F�b�N����.
	 * @param dt ������
	 * @return true:���t�^�ϊ��\/false:���t�^�ϊ��s��
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
	 * ������YYYYMMDD�`�����`�F�b�N����.
	 * null�̏ꍇ�Afalse��Ԃ�.
	 * �G���[�����������ꍇ�Afalse��Ԃ�.
	 * @param dt ���t�`���̕�����
	 * @return true:YYYYMMDD�`��/false:�ʌ`��
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
	 * ���ݓ�����yyyyMMddHHmmss�`���̕�����.
	 * @return YYYYMMDDhhmmss�^������
	 */
	public static String toNow() {
		return toString(new Date());
	}

	/**
	 * ���ݓ�����yyyyMMdd�`���̕�����.
	 * @return YYYYMMDD�^������
	 */
	public static String toToday() {
		return toYYYYMMDD(new Date());
	}

	/**
	 * ���ݓ�����HHmmss�`���̕�����.
	 * @return HHMMSS�^������
	 */
	public static String toNowTime() {
		return toHHMMSS(new Date());
	}

	/**
	 * ������������day����sec�b�������Z����yyyyMMddHHmmss�`���̕�����.
	 * @param day �����Z�������
	 * @param sec �����Z����b��
	 * @return yyyyMMddHHmmss�^�̕�����
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
	 * ���ݓ�����day���������Z����yyyyMMdd�`���̕�����.
	 * @param day �����Z�������
	 * @return YYYYMMDD�^�̕�����
	 */
	public static String toToday(int day) {
		Calendar cal = Calendar.getInstance();
		if (day != 0) {
			cal.add(Calendar.DAY_OF_MONTH, day);
		}
		return toYYYYMMDD(cal.getTime());
	}

	/**
	 * ���݌��̍ŏ��̓���yyyyMMdd�`���̕�����.
	 * @return yyyyMMdd�^�̕�����
	 */
	public static String toFirstDayOfMonth() {
		return toFirstDayOfMonth(0);
	}

	/**
	 * ���݌��̍ŏ��̓�����month���������Z����yyyyMMdd�`���̕�����.
	 * @param month �����Z���錎��
	 * @return YYYYMMDD�^�̕�����
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
	 * �w�肳�ꂽ���tdt8�̑�����N���̌�������yyyyMMdd�`���̕�����.
	 * �G���[�����������ꍇ�Anull�l��Ԃ��܂�.
	 * @param dt8 �L���ȔN�����܂�yyyyMMdd�`���̕�����
	 * @return �w��N���̌�����
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
	 * ���݌��̍Ō�̓���yyyyMMdd�`���̕�����.
	 * @return yyyyMMdd�^�̕�����
	 */
	public static String toLastDayOfMonth() {
		return toLastDayOfMonth(0);
	}

	/**
	 * ���݌��̍Ō�̓�����month���������Z����yyyyMMdd�`���̕�����.
	 * @param month �����Z���錎��
	 * @return YYYYMMDD�^�̕�����
	 */
	public static String toLastDayOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, 1 + month);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return toYYYYMMDD(cal.getTime());
	}

	/**
	 * �w�肳�ꂽ���tdt8�̑�����N���̌�������yyyyMMdd�`���̕�����.
	 * �G���[�����������ꍇ�Anull�l��Ԃ��܂�.
	 * @param dt8 �L���ȔN�����܂�yyyyMMdd�`���̕�����
	 * @return �w��N���̌�����
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
	 * �w�肳�ꂽ���tdt8�̑�����N���̌��������猎�����܂ł�z��ŕԂ�.
	 * �G���[�����������ꍇ�Anull�l��Ԃ��܂�.
	 * @param dt8 �L���ȔN�����܂�yyyyMMdd�`���̕�����
	 * @return �w��N���̌��������猎�����܂ł�z��
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
			String base = dt8.substring(0, 6); //�N��
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
	 * Date�^�ɑ΂��Ďw�肳�ꂽ�����W�������Z����<br>
	 * @param Date DateTime ����
	 * @param String range �����Z���郌���W
	 * @param int pram �����Z����l�i���̒l�Ō��Z�j
	 * @return �����Z��̓���
	 */
	public static Date calcDateTime(Date DateTime, String range, int pram) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTime);

		/** TODO �����W������̒萔��&��ޑ��₷ */
		switch(range){
		case "MINUTE":
			calendar.add(Calendar.MINUTE, pram);
			break;
		case "HOUR":
			calendar.add(Calendar.HOUR, pram);
			break;
		case "DAY":
			calendar.add(Calendar.DAY_OF_MONTH, pram);
			break;
		case "MONTH":
			calendar.add(Calendar.MONTH, pram);
			break;
		case "YEAR":
			calendar.add(Calendar.YEAR, pram);
			break;
		}
		DateTime = calendar.getTime();
		return DateTime;
	}




	/**
	 * 0��00�Ȃ�1,2�����s��ȏꍇ��2���ɐ��`����
	 * @param n ������
	 * @return 2���ɐ��`����������
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
	 * 0��00,0000�Ȃǌ����s��ȏꍇ��4���ɐ��`����B
     * 4���ɖ����Ȃ��ꍇ��2000�N�x�[�X�Ő��`����B
	 * @param y ������
	 * @return 4���ɐ��`����������
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
	 * yyyyMMdd�`���̕����񂩂�YYYY������؂�o��.
	 * @param dt8 ������
	 * @return YYYY������؂�o����������
	 */
	public static String getYYYY(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 4) {
			return null;
		}
		return dt8.substring(0, 4);
	}

	/**
	 * yyyyMMdd�`���̕����񂩂牺�Q��YY������؂�o��.
	 * @param dt8 ������
	 * @return ���Q��YY������؂�o����������
	 */
	public static String getYY(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 4) {
			return null;
		}
		return dt8.substring(2, 4);
	}

	/**
	 * yyyyMMdd�`���̕����񂩂�YYYYMM������؂�o���B
	 * @param dt8 ������
	 * @return YYYYMM������؂�o����������
	 */
	public static String getYYYYMM(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 6) {
			return null;
		}
		return dt8.substring(0, 6);
	}

	/**
	 * yyyyMMdd�`���̕����񂩂�YYYYMMDD������؂�o���B
	 * @param dt8 ������
	 * @return YYYYMMDD������؂�o����������
	 */
	public static String getYYYYMMDD(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 8) {
			return null;
		}
		return dt8.substring(0, 8);
	}

	/**
	 * getYY()�Ɠ����������ʂ���̏ꍇ�Ɍ��ݔN��Ԃ�.
	 * @param dt8 ������
	 * @return ���ʂ���̏ꍇ�Ɍ��ݔN��Ԃ�(������)
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
	 * Date�^�̂܂�YYYYMMDDHH�ɐ؂�̂Ă�.
	 * @param dt Date�^
	 * @return Date(YYYYMMDDHH)
	 * @throws ParseException
	 */
	public static Date moldYYYYMMDDHH(Date dt){
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.HOUR_OF_DAY);
	}

	/**
	 * Date�^�̂܂�YYYYMMDDHHmm�ɐ؂�̂Ă�.
	 * @param dt Date�^
	 * @return Date(YYYYMMDDHHmm)
	 */
	public static Date moldYYYYMMDDHHmm(Date dt) {
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.MINUTE);
	}

	/**
	 * yyyyMMdd�`���̕����񂩂�DD������؂�o��.
	 * @param dt8 ������
     * @return DD������؂�o����������
	 */
	public static String getDD(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 8) {
			return null;
		}
		return dt8.substring(6, 8);
	}

	/**
	 * Date�^�̂܂�YYYYMMDD�ɐ؂�̂Ă�.
	 * @param dt Date�^
	 * @return Date(YYYYMMDD)
	 * @throws ParseException
	 */
	public static Date moldYYYYMMDD(Date dt){
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.DAY_OF_MONTH);
	}

	/**
	 * yyyyMMdd�`���̕����񂩂�MM������؂�o��.
	 * @param dt8 ������
	 * @return MM������؂�o����������
	 */
	public static String getMM(String dt8) {
		if (StringUtil.isEmpty(dt8) || StringUtil.length(dt8) < 6) {
			return null;
		}
		return dt8.substring(4, 6);
	}

	/**
	 * Date�^�̂܂�YYYYMM�ɐ؂�̂Ă�.
	 * @param dt Date�^
	 * @return Date(YYYYMM)
	 * @throws ParseException
	 */
	public static Date moldYYYYMM(Date dt){
		if (dt == null) return null;
		return DateUtils.truncate(dt, Calendar.MONTH);
	}

	/**
	 * ���t����YYYY������؂�o��.
	 * @param dt ���t
	 * @return YYYY ����
	 */
	public static int getYYYY(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * ���t����MM������؂�o��.
	 * @param dt ���t
	 * @return MM ����
	 */
	public static int getMM(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * ���t����DD������؂�o��.
	 * @param dt ���t
	 * @return  DD ����
	 */
	public static int getDD(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * yyyyMMdd�`���̕����񂩂�j��(����)��Ԃ�.
	 * �G���[�����������ꍇ�A�󕶎���Ԃ�.
	 * @param dt8 ������
	 * @return �����񂩂�j��(����)��Ԃ�
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
	 * ���t����j��(����)��Ԃ�.
	 * �G���[�����������ꍇ�A�󕶎���Ԃ�.
	 * @param dt Date�^
	 * @return ���t����j��(����)��Ԃ�
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
				return "��";
			case Calendar.MONDAY:
				return "��";
			case Calendar.TUESDAY:
				return "��";
			case Calendar.WEDNESDAY:
				return "��";
			case Calendar.THURSDAY:
				return "��";
			case Calendar.FRIDAY:
				return "��";
			case Calendar.SATURDAY:
				return "�y";
			}
			return "";
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return "";
	}

	/**
	 * �j��(����)��html�`���ŕԂ�.
     * �y�j��blue��font�^�O�A���j��red��font�^�O��t����.
     * �G���[�����������ꍇ�A�󕶎���Ԃ�.
	 * @param dt8 ������
	 * @return �j��(����)��html�`���ŕԂ�(������)
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
				return "<font color=\"red\">��</font>";
			case Calendar.MONDAY:
				return "��";
			case Calendar.TUESDAY:
				return "��";
			case Calendar.WEDNESDAY:
				return "��";
			case Calendar.THURSDAY:
				return "��";
			case Calendar.FRIDAY:
				return "��";
			case Calendar.SATURDAY:
				return "<font color=\"blue\">�y</font>";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * yyyyMMddHHmmss�`���܂���HHmmss�`���̕����񂩂�HH������؂�o��.
     * ����(14or6)�Ŕ��f����.
	 * @param dt14 ������
	 * @return HH������؂�o����������
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
	 * yyyyMMddHHmmss�`���܂���HHmmss�`���̕����񂩂�mm������؂�o��.
     * ����(14or6)�Ŕ��f����.
	 * @param dt14 ������
	 * @return mm������؂�o����������
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
	 * yyyyMMddHHmmss�`���܂���HHmmss�`���̕����񂩂�ss������؂�o��.
     * ����(14or6)�Ŕ��f����.
	 * @param dt14 ������
	 * @return ss������؂�o����������
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
	 * yyyyMMdd�`���̕�����X���b�V����؂�ɂ��ĕԋp.
     * 8�����FYYYY/MM/DD
     * 6�����FYYYY/MM
     * 4�����FYYYY
	 * @param dt ������
	 * @return yyyyMMdd�`�����X���b�V����؂�ɂ���������
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
	 * �f�[�^�������AUI����(ascii�̂�)�ɕϊ�����.
	 * YYYY/MM/DD HH:mm:SS
	 * YYYY/MM/DD
	 * HH:mm:SS
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
	 * �f�[�^�������AUI����(ascii�̂�)�ɕϊ�����.
	 * YYYY/MM/DD HH:mm
	 * YYYY/MM/DD
	 * HH:mm
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
	 * �f�[�^�������AUI����(ascii�̂�)�ɕϊ�����.
	 * YY/MM/DD HH:mm:ss
	 * YY/MM/DD
	 * HH:mm:ss
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
	 * �f�[�^�������AUI����(ascii�̂�)�ɕϊ�����.
	 * YY/MM/DD HH:mm
	 * YY/MM/DD
	 * HH:mm
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
	 * �f�[�^�������AUI����(�����܂�)�ɕϊ�����.
	 * YYYY�NMM��DD��(�j) HH:mm
	 * YYYY�NMM��DD��(�j)
	 * HH:mm
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
	 */
	public static String toUI(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "�N" + getMM(dt) + "��" + getDD(dt) + "��" + "(" +
			getWeek(dt) + ") " + getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "�N" + getMM(dt) + "��" + getDD(dt) + "��" + "(" +
			getWeek(dt) + ")";
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * �f�[�^�������AUI����(�����܂ށA�j����)�ɕϊ�����.
	 * YYYY�NMM��DD�� HH:mm
	 * YYYY�NMM��DD��
	 * HH:mm
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
	 */
	public static String toUINonWeek(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "�N" + getMM(dt) + "��" + getDD(dt) + "��" + " " +
			getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "�N" + getMM(dt) + "��" + getDD(dt) + "��";
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * �f�[�^�������Ahtml����(font�^�O�t��)�ɕϊ�����.
	 * YYYY�NMM��DD��(�j) HH:mm
	 * YYYY�NMM��DD��(�j)
	 * HH:mm.
	 * �j�̕����́A�y�Ȃ��font�^�O��blue�A���Ȃ��font�^�O��red��Ԃ�
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
	 */
	public static String toHtml(String dt) {
		if (StringUtil.isEmpty(dt)) {
			return "";
		}
		int len = StringUtil.length(dt);
		if (len == 14) {
			return getYYYY(dt) + "�N" + getMM(dt) + "��" + getDD(dt) + "��" + "(" +
			getWeekHtml(dt) + ") " + getHH(dt) + ":" + getmm(dt);
		} else if (len == 8) {
			return getYYYY(dt) + "�N" + getMM(dt) + "��" + getDD(dt) + "��" + "(" +
			getWeekHtml(dt) + ")";
		} else if (len == 6) {
			return getHH(dt) + ":" + getmm(dt);
		} else {
			return dt;
		}
	}

	/**
	 * �f�[�^�������A�N����UI����(YYYY�NMM��)�ɕϊ�����.
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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

		return y + "�N" + m + "��";
	}

	/**
	 * �f�[�^�������A������UI����(MM/DD)�ɕϊ�����.
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
	 * �f�[�^�������A������UI����(HH:mm)�ɕϊ�����.
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
	 * �f�[�^�������A������UI����(MM��DD��)�ɕϊ�����.
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
		return m + "��" + d + "��";
	}

	/**
	 * �f�[�^�������A������UI����(HH��mm��)�ɕϊ�����.
	 * @param dt �f�[�^����(yyyyMMddHHmmss�Ȃ�)
	 * @return UI����
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
		return h + "��" + m + "��";
	}

	/**
	 * �f�[�^���� YYYY/MM/DD HH:mm:ss������t�^�ɕϊ�����.
	 * @param dt (YYYY/MM/DD HH:mm:ss�Ȃ�)
	 * @return ���t�^
	 * @throws ParseException Parse��O
	 *
	 */
	public static Date toDateSplitSCString(String dt)
			throws ParseException {
		int len = StringUtil.length(dt);
		if (len == 19) {
			// YYYY/MM/DD HH:mm:ss �̌`��
			synchronized (FM_YYYY_MM_DD_HH_MM_SS) {
				return FM_YYYY_MM_DD_HH_MM_SS.parse(dt);
			}
		} else if ((len == 17)
				&& (11 == dt.indexOf(":"))
				&& (5 == dt.lastIndexOf("/"))) {
			// YY/MM/DD HH:mm:ss �̌`��
			synchronized (FM_YYYY_MM_DD_HH_MM_SS) {
				// XX�N���A00XX�N�Ɖ��߂����ׁA�����̔N��ݒ�
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
	 * ���t�^����f�[�^���� YYYY/MM/DD HH:mm:ss�̕�����ɕϊ�����.
	 * null�̏ꍇ�Anull��Ԃ�.
	 * @param dt �Ώۓ��t
	 * @return �ϊ���̕�����
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
	 * ���t�^����f�[�^���� YYYY/MM/DD�̕�����ɕϊ�����.
	 * null�̏ꍇ�A�󕶎���Ԃ�.
	 * @param dt �Ώۓ��t
	 * @return �ϊ���̕�����
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
	 * ���t�^����f�[�^���� YYYY/MM/DD�̕�����ɕϊ�����.
	 * @param dtStr �Ώۓ��t
	 * @return �ϊ���̕�����
	 * @throws ParseException Parse��O
	 */
    public static String toYYYYMMDDSplitS(String dtStr)
    		throws ParseException{
    	Date wk = toDate(dtStr);
    	return toYYYYMMDDSplitS(wk);
    }

    /**
     * ���t�^�ɑ΂��A�����Z���s��.
     * null�̏ꍇ�Anull��Ԃ�.
     * @param targetDate �Ώۓ��t
     * @param h �����Z���鎞��
     * @return �ϊ���̓���
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
     * ���t�^�ɑ΂��A�����Z���s��.
     * null�̏ꍇ�Anull��Ԃ�.
     * @param targetDate �Ώۓ��t
     * @param day �����Z�������
     * @return �ϊ���̓���
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
     * ���t�^�ɑ΂��A���̉����Z���s��.
     * @param targetDate �Ώۓ��t
     * @param month �����Z���錎��
     * @return �ϊ���̓���
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
     * �V�X�e�����Ԃ��擾.
     * @return �V�X�e������
     */
	public static Date sysdate() {
		return new Date();
	}

	 /**
     * Date�^��String�^�ɕϊ����܂�.
     * @param date ���t
     * @param datePattern ���t�̃t�H�[�}�b�g
     * @return String�^�̓��t
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
	 * Date�^��String�^�ɕϊ����܂�.<br>
	 * <br>
	 * <b>�ړI:</b><br>
	 * Date�^��String�^�ɕϊ����܂�.<br>
	 * <br>
	 * <b>�����T�v:</b><br>
	 * Date�^��String�^�ɕϊ����܂�.<br>
	 * @param date Date�^���t
	 * @param datePattern �t�H�[�}�b�g�^�C�v
	 * @return �ϊ�����t������
	 */
	public static String convertDate2String(final Date date, final DateFormatType datePattern){
		return convertDate2String(date, datePattern.getFormatString());
	}

	/**
	 * java.sql.Timestamp��YYYYMMDDHHMMSS�`���̕�����ɕϊ�����.<br>
	 * <p>
	 * null�̎���null��Ԃ�.<br>
	 * </p>
	 * @param target �Ώۂ�Timestamp
	 * @return �ϊ���̕�����(YYYYMMDDHHMMSS�`��)
	 */
	public static String convTimestampToYYYYMMDDHHMMSS(Timestamp target) {

		if (target == null) {
			return null;
		}

		return FM_FULL.format(target);
	}

	/**
	 * ���ݓ��t���擾����.<br>
	 * @return ���ݓ��t(Timestamp�^)
	 */
	public static Timestamp getNow(){
		Calendar cal = Calendar.getInstance();
		return new Timestamp(cal.getTimeInMillis());
	}

	/**
	 * ���ݓ��t�e�L�X�g���擾����.<br>
	 * @return ���ݓ��t(������)
	 */
	public static String getNowTxt(){
		return FM_YYYY_MM_DD_HH_MM_SS.format(getNow());
	}
	/**
	 * �����񂩂���t�^�֕ϊ�����.
	 * null�̏ꍇ�Anull��Ԃ�.
	 * �G���[�����������ꍇ�Anull��Ԃ�.
	 * @param strTime �ϊ���������
	 * @return �ϊ�����t�^
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
	 * YYYY/HH/DD hh:mm:ss��YYYYMMDDhhmmss�ɕҏW.
	 * @param date ��؂蕶��������t
	 * @return ��؂蕶���Ȃ����t(������)
	 */
	public static String removeDelimiter(String date) {
	    if (StringUtil.isEmpty(date)) {
	        return "";
	    }
		return date.replaceAll("/","").replaceAll(" ", "").replaceAll(":", "");
	}

	/**
	 * �����t�H�[�}�b�g.
	 */
	public static enum DateFormatType {

		/**
		 * yyyyMMddHHmmss�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDDHHMMSS("yyyyMMddHHmmss"),

		/**
		 * yyyyMMddHHmmss.SSS�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDDHHMMSScSSS("yyyyMMddHHmmss.SSS"),

		/**
		 * yyyyMMddHHmmssSSS�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDDHHMMSSSSS("yyyyMMddHHmmssSSS"),

		/**
		 * yyyyMMddHHmm�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDDHHMM("yyyyMMddHHmm"),

		/**
		 * yyyyMMddHH�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDDHH("yyyyMMddHH"),

		/**
		 * yyyyMMdd�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDD("yyyyMMdd"),

		/**
		 * yyyyMMdd HHmm�̓��t�t�H�[�}�b�g.
		 */
		YYYYMMDD_HHMM("yyyyMMdd HHmm"),

		/**
		 * hhmm�̓��t�t�H�[�}�b�g.
		 */
		HHMM("HHmm"),

		/**
		 * yyMMdd�̓��t�t�H�[�}�b�g.
		 */
		YYMMDD("yyMMdd"),

		/**
		 * yyMMdd HHmm�̓��t�t�H�[�}�b�g.
		 */
		YYMMDD_HHMM("yyMMdd HHmm"),

		/**
		 * yyyy/MM/dd HH�̓��t�t�H�[�}�b�g.
		 */
		YYYYsMMsDD_HH("yyyy/MM/dd HH"),

		/**
		 * yyyy/MM/dd HH:mm�̓��t�t�H�[�}�b�g.
		 */
		YYYYsMMsDD_HHcMM("yyyy/MM/dd HH:mm"),

		/**
		 * yyyy/MM/dd HH:mm:ss�̓��t�t�H�[�}�b�g.
		 */
		YYYYsMMsDD_HHcMMcSS("yyyy/MM/dd HH:mm:ss"),

		/**
		 * yyyy/MM/dd HH:mm:ss.SSS�̓��t�t�H�[�}�b�g.
		 */
		YYYYsMMsDD_HHcMMcSScSSS("yyyy/MM/dd HH:mm:ss.SSS"),

		/**
		 * yyyy-MM-dd HH:mm:ss�̓��t�t�H�[�}�b�g.
		 */
		YYYYhMMhDD_HHcMMcSS("yyyy-MM-dd HH:mm:ss"),

		/**
		 * yyyy-MM-dd HH:mm:ss.SSS�̓��t�t�H�[�}�b�g.
		 */
		YYYYhMMhDD_HHcMMcSScSSS("yyyy-MM-dd HH:mm:ss.SSS"),

		/**
		 * yyyy/MM�̓��t�t�H�[�}�b�g.
		 */
		YYYYsMM("yyyy/MM"),

		/**
		 * yyyy/MM/dd (E)�̓��t�t�H�[�}�b�g.
		 */
		YYYYsMMsDD_E("yyyy/MM/dd (E)");

		/**
		 * �t�H�[�}�b�g������(DateFormat�w��).
		 */
		private String format ;

		/**
		 * �R���X�g���N�^.
		 * @param format �t�H�[�}�b�g������
		 */
		private DateFormatType(String format) {
			this.format = format;
		}

		/**
		 * �t�H�[�}�b�g������擾���\�b�h.
		 * @return �t�H�[�}�b�g������
		 */
		public String getFormatString() {
			return format;
		}
	}
}
