package job.sfcommon.dataaccess.entity.looponexCore;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgLatestDataEntryInfoKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_latest_data_entry_info.history_kind
     *
     * @mbg.generated
     */
    private Integer historyKind;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_latest_data_entry_info.group_no
     *
     * @mbg.generated
     */
    private Integer groupNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_latest_data_entry_info.history_kind
     *
     * @return the value of public.slg_latest_data_entry_info.history_kind
     *
     * @mbg.generated
     */
    public Integer getHistoryKind() {
        return historyKind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_latest_data_entry_info.history_kind
     *
     * @param historyKind the value for public.slg_latest_data_entry_info.history_kind
     *
     * @mbg.generated
     */
    public void setHistoryKind(Integer historyKind) {
        this.historyKind = historyKind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_latest_data_entry_info.group_no
     *
     * @return the value of public.slg_latest_data_entry_info.group_no
     *
     * @mbg.generated
     */
    public Integer getGroupNo() {
        return groupNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_latest_data_entry_info.group_no
     *
     * @param groupNo the value for public.slg_latest_data_entry_info.group_no
     *
     * @mbg.generated
     */
    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }
}