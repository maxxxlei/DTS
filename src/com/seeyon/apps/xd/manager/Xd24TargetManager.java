package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24TargetManager {

	/**
	 * 后去目标任务列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getTargetList(FlipInfo flipInfo, Map<String, String> params) throws BusinessException;
	/**
	 * 保存目标
	 * @param tp
	 * @throws BusinessException
	 */
	public void saveTarget(TargetPo tp) throws BusinessException;
}
