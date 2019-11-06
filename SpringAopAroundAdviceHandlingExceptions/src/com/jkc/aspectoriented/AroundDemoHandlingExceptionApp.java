package com.jkc.aspectoriented;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jkc.aspectoriented.dao.AccountDAO;
import com.jkc.aspectoriented.dao.MembershipDAO;
import com.jkc.aspectoriented.service.TrafficFortuneService;

@SuppressWarnings("all")
public class AroundDemoHandlingExceptionApp {

	private static Logger logger = Logger.getLogger(AroundDemoHandlingExceptionApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		logger.info("\t Around Demo Application - Main )-)-)-)-)-)-)");
		logger.info("\t\t Calling Fortune Service");
		boolean trip = true;
		String fortune = fortuneService.getFortune(trip);
		logger.info("\t\t\t Printing Fortune : " + fortune);
		logger.info("Finish");
		context.close();
	}
}
