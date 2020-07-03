package job.sfcommon.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import job.sfcommon.util.NumUtil;

public class NumUtilTest {

	@Test
	public void roundOnStringTest0() {

		// 実行
		String result = NumUtil.roundOnString("22.215555",2,0);

		assertEquals("22.22", result);
	}

	@Test
	public void roundOnStringTest1() {

		// 実行
		String result1 = NumUtil.roundOnString("444.45555",2,1);

		assertEquals("444.46", result1);

		// 実行
		String result2 = NumUtil.roundOnString("444.44555",2,1);

		assertEquals("444.45", result2);
	}

	@Test
	public void roundOnStringTest2() {

		// 実行
		String result = NumUtil.roundOnString("22225",2,2);

		assertEquals("222.25", result);
	}

	@Test
	public void roundOnNumericTest0() {

		// 実行
		BigDecimal result = NumUtil.roundOnNumeric(BigDecimal.valueOf(22.215555),2,0);

		assertEquals(BigDecimal.valueOf(22.22), result);
	}

	@Test
	public void roundOnNumericTest1() {

		// 実行
		BigDecimal result1 = NumUtil.roundOnNumeric(BigDecimal.valueOf(444.45555),2,1);

		assertEquals(BigDecimal.valueOf(444.46), result1);

		// 実行
		BigDecimal result2 = NumUtil.roundOnNumeric(BigDecimal.valueOf(444.44555),2,1);

		assertEquals(BigDecimal.valueOf(444.45), result2);
	}

	@Test
	public void roundOnNumericTest2() {

		// 実行
		BigDecimal result = NumUtil.roundOnNumeric(BigDecimal.valueOf(22225),2,2);

		assertEquals(BigDecimal.valueOf(222.25), result);
	}
}
