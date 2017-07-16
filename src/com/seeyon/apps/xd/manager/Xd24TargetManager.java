package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24TargetManager {

	/**
	 * 获取目标任务列表
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
	public void saveTarget(Object entity) throws BusinessException;
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	public String deleteTargets(String[] ids) throws BusinessException;
}
