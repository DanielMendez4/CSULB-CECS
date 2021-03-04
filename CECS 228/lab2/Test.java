package lab2;

public class Test {
	
	static int total;
		
	 public static void main(String[] args) {
		 total = 0;
		 String str = "abcdefghi";
	     int n = str.length();
	     int r = 6;
	     Test permutation = new Test(); 
	     permutation.permute(str, 0, n-1, r);
	     System.out.println("Total permutations: " + total);
	 }
	  
	 /** 
	  * permutation function 
	  * @param str - string to calculate permutation for 
	  * @param start - starting index 
	  * @param end -  end index 
	  */
	 private void permute(String str, int start, int end, int r) {
		 if (start == r) {
			 System.out.println(str.substring(0, r));
			 total++;
		 } else { 
			 for (int i = start; i <= end; i++) { 
				 str = swap(str, start, i); 
	             permute(str, start + 1, end, r); 
	             str = swap(str, start, i); 
			 }
		 }
	 }
	 
	 /** 
	  * Swap Characters at position 
	  * @param a string value 
	  * @param i position 1 
	  * @param j position 2 
	  * @return swapped string 
	  */
	 public String swap(String a, int i, int j) { 
		 char temp; 
	     char[] charArray = a.toCharArray(); 
	     temp = charArray[i] ; 
	     charArray[i] = charArray[j]; 
	     charArray[j] = temp; 
	     return String.valueOf(charArray); 
	 }
}
