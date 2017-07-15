package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;
/**
 * 目标录入-考核、考察目标项表 entity
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class TargetItemPo extends BasePO{

	private static final long serialVersionUID = -3808179282583756395L;
	private Long 	id;
	private Long 	targetId;	//所属目标ID
	private int		type;	//枚举，是指考核目标项还是考察目标项 	
	private int		khzq; 	//考核周期：年度、半年度、季度、月度
	private int		khzqxx; //考核周期细项
	private Long	month;	//月
	private Date  	startTime;	//考核、考察开始日
	private Date  	endTime;	//考核、考察结束日
	private Long 	goalId;	//目标项ID
	private String 	goalName;	//目标项名称
	private String 	otherMember;	//协同责任人
	private String 	actualValue;	//实际值
	
	public Long getGoalId() {
		return goalId;
	}
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getKhzq() {
		return khzq;
	}
	public void setKhzq(int khzq) {
		this.khzq = khzq;
	}
	public int getKhzqxx() {
		return khzqxx;
	}
	public void setKhzqxx(int khzqxx) {
		this.khzqxx = khzqxx;
	}
	public Long getMonth() {
		return month;
	}
	public void setMonth(Long month) {
		this.month = month;
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
	public String getOtherMember() {
		return otherMember;
	}
	public void setOtherMember(String otherMember) {
		this.otherMember = otherMember;
	}
	public String getActualValue() {
		return actualValue;
	}
	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}
	
}
