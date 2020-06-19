package job.sfcommon.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.dataaccess.dao.nhlng.CmtSystemStatDao;
import job.sfcommon.dataaccess.entity.nhlng.CmtSystemStat;
import job.sfcommon.dataaccess.entity.nhlng.CmtSystemStatExample;
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
@Dependent
public class SystemUtil {
	/** ログカテゴリ*/
	private static final String LOG_CAT = ConstUtil.LOG_COMMON;
	/**
	 * 自身のhostnameグローバル変数
	 */
	private static String hostName;

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
	public static MasterStatDto getMasterStat(SqlSession session) throws RuntimeException{

		// 処理開始ログ
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

		MasterStatDto masterStatDto = new MasterStatDto();
		List<CmtSystemStat> results = new ArrayList();

		CmtSystemStatExample example = new CmtSystemStatExample();

		try {
			results = CmtSystemStatDao.select(session, example);
		} catch (Exception e) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e));
			throw (e);
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
		OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		return masterStatDto;
	}

	/**
	 * 自身のサーバホスト名グローバル変数作成処理
	 *
	 * @throws Exception
	 */
	public void makeHostName() throws RuntimeException{
		String[] param = { new Object() {
		}.getClass().getEnclosingMethod().getName()};
		// 自身のhost情報取得
		try {
			// 処理開始ログ
			OutPutLogs.outPutLogs(LOG_CAT, "0004", param);

			InetAddress ia = InetAddress.getLocalHost();
			hostName = ia.getHostName();// ホスト名
			// 処理終了ログ
			OutPutLogs.outPutLogs(LOG_CAT, "0005", param);
		} catch (UnknownHostException e1) {
			OutPutLogs.outPutLogs(LOG_CAT, "0003", param, new Throwable(e1));
		}
	}

	/**
	 * 自身のサーバホスト名取得
	 *
	 * @throws Exception
	 */
	public static String getHostName() throws RuntimeException{
		return hostName;
	}
}