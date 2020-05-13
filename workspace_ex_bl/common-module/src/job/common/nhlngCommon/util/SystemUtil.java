package job.common.nhlngCommon.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.ibatis.session.SqlSession;

import job.common.nhlngCommon.dataAccess.dao.nhlng.CmtSystemStatDao;
import job.common.nhlngCommon.dto.MasterStatDto;
import job.common.nhlngCommon.function.outPutLogs.OutPutLogs;
import job.common.uiCommon.dataAccess.session.selectDb;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/10 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * SystemUtil システム管理ユーティリティ共通クラス<br>
 * * @author D.Suzuki
 */
@ApplicationScoped
public class SystemUtil {

	/**
	 * 自身のhostnameグローバル変数 TODO 現環境のホスト名を固定している
	 */
	public static String hostName = "SCC-ENG01";

	/**
	 * 主従状態取得共通関数
	 *
	 * @param tagNoList
	 *            タグNoリスト
	 * @param fromDate
	 *            検索条件From日時
	 * @param toDate
	 *            検索条件To日時
	 * @return List<CurrentDataDto> <タグNo,値,収集日時>リスト
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static MasterStatDto getMasterStat() {

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		MasterStatDto masterStatDto = new MasterStatDto();
		List<Map<CmtSystemStatDao.COLUMNS, Object>> results = new ArrayList();

		// システム状態取得
		SqlSession session = selectDb.dbAcssece("nhlng");
		try {
			results = CmtSystemStatDao.selectAllRecord(session);
		} catch (RuntimeException e) {
			throw (e);
		} finally {
			session.close();
		}
		// return用オブジェクトにラッパー
		for (Map<CmtSystemStatDao.COLUMNS, Object> result : results) {
			if (hostName.equals((String) result.get(CmtSystemStatDao.COLUMNS.SCC_SERVER_NAME))) {
				masterStatDto.setSccServerNameOneself((String) result.get(CmtSystemStatDao.COLUMNS.SCC_SERVER_NAME));
				masterStatDto.setMasterStatOneself((int) result.get(CmtSystemStatDao.COLUMNS.MASTER_STAT));
			} else {
				masterStatDto.setSccServerNameOther((String) result.get(CmtSystemStatDao.COLUMNS.SCC_SERVER_NAME));
				masterStatDto.setMasterStatOther((int) result.get(CmtSystemStatDao.COLUMNS.MASTER_STAT));
			}
		}
		// 処理終了ログ
		OutPutLogs.outPutLogs("CMN", "002", param);
		return masterStatDto;
	}

	/**
	 * 警告:使用禁止<br>
	 * 自身のサーバホスト名グローバル変数作成処理
	 *
	 * @throws Exception
	 */
	public static void getHostName() {

		// 自身のhost情報取得
		try {
			// 処理開始ログ
			String[] param = { new Object() {
			}.getClass().getEnclosingMethod().getName()};
			OutPutLogs.outPutLogs("CMN", "001", param);

			InetAddress ia = InetAddress.getLocalHost();
			hostName = ia.getHostName();// ホスト名
			// 処理終了ログ
			OutPutLogs.outPutLogs("CMN", "002", param);
		} catch (UnknownHostException e1) {
			/** TODO */
		}
	}
}