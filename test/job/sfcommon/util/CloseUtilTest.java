package job.sfcommon.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDay;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseHour;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMon;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.dto.CmtCloseDayDto;
import job.sfcommon.util.CloseUtil;
import job.sfcommon.util.ConstUtil;
import job.sfcommon.util.DateUtil;

public class CloseUtilTest {

	private static final String DB = ConstUtil.NHLNG;

	@Test
	/** 時締データ読込1 */
	public void nhHourCloseReadTest1() throws ParseException {
		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String from = "2020-05-29 09:00:00";
		Date fromDate = sdf.parse(from);

		String to = "2020-06-01 15:00:00";
		Date toDate = sdf.parse(to);
		SqlSession session = SelectDb.dbAcssece(DB);
		Map<Date, List<CmtCloseHour>> resurts = CloseUtil.nhHourCloseRead(session, fromDate, toDate);
		session.close();
		System.out.println(resurts);
	}

	@Test
	/** 時締データ読込2 */
	public void nhHourCloseReadTest2() throws ParseException {
		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date fromDate = null;

		String to = "2020-05-11 15:00:00";
		Date toDate = sdf.parse(to);
		SqlSession session = SelectDb.dbAcssece(DB);
		Map<Date, List<CmtCloseHour>> resurts = CloseUtil.nhHourCloseRead(session, fromDate, toDate);
		session.close();
		System.out.println(resurts);

	}

	/** 時締データ読込3 */
	@Test
	public void nhHourCloseReadTest3() throws ParseException {
		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String from = "2020-05-11 09:00:00";
		Date fromDate = sdf.parse(from);

		Date toDate = null;
		SqlSession session = SelectDb.dbAcssece(DB);
		Map<Date, List<CmtCloseHour>> resurts = CloseUtil.nhHourCloseRead(session, fromDate, toDate);
		session.close();
		System.out.println(resurts);
	}

	@Test
	/** 時締めデータ書込1 */
	public void nhHourCloseWriteTest1() throws ParseException {

		List<String> tagNoList = new ArrayList();
		tagNoList.add("EV6AR1");
		tagNoList.add("EW6AR1");
		tagNoList.add("EPF6AR1");
		tagNoList.add("EV6BR1");
		tagNoList.add("EW6BR1");
		tagNoList.add("EPF6BR1");
		tagNoList.add("EW6R1");
		tagNoList.add("EPF6R1");
		tagNoList.add("EWEG1");
		tagNoList.add("EWTTL1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-05-27 00:00:00";
		Date date = DateUtil.moldYYYYMMDDHH(sdf.parse(datef));

		int count = 0;
		List<CmtCloseHour> expected = new ArrayList();
		for (String tagNo : tagNoList) {

			count++;

			CmtCloseHour cmtCloseHour = new CmtCloseHour();
			cmtCloseHour.setTagNo(tagNo);
			cmtCloseHour.setCloseDtime((DateUtil.calcDateTime(date, "HOUR", +(count - 1))));
			cmtCloseHour.setTagData("999");
			cmtCloseHour.setQltyCd(198);
			cmtCloseHour.setCollDtime(date);
			cmtCloseHour.setLastUpdUser("TEST");
			expected.add(cmtCloseHour);
		}
		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.nhHourCloseWrite(session, expected));
		session.commit();
		session.close();
	}

