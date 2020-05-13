package job.common.nhlngCommon.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author kumagai
 *
 */
public class NumUtil {
    /**
     * 数値のフォーマット変換(#,##0).
     *
     * @param num
     *            int型の数値
     * @return [#,##0]形式の文字列 ※nullの場合は0
     */
    public static String formatNum(int num) {
        String ret = "";
        Integer value = (num);
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance();
        df.applyPattern("#,##0");
        ret = df.format(value);
        return ret;
    }

    /**
     * 数値のフォーマット変換(#,##0).
     *
     * @param num
     *            long型の数値
     * @return [#,##0]形式の文字列 ※nullの場合は0
     */
    public static String formatNum(long num) {
        String ret = "";
        Long value = (num);
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance();
        df.applyPattern("#,##0");
        ret = df.format(value);
        return ret;
    }

    /**
     * 数値のフォーマット変換(#,##0).
     *
     * @param num
     *            double型の数値
     * @return [#,##0]形式の文字列 ※nullの場合は0
     */
    public static String formatNum(double num) {
        return formatNum(num, 340);
    }

    /**
     * 数値のフォーマット変換(#,##0).
     *
     * @param num
     *            double型の数値
     * @param digitSize
     *            int型の数値
     * @return [#,##0]形式の文字列 ※nullの場合は0
     */
    public static String formatNum(double num, int digitSize) {
        String ret = "";
        String format = "#,##0";
        if (0 < digitSize && digitSize < 10) {
            format += ".";
            for (int i = 0; i < digitSize; i++) {
                format += "0";
            }
        } else {
            format += ".0";
        }
        Double value = (num);
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance();
        df.applyPattern(format);
        df.setMaximumFractionDigits(digitSize);
        ret = df.format(value);
        return ret;
    }

    /**
     * 数値のフォーマット変換(\\#,##0).
     *
     * @param num
     *            int型の数値
     * @return [\\#,##0]形式の文字列 ※nullの場合は\0
     */
    public static String formatYen(int num) {
        String ret = "";
        ret = "\\" + formatNum(num);
        return ret;
    }

    /**
     * 数値のフォーマット変換(\\#,##0).
     *
     * @param num
     *            long型の数値
     * @return [\\#,##0]形式の文字列 ※nullの場合は\0
     */
    public static String formatYen(long num) {
        String ret = "";
        ret = "\\" + formatNum(num);
        return ret;
    }

    /**
     * 数値のフォーマット変換(\\#,##0).
     *
     * @param num
     *            double型の数値
     * @return [\\#,##0]形式の文字列 ※nullの場合は\0
     */
    public static String formatYen(double num) {
        String ret = "";
        ret = "\\" + formatNum(num);
        return ret;
    }

    /**
     * 数値のフォーマット変換(\\#,##0).
     *
     * @param num
     *            double型の数値
     * @param digitPos
     *            int型の数値
     * @return [\\#,##0]形式の文字列 ※nullの場合は\0
     */
    public static String formatYen(double num, int digitPos) {
        String ret = "";
        ret = "\\" + formatNum(num, digitPos);
        return ret;
    }

    /**
     * 指定された文字列を整数に変換して返します. 整数型に変換できなかった場合は、NumberFormatExceptionをスローします.
     *
     * @param value
     *            文字列
     * @return 変換した整数
     * @exception NumberFormatException
     *                数値型変換時に失敗した場合
     */
    public static int toInt(String value) throws NumberFormatException {
        if (value == null || value.length() == 0) {
            throw new NumberFormatException("Invalid Value[" + value + "]");
        }
        return Integer.parseInt(value.trim().replaceAll(",", ""));
    }

