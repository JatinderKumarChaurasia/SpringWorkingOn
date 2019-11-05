package com.jkc.aspectoriented;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jkc.aspectoriented.dao.AccountDAO;
import com.jkc.aspectoriented.dao.MembershipDAO;

@SuppressWarnings("all")
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		Account account = new Account();
		account.setName("Raom");
		account.setLevel("M");
		accountDAO.addAccount(account, false);
		accountDAO.doWork();
		accountDAO.setName("Abnsm");
		accountDAO.setServiceCode("3443");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		membershipDAO.addAnyMember();
		membershipDAO.gotoSleep();
		context.close();
	}

}
