package com.seeyon.apps.xd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24ZzjhlxDaoImpl implements Xd24ZzjhlxDao{
	private static Log log=LogFactory.getLog(Xd24ZzjhlxDaoImpl.class);
	
	
	@Override
	public FlipInfo getUser(FlipInfo fi, Map<String, Object> map) {
		Map<String,Object> params = new HashMap<String,Object>();
		List<ZzjhlxPo> list=new ArrayList<ZzjhlxPo>();
		String sql="select z.id,z.name,z.isEnable,z.updateTime,z.createTime FROM ZzjhlxPo z order by z.updateTime desc";
		DBAgent.find(sql, params, fi);
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
public List getZzjhlxById(String id) {
	String hql = "select z.id,z.name,z.isEnable,z.createTime,z.desc FROM ZzjhlxPo z where z.id=:id";
	Map<String,Object> params = new HashMap<String,Object>();
	params.put("id", Long.valueOf(id));
	return DBAgent.find(hql,params);
					
}

	@Override
	public List getNameAndId(String id, String name) {
		String hql = "select z.id, z.name FROM ZzjhlxPo z where z.name=:name";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", String.valueOf(name));
		List find = DBAgent.find(hql,params);
		return find;
	}



	
}
