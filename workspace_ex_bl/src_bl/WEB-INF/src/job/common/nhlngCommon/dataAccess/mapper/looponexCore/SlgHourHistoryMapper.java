package job.common.nhlngCommon.dataAccess.mapper.looponexCore;

import java.util.List;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgHourHistory;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgHourHistoryExample;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.SlgHourHistoryKey;
import org.apache.ibatis.annotations.Param;

public interface SlgHourHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    long countByExample(SlgHourHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int deleteByExample(SlgHourHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SlgHourHistoryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int insert(SlgHourHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int insertSelective(SlgHourHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    List<SlgHourHistory> selectByExample(SlgHourHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    SlgHourHistory selectByPrimaryKey(SlgHourHistoryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgHourHistory record, @Param("example") SlgHourHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgHourHistory record, @Param("example") SlgHourHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SlgHourHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_hour_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SlgHourHistory record);
}