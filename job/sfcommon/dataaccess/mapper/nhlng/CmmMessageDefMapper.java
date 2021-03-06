package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDef;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageDefExample;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageDefMapper メッセージ定義マスタMapper
 * @author D.Suzuki
 */
public interface CmmMessageDefMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    long countByExample(CmmMessageDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    List<CmmMessageDef> selectByExample(CmmMessageDefExample example);

}