<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=xd24ZldtwdManager"></script>
<html>
<head>
<title>底部菜单</title>
</head>
<script>
	$(document).ready(function() {
		var flag="${flag}";
		if(flag=="show"){
			$("#bottomButton").hide();
			var id = "${id}";
			var manager = new xd24ZldtwdManager();
			var zldtwd = manager.getZldtwdById(id);
			$("#id").val(zldtwd.id);
			$("#mapName").val(zldtwd.name);
			if(zldtwd.isEnable=='否'){
				$("input[id='isEnable'][value='0']").attr("checked",true).attr("disabled", true);
				$("input[id='isEnable'][value='1']").attr("disabled", true);
			}
			if(zldtwd.isEnable=='是'){
				$("input[id='isEnable'][value='1']").attr("checked",true).attr("disabled", true);
				$("input[id='isEnable'][value='0']").attr("disabled", true);
            }
            $("#description").val(zldtwd.description);
			$("#mapName").attr("disabled", true);
			$("#isEnable").attr("disabled", true);
			$("#description").attr("disabled", true);
		}
		if(flag=="update"){
			$("#bottomButton").show();
			var id = "${id}";
            var manager = new xd24ZldtwdManager();
            var zldtwd = manager.getZldtwdById(id);
            $("#id").val(zldtwd.id);
            $("#mapName").val(zldtwd.name);
            if(zldtwd.isEnable=='否'){
                $("input[id='isEnable'][value='0']").attr("checked",true);
            }
            if(zldtwd.isEnable=='是'){
                $("input[id='isEnable'][value='1']").attr("checked",true);
            }
            $("#description").val(zldtwd.description);
        }
		if(flag=="new"){
			$("#bottomButton").show();
            $("#mapName").val("");
            $("#isEnable").removeAttr("checked");
            $("#description").val("");
        }
	});
	function OK() {
		debugger;
		var re = $("#myfrm").validate();
		if(re == false){
			return;
		}
		var flag = "${flag}";
		debugger;
		if(flag=="new"){
			var o = new Object();
            o.name = $("#mapName").val();
            o.isEnable= $('input:radio[id="isEnable"]:checked').val();
            o.description = $("#description").val();
			if(o.name==""){
				$.alert("请输入战略地图名称！");
				return;
			}
			if(o.isEnable == undefined){
                $.alert("请选择是否启用状态！");
                return;
            }
			if(o.description==""){
                $.alert("请输入战略地图描述！");
                return;
            }
			var manager = new xd24ZldtwdManager();
			var canNew = manager.getSumZldtwName(o.name,"",true);
			debugger;
			if(canNew){
				manager.saveZldtwd(o);
				parent.location.href = _ctxPath + "/xd24/zldtwdController.do?method=zldtwdList"
			}else{
				$.alert("系统中已存在该战略地图名称，请检查！！");
                return;
			}
        }
		if(flag=="update"){
		      var o = new Object();
	          o.id = "${id}";
		      o.name = $("#mapName").val();
		      o.isEnable= $('input:radio[id="isEnable"]:checked').val();
		      o.description = $("#description").val();
		      if(o.name==""){
		          $.alert("请输入战略地图名称！");
		          return;
		      }
		      if(o.isEnable == undefined){
		          $.alert("请选择是否启用状态！");
		          return;
		      }
		      if(o.description==""){
		          $.alert("请输入战略地图描述！");
		          return;
		      }
		      var manager = new xd24ZldtwdManager();
				var canUpdate = manager.getSumZldtwName(o.name,o.id,false);
				if(canUpdate){
					manager.updateZldtwd(o);
		            parent.location.href = _ctxPath + "/xd24/zldtwdController.do?method=zldtwdList"
				}else{
				    $.alert("系统中已存在该战略地图名称，请检查！");
				    return;
				}
		 }
	}
	function cancel(){
		parent.location.href = _ctxPath + "/xd24/zldtwdController.do?method=zldtwdList"
	}
</script>
<body>
	<div>
		<form id="myfrm" name="myfrm" align="center" method="post">
			<div class="form_area" id='form_area' align="center">
					<input type="hidden" id="id" />
					<table border="0" cellspacing="0" cellpadding="0"
						class="margin_lr_10 margin_t_10" align="center" width="400">
						<br>
						<tr>
							<th width="95px"><font color="red">*</font><label
								class="margin_r_10" for="text">战略地图名称:</label></th>
							<td>
								<div>
									<input type="text" id="mapName" class="validate" validate="type:'string',name:'战略地图名称',notNull:true,maxLength:'80',avoidChar:'!@#$%^&amp;*+|,'" style="width: 300px" />
								</div>
							</td>
						</tr>
						<tr>
							<th><font color="red">*</font><label class="margin_r_10"
								for="text">是否启用:</label></th>
							<td>
								<div  align="left">&nbsp&nbsp
									<input type="radio" id="isEnable" name="enable" value="1">是&nbsp&nbsp 
									<input type="radio" id="isEnable" name="enable" value="0"> 否<br>
								</div>
							</td>
						</tr>
						<tr>
							<th><font color="red">*</font><label class="margin_r_10" for="text">战略地图描述:</label></th>
							<td>
								<div>
									<textarea id="description" name="description" class="validate" validate="type:'string',name:'战略地图描述',notNull:true,maxLength:'5000',avoidChar:'!@#$%^&amp;*+|,'"  style="width: 300px; height: 80px;"></textarea>
								</div>
							</td>
						</tr>
					</table>
					<div class="stadic_layout_footer stadic_footer_height"
						id="bottomButton">
						<div id="button" align="center"
							class="page_color button_container">
							<div
								class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
								<a href="javascript:OK()"
									class="common_button common_button_emphasize margin_r_10 hand"
									id="edit_confirm_button">确定</a>&nbsp;
								<a href="javascript:cancel()"
									class="common_button common_button_gray"
									id="edit_cancel_button">取消</a>
							</div>
						</div>
					</div>
				</div>
		</form>
	</div>
</body>
</html>