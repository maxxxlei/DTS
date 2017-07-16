package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

/**
 * 菜单角色管理
 * @author zhaifeng
 *
 */
public interface MenuRoleManager {
	
	/**
	 * 查询菜单列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getMenuList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
	
	
}
