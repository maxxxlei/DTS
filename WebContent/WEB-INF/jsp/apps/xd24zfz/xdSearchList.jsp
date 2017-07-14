<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%-- <%@ include file="/WEB-INF/jsp/common/common.jsp"%> --%>
<script type="text/javascript" src="${path}/ajax.do?managerName=lbManager"></script>
<html>
<head>
<title>劳保信息列表展示</title>
<script text="text/javascript">
	var grid;
	$(function() {
		new MxtLayout({
			'id' : 'layout',
			'northArea' : {
				'id' : 'north',
				'height' : 75,
				'sprit' : false,
				'border' : false
			},
			'centerArea' : {
				'id' : 'center',
				'border' : false,
				'minHeight' : 20
			}
		});
		grid = $("#laobaoList").ajaxgrid({
			colModel : [{
				display : "人员",
				name : 'NAME',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "人员编号",
				name : 'CODE',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "单位",
				name : 'COMPANY',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "部门",
				name : 'DEPARTMENT',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "岗位",
				name : 'POST',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "劳保类型",
				name : 'TYPE',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "劳保物品",
				name : 'LAOBAO',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "编码",
				name : 'LBCODE',
				width : '10%',
				sortable : false,
				hide : true,
				align : 'center'
			},{
				display : "尺码",
				name : 'SIZE',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "应发放日期",
				name : 'SENDTIME',
				width : '10%',
				sortable : false,
				align : 'center'
			}],
			isToggleHideShow : false,
			usepager : false,
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
			managerName : "lbManager",
			managerMethod : "getLaoBaoList"
		});
		var o = new Object();
		debugger;
		//$("#laobaoList").ajaxgridLoad(o);
		debugger;
		//工具栏
		var toolbar = $("#toolbar").toolbar({
		    toolbar: [{
		      id: "send",
		      name: "发放",
		      className: "ico16",
		      click: function() {
		        send();
		      }
		    },
		    {
		      id: "count",
		      name: "统计",
		      className: "ico16 editor_16",
		      click: function() {
		      	count();
		      }
		    }]
		  });
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
				if (choose === 'type') {
					o.type = $('#type').val();
					if (o.type == "") {
						$.alert("请输入要查询的劳保类型！");
						return;
					}
				}
				if (choose === 'datetime') {
					o.from_datetime = $('#from_datetime').val();
					if (o.from_datetime == "") {
						debugger;
						$.alert("请输入起始日期！");
						return;
					}
					o.to_datetime = $('#to_datetime').val();
					if (o.to_datetime == "") {
						debugger;
						$.alert("请输入结束日期！");
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
					$("#laobaoList").ajaxgridLoad(o);
				}
			},
			conditions : [ {
				id : 'type',
				name : 'type',
				type : 'input',
				text : "劳保类型",
				value : 'type',
				maxLength : 100
			}, {
	            id: 'datetime',
	            name: 'datetime',
	            type: 'datemulti',
	            text: '发起时间',
	            value: 'datetime',
	            dateTime: true
	        } ]
		});
	});
	
	//修改用户
	function count() {
		var dialog = $.dialog({
		url : _ctxPath + '/trlaobao/trlaobao.do?method=laobaoCountList',
			width : 600,
			height : 400,
			isDrag : true,
			targetWindow : getCtpTop(),
			title : "统计"
		});
	};
	function send() {
		var users = new Array();
		var manager = new lbManager();
		var v = getTableChecked();
		debugger;
		if (v.length === 0) {
			$.alert("您未选择发放数据！");
			return;
		} else {
			var checkResult = true;
			$(v).each(function(index, domEle) {
				users.push(domEle.id);
			});
			if (!checkResult)
				return;
			$.confirm({
				'msg' : "确定要删除该人员副岗？",
				ok_fn : function() {
					debugger;
					manager.deleteUser(users, {
						success : function() {
							reloadtab();
						}
					});
				},
				cancel_fn : function() {
				}
			});
		}
	};
	//获取选中
	function getTableChecked() {
		return $("#laobaoList").formobj({
			gridFilter : function(data, row) {
				return $("input:checkbox", row)[0].checked;
			}
		});
	};

</script>
<style> 
body{ text-align:center} 
#AAA{ margin:0 auto;height:30px;}
#BBB{ margin:0 auto;height:30px;}
#searchDiv{margin:0 auto;width:60%;border:1px solid  #778899} 
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style> 
</head>
<h1>你好</h1>
<body>
	<div id='layout' class="comp" comp="type:'layout'"><!-- 
	    <div id="breadCrumb4Team" class="comp" comp="type:'breadcrumb',code:'F18_magazine'"></div> -->
	    <div class="layout_north" layout="height:80,sprit:false,border:false">
	        <div id="searchDiv" style="margin-top:5px;">
		        <div id="AAA" style="font-size:12px;margin-top:5px;">
	        	        劳保类型：<input id="laoBaoType">&nbsp&nbsp&nbsp&nbsp
	        		起始时间：<input id="fromTime" type="text"  class="comp" comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false,isClear:true,clearBlank:false" readonly="readonly"/>&nbsp&nbsp结束时间：<input id="toTime" type="text"  class="comp" comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false,isClear:true,clearBlank:false" readonly="readonly"/>
		        </div>
		        <div id="BBB" style="font-size:12px">
		        	<a class="common_button common_button_emphasize margin_r_10" href="javascript:void(0)" id="search">查询</a>&nbsp&nbsp&nbsp&nbsp
		        </div>
	        </div>
	    </div>
	    <div class="layout_center over_hidden" layout="border:false" id="center">
	        <table id="laobaoList" class="flexme3" border="0" cellspacing="0" cellpadding="0"></table>
	        <!-- 
	        <div id="grid_detail" class="">
	            <iframe id="summary" name='summaryF' width="100%" height="100%"
						frameborder="0" class='calendar_show_iframe'
						style="overflow-y: hidden"></iframe>
	        </div>
	         -->
	    </div>
	</div>
</body>
</html>