package com.seeyon.apps.xd.vo;

import java.util.Date;

public class TargetVo {

	private Long 		id;
	private String 		year;
	private Date 		createTime; //编制时间
	private Date		effectTime; //生效时间
	private Long 		accountId;//单位id
	private Long 		memberId;//编制人id
	private Long 		pTargetId;//上级目标id
	private String 		code;	//目标编号
	private int 		dimension; //战略地图维度
	private String		subject; //目标名称
	private int			attr; //目标属性
	private Date 		startTime; //目标开始时间
	private Date		endTime; //目标结束时间
	private int 		isCore;	//是否关键
	private String		description;
	private Long 		versionId;//版本号ID
	private int 		isDelete;
	private Date 		updateTime;
	private int 		ghjhState;//规划阶段审批状态
	private int 		zxtjState;//执行阶段审批状态
	private int 		dbfxState;//对比分析状态
	private int 		gxjyState;//更新决议 审批状态
	private int 		khpjState;//考核评价 审批状态
	private int 		qmzjState;//全面总结状态
	
}
