package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface VersionDao {
	
	/**
	 * 新增版本信息
	 * @param versionPo  
	 * @return
	 */
	public Boolean saveVersion(VersionPo versionPo) throws BusinessException;
	
	
	public FlipInfo getVersion(FlipInfo fi,Map<String, Object> map) throws BusinessException;

}
