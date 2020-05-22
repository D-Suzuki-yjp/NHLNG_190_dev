package job.sfcommon.dataaccess.mapper.looponexcore;

import java.util.List;

import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentTrend;
import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentTrendExample;
import job.sfcommon.dataaccess.entity.looponexcore.SlgCurrentTrendKey;

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