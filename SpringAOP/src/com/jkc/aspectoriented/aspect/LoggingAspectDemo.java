package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.annotation.Before;

//@Aspect // annotates that it is aspect
//@Component
public class LoggingAspectDemo {

	// @Before(pointcut expression)
	/*
	 * execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
	 * method-name-pattern(param-pattern) throws-pattern?) here the pattern
	 * having ? is optional pattern use wildcards :?*(matches on everything)
	 */
	/*
	 * here execution is the expression pointcut modifier-pattern : public
	 * return-type-pattern: void method-name-pattern: addAccount
	 * declaring-type-pattern: com.jkc.aspectoriented.dao.AccountDAO
	 **/

	@Before("execution(public void com.jkc.aspectoriented.dao.AccountDAO.addAccount())") // match
																							// only
																							// on
																							// AccountDAO
																							// methods
	// @Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println(getClass() + ": Executing @Before advice on addAccount() =============>");
	}

	// any method starting with put word
	@Before("execution(public void put*())")
	public void beforePutAdvice() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Executing @Before Advice on Methods starting with put word ============>");
	}

	// any return type
	@Before("execution(public * any*())")
	public void beforeAnyAdviceWithAnyReturnType() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------------");
		System.out
				.println("Executing @Before Advice on Methods starting with any word and any return type============>");
	}

	@Before("execution(* com.jkc.aspectoriented.dao.*.*(..))")
	public void anyMethodAnyReturnTypeOfPackageWithAnyNumOfArguments() {
		System.out.println("Executing any Method with Any Return Type OfPackage With Any Number Of Arguments======>");
	}
}
