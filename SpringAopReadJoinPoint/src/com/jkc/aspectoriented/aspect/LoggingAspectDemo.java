package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jkc.aspectoriented.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspectDemo {

	@Before("com.jkc.aspectoriented.aspect.CommonAspects.doThisBeforeGetterAndSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {
		System.out.println("\t Before Adding Account Perform Some Action");
		// Display Method Signature and Method Arguments
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		// return returnType qualifiedClassName.methodName(argsType..)
		System.out.println("Method Signature : \t"+methodSignature);
		
		Object[] arguments = joinPoint.getArgs();
		for(Object arg:arguments){
			System.out.println("Argument : \t"+arg);
			if(arg instanceof Account){
				Account account = (Account)arg;
				System.out.println("\tAccount Name :"+account.getName()+"\t Account Level :"+account.getLevel());
			}
		}
	}
}
