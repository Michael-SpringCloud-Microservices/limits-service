/**
 * 
 */
package com.in28minutes.microservices.limitsservice.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 109726
 *
 */
@Component
public class MessagesBean {

	@Value("${minimum}")
	private int minimum;

	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}

	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	

}
