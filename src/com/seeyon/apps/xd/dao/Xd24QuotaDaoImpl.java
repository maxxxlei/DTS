package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24QuotaDaoImpl implements Xd24QuotaDao {

	private Logger LOGGER = Logger.getLogger(Xd24QuotaDaoImpl.class);
	@Override
	public FlipInfo getQuotaList(FlipInfo fi,Map<String, Object> map)
			throws BusinessException {
		
		String hql="SELECT a.id,a.quotaCode,a.quotaName,a.quotaUnit,a.quotaType,a.create_Time,a.update_Time FROM QuotaPo a";
//		map.put("quotaName", po.getQuotaName());
		//hql.append("order by a.update_Time desc");
//		String hql = "select a.quotaCode,a.quotaName,a.quotaUnit,a.quotaType from QuotaPo a where a.quotaName order by a.quotaCode desc";
		
	DBAgent.find(hql, map, fi);
	return fi;
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
