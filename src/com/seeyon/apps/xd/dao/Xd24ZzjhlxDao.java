package com.seeyon.apps.xd.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24ZzjhlxDao {

	
	
	/**
	 * 删除目标--实际为修改is_delete 的状态值
	 * @param targetPo
	 * @return
	 * @throws BusinessException
	 */
	public void updateZzjhlx(ZzjhlxPo zzjhlxPo) throws BusinessException;
	
	/**
	 * 查询组织计划列表
	 * @param fi
	 * @param map
	 * @return
	 */
	public FlipInfo getZzjhList(FlipInfo fi, Map<String, Object> map) throws BusinessException;
	
	/**
	 * 模糊查询当前数据中的用户
	 * @param fi
	 * @param map
	 * @return
	 */
	public List find(FlipInfo fi, Map<String, Object> map,String key,String value) throws BusinessException;

	/**
	 * 保存组织计划
	 * @param po
	 */
	public void saveZzjhlx(ZzjhlxPo po) throws BusinessException;
	/**
	 * 通过id查询组织计划
	 * @param id
	 * @return
	 */
	public List getZzjhlxById(String id) throws BusinessException;

	/**
	 * 
	 * 通过id和name属性查询是否有相同的name属性和是否是自己本身查询组织计划
	 * @param id
	 * @param name
	 * @return
	 */
	public List getNameAndId(String id, String name)throws BusinessException;

	/**
	 * 根据ID获取对象
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public ZzjhlxPo getZzjhlxPoById(Long id) throws BusinessException;

	/**
	 * 根据时间获取对象集合
	 * @param fi
	 * @param map
	 * @param value 
	 * @return 
	 */
	public List getStartTime(FlipInfo fi, Map<String, Object> map, String value) throws ParseException;
	/**
	 * 根据启用状态查询
	 * @param fi
	 * @param map
	 * @param value
	 * @return
	 */
	public List getisEnable(FlipInfo fi, String value);




}
