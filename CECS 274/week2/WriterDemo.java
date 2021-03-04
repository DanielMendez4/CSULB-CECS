package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriterDemo {
	
	public static void main(String[] args) throws FileNotFoundException {
			
		File textfile = new File("C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\tollfreecomplete.txt");
			
		Scanner fileReader = new Scanner(textfile);
			
		//STEP 1: CREATE PrintWriter OBJECT SPECIFYING LOCATION OF FILE THAT IS TO BE WRITTEN
			
		PrintWriter fileWriter = new PrintWriter("C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\newtollfreecomplete.txt");
		Pattern p = Pattern.compile("([\\w|\\s|-]+)\\s+[.]+\\s([\\d|-]+)");
		Matcher m;
			
		while (fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			m = p.matcher(currentLine);
				
			if (m.find()) { //Checks to see is current line matched the pattern
				String companyName = m.group(1);
				String companyPh = m.group(2);
					
				//STEP 2: WRITE TO THE TEXT FILE USING METHODS OF PrintWriter WHICH ARE SAME AS print(), println(), printf()
					
				fileWriter.printf("Company Name: %-50s Ph: %s", companyName, companyPh);
				fileWriter.println();
			}
		}
		//STEP 4: CLOSE THE READER TO PROTECT EXTERNAL TEXT FILE
		fileWriter.close();
		fileReader.close();
	}
}
// %s: insert string
// %50s: insert a string allowing for 50 characters, aligned to the right
// %-50s: aligned to the left