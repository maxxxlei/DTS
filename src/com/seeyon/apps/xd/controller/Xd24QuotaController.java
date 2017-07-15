package com.seeyon.apps.xd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;

/**
 * 
 * @author fengkai
 *
 */
public class Xd24QuotaController extends BaseController {
	
	   /**
	    * 主页面显示
	    * @param request
	    * @param response
	    * @return
	    * @throws BusinessException
	    */
       public ModelAndView createQuota(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
    	   
    	  ModelAndView view = new ModelAndView("/apps/quota/quota");
    	       return view;
		       
	}
       public ModelAndView createQuotaa(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
	
	       return new ModelAndView("/apps/quota/3");
    }

}
