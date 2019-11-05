package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectDemo2 {

	// @Pointcut("* com.jkc.aspectoriented.dao.*.*(..)")
	@Pointcut("execution(* com.jkc.aspectoriented.dao.*.*(..))")
	private void forDAOPackage() {
		System.out.println("For DAO Package Executing");
	}

	@Pointcut("execution(* com.jkc.aspectoriented.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.jkc.aspectoriented.dao.*.set*(..))")
	private void setter() {
	}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void doThisBeforeGetterAndSetter(){
		// for DAO Package No Getter and Setter
		//System.out.println("Executing GETTER AND SETTER\n");
	}
	
	@Before("doThisBeforeGetterAndSetter()")
	public void beforeAddAccount(){
		System.out.println("Before Adding Account Perform Some Action");
	}
	
	@Before("doThisBeforeGetterAndSetter()")
	public void performAPIAnalytics(){
		System.out.println("Performing API Analytics -------------");
	}
	@Before("doThisBeforeGetterAndSetter()")
	public void doWork(){
		System.out.println("Doing Work with Getter and Setter");
	}

}
