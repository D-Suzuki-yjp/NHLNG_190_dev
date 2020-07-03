package job.sfcommon.util;

import java.io.File;

/**
 * ソート機能クラスの基底クラス.<br>
 *
 * @author kumagai.
 */
public abstract class FileWrapper implements Comparable<Object> {

	/** File */
	protected File file;

	/**
	 * コンストラクタ
	 *
	 * @param file
	 *            ファイル
	 */
	public FileWrapper(File file) {
		this.file = file;
	}

	/**
	 * 比較の仕方を実装します.<br>
	 * 全てのサブクラスにこのメソッドを実装させます.
	 * @param obj Object
	 * @return File File
	 */
	public abstract int compareTo(Object obj);

	/**
	 * ファイルを返します。
	 *
	 * @return file ファイル
	 */
	public File getFile() {
		return this.file;
	}

}
