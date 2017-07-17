package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;

/**
 * 规划表
 * @author ML
 *
 */
public class GuiHuaPo extends BasePO {
	
	private static final long serialVersionUID = 4847027645311785073L;
	
	private Long id ;
	/**
	 * 年度
	 */
	private String year;
	/**
	 * 创建时间（编制时间）
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 单位id
	 */
	private Long accountId;
	/**
	 * 编制人
	 */
	private Long memberId;
	/**
	 * 规划类型
	 */
	private Integer type;
	/**
	 * 规划名称
	 */
	private String ghName;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 标的物
	 */
	private String attachment;
	/**
	 * 审批状态
	 * 0:未审批
	 *	1：审批中
	 *	2：审批通过
	 *	3：审批未通过
	 */
	private Integer state;
	/**
	 * '是否删除
		1：删除
		0：未删除'
	 */
	private Integer isDelete;
	/**
	 * 版本id
	 */
	private Long versionId;
	/**
	 * 版本是否生效状态
	 * 0.生效
	 * 1.不生效
	 */
	private Integer vState;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getGhName() {
		return ghName;
	}
	public void setGhName(String ghName) {
		this.ghName = ghName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public Integer getvState() {
		return vState;
	}
	public void setvState(Integer vState) {
		this.vState = vState;
	}
	
	
	
}
