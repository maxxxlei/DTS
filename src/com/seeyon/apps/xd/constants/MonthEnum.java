package com.seeyon.apps.xd.constants;

import com.seeyon.ctp.common.code.EnumsCode;

public enum MonthEnum implements EnumsCode {
	Month1("1","1月"),	
	Month2("2","2月"),
	Month3("3","3月"),
	Month4("4","4月"),
	Month5("5","5月"),
	Month6("6","6月"),
	Month7("7","7月"),
	Month8("8","8月"),
	Month9("9","9月"),
	Month10("10","10月"),
	Month11("11","11月"),
	Month12("12","12月");
	
	
	private String value;
    private String text;
	MonthEnum(String value,String text){
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
