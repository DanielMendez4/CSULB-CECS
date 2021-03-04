package week8;

public class ArrayUtil {
	
	/**
	 * Prints the input array
	 * @param array - an array of non primative types
	 * **/
	public static <E> void print(E[] array) {
		for (E ele: array) {
			System.out.print(ele + " ");
		}
	}
	
	/**
	 * Returns the minimum element contained in the array
	 * @param array - an array of non primative types
	 * @return the minimum element
	 * **/
	public static <E extends Comparable<E>> E min(E[] array) {
		E minEle = array[0];
		for (int i = 1; i < array.length; i++) {
			if (minEle.compareTo(array[i]) > 0) { 
				minEle = array[i];
			}
		}
		return minEle;
	}
	
	/**
	 * Swaps 2 elements in the array
	 * @param array - an array of non primative types
	 * @param i - index of one element to swap
	 * @param j - index of second element to swap
	 * **/
	public static <E> void swap(E[] array, int i, int j) {
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		String[] alph = {"Z", "B", "C"};
		Integer[] counts = {13,2,3,5};
		swap(alph, 0, 2);
		swap(counts, 1, 2);
		
		print(alph);
		System.out.println("");
		print(counts);
		System.out.println("\n" + min(alph));
	}
}