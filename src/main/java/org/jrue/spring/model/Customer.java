package org.jrue.spring.model;

public class Customer {

	private String firstName;
	private String lastName;
	private int birthday;
	private Address currentAddress;
	
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
}
