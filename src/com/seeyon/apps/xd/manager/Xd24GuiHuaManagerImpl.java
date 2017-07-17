package com.seeyon.apps.xd.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seeyon.apps.xd.constants.Xd24Enum;
import com.seeyon.apps.xd.dao.Xd24GuiHuaDao;
import com.seeyon.apps.xd.vo.GuiHuaVo;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.util.FlipInfo;
import com.seeyon.ctp.util.Strings;
import com.seeyon.ctp.util.annotation.AjaxAccess;

public class Xd24GuiHuaManagerImpl implements Xd24GuiHuaManager{
	private Logger LOGGER = Logger.getLogger(VersionManagerImpl.class);
	private Xd24GuiHuaDao guihuaDao;
	
	public void setGuihuaDao(Xd24GuiHuaDao guihuaDao) {
		this.guihuaDao = guihuaDao;
	}


	@AjaxAccess
	@Override
	public FlipInfo getGuiHua(FlipInfo flipInfo, Map<String, Object> map)
			throws BusinessException {
//		//fi.setSize(15);//设置默认显示条数
//			String key=(String) map.get("condition");//取前台查询按钮中的选择项，取得值为conditions中的value属性值
//			String value=(String) map.get("value");
//			if(Strings.isNotEmpty(key)){
//				flipInfo = guihuaDao.getVersionByCondition(flipInfo,map,key,value);
//			}else{
//				flipInfo = guihuaDao.getVersion(flipInfo,map);
//			}
//	        List list = flipInfo.getData();
//	        //进行数据加工
//	        List<VersionVo>  result = this.convert(list);
//	        flipInfo.setData(result);
			return flipInfo;
	}

	
//	public List<GuiHuaVo> convert(List list){
//		List<GuiHuaVo> voes = new ArrayList<GuiHuaVo>();
//		if(Strings.isNotEmpty(list)){
//			for (int i = 0; i < list.size(); i++) {
//				Object[] obj = (Object[]) list.get(i);
//				
//				int j = 0;
//				GuiHuaVo  vo = new GuiHuaVo();
//				Object id = obj[j++];
//				if(id != null){
//				    vo.setId(Long.parseLong(id.toString()));
//				}
//				Object vCode = obj[j++];
//				if(vCode != null){
//				    vo.setvCode(vCode.toString());
//				}
//				Object year = obj[j++];
//				if(year != null){
//				    vo.setvYear(year.toString());
//				}
//				Object createTime = obj[j++];
//				if(createTime != null){
//					Timestamp ts = (Timestamp) createTime;
//					
//					vo.setCreateTime(new Date(ts.getTime()));
//				}
//				Object isEnable = obj[j++];
//				if(isEnable != null){
//					String enable = Xd24Enum.VersionEnable.ENABLE.getKey();
//					String disenable = Xd24Enum.VersionEnable.DISENABLE.getKey();
//
//					if(enable.equals(isEnable.toString())){
//						vo.setIsEnable(Xd24Enum.VersionEnable.ENABLE.getText());
//					}else if(disenable.equals(isEnable.toString())){
//						vo.setIsEnable(Xd24Enum.VersionEnable.DISENABLE.getText());
//					}
//				}
//				Object state = obj[j++];
//				if(state != null){
//					String userful = Xd24Enum.VersionIs.USEFUL.getKey();
//					String notuseful = Xd24Enum.VersionIs.NOTUSEFUL.getKey();
//
//					if(userful.equals(state.toString())){
//						vo.setState(Xd24Enum.VersionIs.USEFUL.getText());
//					}else if(notuseful.equals(state.toString())){
//						vo.setState(Xd24Enum.VersionIs.NOTUSEFUL.getText());
//					}
//				}
//				voes.add(vo);
//			}
//		}
//		return voes;
//	}
}
