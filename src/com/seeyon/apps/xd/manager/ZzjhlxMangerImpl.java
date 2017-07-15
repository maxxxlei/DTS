package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.apps.xd.dao.ZzjhlxDao;
import com.seeyon.apps.xd.po.ZzjhlxPo;
import com.seeyon.apps.xd.vo.ZzjhlxVo;
import com.seeyon.ctp.common.dao.BaseHibernateDao;
import com.seeyon.ctp.util.BeanUtils;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class ZzjhlxMangerImpl implements ZzjhlxManger{
	private static Log log=LogFactory.getLog(ZzjhlxMangerImpl.class);
	private ZzjhlxDao zzjhlxDao;

	public ZzjhlxDao getZzjhlxDao() {
		return zzjhlxDao;
	}

	public void setZzjhlxDao(ZzjhlxDao zzjhlxDao) {
		this.zzjhlxDao = zzjhlxDao;
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
