package job.sfcommon.util;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.dto.MasterStatDto;

public class SystemUtilTest {

	@Test
	/**主従状態取得*/
	public void getMasterStatTest() {
		SystemUtil systemUtil = new SystemUtil();

		SqlSession session = SelectDb.dbAcssece("nhlng");
		MasterStatDto masterStatDto = SystemUtil.getMasterStat(session);

		assertEquals("SCC-ENG01", masterStatDto.getSccServerNameOneself());
		assertEquals(1, masterStatDto.getMasterStatOneself());
		assertEquals("SCC-B", masterStatDto.getSccServerNameOther());
		assertEquals(0, masterStatDto.getMasterStatOther());
	}
}
