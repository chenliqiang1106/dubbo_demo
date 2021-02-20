package com.wazert.sanitation.dubbo;

import java.util.Map;

import com.wazert.sanitation.domain.Result;

/**
 * @author clq
 * @function 调用数据统一处理(服务)
 * @date 2021-02-19
 */
public interface InvokeDataService {
	
	public Result executeMethod(Map<String, Object> map); // 执行方法 author clq date 2020-07-21
}