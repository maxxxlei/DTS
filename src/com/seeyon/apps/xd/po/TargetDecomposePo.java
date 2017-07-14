package com.seeyon.apps.xd.po;

import java.io.Serializable;
/**
 * 目标录入-向下分解表 entity
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class TargetDecomposePo implements Serializable{

	private static final long serialVersionUID = 8250549068411958925L;
	
	private Long 	id;
	private Long 	targetId;	//所属目标ID
	private String  targetDesc;	
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
	public String getTargetDesc() {
		return targetDesc;
	}
	public void setTargetDesc(String targetDesc) {
		this.targetDesc = targetDesc;
	}
	public Long getTargetRecipientId() {
		return targetRecipientId;
	}
	public void setTargetRecipientId(Long targetRecipientId) {
		this.targetRecipientId = targetRecipientId;
	}
	
}
