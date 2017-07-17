<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>录入</title>
<link rel="stylesheet" type="text/css" href="${path }/apps_res/xd24zfz/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${path }/apps_res/xd24zfz/css/css.css">
</head>
<body>
	<div class="goal-layout">
		<div class="goal-header">
			<button class="btn btn-default goal-btn">保存</button>
			<button class="btn btn-primary">提交审批</button>
		</div>
	</div>
	<div class="stadic_content" style="height:100%;">
		<iframe width="100%" height="100%" frameborder="0" src="${path }/xd24/targetController.do?method=transTargetForm"></iframe>
	</div>
</body>
</html>