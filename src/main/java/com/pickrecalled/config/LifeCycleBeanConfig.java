package com.pickrecalled.config;

import com.pickrecalled.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.annotation.Resource;

@Configuration
@ComponentScan(value = "com.pickrecalled.config", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Resource.class }) })
public class LifeCycleBeanConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	// @Scope("prototype")
	public Car car() {
		return new Car();
	}
}
