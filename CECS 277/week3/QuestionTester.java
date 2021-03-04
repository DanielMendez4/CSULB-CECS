package week3;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionTester {
	
	/**
	 * Display a question, take and grade the response
	 * **/
	public static int presentGradeQuestion(Question question) {
		
		question.display();
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		boolean isCorrect = question.checkAnswer(response);
		if (isCorrect) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Sorry, your answer is incorrect!");
			System.out.println("Correct answer: " + question.getAnswer());
			return 0;
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Question> quiz = new ArrayList<Question>();
		
		quiz.add(new Question("What is the capitol of CA?", "Sacramento"));
		quiz.add(new Question("What is the capitol of the US?", "Washington D.C."));
		
		MCQuestion mc = new MCQuestion("Which animal below meows?");
		 mc.addChoice("giraffe",  false);
		 mc.addChoice("cat",  true);
		 mc.addChoice("hippo", false);
		 mc.addChoice("dog",  false);
		 
		 quiz.add(mc);
		
		// Example of the Substitution Principle
		// Can replace any arguments that are expected to be super class with subclass objects
		
		double score = 0;
		
		for (Question q : quiz) {
			score += presentGradeQuestion(q); // Example of Substitution Principle and Polymorphism
			// Polymorphism - when a method has a uniform behavior for objects of different subclasses
		}
		
		System.out.println("Score " + score + "/" + quiz.size());
	}
}
