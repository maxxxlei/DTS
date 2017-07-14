<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%-- <%@ include file="/WEB-INF/jsp/common/common.jsp"% --%>>
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
			render : rend,
			colModel : [{
				display : 'checkbox',
				width : '2%',
				name : 'checkboxid',
				sortable : false,
				align : 'center',
				type : 'checkbox',
				checked : true,
				hide : true,
			},{
				display : "人员",
				name : 'name',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "人员编号",
				name : 'code',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "单位",
				name : 'company',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "部门",
				name : 'department',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "岗位",
				name : 'post',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "劳保类型",
				name : 'type',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "劳保物品",
				name : 'laobao',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "编码",
				name : 'lbcode',
				width : '10%',
				sortable : false,
				hide : true,
				align : 'center'
			},{
				display : "尺码",
				name : 'size',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "应发放日期",
				name : 'sendtime',
				width : '10%',
				sortable : false,
				align : 'center'
			},{
				display : "数量",
				name : 'quantity',
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
		//$("#laobaoList").ajaxgridLoad(o);
		//搜索框
		debugger;
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
						$.alert("请输入起始日期！");
						return;
					}
					o.to_datetime = $('#to_datetime').val();
					if (o.to_datetime == "") {
						$.alert("请输入结束日期！");
						return;
					}
				}
				var val = searchobj.g.getReturnValue();
				if (window.location.href.indexOf("condition=templeteAll&textfield=all") != -1) {
					o.templeteAll = "all";
				}
				if (val !== null) {
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
	//获取选中
	function getTableChecked() {
		return $("#laobaoList").formobj({
			gridFilter : function(data, row) {
				return $("input:checkbox", row)[0].checked;
			}
		});
	};
	//查询
	function search() {
		var type = $("#laoBaoType").val();
		var fromTime = $("#fromTime").val();
		var toTime = $("#toTime").val();
		if (type == "") {
			$.alert("请输入要查询的劳保类型！");
			return;
		}
		if (fromTime == "") {
			$.alert("请输入起始日期！");
			return;
		}
		if (toTime == "") {
			$.alert("请输入结束日期！");
			return;
		}
		fromTime1 = fromTime.replace(/-/g,"/");
		var startDate = new Date(fromTime1);
		toTime1 = toTime.replace(/-/g,"/");
		var endDate = new Date(toTime1);
		var date = endDate.getTime()-startDate.getTime();
		if (date <= 0){
			$.alert("起始时间必须小于终止时间，请检查！");
			return;
		}
		var manager = new lbManager();
		var o = new Object();
		o.type = type;
		o.fromTime = fromTime;
		o.toTime = toTime;
		$("#laobaoList").ajaxgridLoad(o);
	};
	function rend(txt,rowData, rowIndex, colIndex,colObj){
		if(colIndex==11){
			return '<input id=' + rowIndex +'S11'+'></input>';
		}else{
			return txt;
		} 
	};
	//发放
	function send(){
		var list=new ArrayList();
		$('.flexigrid').find("input[type='checkbox']").attr("checked","true"); 
		var id_checkbox = grid.grid.getSelectRows();
		for (var i = 0; i < id_checkbox.length; i++) {
			var obj = id_checkbox[i];
			obj.quantity = $('#'+i+'S11').val();
			list.add(obj);
		}
		var manager = new lbManager();
		var json=JSON.stringify(list);
		manager.sendLaoBao(json);
	};
	//统计
	function count() {
		var list=new ArrayList();
		$('.flexigrid').find("input[type='checkbox']").attr("checked","true"); 
		var id_checkbox = grid.grid.getSelectRows();
		for (var i = 0; i < id_checkbox.length; i++) {
			var obj = id_checkbox[i];
			obj.quantity = $('#'+i+'S11').val();
			list.add(obj);
		}
		var json=JSON.stringify(list);
		var dialog = $.dialog({
		url : _ctxPath + '/trlaobao/trlaobao.do?method=laobaoCountList&json='+json+'&aaa=222',
			width : 600,
			height : 400,
			isDrag : true,
			targetWindow : getCtpTop(),
			title : "统计"
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
<body>
<h1>火狐</h1>
	<div id='layout' class="comp" comp="type:'layout'"><!-- 
	    <div id="breadCrumb4Team" class="comp" comp="type:'breadcrumb',code:'F18_magazine'"></div> -->
	    <div class="layout_north" layout="height:80,sprit:false,border:false">
	        <div id="searchDiv" style="margin-top:5px;">
		        <div id="AAA" style="font-size:12px;margin-top:5px;">
	        	        劳保类型：<input id="laoBaoType">&nbsp&nbsp&nbsp&nbsp
	        		起始时间：<input id="fromTime" type="text"  class="comp" comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false,isClear:true,clearBlank:false" readonly="readonly"/>&nbsp&nbsp结束时间：<input id="toTime" type="text"  class="comp" comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false,isClear:true,clearBlank:false" readonly="readonly"/>
		        </div>
		        <div id="BBB" style="font-size:12px">
		        	<a class="common_button common_button_emphasize margin_r_10" href="javascript:search()" id="search">查询</a>&nbsp&nbsp&nbsp&nbsp
		        	<a class="common_button common_button_emphasize margin_r_10" href="javascript:count()" id="count">统计</a>&nbsp&nbsp&nbsp&nbsp
		        	<a class="common_button common_button_emphasize margin_r_10" href="javascript:send()" id="send">发放</a>
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