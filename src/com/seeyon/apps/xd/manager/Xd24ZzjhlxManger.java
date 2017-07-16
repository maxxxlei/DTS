package com.seeyon.apps.xd.manager;

import java.util.Map;

import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;

public interface Xd24ZzjhlxManger {

	public FlipInfo getUser(FlipInfo fi, Map<String, Object> map);

	void saveZzjhlx(Map<String, String> zzjhlx) throws BusinessException;

	public ZzjhlxVo getZzjhlxById(String id);

	Boolean getNameAndId(String id, String name);
}
