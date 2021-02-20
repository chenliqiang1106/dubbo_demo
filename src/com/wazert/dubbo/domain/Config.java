package com.wazert.dubbo.domain;

import java.io.Serializable;

/**
 * @author clq
 * @function 配置
 * @date 2021-02-19
 */
public class Config implements Serializable{
	private static final long serialVersionUID = 8091264978993407502L;
	
	private Integer timeout=10000;
	private String registryAddress="172.16.0.41:2181";
	private String registryProtocol="zookeeper";
	private String zkVersion="3.5.2";

	// publish configures
	private Boolean publishRunning=false;
	private String publishApplicationName="dubbo-productor";
	private String publishProtocolName="dubbo";
	private Integer publishProtocolPort=20881;
	
	// subscribe configures
	private Boolean subscribeRunning=true;
	private String subscribeApplicationName="dubbo-consumer";
	private String subscribeAddress="172.16.0.41:2181";
	
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public String getRegistryAddress() {
		return registryAddress;
	}
	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}
	public String getRegistryProtocol() {
		return registryProtocol;
	}
	public void setRegistryProtocol(String registryProtocol) {
		this.registryProtocol = registryProtocol;
	}
	public String getZkVersion() {
		return zkVersion;
	}
	public void setZkVersion(String zkVersion) {
		this.zkVersion = zkVersion;
	}
	public Boolean getPublishRunning() {
		return publishRunning;
	}
	public void setPublishRunning(Boolean publishRunning) {
		this.publishRunning = publishRunning;
	}
	public String getPublishApplicationName() {
		return publishApplicationName;
	}
	public void setPublishApplicationName(String publishApplicationName) {
		this.publishApplicationName = publishApplicationName;
	}
	public String getPublishProtocolName() {
		return publishProtocolName;
	}
	public void setPublishProtocolName(String publishProtocolName) {
		this.publishProtocolName = publishProtocolName;
	}
	public Integer getPublishProtocolPort() {
		return publishProtocolPort;
	}
	public void setPublishProtocolPort(Integer publishProtocolPort) {
		this.publishProtocolPort = publishProtocolPort;
	}
	public Boolean getSubscribeRunning() {
		return subscribeRunning;
	}
	public void setSubscribeRunning(Boolean subscribeRunning) {
		this.subscribeRunning = subscribeRunning;
	}
	public String getSubscribeApplicationName() {
		return subscribeApplicationName;
	}
	public void setSubscribeApplicationName(String subscribeApplicationName) {
		this.subscribeApplicationName = subscribeApplicationName;
	}
	public String getSubscribeAddress() {
		return subscribeAddress;
	}
	public void setSubscribeAddress(String subscribeAddress) {
		this.subscribeAddress = subscribeAddress;
	}
}
