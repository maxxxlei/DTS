package com.seeyon.apps.xd.manager;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.FileInfo;

import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.apps.xd.vo.VersionVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;
/**
 * 版本管理
 * @author 刘伟敏
 *
 */
public interface VersionManger {
	
	/**
	 * 新增版本信息
	 */
	public Boolean saveVersion(VersionPo vsPo) throws BusinessException;
	
	/**
	 * 查询版本信息
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	public FlipInfo  getVersion(FlipInfo fi,Map<String, Object> param) throws BusinessException;

}
