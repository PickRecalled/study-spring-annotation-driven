package com.pickrecalled.config;

import com.pickrecalled.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// 读到外部配置文件中的Key与Value保存到运行的环境变量中
@PropertySource(encoding = "UTF-8", value = { "classpath:person.properties" })
public class ValuePersonConfig {

	@Bean
	public Person person() {
		return new Person();
	}

}
