package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24ZldtwdDao {
	/**
	 * 查询战略地图维度列表页面
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public List getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
	
	/**
	 * 保存战略地图维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void saveZldtwd(ZldtwdPo po) throws BusinessException;
}
