package job.common.nhlngCommon.util;

import java.io.File;


/**
 * �t�@�C���̍ŏI�X�V�����̍~���Ń\�[�g�Ɏg�p���܂�.<br>
 *
 * @author kumagai.
 */
public class DateDescFileWrapper extends FileWrapper{

	/**
	 * �R���X�g���N�^.
	 * @param file �t�@�C��
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
			return 1;	//�������ꍇ
		} else if (this.file.lastModified() > castFile.lastModified()) {
			return -1;	//�傫���ꍇ
		} else {
			return 0;	//�������ꍇ
		}
	}


	@Override
	public boolean equals(Object obj){
		assert obj instanceof DateDescFileWrapper;

		DateDescFileWrapper castObj = (DateDescFileWrapper)obj;
		File castFile = castObj.getFile();

		if (this.file.lastModified() == castFile.lastModified()) {
			return true;	//�������ꍇ
		}
		return false;
	}

	@Override
	public int hashCode() {
		assert false : "hashCode���Ăяo����邱�Ƃ͑z�肳��Ă��܂���B";
	return 42; // �K���Ȓl
	}

}
