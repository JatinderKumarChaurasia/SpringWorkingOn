package com.jkc.aspectoriented;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jkc.aspectoriented.dao.AccountDAO;
import com.jkc.aspectoriented.dao.MembershipDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		accountDAO.addAccount();
		// System.out.println("Adding Account ");
		// accountDAO.addAccount(new
		// Account(1,"Ramesh","Pandiwala","beginner"));
		// accountDAO.addAccount(1,2,4,5,6,7);
		accountDAO.addAccount(new Account(), false);
		
		membershipDAO.addAccount();
		/*
		 * membershipDAO.putMe(); membershipDAO.putWith();
		 * membershipDAO.putOn(); membershipDAO.anyReturnTypeBoolean();
		 * membershipDAO.anyReturnTypeFloat(); membershipDAO.anyReturnTypeInt();
		 */
		membershipDAO.gotoSleep();
		Account account = new Account();
		account.setId(34);
		account.setFirstName("This Is Me");
		account.setLastName("Means");
		account.setLevel("beginner");
		System.out.println("Now Getting The Data");
		account.getFirstName();
		account.getLastName();
		account.getLevel();
		account.getId();
		context.close();

	}

}
