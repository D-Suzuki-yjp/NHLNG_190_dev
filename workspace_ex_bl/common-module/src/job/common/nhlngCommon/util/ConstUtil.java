package job.common.nhlngCommon.util;

/**
 * �萔�ێ��p�N���X.
 *
 * @author kumagai.
 *
 */
public class ConstUtil {

	/** �R���X�g���N�^. */
	private ConstUtil() {}

	/** �f�t�H���g�����R�[�h. */
	public static final String DEFAULT_ENCODE = "Shift_JIS";
    /** �L�����N�^�Z�b�g(UTF-8). */
    public static final String CHARSET_UTF8 = "UTF-8";
    /** �L�����N�^�Z�b�g(Shift-JIS). */
    public static final String CHARSET_SJIS = "Shift_JIS";
    /** �L�����N�^�Z�b�g(MS932). */
    public static final String CHARSET_MS932 = "MS932";
    /** �L�����N�^�Z�b�g(Windows-31J). */
    public static final String CHARSET_WIN31J = "Windows-31J";

    /** �p�X�Z�p���[�^. */
    public static final String PATH_SEPARATOR = "/";
    /** ���s. */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /** �t�@�C���G���R�[�h. */
    public static final String FILE_ENCODING = System.getProperty("file.encoding");
    /** �^�u. */
    public static final String TAB = "\t";

    /** �t���O���. */
    public static enum FLAG {
        /** OFF. */
        OFF("0"),
        /** ON. */
        ON("1");

        /** �l. */
        private String value;

        /**
         * �R���X�g���N�^.
         * @param value �l
         */
        FLAG(String value) {
            this.value = value;
        }

        /**
         * �l�̎擾.
         * @return �l
         */
        public String getValue() {
            return this.value;
        }
    }

	/** �t�@�C�������݂��܂���B */
	public static final String E00001 = "E00001";
	/** �t�@�C���ǂݏ������s�B */
	public static final String E00002 = "E00002";

}
