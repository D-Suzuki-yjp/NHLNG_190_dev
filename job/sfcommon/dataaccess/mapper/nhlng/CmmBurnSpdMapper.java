package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import job.sfcommon.dataaccess.entity.nhlng.CmmBurnSpd;
import job.sfcommon.dataaccess.entity.nhlng.CmmBurnSpdExample;

public interface CmmBurnSpdMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_burn_spd
     *
     * @mbg.generated
     */
    long countByExample(CmmBurnSpdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_burn_spd
     *
     * @mbg.generated
     */
    List<CmmBurnSpd> selectByExample(CmmBurnSpdExample example);
}