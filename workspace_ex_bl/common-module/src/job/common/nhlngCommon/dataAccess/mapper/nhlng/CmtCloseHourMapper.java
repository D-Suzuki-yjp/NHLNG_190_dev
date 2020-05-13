package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtCloseHour;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmtCloseHourExample;

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
    int deleteByPrimaryKey(@Param("closeDtime") Date closeDtime, @Param("tagNo") String tagNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int insert(@Param("recordList") List<CmtCloseHour> recordList);

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

    /**TODO write
     */
    List<CmtCloseHour> selectByExtendedExample(CmtCloseHourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    CmtCloseHour selectByPrimaryKey(@Param("closeDtime") Date closeDtime, @Param("tagNo") String tagNo);

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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CmtCloseHour record);

    int insertOrUpdate(List<CmtCloseHour> recordList);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_hour
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CmtCloseHour record);
}