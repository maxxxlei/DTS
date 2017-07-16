package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;
/**
 * 战略地图维护
 * @author zhaifeng
 *
 */
public class Xd24ZldtwdController extends BaseController{
	public ModelAndView zldtwdList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zfz/zldtwd/zldtwdList");
		return view;
	}
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zfz/zldtwd/edit");
		String flag = request.getParameter("flag");
		view.addObject("flag", flag);
		return view;
	}
}
