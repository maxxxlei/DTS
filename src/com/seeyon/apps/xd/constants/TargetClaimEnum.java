package com.seeyon.apps.xd.constants;

import com.seeyon.ctp.common.code.EnumsCode;
/**
 * 目标-指标度量enum,用于前端下拉框使用
 * @author heliang.wang
 *
 * @time 2017年7月17日
 */
public enum TargetClaimEnum implements EnumsCode {
	DL1("1","大于"),	
	DL2("2","小于"),
	DL3("3","等于"),
	DL4("4","大于等于"),
	DL5("5","小于等于"),
	DL6("6","有无");
	
	
	private String value;
    private String text;
	TargetClaimEnum(String value,String text){
    	this.value = value;
    	this.text = text;
    }
	
	

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public String getValue() {
		return this.value;
	}
	
}
