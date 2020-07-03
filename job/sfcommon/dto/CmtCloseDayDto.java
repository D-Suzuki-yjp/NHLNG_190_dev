package job.sfcommon.dto;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/7 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmtCloseDayDto NH日締データDTO<br>
 * String tagLogicName1 グ論理名1<br>
 * Date NhTagDataDto.closeDtime 締め日時<br>
 * String NhCloseDayData.tagNo タグNo<br>
 * String NhCloseDayData.tagData タグ値<br>
 * String NhCloseDayData.qltyCd 品質コード<br>
 * Date NhCloseDayData.collDTime 収集日時
 * @author D.Suzuki
 */

/** NH日締データDTO */
public class CmtCloseDayDto extends NhTagDataDto{
		/**
		 * タグ論理名1
		 */
		private String tagLogicName1;

		public String getTagLogicName1() {
			return tagLogicName1;
		}

		public void setTagLogicName1(String tagLogicName1) {
			this.tagLogicName1 = tagLogicName1;
		}
}