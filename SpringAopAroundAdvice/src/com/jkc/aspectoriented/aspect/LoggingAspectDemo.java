package com.jkc.aspectoriented.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jkc.aspectoriented.Account;

@Aspect
@Component
@Order(2)
@SuppressWarnings("all")
public class LoggingAspectDemo {
	
	// Around
	@Around("execution(* com.jkc.aspectoriented.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortuneMessage(ProceedingJoinPoint joinPoint) throws Throwable{
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\t Around Advice On Method :" + method);
		System.out.println("\t Around Advice Method Signature :" + signature);
		long begin = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		long timeToTakeMethodToExecute = end-begin;
		System.out.println("\t Method Execution Time : "+timeToTakeMethodToExecute/1000.0+"s");
		return result;
	}
	
	@After("execution(* com.jkc.aspectoriented.dao.AccountDAO.getAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\t After Finally On Method :" + method);
		System.out.println("\t After Finally Method Signature :" + signature);
	}
	
	// throwing value and Throwable name should be same
	@AfterThrowing(pointcut="execution(* com.jkc.aspectoriented.dao.AccountDAO.getAccounts(..))",throwing="exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable exception){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\t After Throwing On Method :" + method);
		System.out.println("\t After Throwing Method Signature :" + signature);
		
		System.out.println("\t Exception is : "+exception);
	}

	/*
	 * returning name and method parameter name should be same List<Account>
	 * result - returned by method returning = result-[same name as above]
	 */
	@AfterReturning(pointcut = "execution(* com.jkc.aspectoriented.dao.AccountDAO.getAccounts(..))", returning = "result")
	public void afterReturningAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\t After Returning On Method :" + method);
		System.out.println("\t After Returning Method Signature :" + signature);
		System.out.println("\t List: " + result);
		// Post Processing ,Modifying the Data
		System.out.println("\t\t-------------------------Result After Postprocessing-----------\t\t ");
		convertAccountNamesToUpperCase(result);
		if (!(result.isEmpty())) {
			System.out.println("\t Result After Processing : " + result);
		}
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		if (!result.isEmpty()) {
			for (Account account : result) {
				String upcase = account.getName().toUpperCase();
				account.setName(upcase);
			}
		}
	}

	@Before("com.jkc.aspectoriented.aspect.CommonAspects.doThisBeforeGetterAndSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {
		System.out.println("\t Before Adding Account Perform Some Action");
		// Display Method Signature and Method Arguments
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		// return returnType qualifiedClassName.methodName(argsType..)
		System.out.println("Method Signature : \t" + methodSignature);

		Object[] arguments = joinPoint.getArgs();
		for (Object arg : arguments) {
			System.out.println("Argument : \t" + arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("\tAccount Name :" + account.getName() + "\t Account Level :" + account.getLevel());
			}
		}
	}
}
