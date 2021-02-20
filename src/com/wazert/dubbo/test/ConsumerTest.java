package com.wazert.dubbo.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.wazert.dubbo.Consumer;
import com.wazert.sanitation.domain.Result;
import com.wazert.sanitation.dubbo.InvokeDataService;

/**
 * @author clq
 * @function 消费者调试	
 * @date 2021-02-19
 */
public class ConsumerTest extends Consumer<InvokeDataService> {
	private static final Logger logger = Logger.getLogger(ConsumerTest.class);
	
	@Test
	public void test() throws IOException {
		
		Map<String,Object> mapTemp = new HashMap<String,Object>();
		mapTemp.put("beanId", "sanitationMetaDao");
		mapTemp.put("param", null);
		mapTemp.put("methodName", "selectMoreTablesColumns");
		mapTemp.put("paramTypeNames", "Map");
		Result result = serviceBean.executeMethod(mapTemp);

		// 消费记录
		logger.debug("获取数据1:" + result);
	}
}
