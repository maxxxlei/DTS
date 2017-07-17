package com.seeyon.apps.xd.constants;

import java.util.LinkedHashMap;
import java.util.Map;

import com.seeyon.apps.xd.constants.Xd24Enum.MonthEnum;
import com.seeyon.ctp.common.code.CustomCode;

/**
 * 目标-月份enum,用于前端下拉框使用
 * @author heliang.wang
 *
 * @time 2017年7月17日
 */
public class MonthCategoryEnum implements CustomCode {

		@Override
		public Map getCodesMap(Map codeCfg) {
			MonthEnum[] categorys = MonthEnum.values();
			Map myMap = new LinkedHashMap();
			for(int i=0;i<categorys.length;i++){
				MonthEnum cate = categorys[i];
				myMap.put(cate.getKey(), cate.getText());
			}
			return myMap;
		}

}
