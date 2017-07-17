package com.seeyon.apps.xd.manager;

import com.seeyon.apps.xd.vo.UserVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.organization.bo.V3xOrgAccount;
import com.seeyon.ctp.organization.bo.V3xOrgDepartment;
import com.seeyon.ctp.organization.bo.V3xOrgMember;
import com.seeyon.ctp.organization.bo.V3xOrgPost;
import com.seeyon.ctp.organization.manager.OrgManager;

public class UserManagerImpl implements UserManager {

	private OrgManager orgManager;
	
	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}

	@Override
	public UserVo getUserInfo(Long memberId) throws BusinessException {
		UserVo uv = new UserVo();
		if(memberId != null){
			V3xOrgMember member = orgManager.getMemberById(memberId);
			uv.setId(memberId);
			uv.setName(member.getName());
			//单位id
			Long accountId = member.getOrgAccountId();
			uv.setAccountId(accountId);
			//岗位id
			Long postId = member.getOrgPostId();
			uv.setPostId(postId);
			V3xOrgPost post = orgManager.getPostById(postId);
			uv.setPostName(post.getName());
			//组id(所在部门ID)
			Long groupId = member.getOrgDepartmentId();
			uv.setGroupId(groupId);
			V3xOrgDepartment group = orgManager.getDepartmentById(groupId);
			uv.setGroupName(group.getName());
			V3xOrgAccount orgAccount = orgManager.getAccountById(accountId);
			uv.setAccountName(orgAccount.getName());
			//部门(组所在的上级部门)
			V3xOrgDepartment departMent = orgManager.getDepartmentByPath(group.getParentPath());
			uv.setDepartMentId(departMent.getId());
			uv.setDepartMentName(departMent.getName());
			//中心
			String accountPath = group.getPath();
			String path = accountPath.substring(0, 12);
			V3xOrgDepartment center = orgManager.getDepartmentByPath(path);
			uv.setCenterId(center.getId());
			uv.setCenterName(center.getName());
		}
		return uv;
	}
}
