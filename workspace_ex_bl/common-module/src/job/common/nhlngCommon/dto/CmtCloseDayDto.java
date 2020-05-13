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
 * CmtCloseDayDto NH日締データDTO<br>
 * String tagNo タグNo<br>
 * List<NhCloseDayData> nhCloseDayDataList NH日締データリスト<br>
 * String NhCloseDayData.closeDTime 締め日時<br>
 * String NhCloseDayData.tagData タグ値<br>
 * String NhCloseDayData.qltyCd 品質コード<br>
 * String NhCloseDayData.collDTime 収集日時
 * @author D.Suzuki
 */
 public class CmtCloseDayDto{
		/**
		 * タグNo
		 */
		private String tagNo;

		/**
		 * 締めデータ
		 */
		private List<NhCloseDayData> nhCloseDayDataList;

		public String getTagNo() {
			return tagNo;
		}

		public void setTagNo(String tagNo) {
			this.tagNo = tagNo;
		}

		public List<NhCloseDayData> getNhCloseDayDataList() {
			return nhCloseDayDataList;
		}

		public void setNhCloseDayDataList(List<NhCloseDayData> nhCloseDayDataList) {
			this.nhCloseDayDataList = nhCloseDayDataList;
		}

		public class NhCloseDayData extends NhTagDataDto{

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