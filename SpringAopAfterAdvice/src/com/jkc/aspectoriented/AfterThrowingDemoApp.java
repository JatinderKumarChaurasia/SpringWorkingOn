package com.jkc.aspectoriented;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jkc.aspectoriented.dao.AccountDAO;
import com.jkc.aspectoriented.dao.MembershipDAO;

@SuppressWarnings("all")
public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		List<Account> accounts = null;
		try {
			// to simulate exception
			boolean trip = true;
			accounts = accountDAO.getAccounts(trip);
		} catch (Exception e) {
			System.out.println("\t Catch Exception - In Main Program _)-)-)-)-)-)-)-)-)-)-)" + e);
		}
		// List<Account> accounts = accountDAO.getAccounts();
		System.out.println("\t MainApp - After Throwing List of Accounts ---");
		System.out.println("\t --------------------------");
		System.out.println("\t " + accounts);
		context.close();
	}

}
