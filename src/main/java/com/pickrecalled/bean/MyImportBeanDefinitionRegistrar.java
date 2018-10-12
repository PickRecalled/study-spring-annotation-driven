package com.pickrecalled.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 查看容器当中是否有com.pickrecalled.config.Red与com.pickrecalled.config.Blue组件的定义
		boolean redb = registry.containsBeanDefinition("com.pickrecalled.bean.Red");
		boolean blueb = registry.containsBeanDefinition("com.pickrecalled.bean.Blue");
		// 满足要求向容器注册自定义的组件
		if (redb && blueb) {
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);
		}
	}
}
