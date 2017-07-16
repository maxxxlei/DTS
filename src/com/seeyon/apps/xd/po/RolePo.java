package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;

public class RolePo extends BasePO {
	
	/**
	 * 角色名称
	 */
	private String name;
	
	
	
	/**
	 * 资源编号
	 */
	private Integer code;
	
	/**
	 * 排序号
	 */
	private Integer sortCode;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 创建时间
	 */
	private Date updateTime;
	
	/**
	 * 是否删除
	 */
	private Integer isDelete;
	
	/**
	 * 是否启用
	 */
	private Integer isEnable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	

	
}
