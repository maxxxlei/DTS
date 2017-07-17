<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<script type="text/javascript">

function OK(){
	$("#addForm")
}

function cancel(){
	
}
</script>
<body>
	<form name="addForm" id="addForm" method="post">
		<div class="form_area">
			<div class="one_row">
				<p class="align_right">
					<font color="red">*</font>菜单管理
				</p>
				<table border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<input type="hidden" name="orgAccountId" id="orgAccountId"
							value="" />
						<input type="hidden" name="id" id="id" value="" />
						<tr>
							<th nowrap="nowrap"><label class="margin_r_10" for="text"><font
									color="red">*</font>菜单名称:</label></th>
							<td>
								<div class="common_txtbox_wrap">
									<input type="text" id="name" class="validate"
										validate="type:'string',name:'菜单名称',notNullWithoutTrim:true,minLength:1,maxLength:80,avoidChar:'\\/|><:*!@#$%^&amp;*+|,\'&quot'">
								</div>
							</td>
						</tr>
						<tr id="categoryId_area">
							<th nowrap="nowrap"><label class="margin_r_10" for="text"><font
									color="red">*</font>菜单类型:</label></th>
							<td>
								<div class="common_selectbox_wrap">
									<select id="categoryId" name="categoryId" class="codecfg "
										codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.MenuCategoryEnum'">
										<option value="">${ctp:i18n('level.select.choose')}</option>
									</select>
								</div>

							</td>
						</tr>
						<tr id="levelId_area">
							<th nowrap="nowrap"><label class="margin_r_10" for="text"><font
									color="red">*</font>菜单级别:</label></th>
							<td>
								<div class="common_selectbox_wrap">
									<select id="menuLevelId" name="menuLevel" class="codecfg "
										codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.MenuLevelEnum'">
										<option value="">${ctp:i18n('level.select.choose')}</option>
									</select>
								</div>

							</td>
						</tr>
						<tr>
							<th nowrap="nowrap"><label class="margin_r_10" for="text"><font
									color="red">*</font>菜单资源:</label></th>
							<td>
								<div class="common_txtbox_wrap">
									<input type="text" id="navurl" class="validate"
										validate="type:'string',name:'菜单资源',notNullWithoutTrim:true,minLength:1,maxLength:1000,avoidChar:'\\/|><:*!@#$%^&amp;*+|,\'&quot'">
								</div>
							</td>
						</tr>
						<tr>
							<th nowrap="nowrap"><label class="margin_r_10" for="text"><font
									color="red">*</font>资源编号:</label></th>
							<td>
								<div class="common_txtbox_wrap">
									<input type="text" id="resourceCode" class="validate"
										validate="type:'string',name:'资源编号',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'">
								</div>

							</td>
						</tr>
						<tr>
							<th nowrap="nowrap"><label class="margin_r_10">是否启用:</label></th>
							<td width="100%">
								<div class="common_radio_box left margin_t_5">
									<label class="margin_r_10 hand" for="radio1"> <input
										type="radio" id='radio1' name="isEnable" value="1"
										class="radio_com" checked="checked" />启用
									</label> <label class="margin_r_10 hand" for="radio0"> <input
										type="radio" id='radio0' name="isEnable" value="0"
										class="radio_com" />停用
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<th nowrap="nowrap"><label class="margin_r_10" for="text">排序号:</label></th>

							<td width="100%">
								<div class="common_txtbox_wrap">
									<input type="text" id="sortCode" class="validate"
										validate="type:'number',isInteger:true,name:'排序号',minValue:1,notNull:true,minLength:1,maxValue:99">
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
            <div class="stadic_layout_footer stadic_footer_height" id="bottomButton">
                <div id="button" align="center" class="page_color button_container">
                    <div class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
                       <a href="javascript:OK()" class="common_button common_button_emphasize margin_r_10 hand" id="edit_confirm_button">${ctp:i18n('permission.confirm')}</a>&nbsp;<%--确定 --%>
                        <a href="javascript:cancel()" class="common_button common_button_gray" id="edit_cancel_button">${ctp:i18n('permission.cancel')}</a><%--取消 --%>
                    </div>
                </div>
            </div>
		</div>
	</form>


</body>
</html>