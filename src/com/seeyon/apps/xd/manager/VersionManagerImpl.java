package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.collaboration.vo.ColSummaryVO;
import com.seeyon.apps.xd.dao.VersionDao;
import com.seeyon.apps.xd.po.VersionPo;
import com.seeyon.apps.xd.vo.VersionVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.seeyon.ctp.util.annotation.AjaxAccess;

@AjaxAccess
public class VersionManagerImpl implements VersionManger{

	private Logger LOGGER = Logger.getLogger(VersionManagerImpl.class);
	private VersionDao versionDao;
	

	public void setVersionDao(VersionDao versionDao) {
		this.versionDao = versionDao;
	}

	/**
	 * 新增版本信息
	 */
	@AjaxAccess
	public Boolean saveVersion(VersionPo vsPo) throws BusinessException{
		
		return versionDao.saveVersion(vsPo);
	}

	/**
	 * 查询版本信息
	 */
	@AjaxAccess
	public FlipInfo getVersion(FlipInfo flipInfo,Map<String, Object> map) throws BusinessException {
		
	
		//fi.setSize(15);//设置默认显示条数
		String key=(String) map.get("condition");//取前台查询按钮中的选择项，取得值为conditions中的value属性值
		String value=(String) map.get("value");
		//list=memberdao.loginuser(fi, map);
		flipInfo = versionDao.getVersion(flipInfo,map);
        List list = flipInfo.getData();
        //进行数据加工
        List<VersionVo>  result = this.convert(list);
        flipInfo.setData(result);
		return flipInfo;
	}

	public List<VersionVo> convert(List list){
		List<VersionVo> voes = new ArrayList<VersionVo>();
		if(Strings.isNotEmpty(list)){
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				
				int j = 0;
				VersionVo  vo = new VersionVo();
				Object id = obj[j++];
				if(id != null){
				    vo.setId(Long.parseLong(id.toString()));
				}
				Object vCode = obj[j++];
				if(vCode != null){
				    vo.setvCode(vCode.toString());
				}
				Object year = obj[j++];
				if(year != null){
				    vo.setvYear(year.toString());
				}
				Object createTime = obj[j++];
				if(createTime != null){
					Timestamp ts = (Timestamp) createTime;
					
					vo.setCreateTime(new Date(ts.getTime()));
				}
				Object isEnable = obj[j++];
				if(isEnable != null){
				    vo.setIsEnable(Integer.parseInt(isEnable.toString()));
				}
				Object state = obj[j++];
				if(state != null){
				    vo.setState(Integer.parseInt(state.toString()));
				}
				voes.add(vo);
			}
		}
		return voes;
	}
}
