<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=xd24quotaManager"></script>
<html>
<head>
<title>副岗管理</title>
<script text="text/javascript">
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
			colModel : [ {
				display : 'checkbox',
				width : '4%',
				name : 'id',
				sortable : false,
				align : 'center',
				type : 'checkbox'
			},{
				display : "编号",
				name : 'name',
				width : '10%',
				sortable : true,
				align : 'center'
			},{
				display : "指标项名称",
				name : 'form_name',
				width : '20%',
				sortable : true,
				align : 'center'
			},{
				display : "指标分类",
				name : 'post_name',
				width : '10%',
				sortable : true,
				align : 'center'
			}, {
				display : "度量",
				name : 'type',
				width : '10%',
				sortable : true,
				align : 'center'
			}, {
				display : "指标控件类型",
				name : 'depart_name',
				width : '10%',
				sortable : true,
				align : 'center'
			}],
			isToggleHideShow : false,
			usepager : true,
			useRp : true,
			customize : false,
			resizable : false,
			showToggleBtn : false,
			parentId : $('.layout_center').eq(0).attr('id'),
			vChange : false,
			vChangeParam : {
				overflow : "hidden",
				autoResize : true
			},
			slideToggleBtn : true,
			managerName : "xd24quotaManager",
			managerMethod : "getQuota"
		});
		
		debugger;
		//window.parent.document.getElementById("nowLocation").appendChild("<span class=\"nowLocation_ico\"><img src=\"/seeyon/main/skin/frame/harmony/menuIcon/personal.png\"></span>");
		debugger;
		
		var o = new Object();
		$("#listSent").ajaxgridLoad(o);
		//搜索框
		var topSearchSize = 2;
		if ($.browser.msie && $.browser.version == '6.0') {
			topSearchSize = 5;
		}
		var searchobj = $.searchCondition({
			top : topSearchSize,
			right : 10,
			searchHandler : function() {
				var o = new Object();
				var choose = $('#' + searchobj.p.id).find("option:selected").val();
				if (choose == "") {
					$.alert("请选择查询条件！");
					return;
				}
				if (choose === 'name') {
					o.name = $('#name').val();
					if (o.name == "") {
						$.alert("请输入要查询的编号！");
						return;
					}
				}
				if (choose === 'form_name') {
					o.form_name = $('#form_name').val();
					if (o.form_name == "") {
						$.alert("请输入要查询的指标名称！");
						return;
					}
				if (choose === 'form_name') {
					o.form_name = $('#form_namea').val();
					if (o.form_name == "") {
						$.alert("请输入要查询的指标类别！");
						return;
					}
				}
				var val = searchobj.g.getReturnValue();
				debugger;
				if (window.location.href.indexOf("condition=templeteAll&textfield=all") != -1) {
					o.templeteAll = "all";
				}
				if (val !== null) {
					debugger;
					$("#listSent").ajaxgridLoad(o);
				}
			},
			conditions : [ {
				id : 'name',
				name : 'name',
				type : 'input',
				text : "编号",
				value : 'name',
				maxLength : 100
			},{
				id : 'form_name',
				name : 'form_name',
				type : 'input',
				text : "指标项名称",
				value : 'form_name',
				maxLength : 100
			},{
				id : 'form_namea',
				name : 'form_namea',
				type : 'input',
				text : "指标类别",
				value : 'form_namea',
				maxLength : 100
			} ]
		});
		//工具栏
		var toolbar = $("#toolbar").toolbar({
		    toolbar: [{
		      id: "create1",
		      name: "${ctp:i18n('common.toolbar.new.label')}",
		      className: "ico16",
		      click: function() {
		        newUser();
		      }
		    },
		    {
		      id: "modify",
		      name: "${ctp:i18n('label.modify')}",
		      className: "ico16 editor_16",
		      click: function() {
		       updateUser();
		      }
		    }
		    ,
		    {
		      id: "delete",
		      name: "${ctp:i18n('usersystem.restUser.deleteUser')}",
		      className: "ico16 del_16",
		      click: function() {
		        deleteUser();
		      }
		    }]
		  });
	});

	//加载用户列表
	function reloadtab() {
		var o = new Object();
		$("#listSent").ajaxgridLoad(o);
	};
	//获取选中
	function getTableChecked() {
		return $("#listSent").formobj({
			gridFilter : function(data, row) {
				return $("input:checkbox", row)[0].checked;
			}
		});
	}
</script>
</head>
<body>
	<div id='layout' class="comp" comp="type:'layout'"><!-- 
	    <div id="breadCrumb4Team" class="comp" comp="type:'breadcrumb',code:'F18_magazine'"></div> -->
	    <div class="layout_north" layout="height:30,sprit:false,border:false">
	        <div id="toolbar"></div>
	    </div>
	    <div class="layout_center over_hidden" layout="border:false" id="center">
	        <table id="listSent" class="flexme3" border="0" cellspacing="0" cellpadding="0"></table>
	        <div id="grid_detail" class="">
	            <iframe id="summary" name='summaryF' width="100%" height="100%"
						frameborder="0" class='calendar_show_iframe'
						style="overflow-y: hidden"></iframe>
	        </div>
	    </div>
	</div>
</body>
</html>