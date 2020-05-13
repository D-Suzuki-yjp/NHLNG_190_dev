package job.common.nhlngCommon.dto;

import java.util.List;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/9 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * HoureHistoryDto 瞬時トレンドDTO<br>
 * String tagNo タグNo<br>
 * HoureHistory houreHistory トレンドデータ<br>
 * String HoureHistory.value 値<br>
 * String HoureHistory.collectDate 収集日時<br>
 * @author D.Suzuki
 */
 public class HourHistoryDto{

    /**
     * タグNo
     */
    private String tagNo;

    /**
     * 時締データ
     */
    private List<HourHistory> hourHistoryList;


    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public List<HourHistory> getCurrentTrendList() {
        return hourHistoryList;
    }

    public void setCurrentTrendList(List<HourHistory> hourHistoryList) {
        this.hourHistoryList = hourHistoryList;
    }

    public class HourHistory extends CoreTagDataDto{
    }
}