package job.common.nhlngCommon.dataAccess.entity.nhlng;

import java.util.Date;

public class CmmScreen {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_screen.tag_no
     *
     * @mbg.generated
     */
    private String tagNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_screen.screen_id
     *
     * @mbg.generated
     */
    private String screenId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_screen.last_upd_user
     *
     * @mbg.generated
     */
    private String lastUpdUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_screen.last_upd_dtime
     *
     * @mbg.generated
     */
    private Date lastUpdDtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_screen.delete_flag
     *
     * @mbg.generated
     */
    private Integer deleteFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_screen.tag_no
     *
     * @return the value of public.cmm_screen.tag_no
     *
     * @mbg.generated
     */
    public String getTagNo() {
        return tagNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_screen.tag_no
     *
     * @param tagNo the value for public.cmm_screen.tag_no
     *
     * @mbg.generated
     */
    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_screen.screen_id
     *
     * @return the value of public.cmm_screen.screen_id
     *
     * @mbg.generated
     */
    public String getScreenId() {
        return screenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_screen.screen_id
     *
     * @param screenId the value for public.cmm_screen.screen_id
     *
     * @mbg.generated
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_screen.last_upd_user
     *
     * @return the value of public.cmm_screen.last_upd_user
     *
     * @mbg.generated
     */
    public String getLastUpdUser() {
        return lastUpdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_screen.last_upd_user
     *
     * @param lastUpdUser the value for public.cmm_screen.last_upd_user
     *
     * @mbg.generated
     */
    public void setLastUpdUser(String lastUpdUser) {
        this.lastUpdUser = lastUpdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_screen.last_upd_dtime
     *
     * @return the value of public.cmm_screen.last_upd_dtime
     *
     * @mbg.generated
     */
    public Date getLastUpdDtime() {
        return lastUpdDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_screen.last_upd_dtime
     *
     * @param lastUpdDtime the value for public.cmm_screen.last_upd_dtime
     *
     * @mbg.generated
     */
    public void setLastUpdDtime(Date lastUpdDtime) {
        this.lastUpdDtime = lastUpdDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_screen.delete_flag
     *
     * @return the value of public.cmm_screen.delete_flag
     *
     * @mbg.generated
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_screen.delete_flag
     *
     * @param deleteFlag the value for public.cmm_screen.delete_flag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}