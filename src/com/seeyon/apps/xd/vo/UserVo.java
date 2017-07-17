package com.seeyon.apps.xd.vo;

public class UserVo {

	private Long id;
	private String name;
	private Long groupId;//组
	private String groupName;
	private Long accountId;
	private String accountName;//单位
	private Long postId;
	private String postName;//岗位
	private Long departMentId;
	private String departMentName;//部门
	private Long centerId;
	private String centerName;//中心

	public Long getCenterId() {
		return centerId;
	}
	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDepartMentId() {
		return departMentId;
	}
	public void setDepartMentId(Long departMentId) {
		this.departMentId = departMentId;
	}
	public String getDepartMentName() {
		return departMentName;
	}
	public void setDepartMentName(String departMentName) {
		this.departMentName = departMentName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", departMentId="
				+ departMentId + ", departMentName=" + departMentName
				+ ", accountId=" + accountId + ", accountName=" + accountName
				+ ", postId=" + postId + ", postName=" + postName + "]";
	}
	
}
