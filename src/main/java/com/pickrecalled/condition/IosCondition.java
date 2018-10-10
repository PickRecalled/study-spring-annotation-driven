package com.pickrecalled.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * IOS Condition 判断当前操作系统是不是IOS系统
 */
public class IosCondition implements Condition {
	/**
	 * 确定条件是否匹配
	 * @param context
	 *        判断条件能使用的上下文（也就是我们说的环境）
	 * @param metadata
	 *        当前标注了@Conditional注解的注释信息
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 能获取到IOC容器使用的Bean工厂，beanFactory就是创建对象以及装配的工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

		// 能获取到类的加载器
		ClassLoader classLoader = context.getClassLoader();

		// 能获取到Bean定义的注册的类，也就是说所有Bena定义都在BeanDefinitionRegistry里注册，
		// 在BeanDefinitionRegistry里可以查询，注册，移出一个Bean的定义，还能查询当前容器当中有没有这个Bean的定义等等方法
		BeanDefinitionRegistry registry = context.getRegistry();

		// 能获取到运行环境，它里封装了一些运行时的信息包括环境变量，虚拟机的变量等
		Environment environment = context.getEnvironment();

		// 要判断当前操作系统需要使用Environment
		String osName = environment.getProperty("os.name");
		if (osName.contains("Mac OS X")) {
			return true;
		}
		return false;
	}
}
