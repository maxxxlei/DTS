package com.seeyon.apps.xd.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.AppContext;
import com.seeyon.ctp.common.authenticate.domain.User;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.DateUtil;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.SQLWildcardUtil;

public class Xd24TargetDaoImpl implements Xd24TargetDao {

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getTargetList(FlipInfo flipInfo, Map<String, String> params)
			throws BusinessException {
		LOGGER.info("==========进入获取目标列表方法getTargetList==========");
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("select t.id,t.subject,t.createTime,t.effectTime,t.memberId,t.startTime,");
		hql.append("t.endTime from TargetPo t where ");
		hql.append("t.isDelete =:isDelete and t.memberId =:memberId order by t.createTime desc");
		map.put("isDelete", Integer.valueOf(Xd24Enum.Target.DELETE_N.getKey()));
		User user = AppContext.getCurrentUser();
		map.put("memberId", user.getId());
		return DBAgent.find(hql.toString(), map, flipInfo);
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
		params.put("isDelete", Integer.valueOf(Xd24Enum.Target.DELETE_N.getKey()));
		try {
			if("subject".equals(key) && Strings.isNotBlank(value)){
				hql.append(" and t.subject like :subject");
				params.put("subject", SQLWildcardUtil.escape(value));
			}else if("memberId".equals(key) && Strings.isNotBlank(value)){
				hql.append(" and t.memberId =:memberId");
				params.put("memberId", Long.valueOf(value.substring(7)));
			}else if("startTime".equals(key) && Strings.isNotBlank(value)){
				//一、时间以#开头，证明没有form_startTime
				boolean hb = value.startsWith("#");
				//二、时间以#结尾，证明没有to_startTime
				boolean fb = value.endsWith("#");
				String[] time = value.split("#");
				if(hb){
					String sd = time[0];
					if(Strings.isNotBlank(sd)){
						Date d1 = DateUtil.parse(sd);
						hql.append(" and t.startTime <=:endTime");
						params.put("endTime", d1);
					}
				}else if(fb){
					String ed = time[0];
					if(Strings.isNotBlank(ed)){
						hql.append(" and t.startTime >=:startTime");
						Date d2 = DateUtil.parse(ed);
						params.put("startTime", d2);
					}
				}else{
					//三、两个时间段都存在值
					String st = time[0];
					String ft = time[1];
					if(Strings.isNotBlank(st) && Strings.isNotBlank(ft)){
						hql.append(" and t.startTime >=:startTime and t.startTime <=:endTime");
						params.put("startTime", DateUtil.parse(st));
						params.put("endTime", DateUtil.parse(ft));
					}
				}
			}else if("endTime".equals(key)){
				boolean hb = value.startsWith("#");
				boolean fb = value.endsWith("#");
				String[] time = value.split("#");
				if(hb){
					String sd = time[0];
					if(Strings.isNotBlank(sd)){
						Date d1 = DateUtil.parse(sd);
						hql.append(" and t.endTime <=:endTime");
						params.put("endTime", d1);
					}
				}else if(fb){
					String ed = time[0];
					if(Strings.isNotBlank(ed)){
						hql.append(" and t.endTime >=:startTime");
						Date d2 = DateUtil.parse(ed);
						params.put("startTime", d2);
					}
				}else{
					//三、两个时间段都存在值
					String st = time[0];
					String ft = time[1];
					if(Strings.isNotBlank(st) && Strings.isNotBlank(ft)){
						hql.append(" and t.endTime >=:startTime and t.endTime <=:endTime");
						params.put("startTime", DateUtil.parse(st));
						params.put("endTime", DateUtil.parse(ft));
					}
				}
			}
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
			throw new BusinessException(e);
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
