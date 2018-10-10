package com.pickrecalled.config;

import com.pickrecalled.condition.IosCondition;
import com.pickrecalled.condition.LinuxCondition;
import com.pickrecalled.condition.WindowsCondition;
import com.pickrecalled.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalPersonConfig {

	/**
	 * 创建Windows之父 比尔盖茨 对象
	 * @return
	 */
	@Bean("bill")
	@Conditional({ WindowsCondition.class })
	public Person person01() {
		return new Person("Bill Gates", "62");
	}

	/**
	 * 创建Linux之父 林纳斯 对象
	 * @return
	 */
	@Bean("linus")
	@Conditional({ LinuxCondition.class })
	public Person person02() {
		return new Person("Linus", "48");
	}

	/**
	 * 创建IOS之父 乔布斯 对象
	 * @return
	 */
	@Bean("jobs")
	@Conditional({ IosCondition.class })
	public Person person03() {
		return new Person("Jobs", "56");
	}

}
