package com.seeyon.apps.xd.dao;

import java.util.Map;

import org.h2.engine.Session;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24QuotaDaoImpl implements Xd24QuotaDao {


	@Override
	public FlipInfo getQuotaList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		String hql = "from QuotaPo ";
		DBAgent.find(hql, query, flipInfo);
		return flipInfo;
	}

	@Override
	public int saveQuota(Map<String, String> quota) throws BusinessException {
		return 0;
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
