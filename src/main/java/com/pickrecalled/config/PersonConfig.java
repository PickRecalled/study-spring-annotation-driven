package com.pickrecalled.config;

import com.pickrecalled.model.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//排除@Controller标注的组件
//@ComponentScan(value = "com.pickrecalled", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Controller.class })})

//只包含@Controller标注的组件，注意需要配置useDefaultFilters = false
//@ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) })

//JDK8版本@ComponentScan是被@Repeatable注解标签标注的，可以重复出现多次
/*@ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) })
@ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Repository.class }) })*/

//扫描包策略标签
@ComponentScans(value = {
        @ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }),
        @ComponentScan(value = "com.pickrecalled", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Service.class }) })
})
public class PersonConfig {

	@Bean
	public Person person() {
		return new Person("王五", "10");
	}
}
