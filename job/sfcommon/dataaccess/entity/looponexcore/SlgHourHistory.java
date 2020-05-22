package job.sfcommon.dataaccess.entity.looponexcore;

import java.util.Date;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgHourHistory extends SlgHourHistoryKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_hour_history.value
     *
     * @mbg.generated
     */
    private String value;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_hour_history.quality
     *
     * @mbg.generated
     */
    private Integer quality;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_hour_history.collect_date
     *
     * @mbg.generated
     */
    private Date collectDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_hour_history.value
     *
     * @return the value of public.slg_hour_history.value
     *
     * @mbg.generated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_hour_history.value
     *
     * @param value the value for public.slg_hour_history.value
     *
     * @mbg.generated
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_hour_history.quality
     *
     * @return the value of public.slg_hour_history.quality
     *
     * @mbg.generated
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_hour_history.quality
     *
     * @param quality the value for public.slg_hour_history.quality
     *
     * @mbg.generated
     */
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_hour_history.collect_date
     *
     * @return the value of public.slg_hour_history.collect_date
     *
     * @mbg.generated
     */
    public Date getCollectDate() {
        return collectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_hour_history.collect_date
     *
     * @param collectDate the value for public.slg_hour_history.collect_date
     *
     * @mbg.generated
     */
    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }
}