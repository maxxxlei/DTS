<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript"
	src="${path}/ajax.do?managerName=xd24quotaManager"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>底部菜单</title>
<script>
$(document).ready(function() {
	//提交表单
	$("#submit")
			.click(
					function() {
						$
								.ajax({
									type : "post",
									dataType : "json",
									url : _ctxPath
											+ '/xd24quota/xd24quotaController.do?method=saveQuota',
									async : false,
									data : getFormData(),
									success : function(result) {
										if (result) {
											$.alert("目标录入成功！");
											window.close();
											window.location.href = _ctxPath
													+ '/xd24quota/xd24quotaController.do?method=quotaList';
										} else {
											$.alert("保存数据失败！");
										}
									},
									error : function() {
										$.alert("服务器异常！");
									}
								});
					});
	$(document).ready(function() {
		function getFormData() {
			var year = $("#name").val();
			var bzsj = $("#code").val();
			var sxsj = $("#qclass").val();
			var wjh = $("#unit").val();
			var bh = $("#type").val();
			var data = {
				name : name,
				code : code,
				qclass : qclass,
				unit : unit,
				type : type,
			}
			return data;
		}
	});
</script>
</head>
<body>

	<div>
		<form id="myfrm" name="myfrm" align="center" method="post">
			<div class="form_area" id='form_area' align="center">
				<input type="hidden" id="id" class="validate"
					validate="type:'string',name:'编号',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'" />
				<input type="hidden" id="departCode" class="validate"
					validate="type:'string',name:'兼职部门代码',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'" />
				<table border="0" cellspacing="0" cellpadding="0"
					class="margin_lr_10 margin_t_10" align="center" width="700px">
					<br>
					<tr>
						<th width="100px"><font color="red">*</font><label
							class="margin_r_10" for="text">指标分类:</label></th>
						<td>
							<div>
								<select style="width: 90px" id="qclass">
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
								<!--     readonly unselectable="on"
					<input type="text" id="spc1" name="spc1" class="comp" comp="type:'selectPeople',mode:'open',selectType:'Member',value:'',text:''"/>-->
								<input type="text" id="name" class="validate"
									validate="type:'string',name:'指标项',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"
									style="width: 200px" />
						</td>

					</tr>
					<tr>
						<th><font color="red">*</font><label class="margin_r_10"
							for="text">度量:</label></th>
						<td>
							<div>
								<select style="width: 90px" id="unit">
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
								<!--     readonly unselectable="on"
					<input type="text" id="spc1" name="spc1" class="comp" comp="type:'selectPeople',mode:'open',selectType:'Member',value:'',text:''"/>-->
								<input type="text" id="code" class="validate"
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
								<select style="width: 90px" id="type">
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
						<div
							class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
							<a href="javascript:OK()"
								class="common_button common_button_emphasize margin_r_10 hand"
								id="submit">${ctp:i18n('permission.confirm')}</a>&nbsp;
							<%--确定 --%>
							<a href="javascript:void(0)"
								class="common_button common_button_gray" id="edit_cancel_button">${ctp:i18n('permission.cancel')}</a>
							<%--取消 --%>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


</body>
</html>