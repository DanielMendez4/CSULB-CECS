package week8;

public class RecursionHelperMethod {
	
	/**
	 * checks to see if the given string is a palindrome
	 * @param text - the string to check
	 * @return true if the text is a palindrome, false otherwise
	 * **/
	public static boolean isPalindrome(String text) {
		return isPalindrome(text, 0, text.length());
	}
	
	/*
	 * this is a recursive helper method that is used by the public 
	 * isPalindrome method
	 * */
	private static boolean isPalindrome(String text, int start, int end) {
		
		//BASE CASES
		if(end <= start) { return true;} //we made it to the middle
		//of the string without returning false
		
		char first = Character.toLowerCase( text.charAt(start) );
		char last = Character.toLowerCase( text.charAt(end-1) );
		
		if(Character.isLetter(first) && Character.isLetter(last)) {
			if(first == last) {
				return isPalindrome(text, start+1, end-1); //Recursive call
			}
			else {
				return false;
			}
		}
		else if(!Character.isLetter(first)) { //first character is not a letter
			
			return isPalindrome(text, start+1, end);
		}
		else { //the last character is not a letter
			
			return isPalindrome(text, start, end-1);
		}
		
	}

	public static void main(String[] args) {
		
		String text = "three";
		System.out.println(isPalindrome(text));
	}
}
