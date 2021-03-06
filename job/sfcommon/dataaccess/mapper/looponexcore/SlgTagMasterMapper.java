package job.sfcommon.dataaccess.mapper.looponexcore;

import java.util.List;
import job.sfcommon.dataaccess.entity.looponexcore.SlgTagMaster;
import job.sfcommon.dataaccess.entity.looponexcore.SlgTagMasterExample;
import org.apache.ibatis.annotations.Param;

public interface SlgTagMasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    long countByExample(SlgTagMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int deleteByExample(SlgTagMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String lcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int insert(SlgTagMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int insertSelective(SlgTagMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    List<SlgTagMaster> selectByExample(SlgTagMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    SlgTagMaster selectByPrimaryKey(String lcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgTagMaster record, @Param("example") SlgTagMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgTagMaster record, @Param("example") SlgTagMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SlgTagMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_tag_master
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SlgTagMaster record);
}