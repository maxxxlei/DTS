package com.seeyon.apps.xd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import com.seeyon.apps.xd.constants.Xd24Enum;
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
		hql.append("t.endTime from TargetPo t where ");
		hql.append("t.isDelete = '").append(Xd24Enum.Target.DELETE_N.getKey());
		hql.append("' order by t.createTime desc");
		return DBAgent.find(hql.toString(), params, flipInfo);
	}

	@Override
	public void saveTarget(Object entity) throws BusinessException {
		
		DBAgent.save(entity);
	}

	@Override
	public List<Object[]> getTargetList(FlipInfo flipInfo, Map<String, String> map,
			String key, String value) throws BusinessException {
		LOGGER.info("根据搜索框中的条件进行查询=================");
		Map<String,Object> params = new HashMap<String,Object>();
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuffer hql = new StringBuffer("select t.id,t.subject,t.createTime,t.effectTime,t.memberId,t.startTime,");
		hql.append("t.endTime from TargetPo t where t.isDelete =:isDelete");
		params.put("isDelete", Xd24Enum.Target.DELETE_N.getKey());
		if("subject".equals(key)){
			hql.append(" and t.subject =:subject");
			params.put("subject", value);
		}else if("memberId".equals(key)){
			hql.append(" and t.memberId =:memberId");
			params.put("memberId", value);
		}else if("startTime".equals(key)){
			String[] time = value.split("#");
			if(Strings.isNotBlank(time[0])){
				hql.append(" and t.startTiem >=:startTiem");
				params.put("startTiem", time[0]);
			}
			if(Strings.isNotBlank(time[1])){
				hql.append(" and t.startTiem <=:endTiem");
				params.put("endTiem", time[1]);
			}
		}else if("endTime".equals(key)){
			String[] time = value.split("#");
			if(Strings.isNotBlank(time[0])){
				hql.append(" and t.endTime >=:startTime");
				params.put("startTiem", time[0]);
			}
			if(Strings.isNotBlank(time[1])){
				hql.append(" and t.endTime <=:endTime");
				params.put("endTime", time[1]);
			}
		}
		hql.append(" order by t.createTime desc");
		list = DBAgent.find(hql.toString(),params, flipInfo);
		return list;
	}

	@Override
	public void updateTarget(TargetPo targetPo) throws BusinessException {
		DBAgent.update(targetPo);
	}

	@Override
	public TargetPo getTargetPoById(Long id) throws BusinessException {
		TargetPo targetPo = DBAgent.get(TargetPo.class, id);
		return targetPo;
	}

}
