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

	@Before("forDAOPackage()")
	public void custome1() {
		System.out.println("For Custome 1 Package");
	}

	@Before("forDAOPackage()")
	public void custome2() {
		System.out.println("For Custome 2 Package");
	}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void doThisBeforeGetterAndSetter(){
		//System.out.println("Executing GETTER AND SETTER\n");
	}
	@Before("doThisBeforeGetterAndSetter()")
	public void doWork(){
		System.out.println("Doing Work with Getter and Setter");
	}

	@Before("forDAOPackage()")
	public void custome3() {
		System.out.println("For Custome 3 Package");
	}
}
