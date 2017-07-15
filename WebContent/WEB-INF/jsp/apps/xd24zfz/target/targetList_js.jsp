<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/apps/ldap/ldap_tools_js.jsp"%>
<script text="text/javascript" language="javascript">
var dialog4Role;
var dialog4Batch;
var dialog;
var grid;
    $(function() {
        new MxtLayout({
            'id' : 'layout',
            'northArea' : {
                'id' : 'north',
                'height' : 30,
                'sprit' : false,
                'border' : false
            },
            'centerArea' : {
                'id' : 'center',
                'border' : false,
                'minHeight' : 20
            }
        });
        grid = $("#listSent").ajaxgrid({
            colModel : [{
                display : 'checkbox',
                width : '2%',
                name : 'id',
                sortable : false,
                align : 'center',
                type : 'checkbox'
            },{
                display : "目标名称",
                name : 'subject',
                width : '15%',
                sortable : true,
                align : 'center'
            },{
                display : "编制时间",
                name : 'createTime',
                width : '12%',
                sortable : true,
                align : 'center'
            },{
                display : "生效时间",
                name : 'effectTime',
                width : '12%',
                sortable : true,
                align : 'center'
            },{
                display : "责任人",
                name : 'memberId',
                width : '10%',
                sortable : true,
                align : 'center'
            },{
                display : "目标开始时间",
                name : 'startTime',
                width : '12%',
                sortable : true,
                align : 'center'
            },{
                display : "目标结束时间",
                name : 'endTime',
                width : '12%',
                sortable : true,
                align : 'center'
            } ,{
                display : "目标描述",
                name : 'description',
                width : '25%',
                sortable : true,
                align : 'center'
            }],
            isToggleHideShow : false,
            usepager : true,
            useRp : true,
            customize : false,
            resizable : false,
            showToggleBtn : true,
            parentId : $('.layout_center').eq(0).attr('id'),
            vChange : true,
            vChangeParam : {
                overflow : "hidden",
                autoResize : true
            },
            slideToggleBtn : true,
            managerName : "xd24TargetManager",
            managerMethod : "getTargetList",
            click : clickGrid,
            dblclick: dblclkGrid
        });
        var o = new Object();
        $("#targetTable").ajaxgridLoad(o);

        var toolBarVar = $("#toolbar").toolbar({
            toolbar: [{
              id: "add",
              name: "${ctp:i18n('common.toolbar.new.label')}",
              className: "ico16",
              click: newMember
            },
            {
              id: "edit",
              name: "${ctp:i18n('common.button.modify.label')}",
              className: "ico16 editor_16",
              click: editMember
            },
            {
              id: "delete",
              name: "${ctp:i18n('common.toolbar.delete.label')}",
              className: "ico16 delete del_16",
              click: delMembers
            }]
        });
      	//表格单击事件
        function clickGrid(data, r, c) {
        	$.alert("单击！");
      		//viewDetail(data.id);
        }

        //表格双击事件
        function dblclkGrid(data, r, c) {
			$.alert("双击！");
        }
    });
</script>
