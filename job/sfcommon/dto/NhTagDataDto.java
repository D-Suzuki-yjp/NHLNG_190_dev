package job.sfcommon.dto;

import java.util.Date;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release Date ID/Name Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/7 30042453/D.Suzuki 初版 [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtCloseHourDto NH日締データDTO<br>
 * String tagNo タグNo<br>
 * CurrentTrend currentTrend トレンドデータ<br>
 * String CurrentTrend.value 値<br>
 * String CurrentTrend.collectDate 収集日時<br>
 *
 * @author D.Suzuki
 */
public class NhTagDataDto{

    /**
     * 締め日時(JobDb)
     */
    private Date closeDtime;

    /**
     * タグNo
     */
    private String tagNo;

    /**
     * タグ値(JobDb)
     */
    private String tagData;

    /**
     * 品質コード
     */
    private Integer qltyCd;

    /**
     * 収集日時(JobDb)
     */
    private Date collDTime;

    public Date getCloseDtime() {
        return closeDtime;
    }

    public void setCloseDtime(Date closeDtime) {
        this.closeDtime = closeDtime;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getTagData() {
        return tagData;
    }

    public void setTagData(String tagData) {
        this.tagData = tagData;
    }

    public Integer getQltyCd() {
        return qltyCd;
    }

    public void setQltyCd(Integer qltyCd) {
        this.qltyCd = qltyCd;
    }

    public Date getCollDTime() {
        return collDTime;
    }

    public void setCollDTime(Date collDTime) {
        this.collDTime = collDTime;
    }
}