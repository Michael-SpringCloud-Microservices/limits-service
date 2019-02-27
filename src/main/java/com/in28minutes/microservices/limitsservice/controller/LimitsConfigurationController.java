package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.configuration.Configuration;
import com.in28minutes.microservices.limitsservice.model.LimitsConfiguration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController implements InitializingBean,DisposableBean {


	@Autowired
	Configuration configuration;


	private int minimum;

	private int maximum;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfiguration() {
		// The following line will refer properties from git based file system via Spring cloud config server
		return new LimitsConfiguration(maximum, minimum);

	}

	@GetMapping("/limits/via-propety-file")
	public LimitsConfiguration retrieveLimitsFromPropertyFile() {
		return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());

	}

	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}

	/**
	 * @param minimum the minimum to set
	 */
	@Value("${maximum}")
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
	@Value("${minimum}")
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}


	public void afterPropertiesSet() {
		System.out.println("The minimum value received :" + maximum);
		System.out.println("The minimum value received :" + minimum);
	}
	
	public void destroy() {
		System.out.println("The bean is getting destroyed");
	   }
}
