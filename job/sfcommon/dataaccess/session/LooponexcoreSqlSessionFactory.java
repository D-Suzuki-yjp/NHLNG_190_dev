package job.sfcommon.dataaccess.session;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import job.sfcommon.function.outputlogs.OutPutLogs;
import job.sfcommon.util.ConstUtil;

/**
 * アクセスコントロールのマスタDB用のMyBatisセッション生成クラス。
 */
public class LooponexcoreSqlSessionFactory {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/

	/** エラー文のフォーマット */
	private static final String ERROR_FORMAT = "MyBatis Config XMLファイル '%s' 読み込みエラー";

	/** アクセスコントロール用SqlSessionFactoryオブジェクト */
	private static SqlSessionFactory LOOPONEXCORE_SQL_SESSION_FACTORY;

	static {
		try (InputStream in = Resources.getResourceAsStream("mybatis-config-looponexcore.xml");) {
			LOOPONEXCORE_SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(in, "looponex_core");
		} catch (IOException e) {
			// If the resource cannot be found or read
			e.printStackTrace();
			String[] pram = {String.format(ERROR_FORMAT, "mybatis-config-nhlng.xml")};
			OutPutLogs.outPutLogs(ConstUtil.LOG_COMMON, "0003", pram);
		}
	}

	/*--------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/

	/*--------------------------------------------
	|         C O N S T R U C T O R S           |
	============================================*/

	/**
	 * Prevent instantiation.
	 */
	private LooponexcoreSqlSessionFactory() {
	}

	/*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/

	/*--------------------------------------------
	|               M E T H O D S               |
	============================================*/

	public static SqlSession openSession() {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession();
	}

	public static SqlSession openSession(boolean autoCommit) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(autoCommit);
	}

	public static SqlSession openSession(ExecutorType execType) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(execType);
	}

	public static SqlSession openSession(TransactionIsolationLevel level) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(level);
	}

	public static SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(execType, level);
	}

	public static SqlSession openSession(ExecutorType execType, boolean autoCommit) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(execType, autoCommit);
	}

	public static SqlSession openSession(Connection connection) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(connection);
	}

	public static SqlSession openSession(ExecutorType execType, Connection connection) {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.openSession(execType, connection);
	}

	/**
	 * Retrieves current configuration.
	 *
	 * @return {@link Configuration}
	 */
	public static Configuration getConfiguration() {
		return LOOPONEXCORE_SQL_SESSION_FACTORY.getConfiguration();
	}

}
