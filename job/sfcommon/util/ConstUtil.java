package job.sfcommon.util;

/**
 * 定数保持用クラス.
 *
 * @author kumagai.
 *
 */
public class ConstUtil {

	/** コンストラクタ. */
	private ConstUtil() {
	}

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
	/** 時間単位 */
	/**
	 * comment
	 *
	 */
	public static enum DATETIME_UNIT {
		/** 分. */
		MINUTE("MINUTE"),
		/** 時. */
		HOUR("HOUR"),
		/** 日. */
		DAY("DAY"),
		/** 月. */
		MONTH("MONTH"),
		/** 年. */
		YEAR("YEAR");
		/** name */
		private final String datetimeUnit;
		/** コンストラクタ
		 * @param datetimeUnit 時間単位
		 *  */
		private DATETIME_UNIT(final String datetimeUnit) {
			this.datetimeUnit = datetimeUnit;
		}
		/** getter
		 *  @return datetimeUnit 時間単位
		 *  */
		public String getDatetimeUnit() {
			return this.datetimeUnit;
		}
	}

	/** 分. */
	public static final String MINUTE = "MINUTE";
	/** 時. */
	public static final String HOUR = "HOUR";
	/** 日. */
	public static final String DAY = "DAY";
	/** 月. */
	public static final String MONTH = "MONTH";
	/** 年. */
	public static final String YEAR = "YEAR";

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
		 *
		 * @param value
		 *            値
		 */
		FLAG(String value) {
			this.value = value;
		}

