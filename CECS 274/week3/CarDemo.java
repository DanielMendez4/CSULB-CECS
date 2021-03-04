package week3;

import java.util.Arrays;

public class CarDemo {
	
	public static void main(String[] args)  {
		
		Car ford = new Car();
		ford.setMakeModelYr("Ford Mustang 2001");
		
		Car tesla = new Car();
		tesla.setMakeModelYr("Telsa Model S 2018");
		
		ford.move('U');
		ford.move('U');ford.move('L');ford.move('L');ford.move('L');ford.move('D'); // (-3,1)
		
		tesla.move('R');tesla.move('R');tesla.move('R');tesla.move('R');tesla.move('R');
		tesla.move('R');tesla.move('U');
		
		System.out.println("The position of the " + ford.getMakeModelYr()+ " is: " + Arrays.toString(ford.getPosition()));
		System.out.println("The position of the " + tesla.getMakeModelYr()+ " is " + Arrays.toString(tesla.getPosition()));
		System.out.println(ford);
		System.out.println(tesla);
	}
}
