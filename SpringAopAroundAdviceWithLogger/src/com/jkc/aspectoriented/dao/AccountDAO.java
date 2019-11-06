package com.jkc.aspectoriented.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jkc.aspectoriented.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> getAccounts(boolean trip) {
		
		if(trip){
			throw new RuntimeException("Found A Runtime Exception (-)-)-(-)-)-(-)");
		}
		List<Account> accounts = new ArrayList<>();
		Account account = new Account("Abc", "M");
		Account account1 = new Account("DEF", "H");
		Account account2 = new Account("GHI", "B");
		Account account3 = new Account("JKL", "M");
		accounts.add(account);
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}

	public void addAccount(Account account, boolean flag) {
		System.out.println("Saving Account" + account + " with flag:" + flag);
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
