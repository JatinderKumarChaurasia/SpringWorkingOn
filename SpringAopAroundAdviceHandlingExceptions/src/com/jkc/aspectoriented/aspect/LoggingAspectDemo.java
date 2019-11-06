package com.jkc.aspectoriented.aspect;

import java.util.List;
import java.util.logging.Logger;

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

	private static Logger logger = Logger.getLogger(LoggingAspectDemo.class.getName());

	// Around
	@Around("execution(* com.jkc.aspectoriented.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortuneMessage(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		logger.info("\t Around Advice On Method :" + method);
		logger.info("\t Around Advice Method Signature :" + signature);
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			logger.warning("Loggine Aspect Demo: "+e.getMessage());
			//result = "Facing Undefined Problem";
			// re-throwing the Exception
			throw e;
		}
		long end = System.currentTimeMillis();
		long timeToTakeMethodToExecute = end - begin;
		logger.info("\t Method Execution Time : " + timeToTakeMethodToExecute / 1000.0 + "s");
		return result;
	}

	@After("execution(* com.jkc.aspectoriented.dao.AccountDAO.getAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		logger.info("\t After Finally On Method :" + method);
		logger.info("\t After Finally Method Signature :" + signature);
	}

	// throwing value and Throwable name should be same
	@AfterThrowing(pointcut = "execution(* com.jkc.aspectoriented.dao.AccountDAO.getAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		logger.info("\t After Throwing On Method :" + method);
		logger.info("\t After Throwing Method Signature :" + signature);

		logger.info("\t Exception is : " + exception);
	}

	/*
	 * returning name and method parameter name should be same List<Account>
	 * result - returned by method returning = result-[same name as above]
	 */
	@AfterReturning(pointcut = "execution(* com.jkc.aspectoriented.dao.AccountDAO.getAccounts(..))", returning = "result")
	public void afterReturningAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String method = joinPoint.getSignature().toShortString();
		logger.info("\t After Returning On Method :" + method);
		logger.info("\t After Returning Method Signature :" + signature);
		logger.info("\t List: " + result);
		// Post Processing ,Modifying the Data
		logger.info("\t\t-------------------------Result After Postprocessing-----------\t\t ");
		convertAccountNamesToUpperCase(result);
		if (!(result.isEmpty())) {
			logger.info("\t Result After Processing : " + result);
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
		logger.info("\t Before Adding Account Perform Some Action");
		// Display Method Signature and Method Arguments
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		// return returnType qualifiedClassName.methodName(argsType..)
		logger.info("Method Signature : \t" + methodSignature);

		Object[] arguments = joinPoint.getArgs();
		for (Object arg : arguments) {
			logger.info("Argument : \t" + arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				logger.info("\tAccount Name :" + account.getName() + "\t Account Level :" + account.getLevel());
			}
		}
	}
}
