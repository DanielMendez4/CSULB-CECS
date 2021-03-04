package week5;

public class Country implements Comparable<Object> {
	
	private String countryName;
	private int countryPop;
	
	/**
	 * default constructor
	 * creates a new Country object with name "N/A" and population 0
	 * **/
	public Country() {
		this.countryName = "N\\A";
		this.countryPop = 0;
	}
	
	
	/**
	 * overloaded constructor creates new object with given name and initial population
	 * @param name - the name of the country as a String
	 * @param iniPop - initial population as an integer
	 * **/
	public Country(String name, int iniPop) {
		this.countryName = name;
		this.countryPop = iniPop;
	}
	
	/**
	 * updates current population with current population
	 * @param newPop - new population as an integer
	 * **/
	public void updatePop(int newPop) {
		this.countryPop = newPop;
	}
	
	/**
	 * gets current population
	 * @return population as an integer
	 * **/
	public int getPop() {
		return this.countryPop;
	}
	
	/**
	 * gets the name of this country
	 * @return the name as String
	 * **/
	public String getName() {
		return this.countryName;
	}
	
	public String toString() {
		return "Name: " + countryName + "\t\tPopulation: " + countryPop;		
	}
	
	public int compareTo(Object o) {
		Country otherCountry = (Country) o;
		//if this population is smaller, should come first in the list
		//i.e. it should be to the left of the other country
		//we denote that with negative integer
		if (this.countryPop < otherCountry.countryPop) {
			return -1;
		//if populations are the same, return 0
		} else if (this.countryPop == otherCountry.countryPop) {
			return 0;
		//if population of the object is larger, should come after
		//i.e. it should be to the right of the other country
		//we denote that with positive integer
		} else {
			return 1;
		}
	}
}
