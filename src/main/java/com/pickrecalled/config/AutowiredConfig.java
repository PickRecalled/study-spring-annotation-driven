package com.pickrecalled.config;

import com.pickrecalled.bean.Car;
import com.pickrecalled.bean.Color;
import com.pickrecalled.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({ "com.pickrecalled.controller", "com.pickrecalled.dao", "com.pickrecalled.service", "com.pickrecalled.bean" })
public class AutowiredConfig {

	@Bean
	public Color color(@Autowired Car car) {
		Color color = new Color();
		color.setCar(car);
		return color;
	}

	/**
	 * BookDao类型的不重名的组件
	 * @return
	 */
	@Bean("bookDao2")
	@Primary
	public BookDao bookDao() {
		BookDao bd = new BookDao();
		bd.setLable("2");
		return bd;
	}

}
