package job.common.nhlngCommon.dataAccess.mapper.looponexCore;

import java.util.List;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.MSubsystem;
import job.common.nhlngCommon.dataAccess.entity.looponexCore.MSubsystemExample;
import org.apache.ibatis.annotations.Param;

public interface MSubsystemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    long countByExample(MSubsystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int deleteByExample(MSubsystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String subsystemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int insert(MSubsystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int insertSelective(MSubsystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    List<MSubsystem> selectByExample(MSubsystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    MSubsystem selectByPrimaryKey(String subsystemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MSubsystem record, @Param("example") MSubsystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MSubsystem record, @Param("example") MSubsystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MSubsystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MSubsystem record);
}