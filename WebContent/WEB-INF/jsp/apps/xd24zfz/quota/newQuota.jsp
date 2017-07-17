<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript"
	src="${path}/ajax.do?managerName=xd24quotaManager"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>底部菜单</title>
<script type="text/javascript">
$(function(){
	//表单提交
	 $("#quotaSubmit").click(function(){
		 var form = $("#quota_edit_form");
         var path = _ctxPath + "/xd24/quotaController.do?method=newQuota";
         
         form.attr('action',path);
         $('#quotaSubmit')[0].disabled = false;
         form.jsonSubmit({
             validate : true,
             errorIcon : true,
             collbackError:function(){
         	   subCount = 0;
             },
             callback:function(args){
             	//refreshW();
             }
         });
	 })
})
</script>
</head>
<body>

	<div>
	  
		<form id="quota_edit_form" class="h100b" name="myfrm" align="center" method="post">
		<input type="submit" value="提交" id="quotaSubmit">
			<div class="form_area" id='form_area' align="center">
				<table border="0" cellspacing="0" cellpadding="0"
					class="margin_lr_10 margin_t_10" align="center" width="700px">
					<br>
					<tr>
						<th width="100px"><font color="red">*</font><label
							class="margin_r_10" for="text">指标分类:</label></th>
						<td>
							<div>
								<select style="width: 90px" id="quotaClass">
									<option value="">请选择</option>
									<option value="1">财务指标</option>
									<option value="2">间接财务指标</option>
									<option value="3">业务指标</option>
								</select>
							</div>
						</td>
						<th width="90px"><font color="red">*</font><label
							class="margin_r_10" for="text">指标项:</label></th>
						<td>
							<div>
								<input type="text" id="quotaName" class="validate"
									validate="type:'string',name:'指标项',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"
									style="width: 200px" />
						</td>
					</tr>
					<tr>
						<th><font color="red">*</font><label class="margin_r_10"
							for="text">度量:</label></th>
						<td>
							<div>
								<select style="width: 90px" id="quotaUnit">
									<option value="">请选择</option>
									<option value="1">元</option>
									<option value="2">倍数</option>
									<option value="3">次数</option>
									<option value="4">小时</option>
									<option value="5">百分比</option>
									<option value="6">金额</option>
									<option value="7">个数</option>
								</select>
							</div>
						<th width="50px"><font color="red">*</font><label
							class="margin_r_10" for="text">编号:</label></th>
						<td>
							<div>
								<input type="text" id="quotaCode" class="validate"
									validate="type:'string',name:'编号',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"
									style="width: 40px" />
						</td>
						</td>
					</tr>
					<tr>
						<th><font color="red">*</font><label class="margin_r_10"
							for="text">指标控件类型:</label></th>
						<td>
							<div>
								<select style="width: 90px" id="quotaType">
									<option value="">请选择</option>
									<option value="1">数字</option>
									<option value="2">日期</option>
									<option value="3">金额</option>
									<option value="4">百分比</option>
									<option value="5">附件</option>
									<option value="6">日期时间</option>
									<option value="7">文本</option>
								</select>
							</div>
						</td>
						<!-- <td>
                  <div >checked="true"
					<textarea id ="description" name="战略地图描述" style="width:300px;height:80px;"></textarea>
                  </div>
                </td> -->
					</tr>
				</table>
				<div class="stadic_layout_footer stadic_footer_height"
					id="bottomButton">
					<div id="button" align="center" class="page_color button_container">
						<%-- <div
							class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
							<a href="javascript:OK()"
								class="common_button common_button_emphasize margin_r_10 hand"
								id="submit">${ctp:i18n('permission.confirm')}</a>&nbsp;
							确定
							<a href="javascript:void(0)"
								class="common_button common_button_gray" id="edit_cancel_button">${ctp:i18n('permission.cancel')}</a>
							取消
						</div> --%>
					</div>
				</div>
			</div>
		</form>
	</div>


</body>
</html>