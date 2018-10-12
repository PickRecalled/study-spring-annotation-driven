package com.pickrecalled.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
	@Override
	// 此方法返回值就是导入到容器中的组件全类名
	// AnnotationMetadata:当前标注@Import注解的类的所有注解信息，通过这个可以获取当前类在容器当中所有注解的信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] { "com.pickrecalled.bean.Blue", "com.pickrecalled.bean.Yellow" };
	}
}
