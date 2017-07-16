package com.seeyon.apps.xd.constants;

public class Xd24Enum {
	
	public enum Target{
	    DELETE_Y("0","删除"),
	    DELETE_N("1","未删除");
	    
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
     
}
