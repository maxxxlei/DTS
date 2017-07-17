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
 * 版本管理
 * @author 刘伟敏
 *
 */
public class VersionController extends BaseController {
 
	private Logger LOGGER = Logger.getLogger(VersionController.class);
	
	private VersionManager versionManager;
	
	public void setVersionManager(VersionManager versionManager) {
		this.versionManager = versionManager;
	}


	/**
	 * 新增版本管理
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 * @throws ParseException 
	 */
	public ModelAndView newVersion(HttpServletRequest request,HttpServletResponse response) throws BusinessException, ParseException{
		LOGGER.info("进入跳转新增版本管理页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/version/saveVersion");
		String type = request.getParameter("type");
		
		if("save".equals(type)){
			long id = UUIDLong.longUUID();
			long versionId = UUIDLong.longUUID();
			Map<String, Object> params = ParamUtil.getJsonParams();
			//SimpleDateFormat tempDate = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
			//Integer vState = Integer.parseInt(params.get("is_State").toString());
			//Integer isEnable = Integer.parseInt(params.get("is_Enable").toString());
			String vYear = params.get("v_Year").toString();
			String vCode = params.get("vCode").toString();
			String desc = params.get("desc").toString();
			//Date create_time = tempDate.parse(params.get("create_time").toString());
			
			
			VersionPo vsPo = new VersionPo();
			vsPo.setId(id);
			vsPo.setState(0);
			vsPo.setIsEnable(0);
			vsPo.setvYear(vYear);
			vsPo.setvCode(vCode);
			vsPo.setDesc(desc);
			vsPo.setCreateTime(new Date());
			vsPo.setUpdateTime(new Date());
			vsPo.setIsDelete(0);
			vsPo.setVersionId(versionId);
			
			Boolean isSuccess = versionManager.saveVersion(vsPo);
			LOGGER.info("添加是否成功==="+isSuccess);
		}
		return mav;
	}
	
	
	/**
	 * 编辑版本管理
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView editVersion(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("进入跳转编辑版本管理页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/version/editVersion");
		String type = request.getParameter("type");
		
		if("update".equals(type)){
			Map<String, Object> params = ParamUtil.getJsonParams();
			Long id = Long.parseLong(params.get("versionId").toString());
			String desc = params.get("desc").toString();
			versionManager.updateVersionDesc(id, desc);
			
		}else if("search".equals(type) || "change".equals(type)){
			String id = request.getParameter("id");
		    VersionPo versionPo = versionManager.getVersionById(Long.valueOf(id));
		    mav.addObject("version", versionPo);
		}
		mav.addObject("openType", type);
		return mav;
	}
	
	
	/**
	 * 获取版本管理信息
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	public ModelAndView listVersions(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		LOGGER.info("进入跳转获取版本管理信息页面....");
		ModelAndView mav = new ModelAndView("apps/xd24zfz/version/versionList");
		
		return mav;
	}
	
}
