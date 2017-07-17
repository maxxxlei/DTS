package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.dao.Xd24TargetDao;
import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.apps.xd.vo.TargetVo;
import com.seeyon.ctp.common.AppContext;
import com.seeyon.ctp.common.authenticate.domain.User;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.organization.bo.V3xOrgMember;
import com.seeyon.ctp.organization.manager.OrgManager;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24TargetManagerImpl implements Xd24TargetManager{

	private static final Logger LOGGER = Logger.getLogger(Xd24TargetManagerImpl.class);
	private Xd24TargetDao xd24TargetDao;
	private OrgManager orgManager;
	
	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}
	public void setXd24TargetDao(Xd24TargetDao xd24TargetDao) {
		this.xd24TargetDao = xd24TargetDao;
	}

	@AjaxAccess
	@Override
	public FlipInfo getTargetList(FlipInfo flipInfo, Map<String, String> params)
			throws BusinessException {
		LOGGER.info("进入查询目标列表方法============");
		List<TargetVo> tvList = new ArrayList<TargetVo>();
		//获取搜索框中的值
		String key = (String) params.get("condition");
		String value = (String) params.get("value");
		List<Object[]> targetList = new ArrayList<Object[]>();
		if(Strings.isNotBlank(key)){
			//搜索框条件查询
			targetList = xd24TargetDao.getTargetList(flipInfo, params, key, value);
			if(targetList.size() > 0){
				for(Object[] o : targetList){
					TargetVo target = new TargetVo();
					target.setId(Long.valueOf(o[0].toString()));
					target.setSubject(o[1].toString());
					Timestamp ts = (Timestamp) o[2];
					target.setCreateTime(new Date(ts.getTime()));
					ts = (Timestamp) o[3];
					target.setEffectTime(new Date(ts.getTime()));
					Long memberId = Long.valueOf(o[4].toString());
					V3xOrgMember member = orgManager.getMemberById(memberId);
					target.setMemberName(member.getName());
					ts = (Timestamp) o[5];
					target.setStartTime(new Date(ts.getTime()));
					ts = (Timestamp) o[6];
					target.setEndTime(new Date(ts.getTime()));
					tvList.add(target);
				}
				LOGGER.info("搜索框条件查询返回结果个数==============="+tvList.size());
				flipInfo.setData(tvList);
			}
		}else{
			//默认查询
			targetList = xd24TargetDao.getTargetList(flipInfo, params);
			if(targetList.size() > 0){
				for(Object[] o : targetList){
					TargetVo target = new TargetVo();
					target.setId(Long.valueOf(o[0].toString()));
					target.setSubject(o[1].toString());
					Timestamp ts = (Timestamp) o[2];
					target.setCreateTime(new Date(ts.getTime()));
					ts = (Timestamp) o[3];
					target.setEffectTime(new Date(ts.getTime()));
					Long memberId = Long.valueOf(o[4].toString());
					V3xOrgMember member = orgManager.getMemberById(memberId);
					target.setMemberName(member.getName());
					ts = (Timestamp) o[5];
					target.setStartTime(new Date(ts.getTime()));
					ts = (Timestamp) o[6];
					target.setEndTime(new Date(ts.getTime()));
					tvList.add(target);
				}
			}
			LOGGER.info("默认查询返回结果个数==============="+tvList.size());
			flipInfo.setData(tvList);
		}
		return flipInfo;
	}

	@Override
	public void saveTarget(Object entity) throws BusinessException {
		xd24TargetDao.saveTarget(entity);
		
	}
	@AjaxAccess
	@Override
	public String deleteTargets(String[] ids) throws BusinessException {
		LOGGER.info("进入批量删除目标方法====");
		if(ids.length > 0){
			for(int i = 0;i<ids.length;i++){
				TargetPo targetPo = xd24TargetDao.getTargetPoById(Long.valueOf(ids[i].toString()));
				targetPo.setIsDelete(Integer.valueOf(Xd24Enum.IsDelete.DELETE_Y.getKey()));
				xd24TargetDao.updateTarget(targetPo);
			}
			LOGGER.info("共删除目标 "+ids.length+" 条记录");
			return "SUCCESS";
		}else{
			return "FALSE";
		}
	}

}
