package com.seeyon.apps.xd.po;

import java.io.Serializable;
import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;

/**
 * 
 * 指标库实体
 * @author fengkai
 *
 */
public class QuotaPo extends BasePO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5591862178663952558L;
	private Long id;
	/**
	 * 版本号id
	 */
	private Long versionId;
	/**启用状态
	 * 
	 */
	private Integer v_state;
	/** 
	 * 指标分类
	 */
	private Integer quotaClass;
	/** 
	 * 指标编号
	 */
	private Long quotaCode;
	/** 
	 * 指标项名称
	 */
	private String quotaName;
	/** 
	 * 度量
	 */
	private Integer quotaUnit;
	/** 
	 * 指标控件类型
	 */
	private String quotaType;

	/**
	 * 创建时间
	 */
	private Date create_Time;
	/**
	 * 修改时间
	 */
	private Date update_Time;
	public Long getId() {
		return id;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public Integer getV_state() {
		return v_state;
	}
	public void setV_state(Integer v_state) {
		this.v_state = v_state;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuotaClass() {
		return quotaClass;
	}
	public void setQuotaClass(int quotaClass) {
		this.quotaClass = quotaClass;
	}
	public Long getQuotaCode() {
		return quotaCode;
	}
	public void setQuotaCode(Long quotaCode) {
		this.quotaCode = quotaCode;
	}
	public String getQuotaName() {
		return quotaName;
	}
	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}
	public int getQuotaUnit() {
		return quotaUnit;
	}
	public void setQuotaUnit(int quotaUnit) {
		this.quotaUnit = quotaUnit;
	}
	public String getQuotaType() {
		return quotaType;
	}
	public void setQuotaType(String quotaType) {
		this.quotaType = quotaType;
	}
	public Date getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(Date create_Time) {
		this.create_Time = create_Time;
	}
	public Date getUpdate_Time() {
		return update_Time;
	}
	public void setUpdate_Time(Date update_Time) {
		this.update_Time = update_Time;
	}

}
