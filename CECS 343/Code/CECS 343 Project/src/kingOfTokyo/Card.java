/*  Card.java
	D. Mendez, R. John, K. Cruz
	CECS 343
	Due 03 Dec 2019
	Title: Card class
	Description: The available cards used for play in King of Tokyo
*/

package kingOfTokyo;

public class Card {
	/**
	 * instance variables
	 * */
	String name; 
	int cost;
	String type;
	String ability;
	
	/**
	 * default constructor
	 * */
	public Card() {
		name = "";
		cost = 0;
		type = "";
		ability = "";
	}
	
	/**
	 * overloaded constructor
	 * */
	public Card(String n, int c, String t, String a) {
		name = n;
		cost = c;
		type = t;
		ability = a;
	}
	
	/**setter method that sets the name of the card
	 * @param nm - name of the card
	 * */
	public void setName(String nm) {
		name = nm;
	}
	/**setter method that sets the cost of the card
	 * @param ct - cost of the card
	 * */
	public void setCost(int ct) {
		cost = ct;
	}
	/**setter method that sets the type of the card
	 * @param tp - type of the card
	 * */
	public void setType(String tp) {
		type =tp;
	}
	/**setter method that sets the ability of the card
	 * @param ab - ability of the card
	 * */
	public void setAbility(String ab) {
		ability = ab;
	}
	
	/**getter method that gets the name of the card
	 * @return name - name of the card
	 * */
	public String getName() {
		return name;
	}
	/**getter method that gets the cost of the card
	 * @return cost - cost of the card
	 * */
	public int getCost() {
		return cost;
	}
	/**getter method that gets the type of the card
	 * @return type - type of the card
	 * */
	public String getType() {
		return type;
	}
	/**getter method that gets the ability of the card
	 * @return ability - ability of the card
	 * */
	public String getAbility() {
		return ability;
	}
	
	/**toString method to format the card display
	 * @return formatted card display
	 * */
	public String toString() {
		return "NAME: "+name+"\n"+"COST: "+cost+"\n"+"TYPE: "+type+"\n"+"ABILITY: "+ability+"\n";
	}

