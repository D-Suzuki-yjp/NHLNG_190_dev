package job.sfcommon.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

/**
 * ProcessUtilのテストクラス.
 *
 * @author kumagai
 *
 */
public class ProcessUtilTest {

	/**
	 * execProgram(String stdout, String... args)
	 * のテスト
	 */
	@Test
	public void testExecProgramStringString() {
		String curPath = FileUtil.getCurrentPath().replaceFirst("/", "").replace('/', '\\').replace("%20", " ");
		String[] exePath = {"cmd", "/c", curPath + "..\\junit\\script\\TestHello.bat"};
		StringBuffer outText = new StringBuffer();
		try {
			int r = ProcessUtil.execProgram(outText, exePath);
			assertEquals(0, r);
			assertEquals("Hello", outText.toString().trim());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * execProgram(Writer out, String... args)
	 * のテスト
	 */
	@Test
	public void testExecProgramWriterString() {
		String curPath = FileUtil.getCurrentPath().replaceFirst("/", "").replace('/', '\\').replace("%20", " ");
		String[] exePath = {"cmd", "/c", curPath + "..\\junit\\script\\TestExe.bat"};
		Writer writer = new StringWriter();
		try {
			int r = ProcessUtil.execProgram(writer, exePath);
			assertEquals(0, r);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					fail();
				}
			}
		}
	}

	/**
	 * execProgram(String... args)
	 * のテスト
	 */
	@Test
	public void testExecProgramString() {
		String curPath = FileUtil.getCurrentPath().replaceFirst("/", "").replace('/', '\\').replace("%20", " ");
		String[] exePath = {"cmd", "/c", curPath + "..\\junit\\script\\TestExe.bat"};
		try {
			int r = ProcessUtil.execProgram(exePath);
			assertEquals(0, r);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
