package com.GCappps.loanFin.app;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class GCapppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GCapppsApplication.class, args);

	
	
		

//		ObjectMapper om=new ObjectMapper();
//		try {
//			System.out.println(om.writeValueAsString(new Customer()));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		Date date=new Date();
//		int startingmonth=date.getYear();
//		System.out.println(startingmonth);
//		System.out.println(date); 
//		}
		
	}

}
