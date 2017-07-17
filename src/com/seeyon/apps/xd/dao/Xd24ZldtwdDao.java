package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24ZldtwdDao {
	/**
	 * 查询战略地图维度列表页面
	 * @param flipInfo
	 * @param query
	 * @return
	 * @throws BusinessException
	 */
	public List getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException;
	
	/**
	 * 保存战略地图维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void saveZldtwd(ZldtwdPo po) throws BusinessException;
	
	/**
	 * 修改战略地图维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void updateZldtwd(ZldtwdPo po) throws BusinessException;
	
	/**
	 * 删除战略地图维度
	 * @param zldtwd
	 * @throws BusinessException
	 */
	public void deleteZldtwd(String[] ids) throws BusinessException;
	
	/**
	 * 通过主键检索战略地图维度信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public List getZldtwdById(long id) throws BusinessException;
	
	/**
	 * 新建用户或者修改用户时，先查询是否有名称重复
	 * @param name
	 * @param id
	 * @param isNew
	 * @return
	 * @throws BusinessException
	 */
	public boolean getSumZldtwName(String name,String id,boolean isNew) throws BusinessException;
	/**
	 * 获取所有战略地图维度
	 * @return
	 * @throws BusinessException
	 */
	public List<ZldtwdPo> getZldtwdList4Enum() throws BusinessException;
}
