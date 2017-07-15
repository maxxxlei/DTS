package com.seeyon.apps.xd.dao;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24TargetDao {

	/**
	 * 后去目标任务列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getTargetList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
}
