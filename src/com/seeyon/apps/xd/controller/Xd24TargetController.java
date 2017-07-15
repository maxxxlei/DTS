package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
/**
 * 目标controller
 * @author heliang.wang
 *
 * @time 2017年7月14日
 */
public class Xd24TargetController extends BaseController{

	private Logger LOGGER = Logger.getLogger(Xd24TargetController.class);
	public ModelAndView createTarget(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("==================================");
		return new ModelAndView("apps/target/1");
	}
}
