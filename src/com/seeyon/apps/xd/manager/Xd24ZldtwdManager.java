package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.apps.xd.vo.ZldtwdVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
/**
 * 战略地图维护
 * @author zhaifeng
 *
 */
public interface Xd24ZldtwdManager {
	/**
	 * 查询战略维度
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
	
	/**
	 * 保存战略维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void saveZldtwd(Map<String, String> zldtwd) throws BusinessException;
	
	/**
	 * 修改战略维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void updateZldtwd(Map<String, String> zldtwd) throws BusinessException;
	
	/**
	 * 删除战略维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void deleteZldtwd(String[] ids) throws BusinessException;
	
	/**
	 * 根据主键，获取战略地图维度信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public ZldtwdVo getZldtwdById(String id) throws BusinessException;
	
	/**
	 * 新建用户或者修改用户时，先查询是否有名称重复
	 * @param name
	 * @param id
	 * @param isNew
	 * @return
	 * @throws BusinessException
	 */
	public boolean getSumZldtwName(String name,String id,boolean isNew) throws BusinessException;
}
