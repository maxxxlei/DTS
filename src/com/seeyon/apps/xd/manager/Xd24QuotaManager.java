package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;


public interface Xd24QuotaManager {
	
	/**
	 * 获取指标库信息
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getQuota(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;

}
