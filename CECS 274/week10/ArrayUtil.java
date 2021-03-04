package week10;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {
	
	/**
	 * Returns the index of the smallest element to the right of the given starting index in the given array
	 * @param a - the array of integers
	 * @param start - the starting index of where to look for minimum element
	 * **/
	public static int minElementPos(int[] a, int start) {
		
		int idxMIN = start;
		for (int i = start + 1; i < a.length; i++) {
			if (a[i] < a[idxMIN]) {
				idxMIN = i; // Update the index because we found smaller element
			}
		}
		return idxMIN;
	}
	
	
	/**
	 * Swaps two elements in a given array
	 * @param a - an array of integers
	 * @param i - index of one of the elements to swap
	 * @param j - index of the second element to swap
	 * **/
	public static void swapElement(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * Generates an array of integers with given size and max value
	 * @param size - size of the array
	 * @param maxVal - max element value in the array
	 * **/
	public static int[] generateIntArray(int size, int maxVal) {
		
		int[] a = new int[size];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(maxVal); // Generating a random integer not exceeding the max value
		}
		
		return a;
	}
	
	
	public static void main(String[] args) {
		
		int[] ages = generateIntArray(10, 15);
		
		System.out.println("BEFORE: " + Arrays.toString(ages));
		swapElement(ages, 2, 4);
		System.out.println("AFTER: " + Arrays.toString(ages));
	}
}