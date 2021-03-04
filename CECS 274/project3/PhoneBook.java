package project3;

import java.util.ArrayList;

public class PhoneBook {
	
	private ArrayList<Contact> fullContact;
	private Contact myContact;

    public PhoneBook() {
    	fullContact = new ArrayList<Contact>();
    	myContact = new Contact();
    }
    
	/**
	* Adds a contact to fullContact
	**/
	public void addContact(String name, String phoneNum, String email, String note) {
		myContact = new Contact(name, phoneNum, email, note);
		fullContact.add(myContact);
	}
	
	/**
	* Edits a contact's name from fullContact
	**/
	public void editName(String existName, String replaceName) {
		for (int i = 0; i < fullContact.size(); i++) {
			if (fullContact.get(i).getName().equals(existName)) {
				fullContact.get(i).setName(replaceName);
				break;
			}
		}
	}
	
	/**
	* Edits a contact's phone # from fullContact
	**/
	public void editPhone(String existPhone, String replacePhone) {
		for (int i = 0; i < fullContact.size(); i++) {
			if (fullContact.get(i).getPhoneNum().equals(existPhone)) {
				fullContact.get(i).setPhoneNum(replacePhone);
				break;
			}
		}
	}
	
	/**
	* Edits a contact's email from fullContact
	**/
	public void editEmail(String existEmail, String replaceEmail) {
		for (int i = 0; i < fullContact.size(); i++) {
			if (fullContact.get(i).getEmail().equals(existEmail)) {
				fullContact.get(i).setEmail(replaceEmail);
				break;
			}
		}
	}
	
	/**
	* Edits a contact's note from fullContact
	**/
	public void editNote(String existNote, String replaceNote) {
		for (int i = 0; i < fullContact.size(); i++) {
			if (fullContact.get(i).getNote().equals(existNote)) {
				fullContact.get(i).setNote(replaceNote);
				break;
			}
		}
	}
	
	/**
	* Deletes a contact from fullContact
	**/
	public void deleteContact(String delName, String delPhoneNum, String delEmail, String delNote) {
		for (int i = 0; i < fullContact.size(); i++) {
			if (fullContact.get(i).getName().equals(delName) && fullContact.get(i).getPhoneNum().equals(delPhoneNum) && fullContact.get(i).getEmail().equals(delEmail) && fullContact.get(i).getNote().equals(delNote)) {
				fullContact.remove(i);
				break;
			}
		}
	}
	
	/**
	* Displays all contacts from fullContact
	**/
	public void displayContact() {
		for (int i = 0; i < fullContact.size(); i++) {
			System.out.println(fullContact.get(i));
		}
	}
	
	/**
	 * Shows whether the contact exists in the phone book
	 * @return find: true if the contact is in phone book/ false if not in the phone book
	 * **/
	public boolean doesExist(String name) {
		boolean find = false;
		for (int i = 0; i < fullContact.size(); i++) {
			if(fullContact.get(i).getName().equals(name)) {
				find = true;
			} else {
				find = false;
			}
		 }
		 return find;
	 }
}