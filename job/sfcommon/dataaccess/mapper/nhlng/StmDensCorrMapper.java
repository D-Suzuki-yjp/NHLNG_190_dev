package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import job.sfcommon.dataaccess.entity.nhlng.StmDensCorr;
import job.sfcommon.dataaccess.entity.nhlng.StmDensCorrExample;

public interface StmDensCorrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_dens_corr
     *
     * @mbg.generated
     */
    long countByExample(StmDensCorrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_dens_corr
     *
     * @mbg.generated
     */
    List<StmDensCorr> selectByExample(StmDensCorrExample example);
}