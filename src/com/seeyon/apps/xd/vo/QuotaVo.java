package com.seeyon.apps.xd.vo;

import java.io.Serializable;

/**
 * 
 * 指标库实体
 * @author fengkai
 *
 */
public class QuotaVo implements Serializable {

	
	private static final long serialVersionUID = -6708333852054165703L;
	private Long id;
	/** 
	 * 指标分类
	 */
	private int quotaClass;
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
	private int quotaUnit;
	/** 
	 * 指标控件类型
	 */
	private String quotaType;
	public Long getId() {
		return id;
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

}
