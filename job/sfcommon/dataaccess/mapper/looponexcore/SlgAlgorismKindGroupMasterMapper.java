package job.sfcommon.dataaccess.mapper.looponexcore;

import java.util.List;
import job.sfcommon.dataaccess.entity.looponexcore.SlgAlgorismKindGroupMasterExample;
import job.sfcommon.dataaccess.entity.looponexcore.SlgAlgorismKindGroupMasterKey;
import org.apache.ibatis.annotations.Param;

public interface SlgAlgorismKindGroupMasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    long countByExample(SlgAlgorismKindGroupMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    int deleteByExample(SlgAlgorismKindGroupMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SlgAlgorismKindGroupMasterKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    int insert(SlgAlgorismKindGroupMasterKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    int insertSelective(SlgAlgorismKindGroupMasterKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    List<SlgAlgorismKindGroupMasterKey> selectByExample(SlgAlgorismKindGroupMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgAlgorismKindGroupMasterKey record, @Param("example") SlgAlgorismKindGroupMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_algorism_kind_group_master
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgAlgorismKindGroupMasterKey record, @Param("example") SlgAlgorismKindGroupMasterExample example);
}