/**
 * Created by heliang.wang on 17/7/17.
 */
(function () {
    $(document).ready(function(){
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
    });
})();
