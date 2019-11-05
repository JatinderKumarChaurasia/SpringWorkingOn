package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonAspects {

	// Those are Shared to others

	// @Pointcut("* com.jkc.aspectoriented.dao.*.*(..)")
	@Pointcut("execution(* com.jkc.aspectoriented.dao.*.*(..))")
	public void forDAOPackage() {
		System.out.println("For DAO Package Executing");
	}

	@Pointcut("execution(* com.jkc.aspectoriented.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.jkc.aspectoriented.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void doThisBeforeGetterAndSetter() {
	}
}
