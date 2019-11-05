package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLoggingAsync {
	
	@Before("com.jkc.aspectoriented.aspect.CommonAspects.doThisBeforeGetterAndSetter()")
	public void logToCloudASync() {
		System.out.println("\t Logging to cloud Syncing ----- ");
	}
}
