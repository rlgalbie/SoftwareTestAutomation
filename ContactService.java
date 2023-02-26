package com.module3.milestone;

import java.util.ArrayList;
/*
 * Module 3 assignment
 * Date: 1/22/2023
 * Author: Rebekah Jackson
 */
public class ContactService {
	public ArrayList<Contact> contactList; 
	
	public ContactService() {
		contactList = new ArrayList<Contact>();
	}
	
	//Add a new contact to the list. If the chosen contact ID already exists in the list, an error is thrown
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		if(checkUniqueID(contactID)) {
			contactList.add(new Contact(contactID, firstName, lastName, phone, address));
		}else {
			throw new IllegalArgumentException("Duplicate contactID");
		}
	}
	
	//Add a new contact to the list. If the chosen contact ID already exists in the list, an error is thrown
	public void addContact(Contact contact) {
		if(checkUniqueID(contact.getContactID())) {
			contactList.add(new Contact(contact.getContactID(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getAddress()));
		}else {
			throw new IllegalArgumentException("Duplicate contactID");
		}
	}
	
	//Finds the specified contact in the contactList and removes it
	public void removeContact(String contactID) {
		Contact toDelete = null;
		for(Contact contact : contactList) {
			if(contactID.equalsIgnoreCase(contact.getContactID())) {
				toDelete = contact;
				break;
			}
		}
		contactList.remove(toDelete);
	}
	
	//Method to iterate through the contactList to find the user based on contactID and update the firstName to the new value
	public void updateFirstName(String contactID, String firstName) {
		for(Contact contact : contactList) {
			if(contactID.equalsIgnoreCase(contact.getContactID())) {
				contact.setFirstName(firstName);
				break;
			}
		}
	}
	
	//Method to iterate through the contactList to find the user based on contactID and update the lastName to the new value
	public void updateLastName(String contactID, String lastName){
		for(Contact contact : contactList) {
			if(contactID.equalsIgnoreCase(contact.getContactID())) {
				contact.setLastName(lastName);
				break;
			}
		}
	}
	
	//Method to iterate through the contactList to find the user based on contactID and update the phone number to the new value
	public void updatePhoneNumber(String contactID, String phone){
		for(Contact contact : contactList) {
			if(contactID.equalsIgnoreCase(contact.getContactID())) {
				contact.setPhone(phone);
				break;
			}
		}
	}
	
	//Method to iterate through the contactList to find the user based on contactID and update the address to the new value
	public void updateAddress(String contactID, String address) {
		for(Contact contact : contactList) {
			if(contactID.equalsIgnoreCase(contact.getContactID())) {
				contact.setAddress(address);
				break;
			}
		}
	}
	
	//Iterate through the contactList, and if we encounter a duplicate ID, return false. Otherwise the new ID is unique and return true
	public boolean checkUniqueID(String contactID) {
		for (Contact c : contactList) {
			if(c.getContactID().equalsIgnoreCase(contactID)) {
				return false;
			}
		}
		return true;
	}
	
	//Iterate through the contactList and return a copy of the desired contact from the list
	public Contact getContact(String contactID) {
		Contact copy = null;
		for(Contact contact : contactList) {
			if(contactID.equalsIgnoreCase(contact.getContactID())) {
				copy = contact;
				break;
			}
		}
		return copy;
				
	}
}
