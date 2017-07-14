package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;

public class Xd24cdController extends BaseController{

	
	/**
	 * 二级菜单1
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView xdcd24SearchList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/target/1");
		return view;
	}
	
	
/**
 * 二级菜单2
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
	public ModelAndView xdcd24SendList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zfz/xdSendList");
		return view;
	}
}
