package com.jkc.aspectoriented.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jkc.aspectoriented.Account;

@Component
public class AccountDAO {

	List<Account> accounts = new ArrayList<>();
	public void addAccount(){
		System.out.println(getClass()+" - Adding a Account");
	}
	
	public void addAccount(Account account){
		accounts.add(account);
		System.out.println("Saving Account"+account);
	}
	public void addAccount(Account account,boolean flag){
		accounts.add(account);
		System.out.println("Saving Account"+account+" with flag:"+flag);
	}
	public boolean addAccount(int... Arr){
		for(int i:Arr){
			System.out.println("Printed Message:"+i);
		}
		return true;
	}
	

}
