package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmmCalc;
import job.sfcommon.dataaccess.entity.nhlng.CmmCalcExample;

public interface CmmCalcMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_calc
     *
     * @mbg.generated
     */
    long countByExample(CmmCalcExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_calc
     *
     * @mbg.generated
     */
    List<CmmCalc> selectByExample(CmmCalcExample example);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param historyKind  帳票区分
	 * @return CmmCalc 計算マスタ
	 */
    CmmCalc selectByPrimaryKey(@Param("historyKind") Integer historyKind);
}