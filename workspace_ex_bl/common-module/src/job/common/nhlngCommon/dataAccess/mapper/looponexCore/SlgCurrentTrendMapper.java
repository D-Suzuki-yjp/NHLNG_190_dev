package job.common.nhlngCommon.dataAccess.mapper.looponexCore;

import java.util.List;

import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgCurrentTrend;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgCurrentTrendExample;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgCurrentTrendKey;

public interface SlgCurrentTrendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    long countByExample(SlgCurrentTrendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    List<SlgCurrentTrend> selectByExample(SlgCurrentTrendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    SlgCurrentTrend selectByPrimaryKey(SlgCurrentTrendKey key);
}