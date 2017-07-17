<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=xd24Manager"></script>
<html>
<head>
<title>底部菜单</title>
</head>
<script>
	$(document).ready(function() {
		var flag="${flag}";
		debugger;
		if(flag=="show"){
			$("#bottomButton").hide();
			$("#mapName").val("1");
            $("#isEnable").val("1"); 
            $("#description").val("浏览");
			$("#mapName").prop("disabled", true);
			$("#isEnable").prop("disabled", true);
			$("#description").prop("disabled", true);
			$("#id").val("111");
		}
		if(flag=="update"){
			$("#bottomButton").show();
            $("#mapName").val("2");
            $("#isEnable").val("0"); 
            $("#description").val("编辑");
            $("#id").val("111");
        }
		if(flag=="new"){
			$("#bottomButton").show();
            $("#mapName").val("");
            $("#isEnable").val("3"); 
            $("#description").val("");
        }
		debugger;
	});
	function OK() {
	    alert("AAA");
	}
</script>
<body>
    <div>
          <form id="myfrm" name="myfrm" align="center" method="post">
          	<div class="form_area" id='form_area'  align="center" >
            <input type="hidden" id="id" class="validate" validate="type:'string',name:'编号',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"/>
            <input type="hidden" id="departCode" class="validate" validate="type:'string',name:'兼职部门代码',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"/>
            <table border="0" cellspacing="0" cellpadding="0" class="margin_lr_10 margin_t_10" align="center" width="400">
                <br>
              <tr>
                <!-- <th width="90px"><font color="red">*</font><label class="margin_r_10" for="text">组织计划名称:</label></th> -->
                <td>
                  <div><!--     readonly unselectable="on"
					<input type="text" id="spc1" name="spc1" class="comp" comp="type:'selectPeople',mode:'open',selectType:'Member',value:'',text:''"/>-->
                    <input type="text" id="name" class="validate" validate="type:'string',name:'战略地图名称',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'" style="width:300px"/>
                </td>
              </tr>
              <tr>
              <th><font color="red">*</font><label class="margin_r_10" for="text">是否启用:</label></th>
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
                <th><font color="red">*</font><label class="margin_r_10" for="text">战略地图描述:</label></th>
                <td>
                  <div ><!-- checked="true" -->
					<textarea id ="description" name="规划类型描述" style="width:300px;height:80px;"></textarea>
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