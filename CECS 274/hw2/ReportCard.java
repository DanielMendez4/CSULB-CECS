package hw2;

import java.util.ArrayList;

public class ReportCard {
	
	public static void main(String[] args) {
		
		ArrayList<Records> myReportCard = new ArrayList<Records>();
		Records record1 = new Records("Math", "A");
		Records record2 = new Records("Science", "B");
		Records record3 = new Records("English", "B");
		Records record4 = new Records("Computer Science", "A");
		Records record5 = new Records();
		
		record5.setClass("Theatre");
		record5.setGrade("B");
		
		myReportCard.add(record1);
		myReportCard.add(record2);
		myReportCard.add(record3);
		myReportCard.add(record4);
		myReportCard.add(record5);
		
		double points = 0.00;
		for (int i = 0; i < myReportCard.size(); i++) {
			if (myReportCard.get(i).getGrade().equals("A")) {
				points = points + 4;
			}
			if (myReportCard.get(i).getGrade().equals("B")) {
				points = points + 3;
			}
			if (myReportCard.get(i).getGrade().equals("C")) {
				points = points + 2;
			}
			if (myReportCard.get(i).getGrade().equals("D")) {
				points = points + 1;
			}
			if (myReportCard.get(i).getGrade().equals("F")) {
				points = points + 0;
			}
		}
		
		double GPA = points/myReportCard.size();
		
		System.out.println("Name: Daniel");
		System.out.println("ID: 016423496");
		for (int j = 0; j < myReportCard.size(); j++) {
			System.out.println(myReportCard.get(j));
		}
		String editGPA = Double.toString(GPA);
		System.out.printf("%nGPA: %s", editGPA);
	}
}
