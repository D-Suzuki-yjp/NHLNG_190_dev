package job.common.nhlngCommon.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������Ɋւ��郆�[�e�B���e�B�N���X.
 *
 * @author kumagai.
 */
public class StringUtil {
	public static final Pattern P_I = Pattern.compile("[0-9]+");
	public static final Pattern P_D = Pattern.compile("[0-9\\-\\.]+");
	public static final Pattern P_LI = Pattern.compile("[a-z0-9\\-\\.]+");
	public static final Pattern P_UI = Pattern.compile("[A-Z0-9\\-\\.]+");
	public static final Pattern P_LUI =
		Pattern.compile("[a-zA-Z0-9\\-\\.]+");

	// userId��[A-Z,0-9]�̂݉\�Ƃ���
	public static final Pattern P_USID = Pattern.compile("[A-Z0-9]+");

	// password��[a-z,A-Z,0-9]�̂݉\�Ƃ���
	public static final Pattern P_PSWD = Pattern.compile("[a-zA-Z0-9]+");

	// tel,fax��[0-9,-]�̂݉\�Ƃ���
	public static final Pattern P_TEL = Pattern.compile("[0-9\\-]+");

	private static final String E_WIN31J = "windows-31j";
	private static final String E_MS932 = "MS932";
	private static final String E_SJIS = "Shift_JIS";

	private static final String TRUE_TEXT = "true";
	private static final String TRUE_NUM = "1";

	/**
	 * ���K�\���Ƃ̃p�^�[���}�b�`����������.
	 * @param p ���K�\��
	 * @param target �������镶����(null�͏��false)
	 * @return ��v�����true
	 */
	public static boolean isMatch(Pattern p, String target) {
		if (target == null)
			return false;
		Matcher matcher = p.matcher(target);
		return matcher.matches();
	}

	/**
	 * ���p�����}�b�`<PRE>[0-9]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchI(String target) {
		return isMatch(P_I, target);
	}

	/**
	 * ���p�����}�b�`<PRE>[0-9,-,.]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchD(String target) {
		return isMatch(P_D, target);
	}

	/**
	 * ���p�������p���}�b�`<PRE>[a-z,0-9,-,.]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchLI(String target) {
		return isMatch(P_LI, target);
	}

	/**
	 * ���p�啶���p���}�b�`<PRE>[A-Z,0-9,-,.]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchUI(String target) {
		return isMatch(P_UI, target);
	}

	/**
	 * ���p�p���}�b�`<PRE>[a-z,A-Z,0-9,-,.]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchLUI(String target) {
		return isMatch(P_LUI, target);
	}

	/**
	 * ���[�UID�����}�b�`<PRE>[A-Z,0-9]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchUSID(String target) {
		return isMatch(P_USID, target);
	}

	/**
	 * �p�X���[�h�����}�b�`<PRE>[a-z,A-Z,0-9]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchPSWD(String target) {
		return isMatch(P_PSWD, target);
	}

	/**
	 * TEL�����}�b�`<PRE>[0-9,-]</PRE>.
	 * @param target �������镶����
	 * @return ��v�����true
	 */
	public static boolean isMatchTEL(String target) {
		return isMatch(P_TEL, target);
	}

	/**
	 * �S�p(SJIS�����Z�b�g�B�O���s��)���`�F�b�N����.
	 * �S�p�g���A�S�p�}�C�i�X�̕�����SJIS�}�b�v��MS932�}�b�v�̗����n�j.
	 * @param target �������镶����
	 * @return �������Ȃ��ꍇ��false,SJIS�����Z�b�g�ȊO��false
	 */
	public static boolean isMatchSJIS(String target) {
	    int ulen = length(target);
	    if (ulen == 0)
	      return false;
	    // MS932�̔g����SJIS�̔g���֕ϊ�
	    target = target.replace('\uff5e', '\u301c');
	    // MS932�̃}�C�i�X��SJIS�̃}�C�i�X�֕ϊ�
	    target = target.replace('\uff0d', '\u2212');
	    // MS932�̃_�b�V����SJIS�̃_�b�V���֕ϊ�
	    target = target.replace('\u2015', '\u2014');
	    byte[] sjis = null;
	    try {
	    	sjis = target.getBytes(E_SJIS);
	    	// SJIS��Byte����UNICODE�������̂Q�{�łȂ���΃G���[
	    	if (sjis.length != (ulen * 2))
	    		return false;
	      	// UNICODE�֖߂��Ĉ�v���Ȃ���΃G���[
	      	String uni = new String(sjis, E_SJIS);
	      	return target.equals(uni);
	    } catch (UnsupportedEncodingException e) {
	    	return false;
	    }
	}

	/**
	 * �S�p(windows-31j�����Z�b�g�B�O����)���`�F�b�N����.
	 * �S�p�g���A�S�p�}�C�i�X�̕�����windows-31j�}�b�v��UNICODE�����̕K�v������.
	 * @param target ������
	 * @return �������Ȃ��ꍇ��false,windows-31j�����Z�b�g�ȊO��false
	 */
	public static boolean isMatchWin31J(String target) {
		return isMatchEncode(target, E_WIN31J);
	}
	/**
	 * �S�p(MS932�����Z�b�g)���`�F�b�N����.
	 * @param target ������
	 * @return �������Ȃ��ꍇ��false,MS932�����Z�b�g�ȊO��false
	 */
	public static boolean isMatchMS932(String target) {
		return isMatchEncode(target, E_MS932);
	}

	/**
	 *  �Ώە����R�[�h���`�F�b�N����.
	 * @param target ������
	 * @param encode �G���R�[�h
	 * @return �������Ȃ��ꍇ��false,�Ώە����R�[�h�����Z�b�g�ȊO��false
	 */
	private static boolean isMatchEncode(String target, String encode) {
	    int ulen = length(target);
	    if (ulen == 0)
	    	return false;
	    byte[] str = null;
	    try {
	    	str = target.getBytes(encode);
	      	// Byte����UNICODE�������̂Q�{�łȂ���΃G���[
	      	if (str.length != (ulen * 2))
	      		return false;
	      	// UNICODE�֖߂��Ĉ�v���Ȃ���΃G���[
	      	String uni = new String(str, encode);
	      	return target.equals(uni);

	    } catch (UnsupportedEncodingException e) {
	    	return false;
	    }
	}

	/**
	 * MS932�y��SJIS�̃}�C�i�X�𒷉�(�[)�֕ϊ�����.
     * MS932�y��SJIS�̃_�b�V���𒷉�(�[)�֕ϊ�����.
	 * @param target �������镶����
	 * @return �ϊ�����������
	 */
	public static String replaceMinusToChouon(String target) {
		if (isEmpty(target)){
			target="";
		}else{
			target = target.replace('\uff0d', '�[');
	        target = target.replace('\u2212', '�[');
	        target = target.replace('\u2015', '�[');
	        target = target.replace('\u2014', '�[');
	    }
		return target;
	}

	/**
	 * �Q�̕����񂪐擪����count�����ň�v���邩��������.
	 * @param s1 ������
	 * @param s2 ������
	 * @param count ������
	 * @return ��v�����true
	 */
	public static boolean startWith(String s1, String s2, int count) {
	    if (count <= 0)
	    	return true;
	    int s1len = length(s1);
	    int s2len = length(s2);
	    if (s1len < count || s2len < count)
	    	return false;
	    for (int i = 0; i < count; ++i) {
	    	if (s1.charAt(i) != s2.charAt(i))
	    		return false;
	    }
	    return true;

	}

	/**
	 * null���C�ɂ����ɕ�����̒�����Ԃ��B
	 * @param str ������
	 * @return null�̏ꍇ��0
	 */
	public static int length(String str) {
		return str != null ? str.length() : 0;
	}

	/**
	 * ���p�S�p���݂�MS932�ɕϊ������ꍇ�̃o�C�g����Ԃ��B
	 * @param target ���p�S�p���ݕ�����
	 * @return MS932�ɕϊ������ꍇ�̃o�C�g��
	 * @throws UnsupportedEncodingException UE��O
	 */
	public static int getByteLengthMS932(String target) 			throws UnsupportedEncodingException{
		return getByteLength(target, E_MS932);
	}
	/**
	 * ���p�S�p���݂�Win31J�ɕϊ������ꍇ�̃o�C�g����Ԃ��B
	 * @param target ���p�S�p���ݕ�����
	 * @return Win31J�ɕϊ������ꍇ�̃o�C�g��
	 * @throws UnsupportedEncodingException UE��O
	 */
	public static int getByteLengthWin31J(String target)
			throws UnsupportedEncodingException{
		return getByteLength(target, E_WIN31J);
	}
	/**
	 * �������ɂ������o�C�g����Ԃ�.
	 * @param target ������
	 * @param encode �G���R�[�h
	 * @return �������ɂ������o�C�g��
	 * @throws UnsupportedEncodingException UE��O
	 */
	public static int getByteLength(String target, String encode)
    		throws UnsupportedEncodingException {
	    int ulen = length(target);
	    if (ulen == 0)
	    	return 0;
	    byte[] sjis = target.getBytes(encode);
	    return sjis.length;
	}

	/**
	 * ��������v�����true��Ԃ�.
	 * @param str ������
	 * @param length ����
	 * @return ��������v�����true��Ԃ�
	 */
	public static boolean isLength(String str, int length) {
		return length(str) == length;
	}

	/**
	 * �������͈͓��ɂ����true��Ԃ�.
	 * @param str ������
	 * @param minlen �ŏ����͕�����
	 * @param maxlen �ő���͕�����
	 * @return �������͈͓��ɂ����true��Ԃ�
	 */
	public static boolean isRange(String str, int minlen, int maxlen) {
		int len = length(str);
		return minlen <= len && len <= maxlen;
	}

	/**
	 * ������null����Ȃ��true��Ԃ�.
	 * @param str ������
	 * @return ������null����Ȃ��true��Ԃ�
	 */
	public static boolean isEmpty(String str) {
		return length(str) == 0;
	}

	/**
	 *  isEmpty�̋t.
	 * @param str ������
	 * @return �����񂪋�̏ꍇfalse��Ԃ�
	 */
	public static boolean isExist(String str) {
		return isEmpty(str) == false;
	}

	/**
	 * ������null����Ȃ��""��Ԃ��D
	 * @param str ������
	 * @return ������null����Ȃ��""��Ԃ�
	 */
	public static String emptyStr(String str) {
		if (length(str) == 0) {
			return "";
		} else {
			return str;
		}
	}

	/**
	 * ������"0","0   ","   0"�̏ꍇ��true��Ԃ�.
	 * @param str ������
	 * @return ������"0","0   ","   0"�̏ꍇ��true��Ԃ�
	 */
	public static boolean isZero(String str) {
		int len = length(str);
		if (len == 0)
			return false;
		String txt = str.trim();
		for (int i=0; i<txt.length(); i++) {
			if (txt.charAt(i)!='0') return false;
		}
		return true;
	}

	/**
	 * a��b����v�����true.
     * a��b���݂���emptty�ł�true.
	 * @param a ������
	 * @param b ������
	 * @return ��v�����true,��v���Ȃ����false
	 */
	public static boolean equals(String a, String b) {
	    boolean exa = isExist(a);
	    boolean exb = isExist(b);
	    if (exa) {
	    	return exb ? a.equals(b) : false;
	    } else {
	    	return exb ? false : true;
	    }
	}

	/**
	 * a��b���r����.
	 * @param a ������
	 * @param b ������
	 * @return a.compare(b)����{�Bnull�͑傫�����ցB
	 */
	public static int compareTo(String a, String b) {
	    boolean exa = isExist(a);
	    boolean exb = isExist(b);
	    if (exa) {
	    	return exb? a.compareTo(b): -1;
	    } else {
	    	return exb? 1: 0;
	    }
	}

	/**
	 * null�Ȃ�΋󕶎���Ԃ�.�ʏ��"null"�Ƃ���������ɂȂ�.
	 * @param str ������
	 * @return null�Ȃ�΋󕶎���Ԃ�
	 */
	public static String toString(String str) {
		return length(str)==0 ? "" : str;
	}

	/**
	 * ��납��K�蕶�����𒊏o����.
	 * @param src �ҏW�Ώە�����
	 * @param maxLength �K�蕶����
	 * @return ��납��K�蕶�����𒊏o��������
	 */
	public static String getRight(String src, int maxLength) {
	    // src = src.trim();
	    if(maxLength < length(src)) {
	    	return src.substring(src.length()-maxLength);
	    } else {
	    	return src;
	    }
	}

	/**
	 * �O����K�蕶�����𒊏o����.
	 * @param src �ҏW�Ώە�����
	 * @param maxLength �K�蕶����
	 * @return �O����K�蕶�����𒊏o��������
	 */
	public static String getLeft(String src,int maxLength) {
	    // src = src.trim();
	    if(maxLength<length(src)) {
	    	return src.substring(0, maxLength);
	    } else {
 	    	return src;
	    }
	}

    /**
     * �o�C�g���ł̕����񒷂����擾.
     *
     * @param str �Ώە�����
     * @return �����񒷂��i�o�C�g���j
     * @throws UnsupportedEncodingException UE��O
     */
    public static int getLenB(String str) throws UnsupportedEncodingException {
        if (str==null || str.length()==0) {
            return 0;
        }
        int ret = 0;
        ret = str.getBytes(E_MS932).length;
        return ret;
    }

    /**
     * �o�C�g���ŕ�����̐擪����w�蕶����i�o�C�g���j�擾.
     *
     * @param val �Ώە�����
     * @param len �؂�o�������i�o�C�g���j
     * @return �؂�o��������
     * @throws UnsupportedEncodingException UE��O
     */
    public static String getLeftB(String val, int len) throws UnsupportedEncodingException {
    	return subStringB(val, 0, len);
    }

    /**
     * �o�C�g���ŕ�����̖�������w�蕶����i�o�C�g���j�擾.
     *
     * @param val �Ώە�����
     * @param len �؂�o�������i�o�C�g���j
     * @return �؂�o��������
     * @throws UnsupportedEncodingException UE��O
     */
    public static String getRightB(String val, int len) throws UnsupportedEncodingException {
    	return subStringB(val, getLenB(val)-len, len);
    }

    /**
     * ��������J�n�ʒu�i�o�C�g���w��j����w��o�C�g�����؂�o��.
     * �J�n�ʒu��2�o�C�g�����Ɋ|����ꍇ�͊|�����������ʒu���J�n�ʒu�Ƃ���.
     *
     * @param val �Ώە�����
     * @param start �J�n������ʒu�i�o�C�g���j
     * @param subLen �؂�o���������i�o�C�g���j
     * @return �؂�o��������
     * @throws UnsupportedEncodingException UE��O
     */
    public static String subStringB(String val, int start, int subLen) throws UnsupportedEncodingException{
        if (val==null || val.length()==0) {
            return val;
        }
        if (start<0) {
            start = 0;
        }
        int endLen = start + subLen;

        // Check 2byte String
        StringBuffer sub = new StringBuffer();
        int blen = 0;
        int strlen = 0;
        for (int i=0; i<val.length(); i++) {
            String ch = val.substring(i, i+1);
            int chlen = getLenB(ch);
            if (strlen==0 && start < (blen+chlen) && (blen+chlen)<(start+chlen)) {
            	start = blen+chlen;
            }
            if (start < (blen+chlen) && (strlen+chlen) <= subLen) {
                sub.append(ch);
                strlen += chlen;
            }
            blen += chlen;
            if (endLen <= blen) {
                break;
            }
        }
        return sub.toString();
    }

    /**
     * �擪����w�蕶�����g�������܂�.
     *
     * @param target �Ώە�����
     * @param str �g���������i1�����j
     * @return �g�����㕶����
     */
    public static String Ltrim (String target, String str) {
        if (target==null || target.length()==0 || str==null || 1<str.length()) {
            return target;
        }

        String ret = target;
//        boolean act_flg = false;
        // �擪����g���������ȊO������ꏊ��T��
        for (int i=0; i<target.length(); i++) {
            String ch = target.substring(i, i+1);
            if (str.equals(ch)) {
                // NOP
            } else {
            	// �o���ꏊ����؂�o��
                ret = target.substring(i);
//                act_flg = true;
                break;
            }
        }
//        if (!act_flg) {
//            return "";
//        }
        return ret;
    }

    /**
     * ��������w�蕶�����g�������܂�.
     *
     * @param target �Ώە�����
     * @param str �g���������i1�����j
     * @return �g�����㕶����
     */
    public static String Rtrim (String target, String str) {
        if (target==null || target.length()==0 || str==null || 1<str.length()) {
            return target;
        }

        String ret = target;
//        boolean act_flg = false;
        // ��������g���������ȊO������ꏊ��T��
        for (int i=target.length(); 0<i; i--) {
            String ch = target.substring(i-1, i);
            if (str.equals(ch)) {
                // NOP
            } else {
            	// �ΏۊO�����񂪏o����擪����؂�o��
                ret = target.substring(0, i);
//                act_flg = true;
                break;
            }
        }
//        if (!act_flg) {
//            return "";
//        }
        return ret;
    }

    /**
     * �擪�Ɏw�蕶�����ɂȂ�܂Ńp�f�B���O���܂�.
     *
     * @param target �Ώە�����
     * @param len �����񒷂�
     * @param pad �p�f�B���O����
     * @return �p�f�B���O�㕶����
     */
    public static String LPad(String target, int len, String pad) {
        if (target==null || len<=target.length() || pad==null || 1<pad.length()) {
            return target;
        }
        StringBuffer ret = new StringBuffer();
        // �擪�Ƀp�f�B���O�����𖄂߂�
        for (int i=0; i<(len-target.length()); i++) {
            ret.append(pad);
        }
        ret.append(target);

        return ret.toString();
    }

    /**
     * �����Ɏw�蕶�����ɂȂ�܂Ńp�f�B���O���܂�.
     *
     * @param target �Ώە�����
     * @param len �����񒷂�
     * @param pad �p�f�B���O����
     * @return �p�f�B���O�㕶����
     */
    public static String RPad(String target, int len, String pad) {
        if (target==null || len<=target.length() || pad==null || 1<pad.length()) {
            return target;
        }
        StringBuffer ret = new StringBuffer(target);
        // �����ɒB����܂Ńp�f�B���O�����Ŗ��߂�
        for (int i=target.length(); i<len; i++) {
            ret.append(pad);
        }
        return ret.toString();
    }

    /**
     * �擪�Ɏw�蕶�����i�o�C�g���j�ɂȂ�܂Ńp�f�B���O���܂�.
     *
     * @param target �Ώە�����
     * @param len �����񒷁i�o�C�g���j
     * @param pad �p�f�B���O����
     * @return �p�f�B���O�㕶����
     * @throws UnsupportedEncodingException UE��O
     */
    public static String LPadB(String target, int len, String pad) throws UnsupportedEncodingException {
        int strlen = getLenB(target);
        if (target==null || len<=strlen || pad==null || 1<pad.length()) {
            return target;
        }
        StringBuffer ret = new StringBuffer();
        int strcnt = 0;
        int padlen = getLenB(pad);
        while (strcnt<(len-strlen)) {
            if ((len-strlen)<(strcnt+padlen)) {
                break;
            }
            ret.append(pad);
            strcnt += padlen;
        }
        ret.append(target);

        return ret.toString();
    }

    /**
     * �����Ɏw�蕶�����i�o�C�g���j�ɂȂ�܂Ńp�f�B���O���܂�.
     *
     * @param target �Ώە�����
     * @param len �����񒷁i�o�C�g���j
     * @param pad �p�f�B���O����
     * @return �p�f�B���O�㕶����
     * @throws UnsupportedEncodingException UE��O
     */
    public static String RPadB(String target, int len, String pad) throws UnsupportedEncodingException {
        int strlen = getLenB(target);
        if (target==null || len<=strlen || pad==null || 1<pad.length()) {
            return target;
        }
        StringBuffer ret = new StringBuffer(target);
        int strcnt = strlen;
        int padlen = getLenB(pad);
        while(strcnt<len) {
            if (len<(strcnt+padlen)) {
                break;
            }
            ret.append(pad);
            strcnt += padlen;
        }
        return ret.toString();
    }

    /**
     * TRUE������`�F�b�N.
     * ("true","TRUE","1"�̂����ꂩ�ƈ�v�����Ƃ�true).
     *
     * @param str �Ώە�����
     * @return true/false
     */
    public static boolean isTrueString(String str) {
    	// �󕶎���false
    	if (isEmpty(str)) {
    		return false;
    	}
    	// �����񂪈�v���邩�ǂ���
    	if (TRUE_TEXT.equals(str.toLowerCase()) || TRUE_NUM.equals(str)) {
    		return true;
    	}
    	return false;
    }

    /**
     * �p�X��"\"��"/"�ɕϊ�.
     * null�̏ꍇnull��Ԃ�.
     * @param path �t�@�C���p�X
     * @return �ϊ���t�@�C���p�X
     */
    public static String getSlashPath(String path) {
        if (path == null) {
            return null;
        }
    	return path.replaceAll("\\\\", "/");
    }

    /**
     * �X�^�b�N�g���[�X������̎擾.
     * @param e ��O
     * @return �X�^�b�N�g���[�X������
     */
    public static String getStackTraceString(Throwable e) {
    	StackTraceElement[] stack = e.getStackTrace();
    	StringBuilder sb = new StringBuilder();
    	sb.append(e.getMessage()).append(ConstUtil.LINE_SEPARATOR);
    	if (stack != null && 0 < stack.length) {
    		for (int i=0; i<stack.length; i++) {
    			sb.append(stack[i].toString()).append(ConstUtil.LINE_SEPARATOR);
    		}
    	}
    	return sb.toString();
    }

	/**
	 * �X�l�[�N�P�[�X�\�L�����[���[�L�������P�[�X�\�L��.
	 * @param targetStr �X�l�[�N�\�L������
	 * @return �L�������\�L������
	 */
	public static String snakeToCamel(String targetStr) {
	    if (isEmpty(targetStr)) {
	        return "";
	    }
		Pattern p = Pattern.compile("_([a-z]|[0-9])");
		Matcher m = p.matcher(targetStr.toLowerCase());

		StringBuffer sb = new StringBuffer(targetStr.length());
		while (m.find()) {
			m.appendReplacement(sb, m.group(1).toUpperCase());
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * �L�������P�[�X�\�L���X�l�[�N�P�[�X�\�L�i�������j��.
	 * @param targetStr �L�������\�L������
	 * @return �X�l�[�N�\�L������
	 */
	public static String camelToSnake(String targetStr) {
	    if (isEmpty(targetStr)) {
	        return "";
	    }
		String convertedStr = targetStr
		.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
		.replaceAll("([a-z])([A-Z])", "$1_$2");
		return convertedStr.toLowerCase();
	}

	/**
	 * �擪������啶���ɕϊ�.
	 * @param str �Ώە�����(�p��)
	 * @return �擪�啶���̕�����
	 */
	public static String upperCaseTop(String str) {
	    if (isEmpty(str)) {
	        return "";
	    }
		StringBuilder sb = new StringBuilder(str);

		String initial = sb.substring(0, 1);
		sb = sb.delete(0, 1);
		initial = initial.toUpperCase();
		sb.insert(0, initial);
		return sb.toString();

	}

//	/**
//	 * null������̏ꍇ�A�󕶎�("")�֕ϊ����܂��B
//	 * @param value �Ώە�����
//	 * @return String ������
//	 */
//	public static String convertNull2Empty(String value) {
//		return value == null ? "" : value;
//	}

	/**
	 * HTML�p�����ϊ�.
	 *
	 * @param text ���͕�����
	 * @return �ϊ��㕶����
	 */
	public static String unparseTagText(final String text){
		String tmp = text;
		if (tmp!=null){
			tmp = tmp.replaceAll("&quot;","\"");
			tmp = tmp.replaceAll("&amp;","&");
			tmp = tmp.replaceAll("&lt;","<");
			tmp = tmp.replaceAll("&gt;",">");
			tmp = tmp.replaceAll("&nbsp;"," ");
			tmp = tmp.replaceAll("&copy;","@");
		}
		return tmp;
	}

	   /**
     * ��������w��̋�؂蕶���ŕ������܂�.<br>
     * ���������S�Ă̗v�f���i�[����������z���Ԃ��܂�.<br>
     * �܂��A���������������trim����܂�.
     * @param orgStr �����Ώە�����
     * @param token ��؂蕶��
     * @return String[] �����㕶����z��
     */
    public static String[] textToArray(String orgStr, String token) {
        if (isEmpty(orgStr)) {
            return null;
        }
        List<String> tempList = new ArrayList<String>();
        String tempArray[] = (String[])null;
        if(orgStr != null && orgStr.length() > 0) {
            tempArray = orgStr.split(token);
            tempList = Arrays.asList(tempArray);
        }
        tempArray = new String[tempList.size()];
        for(int i = 0; i < tempList.size(); i++) {
            if(i < tempList.size()) {
                tempArray[i] = (tempList.get(i)).trim();
            } else {
                tempArray[i] = "";
            }
        }

        tempList = null;
        return tempArray;
    }


    /**
     * �����̕�����ɋ�؂蕶����t�^���Č������܂�.
     * @param inArray �����Ώە����� null�̏ꍇ�͋󕶎���Ԃ��܂�
     * @param token ��؂蕶��
     * @return �����㕶����
     */
    public static final String arrayToText(String inArray[], String token) {
        if(inArray == null || inArray.length == 0) {
            return "";
        }
        int totalSize = inArray.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < totalSize; i++) {
            if (isEmpty(inArray[i])) {
                sb.append("");
            } else {
                sb.append(inArray[i]);
            }
            if(i < totalSize - 1) {
                sb.append(token);
            }
        }

        return new String(sb);
    }

}
