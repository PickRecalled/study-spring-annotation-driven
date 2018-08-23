package com.pickrecalled.config;

import com.pickrecalled.model.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration

@ComponentScans(value = {
        @ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }),
		@ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Service.class }) })
})
public class PersonConfig {

	@Bean
	public Person person() {
		return new Person("王五", "10");
	}
}
