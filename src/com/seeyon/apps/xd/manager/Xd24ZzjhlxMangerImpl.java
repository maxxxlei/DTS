package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.apps.xd.dao.Xd24ZzjhlxDao;
import com.seeyon.apps.xd.po.ZldtwdPo;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.BeanUtils;
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
	 * 通过id和name属性查询是否有相同的name属性和是否是自己本身查询组织计划
	 */
	@Override
	@AjaxAccess
	public Boolean getNameAndId(String name, String id){
		Boolean flag = false;
		List list = zzjhlxDao.getNameAndId(id,name);
		List<ZzjhlxVo> zv = new ArrayList<ZzjhlxVo>();
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
			for(ZzjhlxVo zjv : zv){
				if(name.equals(zjv.getName()) && id == zjv.getId().toString()){
					return false;//姓名相同，相同
				}else if((!name.equals(zjv.getName()) && (id != zjv.getId().toString()))){
					return true;//姓名不同，id不同
				}else if((!name.equals(zjv.getName()) && (id == zjv.getId().toString()))){
					return true;//不同名字，相同的id
				}else if((name.equals(zjv.getName()) && (id != zjv.getId().toString()))){
					return false;//相同的名字，不同的id
				}
			}
			}
		return true;
		}
	
	
	
	/**
	 * 通过id查询组织计划
	 */
	@Override
	@AjaxAccess
	public ZzjhlxVo getZzjhlxById(String id){

		List list = zzjhlxDao.getZzjhlxById(id);
		ZzjhlxVo  vo = new ZzjhlxVo();
		if(Strings.isNotEmpty(list)){
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				int j = 0;
				
				Object id1 = obj[j++];
				if(id1 != null){
				    vo.setId(Long.parseLong(id1.toString()));
				}
				Object name = obj[j++];
				if(name != null){
				    vo.setName(name.toString());
				}
				Object isEnable = obj[j++];
				if(isEnable != null){
				    vo.setIsEnable(Integer.parseInt(isEnable.toString()));
				}
				Object createTime = obj[j++];
				if(createTime != null){
					Timestamp ts = (Timestamp) createTime;
					vo.setCreateTime(new Date(ts.getTime()));
				}
				Object desc = obj[j++];
				if(desc != null){
				    vo.setDesc(desc.toString());
				}
				return vo;
			}
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
	 * 查询到的结果放到FlipInfo里,返回FlipInfo
	 */
	@AjaxAccess
	public FlipInfo getUser(FlipInfo fi, Map<String, Object> map) {
		List<ZzjhlxVo> zzjhlxVo = new ArrayList<ZzjhlxVo>();
		//fi.setSize(15);//设置默认显示条数
		String key = (String) map.get("condition");//取前台查询按钮中的选择项，取得值为conditions中的value属性值
		String value = (String) map.get("value");
		if(key != null&&!key.equals("")){
		if(key.equals("createDate")){
			return null;
		}else{
			List list=zzjhlxDao.find(fi, map, key, value);
				fi.setData(list);
		}
		}else{
			fi = zzjhlxDao.getUser(fi, map);
			List list  = fi.getData();
			List<ZzjhlxVo>  result = this.convert(list);
			fi.setData(result);	
			return fi;
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
