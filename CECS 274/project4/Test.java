package project4;

import java.util.Random;

public class Test {
	
	void bubbleSort(int arr[]) {
		
		int n = arr.length; 
	    for (int i = 0; i < n-1; i++) {
	    	for (int j = 0; j < n-i-1; j++) {
	    		if (arr[j] > arr[j+1]) {
	    			 int temp = arr[j]; 
	    			 arr[j] = arr[j+1]; 
	    			 arr[j+1] = temp;
	    		}
	    	}
	    }
	}
	
	// Prints the array
	void printArray(int arr[]) { 
	        
		int n = arr.length; 
	    for (int i=0; i<n; ++i) {
	    	System.out.print(arr[i] + " "); 
	    }
	    System.out.println();
	}
	
	public static int[] generateIntArray(int size, int maxVal) {
		
		int[] a = new int[size];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(maxVal); // Generating a random integer not exceeding the max value
		}
		return a;
	}
	
	// Driver method to test above 
	public static void main(String args[]) { 
		Test ob = new Test(); 
	    int arr[] = Test.generateIntArray(10, 30);
	    ob.bubbleSort(arr); 
	    System.out.println("Sorted array"); 
	    ob.printArray(arr);
	}
}