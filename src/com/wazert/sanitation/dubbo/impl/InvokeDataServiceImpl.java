package com.wazert.sanitation.dubbo.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import com.wazert.sanitation.domain.Result;
import com.wazert.sanitation.dubbo.InvokeDataService;

/**
 * @author clq
 * @function 调用数据统一处理(服务)
 * @date 2021-02-19
 */
public class InvokeDataServiceImpl implements InvokeDataService {
	private static final Logger logger = Logger.getLogger(InvokeDataServiceImpl.class);

	/**
	 * @author clq
	 * @function 执行方法
	 * @param map {param:,methodName:,paramTypeName:,beanId:}
	 * @return json {msg:成功,msgStatsNum:1}
	 * or {msg:失败,msgStatsNum:2} or {msg:异常,msgStatsNum:3}
	 * or null or {} or []
	 * @date 2021-02-19
	 */
	public Result executeMethod(Map<String,Object> map){
		Result result = new Result(2, "失败1");
		try {
			// 返回客户端
			result = new Result(1, "成功1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("msg", e);
			result = new Result(3, "异常1");
		}
		return result;
	}
}
