<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=xd24Manager"></script>
<html>
<head>
<title>战略地图维度</title>
<script text="text/javascript">
	var grid;
	$(function() {
		new MxtLayout({
            'id': 'layout',
            'northArea': {
                'id': 'north',
                'height': 40,
                'sprit': false,
                'border': false
            },
            'centerArea': {
                'id': 'center',
                'border': false,
                'minHeight': 20
            }
        });
		
 		var colModel =  [ {
			display : 'checkbox',
			width : '4%',
			name : 'id',
			sortable : false,
			align : 'center',
			type : 'checkbox'
		},{
			display : "战略地图名称",
			name : 'name',
			width : '20%',
			sortable : true,
			align : 'center'
		},{
			display : "是否启用",
			name : 'isenable',
			width : '10%',
			sortable : true,
			align : 'center'
		},{
			display : "描述",
			name : 'description',
			width : '20%',
			sortable : true,
			align : 'center'
		}];
		grid = $('#listSent').ajaxgrid({
            click: showInfo,
            dblclick: dbclickRow,
            colModel: colModel,
            height: 200,
            showTableToggleBtn: true,
            parentId: $('.layout_center').eq(0).attr('id'),
            vChange: true,
            isHaveIframe:true,
            slideToggleBtn:true,
            managerName : "xd24Manager",
			managerMethod : "getZldtwdList"
        });
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
						$.alert("请输入要查询的战略地图名称！");
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
				text : "战略地图名称",
				value : 'name',
				maxLength : 100
			} ]
		});
		/* //工具栏
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
				updateRow();
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
		  }); */
		var toolbar = new Array();
        //新建
        toolbar.push({id: "newCreate",name: "新建",className: "ico16",click:addRow });
        //修改
        toolbar.push({id: "update",name: "编辑",className: "ico16 editor_16",click:updateRow });
        //删除
        toolbar.push({ id: "delete",name: "删除",className: "ico16 del_16",click:deleteRows });
        
        $("#toolbars").toolbar({
            borderLeft:false,
            borderTop:false,
            borderRight:false,
            toolbar: toolbar
        });

	});
	//删除用户
	function deleteUser() {
		var users = new Array();
		var manager = new xd24Manager();
		var v = getTableChecked();
		if (v.length === 0) {
			$.alert("请选择要删除的用户！");
			return;
		} else {
			var checkResult = true;
			$(v).each(function(index, domEle) {
				users.push(domEle.id);
			});
			if (!checkResult)
				return;
			$.confirm({
				'msg' : "确定要删除战略地图？",
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
	};
	//只读展示
    function showInfo(row, rowIndex, colIndex) {
		debugger;
		grid.grid.resizeGridUpDown('middle');
        $('#summary').attr("src",_ctxPath + "/test/xd24ZldtwdController.do?method=edit&flag=show&"+row.id);
    }
    //双击修改
    function dbclickRow(){
        updateRow();
    }
    //点击修改
    function updateRow(){
    	debugger;
        var rows = grid.grid.getSelectRows();
        debugger;
        if(rows.length === 0){
            $.alert("请选择一条记录!");//请选择一条记录
            return;
        }
        if(rows.length>1){
            $.alert("只能选择一条记录进行修改!");//只能选择一条记录进行修改
            return;
        }
        grid.grid.resizeGridUpDown('middle');
        $('#summary').attr("src",_ctxPath + "/test/xd24ZldtwdController.do?method=edit&flag=update&"+ rows[0].id);
    }
    
    //删除行
    function deleteRows(){
    	
    }
    //添加行
    function addRow(){
        grid.grid.resizeGridUpDown('middle');
        $('#summary').attr("src",_ctxPath + "/test/xd24ZldtwdController.do?method=edit&flag=new");
    }
</script>
</head>
<body>
    <div id='layout'>
        <div class="layout_north bg_color f0f0f0" id="north">
            <div id="toolbars"></div>
        </div>
	    <div class="layout_center over_hidden" id="center">
            <table class="flexme3" id="listSent"></table>
            <div id="grid_detail" class="h100b">
                <iframe id="summary" width="100%" height="100%" frameborder="0"  style="overflow-y:hidden"></iframe>
            </div>
        </div>
	</div>

</body>
</html>