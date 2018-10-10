package com.pickrecalled.config;

import org.springframework.beans.factory.FactoryBean;

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

	@Override
	// 返回一个Color对象，这个对象会添加到容器当中
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean调用getObject创建对象并添加到容器当中。。。。");
		// 简单的new 返回一个Color 对象
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	@Override
	// 返回是否单实例，true:这个Bean是单实例，在容器中只保留一份；false:多实例每次都会创建一次
	public boolean isSingleton() {
		return true;
		// return false;
	}
}