    /**
     * 指定された文字列を整数に変換して返します. エラーが発生した場合、デフォルト値を返します.
     *
     * @param value
     *            文字列
     * @param defaultValue
     *            デフォルト値
     * @return 変換した整数
     */
    public static int toInt(String value, int defaultValue) {
        try {
            return toInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 指定された文字列を浮動小数点型に変換して返します.
     * 単精度浮動小数点型に変換できなかった場合は、NumberFormatExceptionをスローします.
     *
     * @param value
     *            文字列
     * @return 変換した浮動小数点型
     * @exception NumberFormatException
     *                数値型変換時に失敗した場合
     */
    public static float toFloat(String value) throws NumberFormatException {
        if (value == null || value.length() == 0) {
            throw new NumberFormatException("Invalid Value[" + value + "]");
        }
        return Float.parseFloat(value.trim().replaceAll(",", ""));
    }

    /**
     * 指定された文字列を浮動小数点型に変換して返します. エラーが発生した場合、デフォルト値を返します.
     *
     * @param value
     *            文字列
     * @param defaultValue
     *            デフォルト値
     * @return 変換した浮動小数点型
     */
    public static float toFloat(String value, float defaultValue) {
        try {
            return toFloat(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 指定された文字列を整数に変換して返します. 整数型に変換できなかった場合は、NumberFormatExceptionをスローします.
     *
     * @param value
     *            文字列
     * @return 変換した整数
     * @exception NumberFormatException
     *                数値型変換時に失敗した場合
     */
    public static long toLong(String value) throws NumberFormatException {
        if (value == null || value.length() == 0) {
            throw new NumberFormatException("Invalid Value[" + value + "]");
        }
        return Long.parseLong(value.trim().replaceAll(",", ""));
    }

    /**
     * 指定された文字列を整数に変換して返します. エラーが発生した場合、デフォルト値を返します.
     *
     * @param value
     *            文字列
     * @param defaultValue
     *            デフォルト値
     * @return 変換した整数
     */
    public static long toLong(String value, long defaultValue) {
        try {
            return toLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 四捨五入関数. エラーが発生した場合、デフォルト値を返します.
     *
     * @param val
     *            対象数値（文字列）
     * @param decimalPoint
     *            小数点桁数（文字列）
     * @param nDefVal
     *            デフォルト値（文字列）
     * @return 変換した文字列
     */
    public static String round(String val, String decimalPoint,
            String nDefVal) {
        String retValue = "";
        int decCnt = 0;
        // 入力チェック
        if (val == null || val.length() == 0 || decimalPoint == null
                || decimalPoint.length() == 0) {
            return nDefVal;
        }
        // 小数点以下桁数を取得
        decCnt = toInt(decimalPoint, 0);
        try {
            // 定数を定義
            // BigDecimal BdOne = new BigDecimal(1);

            // 変換対象の値を取得
            BigDecimal BdTargetVal = new BigDecimal(val);

            // 四捨五入を実行
            BigDecimal DbFormatVal = BdTargetVal.setScale(decCnt,
                    BigDecimal.ROUND_HALF_UP);

            // 値を文字列へ変換
            retValue = DbFormatVal.toPlainString();

        } catch (NumberFormatException e) {
            // エラー発生時は、デフォルト値を返答
            retValue = nDefVal;
        }
        return retValue;
    }

    /**
     * 四捨五入関数.
     *
     * @param val
     *            入力値 double型の数値
     * @param pos
     *            小数点桁数 int型の数値
     * @return 四捨五入後の値（文字列）
     */
    public static String round(double val, int pos) {
        return roundMain(val, pos, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 切捨て関数.
     *
     * @param val
     *            入力値 double型の数値
     * @param pos
     *            小数点桁数 int型の数値
     * @return 切捨て後の値（文字列）
     */
    public static String roundDown(double val, int pos) {
        return roundMain(val, pos, BigDecimal.ROUND_DOWN);
    }

    /**
     * 切上げ関数.
     *
     * @param val
     *            入力値 double型の数値
     * @param pos
     *            小数点桁数 int型の数値
     * @return 切上げ後の値（文字列）
     */
    public static String roundUp(double val, int pos) {
        return roundMain(val, pos, BigDecimal.ROUND_UP);
    }

    /**
     * 丸め関数.
     *
     * @param val
     *            入力値 double型の数値
     * @param pos
     *            小数点桁数 int型の数値
     * @param coef
     *            変換定数(BigDecimal定数) int型の数値
     * @return 変換後の値（文字列）
     */
    public static String roundMain(double val, int pos, int coef) {

        // 変換対象の値を取得
        BigDecimal BdTargetVal = new BigDecimal(val);

        BigDecimal DbFormatVal = BdTargetVal.setScale(pos, coef);

        // 値を文字列へ変換
        return DbFormatVal.toPlainString();
    }

    /**
     * 除算した余りを返す.
     *
     * @param src
     *            int型の数値
     * @param num
     *            int型の数値
     * @return 除算した余り
     */

    public static int Mod(int src, int num) {
        int a = src % num;

        return a;

    }

    /**
     * 除算した余りを返す(浮動小数点型).
     *
     * @param val
     *            float型の数値
     * @param num
     *            int型の数値
     * @param dp
     *            小数点桁数
     * @return 変換した浮動小数点型
     */
    public static float Mod(float val, int num, int dp) {
        float a = val % num;
        String fmt = ("%." + dp + "f");
        String format = String.format(fmt, a);
        float fl = Float.parseFloat(format);

        return fl;

    }

    // // 判定する桁数は一ケタ多い
    // pos++;
    // // 判定桁に足す値を計算
    // double plus = coef * Math.pow( 10, -pos );
    // if (plus<val) {
    // val += plus;
    // }
    // // フォーマットの準備
    // // 少数の場合判定する桁数まで含める
    // DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance();
    // StringBuffer fmt = new StringBuffer("0.");
    // for (int i=0; i<(pos+1); i++) {
    // fmt.append("0");
    // }
    // df.applyPattern(fmt.toString());
    // String dfval = df.format(val);
    // String rval = "";
    // if (0<pos) {
    // // 少数の場合は余計な桁を削除する
    // rval = dfval.substring(0, dfval.length()-2);
    // } else {
    // // 整数の場合判定桁数以降を"0"で埋める
    // int max = dfval.indexOf(".");
    // if (max<0) {
    // max = dfval.length();
    // }
    // if (((-pos)+1)<max) {
    // // "0"埋めが必要な場合
    // rval = dfval.substring(0, max+pos-1);
    //
    // if (rval.length()<max) {
    // StringBuffer ret = new StringBuffer(rval);
    // for (int i=rval.length(); i<max; i++) {
    // ret.append("0");
    // }
    // rval = ret.toString();
    // }
    // } else {
    // // "0"埋め必要なし
    // rval = dfval;
    // }
    // }
    // // 文字列の最後が"."で終わるときは"."を削除する
    // return ".".equals(rval.substring(rval.length()-1, rval.length())) ?
    // rval.substring(0, rval.length()-1) : rval;
}

/*
 * public static void main(String[] args) throws Exception { // TEST モジュール int
 * nval = 3002; String sInt = NumUtil.toNumberSep(nval); String sInt2 =
 * NumUtil.toNumberYen(nval); long lval = 999999999990L; String slong =
 * NumUtil.toNumberSep(lval); String slong2 = NumUtil.toNumberYen(lval); double
 * dval1 = 999999999990.000001; String sdouble = NumUtil.toNumberSep(dval1);
 * String sdoubleA = NumUtil.toNumberYen(dval1); double dval2 = 0.9899945;
 * String sdouble2 = NumUtil.toNumberSep(dval2); String sdoubleA2 =
 * NumUtil.toNumberYen(dval2); String sdouble3 = NumUtil.toNumberSep(dval2,5);
 * String sdoubleA3 = NumUtil.toNumberYen(dval2,5);
 *
 * System.out.println(sInt); System.out.println(slong);
 * System.out.println(sdouble); System.out.println(sdouble2);
 * System.out.println(sdouble3); System.out.println(sInt2);
 * System.out.println(slong2); System.out.println(sdoubleA);
 * System.out.println(sdoubleA2); System.out.println(sdoubleA3); }
 */
