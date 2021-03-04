package lab2;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
	
	public List<List<String>> permutationUtil(String[] arr) {
		
		List<List<String>> list = new ArrayList<>();
		swapUtil(list, new ArrayList<>(), arr);
		return list;
	}
 
	private void swapUtil(List<List<String>> list, List<String> resultList, String [] arr){
 
		// Base case
		if(resultList.size() == arr.length){
			list.add(new ArrayList<>(resultList));
		} 
		else{
			for(int i = 0; i < arr.length; i++){ 
 
				if(resultList.contains(arr[i])) 
				{
					// If element already exists in the list then skip
					continue; 
				}
				// Choose element
				resultList.add(arr[i]);
				// Explore
				swapUtil(list, resultList, arr);
				// Unchoose element
				resultList.remove(resultList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Test3 permutation = new Test3();
		
		String[] arr= {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		
		List<List<String>> permList = permutation.permutationUtil(arr);
		
		for(List<String> perm:permList) {
			System.out.println(perm);
		}	
	}
}
