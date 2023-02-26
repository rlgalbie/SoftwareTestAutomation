package com.module3.milestone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*
 * Module 3 assignment
 * Date: 1/22/2023
 * Author: Rebekah Jackson
 */
public class ContactTest {
	
	//Testing object creation
	@Test
	void testContact() {
		Contact contact = new Contact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
		assertTrue(contact.getContactID().equals("TestID1"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Fake Address Ln"));
	}
	
	//Testing that the contact ID cannot be more than 10 characters
	@Test
	void testContactContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestID100014", "John", "Doe", "1234567890","123 Fake Address Ln");
		});
	}
	
	//Testing that the firstName cannot be more than 10 characters
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestID1", "JohnJohnJohn", "Doe", "1234567890","123 Fake Address Ln");
		});
	}
	
	//Testing that the lastName cannot be more than 10 characters
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestID1", "John", "DoeDoeDoeDoe", "1234567890","123 Fake Address Ln");
		});
	}
	
	//Testing that the phone cannot be more than 10 characters
	@Test
	void testContactPhoneNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestID1", "John", "Doe", "1234567890123","123 Fake Address Ln");
		});
	}
		
	//Testing that the phone cannot be less than 10 characters
	@Test
	void testContactPhoneNumTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestID1", "John", "Doe", "123456","123 Fake Address Ln");
		});
	}
	
	//Testing that the address cannot be more than 30 characters
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln123 Fake Address Ln");
		});
	}
}
