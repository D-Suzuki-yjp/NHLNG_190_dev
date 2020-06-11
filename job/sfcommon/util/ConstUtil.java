package job.sfcommon.util;

/**
 * 定数保持用クラス.
 *
 * @author kumagai.
 *
 */
public class ConstUtil {

	/** コンストラクタ. */
	private ConstUtil() {}

	/** デフォルト文字コード. */
	public static final String DEFAULT_ENCODE = "Shift_JIS";
    /** キャラクタセット(UTF-8). */
    public static final String CHARSET_UTF8 = "UTF-8";
    /** キャラクタセット(Shift-JIS). */
    public static final String CHARSET_SJIS = "Shift_JIS";
    /** キャラクタセット(MS932). */
    public static final String CHARSET_MS932 = "MS932";
    /** キャラクタセット(Windows-31J). */
    public static final String CHARSET_WIN31J = "Windows-31J";

    /** パスセパレータ. */
    public static final String PATH_SEPARATOR = "/";
    /** 改行. */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /** ファイルエンコード. */
    public static final String FILE_ENCODING = System.getProperty("file.encoding");
    /** タブ. */
    public static final String TAB = "\t";

    /** フラグ状態. */
    public static enum FLAG {
        /** OFF. */
        OFF("0"),
        /** ON. */
        ON("1");

        /** 値. */
        private String value;

        /**
         * コンストラクタ.
         * @param value 値
         */
        FLAG(String value) {
            this.value = value;
        }

        /**
         * 値の取得.
         * @return 値
         */
        public String getValue() {
            return this.value;
        }
    }

	/**
	 * COREDB
	 */
	public static final String LOOPONEX_CORE = "looponex_core";

	/**
	 * JOBDB
	 */
	public static final String NHLNG = "nhlng";

    /** NHタグマスタが持つタグ論理名の数 */
    public static final int TAGLOGICNAME_ARRAY = 4;

	/** ファイルが存在しません。 */
	public static final String E00001 = "E00001";
	/** ファイル読み書き失敗。 */
	public static final String E00002 = "E00002";

	/***********************************************/
	/**                 計算処理                                                   */
	/***********************************************/
	/** 計算処理 計算種別*/
	public static final String CALC_KIND_CALC = "calc";

	/** 計算処理 計算種別*/
	public static final String CALC_KIND_USER = "user";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_ADD = "add";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_SUB = "sub";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_MUL = "mul";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_DIV = "div";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_SET = "set";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_SUM = "sum";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_AVG = "avg";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_MAX = "max";

	/** 計算処理 計算情報*/
	public static final String CALC_INFO_MIN = "min";

	/***********************************************/
	/**                 ログ出力                                                      */
	/***********************************************/

	/** ログカテゴリ 共通処理*/
	public static final String LOG_COMMON = "logcat0.comn";

	/** ログカテゴリA.冗長化*/
	public static final String LOG_CAT_A = "logcat1.rmeq";

	/** ログカテゴリB.データ処理*/
	public static final String LOG_CAT_B = "logcat2.dprc";

	/** ログカテゴリC.データ管理*/
	public static final String LOG_CAT_C = "logcat2.calc";

	/** ログカテゴリD.帳票作成*/
	public static final String LOG_CAT_D = "logcat3.repo";

	/** ログカテゴリE.通信*/
	public static final String LOG_CAT_E = "logcat2.comm";

	/** ログカテゴリF.システム管理*/
	public static final String LOG_CAT_F = "logcat4.sysm";
}
