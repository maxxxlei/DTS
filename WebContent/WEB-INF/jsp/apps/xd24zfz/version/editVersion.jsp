<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本控制</title>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
   <form id="version_edit_form" class="h100b">
   
   <input type="submit" value="提交" id="versionSubmit">
     <table style="border: solid;1px">
	   
        <thead>
           <tr><th>版本管理</th></tr></thead>
        <thead>
           <tr>
               <td>年度</td>
               <td><input type="text" id="v_Year"></td>
               <td>创建时间</td>
               <td><input id="create_time" type="text"></td>
           </tr>
           <tr>
               <td>版本编号</td>
               <td><input type="text" id="vCode"></td>
               <td></td>
               <td></td>
           </tr>
           <tr>
               <td>是否启用</td>
	              <td><select id="is_Enable">
							<option value="">--请选择--</option>
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
				   </td>
               <td>版本是否生效</td>
               <td><select id="is_State">
							<option value="">--请选择--</option>
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
				   </td>
           </tr>
           <tr>
               <td>描述</td>
               <td rowspan="3"><td><input type="text" id="desc"></td></td>
           </tr>
        </thead>
     </table>
     </form>
</body>
</html>