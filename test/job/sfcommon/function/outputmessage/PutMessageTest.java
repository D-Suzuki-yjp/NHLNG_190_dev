package job.sfcommon.function.outputmessage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PutMessageTest {

	@Test
	public void PutMessageTest() {
		PutMessage putMessage = new PutMessage();

		List arg0 = new ArrayList();
		arg0.add("F01-I02");
		arg0.add(0);
		String msgParams = "A";
		arg0.add(msgParams);
		try {
			putMessage.execute(arg0);
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			/** TODO 例外処理 */
			e.printStackTrace();
		}
	}

//	@Test
//	public void PutMessageTest1() {
//		ExecDemandOutputMessage execDemandOutputMessage = new ExecDemandOutputMessage();
//
//		String msgParams = "SCC_A";
//
//		try {
//			execDemandOutputMessage.execDemandOutputMessageMain("A01-O01", msgParams);
//		} catch (Throwable e) {
//			// TODO 自動生成された catch ブロック
//			/** TODO 例外処理 */
//			e.printStackTrace();
//		}
//	}

}
