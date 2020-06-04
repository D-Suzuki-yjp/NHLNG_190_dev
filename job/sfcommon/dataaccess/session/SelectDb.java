package job.sfcommon.dataaccess.session;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.session.SqlSession;

import job.sfcommon.util.ConstUtil;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/1 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * selectDbAcssece 接続先DB選択クラス
 * @author D.Suzuki
 */
@Dependent
public class SelectDb {

	/**
	 * 接続先DB選択処理
	 * @param dbName 接続先DB名
	 * @return SqlSession
	 */
	public static SqlSession dbAcssece(String dbName) {

		SqlSession session = null;
		if(dbName.equals(ConstUtil.LOOPONEX_CORE)){
			session = LooponexcoreSqlSessionFactory.openSession();
		} else if(dbName.equals(ConstUtil.NHLNG)){
			session = NhlngSqlSessionFactory.openSession();
		}

		return session;
	}

}