	public static void main(String[] args) {
		
		Card c1 = new Card("Acid Attack", 6, "Keep", "Deal 1 extra damage each turn (even when you don't otherwise attack).");
		Card c2 = new Card("Alien Metabolism", 3, "Keep", "Buying cards costs you 1 less [Energy].");
		Card c3 = new Card("Alpha Monster", 5, "Keep", "Gain 1[Star] when you attack.");
		Card c4 = new Card("Apartment Building", 5, "Discard", "+ 3[Star]");
		Card c5 = new Card("Armor Plating", 4, "Keep", "Ignore damage of 1.");
		Card c6 = new Card("Background Dweller", 4, "Keep", "You can always reroll any [3] you have.");
		Card c7 = new Card("Burrowing", 5, "Keep", "Deal 1 extra damage on Tokyo. Deal 1 damage when yielding Tokyo to the monster taking it.	");
		Card c8 = new Card("Camouflage", 3, "Keep", "If you take damage roll a die for each damage point. On a [Heart] you do not take that damage point.");
		Card c9 = new Card("Commuter Train", 4, "Discard", "+ 2[Star]");
		Card c10 = new Card("Complete Destruction", 3, "Keep", "If you roll [1][2][3][Heart][Attack][Energy] gain 9[Star] in addition to the regular results.");
		Card c11 = new Card("Corner Store", 3, "Discard", "+ 1[Star]");
		Card c12 = new Card("Dedicated News Team", 3, "Keep", "Gain 1[Star] whenever you buy a card.");
		Card c13 = new Card("Drop from High Altitude", 5, "Discard", "+ 2[Star] and take control of Tokyo if you don't already control it.");
		Card c14 = new Card("Eater of the Dead", 4, "Keep", "Gain 3[Star] every time a monster's [Heart] goes to 0.");
		Card c15 = new Card("Energize", 8, "Discard", "+ 9[Energy]");
		Card c16 = new Card("Energy Hoarder", 3, "Keep", "You gain 1[Star] for every 6[Energy] you have at the end of your turn.");
		Card c17 = new Card("Evacuation Orders (x2)", 7, "Discard", "	All other monsters lose 5[Star].");
		Card c18 = new Card("Even Bigger", 4, "Keep", "Your maximum [Heart] is increased by 2. Gain 2[Heart] when you get this card.");
		Card c19 = new Card("Extra Head (x2)", 7, "Keep", "You get 1 extra die.");
		Card c20 = new Card("Fire Blast", 3, "Discard", "Deal 2 damage to all other monsters.");
		Card c21 = new Card("Fire Breathing",4,"Keep","Your neighbors take 1 extra damage when you deal damage");
		Card c22 = new Card("Freeze Time",	5,"Keep", "On a turn where you score [1][1][1], you can take another turn with one less die.");
		Card c23 = new Card("Frenzy",7,	"Discard",	"When you purchase this card Take another turn immediately after this one.");
		Card c24 = new Card("Friend of Children",3	,"Keep",	"When you gain any [Energy] gain 1 extra [Energy].");
		Card c25 = new Card("Gas Refinery",6,"Discard",	"+ 2[Star] and deal 3 damage to all other monsters.");
		Card c26 = new Card("Giant Brain",5	,"Keep",	"You have one extra reroll each turn.");
		Card c27 = new Card("Gourmet",4,"Keep",	"When scoring [1][1][1] gain 2 extra [Star].");
		Card c28 = new Card("Heal",3,"Discard",	"Heal 2 damage.");
		Card c29 = new Card("Healing Ray",4,"Keep",	"You can heal other monsters with your [Heart] results. They must pay you 2[Energy] for each damage you heal (or their remaining [Energy] if they have not got enough.");
		Card c30 = new Card("Herbivore",5,	"Keep",	"Gain 1[Star] on your turn if you don't damage anyone.");
		Card c31 = new Card("Herd Culler",3,"Keep",	"You can change one of your dice to a [1] each turn.");
		Card c32 = new Card("High Altitude Bombing",4,	"Discard",	"All monsters (including you) take 3 damage.");
		Card c33 = new Card("It Has a Child",7,	"Keep",	"If you are eliminated discard all your cards and lose all your [Star], Heal to 10[Heart] and start again.");
		Card c34 = new Card("Jet Fighters",5,	"Discard","+ 5[Star] and take 4 damage");
		Card c35 = new Card("Jets",5,	"Keep",	"You suffer no damage when yielding Tokyo.");
		Card c36 = new Card("Made in a Lab",2,	"Keep",	"When purchasing cards you can peek at and purchase the top card of the deck.");
		Card c37 = new Card("Metamorph",3,	"Keep",	"At the end of your turn you can discard any keep cards you have to receive the [Energy] they were purchased for.");
		Card c38 = new Card("Mimic",8,	"Keep",	"Choose a card any monster has in play and put a mimic counter on it. This card counts as a duplicate of that card as if it just had been bought. Spend 1[Energy] at the start of your turn to change the power you are mimicking.");
		Card c39 = new Card("Monster Batteries",2,	"Keep",	"When you purchase this put as many [Energy] as you want on it from your reserve. Match this from the bank. At the start of each turn take 2[Energy] off and add them to your reserve. When there are no [Energy] left discard this card.");
		Card c40 = new Card("National Guard", 3 , "Discard",	"+ 2[Star] and take 2 damage.");
		Card c41 = new Card("Nova Breath",	7,	"Keep",	"Your attacks damage all other monsters.");
		Card c42 = new Card("Nuclear Power Plant", 6, "Discard",	"+ 2[Star] and heal 3 damage.");
		Card c43 = new Card("Omnivore",	4,	"Keep",	"Once each turn you can score [1][2][3] for 2[Star]. You can use these dice in other combinations.");
		Card c44 = new Card("Opportunist",	3,	"Keep",	"Whenever a new card is revealed you have the option of purchasing it as soon as it is revealed.");
		Card c45 = new Card("Parasitic Tentacles",	4,	"Keep",	"You can purchase cards from other monsters. Pay them the [Energy] cost.");
		Card c46 = new Card("Plot Twist",3,	"Keep",	"Change one die to any result. Discard when used.");
		Card c47 = new Card("Poison Quills", 3,	"Keep",	"When you score [2][2][2] also deal 2 damage.");
		Card c48 = new Card("Poison Spit",	4	,"Keep",	"When you deal damage to monsters give them a poison counter. Monsters take 1 damage for each poison counter they have at the end of their turn. You can get rid of a poison counter with a [Heart] (that [Heart] doesn't heal a damage also).");
		Card c49 = new Card("Psychic Probe",	3,	"Keep",	"You can reroll a die of each other monster once each turn. If the reroll is [Heart] discard this card.");
		Card c50 = new Card("Rapid Healing",	3,	"Keep",	"Spend 2[Energy] at any time to heal 1 damage.");
		Card c51 = new Card("Regeneration",	4,	"Keep",	"When you heal, heal 1 extra damage.");
		Card c52 = new Card("Rooting for the Underdog",	3,	"Keep",	"At the end of a turn when you have the fewest [Star] gain 1 [Star].");
		Card c53 = new Card("Shrink Ray",	6	,"Keep",	"When you deal damage to monsters give them a shrink counter. A monster rolls one less die for each shrink counter. You can get rid of a shrink counter with a [Heart] (that [Heart] doesn't heal a damage also).");
		Card c54 = new Card("Skyscraper",	6,	"Discard"	,"+ 4[Star]");
		Card c55 = new Card("Smoke Cloud",	4,	"Keep",	"This card starts with 3 charges. Spend a charge for an extra reroll. Discard this card when all charges are spent.");
		Card c56 = new Card("Solar Powered",	2,	"Keep",	"At the end of your turn gain 1[Energy] if you have no [Energy].");
		Card c57 = new Card("Spiked Tail",	5,	"Keep",	"When you attack deal 1 extra damage.");
		Card c58 = new Card("Stretchy",	3,	"Keep",	"You can spend 2[Energy] to change one of your dice to any result.");
		Card c59 = new Card("Tanks",	4,	"Discard"	,"+ 4[Star] and take 3 damage.");
		Card c60 = new Card("Telepath",	4,	"Keep",	"Spend 1[Energy] to get 1 extra reroll.");
		Card c61 = new Card("Urbavore",	4,	"Keep",	"Gain 1 extra [Star] when beginning the turn in Tokyo. Deal 1 extra damage when dealing any damage from Tokyo.");
		Card c62 = new Card("Vast Storm",	6	,"Discard",	"+ 2[Star]. All other monsters lose 1[Energy] for every 2[Energy] they have.");
		Card c63 = new Card("We're Only Making It Stronger",	3,	"Keep",	"When you lose 2[Heart] or more gain 1[Energy].");
		Card c64 = new Card("Wings",	6,	"Keep",	"Spend 2[Energy] to negate damage to you for a turn.");
		Card c65 = new Card("Amusement Park",	6,	"Discard",	"+ 4[Star]");
		Card c66 = new Card("Army",	2,	"Discard", "+ 1[Star] and suffer one damage) for each card you have.");
		Card c67 = new Card("Cannibalistic",	5,	"Keep"	,"When you do damage gain 1[Heart].");
		Card c68 = new Card("Intimidating Roar",	3,	"Keep",	"The monsters in Tokyo must yield if you damage them.");
		Card c69 = new Card("Monster Sidekick",	4,	"Keep",	"If someone kills you, Go back to 10[Heart] and lose all your [Star]. If either of you or your killer win, or all other players are eliminated then you both win. If your killer is eliminated then you are also. If you are eliminated a second time this card has no effect.");
		Card c70 = new Card("Reflective Hide",	6,	"Keep",	"If you suffer damage the monster that inflicted the damage suffers 1 as well.");
		Card c71 = new Card("Sleep Walker",	3,	"Keep",	"Spend 3[Energy] to gain 1[Star].");
		Card c72 = new Card("Super Jump",	4,	"Keep",	"Once each turn you may spend 1[Energy] to negate 1 damage you are receiving.");
		Card c73 = new Card("Throw a Tanker",	4,	"Keep",	"On a turn you deal 3 or more damage gain 2[Star].");
		Card c74 = new Card("Thunder Stomp",	3,	"Keep",	"If you score 4[Star] in a turn, all players roll one less die until your next turn.");
		Card c75 = new Card("Unstable DNA",	3,	"Keep",	"If you yield Tokyo you can take any card the recipient has and give him this card.");
	}
}
