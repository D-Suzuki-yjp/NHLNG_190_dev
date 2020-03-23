package job.common.nhlngCommon.dataAccess.mapper.looponexCore;

import java.util.List;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgCurrentTrend;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgCurrentTrendExample;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgCurrentTrendKey;
import org.apache.ibatis.annotations.Param;

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
    int deleteByExample(SlgCurrentTrendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SlgCurrentTrendKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int insert(SlgCurrentTrend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int insertSelective(SlgCurrentTrend record);

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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgCurrentTrend record, @Param("example") SlgCurrentTrendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgCurrentTrend record, @Param("example") SlgCurrentTrendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SlgCurrentTrend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_current_trend
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SlgCurrentTrend record);
}