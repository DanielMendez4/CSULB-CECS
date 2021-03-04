package week8;

/**
 * Represents an object w/ 2 associated pieces of data
 * **/
public class Pair<T, S> {
	
	private T firstComp; // T will be the type of first component as specified by user
	private S secondComp; // S ... second component as specified by the user
	
	/**
	 * Default constructor creates a pair of null objects
	 * **/
	public Pair() {
		firstComp = null;
		secondComp = null;
	}
	
	/**
	 * Creates pair of objects with input data
	 * @param first - data that will be stored as the first compoenent
	 * @param second - data that will be stored as the second componenet
	 * **/
	public Pair(T first, S second) {
		firstComp = first;
		secondComp = second;
	}
	
	public String toString() {
		return "(" + firstComp + ", " + secondComp + ")"; 
	}
	
	public static void main(String[] args) {
		Pair<String , Integer> child1 = new Pair<String, Integer>();
		System.out.println(child1);
		
		Pair<String, Double> child2 = new Pair<String, Double>("Bob", 2.5);
		System.out.println(child2);
	}
}