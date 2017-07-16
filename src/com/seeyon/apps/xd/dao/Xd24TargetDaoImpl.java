package com.seeyon.apps.xd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24TargetDaoImpl implements Xd24TargetDao {

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getTargetList(FlipInfo flipInfo, Map<String, String> params)
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

	@Override
	public List<Object[]> getTargetList(FlipInfo flipInfo, Map<String, String> map,
			String key, String value) throws BusinessException {
		LOGGER.info("根据搜索框中的条件进行查询=================");
		Map<String,Object> params = new HashMap<String,Object>();
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuffer hql = new StringBuffer("select t.id,t.subject,t.createTime,t.effectTime,t.memberId,t.startTime,");
		hql.append("t.endTime from TargetPo t where ");
		if("subject".equals(key)){
			hql.append(" t.subject =:subject");
			params.put("subject", value);
		}else if("memberId".equals(key)){
			hql.append(" t.memberId =:memberId");
			params.put("memberId", value);
		}
//		else if(){
//			hql
//		}
//		b.append("FROM DemoUserPO where ");
//		b.append(key);
//		b.append(" like :value1");
		list = DBAgent.find(hql.toString(),params, flipInfo);
		return null;
	}

}
