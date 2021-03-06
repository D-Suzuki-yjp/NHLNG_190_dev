package job.sfcommon.dataaccess.entity.looponexcore;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgCollectGroupMaster {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_group_no
     *
     * @mbg.generated
     */
    private Integer collectGroupNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.subsystem_id
     *
     * @mbg.generated
     */
    private String subsystemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_stop_flag
     *
     * @mbg.generated
     */
    private Integer collectStopFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_datasource
     *
     * @mbg.generated
     */
    private String collectDatasource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_forth_class
     *
     * @mbg.generated
     */
    private String collectForthClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_back_class
     *
     * @mbg.generated
     */
    private String collectBackClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.current_trend_forth_class
     *
     * @mbg.generated
     */
    private String currentTrendForthClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.current_trend_back_class
     *
     * @mbg.generated
     */
    private String currentTrendBackClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_cycle
     *
     * @mbg.generated
     */
    private Integer collectCycle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.collect_join_no
     *
     * @mbg.generated
     */
    private Integer collectJoinNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.auto_tag_sync_flag
     *
     * @mbg.generated
     */
    private Integer autoTagSyncFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.auto_modbus_address_flag
     *
     * @mbg.generated
     */
    private Integer autoModbusAddressFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_collect_group_master.not_collect_data_throw_flag
     *
     * @mbg.generated
     */
    private Integer notCollectDataThrowFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_group_no
     *
     * @return the value of public.slg_collect_group_master.collect_group_no
     *
     * @mbg.generated
     */
    public Integer getCollectGroupNo() {
        return collectGroupNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_group_no
     *
     * @param collectGroupNo the value for public.slg_collect_group_master.collect_group_no
     *
     * @mbg.generated
     */
    public void setCollectGroupNo(Integer collectGroupNo) {
        this.collectGroupNo = collectGroupNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.subsystem_id
     *
     * @return the value of public.slg_collect_group_master.subsystem_id
     *
     * @mbg.generated
     */
    public String getSubsystemId() {
        return subsystemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.subsystem_id
     *
     * @param subsystemId the value for public.slg_collect_group_master.subsystem_id
     *
     * @mbg.generated
     */
    public void setSubsystemId(String subsystemId) {
        this.subsystemId = subsystemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_stop_flag
     *
     * @return the value of public.slg_collect_group_master.collect_stop_flag
     *
     * @mbg.generated
     */
    public Integer getCollectStopFlag() {
        return collectStopFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_stop_flag
     *
     * @param collectStopFlag the value for public.slg_collect_group_master.collect_stop_flag
     *
     * @mbg.generated
     */
    public void setCollectStopFlag(Integer collectStopFlag) {
        this.collectStopFlag = collectStopFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_datasource
     *
     * @return the value of public.slg_collect_group_master.collect_datasource
     *
     * @mbg.generated
     */
    public String getCollectDatasource() {
        return collectDatasource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_datasource
     *
     * @param collectDatasource the value for public.slg_collect_group_master.collect_datasource
     *
     * @mbg.generated
     */
    public void setCollectDatasource(String collectDatasource) {
        this.collectDatasource = collectDatasource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_forth_class
     *
     * @return the value of public.slg_collect_group_master.collect_forth_class
     *
     * @mbg.generated
     */
    public String getCollectForthClass() {
        return collectForthClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_forth_class
     *
     * @param collectForthClass the value for public.slg_collect_group_master.collect_forth_class
     *
     * @mbg.generated
     */
    public void setCollectForthClass(String collectForthClass) {
        this.collectForthClass = collectForthClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_back_class
     *
     * @return the value of public.slg_collect_group_master.collect_back_class
     *
     * @mbg.generated
     */
    public String getCollectBackClass() {
        return collectBackClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_back_class
     *
     * @param collectBackClass the value for public.slg_collect_group_master.collect_back_class
     *
     * @mbg.generated
     */
    public void setCollectBackClass(String collectBackClass) {
        this.collectBackClass = collectBackClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.current_trend_forth_class
     *
     * @return the value of public.slg_collect_group_master.current_trend_forth_class
     *
     * @mbg.generated
     */
    public String getCurrentTrendForthClass() {
        return currentTrendForthClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.current_trend_forth_class
     *
     * @param currentTrendForthClass the value for public.slg_collect_group_master.current_trend_forth_class
     *
     * @mbg.generated
     */
    public void setCurrentTrendForthClass(String currentTrendForthClass) {
        this.currentTrendForthClass = currentTrendForthClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.current_trend_back_class
     *
     * @return the value of public.slg_collect_group_master.current_trend_back_class
     *
     * @mbg.generated
     */
    public String getCurrentTrendBackClass() {
        return currentTrendBackClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.current_trend_back_class
     *
     * @param currentTrendBackClass the value for public.slg_collect_group_master.current_trend_back_class
     *
     * @mbg.generated
     */
    public void setCurrentTrendBackClass(String currentTrendBackClass) {
        this.currentTrendBackClass = currentTrendBackClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_cycle
     *
     * @return the value of public.slg_collect_group_master.collect_cycle
     *
     * @mbg.generated
     */
    public Integer getCollectCycle() {
        return collectCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_cycle
     *
     * @param collectCycle the value for public.slg_collect_group_master.collect_cycle
     *
     * @mbg.generated
     */
    public void setCollectCycle(Integer collectCycle) {
        this.collectCycle = collectCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.collect_join_no
     *
     * @return the value of public.slg_collect_group_master.collect_join_no
     *
     * @mbg.generated
     */
    public Integer getCollectJoinNo() {
        return collectJoinNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.collect_join_no
     *
     * @param collectJoinNo the value for public.slg_collect_group_master.collect_join_no
     *
     * @mbg.generated
     */
    public void setCollectJoinNo(Integer collectJoinNo) {
        this.collectJoinNo = collectJoinNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.auto_tag_sync_flag
     *
     * @return the value of public.slg_collect_group_master.auto_tag_sync_flag
     *
     * @mbg.generated
     */
    public Integer getAutoTagSyncFlag() {
        return autoTagSyncFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.auto_tag_sync_flag
     *
     * @param autoTagSyncFlag the value for public.slg_collect_group_master.auto_tag_sync_flag
     *
     * @mbg.generated
     */
    public void setAutoTagSyncFlag(Integer autoTagSyncFlag) {
        this.autoTagSyncFlag = autoTagSyncFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.auto_modbus_address_flag
     *
     * @return the value of public.slg_collect_group_master.auto_modbus_address_flag
     *
     * @mbg.generated
     */
    public Integer getAutoModbusAddressFlag() {
        return autoModbusAddressFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.auto_modbus_address_flag
     *
     * @param autoModbusAddressFlag the value for public.slg_collect_group_master.auto_modbus_address_flag
     *
     * @mbg.generated
     */
    public void setAutoModbusAddressFlag(Integer autoModbusAddressFlag) {
        this.autoModbusAddressFlag = autoModbusAddressFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_collect_group_master.not_collect_data_throw_flag
     *
     * @return the value of public.slg_collect_group_master.not_collect_data_throw_flag
     *
     * @mbg.generated
     */
    public Integer getNotCollectDataThrowFlag() {
        return notCollectDataThrowFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_collect_group_master.not_collect_data_throw_flag
     *
     * @param notCollectDataThrowFlag the value for public.slg_collect_group_master.not_collect_data_throw_flag
     *
     * @mbg.generated
     */
    public void setNotCollectDataThrowFlag(Integer notCollectDataThrowFlag) {
        this.notCollectDataThrowFlag = notCollectDataThrowFlag;
    }
}