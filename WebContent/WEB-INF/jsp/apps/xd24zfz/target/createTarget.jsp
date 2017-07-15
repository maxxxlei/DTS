<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${path }/apps_res/xd24zfz/js/khzq.js"></script>
<title>目标录入页面</title>
<script>
$(document).ready(function() {
	//选择人员
	$("#selectPeople").click(function selectPeopleAuth(auth,authValue){
		$.selectPeople({
			text : auth,
			value : authValue,
			params: {
			   value: authValue
			},
			isNeedCheckLevelScope:false,
			type : 'selectPeople',
			panels : "Department,Team,Post,Level,Outworker,Account",
			selectType : "Member",
			maxSize : 10,
			onlyLoginAccount : false,
			hiddenPostOfDepartment:true,
			minSize: 0,
			callback : function(ret) {
				$("#userName").val(ret.text);
				var memberCode = ret.value;
				var code = memberCode.substring(7);
				$("#userCode").val(code);
			}
		});
	});
});
</script>
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
				<td><input type="text" value="${user.postName }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>单位</td>
				<td><input type="text" value="${user.accountName }" readonly="readonly"></td>
				<td>中心</td>
				<td><input type="text" value="" readonly="readonly"></td>
				<td>部门</td>
				<td><input type="text" value="${user.departMentName }" readonly="readonly"></td>
				<td>组</td>
				<td><input type="text" value="" readonly="readonly"></td>
				<td>责任人</td>
				<td><input type="text" value="${user.name }" readonly="readonly"></td>
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
		</table>
		<table>
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
				<td><textarea rows="1" cols="1"></textarea></td>
			</tr>
		</table>
		<table>
			<div>目标考核项</div>
			<tr>1.1 考核指标项</tr>
			<thead>
				<td>序号</td>
				<td>考核周期</td>
				<td>考核周期细项</td>
				<td>月</td>
				<td>考核开始日</td>
				<td>考核截止日</td>
				<td>指标项</td>
				<td>度量</td>
				<td>要求</td>
				<td>目标值</td>
				<td>协同责任人</td>
			</thead>
			<tr>
				<td><input type="text"></td>
				<td>
					<select id="khzq" name="khzq">
					</select>
				</td>
				<td>
					<select id="khzqxx" name="khzqxx">
					</select>
					<script>init_khzq()</script>
				</td>
				<td>
					<select id="month" name="month">
						<option value="">请选择</option>
						<option value="1">1月</option>
						<option value="2">2月</option>
						<option value="3">3月</option>
						<option value="4">4月</option>
						<option value="5">5月</option>
						<option value="6">6月</option>
						<option value="7">7月</option>
						<option value="8">8月</option>
						<option value="9">9月</option>
						<option value="10">10月</option>
						<option value="11">11月</option>
						<option value="12">12月</option>
					</select>
				</td>
				<td><input type="date" id="khksrq"></td>
				<td><input type="date" id="khjzrq"></td>
				<td><input type="text" id="zbx"></td>
				<td><input type="text" id="dl"></td>
				<td>
					<select id="yq" name="yq">
						<option value="0">请选择</option>
						<option value="1">大于</option>
						<option value="2">小于</option>
						<option value="3">等于</option>
						<option value="4">大于等于</option>
						<option value="5">小于等于</option>
						<option value="6">有无</option>
					</select>
				</td>
				<td><input type="text" id="mbz"></td>
				<td>
					<input type="text" id="userName" class="validate" validate="type:'string',name:'协同责任人',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'" style="width:200px" readonly unselectable="on"/>
                    <span id="selectPeople" class="ico16 radio_people_16 _autoBtn"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>