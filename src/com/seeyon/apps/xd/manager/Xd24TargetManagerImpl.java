package com.seeyon.apps.xd.manager;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.dao.Xd24TargetDao;
import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24TargetManagerImpl implements Xd24TargetManager{

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetManagerImpl.class);
	private Xd24TargetDao xd24TargetDao;
	
	public void setXd24TargetDao(Xd24TargetDao xd24TargetDao) {
		this.xd24TargetDao = xd24TargetDao;
	}

	@AjaxAccess
	@Override
	public List getTargetList(FlipInfo flipInfo, Map<String, String> params)
			throws BusinessException {
		LOGGER.info("进入查询目标列表方法============");
		List targetList = xd24TargetDao.getTargetList(flipInfo, params);
		LOGGER.info("查询返回结果==============="+targetList);
		return targetList;
	}

	@Override
	public void saveTarget(TargetPo tp) throws BusinessException {
		xd24TargetDao.saveTarget(tp);
		
	}

}
