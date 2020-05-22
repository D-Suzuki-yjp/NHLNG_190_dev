package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmmMessageCat;
import job.sfcommon.dataaccess.entity.nhlng.CmmMessageCatExample;



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
    List<CmmMessageCat> selectByExample(CmmMessageCatExample example);
	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param msgCat  メッセージカテゴリ
	 * @return メッセージカテゴリマスタ
	 */
    CmmMessageCat selectByPrimaryKey(@Param("msgCat") String msgCat);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKeyBetweenDB
	 * @param msgCat  メッセージカテゴリ
	 * @return CmmMessageCat メッセージカテゴリマスタ
	 */
	CmmMessageCat selectByPrimaryKeyBetweenDB(@Param("msgCat") String msgCat);
}