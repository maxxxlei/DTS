package com.seeyon.apps.xd.dao;

import java.util.Map;

import org.apache.log4j.Logger;
import org.h2.engine.Session;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24QuotaDaoImpl implements Xd24QuotaDao {

	private Logger LOGGER = Logger.getLogger(Xd24QuotaDaoImpl.class);
	@Override
	public FlipInfo getQuotaList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		String hql = "select a.quotaCode,a.quotaName,a.quotaUnit,a.quotaType from QuotaPo a where a.quotaName order by a.quotaCode desc";
		DBAgent.find(hql, query, flipInfo);
		return flipInfo;
	}

	@Override//保存
	public Boolean saveQuotaPo(QuotaPo po) throws BusinessException{
	   Object  obj = DBAgent.save(po);
	   LOGGER.info("obj==="+obj);
	   if(obj != null){
		   return true;
	   }
	   return false;
	}

	@Override
	public int updateQuota(Map<String, String> quotal) throws BusinessException {
		return 0;
	}

	@Override
	public void deleteQuota(String[] idQuota) throws BusinessException {
		// TODO Auto-generated method stub
		
	}



}
