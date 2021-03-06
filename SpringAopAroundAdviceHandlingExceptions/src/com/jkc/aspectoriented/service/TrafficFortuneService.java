package com.jkc.aspectoriented.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune(){
	    try {
			TimeUnit.MILLISECONDS.sleep(15);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception - In Time Fortune Service");
		//	e.printStackTrace();
		}
		return "morning";
	}

	public String getFortune(boolean trip) {
		if(trip){
			throw new RuntimeException("Exception Is Thrown: Traffic Fortune Service");
		}
		return getFortune();
	}
}
