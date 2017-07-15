package com.seeyon.apps.xd.vo;

import java.util.Date;

public class ZzjhlxVo {

	private Long id;
	/**
	 * 规划类型
	 */
	
	/**
	 * 组织计划名称
	 */
	private String name;
	
	/**
	 * 是否启用
	 */
	private int isEnable;
	
	/**
	 * 版本是否有效
	 */
	
	private Long versionId;
	
	/**
	 * 启用状态
	 */
	private int state;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	/**
	 * 是否删除
	 */
	private int isDelete;
	
	/**
	 * 描述
	 */
	private String desc;

	public ZzjhlxVo() {
		super();
	}

	public ZzjhlxVo(Long id, String name, int isEnable, Long versionId,
			int state, Date createTime, Date updateTime, int isDelete,
			String desc) {
		super();
		this.id = id;
		this.name = name;
		this.isEnable = isEnable;
		this.versionId = versionId;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.desc = desc;
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

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


}
