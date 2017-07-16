package com.seeyon.apps.xd.manager;

import java.util.List;
import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
/**
 * 战略地图维护
 * @author zhaifeng
 *
 */
public interface Xd24ZldtwdManager {
	/**
	 * 查询战略维度
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public List getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
	
	/**
	 * 保存战略维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void saveZldtwd(Map<String, String> zldtwd) throws BusinessException;
}
