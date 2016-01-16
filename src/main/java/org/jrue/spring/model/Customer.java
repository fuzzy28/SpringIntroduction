package org.jrue.spring.model;

import java.util.Map;
import java.util.Set;

import org.jrue.spring.annotations.qualifier.CurrentAddress3;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class Customer implements  BeanNameAware,BeanFactoryAware, ApplicationContextAware,InitializingBean, DisposableBean {

	private String firstName;
	private String lastName;
	private int birthday;
	@Autowired
	@Qualifier(value="currentAddress2")
	private Address currentAddress;
	private Set<String> hobbies;
	private Map<String,String> booksread;
	private String message;
	private double PIvalue;
	@Autowired
	@Qualifier(value="jingleBells")
	private Performer perform;
	@Value("#{systemProperties['global.message']}")
	private String globalMessage;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public String getFullName() {
		return String.format("%s %s", firstName , lastName);
	}
	public Address getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getAddress() {
		return currentAddress.getFullAddress();
	}
	public double getPIvalue() {
		return PIvalue;
	}
	public void setPIvalue(double pIvalue) {
		PIvalue = pIvalue;
	}
	public Set<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getBooksread() {
		return booksread;
	}
	public void setBooksread(Map<String, String> booksread) {
		this.booksread = booksread;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//test spring expression language (SpEL)
	public String sayHi() {
		return "Hi guys! :)";
	}
	
	public void doPerform() {
		perform.perform();
	}
	
	//defines life cycle of bean
	public void initMethod() {
		System.out.println("5.Customer bean has been initialized");
	}
	public void destroyMethod() {
		System.out.println("Customer bean has been destroyed");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("4.Customer bean after properties set has been called");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Customer bean destroy has been called");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("3. Setting application context");
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("2. Setting bean factory ");
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("1. Setting bean name " + name);
	}
	public String getGlobalMessage() {
		return globalMessage;
	}
	public void setGlobalMessage(String globalMessage) {
		this.globalMessage = globalMessage;
	}
	
}
