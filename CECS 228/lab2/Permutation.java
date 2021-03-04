package lab2;

public class Permutation {
	
	static int total;
	
	/**
	 * Prints out permutations for a given n and r
	 * @param input - string being used for the permutation
	 * @param start - starting index
	 * @param end - ending index
	 * @param r - r objects to be arranged
	 * **/
	private void permutationUtil(String input, int start, int end, int r) {
		if (start == r) {
			System.out.println(input.substring(0, r));
			total++;
		} else {
			for (int i = start; i <= end; i++) {
				input = swapUtil(input, start, i);
				permutationUtil(input, start + 1, end , r);
				input = swapUtil(input, start , i);
			}
		}
	}
	
	/**
	 * Swaps a character in the string to create a new permutation
	 * @param input - string being used to swap
	 * @param p1 - position 1
	 * @param p2 - position 2
	 * @return charArray as a swapped string
	 * 
	 * **/
	public String swapUtil(String input, int p1, int p2) {
		char temp;
		char[] charArray = input.toCharArray();
		temp = charArray[p1];
		charArray[p1] = charArray[p2];
		charArray[p2] = temp;
		return String.valueOf(charArray);
	}
	
	public static void main(String[] args) {
		
		total = 0;
		String input = "abcdefghi";
		int n = input.length();
		int r = 6;
		Permutation test1 = new Permutation();
		test1.permutationUtil(input, 0, n - 1, r);
		System.out.println("Total permutations: " + total);
	}
}
