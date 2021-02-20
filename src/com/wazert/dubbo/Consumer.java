package com.wazert.dubbo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.wazert.dubbo.domain.Config;
import com.wazert.sanitation.dubbo.InvokeDataService;

/**
 * @author clq
 * @function 消费者
 * @date 2021-02-19
 */
public abstract class Consumer<T> {
	private static final Logger logger = Logger.getLogger(Consumer.class);
	
	private static Config config;
	private static ApplicationConfig applicationConfig;
	
	static {
		config = new Config();
		
		// 当前应用配置
		applicationConfig = new ApplicationConfig();
		applicationConfig.setName(config.getSubscribeApplicationName());
		logger.debug("消费者应用:" + applicationConfig);
	}
	
	/*
	 * 服务端-springBean
	 */
	protected T serviceBean = getServiceBean();
	
	/**
	 * @author clq
	 * @function 获取服务端-springBean
	 * @param clazz
	 * @return T
	 * @date 2021-02-19
	 */
	protected T getServiceBean(Class<T> clazz) {
		if(config.getSubscribeRunning() == false){
			return null;
		}
		
		// 订阅服务
		RegistryConfig registryConfig = new RegistryConfig(config.getSubscribeAddress());
        registryConfig.setProtocol(config.getRegistryProtocol());
        registryConfig.setTimeout(config.getTimeout());// 超时
        
        ReferenceConfig<T> referenceConfig = new ReferenceConfig<T>();
		referenceConfig.setApplication(applicationConfig);
		referenceConfig.setRegistry(registryConfig);
		referenceConfig.setTimeout(config.getTimeout());// 超时
		
		referenceConfig.setInterface(InvokeDataService.class);
		referenceConfig.setVersion(config.getZkVersion());

		return referenceConfig.get();
	}
	
	/**
	 * @author clq
	 * @function 获取服务端-springBean
	 * @return T
	 * @date 2021-02-19
	 */
	@SuppressWarnings("unchecked")
	protected T getServiceBean() {
		// 变相获取 T.class
		Type type = getClass().getGenericSuperclass();
		
		Class<T> clazz = null;
		if(type instanceof ParameterizedType){
			// 强制转化'参数化类型'
			ParameterizedType parameterizedType = (ParameterizedType) type;
			// 参数化类型中可能有多个泛型参数
			Type[] types = parameterizedType.getActualTypeArguments();
			// 获取数据的第一个元素(User.class)
			clazz = (Class<T>) types[0]; // com.oa.shore.entity.User.class
		}
		if(clazz == null) {
			return null;
		}
		return getServiceBean(clazz);
	}
}
