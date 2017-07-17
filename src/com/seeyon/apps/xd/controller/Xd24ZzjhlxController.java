package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.apps.xd.manager.Xd24ZzjhlxManger;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.controller.BaseController;
/**
 * 组织计划类型控制类
 * @author 许永恕
 *
 */
public class Xd24ZzjhlxController extends BaseController{
	private Xd24ZzjhlxManger xd24ZzjhlxManger;
	public void setXd24ZzjhlxManger(Xd24ZzjhlxManger xd24ZzjhlxManger) {
		this.xd24ZzjhlxManger = xd24ZzjhlxManger;
	}


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
		
	/**
	 * 编辑页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView zzjhEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("apps/xd24zfz/zzjhlx/xdZzjhlxadd");
		String flag = request.getParameter("flag");
		view.addObject("flag", flag);
		String rowsId = request.getParameter("id");
		view.addObject("rowsId", rowsId);
		return view;
	}
	
	
}
