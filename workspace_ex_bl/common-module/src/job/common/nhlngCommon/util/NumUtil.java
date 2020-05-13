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
     * ���l�̃t�H�[�}�b�g�ϊ�(#,##0).
     *
     * @param num
     *            int�^�̐��l
     * @return [#,##0]�`���̕����� ��null�̏ꍇ��0
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
     * ���l�̃t�H�[�}�b�g�ϊ�(#,##0).
     *
     * @param num
     *            long�^�̐��l
     * @return [#,##0]�`���̕����� ��null�̏ꍇ��0
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
     * ���l�̃t�H�[�}�b�g�ϊ�(#,##0).
     *
     * @param num
     *            double�^�̐��l
     * @return [#,##0]�`���̕����� ��null�̏ꍇ��0
     */
    public static String formatNum(double num) {
        return formatNum(num, 340);
    }

    /**
     * ���l�̃t�H�[�}�b�g�ϊ�(#,##0).
     *
     * @param num
     *            double�^�̐��l
     * @param digitSize
     *            int�^�̐��l
     * @return [#,##0]�`���̕����� ��null�̏ꍇ��0
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
     * ���l�̃t�H�[�}�b�g�ϊ�(\\#,##0).
     *
     * @param num
     *            int�^�̐��l
     * @return [\\#,##0]�`���̕����� ��null�̏ꍇ��\0
     */
    public static String formatYen(int num) {
        String ret = "";
        ret = "\\" + formatNum(num);
        return ret;
    }

    /**
     * ���l�̃t�H�[�}�b�g�ϊ�(\\#,##0).
     *
     * @param num
     *            long�^�̐��l
     * @return [\\#,##0]�`���̕����� ��null�̏ꍇ��\0
     */
    public static String formatYen(long num) {
        String ret = "";
        ret = "\\" + formatNum(num);
        return ret;
    }

    /**
     * ���l�̃t�H�[�}�b�g�ϊ�(\\#,##0).
     *
     * @param num
     *            double�^�̐��l
     * @return [\\#,##0]�`���̕����� ��null�̏ꍇ��\0
     */
    public static String formatYen(double num) {
        String ret = "";
        ret = "\\" + formatNum(num);
        return ret;
    }

    /**
     * ���l�̃t�H�[�}�b�g�ϊ�(\\#,##0).
     *
     * @param num
     *            double�^�̐��l
     * @param digitPos
     *            int�^�̐��l
     * @return [\\#,##0]�`���̕����� ��null�̏ꍇ��\0
     */
    public static String formatYen(double num, int digitPos) {
        String ret = "";
        ret = "\\" + formatNum(num, digitPos);
        return ret;
    }

    /**
     * �w�肳�ꂽ������𐮐��ɕϊ����ĕԂ��܂�. �����^�ɕϊ��ł��Ȃ������ꍇ�́ANumberFormatException���X���[���܂�.
     *
     * @param value
     *            ������
     * @return �ϊ���������
     * @exception NumberFormatException
     *                ���l�^�ϊ����Ɏ��s�����ꍇ
     */
    public static int toInt(String value) throws NumberFormatException {
        if (value == null || value.length() == 0) {
            throw new NumberFormatException("Invalid Value[" + value + "]");
        }
        return Integer.parseInt(value.trim().replaceAll(",", ""));
    }

    /**
     * �w�肳�ꂽ������𐮐��ɕϊ����ĕԂ��܂�. �G���[�����������ꍇ�A�f�t�H���g�l��Ԃ��܂�.
     *
     * @param value
     *            ������
     * @param defaultValue
     *            �f�t�H���g�l
     * @return �ϊ���������
     */
    public static int toInt(String value, int defaultValue) {
        try {
            return toInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * �w�肳�ꂽ������𕂓������_�^�ɕϊ����ĕԂ��܂�.
     * �P���x���������_�^�ɕϊ��ł��Ȃ������ꍇ�́ANumberFormatException���X���[���܂�.
     *
     * @param value
     *            ������
     * @return �ϊ��������������_�^
     * @exception NumberFormatException
     *                ���l�^�ϊ����Ɏ��s�����ꍇ
     */
    public static float toFloat(String value) throws NumberFormatException {
        if (value == null || value.length() == 0) {
            throw new NumberFormatException("Invalid Value[" + value + "]");
        }
        return Float.parseFloat(value.trim().replaceAll(",", ""));
    }

    /**
     * �w�肳�ꂽ������𕂓������_�^�ɕϊ����ĕԂ��܂�. �G���[�����������ꍇ�A�f�t�H���g�l��Ԃ��܂�.
     *
     * @param value
     *            ������
     * @param defaultValue
     *            �f�t�H���g�l
     * @return �ϊ��������������_�^
     */
    public static float toFloat(String value, float defaultValue) {
        try {
            return toFloat(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * �w�肳�ꂽ������𐮐��ɕϊ����ĕԂ��܂�. �����^�ɕϊ��ł��Ȃ������ꍇ�́ANumberFormatException���X���[���܂�.
     *
     * @param value
     *            ������
     * @return �ϊ���������
     * @exception NumberFormatException
     *                ���l�^�ϊ����Ɏ��s�����ꍇ
     */
    public static long toLong(String value) throws NumberFormatException {
        if (value == null || value.length() == 0) {
            throw new NumberFormatException("Invalid Value[" + value + "]");
        }
        return Long.parseLong(value.trim().replaceAll(",", ""));
    }

    /**
     * �w�肳�ꂽ������𐮐��ɕϊ����ĕԂ��܂�. �G���[�����������ꍇ�A�f�t�H���g�l��Ԃ��܂�.
     *
     * @param value
     *            ������
     * @param defaultValue
     *            �f�t�H���g�l
     * @return �ϊ���������
     */
    public static long toLong(String value, long defaultValue) {
        try {
            return toLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * �l�̌ܓ��֐�. �G���[�����������ꍇ�A�f�t�H���g�l��Ԃ��܂�.
     *
     * @param val
     *            �Ώې��l�i������j
     * @param decimalPoint
     *            �����_�����i������j
     * @param nDefVal
     *            �f�t�H���g�l�i������j
     * @return �ϊ�����������
     */
    public static String round(String val, String decimalPoint,
            String nDefVal) {
        String retValue = "";
        int decCnt = 0;
        // ���̓`�F�b�N
        if (val == null || val.length() == 0 || decimalPoint == null
                || decimalPoint.length() == 0) {
            return nDefVal;
        }
        // �����_�ȉ��������擾
        decCnt = toInt(decimalPoint, 0);
        try {
            // �萔���`
            // BigDecimal BdOne = new BigDecimal(1);

            // �ϊ��Ώۂ̒l���擾
            BigDecimal BdTargetVal = new BigDecimal(val);

            // �l�̌ܓ������s
            BigDecimal DbFormatVal = BdTargetVal.setScale(decCnt,
                    BigDecimal.ROUND_HALF_UP);

            // �l�𕶎���֕ϊ�
            retValue = DbFormatVal.toPlainString();

        } catch (NumberFormatException e) {
            // �G���[�������́A�f�t�H���g�l��ԓ�
            retValue = nDefVal;
        }
        return retValue;
    }

    /**
     * �l�̌ܓ��֐�.
     *
     * @param val
     *            ���͒l double�^�̐��l
     * @param pos
     *            �����_���� int�^�̐��l
     * @return �l�̌ܓ���̒l�i������j
     */
    public static String round(double val, int pos) {
        return roundMain(val, pos, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * �؎̂Ċ֐�.
     *
     * @param val
     *            ���͒l double�^�̐��l
     * @param pos
     *            �����_���� int�^�̐��l
     * @return �؎̂Č�̒l�i������j
     */
    public static String roundDown(double val, int pos) {
        return roundMain(val, pos, BigDecimal.ROUND_DOWN);
    }

    /**
     * �؏グ�֐�.
     *
     * @param val
     *            ���͒l double�^�̐��l
     * @param pos
     *            �����_���� int�^�̐��l
     * @return �؏グ��̒l�i������j
     */
    public static String roundUp(double val, int pos) {
        return roundMain(val, pos, BigDecimal.ROUND_UP);
    }

    /**
     * �ۂߊ֐�.
     *
     * @param val
     *            ���͒l double�^�̐��l
     * @param pos
     *            �����_���� int�^�̐��l
     * @param coef
     *            �ϊ��萔(BigDecimal�萔) int�^�̐��l
     * @return �ϊ���̒l�i������j
     */
    public static String roundMain(double val, int pos, int coef) {

        // �ϊ��Ώۂ̒l���擾
        BigDecimal BdTargetVal = new BigDecimal(val);

        BigDecimal DbFormatVal = BdTargetVal.setScale(pos, coef);

        // �l�𕶎���֕ϊ�
        return DbFormatVal.toPlainString();
    }

    /**
     * ���Z�����]���Ԃ�.
     *
     * @param src
     *            int�^�̐��l
     * @param num
     *            int�^�̐��l
     * @return ���Z�����]��
     */

    public static int Mod(int src, int num) {
        int a = src % num;

        return a;

    }

    /**
     * ���Z�����]���Ԃ�(���������_�^).
     *
     * @param val
     *            float�^�̐��l
     * @param num
     *            int�^�̐��l
     * @param dp
     *            �����_����
     * @return �ϊ��������������_�^
     */
    public static float Mod(float val, int num, int dp) {
        float a = val % num;
        String fmt = ("%." + dp + "f");
        String format = String.format(fmt, a);
        float fl = Float.parseFloat(format);

        return fl;

    }

    // // ���肷�錅���͈�P�^����
    // pos++;
    // // ���茅�ɑ����l���v�Z
    // double plus = coef * Math.pow( 10, -pos );
    // if (plus<val) {
    // val += plus;
    // }
    // // �t�H�[�}�b�g�̏���
    // // �����̏ꍇ���肷�錅���܂Ŋ܂߂�
    // DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance();
    // StringBuffer fmt = new StringBuffer("0.");
    // for (int i=0; i<(pos+1); i++) {
    // fmt.append("0");
    // }
    // df.applyPattern(fmt.toString());
    // String dfval = df.format(val);
    // String rval = "";
    // if (0<pos) {
    // // �����̏ꍇ�͗]�v�Ȍ����폜����
    // rval = dfval.substring(0, dfval.length()-2);
    // } else {
    // // �����̏ꍇ���茅���ȍ~��"0"�Ŗ��߂�
    // int max = dfval.indexOf(".");
    // if (max<0) {
    // max = dfval.length();
    // }
    // if (((-pos)+1)<max) {
    // // "0"���߂��K�v�ȏꍇ
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
    // // "0"���ߕK�v�Ȃ�
    // rval = dfval;
    // }
    // }
    // // ������̍Ōオ"."�ŏI���Ƃ���"."���폜����
    // return ".".equals(rval.substring(rval.length()-1, rval.length())) ?
    // rval.substring(0, rval.length()-1) : rval;
}

/*
 * public static void main(String[] args) throws Exception { // TEST ���W���[�� int
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
