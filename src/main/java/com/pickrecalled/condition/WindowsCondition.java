package com.pickrecalled.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Windows Condition 判断当前操作系统是不是Windows系统
 */
public class WindowsCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 能获取到运行环境，它里封装了一些运行时的信息包括环境变量，虚拟机的变量等
		Environment environment = context.getEnvironment();

		// 要判断当前操作系统需要使用Environment
		String osName = environment.getProperty("os.name");
		if (osName.contains("Windows")) {
			return true;
		}
		return false;
	}
}
