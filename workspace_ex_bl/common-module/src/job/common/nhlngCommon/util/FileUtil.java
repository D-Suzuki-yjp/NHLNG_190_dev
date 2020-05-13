package job.common.nhlngCommon.util;

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
 * �t�@�C���֘A���[�e�B���e�B.
 *
 * @author kumagai.
 *
 */
public final class FileUtil {
	/** �R���X�g���N�^. */
	private FileUtil() { }

	/**
	 * �N���X�p�X��ɂ���t�@�C����Stream�Ŏ擾.
	 *
	 * @param fileName �t�@�C����
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
	 * �w�肵���f�B���N�g��[directoryPath]����A
	 * �����Ώۂ̃t�@�C��[fileName]���������A�Y������
	 * �t�@�C���I�u�W�F�N�g�̃��X�g��Ԃ��܂�.
	 *
	 * ��)
	 * File[] files =listFiles("C:/filelist/", "*.java");
	 * ��L�̗�ł́A�f�B���N�g��filelist���ċA�I�Ɍ������A
	 * �g���qjava�̃t�@�C�����X�g���擾���܂�.
	 *
	 * @param directoryPath �����Ώۂ̃f�B���N�g����\���p�X
	 * @param fileName �����Ώۂ̃t�@�C����
	 *                 �t�@�C�����ɂ̓��C���h�J�[�h�����Ƃ���*���w��\
	 * @return �����Ƀ}�b�`�����t�@�C���I�u�W�F�N�g
	 */
	public static List<File> getFileList(String directoryPath, String fileName) {
	    return getFileList(directoryPath, fileName, true);
	}

   /**
     * �w�肵���f�B���N�g��[directoryPath]����A
     * �����Ώۂ̃t�@�C��[fileName]���������A�Y������
     * �t�@�C���I�u�W�F�N�g�̃��X�g��Ԃ��܂�.
     *
     * ��)
     * File[] files =listFiles("C:/filelist/", "*.java");
     * ��L�̗�ł́A�f�B���N�g��filelist���ċA�I�Ɍ������A
     * �g���qjava�̃t�@�C�����X�g���擾���܂�.
     *
     * @param directoryPath �����Ώۂ̃f�B���N�g����\���p�X
     * @param fileName �����Ώۂ̃t�@�C����
     *                 �t�@�C�����ɂ̓��C���h�J�[�h�����Ƃ���*���w��\
     * @param wildcard ���C���h�J�[�h�����̎g�p�L��(true:�g�p�^false:���g�p)
     * @return �����Ƀ}�b�`�����t�@�C���I�u�W�F�N�g
     * @throws IllegalArgumentException IllegalArgument��O
     */
    public static List<File> getFileList(String directoryPath, String fileName, boolean wildcard) {
        List<File> fList = new ArrayList<File>();
        // �����`�F�b�N
        if (directoryPath == null || directoryPath.length() == 0
            || fileName == null || fileName.length() == 0) {
            return fList;
        }
        // ���C���h�J�[�h�����Ƃ���*�𐳋K�\���ɕϊ�
        if (wildcard) {
            fileName = fileName.replace(".", "\\.");
            fileName = fileName.replace("*", ".*");
        }
        // �f�B���N�g���`�F�b�N
        File dir = new File(directoryPath);
        if (!dir.exists()) {
            throw new IllegalArgumentException
            ("�w�肳�ꂽ�p�X(" + dir.getAbsolutePath() + ")�����݂��܂���B");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException
            ("�����Ŏw�肳�ꂽ�p�X(" + dir.getAbsolutePath() + ")�̓f�B���N�g���ł͂���܂���B");
        }
        // �f�B���N�g�����̃t�@�C��������
        File[] files = dir.listFiles();
        for (int i=0; i<files.length; i++) {
            File file = files[i];
            if (!file.isFile()) continue;   // �t�@�C���łȂ��Ƃ��͉������Ȃ�
            if (fileName != null && file.getName().matches(fileName)) {
                // �t�@�C�������}�b�`������OK
                fList.add(file);
            }
        }

        return fList;
    }

	/**
	 * �w�肵���f�B���N�g��[directoryPath]����A
	 * �����Ώۂ̃f�B���N�g��[fileName]���������A�Y������
	 * �t�@�C���I�u�W�F�N�g�̃��X�g��Ԃ��܂�.
	 *
	 * ��)
	 * File[] files =listFiles("C:/filelist/", "2010*");
	 * ��L�̗�ł́A�f�B���N�g��filelist���������A
	 * 2010�Ŏn�܂�f�B���N�g���̃t�@�C�����X�g���擾���܂�.
	 *
	 * @param directoryPath �����Ώۂ̃f�B���N�g����\���p�X
	 * @param dirName �����Ώۂ̃f�B���N�g����
	 *                 �f�B���N�g�����ɂ̓��C���h�J�[�h�����Ƃ���*���w��\
	 * @return �����Ƀ}�b�`�����t�@�C���I�u�W�F�N�g
	 * @throws IllegalArgumentException IllegalArgument��O
	 */
	public static List<File> getDirList(String directoryPath, String dirName) {
        List<File> dList = new ArrayList<File>();
        // �����`�F�b�N
        if (directoryPath == null || directoryPath.length() == 0
            || dirName == null || dirName.length() == 0) {
            return dList;
        }
	    // ���C���h�J�[�h�����Ƃ���*�𐳋K�\���ɕϊ�
	    if (dirName != null) {
	        dirName = dirName.replace(".", "\\.");
	        dirName = dirName.replace("*", ".*");
	    }
	    // �f�B���N�g���`�F�b�N
	    File dir = new File(directoryPath);
	    if (!dir.exists()) {
	    	throw new IllegalArgumentException
	        ("�w�肳�ꂽ�p�X(" + dir.getAbsolutePath() + ")�����݂��܂���B");
	    }
	    if (!dir.isDirectory()) {
	        throw new IllegalArgumentException
	        ("�w�肳�ꂽ�p�X(" + dir.getAbsolutePath() + ")�̓f�B���N�g���ł͂���܂���B");
	    }
	    // �f�B���N�g�����̃f�B���N�g��������
	    File[] dirs = dir.listFiles();
	    for (int i=0; i<dirs.length; i++) {
	        File d = dirs[i];
	        if (!d.isDirectory()) continue;	// �f�B���N�g���łȂ��Ƃ��͉������Ȃ�
	        if (dirName != null && d.getName().matches(dirName)) {
	        	// �t�@�C�������}�b�`������OK
	        	dList.add(d);
	        }
	    }

	    return dList;
	}

	/**
	 * �ŏI�X�V�����̏����Ń\�[�g�����t�@�C���̃��X�g��Ԃ��܂�.
	 * @param path �f�B���N�g���p�X
	 * @param filter �t�B���^ null�̏ꍇ�t�B���^�����O�����̌��ʂ��Ԃ�܂�
	 * @return �t�@�C�����X�g
	 */
	public static List<File> getAscFileList(String path, String filter){
		return getAscFileList(path, filter, true);
	}

	/**
     * �ŏI�X�V�����̏����Ń\�[�g�����t�@�C���̃��X�g��Ԃ��܂�.
     * @param path �f�B���N�g���p�X
     * @param filter �t�B���^ null�̏ꍇ�t�B���^�����O�����̌��ʂ��Ԃ�܂��B
     * @param wildcard ���C���h�J�[�h�����̎g�p�L��(true:�g�p�^false:���g�p)
     * @return �t�@�C�����X�g
     */
    public static List<File> getAscFileList(String path, String filter, boolean wildcard) {
        List<File> files = getFileList(path, filter, wildcard);

        //��r�@�\�iComparable�������j�������t�@�C�����b�p
        DateAscFileWrapper [] fileWrappers = new DateAscFileWrapper[files.size()];
        for (int i=0; i<files.size(); i++) {
            fileWrappers[i] = new DateAscFileWrapper(files.get(i));
        }
        //�\�[�g���s��
        Arrays.sort(fileWrappers);
        //�\�[�g�����I�u�W�F�N�g����߂�l�ɃZ�b�g
        List<File> sortedFiles = new ArrayList<File>();
        for (int i=0; i<files.size(); i++) {
            sortedFiles.add(fileWrappers[i].getFile());
        }
        return sortedFiles;
    }

	/**
	 * �ŏI�X�V�����̍~���Ń\�[�g�����t�@�C���̃��X�g��Ԃ��܂�.
	 * @param path �f�B���N�g���p�X
	 * @param filter �t�B���^ null�̏ꍇ�t�B���^�����O�����̌��ʂ��Ԃ�܂�
	 * @return �t�@�C�����X�g
	 */
	public static List<File> getDescFileList(String path, String filter){
		return getDescFileList(path, filter, true);
	}

	   /**
     * �ŏI�X�V�����̍~���Ń\�[�g�����t�@�C���̃��X�g��Ԃ��܂�.
     * @param path �f�B���N�g���p�X
     * @param filter �t�B���^ null�̏ꍇ�t�B���^�����O�����̌��ʂ��Ԃ�܂��B
     * @param wildcard ���C���h�J�[�h�����̎g�p�L��(true:�g�p�^false:���g�p)
     * @return �t�@�C�����X�g
     */
    public static List<File> getDescFileList(String path, String filter, boolean wildcard){
        List<File> files = getFileList(path, filter, wildcard);

        //��r�@�\�iComparable�������j�������t�@�C�����b�p
        DateDescFileWrapper [] fileWrappers = new DateDescFileWrapper[files.size()];
        for (int i=0; i<files.size(); i++) {
            fileWrappers[i] = new DateDescFileWrapper(files.get(i));
        }
        //�\�[�g���s��
        Arrays.sort(fileWrappers);
        //�\�[�g�����I�u�W�F�N�g����߂�l�ɃZ�b�g
        List<File> sortedFiles = new ArrayList<File>();
        for (int i=0; i<files.size(); i++) {
            sortedFiles.add(fileWrappers[i].getFile());
        }
        return sortedFiles;
    }

	/**
	 * �t�@�C�����X�g�̒��ōł��X�V�������ł��Â��t�@�C�����擾.
	 *
	 * @param fileList �t�@�C�����X�g
	 * @return ��ԌÂ��t�@�C���I�u�W�F�N�g�B���݂��Ȃ��ꍇ��NULL
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
	 * �f�B���N�g�����̃t�@�C���p�^�[���Ɉ�v����t�@�C���̒���
	 * �X�V�������ł��Â��t�@�C�����擾.
	 *
	 * @param directoryPath �����Ώۂ̃f�B���N�g����\���p�X
	 * @param fileName �����Ώۂ̃t�@�C����
	 *                 �t�@�C�����ɂ̓��C���h�J�[�h�����Ƃ���*���w��\
	 * @return  �X�V�������ł��Â��t�@�C��
	 *
	 */
	public static File getOldestFile(String directoryPath, String fileName) {
		return getOldestFile(getFileList(directoryPath, fileName));
	}

	/**
	 * �t�@�C���̓Ǎ��݁A������ɂ��ĕԂ��܂��B<br>
	 * charset�֎w�肳�ꂽ�G���R�[�h�����œǍ��݂܂��B
	 * @param file �t�@�C��
	 * @param charset �L�����Z�b�g
	 * @return String �t�@�C�����e������
	 * @throws IOException I/O��O
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
	 * �t�@�C���̓Ǎ��݁A������ɂ��ĕԂ��܂�.<br>
	 * UTF-8�Ƃ��ēǍ��݂܂�.
	 * @param file �t�@�C��
	 * @return String �t�@�C�����e������
	 * @throws IOException I/O��O
	 */
	public static String readFile(File file) throws IOException {
		return readFile(file, ConstUtil.CHARSET_UTF8);
	}

	/**
	 * �t�@�C�����R�s�[���܂�.
	 * @param oldFile �R�s�[���t�@�C��
	 * @param newFile �R�s�[��t�@�C��
	 * @throws IOException I/O��O
	 */
	public static void copyFile(File oldFile, File newFile) throws IOException{
		FileChannel ifc = null;
		FileChannel ofc = null;
		try {
			// ���͌��t�@�C���̃X�g���[������`���l�����擾
			ifc = new FileInputStream(oldFile).getChannel();

			// �o�͐�t�@�C���̃`���l�����擾
			ofc = new FileOutputStream(newFile).getChannel();

			// �o�C�g��]�����܂��B
			ifc.transferTo(0, ifc.size(), ofc);
		} finally {
			if (ifc != null){ifc.close();}
			if (ofc != null){ ofc.close();}
		}
	}

	/**
	 * �t�@�C���̑��݊m�F.
	 *
	 * @param filePath �t�@�C���p�X
	 * @return true:���݁^false:����
	 */
	public static boolean isExists(String filePath) {
		return isExists(new File(filePath));
	}

	/**
	 * �t�@�C���̑��݊m�F.
	 *
	 * @param file �t�@�C���I�u�W�F�N�g
	 * @return true:���݁^false:����
	 */
	public static boolean isExists(File file) {
		return file.exists();
	}

	/**
	 * �w�肳�ꂽ�t�@�C�����o�͂��܂��B<br>
	 * data��null�̏ꍇ�A��̃t�@�C�����쐬����܂��B<br>
	 *
	 * @param file		�t�@�C��
	 * @param data		�f�[�^
	 * @param charset	�L�����Z�b�g
	 * @param append	�A�y���h�ŏo�͂̏ꍇtrue
	 * @throws IOException I/O��O
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
	 * �w�肳�ꂽ�p�X�փt�@�C�����o�͂��܂��B<br>
	 * data��null�̏ꍇ�A��̃t�@�C�����쐬����܂��B<br>
	 *
	 * @param filePath �t�@�C���p�X
	 * @param data �f�[�^
	 * @throws IOException I/O��O
	 */
	public static void writeFile(String filePath, String data) throws IOException{
		writeFile(new File(filePath), data);
	}

	/**
	 * �w�肳�ꂽ�t�@�C�����o�͂��܂��B<br>
	 * data��null�̏ꍇ�A��̃t�@�C�����쐬����܂��B<br>
	 * Shift_JIS�G���R�[�h�����ŏo�͂��܂��B
	 *
	 * @param file �t�@�C��
	 * @param data �f�[�^
	 * @throws IOException I/O��O
	 */
	public static void writeFile(File file, String data) throws IOException{
		writeFile(file, data, ConstUtil.DEFAULT_ENCODE, false);
	}

	/**
	 * �w�肵���f�B���N�g�����̃t�@�C����S��zip�Ɉ��k
	 * @param tergetDir �Ώۃf�B���N�g��
	 * @param zipPathName �쐬����zip�t�@�C���i�t���p�X�j
	 */
	public static void createZip(String tergetDir, String zipPathName) {
		File zip = new File(zipPathName);
		File target = new File(tergetDir);
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(new FileOutputStream(zip));
			archive(zos, zip, target);
		} catch (FileNotFoundException e) {
			//throw new AppException("�t�@�C�����k�G���[�@�Ώۃf�B���N�g��=" + tergetDir + " ���k�t�@�C����=" + zipPathName);
		} finally {
			if (zos != null) {
				try {zos.closeEntry();	} catch (IOException e) {}
				try {zos.flush();		} catch (IOException e) {}
				try {zos.close();		} catch (IOException e) {}
			}
		}
	}

	/**
	 * �t�@�C�����k
	 * @param zos ZipOutputStream
	 * @param zip zip�t�@�C���I�u�W�F�N�g
	 * @param target ���k�ΏۃI�u�W�F�N�g
	 */
	private static void archive(ZipOutputStream zos, File zip, File target) {

		if (target.isDirectory()) {
			File[] targetFiles = target.listFiles();
			for (File targetFile : targetFiles) {
				if (targetFile.isDirectory()) {
					//�t�H���_�̏ꍇ�͍ċA����
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
						//throw new AppException("�t�@�C�����k�G���[");
					} finally{
						if (bis != null) {try {bis.close();} catch (IOException e) {}}
						try {zos.closeEntry();	} catch (IOException e) {}
					}
				}
			}
		}
	}

   /**
     * �t�H���_�E�t�@�C�����폜����B<br>
     * �t�H���_���Ƀt�@�C����T�u�t�H���_�����݂���ꍇ���폜����B<br>
     * �w��File��null�`�F�b�N�͖{�������ł͍s��Ȃ��ׁA�R�[���O�Ƀ`�F�b�N�����鎖�B<br>
     *
     * @param path �t�@�C���^�f�B���N�g���p�X
     * @return boolean true:�����^false:���s
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
     * �t�H���_�E�t�@�C�����폜����B<br>
     * �t�H���_���Ƀt�@�C����T�u�t�H���_�����݂���ꍇ���폜����B<br>
     * �w��File��null�`�F�b�N�͖{�������ł͍s��Ȃ��ׁA�R�[���O�Ƀ`�F�b�N�����鎖�B<br>
     *
     * @param target �t�@�C���^�f�B���N�g���p�X
     * @return boolean true:�����^false:���s
     */
    public static boolean deleteAll(File target){
        boolean result = false;

        if(target.isFile()){
            // �Ώۂ��t�@�C���̏ꍇ�͍폜
            result = target.delete();
        }else if(target.isDirectory()){
            // �Ώۂ��t�H���_�̏ꍇ�ɂ́A�t�H���_���̃t�@�C�����X�g�擾
            File[] fileList = target.listFiles();
            for(File f : fileList){
                // �����\�b�h���ċA�I�ɌĂ�
                result = deleteAll(f.getPath());
                // ���s���Ԃ��ꂽ�ꍇ�́A���s��Ԃ�
                if(!result){
                    return result;
                }
            }
            // �����t�H���_�E�t�@�C�����폜��Ƀt�H���_�폜
            result = target.delete();
        }
        return result;
    }

    /**
     * �t�H���_���̃t�@�C�����폜����.<br>
     * �����Ɏw��ł���̂̓t�H���_�p�X�̂�.<br>
     * �w��File��null�`�F�b�N�͖{�������ł͍s��Ȃ��ׁA�R�[���O�Ƀ`�F�b�N�����鎖.<br>
     * @param path �f�B���N�g���p�X
     * @return boolean true:�����^false:���s
     */
    public static boolean deleteFiles(String path) {
        File target = getFileInstance(path);
        return deleteFiles(target);
    }

    /**
     * �t�H���_���̃t�@�C�����폜����.<br>
     * �����Ɏw��ł���̂̓t�H���_�p�X�̂�.<br>
     * �w��File��null�`�F�b�N�͖{�������ł͍s��Ȃ��ׁA�R�[���O�Ƀ`�F�b�N�����鎖.<br>
     * @param target �f�B���N�g���p�X
     * @return boolean true:�����^false:���s
     */
    public static boolean deleteFiles(File target) {
        boolean result = false;

        if (target.isFile()) {
            // �Ώۂ��t�@�C���̏ꍇ�͉������Ȃ�
            return false;
        }
        if(target.isDirectory()){
            // �Ώۂ��t�H���_�̏ꍇ�ɂ́A�t�H���_���̃t�@�C�����X�g�擾
            File[] fileList = target.listFiles();
            for(File f : fileList){
                // �t�@�C���݂̂��폜
                if (f.isFile()) {
                    result = f.delete();
                    // ���s���Ԃ��ꂽ�ꍇ�́A���s��Ԃ�
                    if (!result) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * �t�@�C���̖��O��ύX���܂�.<br>
     * �ύX��t�@�C���̔z�u�t�H���_���Ȃ��ꍇ�ɂ͍쐬����.<br>
     * �ύX��t�@�C�������ɑ��݂���ꍇ�ɂ́A�폜������Ƀt�@�C�����ύX���s��.<br>
     *
     * rename���t�@�C���͂Ȃ��Ȃ�܂�.<br>
     * @param oldFile �ύX��
     * @param newFile �ύX��
     * @return ���O�̕ύX�����������ꍇ�� true�A�����łȂ��ꍇ�� false
     * @throws IOException I/O��O
     */
    public static boolean renameFile(File oldFile, File newFile) throws IOException{
        boolean result = true;
        // ���l�[����̃t�H���_�Ɗ����t�@�C�����m�F
        if(!newFile.getParentFile().exists()){
            result = newFile.getParentFile().mkdirs();
        }else{
            if(newFile.exists()){
                result = newFile.delete();
            }
        }

        if(result){
            // �R�s�[����
            FileUtil.copyFile(oldFile, newFile);
            // �Â��t�@�C�����폜����
            result = oldFile.delete();
        }
        return result;
    }

    /**
     * �t�@�C���̖��O��ύX���܂�.<br>
     * rename���t�@�C���͂Ȃ��Ȃ�܂�.<br>
     * @param oldPath �ύX��
     * @param newPath �ύX��
     * @return ���O�̕ύX�����������ꍇ�� true�A�����łȂ��ꍇ�� false
     * @throws IOException I/O��O
     */
    public static boolean renameFile(String oldPath, String newPath) throws IOException{
        return renameFile(getFileInstance(oldPath), getFileInstance(newPath));
    }

    /**
     * �t�@�C���̃o�C�g�T�C�Y���擾����.
     * @param file �t�@�C��
     * @return �t�@�C���̃o�C�g�T�C�Y
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
     * �t�@�C���̃o�C�g�T�C�Y���擾����.
     * @param filePath �t�@�C���p�X
     * @return �t�@�C���̃o�C�g�T�C�Y
     */
    public static Long getFileByteSize(String filePath){
        if(StringUtil.isEmpty(filePath)){
            return 0L;
        }
        return getFileByteSize(getFileInstance(filePath));
    }

    /**
     * File�I�u�W�F�N�g�𐶐����܂�.
     * @param path �t�@�C���p�X
     * @return File
     */
    public static File getFileInstance(String path){
        return new File(path);
    }

    /**
     * �f�B���N�g���̍쐬.
     * �e�f�B���N�g�������݂��Ȃ��ꍇ�A�쐬����.
     *
     * @param dirPath �f�B���N�g���p�X
     * @return true:���� / false:���s
     */
    public static boolean makeDir(String dirPath) {
        // null�`�F�b�N
        if (dirPath == null || dirPath.length() == 0) {
            return false;
        }

        File dir = getFileInstance(dirPath);
        return makeDir(dir);
    }

    /**
     * �f�B���N�g���̍쐬.
     * �e�f�B���N�g�������݂��Ȃ��ꍇ�A�쐬����.
     *
     * @param dir �f�B���N�g���p�X(File�I�u�W�F�N�g)
     * @return true:���� / false:���s
     */
    public static boolean makeDir(File dir) {
        if (dir == null) {
            return false;
        }

        // ���łɑ��݂�����I��
        if (dir.exists()) {
            return true;    // ���݂��Ă���̂�true
        }

        // �f�B���N�g���쐬
        return dir.mkdirs();
    }

    /**
     * �J�����g�f�B���N�g���̃p�X���擾.
     *
     * @return �J�����g�f�B���N�g���̃p�X
     */
    public static String getCurrentPath() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    /**
     * �N���X�p�X��ɂ���t�@�C���̃t���p�X���擾.
     *
     * @param fileName �t�@�C����
     * @return �t���p�X
     */
    public static String getFilePath(String fileName) {
        FileUtil.class.getClassLoader();
        FileUtil.class.getClassLoader().getResource(fileName);
        return FileUtil.class.getClassLoader().getResource(fileName).getPath();
    }

    /**
     * �t�@�C���̍ŏI�X�V�������擾.
     *
     * @param filePath �t�@�C���̃t���p�X
     * @return long�^���t
     */
    public static long getFileLastModify(String filePath) {
        if (isExists(filePath)) {
            return getFileInstance(filePath).lastModified();
        }

        return 0;
    }
}
