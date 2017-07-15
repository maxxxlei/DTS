package com.seeyon.apps.xd.dao;

import java.util.Map;

import org.h2.engine.Session;

import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;


public interface Xd24QuotaDao {
	
	/**
	 * 查询指标库列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getQuotaList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
	/**
	 * 添加指标库数据
	 * @param quota
	 * @return
	 * @throws BusinessException
	 */
	public int saveQuota(Map<String, String> quota) throws BusinessException;
	/**
	 * 修改指标库数据
	 * @param quotal
	 * @return
	 * @throws BusinessException
	 */
	public int updateQuota(Map<String, String> quotal) throws BusinessException;
	/**
	 * 删除指标库数据
	 * @param idQuota
	 * @return
	 * @throws BusinessException
	 */
	public void deleteQuota(String[]  idQuota) throws BusinessException;
	
	
}
