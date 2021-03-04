package week5;

import java.util.ArrayList;
import java.util.Collections;

public class CountryTester {

	public static void main(String[] args) {
		Country usa = new Country("USA", 300000);
		Country canada = new Country("Canada", 200000);
		usa.updatePop(1000000);
		
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(usa);
		countries.add(canada);
		System.out.println("\nBefore sort: ");
		System.out.println(countries);
		System.out.println("\nAfter sort: ");
		Collections.sort(countries);
		System.out.println(countries);
	}
}