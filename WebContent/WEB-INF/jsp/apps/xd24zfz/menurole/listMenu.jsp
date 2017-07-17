<%--
 $Author:  翟锋$
 $Rev: 1697 $
 $Date:: #$:
  
 Copyright (C) 2012 Seeyon, Inc. All rights reserved.
 This software is the proprietary information of Seeyon, Inc.
 Use is subject to license terms.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>菜单列表页面</title>
    <script type="text/javascript" src="${path}/ajax.do?managerName=menuRoleManager"></script>
    <script type="text/javascript">
        var grid;
        var edocDialog;
        var infoDialog;
        $(function () {
            //初始化布局
            new MxtLayout({
                'id': 'layout',
                'northArea': {
                    'id': 'north',
                    'height': 40,
                    'sprit': false,
                    'border': false
                },
                'centerArea': {
                    'id': 'center',
                    'border': false,
                    'minHeight': 20
                }
            });
          
            //工具栏
            var toolbar = new Array();
            //新建
            toolbar.push({id: "newCreate",name: "${ctp:i18n('common.toolbar.new.label')}",className: "ico16",click:addRow });
            //修改
            toolbar.push({id: "update",name: "${ctp:i18n('common.toolbar.update.label')}",className: "ico16 editor_16",click:updateRow });
           
            //删除
            toolbar.push({ id: "delete",name: "${ctp:i18n('common.button.delete.label')}",className: "ico16 del_16",click:deleteRow });
           
            
            $("#toolbars").toolbar({
                borderLeft:false,
                borderTop:false,
                borderRight:false,
                toolbar: toolbar
            });
            //定义搜索条件选项
            var condition = new Array();
            //名称
            condition.push({id: 'name',name: 'name',type: 'input',text: "${ctp:i18n('permission.name')}",value: 'name',maxLength:20,validate:false});
            
            //启用状态
            condition.push({id: 'isEnabled',name: 'isEnabled',type: 'select',text: "${ctp:i18n('permission.auth.isenabled')}",value: 'isEnabled',
                items: [{
                    text: "${ctp:i18n('common.state.normal.label')}",//启用
                    value: '1'
                }, {
                    text: "${ctp:i18n('common.state.invalidation.label')}",//停用
                    value: '0'
                }]
            });
            
            
            //搜索框
            var searchobj = $.searchCondition({
                top:7,
                right:10,
                searchHandler: function(){
                    searchFunc();
                },
                conditions:condition
            });
            //搜索框执行的动作
            function searchFunc(){
                var o = new Object();
                o.configCategory = $('#category').val();
                var choose = $('#'+searchobj.p.id).find("option:selected").val();
                if(choose === 'name'){
                    o.name = $('#name').val();
                }else if(choose === 'isRef'){
                    o.isRef = $('#isRef').val();
                }else if(choose === 'isEnabled'){
                    o.isEnabled = $('#isEnabled').val();
                }else if(choose === 'expressionType'){
                    o.configCategory = $('#expressionType').val();
                }
                
                var val = searchobj.g.getReturnValue();
                if(val !== null){
                    $("#menuList").ajaxgridLoad(o);
                }
            }
          	//定义列表框选项栏目名称
            var colModel = new Array();
            colModel.push({display: 'id',name: 'id',width: '4%',type: 'checkbox'});
            colModel.push({display: "菜单名称",name: 'name',width: "30%"});
            colModel.push({display: "菜单分类",name: 'category',width: "20%"});
            colModel.push({display: "菜单级别",name: 'menuLevel',width: "20%"});
            colModel.push({display: "是否启用",name: 'isEnable',width: "10%"});
            colModel.push({display: "创建时间",name: 'createTime',width: "16%"});
           
            
            //构造列表
             grid = $('#menuList').ajaxgrid({
                click: showInfo,
                dblclick: dbclickRow,
                colModel: colModel,
                height: 200,
                showTableToggleBtn: true,
                parentId: $('.layout_center').eq(0).attr('id'),
                vChange: true,
                isHaveIframe:true,
                slideToggleBtn:true,
                onSuccess:function(){
                	if($.trim(grid) != "" && $.trim(grid.p) != ""){
                		grid.grid.resizeGridUpDown("down");
                	}
                },
                managerName : "menuRoleManager",
                managerMethod : "getMenuList"
            });
             
            function showInfo(row, rowIndex, colIndex) {
                $('#summary').attr("src",_ctxPath + "/xd24/menuRoleController.do?method=editMenu&operType=show&id="+row.id);
            }
            //双击事件
            function dbclickRow(){
                updateRow();
            }
            
            //新建节点权限
            function addRow(){
                //将新建页面显示
                $('#summary').attr("src",_ctxPath + "/xd24/menuRoleController.do?method=addMenu");
                grid.grid.resizeGridUpDown('middle');
            }
            
            
          
            //修改节点权限
            function updateRow(){
                var rows = grid.grid.getSelectRows();
                if(rows.length === 0){
                    $.alert("${ctp:i18n('permission.operation.choose.one')}!");//请选择一条记录
                    return;
                }
                if(rows.length>1){
                    $.alert("${ctp:i18n('permission.operation.choose.onlyone')}!");//只能选择一条记录进行修改
                    return;
                }
                grid.grid.resizeGridUpDown('middle');
                $('#summary').attr("src",_ctxPath + "/permission/permission.do?method=edit&operType=change&flag=edit&id="+rows[0].flowPermId);
            }
            
            
            //删除节点权限
            function deleteRow(){
                var rows = grid.grid.getSelectRows();
                if(rows.length === 0){
                    $.alert("${ctp:i18n('permission.operation.choose.delete.records')}"); //请选择要删除的记录
                    return;
                }
                var pm = new permissionManager();
                var tranObj = new Array();
                for(i=0;i<rows.length;i++){
                    if(rows[i].type == '0'){
                        $.alert("${ctp:i18n('permission.right.not.delete')}");//系统权限无法被删除
                        return;
                    }
                    //判断是否被引用
                    if(rows[i].isRef == '1'){
                        $.alert("${ctp:i18n('permission.operation.isRef')}");//权限已被引用，无法被删除
                        return;
                    }
                    if(rows[i].isDefaultNode == '1'){
                    	$.alert("${ctp:i18n('permission.list.deleteDefaultNode')}");//权限被设置默认，请更新其他节点为默认后删除！
                        return;
                    }
                    tranObj[i] = rows[i].flowPermId;
                }
                var confirm = $.confirm({
                    'msg': "${ctp:i18n('permission.operation.confirm.delete')}",//确定删除该权限，该操作无法恢复
                    ok_fn: function () { 
                        pm.deletePermissions(tranObj,{
                            success : function(msg){
                                if(msg === ""){
                                    searchFunc();
                                }else{
                                    $.alert(msg);
                                }
                            }, 
                            error : function(request, settings, e){
                                    $.alert(e);
                            }
                         });
                    },
                    cancel_fn:function(){
                        confirm.close();
                    }
                });
            }
            
        });
    </script>
</head>
<body>
    <div id='layout'>
        <div class="layout_north bg_color f0f0f0" id="north">
            <div id="toolbars"></div>
        </div>
        <div class="layout_center over_hidden" id="center">
            <table class="flexme3" id="menuList"></table>
            <div id="grid_detail" class="h100b">
                <iframe id="summary" width="100%" height="100%" frameborder="0"  scrolling="no"></iframe>
            </div>
        </div>
        
    </div>
</body>
</html>
