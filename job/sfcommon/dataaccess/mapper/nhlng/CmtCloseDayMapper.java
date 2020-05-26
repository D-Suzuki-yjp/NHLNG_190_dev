package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDay;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseDayExample;

public interface CmtCloseDayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    long countByExample(CmtCloseDayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int deleteByExample(CmtCloseDayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(@Param("closeDtime") Date closeDtime, @Param("tagNo") String tagNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int insert(CmtCloseDay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int insertSelective(CmtCloseDay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    List<CmtCloseDay> selectByExample(CmtCloseDayExample example);

    /**TODO write
     */
    List<CmtCloseDay> selectByExtendedExample(CmtCloseDayExample example);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    CmtCloseDay selectByPrimaryKey(@Param("closeDtime") Date closeDtime, @Param("tagNo") String tagNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmtCloseDay record, @Param("example") CmtCloseDayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmtCloseDay record, @Param("example") CmtCloseDayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CmtCloseDay record);

    int insertOrUpdate(List<CmtCloseDay> recordList);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_day
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CmtCloseDay record);

    /**
     * 日締処理
     * @param Date targetDate
     * @param String className
     * @author D.Suzuki
     */
	int dayClose(@Param("targetDate") Date targetDate,@Param("className") String className);
}