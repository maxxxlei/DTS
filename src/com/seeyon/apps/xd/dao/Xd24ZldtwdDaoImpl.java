package com.seeyon.apps.xd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.DBAgent;
import com.seeyon.ctp.util.DateUtil;
import com.seeyon.ctp.util.FlipInfo;

public class Xd24ZldtwdDaoImpl implements Xd24ZldtwdDao {
	private static final Logger LOGGER = Logger.getLogger(Xd24ZldtwdDaoImpl.class);
	@Override
	public List getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException {
		try{
			String hql ="select a.id, a.name,a.isEnable,a.description,a.createTime from ZldtwdPo a where a.isDelete=:isDelete";
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("isDelete", 0);
			if(query.get("name") != null){
				hql = hql + " and a.name like :name";
				params.put("name", "%"+query.get("name").toString()+"%");
			}
			if(query.get("description") != null){
				hql = hql + " and a.description like :description";
				params.put("description", "%"+query.get("description").toString()+"%");
			}
			if(query.get("isEnable") != null){
				hql = hql + " and a.isEnable=:isEnable";
				params.put("isEnable", Integer.valueOf(query.get("isEnable").toString()));
			}
			if(query.get("from_datetime") != null){
				hql = hql + " and a.createTime  >=:startTime";
				params.put("startTime", DateUtil.parse(query.get("from_datetime").toString()));
			}
			if(query.get("to_datetime") != null){
				hql = hql + " and a.createTime <=:endTime";
				params.put("endTime", DateUtil.parse(query.get("to_datetime").toString()));
			}
			hql = hql + " order by a.createTime desc";
			return DBAgent.find(hql, params, flipInfo);
		} catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}
	
	@Override
	public void saveZldtwd(ZldtwdPo po) throws BusinessException {
		try{
			DBAgent.save(po);
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}
	
	@Override
	public void updateZldtwd(ZldtwdPo po) throws BusinessException {
		try{
			DBAgent.update(po);
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@Override
	public List getZldtwdById(long id) throws BusinessException {
		try{
			String hql ="select a.id, a.name,a.isEnable,a.description from ZldtwdPo a where a.id=:id";
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", Long.valueOf(id));
			return DBAgent.find(hql, params);
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@Override
	public void deleteZldtwd(String[] ids) throws BusinessException {
		try{
			List<ZldtwdPo> list = new ArrayList<ZldtwdPo>();
			Map<String,Object> params = new HashMap<String,Object>();
			for(String id : ids){
				String hql ="FROM ZldtwdPo where id =:id";
				params.put("id", Long.parseLong(id));
				list.addAll(DBAgent.find(hql, params));
			}
			for(ZldtwdPo po:list){
				po.setIsDelete(1);
				DBAgent.update(po);	
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@Override
	public boolean getSumZldtwName(String name, String id, boolean isNew) throws BusinessException {
		try{
			if(isNew){
				String hql ="from ZldtwdPo a where a.name=:name and a.isDelete=:isDelete";
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("name", name);
				params.put("isDelete", 0);
				List list = DBAgent.find(hql, params);
				if(list != null && list.size() > 0){
					return false;
				}else {
					return true;
				}
			}else{
				String hql ="select a.id,a.name from ZldtwdPo a where a.name=:name and a.isDelete=:isDelete";
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("name", name);
				params.put("isDelete", 0);
				long idValue = Long.valueOf(id);
				List list = DBAgent.find(hql, params);
				if(list != null && list.size() > 0){
					int count = 0;
					for (int i = 0; i < list.size(); i++) {
						Object[] obj = (Object[]) list.get(i);
						int j = 0;
						Object idSelect = obj[j++];
						Object nameSelect = obj[j++];
						if((!id.equals(idSelect.toString())) && name.equals(nameSelect)){
							count++;
						}
					}
					if (count > 0) {
						return false;
					}else {
						return true;
					}
				}else {
					return true;
				}
			}
		} catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@Override
	public List<ZldtwdPo> getZldtwdList4Enum() throws BusinessException {
		StringBuffer hql = new StringBuffer("select z.id,z.name from ZldtwdPo z where 1=1");
		hql.append(" and z.isEnable =:isEnable");
		hql.append(" and z.isDelete =:isDelete");
		hql.append(" order by z.createTime desc");
		Map<String,Object> params = new HashMap<String, Object>();
		Integer isEnable = Integer.valueOf(Xd24Enum.Zldtwd.ENABLE_Y.getKey());
		Integer isDelete = Integer.valueOf(Xd24Enum.IsDelete.DELETE_N.getKey());
		params.put("isEnable",isEnable);
		params.put("isDelete",isDelete);
		LOGGER.info("查询所有战略地图的sql=========="+hql.toString());
		List<Object[]> list = DBAgent.find(hql.toString(), params);
		List<ZldtwdPo> dataList = new ArrayList<ZldtwdPo>();
		if(list.size()>0){
			for(int i = 0;i < list.size();i++){
				Object[] o = list.get(i);
				ZldtwdPo zp = new ZldtwdPo();
				zp.setId(Long.valueOf(o[0].toString()));
				zp.setName(o[1].toString());
				dataList.add(zp);
			}
		}
		LOGGER.info("查询到符合条件的枚举数量："+dataList.size());
		return dataList;
	}


}
