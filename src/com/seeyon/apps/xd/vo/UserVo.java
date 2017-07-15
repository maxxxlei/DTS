package com.seeyon.apps.xd.vo;

public class UserVo {

	private Long id;
	private String name;
	private Long departMentId;
	private String departMentName;
	private Long accountId;
	private String accountName;
	private Long postId;
	private String postName;
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
