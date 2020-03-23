<!--
/**
 * TITLE :JSPテンプレート
 * @version 2.02
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 YYYY/MM/DD 00000000/XXXXXXX.XXXXX    初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 */
-->

<%-- ======================== JSP page 定義 =========================== --%>
<%@ page contentType="text/html; charset=UTF-8"
    import="com.yse.gb.gf.com.config.Config,java.util.*,java.net.URLEncoder"
    errorPage="_ErrorView.jsp"%>
<%-- ================================================================== --%>

<%-- ======================== 共通インクルードJSP ===================== --%>
<jsp:include page="<%=Config._VIEWCONTROLLER_NAME%>" flush="true" />
<%-- ================================================================== --%>

<!-- ======================== 各画面固有 SCRIPT ======================= -->
<script>
  function jspOnloadTask() {

    /*
    // HTMLからフォーム内にある入力系すべてのコンポーネントを追加する
    var jspmain = $( "form[name=jspmain]" );
    $( "form[name=main]", top.htmlFrame.document )
      .find( "input, select, option, textarea" )
      .not( "[name=TOPMSGTEXT]" )
      .each( function() {
        // 同じ名前のコンポートがなければ移植する
        if ( jspmain.find( "[name=" + $( this ).attr( "name" ) + "]" ).length == 0 ) {
          jspmain.append( $( this ).clone() );
        }
      } );
    */

    //refreshPage( 10000, "RedispCommand" );
  }
</script>
<!-- ================================================================== -->
