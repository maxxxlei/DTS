package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;
/**
 * 版本管理实体
 */
public class VersionPo extends BasePO {
	
	private static final long serialVersionUID = -4903060622895942789L;
	private Long id;
	/**
	 * 版本名称
	 */
	private String vName;
	/**
	 * 版本编号
	 */
	private String vCode;
	/**
	 * 年度
	 */
	private Long vYear;
	/**
	 * 启用状态
	 */
	private Long state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date uodateTime;
	/**
	 * 是否删除
	 */
	private Long isDelete;
	/**
	 * 描述
	 */
	private String desc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvCode() {
		return vCode;
	}
	public void setvCode(String vCode) {
		this.vCode = vCode;
	}
	public Long getvYear() {
		return vYear;
	}
	public void setvYear(Long vYear) {
		this.vYear = vYear;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUodateTime() {
		return uodateTime;
	}
	public void setUodateTime(Date uodateTime) {
		this.uodateTime = uodateTime;
	}
	public Long getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
