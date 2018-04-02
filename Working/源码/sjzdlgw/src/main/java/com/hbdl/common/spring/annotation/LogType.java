package com.hbdl.common.spring.annotation;

public enum LogType {
	
	LOGIN("登录"),
	
	OPERATE("操作");
	
	private final String value;
	
	LogType(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
