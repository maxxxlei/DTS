package com.seeyon.apps.xd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.seeyon.apps.xd.manager.Xd24QuotaManager;
import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.apps.xd.vo.QuotaVo;
import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.ParamUtil;
import com.seeyon.ctp.util.UUIDLong;

/**
 * 鑫达24字方针指标库Controller
 * 
 * @author fengkai
 *
 */
public class Xd24QuotaController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(Xd24QuotaController.class);
	private Xd24QuotaManager xd24QuotaManager;

	public void setXd24QuotaManager(Xd24QuotaManager xd24QuotaManager) {
		this.xd24QuotaManager = xd24QuotaManager;
	}
	/**
	 * 指标库列表页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listQuota(HttpServletRequest request,
			HttpServletResponse response,FlipInfo fi) throws BusinessException {
		ModelAndView view = new ModelAndView("/apps/xd24zfz/quota/listQuota");
		return view;

	}
	/**
	 * 
	 * 指标库新建保存跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView newQuota(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		
     	ModelAndView mav = new ModelAndView("/apps/xd24zfz/quota/newQuota");
     	long id = UUIDLong.longUUID();
		long versionId = UUIDLong.longUUID();
		Map<String, Object> params = ParamUtil.getJsonParams();
		
		if(params.size()>0){
			Long quotaCode = Long.parseLong(params.get("quotaCode").toString());
			String quotaName = params.get("quotaName").toString();
			Integer quotaClass = Integer.parseInt(params.get("quotaClass").toString());
			Integer quotaUnit = Integer.parseInt(params.get("quotaUnit").toString());
			//Integer v_state = Integer.parseInt(params.get("v_state").toString());
			String quotaType = params.get("quotaType").toString();
			QuotaPo Po = new QuotaPo();
			Po.setId(id);
			Po.setVersionId(versionId);
			Po.setQuotaClass(quotaClass);
			Po.setQuotaName(quotaName);
			Po.setQuotaCode(quotaCode);
			Po.setQuotaUnit(quotaUnit);
			Po.setQuotaType(quotaType);
			Po.setCreate_Time(new Date());
			Po.setUpdate_Time(new Date());
			Po.setV_state(1);
			
			Boolean isSuccess = xd24QuotaManager.saveQuotaPo(Po);
			LOGGER.info("添加是否成功==="+isSuccess);
		}
		return mav;

	}
	/**
	 * 修改目标方法
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView editQuota(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView view = new ModelAndView("apps/xd24zfz/quota/editQuota");
		String flag = request.getParameter("flag");
		view.addObject("flag", flag);
		return view;
		
	}



}
