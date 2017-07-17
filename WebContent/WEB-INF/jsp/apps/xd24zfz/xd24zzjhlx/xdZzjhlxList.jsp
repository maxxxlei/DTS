<%--
 $Author:  许永恕$
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
    <title>组织计划</title>
    <script type="text/javascript" src="${path}/ajax.do?managerName=zzjhlxManger"></script>
    <script type="text/javascript">
        var grid;
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
            //获取类型 (协同 或者公文)
            var category = $('#category').val();
            //工具栏
            var toolbar = new Array();
            //新建
            toolbar.push({id: "newCreate",name: "新建",className: "ico16",click:addRow });
            //修改
            toolbar.push({id: "update",name: "修改",className: "ico16 editor_16",click:updateRow });
           
            //删除
            toolbar.push({ id: "delete",name: "删除",className: "ico16 del_16",click:deleteRow });
            
            $("#toolbars").toolbar({
                borderLeft:false,
                borderTop:false,
                borderRight:false,
                toolbar: toolbar
            });
            //定义搜索条件选项
            var condition = new Array();
            //名称
            condition.push({id: 'name',name: 'name',type: 'input',text: "组织计划名称",value: 'name',maxLength:20,validate:false});
            //启用状态
            condition.push({id: 'isEnable',name: 'isEnable',type: 'select',text: "启用状态",value: 'isEnable',
                items: [{
                    text: "启用",//启用
                    value: '1'
                }, {
                    text: "停用",//停用
                    value: '0'
                }]
            });
           /*  //创建时间
            condition.push({id: '',name: 'createTime',type: 'createTime',text: "",value: 'createTime',dateTime:true});
            */
            //目标开始时间
            condition.push({id: 'createTime',name: 'createTime',type: 'datemulti',text: "创建时间",value: 'startTime',dateTime:true});
            
           
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
                var choose = $('#'+searchobj.p.id).find("option:selected").val();
                o.condition = choose;
                if(choose === 'name'){
                    o.value = $('#name').val();
                    alert(o.name+"hhhhh");
                }else if(choose === 'startTime'){
                	alert("时间");
                	 var sDate = $('#from_createTime').val();
                     var eDate = $('#to_createTime').val();
                     o.value = sDate +"#"+eDate;
                     alert(o.value);
                }else if(choose === 'isEnable'){
                    o.value = $('#isEnable').val();
                    alert(o.isEnabled);
                }
                var val = searchobj.g.getReturnValue();
                if(val !== null){
                    $("#perList").ajaxgridLoad(o);
                }
            }
          	//定义列表框选项栏目名称
            var colModel = new Array();
            colModel.push({display: 'id',name: 'id',width: '4%',type: 'checkbox'});
            //组织计划名称
            colModel.push({display: "组织计划名称",name: 'name',width: "60%"});
            //是否启用
            colModel.push({display: "是否启用",name: 'isEnable',width: "17%"});
            
            //是否默认
            colModel.push({display: "创建时间",name: 'createTime',width: "17%"});
            
            //构造列表
             grid = $('#perList').ajaxgrid({
                click: showInfo,
                dblclick: dbclickRow,
                colModel: colModel,
                height: 200,
                render : rend,
                showTableToggleBtn: true,
                parentId: $('.layout_center').eq(0).attr('id'),
                vChange: true,
                isHaveIframe:true,
                slideToggleBtn:true,
                managerName : "zzjhlxManger",
                managerMethod : "getZzjhList"
            });
             var o = new Object();
             $("#perList").ajaxgridLoad(o);
             function rend(txt, data, r, c) {
            		if(c===1){
            			txt = "<span class='grid_black'>"+txt+"</span>";
            		}
            		return txt;
            }
            
            //双击事件
            function dbclickRow(){
            	//$('#summary').attr("src",_ctxPath + "/xdcd24/xdcd24.do?method=newaddRow&flag=update");
            	updateRow();
            }
            //单机事件
            function showInfo(){
            	//$('#summary').attr("src",_ctxPath + "/xdcd24/xdcd24.do?method=newaddRow&flag=show");
            	updateRow();
            	
            }
            
            //新建节点权限
            function addRow(){
                //将新建页面显示
                $('#summary').attr("src",_ctxPath + "/xdcd24/xdcd24.do?method=newaddRow&flag=new");
                grid.grid.resizeGridUpDown('middle');
            }
           //修改权限
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
                debugger;
                $('#summary').attr("src",_ctxPath + "/xdcd24/xdcd24.do?method=newaddRow&flag=update&rowsId="+rows[0].id);
            }
            //删除节点权限
            function deleteRow(){
            	 var rows = grid.grid.getSelectRows();
            	 if(rows.length === 0){
                     $.alert("请选择要删除的记录"); //请选择要删除的记录
                     return;
                 }
            	 var manager = new zzjhlxManger();
            	 debugger;
            	 var tranObj = new Array();
            	 for(i=0;i<rows.length;i++){
                     //进行数据验证，是否可以进行删除操作
                      tranObj[i] = rows[i].id;
                     alert(tranObj[i]);
                  }
            	 var confirm = $.confirm({
                     'msg': "确定删除该数据，该操作无法恢复",//确定删除该权限，该操作无法恢复
                     ok_fn: function () { 
                    	 manager.deleteZzjhlx(tranObj,{
                             success : function(msg){
                                 if("SUCCESS" === msg){
                                     $.alert("删除成功！");
                                     var o = new Object();
                                     //$('#versionList').ajaxgrid();
                                     $("#perList").ajaxgridLoad(o);
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
            var skinPathKey = getCtpTop().skinPathKey == null ? "harmony" : getCtpTop().skinPathKey;
            var html = '<span class="nowLocation_ico"><img src="'+_ctxPath+'/main/skin/frame/'+skinPathKey+'/menuIcon/'+getCtpTop().currentSpaceType+'.png"></span>';
            html += '<span class="nowLocation_content">24字方针系统设置 > ';
            html += '<a>组织计划类型管理</a>';
            html += '</span>';
            getCtpTop().showLocation(html);

        });
    </script>
</head>
<body>
    <div id='layout'>
        
        <div class="layout_north bg_color f0f0f0" id="north">
            <div id="toolbars"></div>
        </div>
        <div class="layout_center over_hidden" id="center">
            <table class="flexme3" id="perList"></table>
            <div id="grid_detail" class="h100b">
                <iframe id="summary" width="100%" height="100%" frameborder="0" scrolling="no" 
                 style="overflow-y:hidden"></iframe>
            </div>
        </div>
    </div>
</body>
</html>
