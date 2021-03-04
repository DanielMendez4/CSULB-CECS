package week2;
import java.util.Scanner;

public class InputDemo {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Hello, what is your name? ");
		String name = in.nextLine();
		System.out.println("Lovely to meet you, " + name +"!");
		System.out.print("How old are you? ");
		int age = Integer.parseInt(in.nextLine().trim());
		System.out.println("Wow! " + age + " years young!");
		in.close();
	}

}
