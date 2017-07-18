/**
 * Created by heliang.wang on 17/7/17.
 */
(function () {
    $(document).ready(function(){
    	/*$('#goal-content').on('click','.add-goal-assessment',function(ev){
            if(ev){
                ev.stopPropagation()
            }
            $('#goal-content').append($('#goal-assessment-html').html());
        });


        //考核指标项
        $('#goal-content').on('click','.add-assessment-index-item',function(ev){
            if(ev){
                ev.stopPropagation()
            }
            var _tbody = $(this).parents('.goal-assessment-item').find('.table-assessment tbody');
            var _size = _tbody.children('tr').size();
            var _html = "<tr><td>"+(_size+1)+"</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
            _tbody.append(_html);
        });


        //考核目标项
        $('#goal-content').on('click','.add-assessment-target-item',function(ev){
            if(ev){
                ev.stopPropagation()
            }
            var _tbody = $(this).parents('.goal-assessment-item').find('.table-assessment tbody');
            var _size = _tbody.children('tr').size();
            var _html = "<tr><td>"+(_size+1)+"</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
            _tbody.append(_html);
        });


        //考察指标项
        $('#goal-content').on('click','.add-index-item',function(ev){
            if(ev){
                ev.stopPropagation()
            }
            var _tbody = $(this).parents('.goal-assessment-item').find('.table-assessment tbody');
            var _size = _tbody.children('tr').size();
            var _html = "<tr><td>"+(_size+1)+"</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
            _tbody.append(_html);
        });


        //考察目标项
        $('#goal-content').on('click','.add-target-item',function(ev){
            if(ev){
                ev.stopPropagation()
            }
            var _tbody = $(this).parents('.goal-assessment-item').find('.table-assessment tbody');
            var _size = _tbody.children('tr').size();
            var _html = "<tr><td>"+(_size+1)+"</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
            _tbody.append(_html);
        });

        //目标向下分解
        $('#goal-content').on('click','.add-target-down-decomposition',function(ev){
            if(ev){
                ev.stopPropagation()
            }
            var _tbody = $(this).parents('.goal-assessment-item').find('.table-assessment tbody');
            var _size = _tbody.children('tr').size();
            var _html = "<tr><td>"+(_size+1)+"</td><td></td><td></td></tr>";
            _tbody.append(_html);
        });*/


        $(".datepicker").datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            clearBtn: true,//清除按钮
            todayBtn: true,//今日按钮
            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
        });
        
    	//获取系统当前时间
		var date = new Date();
		//获取当前年
		var year = date.getFullYear();
		//获取当前月
		var month = date.getMonth()+1;
		var h = date.getHours();       //获取当前小时数(0-23)
		var m = date.getMinutes();     //获取当前分钟数(0-59)
		var s = date.getSeconds();
		var time = Format(date,"yyyy-MM-dd HH:mm:ss");
		$("#year").val(year);
		$("#bzsj").val(time).attr("readonly",true);
		
		//当前登录人所属岗位id
		var postId = $("#postId").val();
		//CEO 岗位ID
		var pid = "-7947150997509224459";
		//登录人为boss时，隐藏上级目标及
		if(postId == pid){
			$("#pid").hide();
			$("#jtmc_div").hide();
		}
		//iframe 获取父窗口属性
		var args = window.parent.document;
		$("#submit",args).click(function(){
			alert(11);
		});
    });
})();
