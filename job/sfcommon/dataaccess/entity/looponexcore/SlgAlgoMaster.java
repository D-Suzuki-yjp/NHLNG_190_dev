package job.sfcommon.dataaccess.entity.looponexcore;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgAlgoMaster extends SlgAlgoMasterKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_algo_master.algorism_kind_name
     *
     * @mbg.generated
     */
    private String algorismKindName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.slg_algo_master.algo_parameter
     *
     * @mbg.generated
     */
    private String algoParameter;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_algo_master.algorism_kind_name
     *
     * @return the value of public.slg_algo_master.algorism_kind_name
     *
     * @mbg.generated
     */
    public String getAlgorismKindName() {
        return algorismKindName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_algo_master.algorism_kind_name
     *
     * @param algorismKindName the value for public.slg_algo_master.algorism_kind_name
     *
     * @mbg.generated
     */
    public void setAlgorismKindName(String algorismKindName) {
        this.algorismKindName = algorismKindName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.slg_algo_master.algo_parameter
     *
     * @return the value of public.slg_algo_master.algo_parameter
     *
     * @mbg.generated
     */
    public String getAlgoParameter() {
        return algoParameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.slg_algo_master.algo_parameter
     *
     * @param algoParameter the value for public.slg_algo_master.algo_parameter
     *
     * @mbg.generated
     */
    public void setAlgoParameter(String algoParameter) {
        this.algoParameter = algoParameter;
    }
}