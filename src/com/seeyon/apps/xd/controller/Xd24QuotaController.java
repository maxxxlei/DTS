package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;

/**
 * 鑫达24字方针指标库Controller
 * 
 * @author fengkai
 *
 */
public class Xd24QuotaController extends BaseController {

	/**
	 * 指标库列表页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listQuota(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		ModelAndView view = new ModelAndView("/apps/xd24zfz/quota/quotaList");
		return view;

	}
	
	

	

}
