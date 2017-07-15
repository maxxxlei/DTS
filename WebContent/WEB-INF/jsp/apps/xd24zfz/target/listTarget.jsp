<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
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
     condition.push({id: 'memberId',name: 'memberId',type: 'input',text: "责任人",value: 'memberId'});
     //目标开始时间
     condition.push({id: 'startTime',name: 'starttime',type: 'datemulti',text: "目标开始时间",value: 'startTime',dateTime:true});
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
         if(choose === 'subject'){
             o.subject = $('#subject').val();
         }else if(choose === 'memberId'){
             o.memberId = $('#memberId').val();
         }else if(choose === 'startTime'){
             o.startTime = $('#startTime').val();
         }else if(choose === 'endTime'){
             o.endTime = $('#endTime').val();
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
     colModel.push({display: "责任人",name: 'memberId',width: '10%',align:'center'});
     colModel.push({display: "目标开始时间",name: 'startTime',width: '12%',align:'center'});
     colModel.push({display: "目标结束时间",name: 'endTime',width: '12%',align:'center'});
     colModel.push({display: "目标描述",name: 'description',width: '25%',align:'center'});
     
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
         	$.alert("abc");
         },
         managerName : "xd24TargetManager",
         managerMethod : "getTargetList"
     });
     function showInfo(data, r, c){
    	 
     }
     function dbclickRow(data, r, c){
    	 
     }
     
     function  addTarget(){
 		var dialog = $.dialog({
 			id	: 'url',
 			url : _ctxPath + '/target/xd24TargetController.do?method=newTarget',
 			width : 600,
 			height : 400,
 			isDrag : true,
 			targetWindow : getCtpTop(),
 			title : "新建目标"
 		});

     }
     function updateTarget(){
    	 
     }
     function deleteTarget(){
    	 
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