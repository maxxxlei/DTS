package com.seeyon.apps.xd.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24TargetDaoImpl implements Xd24TargetDao {

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetDaoImpl.class);
	
	@Override
	public FlipInfo getTargetList(FlipInfo flipInfo, Map<String, String> query)
			throws BusinessException {
		LOGGER.info("==========进入获取目标列表方法getTargetList==========");
		String hql = " from TargetPo";
		List<TargetPo> dataList = DBAgent.find(hql);
		LOGGER.info("查询到的结果条数："+dataList.size());
		flipInfo.setData(dataList);
		return flipInfo;
	}

}
