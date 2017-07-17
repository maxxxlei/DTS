package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.dao.Xd24QuotaDao;
import com.seeyon.apps.xd.po.QuotaPo;
import com.seeyon.apps.xd.vo.QuotaVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24QuotaManagerImpl implements Xd24QuotaManager {
	
	private static final Logger LOGGER = Logger.getLogger(Xd24QuotaManagerImpl.class);
	private Xd24QuotaDao xd24QuotaDao;
	
	

	public void setXd24QuotaDao(Xd24QuotaDao xd24QuotaDao) {
		this.xd24QuotaDao = xd24QuotaDao;
	}


	@Override
	@AjaxAccess
	public FlipInfo getQuotaList(FlipInfo fi,Map<String, Object> map)
			throws BusinessException {
		 fi=xd24QuotaDao.getQuotaList(fi,map);
		List list=fi.getData();
		List<QuotaVo> volist=new ArrayList<QuotaVo>();
		if(Strings.isNotEmpty(list)){
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				int j = 0;
				QuotaVo vo=new QuotaVo();
				Object id=obj[j++];
				if(id != null){
				    vo.setId((Long)(id));
				}
				Object quotaCode=obj[j++];
				if(quotaCode != null){
				    vo.setQuotaCode((Long)(quotaCode));
				}
				Object quotaName = obj[j++];
				if(quotaName != null){
				    vo.setQuotaName(quotaName.toString());
				}
				Object quotaUnit = obj[j++];
				if(quotaUnit != null){
					vo.setQuotaUnit(Integer.valueOf(quotaUnit.toString()));
				}
				Object quotaType = obj[j++];
				if(quotaType != null){
					vo.setQuotaType(quotaType.toString());;
				}
				Object create_Time = obj[j++];
				if(create_Time != null){
					Timestamp ts = (Timestamp) create_Time;
					vo.setCreate_Time(new Date(ts.getTime()));
				}
				Object update_Time = obj[j++];
				if(update_Time != null){
					Timestamp ts = (Timestamp) update_Time;
					vo.setUpdate_Time(new Date(ts.getTime()));
				}
				volist.add(vo);
			}
		}
		fi.setData(volist);
		return fi;
	}

	@AjaxAccess
	public Boolean saveQuotaPo(QuotaPo po) throws BusinessException{
		
		return xd24QuotaDao.saveQuotaPo(po);
	}


	@Override
	public int updateQuota(Map<String, String> quotal) throws BusinessException {
		return xd24QuotaDao.updateQuota(quotal);
	}


	@Override
	public void deleteQuota(String[] idQuota) throws BusinessException {
		// TODO Auto-generated method stub
		
	}



}
