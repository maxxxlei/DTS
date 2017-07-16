package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24ZzjhlxDao {

	/**
	 * 查询当前数据中的所有用户
	 * @param fi
	 * @param map
	 * @return
	 */
	public FlipInfo getUser(FlipInfo fi, Map<String, Object> map);
	
	/**
	 * 模糊查询当前数据中的用户
	 * @param fi
	 * @param map
	 * @return
	 */
	public List find(FlipInfo fi, Map<String, Object> map,String key,String value);

	/**
	 * 保存组织计划
	 * @param po
	 */
	public void saveZzjhlx(ZzjhlxPo po);
	/**
	 * 通过id查询组织计划
	 * @param id
	 * @return
	 */
	public List getZzjhlxById(String id);

	/**
	 * 
	 * 通过id和name属性查询是否有相同的name属性和是否是自己本身查询组织计划
	 * @param id
	 * @param name
	 * @return
	 */
	public List getNameAndId(String id, String name);


}
