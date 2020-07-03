package job.sfcommon.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ファイル関連ユーティリティ.
 *
 * @author kumagai.
 *
 */
public final class FileUtil {
	/** コンストラクタ. */
	private FileUtil() { }

	/**
	 * クラスパス上にあるファイルをStreamで取得.
	 *
	 * @param fileName ファイル名
	 * @return InputStream
	 */
	public static synchronized InputStream getFileStream(String fileName) {
	    if (fileName == null || fileName.length() == 0) {
	        return null;
	    }

//	    URL resource = null;
//        try {
//            resource = new URL(FileUtil.class.getResource("."), fileName);
//        } catch (MalformedURLException e) {
//            throw new AppException(e);
//        }
//
//        return resource.openConnection().getInputStream();

		return FileUtil.class.getClassLoader().getResourceAsStream(fileName);
	}

	/**
	 * 指定したディレクトリ[directoryPath]から、
	 * 検索対象のファイル[fileName]を検索し、該当する
	 * ファイルオブジェクトのリストを返します.
	 *
	 * 例)
	 * File[] files =listFiles("C:/filelist/", "*.java");
	 * 上記の例では、ディレクトリfilelistを再帰的に検索し、
	 * 拡張子javaのファイルリストを取得します.
	 *
	 * @param directoryPath 検索対象のディレクトリを表すパス
	 * @param fileName 検索対象のファイル名
	 *                 ファイル名にはワイルドカード文字として*を指定可能
	 * @return 検索にマッチしたファイルオブジェクト
	 */
	public static List<File> getFileList(String directoryPath, String fileName) {
	    return getFileList(directoryPath, fileName, true);
	}

   /**
     * 指定したディレクトリ[directoryPath]から、
     * 検索対象のファイル[fileName]を検索し、該当する
     * ファイルオブジェクトのリストを返します.
     *
     * 例)
     * File[] files =listFiles("C:/filelist/", "*.java");
     * 上記の例では、ディレクトリfilelistを再帰的に検索し、
     * 拡張子javaのファイルリストを取得します.
     *
     * @param directoryPath 検索対象のディレクトリを表すパス
     * @param fileName 検索対象のファイル名
     *                 ファイル名にはワイルドカード文字として*を指定可能
     * @param wildcard ワイルドカード文字の使用有無(true:使用／false:未使用)
     * @return 検索にマッチしたファイルオブジェクト
     * @throws IllegalArgumentException IllegalArgument例外
     */
    public static List<File> getFileList(String directoryPath, String fileName, boolean wildcard) {
        List<File> fList = new ArrayList<File>();
        // 引数チェック
        if (directoryPath == null || directoryPath.length() == 0
            || fileName == null || fileName.length() == 0) {
            return fList;
        }
        // ワイルドカード文字として*を正規表現に変換
        if (wildcard) {
            fileName = fileName.replace(".", "\\.");
            fileName = fileName.replace("*", ".*");
        }
        // ディレクトリチェック
        File dir = new File(directoryPath);
        if (!dir.exists()) {
            throw new IllegalArgumentException
            ("指定されたパス(" + dir.getAbsolutePath() + ")が存在しません。");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException
            ("引数で指定されたパス(" + dir.getAbsolutePath() + ")はディレクトリではありません。");
        }
        // ディレクトリ内のファイルを検索
        File[] files = dir.listFiles();
        for (int i=0; i<files.length; i++) {
            File file = files[i];
            if (!file.isFile()) {
            	continue;   // ファイルでないときは何もしない
            }
            if (fileName != null && file.getName().matches(fileName)) {
                // ファイル名がマッチしたらOK
                fList.add(file);
            }
        }

        return fList;
    }

