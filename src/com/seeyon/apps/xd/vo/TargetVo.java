package com.seeyon.apps.xd.vo;

import org.apache.log4j.Logger;

import com.seeyon.ctp.menu.check.AbstractMenuCheck;
/**
 * 战略规划 菜单校验类
 * @author heliang.wang
 *
 * @time 2017年7月13日
 */
public class TargetVo extends AbstractMenuCheck{

	private static final Logger LOGGER = Logger.getLogger(TargetVo.class);

	@Override
	public boolean check(long memberId, long loginAccountId) {
//		String dbId = AppContext.getSystemProperty("trlaobao.laobaoAdmin");
//		long dbMemberId = Long.parseLong(dbId);
//		if(memberId == dbMemberId){
//			LOGGER.info("劳保信息列表：" + memberId);
//			return true;
//		}
		return true;
	}
	
}
