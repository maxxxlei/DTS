package com.seeyon.apps.xd.po;

import java.util.Date;

import com.seeyon.ctp.common.po.BasePO;
/**
 * 规划类型管理
 */
public class PlanTypePo extends BasePO {
	private static final long serialVersionUID = 1L;
	private Long id;
	/**
	 * 规划类型
	 */
	private Long ptype;
	
	/**
	 * 规划名字
	 */
	private String pname;
	
	/**
	 * 启用状态
	 */
	private Integer state;
	
	/**
	 * 创建时间
	 */
	private Date createtime;
	
	/**
	 * 修改时间
	 */
	private Date updatetime;
	
	/**
	 * 是否删除
	 */
	private Integer isdelete;
	
	/**
	 * 描述
	 */
	private String desc;

	public PlanTypePo() {
		super();
	}

	public PlanTypePo(Long id, Long ptype, String pname, Integer state,
			Date createtime, Date updatetime, Integer isdelete, String desc) {
		super();
		this.id = id;
		this.ptype = ptype;
		this.pname = pname;
		this.state = state;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isdelete = isdelete;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPtype() {
		return ptype;
	}

	public void setPtype(Long ptype) {
		this.ptype = ptype;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
