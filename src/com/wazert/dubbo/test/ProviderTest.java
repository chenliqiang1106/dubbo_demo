package com.wazert.dubbo.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.wazert.dubbo.Provider;
import com.wazert.sanitation.dubbo.InvokeDataService;
import com.wazert.sanitation.dubbo.impl.InvokeDataServiceImpl;

/**
 * @author clq
 * @function 生产者调试	
 * @date 2021-02-19
 */
public class ProviderTest{
	private static final Logger logger = Logger.getLogger(ProviderTest.class);
	
	@Test
	public void test() throws IOException {
		// 生产者
		new Provider<InvokeDataService>(new InvokeDataServiceImpl());
		
		// 发布服务
		logger.debug("发布服务");
		System.in.read();// 为保证服务一直开着,利用输入流的阻塞来模拟
	}
}
