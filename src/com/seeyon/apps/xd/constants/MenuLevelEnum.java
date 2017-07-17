package com.seeyon.apps.xd.constants;

import com.seeyon.ctp.common.code.EnumsCode;

public enum MenuLevelEnum implements EnumsCode {
	Level1("1","一级菜单"),	
	Level2("2","二级菜单"),
	Level3("3","三级菜单");
	
	
	private String value;
    private String text;
	MenuLevelEnum(String value,String text){
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
