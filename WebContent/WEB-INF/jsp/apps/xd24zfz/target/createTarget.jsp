<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>目标录入页面</title>
</head>
<body>
	<form method="post">
		<input type="submit" value="保存">
		<input type="reset" value="重置">
		<table border="1">
			<tr>
				<td>年度</td>
				<td><input type="text" value=""></td>
				<td>编制时间</td>
				<td><input type="date" ></td>
				<td>生效时间</td>
				<td><input type="date" ></td>
				<td>文件号</td>
				<td><input type="text" ></td>
				<td>编号</td>
				<td><input type="text" ></td>
				<td>岗位</td>
				<td><input type="text" value="${user.postName }"></td>
			</tr>
			<tr>
				<td>单位</td>
				<td><input type="text" value="${user.accountName }"></td>
				<td>中心</td>
				<td><input type="text" value=""></td>
				<td>部门</td>
				<td><input type="text" value="${user.departMentName }"></td>
				<td>组</td>
				<td><input type="text" value=""></td>
				<td>责任人</td>
				<td><input type="text" value="${user.name }"></td>
			</tr>
		</table>
		<table id="sjmb">
			<tr>上级目标信息</tr>
			<tr>
				<td>上级目标编号</td>
				<td><input type="text" id="smbbh"></td>
				<td>上级目标维度</td>
				<td><input type="text" id="smbwd"></td>
				<td>上级目标名称</td>
				<td><input type="text" id="smbmc"></td>
			</tr>
			<tr>目标承接</tr>
			<tr>
				<td>目标编号</td>
				<td><input type="text" id="mbbh"></td>
				<td>战略地图维度</td>
				<td>
					<select id="zldtwd" name="zldtwd">
						<option value="">--请选择--</option>
						<option value="0">财务担当</option>
						<option value="1">内部运营与管理</option>
						<option value="2">外部市场与客户</option>
						<option value="3">组织能力提升</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>目标名称</td>
				<td><input type="text" id="mbmc"></td>
				<td>目标来源</td>
				<td>
					<input type="radio" name="targetAttr" id="bcmc" value="0">补充目标
					<input type="radio" name="targetAttr" id="cjmc" value="1">承接目标
					<input type="radio" name="targetAttr" id="jtmc" value="2">集团目标(首目标)
				</td>
			</tr>
			<tr>
				<td>目标起止时间</td>
				<td><input type="date" id="startDate"></td>
				<td>-</td>
				<td><input type="date" id="endDate"></td>
				<td>是否关键</td>
				<td>
					<input type="radio" name="isDelete" id="yes" value="0">是
					<input type="radio" name="isDelete" id="no" value="1">否
				</td>
			</tr>
			<tr>
				<td>目标描述</td>
				<td><input type="text" id="mbms"></td>
			</tr>
		</table>
	</form>
</body>
</html>