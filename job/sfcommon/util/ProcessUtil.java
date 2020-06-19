package job.sfcommon.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 *
 * 外部コマンド実行用ユーティリティクラス.<br>
 * <br>
 * <b>概要:</b><br>
 * 外部コマンドを引数として受けとり、実行する.<br>
 * 標準出力、エラー出力を引数として受けるWriterに渡す.<br>
 *
 * @author kumagai
 */
public final class ProcessUtil {
	/** 外部コマンド実行中判定フラグ. */
	private static boolean bExec = false;
	/** 外部コマンド実行開始日時. */
	private static Date bDate = null;
	/** 外部コマンド終了待ち時間. */
	private static int TIMEOUT = 60;
	/** プロセス */
	private static Process process = null;

	/**
     * private constructor
     */
    private ProcessUtil() {
        // empty
    	super();
    }

	/**
	 *
	 * 実行状態チェック.<br>
	 * <br>
	 * <b>目的:</b><br>
	 * 外部コマンドの実行状態を判定する.<br>
	 * <br>
	 * <b>処理概要:</b><br>
     *
     * ※必ずこのメソッドで実行状態のチェックを行ってください.
	 * <br>
     * @return true:実行中 false:実行中でない
	 */
    public static boolean isExec() {

    	//一定の時間を超過しても外部プロセスからの応答がない場合は、実行中フラグを落して外部プロセス呼び出し可能にする
    	if (bExec) {
        	int processTimeOut = TIMEOUT;
        	Calendar timeOutCal = Calendar.getInstance();
        	timeOutCal.setTime(bDate);
        	timeOutCal.add(Calendar.SECOND, processTimeOut);

        	Calendar now = Calendar.getInstance();
        	now.setTime(DateUtil.sysdate());
        	if (timeOutCal.compareTo(now) <= 0) {
        		// 時間切れ
        		stopExec();
        		bExec = false;
        		bDate = null;
        	}
    	}

    	return bExec;
    }

    /**
     * 実行中のプロセスを強制終了する.
     */
    public static void stopExec() {
		if (process != null) {
			process.destroy();
			process = null;
		}
    }

    /**
     * 外部コマンドの実行
	 * <br>
	 * <b>目的:</b><br>
	 * 外部コマンドを実行します.<br>
	 * <br>
	 * <b>処理概要:</b><br>
     * ※ isExec() == true の場合にのみ実行してください。
     *
     * @param args 実行パラメータ
     * @return 実行
     * @throws IOException I/O例外
     */
    public static int execProgram(String... args) throws IOException {
    	return execProgram(null, null, args);
    }

    /**
     * 外部コマンドの実行
	 * <br>
	 * <b>目的:</b><br>
	 * 外部コマンドを実行します.<br>
	 * <br>
	 * <b>処理概要:</b><br>
     * ※ isExec() == true の場合にのみ実行してください。
     *
     * @param out 出力先
     * @param args 実行パラメータ
     * @return 実行
     * @throws IOException I/O例外
     */
    public static int execProgram(Writer out, String... args) throws IOException {
    	File execDir = FileUtil.getFileInstance(".");
    	return execProgram(execDir, null, out, args);
    }

    /**
     * 外部コマンドの実行
	 * <br>
	 * <b>目的:</b><br>
	 * 外部コマンドを実行します.<br>
	 * <br>
	 * <b>処理概要:</b><br>
     * ※ isExec() == true の場合にのみ実行してください。
     *
     * @param execDir 実行ディレクトリ
     * @param out 出力先
     * @param args 実行パラメータ
     * @return 実行
     * @throws IOException I/O例外
     */
    public static int execProgram(File execDir, Writer out, String... args) throws IOException {
    	return execProgram(execDir, null, out, args);
    }

    /**
     * 外部コマンドの実行
	 * <br>
	 * <b>目的:</b><br>
	 * 外部コマンドを実行します.<br>
	 * <br>
	 * <b>処理概要:</b><br>
     * ※ isExec() == false の場合にのみ実行してください。
     *
     * @param execDir 実行ディレクトリ
     * @param envMap 環境変数指定
     * @param out 出力先
     * @param args 実行パラメータ
     * @return 実行
     * @throws IOException I/O例外
     */
    public static int execProgram(File execDir, Map<String,String> envMap, Writer out, String... args)
            throws IOException {
    	// 実行中チェック
    	if (isExec()) {
    		// 実行中なので終了
    		throw new IOException("プロセス実行中のためスキップします。");
    	}

    	bExec = true;
    	bDate = DateUtil.sysdate();

        ProcessBuilder builder = new ProcessBuilder(args);
        builder.directory(execDir);

        builder.redirectErrorStream(true);

        //環境変数を設定
        if (envMap!=null && envMap.size()>0) {
        	Map<String,String> correntEnvMap = builder.environment();
        	correntEnvMap.putAll(envMap);
        }

        process = builder.start();

        BufferedInputStream stream = new BufferedInputStream(process.getInputStream());
        try {
            return waitEndProcess(out, stream);
        } catch (Exception e) {
        	throw new IOException(e);
        } finally {
            stream.close();
            if (process != null) {
            	process.destroy();
            }
        	builder.directory();
            stream=null;
            process = null;
            builder = null;
            bExec = false;
            bDate = null;
        }
    }


    /**
     * プログラムを実行します。プログラムの終了を待たずにすぐに処理を返します。
	 * <br>
	 * <b>目的:</b><br>
	 * 外部コマンドを実行します.<br>
	 * <br>
	 * <b>処理概要:</b><br>
     * ※ isExec() == true の場合にのみ実行してください。
     *
     * @param execDir 実行ディレクトリ
     * @param args 実行パラメータ
     * @throws IOException I/O例外
     */
    public static void execProgramNoWait(File execDir, String... args)
            throws IOException {

    	bExec = false;
        bDate = null;

        ProcessBuilder builder = new ProcessBuilder(args);
        builder.directory(execDir);

        builder.redirectErrorStream(true);
        builder.start();
    }

    /**
      * プロセスが終了するまで待機します。
      * @param out プロセスの実行結果（標準出力およびエラー出力）の出力先
      * @param stream プロセスの入力ストリーム（標準出力およびエラー出力）
      * @return プロセスの実行結果
      * @throws IOException I/O例外
      */
     private static int waitEndProcess(Writer out, BufferedInputStream stream)
             throws IOException {

    	 final int currentsize = 512;

    	 try {
             byte[] bs = new byte[currentsize];
             int size = -1;
             while (0 < (size = stream.read(bs, 0, currentsize))) {
                 if (out != null) {
                     out.write(new String(bs, 0, size));
                     out.flush();
                 }
             }
             return process.exitValue();
         } catch (IllegalThreadStateException e) {
        	 throw new RuntimeException(e);
         }
     }
}

