package com.pickrecalled.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class FilterConfig implements TypeFilter {
	@Override
	// MetadataReader：读取到的当前正在扫描的类信息。
	// MetadataReaderFactory：可以获取到其它任何类信息的。
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		// 获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

		// 获取当前正在扫描的类信息（类型是什么，实现什么接口）
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取当前正在扫描的类的名称
		String className = classMetadata.getClassName();
		System.out.println("获取当前正在扫描的类的名称：" + className);

		//实现一个简单的验证返回成功
		if (className.contains("er")) {
			return true;
		}

		// 获取当前类资源信息，资源是指类的路径（比如存在D盘的某个路径下）
		Resource resource = metadataReader.getResource();
		return false;
	}
}
