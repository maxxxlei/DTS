package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;
/**
 * 目标录入主表 entity
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class TargetPo extends BasePO{

	private static final long serialVersionUID = -5147350311650086895L;
	private Long 		id;
	private String 		year;
	private String		fileCode;	//文件号
	private String		code;	//编号
	private Date 		createTime; //编制时间
	private Date		effectTime; //生效时间
	private Long 		accountId;//单位id
	private Long 		memberId;//责任人id
	private Long 		pTargetId;//上级目标id
	private String 		targetCode;	//目标编号
	private int 		dimension; //战略地图维度
	private String		subject; //目标名称
	private int			attr; //目标属性
	private Date 		startTime; //目标开始时间
	private Date		endTime; //目标结束时间
	private int 		isCore;	//是否关键
	private String		description;
	private Long 		versionId;//版本号ID
	private int 		versionState;//版本号状态
	private int 		isDelete;
	private Date 		updateTime;
	private int 		ghjhState;//规划阶段审批状态
	private int 		zxtjState;//执行阶段审批状态
	private int 		dbfxState;//对比分析状态
	private int 		gxjyState;//更新决议 审批状态
	private int 		khpjState;//考核评价 审批状态
	private int 		qmzjState;//全面总结状态
	
	public int getVersionState() {
		return versionState;
	}
	public void setVersionState(int versionState) {
		this.versionState = versionState;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getTargetCode() {
		return targetCode;
	}
	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}
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
	public Date getEffectTime() {
		return effectTime;
	}
	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
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
	public Long getpTargetId() {
		return pTargetId;
	}
	public void setpTargetId(Long pTargetId) {
		this.pTargetId = pTargetId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAttr() {
		return attr;
	}
	public void setAttr(int attr) {
		this.attr = attr;
	}
	public int getIsCore() {
		return isCore;
	}
	public void setIsCore(int isCore) {
		this.isCore = isCore;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getGhjhState() {
		return ghjhState;
	}
	public void setGhjhState(int ghjhState) {
		this.ghjhState = ghjhState;
	}
	public int getZxtjState() {
		return zxtjState;
	}
	public void setZxtjState(int zxtjState) {
		this.zxtjState = zxtjState;
	}
	public int getDbfxState() {
		return dbfxState;
	}
	public void setDbfxState(int dbfxState) {
		this.dbfxState = dbfxState;
	}
	public int getGxjyState() {
		return gxjyState;
	}
	public void setGxjyState(int gxjyState) {
		this.gxjyState = gxjyState;
	}
	public int getKhpjState() {
		return khpjState;
	}
	public void setKhpjState(int khpjState) {
		this.khpjState = khpjState;
	}
	public int getQmzjState() {
		return qmzjState;
	}
	public void setQmzjState(int qmzjState) {
		this.qmzjState = qmzjState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
