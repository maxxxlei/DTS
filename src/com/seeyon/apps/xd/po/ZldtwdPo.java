package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;
/**
 * 战略地图维度Po
 * @author 继往开来
 *
 */
@SuppressWarnings("serial")
public class ZldtwdPo  extends BasePO{


	// 战略地图名称
	private String name;
	// 是否启用
	private Integer isEnable;
	// 版本号
	private Long versionId;
	// 版本启用状态
	private Integer verState;
	// 创建时间
	private Date createTime;
	// 修改时间
	private Date updateTime;
	// 是否删除
	private Integer isDelete;
	// 描述
	private String description;
	
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
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	
	public Integer getVerState() {
		return verState;
	}
	public void setVerState(Integer verState) {
		this.verState = verState;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
