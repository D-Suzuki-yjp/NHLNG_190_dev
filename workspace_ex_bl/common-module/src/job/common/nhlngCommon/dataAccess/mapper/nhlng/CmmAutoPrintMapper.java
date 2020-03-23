package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.List;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmAutoPrint;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmAutoPrintExample;
import org.apache.ibatis.annotations.Param;

public interface CmmAutoPrintMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    long countByExample(CmmAutoPrintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    int deleteByExample(CmmAutoPrintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    int insert(CmmAutoPrint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    int insertSelective(CmmAutoPrint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    List<CmmAutoPrint> selectByExample(CmmAutoPrintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmmAutoPrint record, @Param("example") CmmAutoPrintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmmAutoPrint record, @Param("example") CmmAutoPrintExample example);
}