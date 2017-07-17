package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.dao.Xd24ZldtwdDao;
import com.seeyon.apps.xd.dao.Xd24ZldtwdDaoImpl;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.vo.ZldtwdVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.seeyon.ctp.util.annotation.AjaxAccess;
/**
 * 战略地图维护
 * @author zhaifeng
 *
 */
public class Xd24ZldtwdManagerImpl implements Xd24ZldtwdManager {
	private static final Logger LOGGER = Logger.getLogger(Xd24ZldtwdDaoImpl.class);
	private Xd24ZldtwdDao xd24ZldtwdDao;
	
	
	public void setXd24ZldtwdDao(Xd24ZldtwdDao xd24ZldtwdDao) {
		this.xd24ZldtwdDao = xd24ZldtwdDao;
	}

	@Override
	@AjaxAccess
	public FlipInfo getZldtwdList(FlipInfo flipInfo, Map<String, String> query) throws BusinessException {
		try{
			List list = xd24ZldtwdDao.getZldtwdList(flipInfo, query);
			List<ZldtwdVo> voList = new ArrayList<ZldtwdVo>();
			if(Strings.isNotEmpty(list)){
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[]) list.get(i);
					int j = 0;
					ZldtwdVo  vo = new ZldtwdVo();
					Object id = obj[j++];
					if(id != null){
						vo.setId(Long.parseLong(id.toString()));
					}
					Object name = obj[j++];
					if(name != null){
						vo.setName(name.toString());
					}
					Object isEnable = obj[j++];
					if(isEnable != null){
						String yesKey = Xd24Enum.Zldtwd.ENABLE_Y.getKey();
						String noKey = Xd24Enum.Zldtwd.ENABLE_N.getKey();
						if(yesKey.equals(isEnable.toString())){
							String yesText = Xd24Enum.Zldtwd.ENABLE_Y.getText();
							vo.setIsEnable(yesText);
						}
						if(noKey.equals(isEnable.toString())){
							String noText = Xd24Enum.Zldtwd.ENABLE_N.getText();
							vo.setIsEnable(noText);
						}
					}
					Object description = obj[j++];
					if(description != null){
						vo.setDescription(description.toString());
					}
					Object createTime = obj[j++];
					if(createTime != null){
						Timestamp ts = (Timestamp) createTime;
						vo.setCreateTime(new Date(ts.getTime()));
					}
					voList.add(vo);
				}
			}
			flipInfo.setData(voList);
			return flipInfo;
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}
	
	@Override
	@AjaxAccess
	public void saveZldtwd(Map<String, String> zldtwd) throws BusinessException {
		try{
			ZldtwdPo po = new ZldtwdPo();
			po.setIdIfNew();
			po.setName(zldtwd.get("name"));
			String isEnable = zldtwd.get("isEnable");
			po.setIsEnable(Integer.valueOf(isEnable));
			po.setCreateTime(new Date());
			po.setUpdateTime(new Date());
			po.setIsDelete(0);
			// TODO 版本号需要调接口查询
			po.setVersionId(1l);
			po.setVerState(1);
			po.setDescription(zldtwd.get("description"));
			xd24ZldtwdDao.saveZldtwd(po);
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}
	
	@AjaxAccess
	@Override
	public void updateZldtwd(Map<String, String> zldtwd) throws BusinessException {
		try{
			ZldtwdPo po = new ZldtwdPo();
			if(zldtwd.get("id") != null){
				po.setId(Long.valueOf(zldtwd.get("id")));
				po.setName(zldtwd.get("name"));
				String isEnable = zldtwd.get("isEnable");
				po.setIsEnable(Integer.valueOf(isEnable));
				po.setUpdateTime(new Date());
				po.setIsDelete(0);
				// TODO 版本号需要调接口查询当前最新版本号
				po.setVersionId(123l);
				po.setVerState(1);
				po.setDescription(zldtwd.get("description"));
				xd24ZldtwdDao.updateZldtwd(po);
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@Override
	@AjaxAccess
	public ZldtwdVo getZldtwdById(String id) throws BusinessException {
		try{
			List list = xd24ZldtwdDao.getZldtwdById(Long.valueOf(id));
			if(Strings.isNotEmpty(list)){
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[]) list.get(i);
					int j = 0;
					ZldtwdVo  vo = new ZldtwdVo();
					Object id2 = obj[j++];
					if(id2 != null){
						vo.setId(Long.valueOf(id2.toString()));
					}
					Object name = obj[j++];
					if(name != null){
						vo.setName(name.toString());
					}
					Object isEnable = obj[j++];
					if(isEnable != null){
						String yesKey = Xd24Enum.Zldtwd.ENABLE_Y.getKey();
						String noKey = Xd24Enum.Zldtwd.ENABLE_N.getKey();
						if(yesKey.equals(isEnable.toString())){
							String yesText = Xd24Enum.Zldtwd.ENABLE_Y.getText();
							vo.setIsEnable(yesText);
						}
						if(noKey.equals(isEnable.toString())){
							String noText = Xd24Enum.Zldtwd.ENABLE_N.getText();
							vo.setIsEnable(noText);
						}
					}
					Object description = obj[j++];
					if(description != null){
						vo.setDescription(description.toString());
					}
					return vo;
				}
			}
			return null;
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@AjaxAccess
	@Override
	public void deleteZldtwd(String[] ids) throws BusinessException {
		xd24ZldtwdDao.deleteZldtwd(ids);
	}
	
	@AjaxAccess
	@Override
	public boolean getSumZldtwName(String name,String id,boolean isNew) throws BusinessException{
		return xd24ZldtwdDao.getSumZldtwName(name, id, isNew);
	}

	@Override
	public List<ZldtwdPo> getZldtwdList4Enum() throws BusinessException {
		return xd24ZldtwdDao.getZldtwdList4Enum();
	}



}
