package com.pickrecalled.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

	/**
	 * 构造器
	 */
	public Car() {
		System.out.println("Car 对象构建调用构造器.....");
	}

	/**
	 * 自定义初始化方法
	 */
	public void init() {
		System.out.println("Car 自定义初始化方法....");
	}

	/**
	 * 自定义销毁方法
	 */
	public void destroy() {
		System.out.println("Car 自定义销毁方法....");
	}
}
