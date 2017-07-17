package com.seeyon.apps.xd.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.DateUtil;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.sun.jna.platform.win32.WinDef.LONG;

public class VersionDaoImpl  implements VersionDao {

	private Logger LOGGER = Logger.getLogger(VersionDaoImpl.class);
	/**
	 * 新增
	 */
	@Override
	public Boolean saveVersion(VersionPo versionPo) throws BusinessException{
	   
	    Object  obj = DBAgent.save(versionPo);
	    LOGGER.info("obj==="+obj);
	    if(obj != null){
		    return true;
	    }
	    return false;
	}
	/**
	 * 查询所有
	 */
	@Override
	public FlipInfo getVersion(FlipInfo fi,Map<String, Object> map) throws BusinessException {
		String hql = "select v.id ,v.vCode ,v.vYear ,v.createTime ,v.isEnable ,v.state  from VersionPo v where v.isDelete = :isDelete order by v.updateTime desc";
		LOGGER.info("查询版本信息hql===" + hql);
		map.put("isDelete", 0);
		DBAgent.find(hql, map, fi);
		return fi;
	}
	/**
	 * 根据id删除相应的版本信息数据
	 */
	@Override
	public String updateVersions(String[] ids,String type) throws BusinessException {
		LOGGER.info("数据===" + ids);
		List<VersionPo> vspo = new ArrayList<VersionPo>();
		Map<String,Object> params = new HashMap<String,Object>();
		for(String id : ids){
			params.put("id", Long.parseLong(id));
			params.put("isDelete", 0);
			String hql ="FROM VersionPo where id =:id and isDelete =:isDelete";
            
			vspo.addAll(DBAgent.find(hql, params));
		}
		LOGGER.info("要删除的数据===" + vspo);
		for(VersionPo v:vspo){
			if("del".equals(type)){
				v.setIsDelete(1);
			}else if("enable".equals(type)){
				v.setIsEnable(1);
			}else if("disenable".equals(type)){
				v.setIsEnable(0);
			}
			v.setUpdateTime(new Date());
			DBAgent.update(v);	
		}
		return "SUCCESS";
	}
	/**
	 * 根据条件查询版本信息
	 */
	@Override
	public FlipInfo getVersionByCondition(FlipInfo fi, Map<String, Object> map,String key,String value)
			throws BusinessException {
		
		LOGGER.info("根据搜索框中的条件进行查询=================");
		Map<String,Object> params = new HashMap<String,Object>();
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuffer hql = new StringBuffer("select v.id ,v.vCode ,v.vYear ,v.createTime ,v.isEnable ,v.state  from VersionPo v ");
		hql.append("where v.isDelete =:isDelete");
		params.put("isDelete", 0);
		if("vCode".equals(key)){
			hql.append(" and v.vCode like :vCode");
			params.put("vCode", "%"+value+"%");
		}else if("createTime".equals(key)){
			try {
				//一、时间以#开头，证明没有form_startTime
				boolean hb = value.startsWith("#");
				//二、时间以#结尾，证明没有to_startTime
				boolean fb = value.endsWith("#");
				String[] time = value.split("#");
				if(hb){
					String sd = time[0];
					if(Strings.isNotBlank(sd)){
						Date d1 = DateUtil.parse(sd);
						hql.append(" and v.createTime <=:endTime");
						params.put("endTime", d1);
					}
				}else if(fb){
					String ed = time[0];
					if(Strings.isNotBlank(ed)){
						hql.append(" and v.createTime >=:startTime");
						Date d2 = DateUtil.parse(ed);
						params.put("startTime", d2);
					}
				}else{
					//三、两个时间段都存在值
					String st = time[0];
					String ft = time[1];
					if(Strings.isNotBlank(st) && Strings.isNotBlank(ft)){
						hql.append(" and v.createTime >=:startTime and v.createTime <=:endTime");
						params.put("startTime", DateUtil.parse(st));
						params.put("endTime", DateUtil.parse(ft));
					}
				}
			} catch (ParseException e) {
				
				e.printStackTrace();
				throw new BusinessException(e);
			}
		}
		hql.append(" order by v.updateTime desc");
		DBAgent.find(hql.toString(),params, fi);
		return fi;
	}
	
	
	
	public Integer getVersionCounts(Map<String, Object> params)
			throws BusinessException {
		
	    StringBuffer hql = new StringBuffer("select count(*) from VersionPo");
	    hql.append(" where isDelete =:isDelete");
	    if(params.size() == 1){
	    	hql.append(" and isEnable =:isEnable");
	    }else{
	    	hql.append(" and vYear =:vYear and vCode = :vCode");
	    }
	    params.put("isDelete", 0);
	    List list = DBAgent.find(hql.toString(),params);
	    
		LOGGER.info("hql==" + hql +";params" + params);
		return Integer.parseInt(list.get(0).toString());
	}
	
	public VersionPo getVersionById(Long id) throws BusinessException {
		return DBAgent.get(VersionPo.class, id);
	}
	
	@Override
	public String updateVersionDesc(Long id, String desc)
			throws BusinessException {

        VersionPo vspo = DBAgent.get(VersionPo.class, id);
		
		LOGGER.info("要修改的数据===" + vspo);
		vspo.setDesc(desc);
		vspo.setUpdateTime(new Date());
	    DBAgent.update(vspo);	
		
		return "SUCCESS";
	}
	
	@Override
	public Boolean getTargetCountByVersionId(String[] ids) throws BusinessException {
		Boolean exist = false;
		for (String id : ids) {
			Map<String,Object> params = new HashMap<String,Object>();
			StringBuffer hql = new StringBuffer("select count(*) from TargetPo");
		    hql.append(" where isDelete =:isDelete");
		    params.put("isDelete", 0);
		    hql.append(" and versionId = :versionId");
		    params.put("versionId", Long.valueOf(id));
		    
		    LOGGER.info("hql==" + hql +";params" + params);
		    List list = DBAgent.find(hql.toString(),params);
		    int isExist = Integer.parseInt(list.get(0).toString());
		    if(isExist > 0){
		    	exist = true;
		    	break;
		    }
		}
		LOGGER.info("getTargetCountByVersionId操作结果===" + exist);
		
		return exist;
	}
}
