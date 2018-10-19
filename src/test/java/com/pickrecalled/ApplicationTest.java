package com.pickrecalled;

import com.pickrecalled.bean.Blue;
import com.pickrecalled.bean.Boss;
import com.pickrecalled.bean.Car;
import com.pickrecalled.bean.Color;
import com.pickrecalled.config.*;
import com.pickrecalled.model.Person;
import com.pickrecalled.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class ApplicationTest {

	@Test
	public void testProfile() {
		// 1.创建容器对象
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 2.设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		// 3.注册主配置类
		applicationContext.register(ProfileConfig.class);
		// 4.启动刷新容器
		applicationContext.refresh();

		// String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		// for (String name : beanNamesForType) {
		// System.out.println("当前Spring容器当中组件名称:" + name);
		// }
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("当前Spring容器当中组件名称:" + beanDefinitionName);
		}
	}

	@Test
	public void testAutowiredMethod() {
		// 创建IOC容器
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println("容器当中Boss的Car：" + boss);

		Car car = applicationContext.getBean(Car.class);
		System.out.println("容器当中Car：" + car);

		Color color = applicationContext.getBean(Color.class);
		System.out.println("容器当中Color的Car：" + color);

	}

	@Test
	public void testAutowired() {
		// 创建IOC容器
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);

		BookServiceImpl bookService = applicationContext.getBean(BookServiceImpl.class);
		System.out.println("BookServiceImpl中的BookDao：" + bookService);

		// BookDao bookDao = applicationContext.getBean(BookDao.class);
		// System.out.println("BookDao中的Dao：" + bookDao);

		// 获取容器当中的Bean
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("当前Spring容器当中组件名称:" + name);
		}

	}

	@Test
	public void testValue() {
		// 创建IOC容器
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValuePersonConfig.class);

		// 获取容器当中的Bean
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("当前Spring容器当中组件名称:" + name);
		}

		// 获取容器当中的对象
		Person person = (Person) applicationContext.getBean("person");
		System.out.println("获取到person对象：" + person);

		// 获取运行时环境变量
		Environment environment = applicationContext.getEnvironment();
		String nickName = environment.getProperty("nick.name");
		System.out.println("通过运行时环境变量获取properties文件中的值：" + nickName);

		// 关闭容器
		((AnnotationConfigApplicationContext) applicationContext).close();
	}

	@Test
	public void testBeanLeftCycle() {
		// 创建IOC容器
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleBeanConfig.class);
		System.out.println("容器创建完成....");

		// 获取car对象
		Object car = applicationContext.getBean("car");
		System.out.println("获取car对象：" + car);

		// 关闭容器
		((AnnotationConfigApplicationContext) applicationContext).close();
	}

	@Test
	public void testFactoryBean() {
		// annotation方式获取
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("当前Spring容器当中组件名称:" + name);
		}

		Object colorBean = applicationContext.getBean("colorFactoryBean");
		System.out.println("colorFactoryBean的类型：" + colorBean.getClass());

		Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
		System.out.println("colorFactoryBean本身的类型：" + colorFactoryBean.getClass());

		Object bean1 = applicationContext.getBean("colorFactoryBean");
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		System.out.println("Bean工厂创建的对象是否相等：" + (bean1 == bean2));

	}

	@Test
	public void testImport() {
		// annotation方式获取
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("当前Spring容器当中组件名称:" + name);
		}
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println("从容器中获取Blue对象：" + bean);
	}

	@Test
	public void testConditionalPerson() {
		// annotation方式获取
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalPersonConfig.class);

		// 获取IOC的运行环境
		Environment environment = applicationContext.getEnvironment();

		// 在当前IOC环境当中获取操作系统名称的变量
		String osName = environment.getProperty("os.name");
		System.out.println("IOC容器当中获取到当前操作系统的名称：" + osName);

		// 按类型获取容器当中所有person的定义
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String names : beanNamesForType) {
			System.out.println("容器当中存在的Person对象名：" + names);
		}

		// 按类型获取容器当中所有person的对象
		Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
		System.out.println("容器当中存在的Person对象：" + beansOfType);

	}

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
