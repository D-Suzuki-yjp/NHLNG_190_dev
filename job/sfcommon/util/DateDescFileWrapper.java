package job.sfcommon.util;

import java.io.File;


/**
 * ファイルの最終更新日時の降順でソートに使用します.<br>
 *
 * @author kumagai.
 */
public class DateDescFileWrapper extends FileWrapper{

	/**
	 * コンストラクタ.
	 * @param file ファイル
	 */
	public DateDescFileWrapper(File file) {
		super(file);
	}

	@Override
	public int compareTo(Object obj) {
		assert obj instanceof DateDescFileWrapper;

		DateDescFileWrapper castObj = (DateDescFileWrapper)obj;
		File castFile = castObj.getFile();

		if (this.file.lastModified() < castFile.lastModified()) {
			return 1;	//小さい場合
		} else if (this.file.lastModified() > castFile.lastModified()) {
			return -1;	//大きい場合
		} else {
			return 0;	//等しい場合
		}
	}


	@Override
	public boolean equals(Object obj){
		assert obj instanceof DateDescFileWrapper;

		DateDescFileWrapper castObj = (DateDescFileWrapper)obj;
		File castFile = castObj.getFile();

		if (this.file.lastModified() == castFile.lastModified()) {
			return true;	//等しい場合
		}
		return false;
	}

	@Override
	public int hashCode() {
		assert false : "hashCodeが呼び出されることは想定されていません。";
	return 42; // 適当な値
	}

}
