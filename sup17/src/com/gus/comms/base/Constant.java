package com.gus.comms.base;

public interface Constant {

	/**
	 * 可以通过初始化获取数据库配置
	 */
	int ZK_SESSION_TIMEOUT = 5000;
	
	int ZK_RETY_INTERVAL = 2000;
	
	int ZK_RETY_TIMES = 3;
	
	int ZK_SERVICE_OVERRIDE = 0;
	
	int ZK_SERVICE_WARN = 1;

	String ZK_REGISTRY_PATH = "/registry/service/";
	
	String ZK_REGISTRY_WPATH = "/registry/service";
	
}
