package job.sfcommon.dataaccess.mapper.looponexcore;

import java.util.List;
import job.sfcommon.dataaccess.entity.looponexcore.SlgLoggingKindMaster;
import job.sfcommon.dataaccess.entity.looponexcore.SlgLoggingKindMasterExample;
import org.apache.ibatis.annotations.Param;

public interface SlgLoggingKindMasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    long countByExample(SlgLoggingKindMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int deleteByExample(SlgLoggingKindMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String loggingKindName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int insert(SlgLoggingKindMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int insertSelective(SlgLoggingKindMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    List<SlgLoggingKindMaster> selectByExample(SlgLoggingKindMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    SlgLoggingKindMaster selectByPrimaryKey(String loggingKindName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SlgLoggingKindMaster record, @Param("example") SlgLoggingKindMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SlgLoggingKindMaster record, @Param("example") SlgLoggingKindMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SlgLoggingKindMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_logging_kind_master
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SlgLoggingKindMaster record);
}