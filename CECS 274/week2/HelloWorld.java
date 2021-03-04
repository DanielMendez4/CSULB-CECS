package week2;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.print("Hello World!");
		// System.out.print("Good day!");
		System.out.println("CSULB Students");
		System.out.println("Welcome!");
		//System.out.println(1/0);
		
		System.out.println("A");
		int i = 1;
		double price = 3.445;
		String product = "Chips Ahoy";
		//%s inserts string, \t inserts tab space, %.3f inserts double rounded to three decimal places
		System.out.printf("%d. Product: %s\t\tPrice: $%.2f\n", i, product, price);
		System.out.print("Where does this print?");
		//%d inserts an integer, \n prints a newline (i.e. skips to next line)
	}
}
