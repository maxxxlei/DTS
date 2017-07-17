<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=xd24ZzjhlxManger"></script>
<html>
<head>
<title>底部菜单</title>
</head>
<script>
    $(document).ready(function() {
    	var manager = new xd24ZzjhlxManger();
    	var rowsId = "${rowsId}";//获取选中id
        var flag="${flag}";
        debugger;
        if(flag=="show" || flag=="update"){
        	var zzjhlxVo = manager.getZzjhlxById(rowsId);
        	$("#myfrm").fillform(zzjhlxVo);
        	if(flag=="show"){
	        	$("#myfrm").disable();
	        	$("#bottomButton").hide();
        	}
        }
       
        if(flag=="new"){//新建
            $("#bottomButton").show();
            $("#mapName").val("");
            $("#isEnable").val("3"); 
            $("#description").val("");
        }
        debugger;
    });
    
    
    function OK() {
        var flag = "${flag}";
        debugger;
        if(flag=="new"){
            var o = $("#myfrm").formobj(); 
            o.isEnable= $("#isEnable").val(); 
            if(o.isEnable == ""){
                $.alert("请选择启用状态！");
                return;
            }
            
            
            var manager = new xd24ZzjhlxManger();//Manager类bean,id
            var ne = o.name;
             var flag = manager.checkZzjhlxByName(ne,null);
            if(flag){
                $.alert("规划名称重复，请修改！");
                return;
            } 
            
            alert('22s')
            manager.saveZzjhlx(o);//保存的方法名
            parent.location.href = _ctxPath + "/xd24/zzjhController.do?method=zzjhList"//controller里的方法名，进行页面跳转
            return;		
        }
        var rowsId = "${rowsId}";
        var o = new Object();
        o.name = $("#mapName").val();
        o.isEnable= $("#isEnable").val(); 
        o.desc = $("#descr").val();
        if(o.name == ""){
            $.alert("请输入组织计划名称！!");
            return;
        }
        if(o.isEnable == ""){
            $.alert("请点击是否启用菜单！!");
            return;
        }
        if(o.desc == ""){
            $.alert("请输入组织计划类型描述！!");
            return;
        }//判断是否为重复数据或者为自己
        var manager = new xd24ZzjhlxManger();//Manager类bean,id
        var ne = o.name;
         var flag = manager.getNameAndId(ne,rowsId);
        if(!flag){
        	$.alert("输入内容有误，可能出现重复值！");
        	return;
        } 
        alert("判断结束");
        manager.saveZzjhlx(o);//保存的方法名
        alert("进行跳转");
        parent.location.href = _ctxPath + "/xd24/zzjhController.do?method=xdcd24SearchList"
        		
    }
    
   
</script>
<body>
    <div>
          <form id="myfrm" name="myfrm" align="center" method="post">
            <div class="form_area" id='form_area'  align="center" >
            <table border="0" cellspacing="0" cellpadding="0" class="margin_lr_10 margin_t_10" align="center" width="450">
                <br>
              <tr>
                <th width="90px"><font color="red">*</font><label class="margin_r_10" for="text">组织计划名称:</label></th>
                <td>
                  <div><!--     readonly unselectable="on"
                    <input type="text" id="spc1" name="spc1" class="comp" comp="type:'selectPeople',mode:'open',selectType:'Member',value:'',text:''"/>-->
                    <input type="text" id="name" class="validate" validate="type:'string',name:'组织计划名称',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'" style="width:350px"/>
                </td>
              </tr>
              <tr>
              <th><font color="red">*</font><label class="margin_r_10" for="text" readonly=”true”>是否启用:</label></th>
                <td>
                  <div>
                    <select id ="isEnable">
                        <option value ="">请选择</option>
                        <option value ="1">是</option>
                        <option value ="0">否</option>
                    </select>
                  </div>
                </td>
              </tr>
              <tr>
                <th><font color="red">*</font><label class="margin_r_10" for="text">组织计划描述:</label></th>
                <td>
                  <div ><!-- checked="true" -->
                    <textarea id ="desc" validate="type:'string',name:'组织计划描述',notNull:true,maxLength:5070,avoidChar:'!@#$%^&amp;*+|,'" name="组织计划描述" style="width:350px;height:80px;"></textarea>
                  </div>
                </td>
              </tr>
            </table> 
            <div class="stadic_layout_footer stadic_footer_height" id="bottomButton">
                <div id="button" align="center" class="page_color button_container">
                    <div class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
                       <a href="javascript:OK()" class="common_button common_button_emphasize margin_r_10 hand" id="edit_confirm_button">${ctp:i18n('permission.confirm')}</a>&nbsp;<%--确定 --%>
                        <a href="javascript:void(0)" class="common_button common_button_gray" id="edit_cancel_button">${ctp:i18n('permission.cancel')}</a><%--取消 --%>
                    </div>
                </div>
            </div>
            </div> 
          </form>
    </div> 
</body>
</html>