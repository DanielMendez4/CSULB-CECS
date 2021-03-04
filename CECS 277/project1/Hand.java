package project1;

/**
 * Models the player and computer hand of cards with functionality to draw
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-07
 * **/

import java.util.ArrayList;

public class Hand {
	
	// Instance variables
	private DeckOfCards gameDeck;
	private ArrayList<Card> playerHand;
	private ArrayList<Card> comHand;
	
	/**
	 * Default constructor that creates a new DeckOfCards
	 * Also creates, shuffles, and deals the deck
	 * Finally, creates the playerHand and comHand
	 * **/
	public Hand() {
		
		gameDeck = new DeckOfCards();
		
		gameDeck.create();
		gameDeck.shuffle();
		gameDeck.deal();
		
		playerHand = gameDeck.getPlayerDeck();
		comHand = gameDeck.getComDeck();
	}
	
	/**
	 * Draws a card from the player's deck
	 * @return playerCard - card drawn from the top of the player's hand
	 * **/
	public Card playerDraw() {
		
		Card playerCard = playerHand.remove(0);
		return playerCard;
	}
	
	/**
	 * Draws a card from the computer's deck
	 * @return comCard - card drawn from the top of the computer's hand
	 * **/
	public Card comDraw() {
		
		Card comCard = comHand.remove(0);
		return comCard;
	}
	
	/**
	 * Gets the player's current hand
	 * @return playerHand - current hand of the player
	 * **/
	public ArrayList<Card> getPlayerHand() {
		
		return playerHand;
	}
	
	/**
	 * Gets the computer's current hand
	 * @return comHand - current hand of the computer
	 * **/
	public ArrayList<Card> getComHand() {
		
		return comHand;
	}
}