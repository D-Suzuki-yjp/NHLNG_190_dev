package job.sfcommon.util;

import java.io.File;

import javax.enterprise.context.Dependent;


/**
 * ソート機能クラスの基底クラス.<br>
 *
 * @author kumagai.
 */
@Dependent
public abstract class FileWrapper implements Comparable<Object>{

	/** File */
	protected File file;

	/**
	 * コンストラクタ
	 * @param file ファイル
	 */
	public FileWrapper(File file){
		this.file = file;
	}

	/**
	 * 比較の仕方を実装します.<br>
	 * 全てのサブクラスにこのメソッドを実装させます.
	 */
	public abstract int compareTo(Object obj);

	/**
	 * ファイルを返します。
	 * @return file ファイル
	 */
	public File getFile() {
		return this.file;
	}

}