	@Test
	/** 時締めデータ書込2 */
	public void nhHourCloseWriteTest2() throws ParseException {

		List<String> tagNoList = new ArrayList();
		// tagNoList.add("TL111-");
		tagNoList.add("TD111-");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-05-31 23:00:00";
		Date date = DateUtil.moldYYYYMMDDHH(sdf.parse(datef));

		int loopCount = 5;
		List<CmtCloseHour> expected = new ArrayList();
		for (String tagNo : tagNoList) {
			for (int i = 1; i <= loopCount; i++) {
				CmtCloseHour cmtCloseHour = new CmtCloseHour();
				cmtCloseHour.setTagNo(tagNo + i);
				cmtCloseHour.setCloseDtime(date);
				cmtCloseHour.setTagData(Integer.toString(6 - i));
				cmtCloseHour.setLastUpdUser("CALCTEST");
				expected.add(cmtCloseHour);
			}
		}
		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.nhHourCloseWrite(session, expected));
		session.commit();
		session.close();
	}

	@Test
	/** 日締データ読込論理名 */
	public void nhDayCloseReadByLogicalNameTest() throws ParseException {
		List<String[]> tagNoList = new ArrayList();
		String[] array = new String[4];
		array[0] = "ZERO_VAL";
		array[1] = null;
		array[2] = null;
		array[3] = null;
		tagNoList.add(array);

		SqlSession session = SelectDb.dbAcssece(DB);
		Map<String[], List<CmtCloseDay>> resurts = CloseUtil.nhDayCloseReadByLogicalName(session, tagNoList);
		session.close();
		System.out.println(resurts);
	}

	@Test
	/** 日締めデータ書込み1 */
	public void nhDayCloseWriteTest1() throws ParseException {

		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-05-26 09:00:00";
		Date date = DateUtil.moldYYYYMMDD(sdf.parse(datef));

		int count = 0;
		List<CmtCloseDay> expected = new ArrayList();
		for (String tagNo : tagNoList) {

			count++;

			CmtCloseDay cmtCloseDay = new CmtCloseDay();
			cmtCloseDay.setTagNo(tagNo);
			cmtCloseDay.setCloseDtime((DateUtil.calcDateTime(date, "HOUR", +(count - 1))));
			cmtCloseDay.setTagData("888");
			cmtCloseDay.setQltyCd(198);
			cmtCloseDay.setCollDtime(date);
			cmtCloseDay.setLastUpdUser("TEST");
			expected.add(cmtCloseDay);
		}
		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.nhDayCloseWrite(session, expected));
		session.commit();
		session.close();
	}

	@Test
	/** 日締めデータ書込み2 */
	public void nhDayCloseWriteTest2() throws ParseException {

		List<String> tagNoList = new ArrayList();
		// tagNoList.add("TL111-");
		// tagNoList.add("TD111-");
		tagNoList.add("TT111-");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date date = DateUtil.moldYYYYMMDD(sdf.parse(datef));

		int loopCount = 5;
		List<CmtCloseDay> expected = new ArrayList();
		for (String tagNo : tagNoList) {
			for (int i = 1; i <= loopCount; i++) {
				CmtCloseDay cmtCloseDay = new CmtCloseDay();
				cmtCloseDay.setTagNo(tagNo + i);
				cmtCloseDay.setCloseDtime(date);
				cmtCloseDay.setTagData(Integer.toString(6 - i));
				cmtCloseDay.setLastUpdUser("CALCTEST");
				expected.add(cmtCloseDay);
			}
		}
		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.nhDayCloseWrite(session, expected));
		session.commit();
		session.close();
	}

	@Test
	/** 日締めデータ書込み論理名 */
	public void nhDayCloseWriteByLogicalNameTest() throws ParseException {

		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL112");
		tagNoList.add("TL112");
		tagNoList.add("TL112");
		tagNoList.add("TL112");
		tagNoList.add("TL112");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date date = DateUtil.moldYYYYMMDD(sdf.parse(datef));

		int count = 0;
		List<CmtCloseDayDto> expected = new ArrayList();
		for (String tagNo : tagNoList) {

			count++;

			CmtCloseDayDto cmtCloseDayDto = new CmtCloseDayDto();
			cmtCloseDayDto.setTagLogicName1("ZERO_VAL");
			cmtCloseDayDto.setCloseDtime((DateUtil.calcDateTime(date, "DAY", +(count - 1))));
			cmtCloseDayDto.setTagData("111");
			cmtCloseDayDto.setQltyCd(192);
			expected.add(cmtCloseDayDto);
		}
		SqlSession session = SelectDb.dbAcssece(DB);

		String lupdu = "TEST";
		assertEquals(true, CloseUtil.nhDayCloseWriteByLogicalName(session, expected, lupdu));
		session.commit();
		session.close();
	}

	@Test
	/** 月締めデータ読込1 */
	public void nhMonCloseReadTest1() throws ParseException {
		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String from = "2020-05-11 09:00:00";
		Date fromDate = sdf.parse(from);

		String to = "2020-08-29 15:00:00";
		Date toDate = sdf.parse(to);
		SqlSession session = SelectDb.dbAcssece(DB);
		Map<Date, List<CmtCloseMon>> resurts = CloseUtil.nhMonCloseRead(session, fromDate, toDate);
		session.close();
		System.out.println(resurts);
	}

	@Test
	/** 月締めデータ読込2 */
	public void nhMonCloseReadTest2() throws ParseException {
		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date fromDate = null;

		String to = "2020-07-11 15:00:00";
		Date toDate = sdf.parse(to);
		SqlSession session = SelectDb.dbAcssece(DB);
		Map<Date, List<CmtCloseMon>> resurts = CloseUtil.nhMonCloseRead(session, fromDate, toDate);
		session.close();
		System.out.println(resurts);
	}

	@Test
	/** 月締めデータ読込3 */
	public void nhMonCloseReadTest3() throws ParseException {
		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String from = "2020-05-11 15:00:00";
		Date fromDate = sdf.parse(from);

		Date toDate = null;

		SqlSession session = SelectDb.dbAcssece(DB);
		Map<Date, List<CmtCloseMon>> resurts = CloseUtil.nhMonCloseRead(session, fromDate, toDate);
		session.close();
		System.out.println(resurts);

	}

	@Test
	/** 月締めデータ書込み1 */
	public void nhMonCloseWriteTest1() throws ParseException {

		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2022-01-01 00:00:00";
		Date date = DateUtil.moldYYYYMM(sdf.parse(datef));

		int count = 0;
		List<CmtCloseMon> expected = new ArrayList();
		for (String tagNo : tagNoList) {

			count++;

			CmtCloseMon cmtCloseMon = new CmtCloseMon();
			cmtCloseMon.setTagNo(tagNo);
			cmtCloseMon.setCloseDtime((DateUtil.calcDateTime(date, "MONTH", +(count - 1))));
			cmtCloseMon.setTagData("555");
			cmtCloseMon.setQltyCd(198);
			cmtCloseMon.setLastUpdUser("TEST");
			expected.add(cmtCloseMon);
		}
		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.nhMonCloseWrite(session, expected));
		session.commit();
		session.close();
	}

	@Test
	/** 月締めデータ書込み2 */
	public void nhMonCloseWriteTest2() throws ParseException {

		List<String> tagNoList = new ArrayList();
		// tagNoList.add("TL111-");
		tagNoList.add("TD111-");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-05-01 00:00:00";
		Date date = DateUtil.moldYYYYMM(sdf.parse(datef));

		int loopCount = 5;
		List<CmtCloseMon> expected = new ArrayList();
		for (String tagNo : tagNoList) {
			for (int i = 1; i <= loopCount; i++) {
				CmtCloseMon cmtCloseMon = new CmtCloseMon();
				cmtCloseMon.setTagNo(tagNo + i);
				cmtCloseMon.setCloseDtime(date);
				cmtCloseMon.setTagData(Integer.toString(6 - i));
				cmtCloseMon.setLastUpdUser("CALCTEST");
				expected.add(cmtCloseMon);
			}
		}
		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.nhMonCloseWrite(session, expected));
		session.commit();
		session.close();
	}

	@Test
	/** 日締 */
	public void execDayCloseTest() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.execDayClose(session, targetDate, "TEST"));
		session.commit();
		session.close();
	}

	@Test
	/** 計算処理1 */
	public void calcDataTest1() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 0;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理2 */
	@Test
	public void calcDataTest2() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 1;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理3 */
	@Test
	public void calcDataTest3() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 2;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理4 */
	@Test
	public void calcDataTest4() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 3;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理5 */
	@Test
	public void calcDataTest5() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 4;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理6 */
	@Test
	public void calcDataTest6() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 5;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理7 */
	@Test
	public void calcDataTest7() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 6;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理8 */
	@Test
	public void calcDataTest8() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 7;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理9 */
	@Test
	public void calcDataTest9() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 8;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理10 */
	@Test
	public void calcDataTest10() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 9;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}

	/** 計算処理11 */
	@Test
	public void calcDataTest11() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datef = "2020-06-01 00:00:00";
		Date targetDate = DateUtil.moldYYYYMM(sdf.parse(datef));

		int histryKind = 10;

		SqlSession session = SelectDb.dbAcssece(DB);
		assertEquals(true, CloseUtil.calcData(session, targetDate, histryKind));
		session.commit();
		session.close();
	}
}
