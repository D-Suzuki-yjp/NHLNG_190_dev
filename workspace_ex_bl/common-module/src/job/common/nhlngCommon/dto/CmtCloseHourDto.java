package job.common.nhlngCommon.dto;

import java.util.Date;
import java.util.List;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/7 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtCloseHourDto NH日締データDTO<br>
 * String tagNo タグNo<br>
 * List<NhCloseHourData> nhCloseHourDataList NH時締データリスト<br>
 * String NhCloseHourData.closeDTime 締め日時<br>
 * String NhCloseHourData.tagData タグ値<br>
 * String NhCloseHourData.qltyCd 品質コード<br>
 * String NhCloseHourData.collDTime 収集日時
 * @author D.Suzuki
 */
 public class CmtCloseHourDto{
		/**
		 * タグNo
		 */
		private String tagNo;

		/**
		 * 締めデータ
		 */
		private List<NhCloseHourData> nhCloseHourDataList;

		public String getTagNo() {
			return tagNo;
		}

		public void setTagNo(String tagNo) {
			this.tagNo = tagNo;
		}

		public List<NhCloseHourData> getNhCloseHourDataList() {
			return nhCloseHourDataList;
		}

		public void setNhCloseHourDataList(List<NhCloseHourData> nhCloseHourDataList) {
			this.nhCloseHourDataList = nhCloseHourDataList;
		}

		public class NhCloseHourData extends NhTagDataDto{

			/**
			 * 締め日時
			 */
			private Date closeDTime;

			public Date getCloseDTime() {
				return closeDTime;
			}

			public void setCloseDTime(Date closeDTime) {
				this.closeDTime = closeDTime;
			}
		}
}