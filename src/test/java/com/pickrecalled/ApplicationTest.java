package com.pickrecalled;

import com.pickrecalled.config.PersonConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {

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
