<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script type="text/javascript" src="${path}/ajax.do?managerName=xd24ZldtwdManager"></script>
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
            display : "战略地图描述",
            name : 'description',
            width : '30%',
            sortable : true,
            align : 'center'
        },{
			display : "是否启用",
			name : 'isEnable',
			width : '20%',
			sortable : true,
			align : 'center'
		},{
            display : "创建时间",
            name : 'createTime',
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
            managerName : "xd24ZldtwdManager",
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
				if (choose === 'description') {
					o.description = $('#description').val();
					if (o.description == "") {
						$.alert("请输入要查询的战略地图描述！");
						return;
					}
				}
				if (choose === 'isEnable') {
                    o.isEnable = $('#isEnable_dropdown_text').text();
                    debugger;
                    if (o.isEnable == "是") {
                    	o.isEnable = "1";
                    }
                    if (o.isEnable == "否") {
                        o.isEnable = "0";
                    }
                }
				if (choose === 'createDate') {
                    startDate = $('#from_datetime').val();
                    endDate = $('#to_datetime').val();
                    debugger;
                    if (startDate != "") {
                        o.from_datetime = startDate;
                    }
                    if (endDate != "") {
                        o.to_datetime = endDate;
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
			},{
                id : 'description',
                name : 'description',
                type : 'input',
                text : "战略地图描述",
                value : 'description',
                maxLength : 100
            }, {
                id: 'isEnable',
                name: 'isEnable',
                type: 'select',
                text: '是否启用',
                value: 'isEnable',
                items: [{
                    text: '是',
                    value: '1'
                }, {
                    text: '否',
                    value: '0'
                }]
            },{
                id: 'datetime',
                name: 'datetime',
                type: 'datemulti',
                text: '创建时间',
                value: 'createDate',
                dateTime: true
            } ]
		});
		
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

        var skinPathKey = getCtpTop().skinPathKey == null ? "harmony" : getCtpTop().skinPathKey;
        var html = '<span class="nowLocation_ico"><img src="'+_ctxPath+'/main/skin/frame/'+skinPathKey+'/menuIcon/'+getCtpTop().currentSpaceType+'.png"></span>';
        html += '<span class="nowLocation_content">24字方针系统设置 > ';
        html += '<a>战略地图维度</a>';
        html += '</span>';
        getCtpTop().showLocation(html);
	});
	//删除用户
	function deleteRows() {
		var ids = new Array();
		var manager = new xd24ZldtwdManager();
		var v = getTableChecked();
		if (v.length === 0) {
			$.alert("请选择要删除的用户！");
			return;
		} else {
			var checkResult = true;
			$(v).each(function(index, domEle) {
				ids.push(domEle.id);
			});
			if (!checkResult)
				return;
			$.confirm({
				'msg' : "确定要删除战略地图？",
				ok_fn : function() {
					debugger;
					manager.deleteZldtwd(ids, {
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
		location.href = _ctxPath + "/xd24/zldtwdController.do?method=zldtwdList"
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
        $('#summary').attr("src",_ctxPath + "/xd24/zldtwdController.do?method=edit&flag=show&id="+row.id);
    };
    //双击修改
    function dbclickRow(){
        updateRow();
    };
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
        $('#summary').attr("src",_ctxPath + "/xd24/zldtwdController.do?method=edit&flag=update&&id="+ rows[0].id);
    };
    //添加行
    function addRow(){
        grid.grid.resizeGridUpDown('middle');
        $('#summary').attr("src",_ctxPath + "/xd24/zldtwdController.do?method=edit&flag=new");
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
            <div id="grid_detail" class="h100b" style="overflow:hidden">
                <iframe id="summary" width="100%" height="100%" frameborder="0" style="overflow:hidden"></iframe>
            </div>
        </div>
	</div>

</body>
</html>