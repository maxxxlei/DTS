package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.seeyon.apps.xd.vo.UserVo;
import com.seeyon.ctp.common.AppContext;
import com.seeyon.ctp.common.authenticate.domain.User;
import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.organization.bo.V3xOrgAccount;
import com.seeyon.ctp.organization.bo.V3xOrgDepartment;
import com.seeyon.ctp.organization.bo.V3xOrgPost;
import com.seeyon.ctp.organization.manager.OrgManager;
/**
 * 目标controller
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class Xd24TargetController extends BaseController{

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetController.class);
	private OrgManager orgManager;
	
	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}

	public ModelAndView createTarget(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("进入跳转新增目标页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/target/createTarget");
		User user = AppContext.getCurrentUser();
		UserVo uv = new UserVo();
		uv.setId(user.getId());
		uv.setName(user.getName());
		Long accountId = user.getAccountId();
		uv.setAccountId(accountId);
		Long postId = user.getPostId();
		uv.setPostId(postId);
		V3xOrgPost post = orgManager.getPostById(postId);
		uv.setPostName(post.getName());
		Long departmentId = user.getDepartmentId();
		uv.setDepartMentId(departmentId);
		V3xOrgAccount orgAccount = orgManager.getAccountById(accountId);
		uv.setAccountName(orgAccount.getName());
		V3xOrgDepartment department = orgManager.getDepartmentById(departmentId);
		uv.setDepartMentName(department.getName());
		LOGGER.info("人员信息========="+uv.toString());
		mav.addObject("user", uv);
		return mav;
	}
}