		/**
		 * 値の取得.
		 *
		 * @return 値
		 */
		public String getValue() {
			return this.value;
		}
	}

	/***********************************************/
	/**                   DB                       */
	/***********************************************/

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

	/** 品質コード192 */
	public static final int QUALITY_CODE_GOOD = 192;

	/** CAL有効状態 */
	public static final int CAL_ON = 1;

	/** CAL無効状態 */
	public static final int CAL_OFF = 0;

	/** 帳票区分 */
	public static enum REPO_DIV {
		/** 帳票外 */
		NON("N"),
		/** L管 */
		LNG("L"),
		/** 生管 */
		SEISAN("S"),
		/** 電力 */
		ELECTRICITY("E");
		/** name */
		private final String repoDiv;
		/** コンストラクタ
		 * @param repoDiv 帳票区分 */
		private REPO_DIV(final String repoDiv) {
			this.repoDiv = repoDiv;
		}
		/** getter
		 *  @return repoDiv 帳票区分 */
		public String getRepoDiv() {
			return this.repoDiv;
		}
	}

	/** 帳票計算区分 */
	public static enum REPO_CALC_DIV {
		/** 帳票外 */
		NON("N"),
		/** 手動インプット */
		MANUAL("M"),
		/** 計算元 */
		SOURCE("S"),
		/** 計算結果 */
		OUTCOME("O");
		/** name */
		private final String repoCalcDiv;
		/** コンストラクタ
		 *  @param repoCalcDiv 帳票計算区分*/
		private REPO_CALC_DIV(final String repoCalcDiv) {
			this.repoCalcDiv = repoCalcDiv;
		}
		/** getter
		 * @return repoCalcDiv 帳票計算区分*/
		public String getRepoCalcDiv() {
			return this.repoCalcDiv;
		}
	}

	/** 締切種別 */
	public static enum CLOSE_KIND {
		/** 瞬時 */
		CURRENT(0),
		/** 積算 */
		SUM(1),
		/** 平均 */
		AVG(2),
		/** 最大 */
		MAX(3),
		/** 最小 */
		MIN(4);
		/** name */
		private final int closeKind;
		/** コンストラクタ
		 *  @param closeKind 締切種別*/
		private CLOSE_KIND(final int closeKind) {
			this.closeKind = closeKind;
		}
		/** getter
		 *  @return closeKind 締切種別*/
		public int getCloseKind() {
			return this.closeKind;
		}
	}
	/***********************************************/
	/** マシン設定情報 */
	/***********************************************/

	/** SCC_A */
	public static final String SCC_A = "SCC_A";

	/** SCC_A */
	public static final String SCC_B = "SCC_B";

	/** ホスト名 */
	public static enum HOST_NAME {
		/** DDC用OPC_A1 */
		OPCA1("STN0123"),
		/** DDC用OPC_B1 */
		OPCB1("STN0124"),
		/** SCC-I/O用OPC_A2*/
		OPCA2("OPC-A2"),
		/** SCC-I/O用OPC_B2 */
		OPCB2("OPC-B2");
		/** name */
		private final String hostName;
		/** コンストラクタ
		 * @param hostName ホスト名*/
		private HOST_NAME(final String hostName) {
			this.hostName = hostName;
		}
		/** getter
		 * @return hostName ホスト名*/
		public String getHostName() {
			return this.hostName;
		}
	}
	/***********************************************/
	/** LoopOnEX */
	/***********************************************/

	/** サブシステムID DDC用OPC_A1 */
	public static final String SUBSYSTEM_ID_DDCOPC = "STN0123";

	/** サブシステムID 	SCC-I/O用OPC_A2 */
	public static final String SUBSYSTEM_ID_SCCIOA2 = "	FCN-OPC-A";

	/** サブシステムID SCC-I/O用OPC_B2 */
	public static final String SUBSYSTEM_ID_SCCIOB2 = "	FCN-OPC-B";

	/** サブシステムID 	SCC用PLC_1 */
	public static final String SUBSYSTEM_ID_PLC1 = "TLS";

	/** サブシステムID SCC用PLC_2 */
	public static final String SUBSYSTEM_ID_PLC2 = "LGS";

	/** 収集グループNo */
	public static enum CLLGROUP_NO {
		/** DDC用OPC_A1(1) */
		STN0123(1),
		/** SCC-I/O用OPC_A2(2) */
		FCNOPCA(2),
		/** SCC-I/O用OPC_B2(3) */
		FCNOPCB(3),
		/** SCC用PLC_1(4) */
		TLS(4),
		/** SCC用PLC_2(5) */
		LGS(5);
		/** name */
		private final int cllGroupNo;
		/** コンストラクタ
		 * @param cllGroupNo 収集グループNo*/
		private CLLGROUP_NO(final int cllGroupNo) {
			this.cllGroupNo = cllGroupNo;
		}

		/** getter
		 * @return cllGroupNo 収集グループNo*/
		public int getCllGroupNo() {
			return this.cllGroupNo;
		}
	}

	/** API実行結果:成功 */
	public static final int LOEX_API_SUCCESS = 0;

	/** API実行結果:失敗 */
	public static final int LOEX_API_FAILURE = -1;

	/** API実行結果:該当lcodeなし */
	public static final int LOEX_API_NOFOUND = -2;

	/** API実行結果:例外 */
	public static final int LOEX_API_EXCEPTION = -9;

	/***********************************************/
	/** ステータス */
	/***********************************************/

	/** 主従状態:主系 */
	public static final int MASTER_STAT_MAIN = 1;

	/** 主従状態:従系 */
	public static final int MASTER_STAT_SUB = 0;

	/***********************************************/
	/** コマンド */
	/***********************************************/

	/** バッチ起動用 */
	public static final String BAT_COMMAND_CMD = "cmd";

	/** バッチ起動オプション */
	public static final String BAT_OPTION_C = "/c";

	/***********************************************/
	/** 計算処理 */
	/***********************************************/
	/** 計算処理 計算種別 */
	public static final String CALC_KIND_CALC = "calc";

	/** 計算処理 計算種別 */
	public static final String CALC_KIND_USER = "user";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_ADD = "add";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_SUB = "sub";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_MUL = "mul";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_DIV = "div";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_SET = "set";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_SUM = "sum";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_AVG = "avg";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_MAX = "max";

	/** 計算処理 計算情報 */
	public static final String CALC_INFO_MIN = "min";

	/***********************************************/
	/** ログ出力 */
	/***********************************************/

	/** ログカテゴリ 共通処理 */
	public static final String LOG_COMMON = "logcat0.comn";

	/** ログカテゴリA.冗長化 */
	public static final String LOG_CAT_A = "logcat1.rmeq";

	/** ログカテゴリB.データ処理 */
	public static final String LOG_CAT_B = "logcat2.dprc";

	/** ログカテゴリC.データ管理 */
	public static final String LOG_CAT_C = "logcat2.calc";

	/** ログカテゴリD.帳票作成 */
	public static final String LOG_CAT_D = "logcat3.repo";

	/** ログカテゴリE.通信 */
	public static final String LOG_CAT_E = "logcat2.comm";

	/** ログカテゴリF.システム管理 */
	public static final String LOG_CAT_F = "logcat4.sysm";
}
