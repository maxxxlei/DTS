<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html class="h100b over_hidden">
<head>
<title>目标列表</title>
<%@ include file="/WEB-INF/jsp/apps/xs24zfz/target/targetList_js.jsp"%>
</head>
<body>
    <div id='layout' class="comp" comp="type:'layout'">
        <div class="layout_north" id="north" layout="height:40,sprit:false,border:false">
            <div id="toolbar"></div>
            <div id="searchDiv"></div>
        </div>
        <div class="layout_center over_hidden" layout="border:false" id="center">
            <table id="targetTable" class="flexme3" style="display: none"></table>
            <div id="grid_detail">
                <div>
                    <div id="btnArea" class="">
                        <div id="button_area" align="center" class="page_color button_container border_t padding_t_5" style="height:35px;">
                            <table width="80%" border="0">
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <iframe width="0" height="0" name="exportIFrame" id="exportIFrame"></iframe>
</body>
</html>