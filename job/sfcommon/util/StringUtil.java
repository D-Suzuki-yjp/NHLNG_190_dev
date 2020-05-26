package job.sfcommon.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文字列に関するユーティリティクラス.
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

	// userIdは[A-Z,0-9]のみ可能とする
	public static final Pattern P_USID = Pattern.compile("[A-Z0-9]+");

	// passwordは[a-z,A-Z,0-9]のみ可能とする
	public static final Pattern P_PSWD = Pattern.compile("[a-zA-Z0-9]+");

	// tel,faxは[0-9,-]のみ可能とする
	public static final Pattern P_TEL = Pattern.compile("[0-9\\-]+");

	private static final String E_WIN31J = "windows-31j";
	private static final String E_MS932 = "MS932";
	private static final String E_SJIS = "Shift_JIS";

	private static final String TRUE_TEXT = "true";
	private static final String TRUE_NUM = "1";

	/**
	 * 正規表現とのパターンマッチを検査する.
	 * @param p 正規表現
	 * @param target 検査する文字列(nullは常にfalse)
	 * @return 一致すればtrue
	 */
	public static boolean isMatch(Pattern p, String target) {
		if (target == null)
			return false;
		Matcher matcher = p.matcher(target);
		return matcher.matches();
	}

	/**
	 * 半角整数マッチ<PRE>[0-9]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchI(String target) {
		return isMatch(P_I, target);
	}

	/**
	 * 半角実数マッチ<PRE>[0-9,-,.]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchD(String target) {
		return isMatch(P_D, target);
	}

	/**
	 * 半角小文字英数マッチ<PRE>[a-z,0-9,-,.]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchLI(String target) {
		return isMatch(P_LI, target);
	}

	/**
	 * 半角大文字英数マッチ<PRE>[A-Z,0-9,-,.]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchUI(String target) {
		return isMatch(P_UI, target);
	}

	/**
	 * 半角英数マッチ<PRE>[a-z,A-Z,0-9,-,.]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchLUI(String target) {
		return isMatch(P_LUI, target);
	}

	/**
	 * ユーザID文字マッチ<PRE>[A-Z,0-9]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchUSID(String target) {
		return isMatch(P_USID, target);
	}

	/**
	 * パスワード文字マッチ<PRE>[a-z,A-Z,0-9]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchPSWD(String target) {
		return isMatch(P_PSWD, target);
	}

	/**
	 * TEL文字マッチ<PRE>[0-9,-]</PRE>.
	 * @param target 検査する文字列
	 * @return 一致すればtrue
	 */
	public static boolean isMatchTEL(String target) {
		return isMatch(P_TEL, target);
	}

	/**
	 * 全角(SJIS文字セット。外字不可)かチェックする.
	 * 全角波線、全角マイナスの文字はSJISマップとMS932マップの両方ＯＫ.
	 * @param target 検査する文字列
	 * @return 長さがない場合はfalse,SJIS文字セット以外もfalse
	 */
	public static boolean isMatchSJIS(String target) {
	    int ulen = length(target);
	    if (ulen == 0)
	      return false;
	    // MS932の波線をSJISの波線へ変換
	    target = target.replace('\uff5e', '\u301c');
	    // MS932のマイナスをSJISのマイナスへ変換
	    target = target.replace('\uff0d', '\u2212');
	    // MS932のダッシュをSJISのダッシュへ変換
	    target = target.replace('\u2015', '\u2014');
	    byte[] sjis = null;
	    try {
	    	sjis = target.getBytes(E_SJIS);
	    	// SJISのByte長がUNICODE文字数の２倍でなければエラー
	    	if (sjis.length != (ulen * 2))
	    		return false;
	      	// UNICODEへ戻して一致しなければエラー
	      	String uni = new String(sjis, E_SJIS);
	      	return target.equals(uni);
	    } catch (UnsupportedEncodingException e) {
	    	return false;
	    }
	}

	/**
	 * 全角(windows-31j文字セット。外字可)かチェックする.
	 * 全角波線、全角マイナスの文字はwindows-31jマップのUNICODE文字の必要がある.
	 * @param target 文字列
	 * @return 長さがない場合はfalse,windows-31j文字セット以外もfalse
	 */
	public static boolean isMatchWin31J(String target) {
		return isMatchEncode(target, E_WIN31J);
	}
	/**
	 * 全角(MS932文字セット)かチェックする.
	 * @param target 文字列
	 * @return 長さがない場合はfalse,MS932文字セット以外もfalse
	 */
	public static boolean isMatchMS932(String target) {
		return isMatchEncode(target, E_MS932);
	}

	/**
	 *  対象文字コードかチェックする.
	 * @param target 文字列
	 * @param encode エンコード
	 * @return 長さがない場合はfalse,対象文字コード文字セット以外もfalse
	 */
	private static boolean isMatchEncode(String target, String encode) {
	    int ulen = length(target);
	    if (ulen == 0)
	    	return false;
	    byte[] str = null;
	    try {
	    	str = target.getBytes(encode);
	      	// Byte長がUNICODE文字数の２倍でなければエラー
	      	if (str.length != (ulen * 2))
	      		return false;
	      	// UNICODEへ戻して一致しなければエラー
	      	String uni = new String(str, encode);
	      	return target.equals(uni);

	    } catch (UnsupportedEncodingException e) {
	    	return false;
	    }
	}

	/**
	 * MS932及びSJISのマイナスを長音(ー)へ変換する.
     * MS932及びSJISのダッシュを長音(ー)へ変換する.
	 * @param target 検査する文字列
	 * @return 変換した文字列
	 */
	public static String replaceMinusToChouon(String target) {
		if (isEmpty(target)){
			target="";
		}else{
			target = target.replace('\uff0d', 'ー');
	        target = target.replace('\u2212', 'ー');
	        target = target.replace('\u2015', 'ー');
	        target = target.replace('\u2014', 'ー');
	    }
		return target;
	}

	/**
	 * ２つの文字列が先頭からcount文字で一致するか検査する.
	 * @param s1 文字列
	 * @param s2 文字列
	 * @param count 文字数
	 * @return 一致すればtrue
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
	 * nullを気にせずに文字列の長さを返す。
	 * @param str 文字列
	 * @return nullの場合は0
	 */
	public static int length(String str) {
		return str != null ? str.length() : 0;
	}

	/**
	 * 半角全角混在でMS932に変換した場合のバイト長を返す。
	 * @param target 半角全角混在文字列
	 * @return MS932に変換した場合のバイト長
	 * @throws UnsupportedEncodingException UE例外
	 */
	public static int getByteLengthMS932(String target) 			throws UnsupportedEncodingException{
		return getByteLength(target, E_MS932);
	}
	/**
	 * 半角全角混在でWin31Jに変換した場合のバイト長を返す。
	 * @param target 半角全角混在文字列
	 * @return Win31Jに変換した場合のバイト長
	 * @throws UnsupportedEncodingException UE例外
	 */
	public static int getByteLengthWin31J(String target)
			throws UnsupportedEncodingException{
		return getByteLength(target, E_WIN31J);
	}
	/**
	 * 文字数にあったバイト数を返す.
	 * @param target 文字列
	 * @param encode エンコード
	 * @return 文字数にあったバイト数
	 * @throws UnsupportedEncodingException UE例外
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
	 * 長さが一致すればtrueを返す.
	 * @param str 文字列
	 * @param length 長さ
	 * @return 長さが一致すればtrueを返す
	 */
	public static boolean isLength(String str, int length) {
		return length(str) == length;
	}

	/**
	 * 長さが範囲内にあればtrueを返す.
	 * @param str 文字列
	 * @param minlen 最小入力文字数
	 * @param maxlen 最大入力文字数
	 * @return 長さが範囲内にあればtrueを返す
	 */
	public static boolean isRange(String str, int minlen, int maxlen) {
		int len = length(str);
		return minlen <= len && len <= maxlen;
	}

	/**
	 * 文字列がnullか空ならばtrueを返す.
	 * @param str 文字列
	 * @return 文字列がnullか空ならばtrueを返す
	 */
	public static boolean isEmpty(String str) {
		return length(str) == 0;
	}

	/**
	 *  isEmptyの逆.
	 * @param str 文字列
	 * @return 文字列が空の場合falseを返す
	 */
	public static boolean isExist(String str) {
		return isEmpty(str) == false;
	}

	/**
	 * 文字列がnullか空ならば""を返す．
	 * @param str 文字列
	 * @return 文字列がnullか空ならば""を返す
	 */
	public static String emptyStr(String str) {
		if (length(str) == 0) {
			return "";
		} else {
			return str;
		}
	}

	/**
	 * 文字列が"0","0   ","   0"の場合にtrueを返す.
	 * @param str 文字列
	 * @return 文字列が"0","0   ","   0"の場合にtrueを返す
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
	 * aとbが一致すればtrue.
     * aとbが互いにempttyでもtrue.
	 * @param a 文字列
	 * @param b 文字列
	 * @return 一致すればtrue,一致しなければfalse
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
	 * aとbを比較する.
	 * @param a 文字列
	 * @param b 文字列
	 * @return a.compare(b)が基本。nullは大きい方へ。
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
	 * nullならば空文字を返す.通常は"null"という文字列になる.
	 * @param str 文字列
	 * @return nullならば空文字を返す
	 */
	public static String toString(String str) {
		return length(str)==0 ? "" : str;
	}

	/**
	 * 後ろから規定文字数を抽出する.
	 * @param src 編集対象文字列
	 * @param maxLength 規定文字数
	 * @return 後ろから規定文字数を抽出した結果
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
	 * 前から規定文字数を抽出する.
	 * @param src 編集対象文字列
	 * @param maxLength 規定文字数
	 * @return 前から規定文字数を抽出した結果
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
     * バイト数での文字列長さを取得.
     *
     * @param str 対象文字列
     * @return 文字列長さ（バイト数）
     * @throws UnsupportedEncodingException UE例外
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
     * バイト数で文字列の先頭から指定文字列（バイト数）取得.
     *
     * @param val 対象文字列
     * @param len 切り出し長さ（バイト数）
     * @return 切り出し文字列
     * @throws UnsupportedEncodingException UE例外
     */
    public static String getLeftB(String val, int len) throws UnsupportedEncodingException {
    	return subStringB(val, 0, len);
    }

    /**
     * バイト数で文字列の末尾から指定文字列（バイト数）取得.
     *
     * @param val 対象文字列
     * @param len 切り出し長さ（バイト数）
     * @return 切り出し文字列
     * @throws UnsupportedEncodingException UE例外
     */
    public static String getRightB(String val, int len) throws UnsupportedEncodingException {
    	return subStringB(val, getLenB(val)-len, len);
    }

    /**
     * 文字列を開始位置（バイト数指定）から指定バイト数分切り出す.
     * 開始位置が2バイト文字に掛かる場合は掛かった文字位置を開始位置とする.
     *
     * @param val 対象文字列
     * @param start 開始文字列位置（バイト数）
     * @param subLen 切り出し文字数（バイト数）
     * @return 切り出し文字列
     * @throws UnsupportedEncodingException UE例外
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
     * 先頭から指定文字をトリムします.
     *
     * @param target 対象文字列
     * @param str トリム文字（1文字）
     * @return トリム後文字列
     */
    public static String Ltrim (String target, String str) {
        if (target==null || target.length()==0 || str==null || 1<str.length()) {
            return target;
        }

        String ret = target;
//        boolean act_flg = false;
        // 先頭からトリム文字以外がある場所を探す
        for (int i=0; i<target.length(); i++) {
            String ch = target.substring(i, i+1);
            if (str.equals(ch)) {
                // NOP
            } else {
            	// 出現場所から切り出す
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
     * 末尾から指定文字をトリムします.
     *
     * @param target 対象文字列
     * @param str トリム文字（1文字）
     * @return トリム後文字列
     */
    public static String Rtrim (String target, String str) {
        if (target==null || target.length()==0 || str==null || 1<str.length()) {
            return target;
        }

        String ret = target;
//        boolean act_flg = false;
        // 末尾からトリム文字以外がある場所を探す
        for (int i=target.length(); 0<i; i--) {
            String ch = target.substring(i-1, i);
            if (str.equals(ch)) {
                // NOP
            } else {
            	// 対象外文字列が出たら先頭から切り出す
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
     * 先頭に指定文字数になるまでパディングします.
     *
     * @param target 対象文字列
     * @param len 文字列長さ
     * @param pad パディング文字
     * @return パディング後文字列
     */
    public static String LPad(String target, int len, String pad) {
        if (target==null || len<=target.length() || pad==null || 1<pad.length()) {
            return target;
        }
        StringBuffer ret = new StringBuffer();
        // 先頭にパディング文字を埋める
        for (int i=0; i<(len-target.length()); i++) {
            ret.append(pad);
        }
        ret.append(target);

        return ret.toString();
    }

    /**
     * 末尾に指定文字数になるまでパディングします.
     *
     * @param target 対象文字列
     * @param len 文字列長さ
     * @param pad パディング文字
     * @return パディング後文字列
     */
    public static String RPad(String target, int len, String pad) {
        if (target==null || len<=target.length() || pad==null || 1<pad.length()) {
            return target;
        }
        StringBuffer ret = new StringBuffer(target);
        // 長さに達するまでパディング文字で埋める
        for (int i=target.length(); i<len; i++) {
            ret.append(pad);
        }
        return ret.toString();
    }

    /**
     * 先頭に指定文字数（バイト数）になるまでパディングします.
     *
     * @param target 対象文字列
     * @param len 文字列長（バイト数）
     * @param pad パディング文字
     * @return パディング後文字列
     * @throws UnsupportedEncodingException UE例外
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
     * 末尾に指定文字数（バイト数）になるまでパディングします.
     *
     * @param target 対象文字列
     * @param len 文字列長（バイト数）
     * @param pad パディング文字
     * @return パディング後文字列
     * @throws UnsupportedEncodingException UE例外
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
     * TRUE文字列チェック.
     * ("true","TRUE","1"のいずれかと一致したときtrue).
     *
     * @param str 対象文字列
     * @return true/false
     */
    public static boolean isTrueString(String str) {
    	// 空文字はfalse
    	if (isEmpty(str)) {
    		return false;
    	}
    	// 文字列が一致するかどうか
    	if (TRUE_TEXT.equals(str.toLowerCase()) || TRUE_NUM.equals(str)) {
    		return true;
    	}
    	return false;
    }

    /**
     * パスの"\"を"/"に変換.
     * nullの場合nullを返す.
     * @param path ファイルパス
     * @return 変換後ファイルパス
     */
    public static String getSlashPath(String path) {
        if (path == null) {
            return null;
        }
    	return path.replaceAll("\\\\", "/");
    }

    /**
     * スタックトレース文字列の取得.
     * @param e 例外
     * @return スタックトレース文字列
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
	 * スネークケース表記をローワーキャメルケース表記へ.
	 * @param targetStr スネーク表記文字列
	 * @return キャメル表記文字列
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
	 * キャメルケース表記をスネークケース表記（小文字）へ.
	 * @param targetStr キャメル表記文字列
	 * @return スネーク表記文字列
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
	 * 先頭文字を大文字に変換.
	 * @param str 対象文字列(英字)
	 * @return 先頭大文字の文字列
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
//	 * null文字列の場合、空文字("")へ変換します。
//	 * @param value 対象文字列
//	 * @return String 文字列
//	 */
//	public static String convertNull2Empty(String value) {
//		return value == null ? "" : value;
//	}

	/**
	 * HTML用文字変換.
	 *
	 * @param text 入力文字列
	 * @return 変換後文字列
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
     * 文字列を指定の区切り文字で分割します.<br>
     * 分割した全ての要素を格納した文字列配列を返します.<br>
     * また、分割した文字列はtrimされます.
     * @param orgStr 分割対象文字列
     * @param token 区切り文字
     * @return String[] 分割後文字列配列
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
     * 複数の文字列に区切り文字を付与して結合します.
     * @param inArray 結合対象文字列 nullの場合は空文字を返します
     * @param token 区切り文字
     * @return 結合後文字列
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
