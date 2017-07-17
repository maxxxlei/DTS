package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24GuiHuaManager {
	/**
	 * 查询规划
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo  getGuiHua(FlipInfo fi,Map<String, Object> param) throws BusinessException;
}
