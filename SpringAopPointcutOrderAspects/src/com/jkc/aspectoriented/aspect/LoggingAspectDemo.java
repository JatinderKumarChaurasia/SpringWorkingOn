package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspectDemo {

	@Before("com.jkc.aspectoriented.aspect.CommonAspects.doThisBeforeGetterAndSetter()")
	public void beforeAddAccount() {
		System.out.println("\t Before Adding Account Perform Some Action");
	}
}
