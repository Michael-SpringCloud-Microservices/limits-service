/**
 * 
 */
package com.in28minutes.microservices.limitsservice.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author 109726
 *
 */
@Component
//The following annotation will always fetch the latest updated value from Git based file system
//via Spring cloud config server
@RefreshScope
public class FrequentlyChangedMessagesBean {


	@Value("${maximum}")
	private int maximum;

	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}

	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
