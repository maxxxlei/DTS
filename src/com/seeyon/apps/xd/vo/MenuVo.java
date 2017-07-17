package com.seeyon.apps.xd.vo;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;

public class MenuVo{
	
	/**
	 * 菜单名称
	 */
	private String name;
	
	/**
	 * 资源链接
	 */
	private String resourceNavUrl;
	
	/**
	 * 菜单分类，规划计划、执行统计、对比分析、更新决议、考核评价、全面总结
	 */
	private Integer category;
	
	/**
	 * 资源编号
	 */
	private Integer resourceCode;
	
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
	
	/**
	 * 菜单级别
	 */
	private Integer menuLevel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceNavUrl() {
		return resourceNavUrl;
	}

	public void setResourceNavUrl(String resourceNavUrl) {
		this.resourceNavUrl = resourceNavUrl;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(Integer resourceCode) {
		this.resourceCode = resourceCode;
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

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	
	
}
