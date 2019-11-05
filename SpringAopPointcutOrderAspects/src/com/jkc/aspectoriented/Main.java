package com.jkc.aspectoriented;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jkc.aspectoriented.dao.AccountDAO;
import com.jkc.aspectoriented.dao.MembershipDAO;

@SuppressWarnings("all")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		accountDAO.addAccount(new Account(), false);
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
