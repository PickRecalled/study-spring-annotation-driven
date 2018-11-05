package com.pickrecalled.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 日志类切面类
 */
@Aspect
public class LogAspects {

	@Pointcut("execution(public int com.pickrecalled.aop.MathCalculator.*(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void logStart(JoinPoint joinPoint) {
		// joinPoint.getSignature() 方法签名
		// joinPoint.getSignature().getName()获取方法名
		// joinPoint.getArgs()获取参数列表
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName() + "运行....参数列表:{" + Arrays.asList(args) + "}");
	}

	@After("com.pickrecalled.aop.LogAspects.pointcut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "结束....");
	}

	@AfterReturning(value = "pointcut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + "返回....运行结果:{" + result + "}");
	}

	@AfterThrowing(value = "com.pickrecalled.aop.LogAspects.pointcut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(joinPoint.getSignature().getName() + "异常....异常信息:{" + exception + "}");
	}
}
