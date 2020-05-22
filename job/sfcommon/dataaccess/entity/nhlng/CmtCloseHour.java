package job.sfcommon.dataaccess.entity.nhlng;

import java.util.Date;

import javax.enterprise.context.Dependent;

@Dependent
public class CmtCloseHour extends CmmTagMasterV{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.close_dtime
     *
     * @mbg.generated
     */
    private Date closeDtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.tag_no
     *
     * @mbg.generated
     */
    private String tagNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.tag_data
     *
     * @mbg.generated
     */
    private String tagData;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.qlty_cd
     *
     * @mbg.generated
     */
    private Integer qltyCd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.coll_dtime
     *
     * @mbg.generated
     */
    private Date collDtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.last_upd_user
     *
     * @mbg.generated
     */
    private String lastUpdUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.last_upd_dtime
     *
     * @mbg.generated
     */
    private Date lastUpdDtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmt_close_hour.delete_flag
     *
     * @mbg.generated
     */
    private Integer deleteFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.close_dtime
     *
     * @return the value of public.cmt_close_hour.close_dtime
     *
     * @mbg.generated
     */
    public Date getCloseDtime() {
        return closeDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.close_dtime
     *
     * @param closeDtime the value for public.cmt_close_hour.close_dtime
     *
     * @mbg.generated
     */
    public void setCloseDtime(Date closeDtime) {
        this.closeDtime = closeDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.tag_no
     *
     * @return the value of public.cmt_close_hour.tag_no
     *
     * @mbg.generated
     */
    public String getTagNo() {
        return tagNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.tag_no
     *
     * @param tagNo the value for public.cmt_close_hour.tag_no
     *
     * @mbg.generated
     */
    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.tag_data
     *
     * @return the value of public.cmt_close_hour.tag_data
     *
     * @mbg.generated
     */
    public String getTagData() {
        return tagData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.tag_data
     *
     * @param tagData the value for public.cmt_close_hour.tag_data
     *
     * @mbg.generated
     */
    public void setTagData(String tagData) {
        this.tagData = tagData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.qlty_cd
     *
     * @return the value of public.cmt_close_hour.qlty_cd
     *
     * @mbg.generated
     */
    public Integer getQltyCd() {
        return qltyCd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.qlty_cd
     *
     * @param qltyCd the value for public.cmt_close_hour.qlty_cd
     *
     * @mbg.generated
     */
    public void setQltyCd(Integer qltyCd) {
        this.qltyCd = qltyCd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.coll_dtime
     *
     * @return the value of public.cmt_close_hour.coll_dtime
     *
     * @mbg.generated
     */
    public Date getCollDtime() {
        return collDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.coll_dtime
     *
     * @param collDtime the value for public.cmt_close_hour.coll_dtime
     *
     * @mbg.generated
     */
    public void setCollDtime(Date collDtime) {
        this.collDtime = collDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.last_upd_user
     *
     * @return the value of public.cmt_close_hour.last_upd_user
     *
     * @mbg.generated
     */
    public String getLastUpdUser() {
        return lastUpdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.last_upd_user
     *
     * @param lastUpdUser the value for public.cmt_close_hour.last_upd_user
     *
     * @mbg.generated
     */
    public void setLastUpdUser(String lastUpdUser) {
        this.lastUpdUser = lastUpdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.last_upd_dtime
     *
     * @return the value of public.cmt_close_hour.last_upd_dtime
     *
     * @mbg.generated
     */
    public Date getLastUpdDtime() {
        return lastUpdDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.last_upd_dtime
     *
     * @param lastUpdDtime the value for public.cmt_close_hour.last_upd_dtime
     *
     * @mbg.generated
     */
    public void setLastUpdDtime(Date lastUpdDtime) {
        this.lastUpdDtime = lastUpdDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmt_close_hour.delete_flag
     *
     * @return the value of public.cmt_close_hour.delete_flag
     *
     * @mbg.generated
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmt_close_hour.delete_flag
     *
     * @param deleteFlag the value for public.cmt_close_hour.delete_flag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}