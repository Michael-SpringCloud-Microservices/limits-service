/**
 * 
 */
package com.in28minutes.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 109726
 *
 */
@Component
@ConfigurationProperties("limits-service")
public class Configuration {

	private int minimum;
	
	private int maximum;
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Configuration [minimum=" + minimum + ", maximum=" + maximum
				+ "]";
	}		
	
}
