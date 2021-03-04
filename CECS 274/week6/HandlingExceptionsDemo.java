package week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HandlingExceptionsDemo {
	
	/**
	 * static method that reads and prints the contents of an external text file
	 * @param path - location of the file to read
	 * @throws FileNotFoundException 
	 * **/
	public static void readFile(String path) throws FileNotFoundException {
		
		File textFile = new File(path);
		Scanner fileReader = new Scanner(textFile);
		
		while (fileReader.hasNextLine()) {
			System.out.println(fileReader.nextLine());
		}
		fileReader.close();
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("Enter the path of the file to read: ");
			try {
				readFile(in.nextLine().trim());
				break;
			}
			catch (IOException e) {
				System.out.println("The file does not exist in the path specified! Please try again.");
			}
			finally {
				System.out.println("This will execute in any case.");
			}
		}
		in.close();
	}
}
