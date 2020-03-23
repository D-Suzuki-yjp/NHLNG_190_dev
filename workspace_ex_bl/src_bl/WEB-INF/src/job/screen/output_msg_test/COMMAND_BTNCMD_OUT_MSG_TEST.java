package job.screen.output_msg_test;

import javax.enterprise.context.RequestScoped;

import com.yse.gb.gf.front.CommandException;
import com.yse.gb.gf.front.CommandHelper;
import com.yse.gb.gf.front.InputException;
import com.yse.gb.gf.front.KeyObj;

import job.common.uiCommon.outPutMessage.ExecDemandOutputMessage;


/**
 * ボタン処理クラス。<br>
 * <!-- TYPE DESCRIPTION -->
 *
 * <pre>
 * </pre>
 */
/*
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 YYYY/MM/DD 00000000/XXXX.XXXXXXXX    初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 */
@RequestScoped
public class COMMAND_BTNCMD_OUT_MSG_TEST extends com.yse.gb.gf.bld.front.BLDCommandImpl {
	/**
	 * ボタン処理実行。<br>
	 * 本処理は{@link #getNextScreenId(CommandHelper, KeyObj)}の終了後に呼び出されます。<br>
	 * <!-- METHOD DESCRIPTION -->
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param helper
	 *            コマンドヘルパー
	 * @param nextScreenId
	 *            展開先画面ID
	 * @param keyObj
	 *            展開先画面へ渡す情報の格納用
	 */
	@Override
	protected void perform(final CommandHelper helper, final String nextScreenId, final KeyObj keyObj)
			throws InputException, CommandException, Throwable {

		String MsgId = "";
		String msgCat = "";
		String msgParams = "";

		MsgId = helper.getParam("NMLDLD_MSGID_INPUT");
		msgCat = helper.getParam("NMLDLD_MSGCAT_INPUT");
		msgParams = helper.getParam("NMLTXT_PRM_INPUT");

		ExecDemandOutputMessage.execDemandOutputMessageMain(MsgId, msgCat, msgParams);

		/**
        // リクエストクラスのインスタンス生成
        RequestForServer rfs = new RequestForServer();

        // タスクID
        String taskId = "REQTEST";

        // パラメータの作成
        List<String> paramList = new ArrayList<String>();
        paramList.add("everyone!");

        // 処理待ちフラグの作成（true or false）
        boolean bWait = false;

        // SFホスト名
        String hostName = "localhost";

        // SF-Demand受付ポート
        int port = 51134;

        try {
            LogWriter.putDebug("リクエスト処理前");

            // SFデマンド起動依頼(同一マシン上の場合)
            Object obj = rfs.request(taskId, paramList, bWait);

            // SFデマンド起動依頼(別マシン上の場合)
            //Object obj = rfs.request(hostName, port, taskId, paramList, bWait);

            LogWriter.putDebug("リクエスト処理実施完了");
            LogWriter.putDebug("リクエスト処理実施結果=[" + obj + "]");

            // 画面出力メッセージ設定
            helper.setMsgHandleBean(new MsgHandleBean(new UserMessage("SF起動リクエストが正常に行われました")));
        } catch (Throwable e) {
            System.out.println("★リクエスト処理失敗：" + e.toString());
            throw e;
        }**/
	}
}
