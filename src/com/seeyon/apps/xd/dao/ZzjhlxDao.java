package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import com.seeyon.ctp.util.FlipInfo;

public interface ZzjhlxDao {

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

}
