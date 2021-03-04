package project1;

/**
 * Models a deck of cards with functionality of creating, shuffling, and dealing
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-07
 * **/

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
	
	// Instance variables
	private ArrayList<Card> fullDeck;
	private Card card;
	private ArrayList<String> rank;
	private ArrayList<String> suit;
	private ArrayList<Card> playerDeck;
	private ArrayList<Card> comDeck;
	
	/**
	 * Default constructor
	 * **/
	public DeckOfCards() {
		
		fullDeck = new ArrayList<Card>();
		card = new Card();
		rank = new ArrayList<String>();
		suit = new ArrayList<String>();
		playerDeck = new ArrayList<Card>();
		comDeck = new ArrayList<Card>();
	}
	
	/**
	 * Creates a full deck of cards with rank and suit
	 * **/
	public void create() {
		
		rank.add("A");
		rank.add("2");
		rank.add("3");
		rank.add("4");
		rank.add("5");
		rank.add("6");
		rank.add("7");
		rank.add("8");
		rank.add("9");
		rank.add("10");
		rank.add("J");
		rank.add("Q");
		rank.add("K");
		
		suit.add("Clubs");
		suit.add("Diamonds");
		suit.add("Hearts");
		suit.add("Spades");
		
		for (int i = 0; i < rank.size(); i++) {
			
			for (int j = 0; j < suit.size(); j++) {
				
				card = new Card(rank.get(i), suit.get(j));
				fullDeck.add(card);
			}
		}
	}
	
	/**
	 * Shuffles the deck of cards
	 * **/
	public void shuffle() {
		
		Collections.shuffle(fullDeck);
	}
	
	/**
	 * Deals the deck of cards to the player and computer
	 * **/
	public void deal() {
		
		while (fullDeck.size() != 0) {
			
			playerDeck.add(fullDeck.get(0));
			fullDeck.remove(0);
			comDeck.add(fullDeck.get(0));
			fullDeck.remove(0);
		}
	}
	
	/**
	 * Gets the player's deck of cards
	 * @return playerDeck - the deck of cards belonging to the player
	 * **/
	public ArrayList<Card> getPlayerDeck() {
		
		return playerDeck;
	}
	
	/**
	 * Gets the computer's deck of cards
	 * @return comDeck - the deck of cards belonging to the computer
	 * **/
	public ArrayList<Card> getComDeck() {
		
		return comDeck;
	}
}