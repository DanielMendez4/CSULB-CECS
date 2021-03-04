package project2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Project2WriterDemo {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			aList.add(i);
		}
		String path = "C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\PriceListCopy.txt";
		FileWriter fileOut = new FileWriter(path, true);
		for (int j = 0; j < aList.size(); j++) {
			fileOut.write(String.format("%n%d", aList.get(j)));
		}
		fileOut.close();
	}
}
