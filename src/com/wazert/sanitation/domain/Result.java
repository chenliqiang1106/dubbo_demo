package com.wazert.sanitation.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author clq
 * @function 接口返回结果
 * @date 2021-02-19
 */
public class Result implements Serializable{
	private static final long serialVersionUID = -3725146692288496597L;
	
	private int msgStatsNum;
	private List<Map<String,Object>> rows;
	private String msg;
	private int total;

	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Result() {
		super();
	}

	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Result(int msgStatsNum, String msg, int total, List<Map<String,Object>> rows) {
		this.msgStatsNum = msgStatsNum;
		this.msg = msg;
		if((rows == null || rows.isEmpty())
			|| total <= 0) {
			this.total = 0;
			this.rows = new ArrayList<Map<String,Object>>();
		}else {
			this.total = total;
			this.rows = rows;
		}
	}
	
	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Result(int msgStatsNum, String msg, List<Map<String,Object>> rows) {
		this.msgStatsNum = msgStatsNum;
		this.msg = msg;
		if(rows == null || rows.isEmpty()) {
			this.total = 0;
			this.rows = new ArrayList<Map<String,Object>>();
		}else {
			this.total = rows.size();
			this.rows = rows;
		}
	}
	
	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Result(int msgStatsNum, String msg, Collection<Map<String,Object>> rows) {
		this.msgStatsNum = msgStatsNum;
		this.msg = msg;
		if(rows == null || rows.isEmpty()) {
			this.total = 0;
			this.rows = new ArrayList<Map<String,Object>>();
		}else {
			this.total = rows.size();
			this.rows = new ArrayList<Map<String,Object>>(rows);
		}
	}
	
	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Result(int msgStatsNum, String msg, Map<String,Object> row) {
		this.msgStatsNum = msgStatsNum;
		this.msg = msg;
		if(row == null || row.isEmpty()) {
			this.total = 0;
			this.rows = new ArrayList<Map<String,Object>>();
		}else {
			this.total = 1;
			this.rows = new ArrayList<Map<String,Object>>();
			this.rows.add(row);
		}
	}
	
	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	@SuppressWarnings("unchecked")
	public Result(Map<String,Object> map) {
		this.msgStatsNum = Integer.parseInt(map.get("msgStatsNum").toString());
		this.msg = map.get("msg").toString();

		Object totalObj = map.get("total");// 数量
		this.total = totalObj != null ? Integer.parseInt(totalObj.toString()) : 0;
		
		List<Map<String,Object>> rows = (List<Map<String,Object>>)map.get("rows");
		if(rows != null && !rows.isEmpty()) {
			this.rows = rows;
			if(this.total <= 0) {
				this.total = rows.size();
			}
		}else {
			this.rows = new ArrayList<Map<String,Object>>();
		}
	}
	
	/**
	 * @author clq
	 * @function 构造函数
	 * @date 2021-02-19
	 */
	public Result(int msgStatsNum, String msg) {
		this.msgStatsNum = msgStatsNum;
		this.msg = msg;
		this.total = 0;
		this.rows = new ArrayList<Map<String,Object>>();
	}
	
	public int getMsgStatsNum() {
		return msgStatsNum;
	}
	public void setMsgStatsNum(int msgStatsNum) {
		this.msgStatsNum = msgStatsNum;
	}
	public List<Map<String,Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String,Object>> rows) {
		this.rows = rows;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Result [msgStatsNum=" + msgStatsNum + ", rows=" + rows + ", msg=" + msg + ", total=" + total + "]";
	}
	
}
