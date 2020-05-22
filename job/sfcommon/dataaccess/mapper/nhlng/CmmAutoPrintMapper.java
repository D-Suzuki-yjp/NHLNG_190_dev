package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmmAutoPrint;
import job.sfcommon.dataaccess.entity.nhlng.CmmAutoPrintExample;

public interface CmmAutoPrintMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    long countByExample(CmmAutoPrintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_auto_print
     *
     * @mbg.generated
     */
    List<CmmAutoPrint> selectByExample(CmmAutoPrintExample example);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param reportKind  帳票区分
	 * @return CmmItem 自動印刷マスタ
	 */
    CmmAutoPrint selectByPrimaryKey(@Param("reportKind") String reportKind);
}