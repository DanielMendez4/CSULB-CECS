package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * This program models a phone book.
 * Allows user to store, edit, and delete contacts.
 * **/
public class ArrayListDemo {

	public static void printPhoneBook(ArrayList<String> p) {
		Collections.sort(p);
		int i = 1;
		for(String name : p) {
			System.out.printf("%d. %s\n",  i ,name);
			i++;
		}
	}
		
	public static void main(String[] args) {
		
		ArrayList<String> contacts = new ArrayList<String>();
		
		Scanner in = new Scanner(System.in);
		String response;
		do {
			System.out.println("Please enter a new contact followed by \"Enter\". Type \"Done\" when finished.");
			response = in.nextLine().trim();
			if(!response.equals("Done")) {
				contacts.add(response);
			}
		} while (!response.equals("Done"));
		
		//GOAL: GIVE USER OPTIONS TO VIEW CONTACTS, EDIT OR DELETE CONTACT
		
		String menu = "Select an option:\n1. View Contacts\n2. Edit a contact\n3. Delete a contact\n4. Exit.";
		int option;
		do {
			System.out.println(menu);
			option = Integer.parseInt(in.nextLine());
			
			if(option ==1) { //View contacts
				printPhoneBook(contacts);
			}
			else if (option ==2) { //Edit a contact
				printPhoneBook(contacts);
				System.out.println("Select the contact you wish to edit: ");
				int c = Integer.parseInt(in.nextLine().trim()); //Number of contact to edit
				System.out.print("Enter the new information: ");
				String newInfo = in.nextLine().trim();
				contacts.set(c-1, newInfo);	
			}
			else if(option == 3) { //Delete a contact
				printPhoneBook(contacts);
				System.out.println("Select the contact you wish to delete: ");
				int c = Integer.parseInt(in.nextLine().trim());
				contacts.remove(c-1); //Removing the appropriate element
			}
			else if (option > 4 || option < 1) {
				System.out.println("Invalid selection.");
			}
			
		} while(option!=4);
		
		in.close();
		
//		printPhoneBook(contacts); //To check if contacts were added
//		contacts.add("Daniel Mendez - (111)111-1111");
//		contacts.add("Dan Mendez - (111)111-1111");
//		contacts.add("Daniel Menendez - (111)111-1111");
//		printPhoneBook(contacts);
	}
}
