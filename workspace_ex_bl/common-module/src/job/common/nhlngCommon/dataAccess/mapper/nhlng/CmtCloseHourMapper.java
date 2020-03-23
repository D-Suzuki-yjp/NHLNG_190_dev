package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.List;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtCloseHour;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtCloseHourExample;
import org.apache.ibatis.annotations.Param;

public interface CmtCloseHourMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    long countByExample(CmtCloseHourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int deleteByExample(CmtCloseHourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int insert(CmtCloseHour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int insertSelective(CmtCloseHour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    List<CmtCloseHour> selectByExample(CmtCloseHourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmtCloseHour record, @Param("example") CmtCloseHourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmtCloseHour record, @Param("example") CmtCloseHourExample example);
}