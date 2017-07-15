package com.seeyon.apps.xd.manager;

import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.dao.Xd24TargetDao;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24TargetManagerImpl implements Xd24TargetManger{

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetManagerImpl.class);
	private Xd24TargetDao xd24Target;
	
	public void setXd24Target(Xd24TargetDao xd24Target) {
		this.xd24Target = xd24Target;
	}

	@AjaxAccess
	@Override
	public FlipInfo getTargetList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		
		return xd24Target.getTargetList(flipInfo, query);
	}

}
