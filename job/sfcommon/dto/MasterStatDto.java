package job.sfcommon.dto;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/10 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * MasterStatDto 主従状態DTO<br>
 * String sccServerName SCCサーバ名<br>
 * int masterStatOneself 主従状態（自系）<br>
 * int masterStatOther 主従状態（他系）
 *
 * @author D.Suzuki
 */

/** 主従状態DTO */
public class MasterStatDto{
    /**
     * SCCサーバ名（自系）
     */
    private String sccServerNameOneself;

    /**
     * SCCサーバ名（他系）
     */
    private String sccServerNameOther;

    /**
     * 主従状態（自系）
     */
    private int masterStatOneself;

    /**
     * 主従状態（他系）
     */
    private int masterStatOther;


    public String getSccServerNameOneself() {
        return sccServerNameOneself;
    }

    public void setSccServerNameOneself(String sccServerNameOneself) {
        this.sccServerNameOneself = sccServerNameOneself;
    }

    public String getSccServerNameOther() {
        return sccServerNameOther;
    }

    public void setSccServerNameOther(String sccServerNameOther) {
        this.sccServerNameOther = sccServerNameOther;
    }

    public int getMasterStatOneself() {
        return masterStatOneself;
    }

    public void setMasterStatOneself(int masterStatOneself) {
        this.masterStatOneself = masterStatOneself;
    }

    public int getMasterStatOther() {
        return masterStatOther;
    }

    public void setMasterStatOther(int masterStatOther) {
        this.masterStatOther = masterStatOther;
    }
}