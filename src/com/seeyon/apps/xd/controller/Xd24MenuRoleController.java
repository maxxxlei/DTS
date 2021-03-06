package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;

/**
 * 鑫达24字方针权限校验Controller
 * 
 * @author 翟锋
 *
 */
public class Xd24MenuRoleController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(Xd24MenuRoleController.class);
	
	/**
	 * 菜单角色管理框架页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView indexFrame(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		ModelAndView view = new ModelAndView("/apps/xd24zfz/menurole/indexFrame");
		return view;

	}
	
	
	/**
	 * 菜单管理页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listMenu(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		ModelAndView view = new ModelAndView("/apps/xd24zfz/menurole/listMenu");
		return view;

	}
	
	/**
	 * 角色管理页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listRole(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		ModelAndView view = new ModelAndView("/apps/xd24zfz/menurole/listRole");
		return view;

	}
	
	/**
	 * 菜单修改、查看页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView editMenu(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		ModelAndView view = new ModelAndView("/apps/xd24zfz/menurole/menuEdit");
		String operType = request.getParameter("operType");
		return view;

	}
	/**
	 * 菜单新建页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView addMenu(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		ModelAndView view = new ModelAndView("/apps/xd24zfz/menurole/menuEdit");
		return view;

	}
}
