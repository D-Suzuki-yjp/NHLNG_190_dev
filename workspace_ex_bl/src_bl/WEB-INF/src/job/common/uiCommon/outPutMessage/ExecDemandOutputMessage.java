package job.common.uiCommon.outPutMessage;

import java.util.ArrayList;
import java.util.List;

import com.yse.gb.gf.front.LogWriter;
import com.yse.gb.sf.frame.demand.client.RequestForServer;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * ExecDemandOutputMessage メッセージ出力デマンドアプリケーション呼出クラス(UI)
 * @author D.Suzuki
 */
public class ExecDemandOutputMessage {

	/**
	 * メッセージ出力デマンドアプリケーション呼出
	 * @param MsgId  メッセージID
	 * @param msgCat  メッセージカテゴリ
	 * @param msgParams  埋込パラメータ
	 * @return
	 */
	public static void execDemandOutputMessageMain(String MsgId, String msgCat,String msgParams) throws Throwable{
        // リクエストクラスのインスタンス生成
        RequestForServer rfs = new RequestForServer();

        // タスクID
        String taskId = "OUTPUTMESSAGE";

        // パラメータの作成
        List<String> paramList = new ArrayList<String>();
        // メッセージID
        paramList.add(MsgId);
        // メッセージカテゴリ
        paramList.add(msgCat);
        // 埋込パラメータ
        paramList.add(msgParams);

        // 処理待ちフラグの作成（true or false）
        boolean bWait = false;

        try {
            LogWriter.putDebug("リクエスト処理前");

            // SFデマンド起動依頼(同一マシン上の場合)
            Object obj = rfs.request(taskId, paramList, bWait);

            LogWriter.putDebug("リクエスト処理実施完了");
            LogWriter.putDebug("リクエスト処理実施結果=[" + obj + "]");
        } catch (Throwable e) {
            System.out.println("★リクエスト処理失敗：" + e.toString());
            throw e;
        }

	}

}
