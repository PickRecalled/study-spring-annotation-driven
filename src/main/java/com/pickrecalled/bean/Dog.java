package com.pickrecalled.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Resource
public class Dog implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 * 构造器
	 */
	public Dog() {
		System.out.println("Dog 对象构造调用构造器......");
	}

	/**
	 * 对象创建并赋值之后调用
	 */
	@PostConstruct
	public void init() {
		System.out.println("Dog  @PostConstruct ......");
	}

	/**
	 * 容器移出对象之前回调
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("Dog  @PreDestroy ......");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
