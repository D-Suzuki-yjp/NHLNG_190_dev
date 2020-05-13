package job.common.nhlngCommon.util;

import java.io.File;


/**
 * �\�[�g�@�\�N���X�̊��N���X.<br>
 *
 * @author kumagai.
 */
public abstract class FileWrapper implements Comparable<Object>{

	/** File */
	protected File file;

	/**
	 * �R���X�g���N�^
	 * @param file �t�@�C��
	 */
	public FileWrapper(File file){
		this.file = file;
	}

	/**
	 * ��r�̎d�����������܂�.<br>
	 * �S�ẴT�u�N���X�ɂ��̃��\�b�h�����������܂�.
	 */
	public abstract int compareTo(Object obj);

	/**
	 * �t�@�C����Ԃ��܂��B
	 * @return file �t�@�C��
	 */
	public File getFile() {
		return this.file;
	}

}
