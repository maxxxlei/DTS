package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24ZzjhlxManger {

	/**
	 * 获取组织计划类型列表
	 * @param fi
	 * @param map
	 * @return
	 */
	public FlipInfo getZzjhList(FlipInfo fi, Map<String, Object> map) throws BusinessException;

	void saveZzjhlx(Map<String, String> zzjhlx) throws BusinessException;

	public ZzjhlxVo getZzjhlxById(String id)throws BusinessException;

	public boolean checkZzjhlxByName(String id, String name)throws BusinessException;
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	public String deleteZzjhlx(String[] ids) throws BusinessException;
	
}
