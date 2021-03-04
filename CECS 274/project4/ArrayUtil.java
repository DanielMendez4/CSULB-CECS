package project4;

import java.util.Random;

public class ArrayUtil {
	
	/**
	 * Swaps two elements in a given array
	 * @param a - an array of doubles
	 * @param j - index of the second element to swap
	 * **/
	public static void swapElement(double[] a, int j) {
		
		double temp = a[j];
		a[j] = a[j+1]; 
		a[j+1] = temp;
	}
	
	/**
	 * Generates an array of doubles with given size and max value
	 * @param size - size of the array
	 * @param maxVal - max element value in the array
	 * **/
	public static double[] generateDoubleArray(int size, int maxVal) {
		
		double[] a = new double[size];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(maxVal); // Generating a random integer not exceeding the max value
		}
		return a;
	}
}