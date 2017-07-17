package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;
/**
 * 组织计划类型控制类
 * @author 许永恕
 *
 */
public class Xd24ZzjhlxController extends BaseController{
//	private Xd24Manger xd24Manger;
//
//	public Xd24Manger getXd24Manger() {
//		return xd24Manger;
//	}
//
//	public void setXd24Manger(Xd24Manger xd24Manger) {
//		this.xd24Manger = xd24Manger;
//	}
	
	
	/**
	 * 组织计划列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView zzjhList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zfz/zzjhlx/xdZzjhlxList");
		return view;
	}
	
	
	/**
	 * 新建页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView zzjhAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zfz/zzjhlx/xdZzjhlxadd");
		String flag = request.getParameter("flag");
		view.addObject("flag", flag);
		String rowsId = request.getParameter("rowsId");
		view.addObject("rowsId", rowsId);
		return view;
	}
		

	
	
}
