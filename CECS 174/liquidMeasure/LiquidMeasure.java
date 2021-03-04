package liquidMeasure;

import java.util.Scanner;
/**
 * This program will calculate various Liquid Measurements.
 * @author Daniel Mendez & John Patrick Salcedo
 */
public class LiquidMeasure {
	private int gallons;
	private int quarts;
	private int cups;
	private int ounces;
	static int ouncesPerGallon = 128;
	static int ouncesPerQuart = 32;
	static int ouncesPerCup = 8;
	static int cupsPerQuart = 4;
	static int quartsPerGallon = 4;
	
	public LiquidMeasure(int gallons, int quarts, int cups, int ounces) {
		/**
		 * @param gallons number of gallons as an integer
		 * @param quarts  number of quarts as an integer
		 * @param cups    number of cups as an integer
		 * @param ounces  number of ounces as an integer
		 */
		this.gallons = gallons;
		this.quarts = quarts;
		this.cups = cups;
		this.ounces = ounces;
		this.normalize();
	}
	
	private void normalize() {
		/**
		 * Normalizes LiquidMeasure instance to distribute the total ounces accordingly.
		 */
		int max_ounces = maxOunces(this.gallons, this.quarts, this.cups, this.ounces);
		int final_gallons = max_ounces / ouncesPerGallon;
		max_ounces %= ouncesPerGallon;
		int final_quarts = max_ounces / ouncesPerQuart;
		max_ounces %= ouncesPerQuart;
		int final_cups = max_ounces / ouncesPerCup;
		max_ounces %= ouncesPerCup;
		int final_ounces = max_ounces / 1;
		max_ounces %= 1;
		this.gallons = final_gallons;
		this.quarts = final_quarts;
		this.cups = final_cups;
		this.ounces = final_ounces;
	}
	
	public int getGallons() {
		return gallons;
	}
	
	public int getQuarts() {
		return quarts;
	}
	
	public int getCups() {
		return cups;
	}
	
	public int getOunces() {
		return ounces;
	}
		
	public String toString() {
		/**
		 * @returns the total gallons, total quarts, total cups, and total ounces
		 */
		String result = String.format("%d gallons, %d quarts, %d cups, %d ounces", getGallons(), getQuarts(), getCups(), getOunces());
		return result;
	}
	
	public LiquidMeasure plus(LiquidMeasure other) {
		/**
		 * Adds an instance of LiquidMeasure to another instance of LiquidMeasure.
		 */
		return new LiquidMeasure(this.gallons + other.gallons, this.quarts + other.quarts, this.cups + other.cups, this.ounces + other.ounces);
	}
	
	public LiquidMeasure plus(int other) {
		/**
		 * Adds an instance of LiquidMeasure to an integer.
		 * The integer is treated as some number ounces.
		 */
		return new LiquidMeasure(this.gallons, this.quarts, this.cups, this.ounces + other);
	}
	
	public int totalOunces() {
		/**
		 * @returns the max number of ounces
		 */
		return maxOunces(this.gallons, this.quarts, this.cups, this.ounces);
	}
	
	public int maxOunces(int gallons, int quarts, int cups, int ounces) {
		/**
		 * Calculates the max number of ounces.
		 * @returns the max number of ounces in a LiquidMeasure instance
		 */
		int total_gallons = gallons * ouncesPerGallon;
		int total_quarts = quarts * ouncesPerQuart;
		int total_cups = cups * ouncesPerCup;
		int total_ounces = ounces;
		int max_ounces = (total_gallons + total_quarts + total_cups + total_ounces);
		return max_ounces;
	}
	
	public static void main(String[] args) {
		LiquidMeasure LM = new LiquidMeasure(4,3,2,1);
		System.out.println("First Liquid Measure: " + LM + " total ounces: " + LM.totalOunces());
		LiquidMeasure LM1 = LM.plus(80);
		System.out.println("First Liquid Measure + 80: " + LM1 + " total ounces: " + LM1.totalOunces());
		LiquidMeasure LM2 = new LiquidMeasure(0,0,-2,-2);
		System.out.println("LM2 = " + LM2 + " total ounces: " + LM2.totalOunces());
		System.out.println("LM + LM2 = " + LM.plus(LM2) + " total ounces: " + LM.plus(LM2).totalOunces());
		for (int i = LiquidMeasure.ouncesPerGallon; i > -1; i--) {
		LiquidMeasure LMfor = new LiquidMeasure(1,0,0,-i);
		System.out.println(LMfor + " total ounces: " + LMfor.totalOunces());
		}
		boolean done = false;
		Scanner in = new Scanner(System.in);
		while (!done) {
			System.out.print("Are you done? ");
			String dones = in.nextLine();
			if (dones.equals("y") || dones.equals("Y")) {
				System.out.println("OK then.");
				break;
			} else {
				System.out.print("Gallons: ");
				int gallons = in.nextInt();
				System.out.print("Quarts: ");
				int quarts = in.nextInt();
				System.out.print("Cups: ");
				int cups = in.nextInt();
				System.out.print("Ounces: ");
				int ounces = in.nextInt();
				in.nextLine();
				LiquidMeasure LMwhile = new LiquidMeasure(gallons, quarts, cups, ounces);
				System.out.println(LMwhile + " total ounces: " + LMwhile.totalOunces());
			}
		}
		in.close();
	}
}
