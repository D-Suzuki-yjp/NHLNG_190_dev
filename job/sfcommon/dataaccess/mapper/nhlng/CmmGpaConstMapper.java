package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmmGpaConst;
import job.sfcommon.dataaccess.entity.nhlng.CmmGpaConstExample;

public interface CmmGpaConstMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_gpa_const
     *
     * @mbg.generated
     */
    long countByExample(CmmGpaConstExample example);

     /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_gpa_const
     *
     * @mbg.generated
     */
    List<CmmGpaConst> selectByExample(CmmGpaConstExample example);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param cmpnt  成分
	 * @return CmmGpaConst 燃焼速度マスタ
	 */
    CmmGpaConst selectByPrimaryKey(@Param("cmpnt") Integer cmpnt);
}