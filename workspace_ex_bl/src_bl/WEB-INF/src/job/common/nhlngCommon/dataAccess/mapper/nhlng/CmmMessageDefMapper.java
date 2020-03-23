package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageDef;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageDefExample;

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
    int deleteByExample(CmmMessageDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    int insert(CmmMessageDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    int insertSelective(CmmMessageDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    List<CmmMessageDef> selectByExample(CmmMessageDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmmMessageDef record, @Param("example") CmmMessageDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_def
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmmMessageDef record, @Param("example") CmmMessageDefExample example);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param msgId  メッセージID
	 * @param msgCat  メッセージカテゴリ
	 * @return CmmMessageDef メッセージ定義マスタ
	 */
    CmmMessageDef selectByPrimaryKey(@Param("msgId") String msgId,@Param("msgCat") String msgCat);

	/**
	 * @author D.Suzuki
	 *
	 * updateByPrimaryKeySelective
	 * @param record  メッセージ定義マスタ
	 * @return int update件数
	 */
	int updateByPrimaryKeySelective(CmmMessageDef record);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param msgId  メッセージID
	 * @return int delete件数
	 */
	int deleteByPrimaryKey(String msgId);
}