package com.seeyon.apps.xd.manager;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.apps.xd.vo.QuotaVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;


public interface Xd24QuotaManager {
	/**
	 * 查询指标库列表
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getQuotaList(FlipInfo fi,Map<String, Object> map) throws BusinessException;
	/**
	 * 
	 *添加指标库数据
	 * @param quota
	 * @return
	 * @throws BusinessException
	 */
	public Boolean saveQuotaPo(QuotaPo po) throws BusinessException;

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
	 * @throws BusinessException
	 */
	public void deleteQuota(String[] idQuota) throws BusinessException;

}
