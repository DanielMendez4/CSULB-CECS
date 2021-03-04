package project3;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class CellPhoneTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		CellPhone myCell = new CellPhone();
		Log myLog = new Log();
		ArrayList<String[]> fullLog = new ArrayList<String[]>();
        String toLog[] = new String[4];
		System.out.println("What would you like to do on your cell phone?");
		System.out.println("---OPTIONS---\n"
				+ "Type \"ADD\" to add a new contact.\n"
				+ "Type \"EDIT\" to edit a contact.\n"
				+ "Type \"DELETE\" to delete a contact.\n"
				+ "Type \"DISPLAY\" to display a contact.\n"
				+ "Type \"MAKECALL\" to make a contact.\n"
				+ "Type \"RECEIVECALL\" to receive a call.\n"
				+ "Type \"ADDFAV\" to add a favorite.\n"
				+ "Type \"EDITFAV\" to edit a favorite.\n"
				+ "Type \"DELFAV\" to delete a favorite.\n"
				+ "Type \"DISFAV\" to display a favorite.\n"
				+ "Type \"LOG\" to view all call history.\n"
				+ "Type \"DONE\" to exit your cell phone.");
		String response = "";
		
		while (!response.equals("DONE")) {
			System.out.print(">>> ");
			response = in.nextLine().trim();
			if (response.equals("ADD")) {
				System.out.print("Name of new contact: ");
				String addName = in.nextLine().trim();
				System.out.print("Phone # of new contact: ");
				String addPhone = in.nextLine().trim();
				System.out.print("Email of new contact: ");
				String addEmail = in.nextLine().trim();
				System.out.print("Note of new contact: ");
				String addNote = in.nextLine().trim();
				myCell.addToPB(addName, addPhone, addEmail, addNote);
				System.out.println("New contact added!");
				continue;
			}
			
			if (response.equals("EDIT")) {
				System.out.println("Which contact would you like to edit?");
				System.out.print("Name of contact: ");
				String existName = in.nextLine().trim();
				System.out.print("Phone # of contact: ");
				String existPhone = in.nextLine().trim();
				System.out.print("Email of contact: ");
				String existEmail = in.nextLine().trim();
				System.out.print("Note of contact: ");
				String existNote = in.nextLine().trim();
				System.out.println("---OPTIONS---\n"
						+ "Type \"NAME\" to change the name.\n"
						+ "Type \"PHONE\" to change phone #.\n"
						+ "Type \"EMAIL\" to change email.\n"
						+ "Type \"NOTE\" to chnage note.\n"
						+ "Type \"SAVE\" to save changes.");
				
				String modifier = "";
				while (!modifier.equals("SAVE")) {
					System.out.print(">>> ");
					modifier = in.nextLine().trim();
					if (modifier.equals("NAME")) {
						System.out.print("New name: ");
						String replaceName = in.nextLine().trim();
						myCell.editNamePB(existName, replaceName);
						System.out.println("Name updated!");
						existName = replaceName;
						continue;
					}
					if (modifier.equals("PHONE")) {
						System.out.print("New phone #: ");
						String replacePhone = in.nextLine().trim();
						myCell.editPhonePB(existPhone, replacePhone);
						System.out.println("Phone # updated!");
						existPhone = replacePhone;
						continue;
					}
					if (modifier.equals("EMAIL")) {
						System.out.print("New email: ");
						String replaceEmail = in.nextLine().trim();
						myCell.editEmailPB(existEmail, replaceEmail);
						System.out.println("Email updated!");
						existEmail = replaceEmail;
						continue;
					}
					if (modifier.equals("NOTE")) {
						System.out.print("New note: ");
						String replaceNote = in.nextLine().trim();
						myCell.editNotePB(existNote, replaceNote);
						System.out.println("Note updated!");
						existNote = replaceNote;
						continue;
					}
				}
				System.out.println("Contact updated!");
				continue;
			}
			
			if (response.equals("DELETE")) {
				System.out.print("Name of contact: ");
				String delName = in.nextLine().trim();
				System.out.print("Phone # of contact: ");
				String delPhone = in.nextLine().trim();
				System.out.print("Email of contact: ");
				String delEmail = in.nextLine().trim();
				System.out.print("Note of contact: ");
				String delNote = in.nextLine().trim();
				myCell.deletePB(delName, delPhone, delEmail, delNote);
				System.out.println("Contact deleted!");
				continue;
			}
			
			if (response.equals("DISPLAY")) {
				myCell.displayPB();
				continue;
			}
			
			if (response.equals("MAKECALL")) {
				System.out.println("Who would you like to call?");
				String call = in.nextLine().trim();
                if(myCell.searchPB(call)) {
                	String called = call;
                    toLog[0] = called;
                    Instant start = Instant.now();
                    Date date = new Date(0);
                    toLog[1] = date.toString();
                    System.out.println("Enter \"DONE\" when you're done with your call");
                    String callDone = in.nextLine().trim();
                    if(callDone.equals("DONE")) {
                       System.out.println("Your call has ended.");
                    }
                    Instant end = Instant.now();
                    Duration duration = Duration.between(start, end);
                    toLog[2] = duration.toString();
                    toLog[3] = "outgoing";
                    long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                    fullLog.add(toLog);
                    myLog.checkDuplicate(fullLog);
                } else if(call.equals("1")) {
                	String called = Favorites.getFavName();
                    toLog[0] = called;
                    Instant start = Instant.now();
                    Date date = new Date(0);
                    toLog[1] = date.toString();
                    System.out.println("Enter \"DONE\" when you're done with your call");
                    String callDone = in.nextLine().trim();
                    if(callDone.equals("DONE")) {
                       System.out.println("Your call has ended.");
                    }
                    Instant end = Instant.now();
                    Duration duration = Duration.between(start, end);
                    long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                    toLog[3] = "outgoing";
                    fullLog.add(toLog);
                    myLog.checkDuplicate(fullLog);
                } else if(call.equals("2")) {
                	String called = Favorites.getFavName();
                    toLog[0] = called;
                    Instant start = Instant.now();
                    Date date = new Date(0);
                    toLog[1] = date.toString();
                    System.out.println("Enter \"DONE\" when you're done with your call");
                    String callDone = in.nextLine().trim();
                    if(callDone.equals("DONE")) {
                       System.out.println("Your call has ended.");
                    }
                    Instant end = Instant.now();
                    Duration duration = Duration.between(start, end);
                    toLog[2] = duration.toString();
                    toLog[3] = "outgoing";
                    long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                    fullLog.add(toLog);
                    myLog.checkDuplicate(fullLog);
                } else if(call.equals("3")) {
                	String called = Favorites.getFavName();
                    toLog[0] = called;
                    Instant start = Instant.now();
                    Date date = new Date(0);
                    toLog[1] = date.toString();
                    System.out.println("Enter \"DONE\" when you're done with your call");
                    String callDone = in.nextLine().trim();
                    if(callDone.equals("DONE")) {
                    	System.out.println("Your call has ended.");
                    }
                    Instant end = Instant.now();
                    Duration duration = Duration.between(start, end);
                    toLog[2] = duration.toString();
                    toLog[3] = "outgoing";
                    long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                    fullLog.add(toLog);
                    myLog.checkDuplicate(fullLog);
                } else if(call.equals("4")) {
                	String called = Favorites.getFavName();
                	toLog[0] = called;
                    Instant start = Instant.now();
                    Date date = new Date(0);
                    toLog[1] = date.toString();
                    System.out.println("Enter \"DONE\" when you're done with your call");
                    String callDone = in.nextLine().trim();
                    if(callDone.equals("DONE")) {
                    	System.out.println("Your call has ended.");
                    }
                    Instant end = Instant.now();
                    Duration duration = Duration.between(start, end);
                    toLog[2] = duration.toString();
                    toLog[3] = "outgoing";
                    long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                    fullLog.add(toLog);
                    myLog.checkDuplicate(fullLog);
                } else if(call.equals("5")) {
                	String called = Favorites.getFavName();
                    toLog[0] = called;
                    Instant start = Instant.now();
                    Date date = new Date(0);
                    toLog[1] = date.toString();
                    System.out.println("Enter \"DONE\" when you're done with your call");
                    String callDone = in.nextLine().trim();
                    if(callDone.equals("DONE")) {
                    	System.out.println("Your call has ended.");
                    }
                    Instant end = Instant.now();
                    Duration duration = Duration.between(start, end);
                    toLog[2] = duration.toString();
                    toLog[3] = "outgoing";
                    long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                    fullLog.add(toLog);
                    myLog.checkDuplicate(fullLog);
                } else {
                	System.out.println("That contact doesn't exist in the phone book.");
                }
            }
			
			if (response.equals("RECEIVECALL")) {
				System.out.println("Whose call would you like to receive?");
                String receive = in.nextLine().trim();
                if(myCell.searchPB(receive)) {
                   String received = receive;
                   toLog[0] = received;
                   Instant start = Instant.now();
                  Date date = new Date(0);
                  toLog[1] = date.toString();
                  System.out.println("Enter \"DONE\" when you're done with your call");
                  String callDone = in.nextLine().trim();
                  if(callDone.equals("DONE")) {
                      System.out.println("Your call has ended.");
                  }
                  Instant end = Instant.now();
                  Duration duration = Duration.between(start, end);
                  toLog[2] = duration.toString();
                  toLog[3] = "incoming";
                  long callDuration = duration.toMillis();
                    toLog[2] = String.valueOf(callDuration);
                  fullLog.add(toLog);
                  myLog.checkDuplicate(fullLog);
                }
                else {
                    System.out.println("That contact doesn't exist in the phone book.");
                }
            }

        
	        if (response.equals("ADDFAV")) {
	            System.out.print("Name of contact: ");
	            String favName = in.nextLine().trim();
	            System.out.print("Phone # of contact: ");
	            String favPhone = in.nextLine().trim();
	            System.out.print("Email of contact: ");
	            String favEmail = in.nextLine().trim();
	            System.out.print("Note of contact: ");
	            String favNote = in.nextLine().trim();
	            System.out.print("Where do you want this favorite");
	            String favPos = in.nextLine().trim();
	            int pos = Integer.parseInt(favPos);
	            System.out.print("What image do you want to set:");
	            String favimage = in.nextLine().trim();
	            myCell.addFav(favName,favPhone,favEmail,favNote,favimage,pos);
	            System.out.println("Favorite added!");
	            continue;
	        }
			
			if (response.equals("ADDFAV")) {
				System.out.print("Name of contact: ");
                String favName = in.nextLine().trim();
                System.out.print("Phone # of contact: ");
                String favPhone = in.nextLine().trim();
                System.out.print("Email of contact: ");
                String favEmail = in.nextLine().trim();
                System.out.print("Note of contact: ");
                String favNote = in.nextLine().trim();
                System.out.print("Position of favorite (0-4): ");
                String favPos = in.nextLine().trim();
                int pos = Integer.parseInt(favPos);
                System.out.print("Image for contact (provide the filepath): ");
                String favimage = in.nextLine().trim();
                myCell.addFav(favName,favPhone,favEmail,favNote,favimage,pos);
                System.out.println("Contact added to Favorites!");
                continue;
			}
			
			if (response.equals("MOVEFAV")) {
				System.out.println("which contact do you want to move?\n"
						+ "Type 0 for #1 contact\n"
						+ "Type 1 for #2 contact\n"
						+ "Type 2 for #3 contact\n"
						+ "Type 3 for #4 contact\n"
						+ "Type 4 for #5 contact");
                String contactPosInput = in.nextLine().trim();
                int contactpos = Integer.parseInt(contactPosInput);
                System.out.println("New position for contact (0-4): ");
                String newPosInput = in.nextLine().trim();
                int newPos = Integer.parseInt(newPosInput);
                myCell.moveFav(contactpos,newPos);
                System.out.println("Contact in Favorites has been moved to a new position!");
                continue;
			}
			
			if (response.equals("DELFAV")) {
				System.out.println("Which favorites would you like to delete (0-4):");
                String delFav = in.nextLine().trim();
                int fav = Integer.parseInt(delFav);
                myCell.deleteFav(fav);
                System.out.println("Contact removed from Favorites!");
                continue;
			}
			
			if (response.equals("DISFAV")) {
				System.out.print("Which contact would you like to display (0-4): ");
				String favDisplay = in.nextLine().trim();
				myCell.displayFav(favDisplay);
				continue;
			}
			
			if (response.equals("LOG")) {
				myLog.getCallsMade();
				continue;
			}
		}
		System.out.println("Goodbye!");
		in.close();	
	}
}
