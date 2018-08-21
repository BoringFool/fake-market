package com.zm.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
/*
 * execution的匹配公式千万先仔细写.....,出问题先验证匹配公式总是没有错的new出来的对象不再spring容器里面无法切入，
 * 配置scan和component-scan不 再同一个XML也可能切入不到
 * 
 */
public class FirstAspect {

	@Pointcut(value = "execution(* com.zm.dao.impl.*.name(..))")
	public void pointCut() {

	}

	@Before(value = "pointCut()")
	public void before() {
		System.out.println("前置增强...");
	}

	@After(value = "pointCut()")
	private void after() {
		System.out.println("后置增强...");
	}

}
