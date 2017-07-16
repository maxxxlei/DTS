package com.seeyon.apps.xd.manager;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.seeyon.apps.xd.dao.Xd24ZldtwdDao;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;
/**
 * 战略地图维护
 * @author zhaifeng
 *
 */
public class Xd24ZldtwdManagerImpl implements Xd24ZldtwdManager {
	private Xd24ZldtwdDao xd24ZldtwdDao;
	
	
	public void setXd24ZldtwdDao(Xd24ZldtwdDao xd24ZldtwdDao) {
		this.xd24ZldtwdDao = xd24ZldtwdDao;
	}

	@Override
	@AjaxAccess
	public List getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException {
		return xd24ZldtwdDao.getZldtwdList(flipInfo, query);
	}
	
	@Override
	@AjaxAccess
	public void saveZldtwd(Map<String, String> zldtwd) throws BusinessException {
		ZldtwdPo po = new ZldtwdPo();
		po.setIdIfNew();
		po.setName(zldtwd.get("name"));
		String isEnable = zldtwd.get("isEnable");
		po.setIsEnable(Integer.valueOf(isEnable));
		po.setVerState(1);
		po.setCreateTime(new Date());
		po.setUpdateTime(new Date());
		po.setIsDelete(0);
		// TODO 版本号需要调接口查询
		po.setVersionId(123l);
		po.setDescription("描述");
		xd24ZldtwdDao.saveZldtwd(po);
	}
}
