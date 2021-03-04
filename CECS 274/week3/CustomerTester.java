package week3;

public class CustomerTester {

	public static void main(String[] args) {
		Customer cauchy = new Customer(1);
		Customer newton = new Customer(2, 6000);
		
		cauchy.addPoints(30);
		cauchy.addPoints(2000);
		System.out.println(cauchy);
		System.out.println();
		System.out.println(newton);
	}
}