package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24ZldtwdDaoImpl implements Xd24ZldtwdDao {
	
	@Override
	public List getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException {
		String hql ="select a.id, a.name,a.isEnable,a.description from ZldtwdPo a";
		return DBAgent.find(hql, query, flipInfo);
	}
	
	@Override
	public void saveZldtwd(ZldtwdPo po) throws BusinessException {
		DBAgent.save(po);
	}
}
