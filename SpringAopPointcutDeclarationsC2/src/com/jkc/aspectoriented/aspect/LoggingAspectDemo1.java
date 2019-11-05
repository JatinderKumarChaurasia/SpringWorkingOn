package com.jkc.aspectoriented.aspect;

import org.aspectj.lang.annotation.Before;

/*@Aspect
@Component
*/
public class LoggingAspectDemo1 {

	// only match addAccount of that parameter type(Account)
	@Before("execution(* add*(com.jkc.aspectoriented.Account))")
	// @Before("execution(* add*(Account))")// give error
	public void beforeAddAccountAdvice() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println(getClass() + ": Executing @Before advice on addAccount(Account) =============>");
	}

	@Before("execution(* add*(com.jkc.aspectoriented.Account,..))") // match on
																	// Account
																	// followed
																	// by any
																	// number of
																	// arguments
	public void beforeAddAccountAdvice1() {
		System.out.println("\n");
		System.out.println(getClass()
				+ ": Executing @Before advice on addAccount(Account) followed by any number of args =============>");
	}

	@Before("execution(* add*(..))") // match on any number of arguments
	public void beforeAddAccountAdvice2() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println(getClass() + ": Executing @Before advice on addAccount(multiple) =============>");
	}

}
