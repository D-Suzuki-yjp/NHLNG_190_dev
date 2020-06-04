package job.sfcommon.dataaccess.mapper.nhlng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import job.sfcommon.dataaccess.entity.nhlng.CmtSyncInfo;
import job.sfcommon.dataaccess.entity.nhlng.CmtSyncInfoExample;

public interface CmtSyncInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    long countByExample(CmtSyncInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    int deleteByExample(CmtSyncInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    int insert(CmtSyncInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    int insertSelective(CmtSyncInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    List<CmtSyncInfo> selectByExample(CmtSyncInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmtSyncInfo record, @Param("example") CmtSyncInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_sync_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmtSyncInfo record, @Param("example") CmtSyncInfoExample example);


	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param targetTable  テーブル名
	 * @return CmtSyncInfo 等値化情報
	 */
    CmtSyncInfo selectByPrimaryKey(@Param("targetTable") String targetTable);

	/**
	 * @author D.Suzuki
	 *
	 * updateByPrimaryKeySelective
	 * @param record  等値化情報
	 * @return int update件数
	 */
	int updateByPrimaryKeySelective(CmtSyncInfo record);

	/**
	 * @author D.Suzuki
	 *
	 * selectByPrimaryKey
	 * @param targetTable  テーブル名
	 * @return int delete件数
	 */
	int deleteByPrimaryKey(String targetTable);
}