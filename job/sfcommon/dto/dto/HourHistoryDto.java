package job.sfcommon.dto;

import java.util.Date;

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
 public class HourHistoryDto extends CoreTagDataDto{

    /**
     * 締め日時
     */
    private Date historyDate;

    public Date getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }
}