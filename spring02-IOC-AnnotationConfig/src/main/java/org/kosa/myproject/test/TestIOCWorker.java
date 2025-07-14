package org.kosa.myproject.test;

import org.kosa.myproject.model.Tool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCWorker {
	public static void main(String[] args) {
//		ApplicationContext : Spring IOC Container
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		Tool tool1 = (Tool) factory.getBean("spade");	// IOC의 DL (Dependency Lookup)
		tool1.work();
		
		Tool tool2 = (Tool) factory.getBean("hammer");	// IOC의 DL (Dependency Lookup)
		tool2.work();
		
		factory.close();
	}
}
