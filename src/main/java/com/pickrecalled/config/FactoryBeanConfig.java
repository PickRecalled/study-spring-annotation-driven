package com.pickrecalled.config;

import com.pickrecalled.bean.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfig {

	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
