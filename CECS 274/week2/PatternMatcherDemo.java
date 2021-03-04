package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherDemo {

	public static void main(String[] args) throws FileNotFoundException {
			
		File textfile = new File("C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\tollfreecomplete.txt");
			
		Scanner fileReader = new Scanner(textfile);
		//STEP 1: CREATE Pattern OBJECT USING APPROPRIATE REGEX
		Pattern p = Pattern.compile("([\\w|\\s|-]+)\\s+[.]+\\s([\\d|-]+)");
		//STEP 2: DECLARE Matcher VARIALBE
		Matcher m;
		
		while (fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			//STEP 3: MATCH THE CURRENT LINE TO THE PATTERN
			m = p.matcher(currentLine);	
			if (m.find()) { //Checks to see is current line matched the pattern		
				//System.out.println(m.group(0)); //Shows the whole string that was matched
				System.out.println(m.group(1)); //Shows first group matched
				System.out.println(m.group(2)); //Shows second group matched
				System.out.println();
			}
		}
		fileReader.close();
	}
}

// .: Matches any character
// [.]: Matches . only
// [.]+: Match several .'s only