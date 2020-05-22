package job.sfcommon.dto;

import java.util.Date;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/03/30 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CoreTagDataDto タグデータDTO(CoreDb)<br>
 * String tagNo タグNo<br>
 * String value 値<br>
 * Integer qltyCd 品質コード<br>
 * Date collectDate 収集日時
 * @author D.Suzuki
 */
public class CoreTagDataDto {
    /**
     * タグNo
     */
    private String tagNo;

    /**
     * 値(CoreDb)
     */
    private String value;

    /**
     * 品質コード
     */
    private Integer qltyCd;

    /**
     * 収集日時(CoreDb)
     */
    private Date collectDate;


    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getQltyCd() {
        return qltyCd;
    }

    public void setQltyCd(Integer qltyCd) {
        this.qltyCd = qltyCd;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }
}