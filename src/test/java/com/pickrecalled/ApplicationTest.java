package com.pickrecalled;

import com.pickrecalled.config.PersonConfig;
import com.pickrecalled.config.ScopePersonConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {

	@Test
	public void testScopePerson() {
		// annotation方式获取
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopePersonConfig.class);
		// String[] names = applicationContext.getBeanDefinitionNames();
		// for (String name : names) {
		// System.out.println("当前Spring容器当中的类:" + name);
		// }
		System.out.println("IOC容器创建完成.....");
		// 通过ID第一次获取Person
		Object person1 = applicationContext.getBean("person");
		// 通过ID第二次获取Person
		Object person2 = applicationContext.getBean("person");
		// 两个对象是否相等
		// System.out.println("两个对象是否相等:" + person1.equals(person2));
		System.out.println("两个对象是否相等:" + (person1 == person2));
	}

	@Test
	public void shouldAnswerWithTrue() {
		// xml方式获取
		// ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		// String[] names = applicationContext.getBeanDefinitionNames();
		// for (String name : names) {
		// System.out.println("definitionNames:" + name);
		// }

		// annotation方式获取
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("当前Spring容器当中的类:" + name);
		}
	}
}
