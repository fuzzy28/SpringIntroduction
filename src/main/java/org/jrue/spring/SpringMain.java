package org.jrue.spring;

import org.jrue.spring.model.Customer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Customer customer = context.getBean("customer", Customer.class);
		System.out.printf("Customer Name is %s and he lives at %s\n",customer.getFullName(), customer.getAddress());
		
	}
}
