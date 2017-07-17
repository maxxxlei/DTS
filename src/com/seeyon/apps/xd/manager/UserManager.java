package com.seeyon.apps.xd.manager;

import com.seeyon.apps.xd.vo.UserVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
/**
 * 获取鑫达组织架构中单位、中心、部门、组、人员信息、岗位
 * @author heliang.wang
 *
 * @time 2017年7月17日
 */
public interface UserManager {
	/**
	 * 获取鑫达组织架构中单位、中心、部门、组、人员信息、岗位
	 * @param memberId
	 * @return
	 * @throws BusinessException
	 */
	public UserVo getUserInfo(Long memberId) throws BusinessException;
}
