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
     
}
