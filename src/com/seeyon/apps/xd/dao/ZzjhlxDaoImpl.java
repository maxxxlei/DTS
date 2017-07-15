package com.seeyon.apps.xd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class ZzjhlxDaoImpl implements ZzjhlxDao{
	private static Log log=LogFactory.getLog(ZzjhlxDaoImpl.class);
	
	
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
	
}
