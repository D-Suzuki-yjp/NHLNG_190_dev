package job.exception;

// import java.io.PrintWriter;
import java.io.IOException;

import com.yse.gb.gf.front.MsgHandleBean;
import com.yse.gb.gf.front.UserMessage;
import com.yse.gb.gf.front.exception.ExceptionFileWriter;
import com.yse.gb.gf.front.exception.ExceptionHandler;
// import com.yse.gb.gf.com.io.CreateFileInfo;
/**
 * Throwableのハンドラークラス
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
public class Throwable_Handler implements ExceptionHandler {
/**
 * <METHOD INFOMATION><PRE>
 * Throwable例外キャッチ時の処理
 * </PRE>
 *
 * @return    メッセージBean
 * @param     e 例外インスタンス
 */
public MsgHandleBean execute(Throwable e){

	String text  = ""  ;
	String color = ""  ;
	String link  = ""  ;

	//エラー標準出力
	java.io.PrintStream printStream = System.out;
	e.printStackTrace(printStream);

	//エラーメッセージセット
	text = e.toString();

	//エラー詳細ファイル作成
	try{
		String fileUrl = ExceptionFileWriter.execute(e);
		link = fileUrl ;
	}catch(IOException exp){
		exp.printStackTrace(printStream);
	}

	MsgHandleBean msgBean = new MsgHandleBean(new UserMessage(text,color,link));

	return msgBean ;
}
}
