package job.sfcommon.function.outputlogs;

import javax.enterprise.context.RequestScoped;

import com.yse.gb.ms.MsMessage;

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
@RequestScoped
public class OutPutLogs {

	/**
	 * ログ出力共通関数
	 * @param String cat カテゴリ
	 * @param String logId ID
	 * @param String[] param パラメータ
	 */
	public static void outPutLogs(final String cat ,final String logId,final String[] param) {

	// MsLog4j.propertiesに定義したカテゴリでMsMessageインスタンス
	MsMessage msmsg = new MsMessage(cat);
	String msg = "ms"; // ※未使用のパラメータだが空文字、Null以外を指定

	//GRANDSIGHT_EX_MS.API
	msmsg.messageOut(logId, msg, param); // MsMessage.messageOut(メッセージ番号,
												// 任意の文字列, メッセージ用パラメータ)
												// でlog出力を実行
	}

	/**
	 * スタックトレースログ出力共通関数
	 * @param String cat カテゴリ
	 * @param String logId ID
	 * @param String[] param パラメータ
	 * @param Throwable e
	 */
	public static void outPutLogs(final String cat, final String logId, final String[] param, final Throwable e) {

	// MsLog4j.propertiesに定義したカテゴリでMsMessageインスタンス
	MsMessage msmsg = new MsMessage(cat);
	String msg = "ms"; // ※未使用のパラメータだが空文字、Null以外を指定

	//GRANDSIGHT_EX_MS.API
	msmsg.messageOut(logId, msg, param); // MsMessage.messageOut(メッセージ番号,
												// 任意の文字列, メッセージ用パラメータ)
												// でlog出力を実行
	String[] StParam = {e.getStackTrace().toString()};
	msmsg.messageOut("0003", msg, StParam);
	}
}
