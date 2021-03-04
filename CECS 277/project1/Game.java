package project1;

/**
 * Models the game of war with functionality to battle, convert, and perform war
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-07
 * **/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	// Instance variables
	private Hand gameHand;
	private Card playerBattleCard;
	private Card comBattleCard;
	private int playerBattleRank;
	private int comBattleRank;
	
	private Card playerWarCard;
	private Card comWarCard;
	private int playerWarRank;
	private int comWarRank;
	
	private ArrayList<Card> playerWarDeck;
	private ArrayList<Card> comWarDeck;
	private ArrayList<Card> playerOverflow;
	private ArrayList<Card> comOverflow;
	
	private Random rand;
	private Scanner in;
	
	/**
	 * Default constructor
	 * **/
	public Game() {
		
		gameHand = new Hand();
		playerBattleCard = new Card();
		comBattleCard = new Card();
		playerBattleRank = 0;
		comBattleRank = 0;
		
		playerWarCard = new Card();
		comWarCard = new Card();
		playerWarRank = 0;
		comWarRank = 0;
		
		playerWarDeck = new ArrayList<Card>();
		comWarDeck = new ArrayList<Card>();
		playerOverflow = new ArrayList<Card>();
		comOverflow = new ArrayList<Card>();
		
		rand = new Random();
		in = new Scanner(System.in);
	}
	
	/**
	 * Converts the String rank into integers to be compared
	 * **/
	public void convert() {
		
		playerBattleCard = gameHand.playerDraw();
		comBattleCard = gameHand.comDraw();
		
		if (playerBattleCard.getRank().equals("A")) {
			playerBattleRank = 1;
		} else if (playerBattleCard.getRank().equals("J")) {
			playerBattleRank = 11;
		} else if (playerBattleCard.getRank().equals("Q")) {
			playerBattleRank = 12;
		} else if (playerBattleCard.getRank().equals("K")) {
			playerBattleRank = 13;
		} else {
			playerBattleRank = Integer.parseInt(playerBattleCard.getRank());
		}
		
		if (comBattleCard.getRank().equals("A")) {
			comBattleRank = 1;
		} else if (comBattleCard.getRank().equals("J")) {
			comBattleRank = 11;
		} else if (comBattleCard.getRank().equals("Q")) {
			comBattleRank = 12;
		} else if (comBattleCard.getRank().equals("K")) {
			comBattleRank = 13;
		} else {
			comBattleRank = Integer.parseInt(comBattleCard.getRank());
		}
	}
	
	/**
	 * Compares the two cards being played against each other
	 * If the player's card holds a higher rank, then playerAdvantage is called
	 * If the computer's card hold a higher rank, then comAdvantage is called
	 * If the both cards hold the same rank, then war is called
	 * **/
	public void battle() {
		
		convert();
		
		System.out.print("PLAYER: " + playerBattleCard + " vs. COM: " + comBattleCard + " ... ");

		if (playerBattleRank > comBattleRank) {
			
			playerAdvantage();
		}
		
		if (playerBattleRank < comBattleRank) {
			
			comAdvantage();
		}
		
		if (playerBattleRank == comBattleRank) {
			
			System.out.println("Then it's WAR!");
			war();
		}
	}
	
	/**
	 * Gets called when the player's card holds a higher rank
	 * The computer randomly decides whether to extend the battle
	 * If the player's card holds the higher rank, then player gets both cards
	 * If the computer decides to extend the battle, they need to get a lower sum to win the battle
	 * If the computer's cards add up to the player's card rank, then war is called
	 * **/
	public void playerAdvantage() {
		
		int decision = rand.nextInt(2);
		
		if (decision == 0) {
			
			gameHand.getPlayerHand().add(comBattleCard);
			gameHand.getPlayerHand().add(playerBattleCard);
			System.out.println("PLAYER wins this battle!");
		}
		
		if (decision == 1) {
			
			if (gameHand.getComHand().size() == 1) {
				System.out.println("COM doesn't have any more cards to extend this battle!");
				gameHand.getPlayerHand().add(comBattleCard);
				gameHand.getPlayerHand().add(playerBattleCard);
				System.out.println("PLAYER wins this battle!");
				return;
				
			} else {
				
				System.out.println("COM extends this battle!");
				Card temp = comBattleCard;
				Card comComebackCard = gameHand.comDraw();
				int firstRank = comBattleRank;
				int secondRank;
				
				System.out.print("PLAYER: " + playerBattleCard + " vs. COM: " + comBattleCard + " + " + comComebackCard + " ... ");
				
				if (comComebackCard.getRank().equals("A")) {
					secondRank = 1;
				} else if (comComebackCard.getRank().equals("J")) {
					secondRank = 11;
				} else if (comComebackCard.getRank().equals("Q")) {
					secondRank = 12;
				} else if (comComebackCard.getRank().equals("K")) {
					secondRank = 13;
				} else {
					secondRank = Integer.parseInt(comComebackCard.getRank());
				}
				if (firstRank + secondRank < playerBattleRank) {
					gameHand.getComHand().add(playerBattleCard);
					gameHand.getComHand().add(comComebackCard);
					gameHand.getComHand().add(temp);
					System.out.println("COM wins this extended battle!");
				}
				if (firstRank + secondRank > playerBattleRank) {
					gameHand.getPlayerHand().add(comComebackCard);
					gameHand.getPlayerHand().add(temp);
					gameHand.getPlayerHand().add(playerBattleCard);
					System.out.println("PLAYER wins this extended battle!");
				}
				if (firstRank + secondRank == playerBattleRank) {
					System.out.println("Then it's WAR!");
					comOverflow.add(temp);
					war();
				}
			}
			
		}
	}
	
	/**
	 * Gets called when the computer's card holds a higher rank
	 * The player has the option to extend the battle
	 * If the computer's card holds the higher rank, then computer gets both cards
	 * If the player decides to extend the battle, they need to get a lower sum to win the battle
	 * If the player's cards add up to the computer's card rank, then war is called
	 * **/
	public void comAdvantage() {
		
		System.out.print("Does PLAYER want to extend the battle Y/N?: ");
		String response = in.nextLine();
		
		if (response.equals("N")) {
			
			gameHand.getComHand().add(playerBattleCard);
			gameHand.getComHand().add(comBattleCard);
			System.out.println("COM wins this battle!");
		}
		
		if (response.equals("Y")) {
			
			if (gameHand.getPlayerHand().size() == 1) {
				System.out.println("PLAYER doesn't have any more cards to extend this battle!");
				gameHand.getComHand().add(playerBattleCard);
				gameHand.getComHand().add(comBattleCard);
				System.out.println("COM wins this battle!");
				return;
				
			} else {
				
				System.out.println("PLAYER extends this battle!");
				Card temp = playerBattleCard;
				Card playerComebackCard = gameHand.playerDraw();
				int firstRank = playerBattleRank;
				int secondRank;
				
				System.out.print("PLAYER: " + playerBattleCard + " + " + playerComebackCard + "  vs. COM: " + comBattleCard  + " ... ");
				
				if (playerComebackCard.getRank().equals("A")) {
					secondRank = 1;
				} else if (playerComebackCard.getRank().equals("J")) {
					secondRank = 11;
				} else if (playerComebackCard.getRank().equals("Q")) {
					secondRank = 12;
				} else if (playerComebackCard.getRank().equals("K")) {
					secondRank = 13;
				} else {
					secondRank = Integer.parseInt(playerComebackCard.getRank());
				}
				if (firstRank + secondRank < comBattleRank) {
					gameHand.getComHand().add(comBattleCard);
					gameHand.getComHand().add(playerComebackCard);
					gameHand.getComHand().add(temp);
					System.out.println("PLAYER wins this extended battle!");
				}
				if (firstRank + secondRank > comBattleRank) {
					gameHand.getPlayerHand().add(playerComebackCard);
					gameHand.getPlayerHand().add(temp);
					gameHand.getPlayerHand().add(comBattleCard);
					System.out.println("COM wins this extended battle!");
				}
				if (firstRank + secondRank == comBattleRank) {
					System.out.println("Then it's WAR!");
					playerOverflow.add(temp);
					war();
				}
			}
		}
	}
	
	/**
	 * Gets called when the ranks of the player and computer cards are the same
	 * 4 cards are drawn out of each deck with the last card face up, determining who wins
	 * If the player's last card holds the higher rank, then the player gets all the cards and vice versa
	 * If the last card for the player and computer hold the same rank, then war is called again
	 * **/
	public void war() {
				
		if (getPlayerSize() < 4) {
			for (int i = 0; i < gameHand.getPlayerHand().size(); i++) {
				playerWarDeck.add(gameHand.playerDraw());
			}
		}
		if (getPlayerSize() >= 4) {
			for (int i = 0; i < 4; i++) {
				playerWarDeck.add(gameHand.playerDraw());
			}
		}
		
		if (playerWarDeck.size() > 1) {
			playerWarCard = playerWarDeck.get(playerWarDeck.size() - 1);
		}
		if (playerWarDeck.size() == 1) {
			playerWarCard = playerWarDeck.get(0);
		}
		
		if (playerWarCard.getRank().equals("A")) {
			playerWarRank = 1;
		} else if (playerWarCard.getRank().equals("J")) {
			playerWarRank = 11;
		} else if (playerWarCard.getRank().equals("Q")) {
			playerWarRank = 12;
		} else if (playerWarCard.getRank().equals("K")) {
			playerWarRank = 13;
		} else {
			playerWarRank = Integer.parseInt(playerWarCard.getRank());
		}
		
		// ----------------------------------------------------------------
		
		if (getComSize() < 4) {
			for (int i = 0; i < gameHand.getComHand().size(); i++) {
				comWarDeck.add(gameHand.comDraw());
			}
		}
		if (getComSize() >= 4) {
			for (int i = 0; i < 4; i++) {
				comWarDeck.add(gameHand.comDraw());
			}
		}
		
		if (comWarDeck.size() > 1) {
			comWarCard = comWarDeck.get(comWarDeck.size() - 1);
		}
		if (comWarDeck.size() == 1) {
			comWarCard = comWarDeck.get(0);
		}
		
		if (comWarCard.getRank().equals("A")) {
			comWarRank = 1;
		} else if (comWarCard.getRank().equals("J")) {
			comWarRank = 11;
		} else if (comWarCard.getRank().equals("Q")) {
			comWarRank = 12;
		} else if (comWarCard.getRank().equals("K")) {
			comWarRank = 13;
		} else {
			comWarRank = Integer.parseInt(comWarCard.getRank());
		}
		
		// ----------------------------------------------------------------
		
		System.out.print("PLAYER: ");
		for (int i = 0; i < playerWarDeck.size() - 1; i++) {
			System.out.print("X ");
		}
		System.out.print(playerWarCard + " vs. COM: ");
		for (int i = 0; i < comWarDeck.size() - 1; i++) {
			System.out.print("X ");
		}
		System.out.print(comWarCard + " ... ");
		
		
		if (playerWarRank > comWarRank) {
			
			for (int i = 0; i < comWarDeck.size(); i++) {
				gameHand.getPlayerHand().add(comWarDeck.remove(i));
			}
			for (int i = 0; i < comOverflow.size(); i++) {
				gameHand.getPlayerHand().add(comOverflow.remove(i));
			}
			gameHand.getPlayerHand().add(comBattleCard);
			gameHand.getPlayerHand().add(comWarCard);
			
			for (int i = 0; i < playerWarDeck.size(); i++) {
				gameHand.getPlayerHand().add(playerWarDeck.remove(i));
			}
			gameHand.getPlayerHand().add(playerBattleCard);
			gameHand.getPlayerHand().add(playerWarCard);
			
			System.out.println("PLAYER wins this war!");
			
			playerWarDeck.clear();
			comWarDeck.clear();
			comOverflow.clear();
		}
		
		if (playerWarRank < comWarRank) {
			
			for (int i = 0; i < playerWarDeck.size(); i++) {
				gameHand.getComHand().add(playerWarDeck.remove(i));
			}
			for (int i = 0; i < playerOverflow.size(); i++) {
				gameHand.getComHand().add(playerOverflow.remove(i));
			}
			gameHand.getComHand().add(playerBattleCard);
			gameHand.getComHand().add(playerWarCard);
			
			for (int i = 0; i < comWarDeck.size(); i++) {
				gameHand.getComHand().add(comWarDeck.remove(i));
			}
			gameHand.getComHand().add(comBattleCard);
			gameHand.getComHand().add(comWarCard);
			
			System.out.println("COM wins this war!");
			
			playerWarDeck.clear();
			comWarDeck.clear();
		}
		
		if (playerWarRank == comWarRank) {
			
			System.out.println("The war continues...");
			war();
		}
	}
	
	/**
	 * Gets the current size of the player's hand
	 * @return gameHand.getPlayerHand().size() - the current size of the player's hand
	 * **/
	public int getPlayerSize() {
		
		return gameHand.getPlayerHand().size();
	}
	
	/**
	 * Gets the current size of the computer's hand
	 * @return gameHand.getComHand().size() - the current size of the computer's hand
	 * **/
	public int getComSize() {
		
		return gameHand.getComHand().size();
	}
}