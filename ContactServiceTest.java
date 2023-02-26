package com.module3.milestone;
/*
 * Module 3 assignment
 * Date: 1/22/2023
 * Author: Rebekah Jackson
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	//Testing adding a new contact, both creating the contact inline and creating the contact and passing it in, as both methods exist
	@Test
	void testAddContact() {
		ContactService cService = new ContactService();
		Contact contact = new Contact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
		cService.addContact(contact);
		cService.addContact("TestID2", "Jane", "Dawson", "0987654321","321 Address Fake Way");
		//Verifying that the unique contact ID is added to the list
		assertFalse(cService.checkUniqueID(contact.getContactID()));
		assertFalse(cService.checkUniqueID("TestID2"));
	}
	
	//Testing to make sure that all contacts added must have a unique contact ID
	@Test
	void testAddDuplicateContactID() {
		ContactService cService = new ContactService();
		cService.addContact(new Contact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln"));
		//Trying to add contact with same contactID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cService.addContact(new Contact("TestID1", "Jane", "Dawson", "0987654321","321 Address Fake Way"));
		});
	}
	
	//Testing removing a contact using their Unique contact ID
	@Test
	void testRemoveContact() {
		ContactService cService = new ContactService();
		cService.addContact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
		//Verify the contact is added to the list
		assertFalse(cService.checkUniqueID("TestID1"));
		cService.removeContact("TestID1");
		//Verify the contact is removed from the list
		assertTrue(cService.checkUniqueID("TestID1"));
	}
	
	//Testing updating the first name of the Contact
	@Test
	void testUpdateFirstName() {
		ContactService cService = new ContactService();
		cService.addContact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
		//Verify the designated contact's name is John in the list
		assertTrue(cService.getContact("TestID1").getFirstName().equals("John"));
		//Update the contact's first name
		cService.updateFirstName("TestID1", "Jane");
		//Verify the contact's name is changed
		assertTrue(cService.getContact("TestID1").getFirstName().equals("Jane"));
	}
	
	//Testing updating the last name of the Contact
		@Test
		void testUpdateLastName() {
			ContactService cService = new ContactService();
			cService.addContact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
			//Verify the designated contact's last name is Doe in the list
			assertTrue(cService.getContact("TestID1").getLastName().equals("Doe"));
			//Update the contact's last name
			cService.updateLastName("TestID1", "Dawson");
			//Verify the contact's name is changed
			assertTrue(cService.getContact("TestID1").getLastName().equals("Dawson"));
		}

		//Testing updating the phone number of the Contact
		@Test
		void testUpdatePhoneNum() {
			ContactService cService = new ContactService();
			cService.addContact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
			//Verify the designated contact's phone number is correct in the list
			assertTrue(cService.getContact("TestID1").getPhone().equals("1234567890"));
			//Update the contact's phone number
			cService.updatePhoneNumber("TestID1", "0987654321");
			//Verify the contact's phone number is changed
			assertTrue(cService.getContact("TestID1").getPhone().equals("0987654321"));
		}
		
		//Testing updating the phone number of the Contact
		@Test
		void testUpdateAddress() {
			ContactService cService = new ContactService();
			cService.addContact("TestID1", "John", "Doe", "1234567890","123 Fake Address Ln");
			//Verify the designated contact's address is correct in the list
			assertTrue(cService.getContact("TestID1").getAddress().equals("123 Fake Address Ln"));
			//Update the contact's address
			cService.updateAddress("TestID1", "321 Address Fake Way");
			//Verify the contact's address is changed
			assertTrue(cService.getContact("TestID1").getAddress().equals("321 Address Fake Way"));
		}
}
