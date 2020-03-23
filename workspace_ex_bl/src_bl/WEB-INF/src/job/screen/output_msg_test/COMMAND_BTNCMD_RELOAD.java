package job.screen.output_msg_test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.yse.gb.gf.front.CommandException;
import com.yse.gb.gf.front.CommandHelper;
import com.yse.gb.gf.front.Helper;
import com.yse.gb.gf.front.InputException;
import com.yse.gb.gf.front.KeyObj;
import com.yse.gb.gf.front.SessionValue;
import com.yse.gb.gf.front.ValueBean;
import com.yse.gb.gf.front.html.HtmlObject;
import com.yse.gb.gf.front.html.Input;

/**
 * ボタン処理クラス。<br>
 * <!-- TYPE DESCRIPTION -->
 *
 * <pre>
 * </pre>
 */
/*
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 YYYY/MM/DD 00000000/XXXX.XXXXXXXX    初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 */
@RequestScoped
public class COMMAND_BTNCMD_RELOAD extends com.yse.gb.gf.bld.front.BLDCommandImpl {

	public static final String KEYOBJ_KEY;

	static {
		KEYOBJ_KEY = "htmlObjectList";
	}

	/**
	 * ボタン処理実行。<br>
	 * 本処理は{@link #getNextScreenId(CommandHelper, KeyObj)}の終了後に呼び出されます。<br>
	 * <!-- METHOD DESCRIPTION -->
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param helper
	 *            コマンドヘルパー
	 * @param nextScreenId
	 *            展開先画面ID
	 * @param keyObj
	 *            展開先画面へ渡す情報の格納用
	 */
	@Override
	protected void perform(final CommandHelper helper, final String nextScreenId, final KeyObj keyObj)
			throws InputException, CommandException, Throwable {

		// 画面展開時の情報取得方法
		//
		// String userId =
		// 		keyObj.get("USER_ID");
		//

		// 画面表示時情報取得方法 (Spanなど)
		// ※)Inputの場合は画面の入力値ではなく
		// 表示した時点の値を取ることが出来る
		//
		// String jobNo =
		// 		helper.getInitValue("NMLLBL_JOB_NO");
		//

		// 画面入力情報取得方法 (Inputなど)
		//
		// String tankNo =
		// 		helper.getParam("NMLTXT_TANK_NO");
		//

		// 一覧表の入力情報取得方法(Input,Checkboxなど)
		//
		// String[] deleteNames =
		// 		helper.getCheckedValues("NMLCHK_DELETE");
		//

		// 展開先画面への展開パラメータセット方法
		// keyObj.put("JOB_NO",jobNo);
		//

		// 前回のValueBeanからHtmlObjectのリストを取得
		List<HtmlObject> htmlObjectList = getHtmlObjectList(helper);

		// 今回表示用に値を更新したHtmlObjectのリストを作成
		List<HtmlObject> newHtmlObjectList = remakeNewHtmlObjectList(helper, htmlObjectList);

		// タグのスタイルを連携
		String tagStyleData = helper.getParam("TAG_STYLE_DATA");
		if (tagStyleData != null) {
			newHtmlObjectList.add(new Input("TAG_STYLE_DATA", tagStyleData));
		}

		// spanのテキストを連携
		String spanTextData = helper.getParam("SPAN_TEXT_DATA");
		if (spanTextData != null) {
			newHtmlObjectList.add(new Input("SPAN_TEXT_DATA", spanTextData));
		}

		// チェックボックスの初期状態でのチェック状況データを連携
		String checkboxInitFlags = helper.getParam("CHECKBOX_INIT_FLAGS_COPY");
		if (checkboxInitFlags != null) {
			newHtmlObjectList.add(new Input("CHECKBOX_INIT_FLAGS_COPY", checkboxInitFlags));
		}

		// ラジオボタンの初期状態でのチェック状況データを連携
		String radioInitSelect = helper.getParam("OPTBTN_INIT_SELECT_VALUES_COPY");
		if (radioInitSelect != null) {
			newHtmlObjectList.add(new Input("OPTBTN_INIT_SELECT_VALUES_COPY", radioInitSelect));
		}

		// 入力値の初期値データを連携
		String jspSetValues = helper.getParam("JSP_SET_VALUES_COPY");
		if (jspSetValues != null) {
			newHtmlObjectList.add(new Input("JSP_SET_VALUES_COPY", jspSetValues));
		}
		// エラーメッセージテスト（赤文字出力）
        //helper.setMsgHandleBean(new MsgHandleBean(new UserMessage("再表示完了", "RED", "")));



		// 出来上がった新しいHtmlObjectのリストをCreatorに引き渡す
		keyObj.putObj(KEYOBJ_KEY, newHtmlObjectList);

	}

	/**
	 * 前回のValueBeanから取得したHtmlObjectのリストを取得する
	 *
	 * @param helper
	 *            コマンドヘルパー
	 * @return 前回のValueBeanから取得したHtmlObjectのリスト
	 * @throws ReflectiveOperationException
	 */
	protected List<HtmlObject> getHtmlObjectList(final CommandHelper helper) throws ReflectiveOperationException {
		// SessionValue取得
		Method get_sessionValue = Helper.class.getDeclaredMethod("get_sessionValue");
		get_sessionValue.setAccessible(true);
		SessionValue sessionValue = (SessionValue) get_sessionValue.invoke(helper);

		// 前回の同画面ValueBean取得
		Method getInitValueBean = SessionValue.class.getDeclaredMethod("getInitValueBean", String.class);
		getInitValueBean.setAccessible(true);
		ValueBean initValueBean = (ValueBean) getInitValueBean.invoke(sessionValue, helper.getScreenId());

		List<HtmlObject> htmlObjectList = new ArrayList<>();

		// 前回のValueBeanからHtmlObjectを取得
		@SuppressWarnings("unchecked")
		Iterator<HtmlObject> iterator = initValueBean.getIterator();
		while (iterator.hasNext()) {
			HtmlObject htmlObject = iterator.next();
			htmlObjectList.add(htmlObject);
		}

		return htmlObjectList;
	}

	/**
	 * 今回表示用に値を更新したHtmlObjectのリストを作成する
	 *
	 * @param helper
	 *            コマンドヘルパー
	 * @param htmlObjectList
	 *            前回のValueBeanから取得したHtmlObjectのリスト
	 * @return 今回表示用に値を更新したHtmlObjectのリスト
	 */
	protected List<HtmlObject> remakeNewHtmlObjectList(final CommandHelper helper,
			final List<HtmlObject> htmlObjectList) {
		List<HtmlObject> newHtmlObjectList = new ArrayList<>(htmlObjectList.size());
		for (HtmlObject htmlObject : htmlObjectList) {
			String name = htmlObject.getName();
			String param = helper.getParam(name);

			HtmlObject newHtmlObject;
			if (htmlObject instanceof Input) {
				Input input = (Input) htmlObject;
				input.setValue(param);
				newHtmlObject = input;

			} else {
				// Table, Span, Pre, Embed は以下の理由によりそのまま通過
				// ・Table は行数のみ合っていれば良いため
				// ・Span, Preはサーバー側では変化したinnerTextを取得できないのでHtmlObjectを変化させようがないため
				// ・Embed はサーバー側では変化したsrcを取得できないのでHtmlObjectを変化させようがないため
				newHtmlObject = htmlObject;
			}

			// 新しいリストに追加
			newHtmlObjectList.add(newHtmlObject);
		}
		return newHtmlObjectList;
	}
}
