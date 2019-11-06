package com.jkc.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

	// apply on any class and method present in package com.jkc.controller
	@Pointcut("execution(* com.jkc.controller.*.*(..))")
	public void forControllerPackage() {
		logger.info("\t (-)-(-)-(-) === Running Logger-For Controller Package === (-)-(-)-(-)");
	}

	@Pointcut("execution(* com.jkc.services.*.*(..))")
	public void forServicePackage() {
		logger.info("\t (-)-(-)-(-) === Running Logger-For Services Package === (-)-(-)-(-)");
	}

	@Pointcut("execution(* com.jkc.dao.*.*(..))")
	public void forDAOPackage() {
		logger.info("\t (-)-(-)-(-) === Running Logger-For DAO Package === (-)-(-)-(-)");
	}

	@Pointcut("forControllerPackage() ||forServicePackage() || forDAOPackage()")
	public void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void beforeAppFlow(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String method = signature.toShortString();
		logger.info("\t Before Execution Method Name : " + method);
		logger.info("\t Before Execution Method Signature : " + signature);
		Object[] result = joinPoint.getArgs();
		for(Object res:result){
			logger.info("Argument :"+res);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		Signature signature = joinPoint.getSignature();
		String method = signature.toShortString();
		logger.info("\t After Returning Method Name : " + method);
		logger.info("\t Before Execution Method Signature : " + signature);
		logger.info("\t Result : "+result);
		
	}
}
