package job.sfcommon.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.dto.CurrentDataDto;
import job.sfcommon.dto.CurrentTrendDto;
import job.sfcommon.dto.HourHistoryDto;

public class LoopOnExCoreUtilTest {
	/**
	 * コンストラクタ
	 */
	public LoopOnExCoreUtilTest() {
	};

	@Test
	/** 瞬時データ読込 */
	public void slgCurrentDataReadTest() {

		TagUtil.makeTagNoToLcodeMap();

		List<String> tagNoList = new ArrayList();
		List<CurrentDataDto> resurts = new ArrayList();

		// テストパラメータ
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		// テスト実行
		resurts = LoopOnExCoreUtil.slgCurrentDataRead(tagNoList);

		for (CurrentDataDto resurt : resurts) {
			System.out.println(resurt);
		}
	}

	@Test
	/** 瞬時データ読込(論理名) */
	public void slgCurrentDataReadByLogicalNameTest() {

		TagUtil tagUtil = new TagUtil();
		tagUtil.makeTagNoToLcodeMap();

		List<String[]> tagNoList = new ArrayList();
		String[] array = new String[4];
		array[0] = "ZERO_VAL";
		array[1] = null;
		array[2] = null;
		array[3] = null;
		tagNoList.add(array);

		// テスト実行
		SqlSession session = SelectDb.dbAcssece("nhlng");
		Map<String[], List<CurrentDataDto>> resurts = LoopOnExCoreUtil.slgCurrentDataReadByLogicalName(session,
				tagNoList);

		System.out.println(resurts);
	}

	@Test
	/** 瞬時データ書込 */
	public void slgCurrentDataWrite() {

		TagUtil tagUtil = new TagUtil();
		tagUtil.makeTagNoToLcodeMap();

		List<CurrentDataDto> parm = new ArrayList();
		CurrentDataDto currentDataDto1 = new CurrentDataDto();
		CurrentDataDto currentDataDto2 = new CurrentDataDto();
		Date date = new Date();
		date = DateUtil.calcDateTime(date, "MONTH", -1200);

		// パラメータ（List<CurrentDataDto>）作成
		currentDataDto1.setTagNo("TL111");
		currentDataDto1.setValue("11111");
		Date d1 = new Date();
		currentDataDto1.setCollectDate(DateUtil.moldYYYYMMDDHHmm(date));

		currentDataDto2.setTagNo("TL112");
		currentDataDto2.setValue("22222");
		Date d2 = new Date();
		currentDataDto2.setCollectDate(DateUtil.moldYYYYMMDDHHmm(date));

		parm.add(currentDataDto1);
		parm.add(currentDataDto2);

		SqlSession session = SelectDb.dbAcssece("nhlng");
		assertEquals(true, LoopOnExCoreUtil.slgCurrentDataWrite(session, parm));

	}

	@Test
	/** 瞬時データ読込 */
	public void slgHourHistoryReadTest() {

		TagUtil.getTagNoToLcodeMap();

		List<String> tagNoList = new ArrayList();
		List<HourHistoryDto> resurts = new ArrayList();
		List<CurrentTrendDto> expected = new ArrayList();
		// テストパラメータ
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		Date toDate = DateUtil.moldYYYYMMDDHHmm(new Date(DateUtil.getNow().getTime()));
		// テスト実行
		resurts = LoopOnExCoreUtil.slgHourHistoryRead(toDate);

		System.out.println(resurts);

	}
}
