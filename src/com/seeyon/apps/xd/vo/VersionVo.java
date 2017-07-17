package com.seeyon.apps.xd.vo;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;
/**
 * 版本管理实体
 */
public class VersionVo extends BasePO {
	
	private static final long serialVersionUID = -4903060622895942789L;
	private Long id;
	
	/**
	 * 版本编号
	 */
	private String vCode;
	/**
	 * 年度
	 */
	private String vYear;
	/**
	 * 启用状态
	 */
	private String state;
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
	private Integer isDelete;
	/**
	 * 描述
	 */
	private String desc;
	
	/**
	 * 状态，是否启用、停用，
		0：停用
		1：启用
	 */
	private String isEnable;
	
	/**
	 * 版本 ID
	 */
	private Long versionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getvCode() {
		return vCode;
	}

	public void setvCode(String vCode) {
		this.vCode = vCode;
	}

	public String getvYear() {
		return vYear;
	}

	public void setvYear(String vYear) {
		this.vYear = vYear;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
