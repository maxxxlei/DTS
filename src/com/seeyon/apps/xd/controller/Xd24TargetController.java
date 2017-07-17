package com.seeyon.apps.xd.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.ModelAndView;

import www.seeyon.com.utils.UUIDUtil;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.manager.UserManager;
import com.seeyon.apps.xd.manager.Xd24TargetManager;
import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.apps.xd.vo.UserVo;
import com.seeyon.ctp.common.AppContext;
import com.seeyon.ctp.common.authenticate.domain.User;
import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.organization.bo.V3xOrgAccount;
import com.seeyon.ctp.organization.bo.V3xOrgDepartment;
import com.seeyon.ctp.organization.bo.V3xOrgPost;
import com.seeyon.ctp.organization.manager.OrgManager;
import com.seeyon.ctp.util.DateUtil;
import com.seeyon.ctp.util.ParamUtil;
/**
 * 目标controller
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class Xd24TargetController extends BaseController{

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetController.class);
	private Xd24TargetManager xd24TargetManager;
	private UserManager   userManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setXd24TargetManager(Xd24TargetManager xd24TargetManager) {
		this.xd24TargetManager = xd24TargetManager;
	}
	/**
	 * 跳转新增目标页面
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView newTarget(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("进入跳转新增目标页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/target/newTarget");
		
		return mav;

	}
	/**
	 * 目标列表页面
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listTarget(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		return new ModelAndView("apps/xd24zfz/target/listTarget");
	}
	/**
	 * 保存目标
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public void saveTarget(HttpServletRequest request,HttpServletResponse response) throws Exception{
		LOGGER.info("============进入保存目标方法===================");
		PrintWriter out = response.getWriter();
		try {
			Map<String,Object> params = ParamUtil.getJsonParams();
			TargetPo tp = new TargetPo();
			long uuid = UUIDUtil.getUUIDLong();
			tp.setId(uuid);
			//年度
			String year = request.getParameter("year");
			tp.setYear(year);
			//编制时间
			String bzsj = request.getParameter("bzsj");
			tp.setCreateTime(DateUtil.parse(bzsj));
			//生效时间
			String sxsj = request.getParameter("sxsj");
			tp.setEffectTime(DateUtil.parse(sxsj));
			//文件号
			String wjh = request.getParameter("wjh");
			tp.setFileCode(wjh);
			//编号
			String bh = request.getParameter("bh");
			tp.setCode(bh);
			//责任人ID
			String zrrId = request.getParameter("zrrId");
			if(Strings.isNotBlank(zrrId)){
				tp.setMemberId(Long.parseLong(zrrId));
			}
			//单位ID
			String dwId = request.getParameter("dwId");
			tp.setAccountId(Long.parseLong(dwId));
			//上级目标id smbId
			String smbId = request.getParameter("smbId");
			if(Strings.isNotBlank(smbId)){
				tp.setpTargetId(Long.parseLong(smbId));
			}
			//目标编号 mbbh
			String mbbh = request.getParameter("mbbh");
			if(Strings.isNotBlank(mbbh)){
				tp.setTargetCode(mbbh);
			}
			//战略地图维度 zldtwd
			String zldtwd = request.getParameter("zldtwd");
			tp.setDimension(Integer.valueOf(zldtwd));
			//目标名称 mbmc
			String mbmc = request.getParameter("mbmc");
			if(Strings.isNotBlank(mbmc)){
				tp.setSubject(mbmc);
			}
			//目标来源 targetAttr
			String targetAttr = request.getParameter("targetAttr");
			tp.setAttr(Integer.valueOf(targetAttr));
			//目标开始时间 startDate
			String startDate = request.getParameter("startDate");
			if(Strings.isNotBlank(startDate)){
				tp.setStartTime(DateUtil.parse(startDate));
			}
			//目标结束时间 endDate
			String endDate = request.getParameter("endDate");
			if(Strings.isNotBlank(endDate)){
				tp.setEndTime(DateUtil.parse(endDate));
			}
			//是否关键 isCore
			String isCore = request.getParameter("isCore");
			tp.setIsCore(Integer.valueOf(isCore));
			//目标描述 description
			String desciption = request.getParameter("desciption");
			if(Strings.isNotBlank(desciption)){
				tp.setDescription(desciption);
			}
			//TODO 查询版本的信息，目前写死，后续改为调用接口获取
			tp.setVersionId(1L);
			tp.setVersionState(1);
			//新增计划，是否删除状态
			tp.setIsDelete(Integer.valueOf(Xd24Enum.Target.DELETE_N.getKey()));
			//目标录入保存时，设置当前规划计划阶段状态为未审批
			tp.setGhjhState(Integer.valueOf(Xd24Enum.PlanEnum.PLAN_DISAPPROVE.getKey()));
			//TODO 执行阶段审批状态、对比分析状态、更新决议 审批状态、考核评价 审批状态、全面总结状态 需要确定好枚举进行初始值保存
			
			String khzbx_khzq = params.get("khzbx_khzq").toString();
			xd24TargetManager.saveTarget(tp);
			out.write("true");
		} catch (Exception e) {
			out.write("false");
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	/**
	 * 加载目标录入页面
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView transTargetForm(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		ModelAndView mav = new ModelAndView("apps/xd24zfz/target/targetForm");
		User user = AppContext.getCurrentUser();
		UserVo userInfo = userManager.getUserInfo(user.getId());
		mav.addObject("user", userInfo);
		return mav;
	}
}
