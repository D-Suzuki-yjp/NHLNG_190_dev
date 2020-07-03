package job.sfcommon.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import job.sfcommon.dataaccess.entity.nhlng.CmmTagMasterV;
import job.sfcommon.dataaccess.entity.nhlng.CmtTagVal;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.util.TagUtil;

public class TagUtilTest {

	@Test
	public void selectCmmTagMasterTest() {

		List<String> tagNoList = new ArrayList();
		tagNoList.add("TL111");
		tagNoList.add("TL112");

		SqlSession session = SelectDb.dbAcssece("nhlng");
		Map<String, CmmTagMasterV> result = TagUtil.selectCmmTagMaster(session, tagNoList);

		System.out.println(result);
	}

	@Test
	public void selectCmtTagMasterByLogicalNameTest() {
		List<String[]> tagNoList = new ArrayList();
		String[] array = new String[4];
		array[0] = "ZERO_VAL";
		array[1] = null;
		array[2] = null;
		array[3] = null;
		tagNoList.add(array);
		SqlSession session = SelectDb.dbAcssece("nhlng");
		Map<String[], List<CmmTagMasterV>> result = TagUtil.selectCmtTagMasterByLogicalName(session, tagNoList);

		System.out.println(result);
	}

	@Test
	public void selectCmtTagValByLogicalNameTest() {
		List<String[]> tagNoList = new ArrayList();
		String[] array = new String[4];
		array[0] = "ZERO_VAL";
		array[1] = null;
		array[2] = null;
		array[3] = null;
		tagNoList.add(array);
		SqlSession session = SelectDb.dbAcssece("nhlng");
		java.util.Map<String[], List<CmtTagVal>> result = TagUtil.selectCmtTagValByLogicalName(session, tagNoList);

		System.out.println(result);
	}

	@Test
	public void makeTagNoToLcodeMapTest(){
		SqlSession session = SelectDb.dbAcssece("nhlng");
		TagUtil tagUtil = new TagUtil();
		tagUtil.makeTagNoToLcodeMap();
	}
}
