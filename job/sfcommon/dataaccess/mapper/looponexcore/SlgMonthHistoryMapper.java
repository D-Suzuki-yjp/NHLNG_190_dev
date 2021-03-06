package job.sfcommon.dataaccess.mapper.looponexcore;

import java.util.List;
import job.sfcommon.dataaccess.entity.looponexcore.SlgMonthHistory;
import job.sfcommon.dataaccess.entity.looponexcore.SlgMonthHistoryExample;
import job.sfcommon.dataaccess.entity.looponexcore.SlgMonthHistoryKey;
import org.apache.ibatis.annotations.Param;

public interface SlgMonthHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    long countByExample(SlgMonthHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int deleteByExample(SlgMonthHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SlgMonthHistoryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int insert(SlgMonthHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int insertSelective(SlgMonthHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    List<SlgMonthHistory> selectByExample(SlgMonthHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    SlgMonthHistory selectByPrimaryKey(SlgMonthHistoryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgMonthHistory record, @Param("example") SlgMonthHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgMonthHistory record, @Param("example") SlgMonthHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SlgMonthHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_month_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SlgMonthHistory record);
}