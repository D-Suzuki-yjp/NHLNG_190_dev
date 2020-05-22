package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMon;
import job.sfcommon.dataaccess.entity.nhlng.CmtCloseMonExample;

public interface CmtCloseMonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    long countByExample(CmtCloseMonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int deleteByExample(CmtCloseMonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(@Param("closeDtime") Date closeDtime, @Param("tagNo") String tagNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int insert(CmtCloseMon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int insertSelective(CmtCloseMon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    List<CmtCloseMon> selectByExample(CmtCloseMonExample example);

    /**TODO write
     */
    List<CmtCloseMon> selectByExtendedExample(CmtCloseMonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    CmtCloseMon selectByPrimaryKey(@Param("closeDtime") Date closeDtime, @Param("tagNo") String tagNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmtCloseMon record, @Param("example") CmtCloseMonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmtCloseMon record, @Param("example") CmtCloseMonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CmtCloseMon record);

    int insertOrUpdate(List<CmtCloseMon> recordList);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_close_mon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CmtCloseMon record);
}