package com.jkc.aspectoriented.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + " - Adding a Account in MembershipDAO");
	}

	public void putMe() {
		System.out.println(getClass() + "- Put Me is Executing ");
	}

	public void putOn() {
		System.out.println(getClass() + "- Put On is Executing ");
	}

	public void putWith() {
		System.out.println(getClass() + "- Put With is Executing");
	}
	
	public int anyReturnTypeInt(){
		System.out.println(getClass()+" - ANY Return type-------Integer");
		return 5;
	}
	public double anyReturnTypeFloat(){
		System.out.println(getClass()+" - ANY Return type-------Double");
		return 67.5;
	}
	public boolean anyReturnTypeBoolean(){
		System.out.println(getClass()+" - ANY Return type-------Boolean");
		return true;
	}
	public void gotoSleep(){
		System.out.println("Going to Sleep ----------------------------->");
	}
}
