package com.seeyon.apps.xd.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.JDBCAgent;

public class VersionDaoImpl  implements VersionDao {

	private Logger LOGGER = Logger.getLogger(VersionDaoImpl.class);
	/**
	 * 新增
	 */
	@Override
	public Boolean saveVersion(VersionPo versionPo) throws BusinessException{
	   Object  obj = DBAgent.save(versionPo);
	   LOGGER.info("obj==="+obj);
	   if(obj != null){
		   return true;
	   }
	   
	   return false;
	}
	/**
	 * 查询所有
	 */
	@Override
	public FlipInfo getVersion(FlipInfo fi,Map<String, Object> map) throws BusinessException {
		String hql = "select v.id as ID,v.vCode as CODE,v.vYear as YEAR,v.createTime as CREATETIME,v.isEnable as ISENABLE,v.state as STATE from VersionPo v order by v.updateTime desc";
		LOGGER.info("查询版本信息hql===" + hql);
		 DBAgent.find(hql, map, fi);
		 return fi;
	}

}