	/**
	 * 指定したディレクトリ[directoryPath]から、
	 * 検索対象のディレクトリ[fileName]を検索し、該当する
	 * ファイルオブジェクトのリストを返します.
	 *
	 * 例)
	 * File[] files =listFiles("C:/filelist/", "2010*");
	 * 上記の例では、ディレクトリfilelistを検索し、
	 * 2010で始まるディレクトリのファイルリストを取得します.
	 *
	 * @param directoryPath 検索対象のディレクトリを表すパス
	 * @param dirName 検索対象のディレクトリ名
	 *                 ディレクトリ名にはワイルドカード文字として*を指定可能
	 * @return 検索にマッチしたファイルオブジェクト
	 * @throws IllegalArgumentException IllegalArgument例外
	 */
	public static List<File> getDirList(String directoryPath, String dirName) {
        List<File> dList = new ArrayList<File>();
        // 引数チェック
        if (directoryPath == null || directoryPath.length() == 0
            || dirName == null || dirName.length() == 0) {
            return dList;
        }
	    // ワイルドカード文字として*を正規表現に変換
	    if (dirName != null) {
	        dirName = dirName.replace(".", "\\.");
	        dirName = dirName.replace("*", ".*");
	    }
	    // ディレクトリチェック
	    File dir = new File(directoryPath);
	    if (!dir.exists()) {
	    	throw new IllegalArgumentException
	        ("指定されたパス(" + dir.getAbsolutePath() + ")が存在しません。");
	    }
	    if (!dir.isDirectory()) {
	        throw new IllegalArgumentException
	        ("指定されたパス(" + dir.getAbsolutePath() + ")はディレクトリではありません。");
	    }
	    // ディレクトリ内のディレクトリを検索
	    File[] dirs = dir.listFiles();
	    for (int i=0; i<dirs.length; i++) {
	        File d = dirs[i];
	        if (!d.isDirectory()){
	        	continue;	// ディレクトリでないときは何もしない
	        }
	        if (dirName != null && d.getName().matches(dirName)) {
	        	// ファイル名がマッチしたらOK
	        	dList.add(d);
	        }
	    }

	    return dList;
	}

	/**
	 * 最終更新日時の昇順でソートしたファイルのリストを返します.
	 * @param path ディレクトリパス
	 * @param filter フィルタ nullの場合フィルタリング無しの結果が返ります
	 * @return ファイルリスト
	 */
	public static List<File> getAscFileList(String path, String filter){
		return getAscFileList(path, filter, true);
	}

	/**
     * 最終更新日時の昇順でソートしたファイルのリストを返します.
     * @param path ディレクトリパス
     * @param filter フィルタ nullの場合フィルタリング無しの結果が返ります。
     * @param wildcard ワイルドカード文字の使用有無(true:使用／false:未使用)
     * @return ファイルリスト
     */
    public static List<File> getAscFileList(String path, String filter, boolean wildcard) {
        List<File> files = getFileList(path, filter, wildcard);

        //比較機能（Comparableを実装）を備えるファイルラッパ
        DateAscFileWrapper [] fileWrappers = new DateAscFileWrapper[files.size()];
        for (int i=0; i<files.size(); i++) {
            fileWrappers[i] = new DateAscFileWrapper(files.get(i));
        }
        //ソートを行う
        Arrays.sort(fileWrappers);
        //ソートしたオブジェクトから戻り値にセット
        List<File> sortedFiles = new ArrayList<File>();
        for (int i=0; i<files.size(); i++) {
            sortedFiles.add(fileWrappers[i].getFile());
        }
        return sortedFiles;
    }

	/**
	 * 最終更新日時の降順でソートしたファイルのリストを返します.
	 * @param path ディレクトリパス
	 * @param filter フィルタ nullの場合フィルタリング無しの結果が返ります
	 * @return ファイルリスト
	 */
	public static List<File> getDescFileList(String path, String filter){
		return getDescFileList(path, filter, true);
	}

	   /**
     * 最終更新日時の降順でソートしたファイルのリストを返します.
     * @param path ディレクトリパス
     * @param filter フィルタ nullの場合フィルタリング無しの結果が返ります。
     * @param wildcard ワイルドカード文字の使用有無(true:使用／false:未使用)
     * @return ファイルリスト
     */
    public static List<File> getDescFileList(String path, String filter, boolean wildcard){
        List<File> files = getFileList(path, filter, wildcard);

        //比較機能（Comparableを実装）を備えるファイルラッパ
        DateDescFileWrapper [] fileWrappers = new DateDescFileWrapper[files.size()];
        for (int i=0; i<files.size(); i++) {
            fileWrappers[i] = new DateDescFileWrapper(files.get(i));
        }
        //ソートを行う
        Arrays.sort(fileWrappers);
        //ソートしたオブジェクトから戻り値にセット
        List<File> sortedFiles = new ArrayList<File>();
        for (int i=0; i<files.size(); i++) {
            sortedFiles.add(fileWrappers[i].getFile());
        }
        return sortedFiles;
    }

