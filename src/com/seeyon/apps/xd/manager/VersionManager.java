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
public interface VersionManager {
	
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

	
	public String updateVersions(String[] ids,String type) throws BusinessException;
	/**
	 * 根据条件判断数据是否重复
	 * @param vYear
	 * @param vCode
	 * @return
	 * @throws BusinessException
	 */
	public Boolean getVersionByVcodeAndVyear(String vYear,String vCode) throws BusinessException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public VersionPo getVersionById(Long id)throws BusinessException;
	
	/**
	 * 修改版本信息
	 * @param id   版本信息id
	 * @param desc   版本信息描述
	 * @return
	 * @throws BusinessException
	 */
	public String updateVersionDesc(Long id,String desc) throws BusinessException;
}
