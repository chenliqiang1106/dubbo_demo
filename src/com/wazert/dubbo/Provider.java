package com.wazert.dubbo;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.wazert.dubbo.domain.Config;
import com.wazert.sanitation.dubbo.InvokeDataService;

/**
 * @author clq
 * @function 生产者
 * @date 2021-02-19
 */
public class Provider<T> {
	private static final Logger logger = Logger.getLogger(Provider.class);

	private static Config config;
	private static ApplicationConfig applicationConfig;
	
	static {
		config = new Config();
		
		// 当前应用配置
		applicationConfig = new ApplicationConfig();
		applicationConfig.setName(config.getPublishApplicationName());
		logger.debug("生产者应用:" + applicationConfig);
	}
	
	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Provider(T t) {
		// 初始化
		init(t);
	}

	/**
	 * @author clq
	 * @function 初始化
	 * @param T
	 * @date 2021-02-19
	 */
	public void init(T t) {
		if(config.getPublishRunning() == false){
			return;
		}
		
		// 发布服务
		RegistryConfig registryConfig = new RegistryConfig(config.getRegistryAddress());
        registryConfig.setProtocol(config.getRegistryProtocol());
        registryConfig.setTimeout(config.getTimeout());// 超时
        
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(config.getPublishProtocolName());
        protocolConfig.setPort(config.getPublishProtocolPort());
        
        ServiceConfig<T> serviceConfig = new ServiceConfig<T>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setTimeout(config.getTimeout());// 超时
        
        serviceConfig.setInterface(InvokeDataService.class);
        serviceConfig.setRef(t);
        serviceConfig.setVersion(config.getZkVersion());
        serviceConfig.export();
	}
}
