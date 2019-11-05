package com.jkc.aspectoriented;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jkc.aspectoriented.dao.AccountDAO;
import com.jkc.aspectoriented.dao.MembershipDAO;
import com.jkc.aspectoriented.service.TrafficFortuneService;

@SuppressWarnings("all")
public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("\t Around Demo Application - Main )-)-)-)-)-)-)");
		System.out.println("\t\t Calling Fortune Service");
		String fortune = fortuneService.getFortune();
		System.out.println("\t\t\t Printing Fortune : "+fortune);
		context.close();
	}

}