	/**
	 * ファイルリストの中で最も更新日時が最も古いファイルを取得.
	 *
	 * @param fileList ファイルリスト
	 * @return 一番古いファイルオブジェクト。存在しない場合はNULL
	 */
	public static File getOldestFile(List<File> fileList) {
	    if (fileList == null) {
	        return null;
	    }
		File old = new File("");
		for (File file : fileList) {
			if (file.isDirectory()) {
				continue;
			}
			if (old.lastModified() == 0 || file.lastModified() < old.lastModified()) {
				old = file;
			}
		}
		if ("".equals(old.getName())) {
			return null;
		}
		return old;
	}

	/**
	 * ディレクトリ内のファイルパターンに一致するファイルの中で
	 * 更新日時が最も古いファイルを取得.
	 *
	 * @param directoryPath 検索対象のディレクトリを表すパス
	 * @param fileName 検索対象のファイル名
	 *                 ファイル名にはワイルドカード文字として*を指定可能
	 * @return  更新日時が最も古いファイル
	 *
	 */
	public static File getOldestFile(String directoryPath, String fileName) {
		return getOldestFile(getFileList(directoryPath, fileName));
	}

	/**
	 * ファイルの読込み、文字列にして返します。<br>
	 * charsetへ指定されたエンコード方式で読込みます。
	 * @param file ファイル
	 * @param charset キャラセット
	 * @return String ファイル内容文字列
	 * @throws IOException I/O例外
	 */
	public static String readFile(File file, String charset) throws IOException {
		if (file == null || charset == null) {
		    return null;
		}
	    BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			String tmp;
			while ((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return sb.toString();
	}

	/**
	 * ファイルの読込み、文字列にして返します.<br>
	 * UTF-8として読込みます.
	 * @param file ファイル
	 * @return String ファイル内容文字列
	 * @throws IOException I/O例外
	 */
	public static String readFile(File file) throws IOException {
		return readFile(file, ConstUtil.CHARSET_UTF8);
	}

	/**
	 * ファイルをコピーします.
	 * @param oldFile コピー元ファイル
	 * @param newFile コピー先ファイル
	 * @throws IOException I/O例外
	 */
	@SuppressWarnings("resource")
	public static void copyFile(File oldFile, File newFile) throws IOException{
		FileChannel ifc = null;
		FileChannel ofc = null;
		try {
			// 入力元ファイルのストリームからチャネルを取得
			ifc = new FileInputStream(oldFile).getChannel();

			// 出力先ファイルのチャネルを取得
			ofc = new FileOutputStream(newFile).getChannel();

			// バイトを転送します。
			ifc.transferTo(0, ifc.size(), ofc);
		} finally {
			if (ifc != null){
				ifc.close();
			}
			if (ofc != null){
				ofc.close();
			}
		}
	}

	/**
	 * ファイルの存在確認.
	 *
	 * @param filePath ファイルパス
	 * @return true:存在／false:無し
	 */
	public static boolean isExists(String filePath) {
		return isExists(new File(filePath));
	}

	/**
	 * ファイルの存在確認.
	 *
	 * @param file ファイルオブジェクト
	 * @return true:存在／false:無し
	 */
	public static boolean isExists(File file) {
		return file.exists();
	}

	/**
	 * 指定されたファイルを出力します。<br>
	 * dataがnullの場合、空のファイルが作成されます。<br>
	 *
	 * @param file		ファイル
	 * @param data		データ
	 * @param charset	キャラセット
	 * @param append	アペンドで出力の場合true
	 * @throws IOException I/O例外
	 */
	public static void writeFile(File file, String data, String charset, boolean append) throws IOException{
		OutputStreamWriter writer = null;
		try {
			data = StringUtil.emptyStr(data);

			writer = new OutputStreamWriter(new FileOutputStream(file, append), charset);
			writer.write(data);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 指定されたパスへファイルを出力します。<br>
	 * dataがnullの場合、空のファイルが作成されます。<br>
	 *
	 * @param filePath ファイルパス
	 * @param data データ
	 * @throws IOException I/O例外
	 */
	public static void writeFile(String filePath, String data) throws IOException{
		writeFile(new File(filePath), data);
	}

	/**
	 * 指定されたファイルを出力します。<br>
	 * dataがnullの場合、空のファイルが作成されます。<br>
	 * Shift_JISエンコード方式で出力します。
	 *
	 * @param file ファイル
	 * @param data データ
	 * @throws IOException I/O例外
	 */
	public static void writeFile(File file, String data) throws IOException{
		writeFile(file, data, ConstUtil.DEFAULT_ENCODE, false);
	}

	/**
	 * 指定したディレクトリ内のファイルを全てzipに圧縮
	 * @param tergetDir 対象ディレクトリ
	 * @param zipPathName 作成するzipファイル（フルパス）
	 */
	public static void createZip(String tergetDir, String zipPathName) {
		File zip = new File(zipPathName);
		File target = new File(tergetDir);
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(new FileOutputStream(zip));
			archive(zos, zip, target);
		} catch (FileNotFoundException e) {
			//throw new AppException("ファイル圧縮エラー　対象ディレクトリ=" + tergetDir + " 圧縮ファイル名=" + zipPathName);
		} finally {
			if (zos != null) {
				try {
					zos.closeEntry();
				} catch (IOException e) {
				}
				try {
					zos.flush();
				} catch (IOException e) {
				}
				try {
					zos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * ファイル圧縮
	 * @param zos ZipOutputStream
	 * @param zip zipファイルオブジェクト
	 * @param target 圧縮対象オブジェクト
	 */
	private static void archive(ZipOutputStream zos, File zip, File target) {

		if (target.isDirectory()) {
			File[] targetFiles = target.listFiles();
			for (File targetFile : targetFiles) {
				if (targetFile.isDirectory()) {
					//フォルダの場合は再帰処理
					archive(zos,zip,targetFile);
				} else {
					BufferedInputStream bis = null;
					try {
						zos.putNextEntry(new ZipEntry(targetFile.getName()));
						bis = new BufferedInputStream(new FileInputStream(targetFile));
						int readSize = 0;
						byte buffer[] = new byte[1024];
						while ((readSize = bis.read(buffer,0,buffer.length)) != -1){
							zos.write(buffer,0,readSize);
						}
					} catch (Exception e) {
						//throw new AppException("ファイル圧縮エラー");
					} finally{
						if (bis != null) {
							try {
								bis.close();
							} catch (IOException e) {
							}
						}
						try {
							zos.closeEntry();
						} catch (IOException e) {
						}
					}
				}
			}
		}
	}

   /**
     * フォルダ・ファイルを削除する。<br>
     * フォルダ内にファイルやサブフォルダが存在する場合も削除する。<br>
     * 指定Fileのnullチェックは本処理内では行わない為、コール前にチェックをする事。<br>
     *
     * @param path ファイル／ディレクトリパス
     * @return boolean true:成功／false:失敗
     */
    public static boolean deleteAll(String path){
        if (path == null || path.length() == 0) {
            return false;
        }
        File target = getFileInstance(path);
        if (target == null) {
            return false;
        }
        return deleteAll(target);
    }

    /**
     * フォルダ・ファイルを削除する。<br>
     * フォルダ内にファイルやサブフォルダが存在する場合も削除する。<br>
     * 指定Fileのnullチェックは本処理内では行わない為、コール前にチェックをする事。<br>
     *
     * @param target ファイル／ディレクトリパス
     * @return boolean true:成功／false:失敗
     */
    public static boolean deleteAll(File target){
        boolean result = false;

        if(target.isFile()){
            // 対象がファイルの場合は削除
            result = target.delete();
        }else if(target.isDirectory()){
            // 対象がフォルダの場合には、フォルダ内のファイルリスト取得
            File[] fileList = target.listFiles();
            for(File f : fileList){
                // 自メソッドを再帰的に呼ぶ
                result = deleteAll(f.getPath());
                // 失敗が返された場合は、失敗を返す
                if(!result){
                    return result;
                }
            }
            // 内部フォルダ・ファイルを削除後にフォルダ削除
            result = target.delete();
        }
        return result;
    }

    /**
     * フォルダ内のファイルを削除する.<br>
     * 引数に指定できるのはフォルダパスのみ.<br>
     * 指定Fileのnullチェックは本処理内では行わない為、コール前にチェックをする事.<br>
     * @param path ディレクトリパス
     * @return boolean true:成功／false:失敗
     */
    public static boolean deleteFiles(String path) {
        File target = getFileInstance(path);
        return deleteFiles(target);
    }

    /**
     * フォルダ内のファイルを削除する.<br>
     * 引数に指定できるのはフォルダパスのみ.<br>
     * 指定Fileのnullチェックは本処理内では行わない為、コール前にチェックをする事.<br>
     * @param target ディレクトリパス
     * @return boolean true:成功／false:失敗
     */
    public static boolean deleteFiles(File target) {
        boolean result = false;

        if (target.isFile()) {
            // 対象がファイルの場合は何もしない
            return false;
        }
        if(target.isDirectory()){
            // 対象がフォルダの場合には、フォルダ内のファイルリスト取得
            File[] fileList = target.listFiles();
            for(File f : fileList){
                // ファイルのみを削除
                if (f.isFile()) {
                    result = f.delete();
                    // 失敗が返された場合は、失敗を返す
                    if (!result) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * ファイルの名前を変更します.<br>
     * 変更後ファイルの配置フォルダがない場合には作成する.<br>
     * 変更後ファイルが既に存在する場合には、削除した後にファイル名変更を行う.<br>
     *
     * rename元ファイルはなくなります.<br>
     * @param oldFile 変更元
     * @param newFile 変更後
     * @return 名前の変更が成功した場合は true、そうでない場合は false
     * @throws IOException I/O例外
     */
    public static boolean renameFile(File oldFile, File newFile) throws IOException{
        boolean result = true;
        // リネーム先のフォルダと既存ファイルを確認
        if(!newFile.getParentFile().exists()){
            result = newFile.getParentFile().mkdirs();
        }else{
            if(newFile.exists()){
                result = newFile.delete();
            }
        }

        if(result){
            // コピーする
            FileUtil.copyFile(oldFile, newFile);
            // 古いファイルを削除する
            result = oldFile.delete();
        }
        return result;
    }

    /**
     * ファイルの名前を変更します.<br>
     * rename元ファイルはなくなります.<br>
     * @param oldPath 変更元
     * @param newPath 変更後
     * @return 名前の変更が成功した場合は true、そうでない場合は false
     * @throws IOException I/O例外
     */
    public static boolean renameFile(String oldPath, String newPath) throws IOException{
        return renameFile(getFileInstance(oldPath), getFileInstance(newPath));
    }

    /**
     * ファイルのバイトサイズを取得する.
     * @param file ファイル
     * @return ファイルのバイトサイズ
     */
    public static Long getFileByteSize(File file){
        if(file == null){
            return 0L;
        }
        if(file.exists()){
            return file.length();
        }
        return 0L;
    }

    /**
     * ファイルのバイトサイズを取得する.
     * @param filePath ファイルパス
     * @return ファイルのバイトサイズ
     */
    public static Long getFileByteSize(String filePath){
        if(StringUtil.isEmpty(filePath)){
            return 0L;
        }
        return getFileByteSize(getFileInstance(filePath));
    }

    /**
     * Fileオブジェクトを生成します.
     * @param path ファイルパス
     * @return File
     */
    public static File getFileInstance(String path){
        return new File(path);
    }

    /**
     * ディレクトリの作成.
     * 親ディレクトリが存在しない場合、作成する.
     *
     * @param dirPath ディレクトリパス
     * @return true:成功 / false:失敗
     */
    public static boolean makeDir(String dirPath) {
        // nullチェック
        if (dirPath == null || dirPath.length() == 0) {
            return false;
        }

        File dir = getFileInstance(dirPath);
        return makeDir(dir);
    }

    /**
     * ディレクトリの作成.
     * 親ディレクトリが存在しない場合、作成する.
     *
     * @param dir ディレクトリパス(Fileオブジェクト)
     * @return true:成功 / false:失敗
     */
    public static boolean makeDir(File dir) {
        if (dir == null) {
            return false;
        }

        // すでに存在したら終了
        if (dir.exists()) {
            return true;    // 存在しているのでtrue
        }

        // ディレクトリ作成
        return dir.mkdirs();
    }

    /**
     * カレントディレクトリのパスを取得.
     *
     * @return カレントディレクトリのパス
     */
    public static String getCurrentPath() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    /**
     * クラスパス上にあるファイルのフルパスを取得.
     *
     * @param fileName ファイル名
     * @return フルパス
     */
    public static String getFilePath(String fileName) {
        FileUtil.class.getClassLoader();
        FileUtil.class.getClassLoader().getResource(fileName);
        return FileUtil.class.getClassLoader().getResource(fileName).getPath();
    }

    /**
     * ファイルの最終更新日時を取得.
     *
     * @param filePath ファイルのフルパス
     * @return long型日付
     */
    public static long getFileLastModify(String filePath) {
        if (isExists(filePath)) {
            return getFileInstance(filePath).lastModified();
        }

        return 0;
    }
}
