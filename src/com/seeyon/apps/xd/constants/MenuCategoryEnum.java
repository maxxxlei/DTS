package com.seeyon.apps.xd.constants;

import java.util.LinkedHashMap;
import java.util.Map;

import com.seeyon.apps.xd.constants.Xd24Enum.MenuCategory;
import com.seeyon.ctp.common.code.CustomCode;

/**
 * 菜单分类，用于前端枚举
 * @author zhaifeng
 *
 */
public class MenuCategoryEnum implements CustomCode {

	@Override
	public Map getCodesMap(Map codeCfg) {
		MenuCategory[] categorys = MenuCategory.values();
		Map myMap = new LinkedHashMap();
		for(int i=0;i<categorys.length;i++){
			MenuCategory cate = categorys[i];
			myMap.put(cate.getKey(), cate.getText());
		}
		return myMap;
	}

}
