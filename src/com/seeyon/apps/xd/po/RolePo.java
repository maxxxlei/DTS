package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;

public class RolePo extends BasePO {
	
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	
	/**
	 * 菜单ID
	 */
	private Long menuID;


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public Long getMenuID() {
		return menuID;
	}


	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}
	
	
	
	
	
}
