package com.seeyon.apps.xd.dao;

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
	
	
	public String updateVersions(String[] id,String type) throws BusinessException;
	
	/**
	 * 搜索框查询
	 * @param fi
	 * @param map
	 * @param key
	 * @param value
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getVersionByCondition(FlipInfo fi,Map<String, Object> map,String key,String value) throws BusinessException;

	/**
	 * 根据年度和版本编号判断数据是否重复
	 * @param vYear   年度
	 * @param vCode   版本编号
	 * @return
	 * @throws BusinessException
	 */
	public Integer getVersionByYearAndCode(String vYear,String vCode) throws BusinessException;
	/**
	 * 根据id获取修改页面展示数据
	 */
	public VersionPo getVersionById(Long id)throws BusinessException;
	
	public String updateVersionDesc(Long id,String desc) throws BusinessException;
}
