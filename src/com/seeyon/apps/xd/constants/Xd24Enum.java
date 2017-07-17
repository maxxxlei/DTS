package com.seeyon.apps.xd.constants;

public class Xd24Enum {
	/**
	 * 目标录入--是否删除
	 * @author heliang.wang
	 *
	 * @time 2017年7月16日
	 */
	public enum Target{
	    DELETE_Y("1","删除"),
	    DELETE_N("0","未删除");
	    
	    private String key;
	    private String text;
	    
	    Target(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
	}
	
	/**
	 * 指标分类枚举
	 * @author DELL
	 *
	 */
	public enum Quota{
	    QUOTACLASS_A("0","财务指标"),
	    QUOTACLASS_B("1","间接财务指标"),
	    QUOTACLASS_C("2","业务指标");
	    
	    private String key;
	    private String text;
	    
	    Quota(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
	}
	/**
	 * 规划计划审批状态
	 * @author heliang.wang
	 *
	 * @time 2017年7月16日
	 */
	public enum PlanEnum{
	    PLAN_DISAPPROVE("0","未审批"),
	    PLAN_APPROVEING("1","审批中"),
	    PLAN_APPROVE_PASS("2","审批通过"),
	    PLAN_APPROV_NOT_PASS("3","审批未通过");
	    
	    private String key;
	    private String text;
	    
	    PlanEnum(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
	}
	/**
	 * 版本管理版本是否生效
	 * @author weiminliu
	 *
	 */
	public enum VersionIs{
		NOTUSEFUL("1","未生效"),
		USEFUL("0","生效");
		 
		private String key;
		private String text;
		
		VersionIs(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		 
		 
		 
	}
	/**
	 * 版本是否启用
	 * @author Administrator
	 *
	 */
	public enum VersionEnable{
		ENABLE("1","启用"),
		DISENABLE("0","停用");
		 
		private String key;
		private String text;
		
		VersionEnable(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
	}
	
	/**
	 * 版本是否启用
	 * @author Administrator
	 *
	 */
	public enum IsEnable{
		ENABLE("1","启用"),
		DISENABLE("0","停用");
		 
		private String key;
		private String text;
		
		IsEnable(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
	}
	
	
	/**
	 * 菜单分类
	 * @author zhaifeng
	 *
	 */
	public enum MenuCategory{
		GHJH("1","规划计划"),
		ZXTJ("2","执行统计"),
		DBFX("3","对比分析"),
		GXJY("4","更新决议"),
		KHPJ("5","考核评价"),
		QMZJ("6","全面总结");
		 
		private String key;
		private String text;
		
		MenuCategory(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		/**
		 * 根据key得到枚举类型
		 * 
		 * @param key
		 * @return StateEnum
		 */
		public static MenuCategory getValue(String key) {
			MenuCategory[] enums = MenuCategory.values();
			if (enums != null) {
				for (MenuCategory enum1 : enums) {
					if (enum1.getKey().equals(key)) {
						return enum1;
					}
				}
			}
			return null;
		}
	}
	
	/**
	 * 规划类型枚举
	 * @author ML
	 *
	 */
	public enum GuiHuaType{
		ZLGH("1","战略规划"),
		ZYGH("2","专业规划");
		 
		private String key;
		private String text;
		
		GuiHuaType(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		/**
		 * 根据key得到枚举类型
		 * 
		 * @param key
		 * @return StateEnum
		 */
		public static GuiHuaType getValue(String key) {
			GuiHuaType[] enums = GuiHuaType.values();
			if (enums != null) {
				for (GuiHuaType enum1 : enums) {
					if (enum1.getKey().equals(key)) {
						return enum1;
					}
				}
			}
			return null;
		}
	}
	/**
	 * 战略地图维度_是否启用枚举
	 * @author 继往开来
	 *
	 */
	public enum Zldtwd{
	    ENABLE_Y("1","是"),
	    ENABLE_N("0","否");
	    
	    private String key;
	    private String text;
	    
	    Zldtwd(String key,String text){
	        this.setKey(key);
	        this.setText(text);
	    }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
	}
	
	

}
