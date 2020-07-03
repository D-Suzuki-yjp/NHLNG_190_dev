package job.sfcommon.dto;
/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/9 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * HoureHistoryDto LooponEx日締データDTO<br>
 * String tagNo タグNo<br>
 * HoureHistory houreHistory トレンドデータ<br>
 * String HoureHistory.value 値<br>
 * String HoureHistory.collectDate 収集日時<br>
 * @author D.Suzuki
 */

import java.util.Date;

/** LooponEx日締データDTO */
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