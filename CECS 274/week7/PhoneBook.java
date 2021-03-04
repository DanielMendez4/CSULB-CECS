package week7;

import java.util.Scanner;

public class PhoneBook {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Contact myPB = new Contact();
		System.out.println("What would you like to do to your phone book?");
		System.out.println("OPTIONS:\nType \"ADD\" to add a new contact.\nType \"MODIFY\" to change a contact.\nType \"DELETE\" to delete a contact.\nType \"DISPLAY\" to display a contact.\nType \"DONE\" to exit theh program.");
		String response = "";
		while (!response.equals("DONE")) {
			response = in.nextLine().trim();
			if (response.equals("ADD")) {
				System.out.print("Name of new contact: ");
				String newName = in.nextLine().trim();
				System.out.print("Phone # of new contact: ");
				String newPhone = in.nextLine().trim();
				System.out.print("Email of new contact: ");
				String newEmail = in.nextLine().trim();
				System.out.print("Note for new contact: ");
				String newNote = in.nextLine().trim();
				myPB.add(newName, newPhone, newEmail, newNote);
				continue;
			}
			
			if (response.equals("MODIFY")) {
				System.out.println("What would you like to modify?");
				System.out.println("Type \"NAME\" to change the name.\nType \"PHONE\" to change phone #.\nType \"EMAIL\" to change email.\nType \"NOTE\" to chnage note.");
				String modifier = in.nextLine().trim();
				if (modifier.equals("NAME")) {
					
				}
				if (modifier.equals("PHONE")) {
					
				}
				if (modifier.equals("EMAIL")) {
					
				}
				if (modifier.equals("NOTE")) {
					
				}
			}
			
			if (response.equals("DELETE")) {
				
			}
			
			if (response.equals("DISPLAY")) {
				
			}
			
		}
		
		
		
		
		
		
		in.close();
		
	}
}
