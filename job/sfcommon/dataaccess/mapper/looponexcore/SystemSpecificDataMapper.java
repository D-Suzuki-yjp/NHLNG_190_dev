package job.sfcommon.dataaccess.mapper.looponexcore;

import java.util.List;

import job.sfcommon.dataaccess.entity.looponexcore.SystemSpecificData;
import job.sfcommon.dataaccess.entity.looponexcore.SystemSpecificDataExample;

public interface SystemSpecificDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.system_specific_data
     *
     * @mbg.generated
     */
    long countByExample(SystemSpecificDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.system_specific_data
     *
     * @mbg.generated
     */
    List<SystemSpecificData> selectByExample(SystemSpecificDataExample example);
}