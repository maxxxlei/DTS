<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>规划计划</title>
<script type="text/javascript" src="${path}/ajax.do?managerName=versionManager"></script>
    
<script type="text/javascript">
var grid;
var edocDialog;
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
     toolbar.push({id: "newCreate",name: "新增",className: "ico16",click:addRow });
     //修改
     toolbar.push({id: "update",name: "修改",className: "ico16 editor_16",click:updateRow });
     //删除
     toolbar.push({ id: "delete",name: "删除",className: "ico16 del_16",click:deleteRow });
     //申请审批
     toolbar.push({ id: "enableVersion",name: "申请审批",className: "ico16 editor_16",click:enableRow });
     
     $("#toolbars").toolbar({
         borderLeft:false,
         borderTop:false,
         borderRight:false,
         toolbar: toolbar
     });
   //定义搜索条件选项
     var condition = new Array();
     //编号
     condition.push({id: 'vCode',name: 'vCode',type: 'input',text: "编号",value: 'vCode' });
     //规划名称
     condition.push({id: 'ghName',name: 'ghName',type: 'input',text: "规划名称",value: 'ghName' });
     //引用状态
     condition.push({id: 'createTime',name: 'createTime',type: 'datemulti',text: "创建时间",value: 'createTime', dateTime:true });
     
                
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
         if(choose === 'vCode'){
             o.value = $('#vCode').val();
         }else if(choose === 'createTime'){
        	 var startTime = $('#from_createTime').val();
        	 var endTime = $('#to_createTime').val();
             o.value  = startTime +"#"+ endTime;
         }else if(choose === 'ghName'){
             o.value  =  $('#ghName').val();
         }
         
         var val = searchobj.g.getReturnValue();
         if(val !== null){
             $("#guihuaList").ajaxgridLoad(o);
         }
     }
     var width = '20%';
     var nameWidth = '20%';
     //定义列表框选项栏目名称
     var colModel = new Array();
     colModel.push({display: 'id',name:'id',width: '4%',type: 'checkbox'});
     colModel.push({display: "审批状态",name:'state',width: nameWidth});
     colModel.push({display: "规划类型",name:'type',width: width});
     colModel.push({display: "标的物有无",name:'attachment',width: width});
     colModel.push({display: "规划名称",name:'ghName',width: width});
     colModel.push({display: "编制人",name:'memberId',width: width});
     colModel.push({display: "编制时间",name:'createTime',width: width});
     
     //构造列表
      grid = $('#guihuaList').ajaxgrid({
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
         managerName : "versionManager",
         managerMethod : "getVersion"
     });
     
     //初始化列表
     var o = new Object();
     //$('#guihuaList').ajaxgrid();
     $("#guihuaList").ajaxgridLoad(o);
     
     function showInfo(){
    	 var rows = grid.grid.getSelectRows();
         
         grid.grid.resizeGridUpDown('middle');
         $('#summary').attr("src",_ctxPath + "/xd24/versionController.do?method=editVersion&type=search&id="+rows[0].id);
   
   
     }
     function dbclickRow(){
    	 updateRow();
     }
     function enableRow(){
    	 var type = "enable";
    	 var rows = grid.grid.getSelectRows();
    	 
    	 var tranObj = new Array();
        
         if(rows.length === 0){
             $.alert("请选择一条记录!");//请选择一条记录
             return;
         }
         if(rows.length>1){
             $.alert("只能选择一条记录进行修改!");//只能选择一条记录进行修改
             return;
         }
         if(1 == rows[0].isEnable){
        	 $.alert("该版本已启用!");
             return;
         }
         var vsManager = new versionManager();
         tranObj[0] = rows[0].id;
         var confirm = $.confirm({
             'msg': "确定启用该版本？",//确定删除该权限，该操作无法恢复
             ok_fn: function () { 
                 vsManager.updateVersions(tranObj,type,{
                     success : function(msg){
                         if("SUCCESS" === msg){
                             $.alert("修改成功！");
                             var o = new Object();
                             //$('#guihuaList').ajaxgrid();
                             $("#guihuaList").ajaxgridLoad(o);
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
     
     
     
     function  addRow(){
     	//将新建页面显示
     	grid.grid.resizeGridUpDown('middle');
        $('#summary').attr("src",_ctxPath + "/xd24/versionController.do?method=newVersion&type=open");

          
      }
     
      function updateRow(){
    	  var rows = grid.grid.getSelectRows();
          if(rows.length === 0){
              $.alert("请选择一条记录!");//请选择一条记录
              return;
          }
          if(rows.length>1){
              $.alert("只能选择一条记录进行修改!");//只能选择一条记录进行修改
              return;
          }
          grid.grid.resizeGridUpDown('middle');
          $('#summary').attr("src",_ctxPath + "/xd24/versionController.do?method=editVersion&type=change&id="+rows[0].id);
    
      }
      function deleteRow(){
    	  debugger;
    	  var type = "del";
    	  var rows = grid.grid.getSelectRows();
          if(rows.length === 0){
              $.alert("请选择要删除的记录"); //请选择要删除的记录
              return;
          }
          var vsManager = new versionManager();
          var tranObj = new Array();
          for(i=0;i<rows.length;i++){
             //进行数据验证，是否可以进行删除操作
              tranObj[i] = rows[i].id;
          }
          var confirm = $.confirm({
              'msg': "确定删除该数据，该操作无法恢复",//确定删除该权限，该操作无法恢复
              ok_fn: function () { 
            	  vsManager.updateVersions(tranObj,type,{
                      success : function(msg){
                    	  if("SUCCESS" === msg){
                    		  $.alert("删除成功！");
                              var o = new Object();
                              //$('#guihuaList').ajaxgrid();
                              $("#guihuaList").ajaxgridLoad(o);
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
      html += '<a>版本管理列表</a>';
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
            <table class="flexme3" id="guihuaList"></table>
          <div id="grid_detail" class="h100b">
                <iframe id="summary" width="100%" height="100%" frameborder="0"  style="overflow-y:hidden"></iframe>
            </div> 
        </div>
    </div>
</body>
</html>