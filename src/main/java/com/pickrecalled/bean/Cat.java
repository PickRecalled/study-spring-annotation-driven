package com.pickrecalled.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;


@Resource
public class Cat implements InitializingBean, DisposableBean {

	/**
	 * 构造器
	 */
	public Cat() {
		System.out.println("Cat 对象构建调用构造器.....");
	}

	/**
	 * IOC容器关闭调用
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("Cat 销毁方法....");
	}

	/**
	 * Bean 创建完成并且Bean所以有属性设值完后调用
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Cat 初始化方法....");
	}
}