package job.uicommon.dataaccess.mapper.nhlng;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.uicommon.dataaccess.entity.nhlng.StmTank;
import job.uicommon.dataaccess.entity.nhlng.StmTankExample;

public interface StmTankMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    long countByExample(StmTankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    int deleteByExample(StmTankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    int insert(StmTank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    int insertSelective(StmTank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    List<StmTank> selectByExample(StmTankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") StmTank record, @Param("example") StmTankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.stm_tank
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") StmTank record, @Param("example") StmTankExample example);

	/**
	 * @author D.Suzuki
	 *
	 * updateByPrimaryKeySelective
	 * @param record  タンクマスタ
	 * @return int update件数
	 */
	int updateByPrimaryKeySelective(StmTank record);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param tankNo  タンクNO
	 * @param lvlGaugeFrom  液面FROM
	 * @return int delete件数
	 */
	int deleteByPrimaryKey(int tankNo, BigDecimal lvlGaugeFrom);
}