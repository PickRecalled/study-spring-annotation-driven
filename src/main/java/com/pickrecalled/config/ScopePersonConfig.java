package com.pickrecalled.config;

import com.pickrecalled.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopePersonConfig {

	@Bean
	@Scope("prototype")
	// IOC容器当中组件默认是单实例的
	Person person() {
		System.out.println("给容器当中添加person......");
		return new Person("李四", "30");
	}

}
