package com.seeyon.apps.xd.po;

import java.sql.Clob;

import com.seeyon.ctp.common.po.BasePO;

/**
 * 目标录入-向下分解表 entity
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class TargetDecomposePo extends BasePO{

	private static final long serialVersionUID = 8250549068411958925L;
	
	private Long 	id;
	private Long 	targetId;	//所属目标ID
	private Clob  targetDesc;	
	private Long 	targetRecipientId;	//目标承接人id
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
	public Clob getTargetDesc() {
		return targetDesc;
	}
	public void setTargetDesc(Clob targetDesc) {
		this.targetDesc = targetDesc;
	}
	public Long getTargetRecipientId() {
		return targetRecipientId;
	}
	public void setTargetRecipientId(Long targetRecipientId) {
		this.targetRecipientId = targetRecipientId;
	}
	
}
