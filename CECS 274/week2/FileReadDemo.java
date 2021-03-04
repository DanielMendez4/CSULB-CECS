package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * In this program, we will read from text file
 */
public class FileReadDemo {
	
	//throws FileNotFoundException letting you know what is going to happen if file is not found in the location specified
	//Program will display error message (exception) and crash.
	public static void main(String[] args) throws FileNotFoundException {
		
		//STEP 1: CREATE FILE OBJECT USING DIRECTORY OF THE TEXT FILE
		File textfile = new File("C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\Hello.txt");
		//STEP 2: CREATE SACCNER TOO READ THE FILE
		Scanner fileReader = new Scanner(textfile);
		//STEP 3: PROCESS/READ THE FILE USING THE Scanner METHODS
		while (fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			System.out.println(currentLine);
		}
		//STEP 4: CLOSE THE READER TO PROTECT THE EXTERNAL TEXT FILE
		fileReader.close();
	}
}

// Regex101
// \w: matches A-Z, a-z, 0-9
// \d: matches 0-9
// \s: matches a single space
// .: matches any character
// +: add-on to signify matching one or more instances of the preceding flag
// ( ): used to capture and separate parts of the string
// Ex. \w+: Match one or more word characters
// ([\w|\s]+)\s.+\s([\d|-]+)