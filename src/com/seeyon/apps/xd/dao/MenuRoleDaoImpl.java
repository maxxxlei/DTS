package com.seeyon.apps.xd.dao;

import java.util.Map;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class MenuRoleDaoImpl implements MenuRoleDao {

	@Override
	public FlipInfo getMenuList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		StringBuffer hql = new StringBuffer();
		
		hql.append(" select p.name,p.resourceNavUrl,p.category,p.resourceCode,p.sortCode,p.createTime,p.updateTime,p.isEnable,p.menuLevel from MenuPo p ");
		hql.append(" where p.isDelete=0");
		DBAgent.find(hql.toString(), query, flipInfo);
		return flipInfo;
	}

}
