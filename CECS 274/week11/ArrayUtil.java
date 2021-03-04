package week11;

import java.util.Random;

public class ArrayUtil {
	
	public static int[] generateIntArray(int size, int maxVal) {
		
		int[] a = new int[size];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(maxVal); // Generating a random integer not exceeding the max value
		}	
		return a;
	}
}
