package com.seeyon.apps.xd.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.seeyon.apps.xd.manager.VersionManager;
import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.ParamUtil;
import com.seeyon.ctp.util.UUIDLong;


/**
 * 规划计划
 * @author ML
 *
 */
public class Xd24GuiHuaController extends BaseController {
 
	private Logger LOGGER = Logger.getLogger(Xd24GuiHuaController.class);
	
	/**
	 * 新增规划
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 * @throws ParseException 
	 */
	public ModelAndView newGuiHua(HttpServletRequest request,HttpServletResponse response) throws BusinessException, ParseException{
		LOGGER.info("进入跳转新增规划页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/version/saveVersion");
		return mav;
	}
	
	
	/**
	 * 编辑规划
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView editGuiHua(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("进入跳转编辑规划页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/version/editVersion");
		return mav;
	}
	
	
	/**
	 * 获取规划信息
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listGuiHua(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("进入跳转获取规划信息页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/guihua/guiHuaList");
		
		return mav;
	}
	
}
