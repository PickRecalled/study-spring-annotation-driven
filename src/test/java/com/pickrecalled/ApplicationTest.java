package com.pickrecalled;

import static org.junit.Assert.assertTrue;

import com.pickrecalled.config.PersonConfig;
import com.pickrecalled.model.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {

	@Test
	public void shouldAnswerWithTrue() {
		// xml方式获取
		// ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		// Person person = (Person) applicationContext.getBean("person");
		// System.out.println("xml person info:" + person);
		// assertTrue(null != person);

		//annotation方式获取
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println("annotation person info:" + person);
		assertTrue(null != person);
	}
}
