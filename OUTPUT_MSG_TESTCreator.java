package job.screen.output_msg_test;

import javax.enterprise.context.RequestScoped;

import com.yse.gb.gf.front.Creator;
import com.yse.gb.gf.front.CreatorException;
import com.yse.gb.gf.front.KeyObj;
import com.yse.gb.gf.front.ValueBean;

/**
 * クリエータ。<br>
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
public class OUTPUT_MSG_TESTCreator extends Creator {
	/**
	 * 画面生成処理。<br>
	 * <!-- METHOD DESCRIPTION -->
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param keyObj
	 *            画面展開時パラメータ
	 * @param valueBean
	 *            画面展開情報
	 */
	@Override
	protected void createValueBean(final KeyObj keyObj, final ValueBean valueBean)
			throws CreatorException, Throwable {
		// ここにコードを記述


	}

	private void getMsgId(){
		/**List<Map<CmmMessageDefDao.COLUMNS, Object>> CmmMessageDefDaoRecordList;

		List<String> msgIdList = new ArrayList();

		try (SqlSession session = NHLNGSqlSessionFactory.openSession()) {
			// ユーザ情報検索
			CmmMessageDefDaoRecordList = CmmMessageDefDao.selectAllRecord(session);

			for(Map<CmmMessageDefDao.COLUMNS, Object> CmmMessageDefDaoRecord:CmmMessageDefDaoRecordList){
				msgIdList.add((CmmMessageDefDaoRecord.get(CmmMessageDefDao.COLUMNS.MSGID)).toString());
			}
        }**/


	}
}
