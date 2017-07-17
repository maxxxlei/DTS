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
	var type = "${openType}"
	
	if("search" == type){
		$("#version_edit_form").attr("disabled",true);
		$("#versionSubmit").attr("disabled",true);
	}
	$("#versionSubmit").click(function(){
       
		var vDesc = $("#desc").val();
		if(vDesc == null || vDesc == ""){
			$.alert("描述不能为空！");
			return;
		}
        var form = $("#version_edit_form");
        var path = _ctxPath + "/xd24/versionController.do?method=editVersion&type=update";
        
        form.attr('action',path);
        $('#versionSubmit')[0].disabled = false;
        form.jsonSubmit({
            validate : true,
            errorIcon : true,
            collbackError:function(){
              subCount = 0;
            },
            callback:function(args){
                parent.location.href = _ctxPath + "/xd24/versionController.do?method=listVersions"; 
            }
        });
         
    });
	$("#rockBack").click(function(){
		parent.location.href = _ctxPath + "/xd24/versionController.do?method=listVersions"
   });

});
</script>
</head>
<body>
   <form id="version_edit_form" class="h100b">
     <div class="form_area">
     <input type="hidden" id="versionId" value="${version.id }">
    <div class="one_row">
        <table border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr>
                    <th nowrap="nowrap">
                        <label class="margin_r_10" for="text">年度:</label></th>
                    <td width="100%">
                        <div class="common_txtbox_wrap">
                            <input type="text" id="v_Year" value="${version.vYear }" readonly="readonly">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th nowrap="nowrap">
                        <label class="margin_r_10" for="text">版本编号:</label></th>
                    <td>
                        <div class="common_txtbox_wrap">
                            <input type="text" id="vCode" value="${version.vCode }" readonly="readonly">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th nowrap="nowrap">
                        <label class="margin_r_10" for="text">备注:</label></th>
                    <td>
                        <div class="common_txtbox  clearfix">
                            <textarea cols="30" rows="7" class="w100b" id="desc" >${version.desc }</textarea>
                            
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