package job.exception;

import com.yse.gb.gf.front.MsgHandleBean;
import com.yse.gb.gf.front.UserMessage;
import com.yse.gb.gf.front.exception.ExceptionHandler;
/**
 * IllegalStateExceptionのハンドラークラス(JBoss版用)
 * <!-- TYPE DESCRIPTION --><PRE>
 *
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2002/03/01 61000251/Masashi.Okubo    初版
 * R0.03.01 2002/12/04 61000251/Masashi.Okubo    総合テスト完了
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 * </PRE>
 * @author 61000251/Masashi.Okubo
 */
public class IllegalStateException_Handler implements ExceptionHandler {
/**
 * <METHOD INFOMATION><PRE>
 * SQLException例外キャッチ時の処理
 * </PRE>
 * 
 * @return    メッセージBean
 * @param     e 例外インスタンス
 */
public MsgHandleBean execute(Throwable e){
	MsgHandleBean msgBean = new MsgHandleBean(new UserMessage("セッションが無効になりました。"));
	msgBean.setErrorPage("/_SessionErrorPage.html") ;
	
	return msgBean ;
}
}
