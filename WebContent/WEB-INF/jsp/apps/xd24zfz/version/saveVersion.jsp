<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本控制</title>
<script type="text/javascript" src="${path}/ajax.do?managerName=versionManager"></script>
<script type="text/javascript">
$(function(){
	//表单提交
	 $("#versionSubmit").click(function(){
		 var valResult = $("#v_Year").validate();
		 if(valResult == false){
			 $.alert("验证失败！");
			 return;
		 }
		 
		 var year =  $("#v_Year").val();
		 var code =  $("#vCode").val();
		 if(year == null || code == null || year == "" || code == ""){
			 $.alert("年度或版本编号不能为空！");
			 return;
		 }
		 //根据vcode和vyear判断数据是否存在
		 var o = new Object();
		 o.vYear = year;
		 o.vCode = code;
		 var vsManager = new versionManager();
		 if(vsManager.getVersionByVcodeAndVyear(o)){
			 $.alert("该数据已存在，请重新输入！");
			 return;
		 }
		 var form = $("#version_edit_form");
         var path = _ctxPath + "/xd24/versionController.do?method=newVersion&type=save";
         
         form.attr('action',path);
         $('#versionSubmit')[0].disabled = false;
         form.jsonSubmit({
             validate : true,
             errorIcon : true,
             collbackError:function(){
         	   subCount = 0;
             },
             callback:function(args){
            	// $.alert("添加成功！");
            	 parent.location.href = _ctxPath + "/xd24/versionController.do?method=listVersions"; 
             }
         });
	 });
	$("#rockBack").click(function(){
		parent.location.href = _ctxPath + "/xd24/versionController.do?method=listVersions";
	});
});
</script>
</head>
<body>
   <form id="version_edit_form" class="h100b">
     <div class="form_area">
    <div class="one_row">
        <table border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr>
                    <th nowrap="nowrap">
                        <label class="margin_r_10" for="text">年度:</label></th>
                    <td width="100%">
                        <div class="common_txtbox_wrap">
                            <input type="text" id="v_Year" name="v_Year" class="validate" validate="maxLength:4,minLength:1">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th nowrap="nowrap">
                        <label class="margin_r_10" for="text">版本编号:</label></th>
                    <td>
                        <div class="common_txtbox_wrap">
                            <input type="text" id="vCode" name="vCode"  class="validate" validate="type:'string',maxLength:85,minLength:1">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th nowrap="nowrap">
                        <label class="margin_r_10" for="text">备注:</label></th>
                    <td>
                        <div class="common_txtbox  clearfix">
                            <textarea cols="30" rows="7" class="w100b" id="desc" name="desc"></textarea>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="align_center">
        <a href="javascript:void(0)" class="common_button common_button_emphasize" id="versionSubmit">确定</a>
        <a href="javascript:void(0)" class="common_button common_button_gray" id="rockBack">取消</a>
    </div>
    </div>
   
     </form>
</body>
</html>