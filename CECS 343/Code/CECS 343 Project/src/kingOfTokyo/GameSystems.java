/*  GameSystems.java
	D. Mendez, R. John, K. Cruz
	CECS 343
	Due 03 Dec 2019
	Title: Game systems class
	Description: Contains the methods for the game to function
*/

package kingOfTokyo;

import java.util.Random;
import java.util.ArrayList;

public class GameSystems {
	
	static ArrayList <Integer> rolls = new ArrayList<Integer>(6);
	
	/**
	 * Returns a random number between 1 and 6 inclusive
	 * @return randNum
	 */
	public static int rollDie() {
		
		Random rand = new Random();
		int randNum = rand.nextInt((6 - 1) + 1) +1;
		return randNum;
	}
	
	/**
	 * Allows player to keep a favorable dice roll
	 * @param r - an ArrayList of Integers
	 * @param index - which dice is to be kept
	 */
	public static void resolveDie(ArrayList <Integer> r, int index) {
		
		int rnum = rollDie();
		rolls.set(index,rnum);
	}
	
	/**
	 * Displays the current player's final roll
	 * @param r - an ArrayList of Integers
	 */
	public static void ViewFinalRoll(ArrayList <Integer> r) {
		
		for(int i = 0; i <= r.size(); i++) {
			if(r.get(i) == 1) {
				System.out.println(1);
			}
			else if( r.get(i) == 2) {
				System.out.println(2);
			}
			else if(r.get(i) == 3) {
				System.out.println(3);
			}
			else if( r.get(i) == 4) {
				System.out.println("SMASH!");
			}
			else if(r.get(i) == 5) {
				System.out.println("AQUIRE HEALTH POINTS!");
			}
			else if(r.get(i) == 6) {
				System.out.println("ACQUIRE VICTORY POINTS!");
			}
		}
	}
	
	public static void main(String[] args) {
		for(int i =0; i <6;i++) {
			int num = rollDie();
			rolls.add(num);
		}
		System.out.println(rolls);
		resolveDie(rolls, 3);
		System.out.println(rolls);
		resolveDie(rolls, 2);
		System.out.println(rolls);
		resolveDie(rolls, 5);
		System.out.println(rolls);
		ViewFinalRoll(rolls);
	}
}