package com.jkc.aspectoriented.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addAnyMember() {
		System.out.println(getClass() + " Adding A Member");
		return true;
	}

	public void gotoSleep() {
		System.out.println(getClass() + "Going to Sleep ----------------->");
	}
}
