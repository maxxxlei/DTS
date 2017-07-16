<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单角色权限管理</title>

<script type="text/javascript">
$(function(){
	var url = _ctxPath + "/xd24/menuRoleController.do?method=listMenu";
	$("#templateSysMgr").attr("src",url);
    $("#btn1").click(function(){
        $("#tab1").removeClass("common_tabs A").addClass("current");
        $("#tab2").removeClass("current").addClass("common_tabs A");
        $("#templateSysMgr").attr("src",url);
    });
    $("#btn2").bind("click",function(){
        $("#tab1").removeClass("current").addClass("common_tabs A");
        $("#tab2").removeClass("common_tabs A").addClass("current");
        $("#templateSysMgr").attr("src",_ctxPath + "/xd24/menuRoleController.do?method=listRole");
    });
});
</script>

</head>
<body>
    <div id='layout' class="comp" comp="type:'layout',border:false">
        <div class="comp" comp="type:'breadcrumb',comptype:'location',code:'F01_collappset'"></div>
        <div class="comp" comp="type:'breadcrumb',comptype:'location',code:'F01_colltemplate'"></div>
        <div class="layout_north page_color" layout="height:38,sprit:false,border:false">
            <div>
                <div id="tabs2_head" class="common_tabs clearfix margin_l_5 margin_t_5">
                    <ul class="left">
                    	<li id="tab1" class="current"><a id="btn1" href="javascript:void(0)" tgt="tab1_div"><span>菜单管理</span></a></li>
                        <li id="tab2"><a id="btn2" href="javascript:void(0)" tgt="tab2_div" class="last_tab no_b_border"><span>角色管理</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layout_center over_hidden" layout="border:false">
            <iframe id="templateSysMgr" width="100%" height="100%" frameborder="0" src=""></iframe>
        </div>
    </div>
</body>
</html>