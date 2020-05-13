package job.common.nhlngCommon.dataAccess.entity.nhlng;

import java.math.BigDecimal;
import java.util.Date;

public class CmmBurnSpd {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.cmpnt
     *
     * @mbg.generated
     */
    private Integer cmpnt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.burn_spd
     *
     * @mbg.generated
     */
    private Integer burnSpd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.coef1
     *
     * @mbg.generated
     */
    private BigDecimal coef1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.coef2
     *
     * @mbg.generated
     */
    private BigDecimal coef2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.last_upd_user
     *
     * @mbg.generated
     */
    private String lastUpdUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.last_upd_dtime
     *
     * @mbg.generated
     */
    private Date lastUpdDtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.cmm_burn_spd.delete_flag
     *
     * @mbg.generated
     */
    private BigDecimal deleteFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.cmpnt
     *
     * @return the value of public.cmm_burn_spd.cmpnt
     *
     * @mbg.generated
     */
    public Integer getCmpnt() {
        return cmpnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.cmpnt
     *
     * @param cmpnt the value for public.cmm_burn_spd.cmpnt
     *
     * @mbg.generated
     */
    public void setCmpnt(Integer cmpnt) {
        this.cmpnt = cmpnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.burn_spd
     *
     * @return the value of public.cmm_burn_spd.burn_spd
     *
     * @mbg.generated
     */
    public Integer getBurnSpd() {
        return burnSpd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.burn_spd
     *
     * @param burnSpd the value for public.cmm_burn_spd.burn_spd
     *
     * @mbg.generated
     */
    public void setBurnSpd(Integer burnSpd) {
        this.burnSpd = burnSpd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.coef1
     *
     * @return the value of public.cmm_burn_spd.coef1
     *
     * @mbg.generated
     */
    public BigDecimal getCoef1() {
        return coef1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.coef1
     *
     * @param coef1 the value for public.cmm_burn_spd.coef1
     *
     * @mbg.generated
     */
    public void setCoef1(BigDecimal coef1) {
        this.coef1 = coef1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.coef2
     *
     * @return the value of public.cmm_burn_spd.coef2
     *
     * @mbg.generated
     */
    public BigDecimal getCoef2() {
        return coef2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.coef2
     *
     * @param coef2 the value for public.cmm_burn_spd.coef2
     *
     * @mbg.generated
     */
    public void setCoef2(BigDecimal coef2) {
        this.coef2 = coef2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.last_upd_user
     *
     * @return the value of public.cmm_burn_spd.last_upd_user
     *
     * @mbg.generated
     */
    public String getLastUpdUser() {
        return lastUpdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.last_upd_user
     *
     * @param lastUpdUser the value for public.cmm_burn_spd.last_upd_user
     *
     * @mbg.generated
     */
    public void setLastUpdUser(String lastUpdUser) {
        this.lastUpdUser = lastUpdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.last_upd_dtime
     *
     * @return the value of public.cmm_burn_spd.last_upd_dtime
     *
     * @mbg.generated
     */
    public Date getLastUpdDtime() {
        return lastUpdDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.last_upd_dtime
     *
     * @param lastUpdDtime the value for public.cmm_burn_spd.last_upd_dtime
     *
     * @mbg.generated
     */
    public void setLastUpdDtime(Date lastUpdDtime) {
        this.lastUpdDtime = lastUpdDtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.cmm_burn_spd.delete_flag
     *
     * @return the value of public.cmm_burn_spd.delete_flag
     *
     * @mbg.generated
     */
    public BigDecimal getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.cmm_burn_spd.delete_flag
     *
     * @param deleteFlag the value for public.cmm_burn_spd.delete_flag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(BigDecimal deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}