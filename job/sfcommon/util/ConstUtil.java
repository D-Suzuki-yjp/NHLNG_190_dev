package job.sfcommon.util;

import javax.enterprise.context.ApplicationScoped;

/**
 * 定数保持用クラス.
 *
 * @author kumagai.
 *
 */
@ApplicationScoped
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

    /** NHタグマスタが持つタグ論理名の数 */
    public static final int TAGLOGICNAME_ARRAY = 4;

	/** ファイルが存在しません。 */
	public static final String E00001 = "E00001";
	/** ファイル読み書き失敗。 */
	public static final String E00002 = "E00002";

}
