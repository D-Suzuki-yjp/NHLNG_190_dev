package job.sfcommon.dataaccess.entity.looponexcore;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgAlgorismKindMaster {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_algorism_kind_master.algorism_kind_name
     *
     * @mbg.generated
     */
    private String algorismKindName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_algorism_kind_master.algorism_kind_id
     *
     * @mbg.generated
     */
    private Integer algorismKindId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_algorism_kind_master.algorism_type
     *
     * @mbg.generated
     */
    private Integer algorismType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_algorism_kind_master.algorism_kind_name
     *
     * @return the value of public.slg_algorism_kind_master.algorism_kind_name
     *
     * @mbg.generated
     */
    public String getAlgorismKindName() {
        return algorismKindName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_algorism_kind_master.algorism_kind_name
     *
     * @param algorismKindName the value for public.slg_algorism_kind_master.algorism_kind_name
     *
     * @mbg.generated
     */
    public void setAlgorismKindName(String algorismKindName) {
        this.algorismKindName = algorismKindName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_algorism_kind_master.algorism_kind_id
     *
     * @return the value of public.slg_algorism_kind_master.algorism_kind_id
     *
     * @mbg.generated
     */
    public Integer getAlgorismKindId() {
        return algorismKindId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_algorism_kind_master.algorism_kind_id
     *
     * @param algorismKindId the value for public.slg_algorism_kind_master.algorism_kind_id
     *
     * @mbg.generated
     */
    public void setAlgorismKindId(Integer algorismKindId) {
        this.algorismKindId = algorismKindId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_algorism_kind_master.algorism_type
     *
     * @return the value of public.slg_algorism_kind_master.algorism_type
     *
     * @mbg.generated
     */
    public Integer getAlgorismType() {
        return algorismType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_algorism_kind_master.algorism_type
     *
     * @param algorismType the value for public.slg_algorism_kind_master.algorism_type
     *
     * @mbg.generated
     */
    public void setAlgorismType(Integer algorismType) {
        this.algorismType = algorismType;
    }
}