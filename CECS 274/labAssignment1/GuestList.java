package labAssignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {
	
	public static void printGuestList(ArrayList<String> p) {
		for (String name : p) {
			System.out.printf("%s\n", name);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> guestList = new ArrayList<String>();
		
		Scanner in = new Scanner(System.in);
		String date;
		String event;
		int maxGuest;
		
		System.out.print("Let's get this party started! Enter the date of your event: ");
		date = in.nextLine().trim();
		System.out.print("Good. Now, what would you like to call your event? ");
		event = in.nextLine().trim();
		System.out.print("What is the maximum amount of guests allowed? ");
		maxGuest = Integer.parseInt(in.nextLine().trim());
		System.out.print("Thank you. Please enter the name of each guest followed by \"ENTER\". When you are done, enter \"DONE\".\n");
		String guest;
		do {
			System.out.print("Guest Name: ");
			guest = in.nextLine().trim();
			if (!guest.equals("DONE")) {
				guestList.add(guest);
			}
			
			if (guestList.size() > maxGuest) {
				System.out.println("No more guests can be invited!");
				guestList.remove(guestList.size() - 1);
				break;
			}
				
		} while (!guest.equals("DONE"));
		
		int currentGuests;
		currentGuests = guestList.size();
		System.out.printf("This is the information on your %s event...\nDate: %s\nMax Num. of Guests: %d\nCurrent Num. of Guests: %d\nCurrent Guests:\n", event, date, maxGuest, currentGuests);
		printGuestList(guestList);
		System.out.println("Have a fun party!");
		in.close();
	}
}
