package com.seeyon.apps.xd.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.util.Strings;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.DateUtil;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.SQLWildcardUtil;

public class Xd24ZzjhlxDaoImpl implements Xd24ZzjhlxDao{
	private static Log log=LogFactory.getLog(Xd24ZzjhlxDaoImpl.class);
	
	
	@Override
	public FlipInfo getZzjhList(FlipInfo fi, Map<String, Object> map) throws BusinessException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb.append("select z.id,z.name,z.isEnable,z.updateTime,z.createTime FROM ZzjhlxPo z where 1=1 and z.isDelete=:isDelete and z.state=:vstate");
		params.put("isDelete", );
		if(map != null && map.get("condition") != null){
			String condition = (String) map.get("condition");
			String value = (String) map.get("value");
			if("name".equals(condition) && Strings.isNotBlank(value)){
				sb.append(" and z.name like :name");
				params.put("name", "%"+SQLWildcardUtil.escape(value) +"%");
			}
			if("isEnable".equals(condition) && Strings.isNotBlank(value)){
				sb.append(" and z.isEnable=:isEnable");
				params.put("isEnable", Integer.parseInt(value));
			}
			if("startTime".equals(condition)){
				try {
				String[] times = value.split("#");
				if(Strings.isNotBlank(times[0])){
					Date startDate = DateUtil.parse(times[0], DateUtil.YEAR_MONTH_DAY_PATTERN);
					sb.append(" and z.createTime >=:createTime");
					params.put("createTime", startDate);
				}
				if(times.length > 1 && Strings.isNotBlank(times[1])){
					Date endDate = DateUtil.parse(times[1], DateUtil.YEAR_MONTH_DAY_PATTERN);
					sb.append(" and z.createTime <=:endDate");
					params.put("endDate", endDate);
				}
				} catch (ParseException e) {
					e.printStackTrace();
					log.error(e.getMessage());
					throw new BusinessException(e);
				}
			}
		}
		//String sql="select z.id,z.name,z.isEnable,z.updateTime,z.createTime FROM ZzjhlxPo z order by z.updateTime desc";
		sb.append(" order by z.updateTime desc");
		DBAgent.find(sb.toString(), params, fi);
		return fi;
	}

	@Override
	public List find(FlipInfo fi, Map<String, Object> map, String key,
			String value) {
		Map<String,Object> params = new HashMap<String,Object>();
		List list=new ArrayList();
		String rr=value;
		params.put("value1", "%"+value+"%");
		StringBuffer b=new StringBuffer();
		b.append("FROM ZzjhlxPo where ");
		b.append(key);
		b.append(" like :value1");
		System.out.println(b.toString());
		list=DBAgent.find(b.toString(),params, fi);
		return list;
		
	}
/**
 * 保存新建的组织计划类型
 */
	@Override
	public void saveZzjhlx(ZzjhlxPo po) {
		DBAgent.save(po);
	}

	/**
	 * 通过id查询组织计划
	 */
	@Override
	public ZzjhlxPo getZzjhlxById(Long id) {
		return DBAgent.get(ZzjhlxPo.class, id);
						
	}

	@Override
	public List getZzjhlxByName(String name) {
		String hql = "select z.id, z.name FROM ZzjhlxPo z where z.name=:name";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", String.valueOf(name));
		List find = DBAgent.find(hql,params);
		return find;
	}

	@Override
	public ZzjhlxPo getZzjhlxPoById(Long id) throws BusinessException {
		ZzjhlxPo ZzjhlxPo = DBAgent.get(ZzjhlxPo.class, id);
		return ZzjhlxPo;
	}

	@Override
	public void updateZzjhlx(ZzjhlxPo zzjhlxPo) {
		DBAgent.update(zzjhlxPo);
	}

	@Override
	public List getStartTime(FlipInfo fi, Map<String, Object> map,String value) throws ParseException {
		String[] split = value.split("#");
		String st = split[0];
		String et = split[1];
		String hql = "select z.id, z.name,z.createTime FROM ZzjhlxPo z where z.createTime>:startTime and z.createTime<:endTime ";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("startTime",DateUtil.parse(st) );
		params.put("endTime", DateUtil.parse(et));
		List find = DBAgent.find(hql,params);
		return find;
	}

	@Override
	public List getisEnable(FlipInfo fi, String value) {
		String hql = "select z.id, z.name,z.createTime,z.isEnable FROM ZzjhlxPo z where z.isEnable=:isEnable";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isEnable", Integer.valueOf(value));
		List find = DBAgent.find(hql,params);
		return find;
	}


	
	

	
}
