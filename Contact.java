package com.module3.milestone;
/*
 * Module 3 assignment
 * Date: 1/22/2023
 * Author: Rebekah Jackson
 */
public class Contact {
	private String contactID, firstName, lastName, phone, address;
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		//Checking that the contactID is 10 characters or less, and not null otherwise, throw an exception
		if(validateLength(contactID, 10) && contactID != null) {
			this.contactID = contactID;
		}else {
			throw new IllegalArgumentException("Invalid contactID");
		}
		//Checking that the firstName is 10 characters or less, and not null otherwise, throw an exception
		if(validateLength(firstName, 10) && firstName != null) {
			this.firstName = firstName;
		}else {
			throw new IllegalArgumentException("Invalid firstName");
		}
		//Checking that the lastName is 10 characters or less, and not null otherwise, throw an exception
		if(validateLength(lastName, 10) && lastName != null) {
			this.lastName = lastName;
		}else {
			throw new IllegalArgumentException("Invalid lastName");
		}
		//Checking that the phone is exactly 10 characters, and not null otherwise, throw an exception
		if(phone.length() == 10 && phone != null) {
			this.phone = phone;
		}else {
			throw new IllegalArgumentException("Invalid phone");
		}
		//Checking that the address is 30 characters or less, and not null otherwise, throw an exception
		if(validateLength(address, 30) && address != null) {
			this.address = address;
		}else {
			throw new IllegalArgumentException("Invalid address");
		}
	}
	
	//Getters and setters for each field
	public String getContactID() {
		return contactID;
	}

	//Validates that contactID is 10 characters or less otherwise throw an exception
	public void setContactID(String contactID) {
		if(validateLength(contactID,10)) {
			this.contactID = contactID;
		}else {
			throw new IllegalArgumentException("Invalid contactID");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	//Validates that firstName is 10 characters or less otherwise throw an exception
	public void setFirstName(String firstName){
		if(validateLength(firstName,10)) {
			this.firstName = firstName;
		}else {
			throw new IllegalArgumentException("Invalid firstName");
		}
	}

	public String getLastName() {
		return lastName;
	}

	//Validates that lastName is 10 characters or less otherwise throw an exception
	public void setLastName(String lastName){
		if(validateLength(lastName,10)) {
			this.lastName = lastName;
		}else {
			throw new IllegalArgumentException("Invalid lastName");
		}
	}

	public String getPhone() {
		return phone;
	}
	
	//Validates that phone is exactly 10 characters otherwise throw an exception
	public void setPhone(String phone){
		if(phone.length() == 10) {
			this.phone = phone;
		}else {
			throw new IllegalArgumentException("Invalid phone");
		}
	}

	public String getAddress() {
		return address;
	}

	//Validates that address is 30 characters or less otherwise throw an exception
	public void setAddress(String address) {
		if(validateLength(address,30)) {
			this.address = address;
		}else {
			throw new IllegalArgumentException("Invalid address");
		}
	}

	//This method validates if a string is less than the designated int value, and returns a boolean. Used for field validation
	public static boolean validateLength(String string, int length) {
		return string.length() <= length;
	}
}
