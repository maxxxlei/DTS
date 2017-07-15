function Dsyb(){
	this.Items = {};
}
Dsyb.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
};
Dsyb.prototype.Exists = function(id){
	if(typeof(this.Items[id]) == "undefined") return false;
	return true;
};

function change_khzq(v){
	var str="0";
	for(var i=0;i<v;i++){
		str+=("_"+(document.getElementById(sb[i]).selectedIndex-1));
	};
	var ss=document.getElementById(sb[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0b[v],opt0b[v]);
		if(v && document.getElementById(sb[v-1]).selectedIndex>0 || !v){
			if(dsyb.Exists(str)){
				ar = dsyb.Items[str];
				for(var i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; }
			}
		}//end if v
		if(++v<sb.length){change_khzq(v);}
	}//End with
}

var dsyb = new Dsyb();

dsyb.add("0",["年度","半年度","季度","月度"]);
dsyb.add("0_0",["年终"]);
dsyb.add("0_1",["H1","H2"]);
dsyb.add("0_2",["S1","S2","S3","S4"]);
dsyb.add("0_3",["M1","M2","M3","M4","M5","M6","M7","M8","M9","M10","M11","M12"]);

var sb=["khzq","khzqxx"];//考核周期与考核周期细项select的name
var opt0b = ["请选择","请选择"];//初始值
function init_khzq(){  //初始化函数
	for(var i=0;i<sb.length-1;i++){
	  document.getElementById(sb[i]).onchange=new Function("change_khzq("+(i+1)+")");
	}
	change_khzq(0);
}
