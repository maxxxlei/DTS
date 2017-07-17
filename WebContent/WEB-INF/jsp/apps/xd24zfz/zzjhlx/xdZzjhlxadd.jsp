<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=zzjhlxManger"></script>
<html>
<head>
<title>底部菜单</title>
</head>
<script>
    $(document).ready(function() {
        var flag="${flag}";
        debugger;
        if(flag=="show"){
        	alert(1)
            $("#bottomButton").hide();
            $("#mapName").val("1");
            $("#isEnable").val("1"); 
            $("#description").val("浏览");
            $("#name").atrr("disabled", true);
            $("#isEnable").prop("disabled", true);
            $("#description").prop("disabled", true);
            $("#id").val("111");
            
        }
        if(flag=="update"){
            $("#bottomButton").show();
            $("#mapName").val("2");
            $("#isEnable").val("0"); 
            $("#description").val("编辑");
            $("#id").val("111");
            
            var rowsId = "${rowsId}";//获取选中id
            var manager = new zzjhlxManger();
            var zzjhlxVo = manager.getZzjhlxById(rowsId);
            debugger;
            $("#mapName").val(zzjhlxVo.name);
            $("#isEnable").val(zzjhlxVo.isEnable); 
            $("#descr").val(zzjhlxVo.desc);
            /* parent.location.href = _ctxPath + "/xdcd24/xdcd24.do?method=xdcd24SearchList" */
            return;
                
        }
        if(flag=="new"){//新建
            $("#bottomButton").show();
            $("#mapName").val("");
            $("#isEnable").val("3"); 
            $("#description").val("");
        }
        debugger;
    });
    
    
    function OK() {
        var flag = "${flag}";
        if(flag=="new"){
            var o = new Object();
            o.name = $("#mapName").val();
            o.isEnable= $("#isEnable").val(); 
            o.desc = $("#descr").val();
            if(o.name==""){
                $.alert("请输入组织计划名称！");
                return;
            }
            var isName=$("#mapName").validate();
            if(isName == false){
            	$.alert("组织计划名称长度不能超过50");
            	return; 
            }
            if(o.isEnable==""){
                $.alert("请选择启用状态！");
                return;
            }
            var isName=$("#isEnable").validate();
            if(isName == false){
                $.alert("请选择");
                return; 
            }
            if(o.desc==""){
                $.alert("请输入组织计划描述！");
                return;
            }
            var manager = new zzjhlxManger();//Manager类bean,id
            var ne = o.name;
             var flag = manager.getNameAndId(ne,rowsId);
            if(!flag){
                $.alert("输入内容有误，可能出现重复值！");
                return;
            } 
            var isName=$("#descr").validate();
            if(isName == false){
                $.alert("组织计划描述长度不能超过5000");
                return; 
            }
            
            manager.saveZzjhlx(o);//保存的方法名
            parent.location.href = _ctxPath + "/xdcd24/xdcd24.do?method=xdcd24SearchList"//controller里的方法名，进行页面跳转
            return;		
        }
        var rowsId = "${rowsId}";
        var o = new Object();
        o.name = $("#mapName").val();
        o.isEnable= $("#isEnable").val(); 
        o.desc = $("#descr").val();
        if(o.name == ""){
            $.alert("请输入组织计划名称！!");
            return;
        }
        if(o.isEnable == ""){
            $.alert("请点击是否启用菜单！!");
            return;
        }
        if(o.desc == ""){
            $.alert("请输入组织计划类型描述！!");
            return;
        }//判断是否为重复数据或者为自己
        var manager = new zzjhlxManger();//Manager类bean,id
        var ne = o.name;
         var flag = manager.getNameAndId(ne,rowsId);
        if(!flag){
        	$.alert("输入内容有误，可能出现重复值！");
        	return;
        } 
        alert("判断结束");
        manager.saveZzjhlx(o);//保存的方法名
        alert("进行跳转");
        parent.location.href = _ctxPath + "/xdcd24/xdcd24.do?method=xdcd24SearchList"
        		
    }
    
   
</script>
<body>
    <div>
          <form id="myfrm" name="myfrm" align="center" method="post">
            <div class="form_area" id='form_area'  align="center" >
            <input type="hidden" id="id" class="validate" validate="type:'string',name:'编号',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"/>
            <input type="hidden" id="departCode" class="validate" validate="type:'string',name:'兼职部门代码',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'"/>
            <table border="0" cellspacing="0" cellpadding="0" class="margin_lr_10 margin_t_10" align="center" width="450">
                <br>
              <tr>
                <th width="90px"><font color="red">*</font><label class="margin_r_10" for="text">组织计划名称:</label></th>
                <td>
                  <div><!--     readonly unselectable="on"
                    <input type="text" id="spc1" name="spc1" class="comp" comp="type:'selectPeople',mode:'open',selectType:'Member',value:'',text:''"/>-->
                    <input type="text" id="mapName" class="validate" validate="type:'string',name:'组织计划名称',notNull:true,maxLength:50,avoidChar:'!@#$%^&amp;*+|,'" style="width:350px"/>
                </td>
              </tr>
              <tr>
              <th><font color="red">*</font><label class="margin_r_10" for="text" readonly=”true”>是否启用:</label></th>
                <td>
                  <div>
                    <select id ="isEnable">
                        <option value ="">请选择</option>
                        <option value ="1">是</option>
                        <option value ="0">否</option>
                    </select>
                  </div>
                </td>
              </tr>
              <tr>
                <th><font color="red">*</font><label class="margin_r_10" for="text">组织计划描述:</label></th>
                <td>
                  <div ><!-- checked="true" -->
                    <textarea id ="descr" validate="type:'string',name:'组织计划描述',notNull:true,maxLength:5070,avoidChar:'!@#$%^&amp;*+|,'" name="组织计划描述" style="width:350px;height:80px;"></textarea>
                  </div>
                </td>
              </tr>
            </table> 
            <div class="stadic_layout_footer stadic_footer_height" id="bottomButton">
                <div id="button" align="center" class="page_color button_container">
                    <div class="common_checkbox_box clearfix  stadic_footer_height padding_t_5 border_t">
                       <a href="javascript:OK()" class="common_button common_button_emphasize margin_r_10 hand" id="edit_confirm_button">${ctp:i18n('permission.confirm')}</a>&nbsp;<%--确定 --%>
                        <a href="javascript:void(0)" class="common_button common_button_gray" id="edit_cancel_button">${ctp:i18n('permission.cancel')}</a><%--取消 --%>
                    </div>
                </div>
            </div>
            </div> 
          </form>
    </div> 
</body>
</html>