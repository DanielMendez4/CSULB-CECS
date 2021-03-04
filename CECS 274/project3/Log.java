package project3;

import java.util.ArrayList;

/**
 * Stores calls made/received by the user
 * Displays history of all calls made/received
 * **/
public class Log {
	
	private ArrayList<String> names;
    private ArrayList<String> dates;
    private ArrayList<Integer> durations;
    private ArrayList<String> inOrOut;
    private ArrayList<Integer> quantity;
    
    // The default constructor
    public Log() {
        names = new ArrayList<String>();
        dates = new ArrayList<String>();
        durations = new ArrayList<Integer>();
        inOrOut = new ArrayList<String>();
        quantity = new ArrayList<Integer>();
    }
    /**Checks to see if there were two or more instances where the same person was called in the same day 
     * @param log: The log that contains the call history which includes: name, date, duration, outgoing or incoming
     */ 
    public void checkDuplicate(ArrayList<String[]> log) {
        for(int i = 0; i < log.size(); i++) {
            if(names.contains(log.get(i)[0]) && dates.contains(log.get(i)[1]) && inOrOut.contains(log.get(i)[3])) {
                quantity.set(i, quantity.get(i) + 1);
                durations.set(i, durations.get(i) + Integer.parseInt(log.get(i)[2]));
            }
            else {
                names.add(log.get(i)[0]);
                dates.add(log.get(i)[1]);
                durations.add(Integer.parseInt(log.get(i)[2]));
                inOrOut.add(log.get(i)[3]);
                quantity.add(1);
            }
        }
    }
    
    /**
     * Displays all call history in the log
     * **/
    public void getCallsMade() {
        for(int i = 0; i < quantity.size(); i++) {
            System.out.print(names.get(i));
            if(inOrOut.get(i).equals("outgoing")) {
                System.out.print(" was called  on ");
            }
            else {
                System.out.print("'s call was received on ");
            }
            System.out.print(dates.get(i));
            if(quantity.get(i) > 1) {
                System.out.println(quantity.get(i) + " times for a total of " + durations.get(i) + " seconds.");
            }
            else {
                System.out.println(" for a total of " + durations.get(i) + " seconds.");
            }
            
        }
    }
}