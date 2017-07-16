package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24TargetDao {

	/**
	 * 获取目标任务列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public List<Object[]> getTargetList(FlipInfo flipInfo, Map<String, String> params) throws BusinessException;
	/**
	 * 获取目标任务列表
	 * @param flipInfo
	 * @param params
	 * @param key 搜索框key
	 * @param value 搜索框value
	 * @return
	 * @throws BusinessException
	 */
	public List<Object[]> getTargetList(FlipInfo flipInfo, Map<String, String> params,String key,String value) throws BusinessException;
	/**
	 * 保存目标
	 * @param tp
	 * @throws BusinessException
	 */
	public void saveTarget(TargetPo tp) throws BusinessException;
}
