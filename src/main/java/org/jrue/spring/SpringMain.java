package org.jrue.spring;


import java.util.HashSet;
import java.util.Set;

import org.jrue.spring.model.City;
import org.jrue.spring.model.Customer;
import org.jrue.spring.model.Statistics;
import org.jrue.spring.model.Student;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
//		Customer customer = context.getBean("customer", Customer.class);
//		System.out.printf("%s and he lives at %s\n",customer.getFullName(), customer.getAddress());
//		System.out.println("His hobbies are:");
//		for (String hobby : customer.getHobbies()) {
//			System.out.println(hobby);
//		}
//		System.out.println("The books that he already read are");
//		for (String key : customer.getBooksread().keySet()) {
//			System.out.println(key + " by " + customer.getBooksread().get(key));
//		}
//		System.out.println(customer.getMessage());
//		System.out.println(customer.getPIvalue());
//		customer.doPerform();
//		System.out.println(customer.getGlobalMessage());
		
		Student student = context.getBean("student",Student.class);
		student.setName("Joel Ruelos");

		
		System.out.println("Printing big cities");
		Statistics statistics =  context.getBean("statistics", Statistics.class);
		for (City city : statistics.getBigCities()) {
			System.out.println(city.getName() + " " + city.getPopulation());
		}
		System.out.println("\nPrinting big cities by names");
		for (String cityName : statistics.getBigCitiesInName()) {
			System.out.println(cityName);
		}
		City firstBigCity = statistics.getFirstBigCity();
		City lastBigCity = statistics.getLastBigCity();
		System.out.println("\nFirst big city is " + firstBigCity.getName() + " " + firstBigCity.getPopulation());
		System.out.println("last big city is " +lastBigCity.getName() + " " + lastBigCity.getPopulation());
	}
}