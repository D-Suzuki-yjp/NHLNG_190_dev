package job.common.nhlngCommon.dataAccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.common.nhlngCommon.dataAccess.entity.nhlng.ExmLgsSnd;
import job.common.nhlngCommon.dataAccess.entity.nhlng.ExmLgsSndExample;

public interface ExmLgsSndMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    long countByExample(ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    int deleteByExample(ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    int insert(ExmLgsSnd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    int insertSelective(ExmLgsSnd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    List<ExmLgsSnd> selectByExample(ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ExmLgsSnd record, @Param("example") ExmLgsSndExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.exm_lgs_snd
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ExmLgsSnd record, @Param("example") ExmLgsSndExample example);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param confNo  設定NO
	 * @param writeTagNo  書込タグNO
	 * @return ExmLgsSnd LGS送信マスタ
	 */
    ExmLgsSnd selectByPrimaryKey(@Param("confNo") int confNo,@Param("writeTagNo") String writeTagNo);

	/**
	 * @author D.Suzuki
	 *
	 * updateByPrimaryKeySelective
	 * @param record  LGS送信マスタ
	 * @return int update件数
	 */
	int updateByPrimaryKeySelective(ExmLgsSnd record);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param confNo  設定NO
	 * @param writeTagNo  書込タグNO
	 * @return int delete件数
	 */
	int deleteByPrimaryKey(int confNo, String writeTagNo);
}