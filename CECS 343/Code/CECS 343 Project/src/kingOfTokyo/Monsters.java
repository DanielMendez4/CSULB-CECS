/*  Monsters.java
	D. Mendez, R. John, K. Cruz
	CECS 343
	Due 03 Dec 2019
	Title: Monsters class
	Description: the playable characters in King of Tokyo
*/

package kingOfTokyo; 

public class Monsters {
	
	/**
	 * Instance Variables
	 */
	String MonsterName;
	int energyPoints;
	int healthPoints;
	int victoryPoints;
	
	/**
	 * Default Constructor
	 */
	public Monsters() {
		MonsterName = "";
		healthPoints = 10;
		energyPoints = 0;
		victoryPoints = 0;
	}
	
	/**
	 * Overloaded Constructor
	 * @param MN - name of the monster
	 * @param HP - health points of the monster
	 * @param EP - energy points that the monster has
	 * @param VP - victory points that the monster has
	 */
	public Monsters(String MN, int HP, int EP, int VP) {
		MonsterName = MN;
		healthPoints = HP;
		energyPoints = EP;
		victoryPoints = VP;
	}
	/**
	 * Sets the monster's name
	 * @param Mname - name of the monster
	 */
	public void setMonsterName(String Mname) {
		MonsterName = Mname;
	}
	/**
	 * Sets the energy points of the monster
	 * @param Energy - number of energy points
	 */
	public void setEnergyPoints(int Energy) {
		energyPoints = Energy;
	}
	/**
	 * Sets the health points of the monster
	 * @param Health - current health points of the monsters
	 */
	public void setHealthPoints(int Health) {
		healthPoints = Health;
	}
	/**
	 * Sets the victory points of the monster
	 * @param Victory - number of victory points
	 */
	public void setVictoryPoints(int Victory) {
		victoryPoints = Victory;
	}
	/**
	 * Gets the monster's name
	 * @return MonsterName
	 */
	public String getMonsterName() {
		return MonsterName;
	}
	/**
	 * Gets the monster's current energy points
	 * @return energyPoints
	 */
	public int getEnergyPoints() {
		return energyPoints;
	}
	/**
	 * Gets the monster's current health points
	 * @return healthPoints
	 */
	public int getHealthPoints() {
		return healthPoints;
	}
	/**
	 * Gets the monster's current victory points
	 * @return victoryPoints
	 */
	public int getVictoryPoints() {
		return victoryPoints;
	}
	/**
	 * Prints the information of the monster
	 * @return formatted string of the Monster's information
	 */
	public String toString() {
		return "MONSTER NAME: "+MonsterName+"\nHEALTH POINTS: "+healthPoints+"\nVICTORY POINTS: "+victoryPoints+"\nENERGY POINTS: "+energyPoints;
	}
}