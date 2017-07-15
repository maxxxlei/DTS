<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本控制</title>
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
     //启用
     toolbar.push({ id: "enableVersion",name: "启用",className: "ico16 editor_16",click:updateRow });
     //停用
     toolbar.push({ id: "disableVersion",name: "停用",className: "ico16 editor_16",click:updateRow });
    
     
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
     //引用状态
     condition.push({id: 'isRef',name: 'isRef',type: 'select',text: "${ctp:i18n('permission.auth.isref')}",value: 'isRef',
         items: [{
             text: "${ctp:i18n('systemswitch.yes.lable')}",//是
             value: '1'
         }, {
             text: "${ctp:i18n('systemswitch.no.lable')}",//否
             value: '0'
         }]
     });
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
             $("#permissionList").ajaxgridLoad(o);
         }
     }
     var width = '10%';
     var nameWidth = '20%';
   //定义列表框选项栏目名称
     var colModel = new Array();
     colModel.push({display: 'id',name:'id',width: '4%',type: 'checkbox'});
     colModel.push({display: "年度",name:'vYear',width: nameWidth});
     colModel.push({display: "版本编号",name:'vCode',width: width});
     colModel.push({display: "是否启用",name:'isEnable',width: width});
     colModel.push({display: "是否生效",name:'state',width: width});
     colModel.push({display: "创建时间",name:'createTime',width: width});
     
     //构造列表
      grid = $('#versionList').ajaxgrid({
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
     //$('#versionList').ajaxgrid();
     debugger;
     $("#versionList").ajaxgridLoad(o);
     
     function showInfo(){
    	 
     }
     function dbclickRow(){
    	 
     }
     
     function  addRow(){
     	//将新建页面显示
     	edocDialog = $.dialog({
                     url:"${path}/versionController.do?method=newVersion",
                     width: 800,
                     height: 400,
                     title: "新增版本信息",
                     targetWindow:getCtpTop()
                   });
          
      }
      function updateRow(){
     	 
      }
      function deleteRow(){
     	 
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
            <table class="flexme3" id="versionList"></table>
          <!--   <div id="grid_detail" class="h100b">
                <iframe id="summary" width="100%" height="100%" frameborder="0"  style="overflow-y:hidden"></iframe>
            </div> --> 
        </div>
    </div>
</body>
</html>