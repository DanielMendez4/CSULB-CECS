package week8;

public class RecursionDemo {
	
	public static boolean isPalindrome(String text) {
		
		int size = text.length();
		// BASE CASES
		if (size <= 1) {
			return true; // empty string or string size 1 is a palindrome
		}
		
		char first = Character.toLowerCase(text.charAt(0));
		char last = Character.toLowerCase(text.charAt(size-1));
		
		if (Character.isLetter(first) && Character.isLetter(last)) {
			if (first == last) {
				String substring = text.substring(1, size-1);
				return isPalindrome(substring); // Recursive call
			}
			else {
				return false;
			}
		}
		else if (!Character.isLetter(first)) { // first character is not a letter
			String substring = text.substring(1); // omits the first character
			return isPalindrome(substring);
		}
		else { // last character is not a letter
			String substring = text.substring(0, size-1); // omits the last character
			return isPalindrome(substring);
		}
	}
	
	public static void main(String[] args) {
		
		String text = "Go hang a salami, I'm a lasagna hog!";
		System.out.println(isPalindrome(text));
	}
}
