package com.museum.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.museum.domain.Activity;
import com.museum.domain.ActivityType;
//import com.museum.service.IActivityService;
import com.museum.service.INewsService;

public class App {
	
	@Test
	public void test() throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//IActivityService service = (IActivityService) ctx.getBean("activityServiceImpl");
		
		Date date = new Date();
		ActivityType ay = new ActivityType();
		ay.setActivityTypeId(1);
		ay.setActivityTypeName("111");
		
		Activity n = new Activity();
		n.setActivityImage("download/001.jpg");
		n.setActivityAbstract("111");
		n.setActivityContext("111");
		n.setActivityTime(date);
		n.setActivityTitle("111");
		n.setActivityState("111");
		n.setActivityTimeEnd(date);
		n.setActivityContext("11111111111111111111111111111111111");
		n.setActivityTimeStart(date);
		n.setActivityType(ay);
		
		
		//service.save(n);
	}
	
//	@Test
//	public void test2()throws Exception{
//		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		INewsService service = (INewsService) ctx.getBean("newsServiceImpl");
//		
//		
//		service.delete(7);
//	}
//	
}
