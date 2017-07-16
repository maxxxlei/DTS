package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.apps.xd.dao.MenuRoleDao;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

/**
 * 菜单角色管理
 * @author zhaifeng
 *
 */
public class MenuRoleManagerImpl implements MenuRoleManager {
	private MenuRoleDao menuRoleDao;
	
	public void setMenuRoleDao(MenuRoleDao menuRoleDao) {
		this.menuRoleDao = menuRoleDao;
	}



	@Override
	public FlipInfo getMenuList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		menuRoleDao.getMenuList(flipInfo, query);
		return null;
	}
	
	

}
