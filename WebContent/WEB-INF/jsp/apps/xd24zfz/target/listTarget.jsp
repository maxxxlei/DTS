<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path }/ajax.do?managerName=xd24TargetManager"></script>
<!--

//-->
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>目标管理</title>
    
<script type="text/javascript">
var grid;
$(function(){
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
     toolbar.push({id: "newCreate",name: "新增",className: "ico16",click:addTarget });
     //修改
     toolbar.push({id: "update",name: "修改",className: "ico16 editor_16",click:updateTarget });
     //删除
     toolbar.push({ id: "delete",name: "删除",className: "ico16 del_16",click:deleteTarget });
     
     //工具条
     $("#toolbars").toolbar({
         borderLeft:false,
         borderTop:false,
         borderRight:false,
         toolbar: toolbar
     });
     
     
   	 //定义搜索条件选项
     var condition = new Array();
     //目标名称
     condition.push({id: 'subject',name: 'subject',type: 'input',text: "目标名称",value: 'subject',maxLength:20,validate:false});
     //责任人
     condition.push({id: 'memberId',name: 'memberId',type: 'selectPeople',text: "责任人",value: 'memberId',comp:"type:'selectPeople',mode:'open',panels:'Department,Team,Post,Level',selectType:'Member',maxSize:1"});
     //目标开始时间
     condition.push({id: 'startTime',name: 'startTime',type: 'datemulti',text: "目标开始时间",value: 'startTime',dateTime:true});
     //目标结束时间
     condition.push({id: 'endTime',name: 'endTime',type: 'datemulti',text: "目标结束时间",value: 'endTime',dateTime:true});
     
    
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
         if(choose === 'subject'){
             o.value = $('#subject').val();
         }else if(choose === 'memberId'){
             o.value = $('#memberId').val();
         }else if(choose === 'startTime'){
             var sDate = $('#from_startTime').val();
             var eDate = $('#to_startTime').val();
             o.value = sDate +"#"+eDate;
             alert(o.value);
         }else if(choose === 'endTime'){
        	 var sDate = $('#from_endTime').val();
             var eDate = $('#to_endTime').val();
        	 o.value = sDate +"#"+eDate;
         }
         var val = searchobj.g.getReturnValue();
         if(val !== null){
             $("#targetList").ajaxgridLoad(o);
         }
     }
   
   
   //定义列表框选项栏目名称
     var colModel = new Array();
     colModel.push({display: 'id',name: 'id',width: '2%',type: 'checkbox',align:'center'});
     colModel.push({display: "目标名称",name: 'subject',width: '15%',align:'center'});
     colModel.push({display: "编制时间",name: 'createTime',width: '12%',align:'center'});
     colModel.push({display: "生效时间",name: 'effectTime',width: '12%',align:'center'});
     colModel.push({display: "责任人",name: 'memberName',width: '10%',align:'center'});
     colModel.push({display: "目标开始时间",name: 'startTime',width: '12%',align:'center'});
     colModel.push({display: "目标结束时间",name: 'endTime',width: '12%',align:'center'});
     
     //构造列表
      grid = $('#targetList').ajaxgrid({
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
         },
         managerName : "xd24TargetManager",
         managerMethod : "getTargetList"
     });
     var o = new Object();
     $("#targetList").ajaxgridLoad(o);
     
     function showInfo(data, r, c){
    	 
     }
     function dbclickRow(data, r, c){
    	 
     }
     
     function  addTarget(){
    	  var url = _ctxPath + '/xd24/targetController.do?method=newTarget';
    	  openCtpWindow({"url":url});   
    	 /* var dialog = $.dialog({
 			id	: 'url',
 			url : _ctxPath + '/xd24/targetController.do?method=newTarget',
 			width : $(window).width(),
 			height : $(window).height(),
 			isDrag : true,
 			targetWindow : getCtpTop(),
 			title : "新建目标"
 		}); */
 		/* *var url = _ctxPath + '/xd24/targetController.do?method=newTarget';
 		var width = $(window).width();
        var height = $(window).height();
 		window.open(url, 'newwindow', height, width, 'top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); */
     }
     function updateTarget(){
    	 
     }
     function deleteTarget(){
    	 var rows = grid.grid.getSelectRows();
         if(rows.length === 0){
             $.alert("请选择要删除的记录"); //请选择要删除的记录
             return;
         }
         var tManager = new xd24TargetManager();
         debugger;
         var tranObj = new Array();
         for(i=0;i<rows.length;i++){
            //进行数据验证，是否可以进行删除操作
             tranObj[i] = rows[i].id;
         }
         var confirm = $.confirm({
             'msg': "确定删除该数据，该操作无法恢复",//确定删除该权限，该操作无法恢复
             ok_fn: function () { 
            	 tManager.deleteTargets(tranObj,{
                     success : function(msg){
                         if("SUCCESS" === msg){
                             $.alert("删除成功！");
                             var o = new Object();
                             //$('#versionList').ajaxgrid();
                             $("#targetList").ajaxgridLoad(o);
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
            <table class="flexme3" id="targetList"></table>
        </div>
    </div>
</body>
</html>