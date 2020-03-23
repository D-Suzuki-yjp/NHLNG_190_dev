package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.common.nhlngCommon.dataAccess.entity.nhlng.ExmLgsSnd;
import job.common.nhlngCommon.dataAccess.entity.nhlng.ExmLgsSndExample;

public interface ExmLgsSndMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    long countByExample(ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    int deleteByExample(ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    int insert(ExmLgsSnd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    int insertSelective(ExmLgsSnd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    List<ExmLgsSnd> selectByExample(ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ExmLgsSnd record, @Param("example") ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_ext_com
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ExmLgsSnd record, @Param("example") ExmLgsSndExample example);
}