package com.seeyon.apps.xd.vo;

import java.util.Date;

/**
 * 战略地图维度列表展示VO
 * @author 继往开来
 *
 */
public class ZldtwdVo {
	private Long id;
	// 战略地图名称
	private String name;
	// 是否启用
	private String isEnable;
	// 描述
	private String description;
	// 创建时间
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
