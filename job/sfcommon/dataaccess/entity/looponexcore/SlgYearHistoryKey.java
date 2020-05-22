package job.sfcommon.dataaccess.entity.looponexcore;

import java.util.Date;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgYearHistoryKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_year_history.history_date
     *
     * @mbg.generated
     */
    private Date historyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_year_history.lcode
     *
     * @mbg.generated
     */
    private String lcode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_year_history.history_date
     *
     * @return the value of public.slg_year_history.history_date
     *
     * @mbg.generated
     */
    public Date getHistoryDate() {
        return historyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_year_history.history_date
     *
     * @param historyDate the value for public.slg_year_history.history_date
     *
     * @mbg.generated
     */
    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_year_history.lcode
     *
     * @return the value of public.slg_year_history.lcode
     *
     * @mbg.generated
     */
    public String getLcode() {
        return lcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_year_history.lcode
     *
     * @param lcode the value for public.slg_year_history.lcode
     *
     * @mbg.generated
     */
    public void setLcode(String lcode) {
        this.lcode = lcode;
    }
}