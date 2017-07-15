package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.apps.xd.manager.Xd24Manger;
import com.seeyon.ctp.common.controller.BaseController;
/**
 * 组织计划类型控制类
 * @author 许永恕
 *
 */
public class ZzjhlxController extends BaseController{
	private Xd24Manger xd24Manger;

	public Xd24Manger getXd24Manger() {
		return xd24Manger;
	}

	public void setXd24Manger(Xd24Manger xd24Manger) {
		this.xd24Manger = xd24Manger;
	}
	
	
	/**
	 * 二级菜单1
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView xdcd24SearchList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zzjhlx/xdZzjhlxList");
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
		ModelAndView view = new ModelAndView("apps/xd24zzjhlx/xdZzjhlxZzjh");
		return view;
	}
	
	
	/**
	 * 二级菜单2
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
		public ModelAndView newaddRow(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView view = new ModelAndView("apps/xd24zzjhlx/xdZzjhlxadd");
			return view;
		}
		
	
	
	
}
