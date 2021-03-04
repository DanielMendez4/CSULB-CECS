package project1;

/**
 * Models a playing card with rank and suit
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-07
 * **/

public class Card {
	
	// Instance variables
	private String rank;
	private String suit;
	
	/**
	 * Default constructor that creates a card with no rank or suit
	 * **/
	public Card() {
		
		rank = "N/A";
		suit = "N/A";
	}
	
	/**
	 * Overloaded constructor
	 * @param rank - the rank of the card as String
	 * @param suit - the suit of the card as String
	 * **/
	public Card(String rank, String suit) {
		
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Gets the rank of the card
	 * @return rank - the rank of the card
	 * **/
	public String getRank() {
		
		return rank;
	}
	
	/**
	 * Gets the suit of the card
	 * @return suit - the suit of the card
	 * **/
	public String getSuit() {
		
		return suit;
	}
	
	/**
	 * Creates a String representation of this Card object
	 * @return String with the rank and suit of the card
	 * **/
	public String toString() {
		
		return rank + " of " + suit; 
	}
}