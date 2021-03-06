package job.demand.client;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * ExecDemandOutputMessage 条件付きメッセージ出力デマンドアプリケーション呼出クラス(SF)
 * @author D.Suzuki
 */

import java.util.ArrayList;
import java.util.List;

import com.yse.gb.sf.frame.demand.client.RequestForServer;

import job.sfcommon.function.outputlogs.OutPutLogs;
import job.sfcommon.util.ConstUtil;

/**
 * 条件付きメッセージ出力デマンドアプリケーション呼出クラス(SF)
 * @author D.Suzuki
 */
public class ExecDemandOutputMsgConditional {
	/**
	 * コンストラクタ
	 */
	private ExecDemandOutputMsgConditional(){
	};

	/**
	 * logMsg
	 */
	private static final  String LOG_MSG = "メッセージ出力SFリクエスト";

	/**
	 * 条件付きメッセージ出力デマンドアプリケーション呼出
	 * @param msgId  メッセージID
	 * @param msgParams  埋込パラメータ
	 * @throws Throwable Throwable
	 */
	public static void execDemandOutputMessageMain(final String msgId, final String msgParams) throws Throwable{
        // リクエストクラスのインスタンス生成
        RequestForServer rfs = new RequestForServer();

        // タスクID
        final String taskId = "OUTPUTMESSAGE";

        // パラメータの作成
        List<String> paramList = new ArrayList<String>();
        // メッセージID
        paramList.add(msgId);
        // 条件付きフラグ
        paramList.add("1");
        // 埋込パラメータ
        paramList.add(msgParams);

        // 処理待ちフラグの作成（true or false）
        boolean bWait = false;

        try {
        	String[] pram = {LOG_MSG + "開始"};
			OutPutLogs.outPutLogs(ConstUtil.LOG_COMMON, "0002", pram);

            // SFデマンド起動依頼(同一マシン上の場合)
            Object obj = rfs.request(taskId, paramList, bWait);

        	pram[0] = LOG_MSG + "処理実施完了";
			OutPutLogs.outPutLogs(ConstUtil.LOG_COMMON, "0002", pram);

        	pram[0] = LOG_MSG + "処理実施結果=[" + obj + "]";
			OutPutLogs.outPutLogs(ConstUtil.LOG_COMMON, "0002", pram);
        } catch (Throwable e) {
        	String[] pram = {LOG_MSG + "処理失敗：" + e.toString()};
			OutPutLogs.outPutLogs(ConstUtil.LOG_COMMON, "0002", pram);
            throw e;
        }
	}

}
