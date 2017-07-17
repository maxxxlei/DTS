package com.seeyon.apps.xd.constants;

import java.util.LinkedHashMap;
import java.util.Map;

import com.seeyon.apps.xd.constants.Xd24Enum.GuiHuaType;
import com.seeyon.ctp.common.code.CustomCode;

public class GuiHuaTypeEnum implements CustomCode {

	@Override
	public Map getCodesMap(Map paramMap) {
		GuiHuaType[] guihuaType = GuiHuaType.values();
		Map myMap = new LinkedHashMap();
		for(int i=0;i<guihuaType.length;i++){
			GuiHuaType cate = guihuaType[i];
			myMap.put(cate.getKey(), cate.getText());
		}
		return myMap;
	}

}
