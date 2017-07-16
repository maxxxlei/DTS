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
	 * 指标库列表页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listMenu(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		ModelAndView view = new ModelAndView("/apps/xd24zfz/menurole/menulist");
		return view;

	}
	
	

}
