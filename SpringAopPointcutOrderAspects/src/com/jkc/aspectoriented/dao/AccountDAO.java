package com.jkc.aspectoriented.dao;

import org.springframework.stereotype.Component;

import com.jkc.aspectoriented.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account account,boolean flag){
		System.out.println("Saving Account"+account+" with flag:"+flag);
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing Some Work -- doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName(String name)");
		this.name = name;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode(String serviceCode)");
		this.serviceCode = serviceCode;
	}
	
}
