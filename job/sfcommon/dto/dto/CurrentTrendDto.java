package job.sfcommon.dto;

import java.util.List;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/6 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * TrendDataDto 瞬時トレンドDTO<br>
 * String tagNo タグNo<br>
 * CurrentTrend currentTrend トレンドデータ<br>
 * String CurrentTrend.value 値<br>
 * String CurrentTrend.collectDate 収集日時<br>
 * @author D.Suzuki
 */
 public class CurrentTrendDto{

    /**
     * タグNo
     */
    private String tagNo;

    /**
     * トレンドデータ
     */
    private List<CurrentTrend> currentTrendList;


    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public List<CurrentTrend> getCurrentTrendList() {
        return currentTrendList;
    }

    public void setCurrentTrendList(List<CurrentTrend> currentTrendList) {
        this.currentTrendList = currentTrendList;
    }

    public class CurrentTrend extends CoreTagDataDto{
    }
}