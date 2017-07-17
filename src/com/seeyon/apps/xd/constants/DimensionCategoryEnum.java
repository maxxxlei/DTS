package com.seeyon.apps.xd.constants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.manager.Xd24ZldtwdManager;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.AppContext;
import com.seeyon.ctp.common.code.CustomCode;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.Strings;

/**
 * 战略地图维度，用于前端枚举
 * @author heliang.wang
 *
 */
public class DimensionCategoryEnum implements CustomCode {

	private static final Logger LOGGER = Logger.getLogger(DimensionCategoryEnum.class);
	private Xd24ZldtwdManager xd24ZldtwdManager = (Xd24ZldtwdManager) AppContext.getBean("xd24ZldtwdManager");
	
	@Override
	public Map getCodesMap(Map codeCfg) {
		Map myMap = new LinkedHashMap();
		try {
			List<ZldtwdPo> list = xd24ZldtwdManager.getZldtwdList4Enum();
			if(Strings.isNotEmpty(list)){
				for(ZldtwdPo zp : list){
					myMap.put(zp.getId(), zp.getName());
				}
			}
		} catch (BusinessException e) {
			LOGGER.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return myMap;
	}

}
