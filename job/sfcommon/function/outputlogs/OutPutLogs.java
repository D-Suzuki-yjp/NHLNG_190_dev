package job.sfcommon.function.outputlogs;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/24 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * OutPutLogs ログ出力クラス
 * @author D.Suzuki
 */

import javax.enterprise.context.RequestScoped;

import com.yse.gb.ms.MsMessage;

/** ログ出力クラス */
@RequestScoped
public class OutPutLogs {
	/** コンストラクタ */
	private OutPutLogs() {
	};

	/**
	 * ログ出力共通関数
	 *
	 * @param cat
	 *            カテゴリ
	 * @param logId
	 *            ID
	 * @param param
	 *            パラメータ
	 */
	public static void outPutLogs(final String cat, final String logId, final String[] param) {

		// MsLog4j.propertiesに定義したカテゴリでMsMessageインスタンス
		MsMessage msmsg = new MsMessage(cat);
		String msg = "ms"; // ※未使用のパラメータだが空文字、Null以外を指定

		// GRANDSIGHT_EX_MS.API
		msmsg.messageOut(logId, msg, param); // MsMessage.messageOut(メッセージ番号,
												// 任意の文字列, メッセージ用パラメータ)
												// でlog出力を実行
	}

	/**
	 * スタックトレースログ出力共通関数
	 *
	 * @param cat
	 *            カテゴリ
	 * @param logId
	 *            ID
	 * @param param
	 *            パラメータ
	 * @param e
	 *            Throwable
	 */
	public static void outPutLogs(final String cat, final String logId, final String[] param, final Throwable e) {

		// MsLog4j.propertiesに定義したカテゴリでMsMessageインスタンス
		MsMessage msmsg = new MsMessage(cat);
		String msg = "ms"; // ※未使用のパラメータだが空文字、Null以外を指定

		// GRANDSIGHT_EX_MS.API
		msmsg.messageOut(logId, msg, param); // MsMessage.messageOut(メッセージ番号,
												// 任意の文字列, メッセージ用パラメータ)
												// でlog出力を実行
		String[] stParam = { e.getStackTrace().toString() };
		msmsg.messageOut("0003", msg, stParam);
	}
}
