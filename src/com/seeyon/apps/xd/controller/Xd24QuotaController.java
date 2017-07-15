package com.seeyon.apps.xd.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.ModelAndView;

import www.seeyon.com.utils.UUIDUtil;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.manager.Xd24QuotaManager;
import com.seeyon.apps.xd.manager.Xd24TargetManager;
import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.controller.BaseController;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DateUtil;

/**
 * 鑫达24字方针指标库Controller
 * 
 * @author fengkai
 *
 */
public class Xd24QuotaController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(Xd24QuotaController.class);
	private Xd24QuotaManager xd24QuotaManager;

	public void setXd24TargetManager(Xd24QuotaManager xd24QuotaManager) {
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
			HttpServletResponse response) throws BusinessException {

		ModelAndView view = new ModelAndView("/apps/xd24zfz/quota/quotaList");
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
		
     	ModelAndView view = new ModelAndView("/apps/xd24zfz/quota/quotaNew");
		return view;

	}
	/**
	 * 保存目标方法
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveQuota(HttpServletRequest request,HttpServletResponse response) throws Exception{
		LOGGER.info("====进入保存目标方法======");
		PrintWriter out = response.getWriter();
		try {
			QuotaPo qp = new QuotaPo();
			qp.setId(UUIDUtil.getUUIDLong());
			//指标项
			String name = request.getParameter("name");
			if(Strings.isNotBlank(name)){
				qp.setQuotaName(name);
			}
			//指标编号
			String code = request.getParameter("code");
			 qp.setQuotaCode(Long.parseLong(code));
			//指标类型
			String qclass = request.getParameter("qclass");
			qp.setQuotaClass(Integer.valueOf(qclass));
			//度量
			String unit = request.getParameter("unit");
			qp.setQuotaUnit(Integer.valueOf(unit));;
			//指标控件类型
			String type = request.getParameter("type");
			qp.setQuotaType(type);
			qp.setVersionId(1L);
			qp.setV_state(1);
			xd24QuotaManager.saveQuota(qp);
			out.write("true");
		} catch (Exception e) {
			out.write("false");
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

	

}
