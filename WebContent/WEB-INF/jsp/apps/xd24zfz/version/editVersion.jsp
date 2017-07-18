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
	var vsManager = new versionManager();
	//获取页面展示类型，查看还是修改，如果是查看输入框全部为不可以编辑状态
	var type = "${openType}";
	var vid = "${vid}";
	//表单回填
	var versionVo = vsManager.getVersionById(vid);
	$("#version_edit_form").fillform(versionVo);
	
	if("show" == type){
		$("#version_edit_form").disable();
		$("#bottomButton").hidden();
	}
	if("updateOpen" == type){
		$("#bottomButton").show();
	}
	//表单提交
	$("#versionSubmit").click(function(){
		var type = "update";
		var re = $("#version_edit_form").validate();
        if(re == false){
            return;
        }
        var year =  $("#vYear").val();
        var code =  $("#vCode").val();
        var o = new Object();
        o.vYear = year;
        o.vCode = code;
        o.id = vid;
        var vsManager = new versionManager();
        if(vsManager.getVersionByVcodeAndVyear(o,type)){
            $.alert("该数据已存在，请重新输入！");
            return;
        }
        var form = $("#version_edit_form");
        var path = _ctxPath + "/xd24/versionController.do?method=editVersion&type=update&id="+vid;
        
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
     <input type="hidden" id="id">
	    <div class="one_row">
	        <table border="0" cellspacing="0" cellpadding="0">
	            <tbody>
	                <tr>
	                    <th nowrap="nowrap">
	                        <label class="margin_r_10" for="text">年度:</label></th>
	                    <td width="100%">
	                        <div class="common_txtbox_wrap">
	                            <input type="text" id="vYear" class="validate" validate="maxLength:4,notNull:true,name:'年度',isInteger:true">
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <th nowrap="nowrap">
	                        <label class="margin_r_10" for="text">版本编号:</label></th>
	                    <td>
	                        <div class="common_txtbox_wrap">
	                            <input type="text" id="vCode" class="validate" validate="type:'string',maxLength:85,notNull:true,name:'版本编号'">
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <th nowrap="nowrap">
	                        <label class="margin_r_10" for="text">备注:</label></th>
	                    <td>
	                        <div class="common_txtbox  clearfix">
	                            <textarea cols="30" rows="7" class="w100b" id="desc" class="validate" validate="type:'string',maxLength:500,name:'备注'"></textarea>
	                            
	                        </div>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <div class="stadic_layout_footer stadic_footer_height" id="bottomButton" style="display:none">
	            <div id="button" align="center" class="page_color button_container">
	                <div class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
	                   <a href="javascript:void(0)" class="common_button common_button_emphasize margin_r_10 hand" id="versionSubmit">确定</a>&nbsp;<%--确定 --%>
	                    <a href="javascript:void(0)" class="common_button common_button_gray" id="rockBack">取消</a><%--取消 --%>
	                </div>
	            </div>
	    </div>
    
    </div>
     </form>
</body>
</html>