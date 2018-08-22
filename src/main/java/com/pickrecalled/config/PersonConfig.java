package com.pickrecalled.config;

import com.pickrecalled.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

	@Bean
	public Person person() {
		return new Person("王五", "10");
	}
}
