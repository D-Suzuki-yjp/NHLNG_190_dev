package job.common.nhlngCommon.function.outPutLogs;

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
	 *
	 * @param String cat カテゴリ
	 * @param String logId ID
	 * @param String[] param パラメータ
	 */
	public static void outPutLogs(String cat, String logId, String[] param) {

	MsMessage msmsg = null;
	// MsLog4j.propertiesに定義したカテゴリでMsMessageインスタンス
	/** TODO カテゴリを追加、カテゴリ名の定数プロパティ化 */
	 switch(cat){
	 case "COM" : msmsg = new MsMessage("CMN");
	 case "SCR" : msmsg = new MsMessage("SCR");
	 }
	String msg = "ms"; // ※未使用のパラメータだが空文字、Null以外を指定

	//GRANDSIGHT_EX_MS.API
	msmsg.messageOut(logId, msg, param); // MsMessage.messageOut(メッセージ番号,
												// 任意の文字列, メッセージ用パラメータ)
												// でlog出力を実行
	}

}
