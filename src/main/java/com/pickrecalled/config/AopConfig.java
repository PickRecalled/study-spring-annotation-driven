package com.pickrecalled.config;

import com.pickrecalled.aop.LogAspects;
import com.pickrecalled.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	// 业务逻辑类加入到容器中
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}

	@Bean
	// 切面类加入到容器中
	public LogAspects logAspects() {
		return new LogAspects();
	}
}
