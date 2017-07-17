package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.constants.Xd24Enum.IsEnable;
import com.seeyon.apps.xd.dao.Xd24ZzjhlxDao;
import com.seeyon.apps.xd.po.TargetPo;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.BeanUtils;
import com.seeyon.ctp.util.DateUtil;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24ZzjhlxMangerImpl implements Xd24ZzjhlxManger{
	private static Log log=LogFactory.getLog(Xd24ZzjhlxMangerImpl.class);
	private Xd24ZzjhlxDao zzjhlxDao;

	public Xd24ZzjhlxDao getZzjhlxDao() {
		return zzjhlxDao;
	}

	public void setZzjhlxDao(Xd24ZzjhlxDao zzjhlxDao) {
		this.zzjhlxDao = zzjhlxDao;
	}
/**
 * 删除功能
 * @param ids 选中要删除的id数组可能多个
 * @return
 * @throws BusinessException
 */
	@AjaxAccess
	@Override
	public String deleteZzjhlx(String[] ids) throws BusinessException {
		log.info("进入批量删除目标方法====");
		if(ids.length > 0){
			for(int i = 0;i<ids.length;i++){
				ZzjhlxPo zzjhlxPo = zzjhlxDao.getZzjhlxPoById(Long.valueOf(ids[i].toString()));
				zzjhlxPo.setIsDelete(Integer.valueOf(Xd24Enum.Target.DELETE_Y.getKey()));
				zzjhlxDao.updateZzjhlx(zzjhlxPo);
			}
			log.info("共删除目标 "+ids.length+" 条记录");
			return "SUCCESS";
		}else{
			return "FALSE";
		}
	}
	
	
	/**
	 * 通过id和name属性查询是否有相同的name属性和是否是自己本身查询组织计划
	 * @throws BusinessException 
	 */
	@Override
	@AjaxAccess
	public boolean checkZzjhlxByName(String name, String id) throws BusinessException{
		Boolean flag = false;
		List list = zzjhlxDao.getZzjhlxByName(name);
		List<ZzjhlxVo> zv = new ArrayList<ZzjhlxVo>();
		if(Strings.isEmpty(list)){
			return false;
		}
		if(Strings.isNotEmpty(list)){
			for (int i = 0; i < list.size(); i++) {
				ZzjhlxVo  vo = new ZzjhlxVo();
				Object[] obj = (Object[]) list.get(i);
				int j = 0;
				Object id1 = obj[j++];
				if(id1 != null){
				    vo.setId(Long.parseLong(id1.toString()));
				}
				Object name1 = obj[j++];
				if(name1 != null){
				    vo.setName(name1.toString());
				}
				zv.add(vo);
			}
			if(Strings.isBlank(id)){
				for(ZzjhlxVo zjv : zv){
					if(name.equals(zjv.getName())){
						flag = true;
					}
				}
			}else{
				for(ZzjhlxVo zjv : zv){
					if(name.equals(zjv.getName()) && !zjv.getId().toString().equals(id)){
						flag = true;
					}
				}
			}
			
		}
			return flag;
		}
	
	
	
	/**
	 * 通过id查询组织计划
	 * @throws BusinessException 
	 */
	@Override
	@AjaxAccess
	public ZzjhlxVo getZzjhlxById(String id) throws BusinessException{
		ZzjhlxVo vo = new ZzjhlxVo();
		if(Strings.isNotBlank(id)){
			ZzjhlxPo po = zzjhlxDao.getZzjhlxById(Long.parseLong(id));
			BeanUtils.convert(vo, po);
		}
		return vo;
	}
	
	/**
	 * 保存组织计划管理
	 */
	@Override
	@AjaxAccess
	public void saveZzjhlx(Map<String, String> zzjhlx) throws BusinessException {
		ZzjhlxPo po = new ZzjhlxPo();
		po.setIdIfNew();
		po.setName(zzjhlx.get("name"));
		String isEnable = zzjhlx.get("isEnable");
		po.setIsEnable(Integer.valueOf(isEnable));
		po.setCreateTime(new Date());
		po.setUpdateTime(new Date());
		po.setIsDelete(0);
		po.setState(1);
		// TODO 版本号需要调接口查询
		po.setVersionId(123l);
		po.setDesc(zzjhlx.get("desc"));
		zzjhlxDao.saveZzjhlx(po);
	}
	
	
	
	/**
	 * 获取组织计划列表
	 */
	@AjaxAccess
	public FlipInfo getZzjhList(FlipInfo fi, Map<String, Object> map) throws BusinessException{
		zzjhlxDao.getZzjhList(fi, map);
		List list = fi.getData();
		if(Strings.isNotEmpty(list)){
			List<ZzjhlxVo> result = this.convert(list);
			fi.setData(result);
		}
		return fi;
	}
	
	/**
	 * po转vo
	 * @param list
	 * @return
	 */
	public List<ZzjhlxVo> convert(List list){
		List<ZzjhlxVo> voes = new ArrayList<ZzjhlxVo>();
		if(Strings.isNotEmpty(list)){
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				int j = 0;
				ZzjhlxVo  vo = new ZzjhlxVo();
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
				    vo.setIsEnable(Integer.parseInt(isEnable.toString()));
				    if(IsEnable.ENABLE.getKey().equals(isEnable.toString())){
				    	vo.setIsEnableName("启用");
				    }
				    if(IsEnable.DISENABLE.getKey().equals(isEnable.toString())){
				    	vo.setIsEnableName("停用");
				    }
				}
				Object updateTime = obj[j++];
				if(updateTime != null){
					Timestamp ts = (Timestamp) updateTime;
					vo.setUpdateTime(new Date(ts.getTime()));
				}
				Object createTime = obj[j++];
				if(createTime != null){
					Timestamp ts = (Timestamp) createTime;
					vo.setCreateTime(new Date(ts.getTime()));
				}
				
				voes.add(vo);
			}
		}
		return voes;
	}
	
}
