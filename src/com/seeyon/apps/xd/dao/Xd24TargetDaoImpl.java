package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24TargetDaoImpl implements Xd24TargetDao {

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetDaoImpl.class);
	
	@Override
	public List getTargetList(FlipInfo flipInfo, Map<String, String> params)
			throws BusinessException {
		LOGGER.info("==========进入获取目标列表方法getTargetList==========");
		StringBuffer hql = new StringBuffer("select t.id,t.subject,t.createTime,t.effectTime,t.memberId,t.startTime,");
		hql.append("t.endTime from TargetPo t order by t.createTime desc");
		return DBAgent.find(hql.toString(), params, flipInfo);
	}

	@Override
	public void saveTarget(TargetPo tp) throws BusinessException {
		
		DBAgent.save(tp);
	}

}
