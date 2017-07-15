package com.seeyon.apps.xd.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.apps.xd.dao.ZzjhlxDao;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class ZzjhlxMangerImpl extends BaseHibernateDao implements ZzjhlxManger{
	private static Log log=LogFactory.getLog(ZzjhlxMangerImpl.class);
	private ZzjhlxDao zzjhlxDao;

	public ZzjhlxDao getZzjhlxDao() {
		return zzjhlxDao;
	}

	public void setZzjhlxDao(ZzjhlxDao zzjhlxDao) {
		this.zzjhlxDao = zzjhlxDao;
	}

	
	
	/**
	 * 查询到的结果放到FlipInfo里,返回FlipInfo
	 */
	@AjaxAccess
	public FlipInfo selectUser(FlipInfo fi, Map<String, Object> map) {
		List list=new ArrayList();
		//fi.setSize(15);//设置默认显示条数
		String key=(String) map.get("condition");//取前台查询按钮中的选择项，取得值为conditions中的value属性值
		String value=(String) map.get("value");
		if(key!=null&&!key.equals("")){
		if(key.equals("createDate")){
			return null;
		}else{
			list=zzjhlxDao.find(fi, map, key, value);
				fi.setData(list);
		}
		}else{
			list=zzjhlxDao.getUser(fi, map);
			fi.setData(list);	
		}
		return fi;
	}
}
