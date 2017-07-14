package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.AppContext;
import com.seeyon.ctp.common.authenticate.domain.User;
import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
/**
 * 目标controller
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class Xd24TargetController extends BaseController{

	public ModelAndView createTarget(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		ModelAndView mav = new ModelAndView("apps/xd24zfz/target/createTarget");
		User user = AppContext.getCurrentUser();
		
		mav.addObject("user", user);
		return mav;
	}
}
