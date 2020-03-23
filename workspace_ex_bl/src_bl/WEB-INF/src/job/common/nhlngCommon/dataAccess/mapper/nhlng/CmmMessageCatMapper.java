package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageCat;
import job.common.nhlngCommon.dataAccess.entity.nhlng.CmmMessageCatExample;



/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/02/27 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmMessageCatMapper メッセージカテゴリマスタMapper
 * @author D.Suzuki
 */
public interface CmmMessageCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    long countByExample(CmmMessageCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    int deleteByExample(CmmMessageCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    int insert(CmmMessageCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    int insertSelective(CmmMessageCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    List<CmmMessageCat> selectByExample(CmmMessageCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmmMessageCat record, @Param("example") CmmMessageCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_cat
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmmMessageCat record, @Param("example") CmmMessageCatExample example);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param msgCat  メッセージカテゴリ
	 * @return メッセージカテゴリマスタ
	 */
    CmmMessageCat selectByPrimaryKey(String msgCat);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKeyBetweenDB
	 * @param msgCat  メッセージカテゴリ
	 * @return CmmMessageCat メッセージカテゴリマスタ
	 */
	CmmMessageCat selectByPrimaryKeyBetweenDB(String msgCat);

	/**
	 * @author D.Suzuki
	 *
	 * updateByPrimaryKeySelective
	 * @param record  メッセージカテゴリマスタ
	 * @return int update件数
	 */
	int updateByPrimaryKeySelective(CmmMessageCat record);

	/**
	 * @author D.Suzuki
	 *
	 * updateByPrimaryKeySelective
	 * @param msgCat  メッセージカテゴリ
	 * @return int delete件数
	 */
	int deleteByPrimaryKey(String msgCat);
}