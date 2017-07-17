package com.seeyon.apps.xd.manager;

import java.util.Date;
import java.util.Map;

import com.seeyon.apps.xd.dao.Xd24QuotaDao;
import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24QuotaManagerImpl implements Xd24QuotaManager {
	private Xd24QuotaDao xd24QuotaDao;
	
	

	public void setXd24QuotaDao(Xd24QuotaDao xd24QuotaDao) {
		this.xd24QuotaDao = xd24QuotaDao;
	}


	@Override
	public FlipInfo getQuotaList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		flipInfo = xd24QuotaDao.getQuotaList(flipInfo, query);
		return flipInfo;
	}

	@AjaxAccess
	public Boolean saveQuotaPo(QuotaPo po) throws BusinessException{
		
		return xd24QuotaDao.saveQuotaPo(po);
	}


	@Override
	public int updateQuota(Map<String, String> quotal) throws BusinessException {
		return xd24QuotaDao.updateQuota(quotal);
	}


	@Override
	public void deleteQuota(String[] idQuota) throws BusinessException {
		
	}


	
	
	


}
