package job.common.nhlngCommon.dataAccess.mapper.looponexCore;

import java.util.List;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgMinuteHistory;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgMinuteHistoryExample;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgMinuteHistoryKey;
import org.apache.ibatis.annotations.Param;

public interface SlgMinuteHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    long countByExample(SlgMinuteHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int deleteByExample(SlgMinuteHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SlgMinuteHistoryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int insert(SlgMinuteHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int insertSelective(SlgMinuteHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    List<SlgMinuteHistory> selectByExample(SlgMinuteHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    SlgMinuteHistory selectByPrimaryKey(SlgMinuteHistoryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgMinuteHistory record, @Param("example") SlgMinuteHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgMinuteHistory record, @Param("example") SlgMinuteHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SlgMinuteHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_minute_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SlgMinuteHistory record);
}