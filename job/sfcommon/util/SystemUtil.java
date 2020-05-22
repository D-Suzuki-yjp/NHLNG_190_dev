package job.sfcommon.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.dao.nhlng.CmtSystemStatDao;
import job.sfcommon.dataaccess.entity.nhlng.CmtSystemStat;
import job.sfcommon.dataaccess.entity.nhlng.CmtSystemStatExample;
import job.sfcommon.dataaccess.session.SelectDb;
import job.sfcommon.dto.MasterStatDto;
import job.sfcommon.function.outputlogs.OutPutLogs;

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
	public static MasterStatDto getMasterStat() throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs("CMN", "001", param);

		MasterStatDto masterStatDto = new MasterStatDto();
		List<CmtSystemStat> results = new ArrayList();

		CmtSystemStatExample example = new CmtSystemStatExample();
		// システム状態取得
		SqlSession session = SelectDb.dbAcssece("nhlng");
		try {
			results = CmtSystemStatDao.select(session, example);
		} catch (Exception e) {
			throw (e);
		} finally {
			session.close();
		}
		// return用オブジェクトにラッパー
		for (CmtSystemStat result : results) {
			if (hostName.equals(result.getSccServerName())){
				masterStatDto.setSccServerNameOneself(result.getSccServerName());
				masterStatDto.setMasterStatOneself(result.getMasterStat());
			} else {
				masterStatDto.setSccServerNameOther(result.getSccServerName());
				masterStatDto.setMasterStatOther(result.getMasterStat());
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
	public static void getHostName() throws RuntimeException{

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