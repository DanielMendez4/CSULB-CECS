package week3;

import java.util.ArrayList;

public class MCQuestion extends Question {
	
	private ArrayList<String> choices;

	public MCQuestion(String question) {
		super(question); // Initializes the instance variables of the super class
		
		choices = new ArrayList<String>();
	}
	
	public MCQuestion(String question, String answer) {
		super(question, answer); // Initialing both instance variables of the super class
		choices = new ArrayList<String>();
		choices.add(answer);
		
	}
	
	/**
	 * Adds a choice to this multiple choice question
	 * @param choice - possible answer
	 * @param isCorrect = true if given choice is correct answer, false otherwise
	 * **/
	public void addChoice(String choice, boolean isCorrect) {
		choices.add(choice);
		if (isCorrect) { // If given choice is correct answer, add it to the instance variable
			super.setAnswer(choice);
		}
	}
	
	/**
	 * Overrides the display method of the Question superclass so that it displays the question test and answer shoices
	 * 
	 * **/
	public void display() {
		super.display();
		int i = 1;
		for (String a: choices) {
			System.out.println(i + ". " + a);
			i++;
		}
	}
	
	
	/**
	 * Overrides the checkAnswer() method of the Question superclass
	 * If user enters a choice against the true answer, as opposed to the user input
	 * **/
	public boolean checkAnswer(String answer) {
		
		int c = Integer.parseInt(answer);
		String choice = choices.get(c - 1);
		return super.getAnswer().equals(choice); // Comparing the user's input choice against the real question.
	}

}
