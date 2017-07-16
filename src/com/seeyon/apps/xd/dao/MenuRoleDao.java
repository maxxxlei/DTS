package com.seeyon.apps.xd.dao;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface MenuRoleDao {
	/**
	 * 查询菜单列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getMenuList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
}
