package job.sfcommon.dto;

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
 * CmtCloseMonDto NH月締データDTO<br>
 * String tagNo タグNo<br>
 * List<CmtCloseMonDto> nhCloseMonDataList NH月締データリスト<br>
 * String CmtCloseMonDto.closeDTime 締め日時<br>
 * String CmtCloseMonDto.tagData タグ値<br>
 * String CmtCloseMonDto.qltyCd 品質コード<br>
 * String CmtCloseMonDto.collDTime 収集日時
 * @author D.Suzuki
 */
 public class CmtCloseMonDto{
		/**
		 * タグNo
		 */
		private String tagNo;

		/**
		 * 締めデータ
		 */
		private List<NhCloseMonData> nhCloseMonDataList;

		public String getTagNo() {
			return tagNo;
		}

		public void setTagNo(String tagNo) {
			this.tagNo = tagNo;
		}

		public List<NhCloseMonData> getNhCloseMonDataList() {
			return nhCloseMonDataList;
		}

		public void setNhCloseMonDataList(List<NhCloseMonData> nhCloseMonDataList) {
			this.nhCloseMonDataList = nhCloseMonDataList;
		}

		public class NhCloseMonData extends NhTagDataDto{

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