package arrayList;

import java.util.ArrayList;

public class ArrayListIntro {
	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alice");
		names.add("Bob");
		names.add("Connie");
		names.add("David");
		names.add("Edward");
		names.add("Fran");
		names.add("Fran");
		names.add("Gomez");
		names.add("Harry");
		System.out.println(names);
		
		System.out.println("The first name is: "+ names.get(0));
		int last = (names.size() - 1);
		System.out.println("The last name is: "+ names.get(last));
		System.out.println("");
		
		System.out.println("The length of the list is: " + names.size());
		System.out.println("");

		System.out.println("The last name is: "+ names.get((names.size() - 1)));
		System.out.println("");
		
		names.set(0, "Alice B. Toklas");
		System.out.println(names);
		System.out.println("");
		int david = (names.indexOf("David") + 1);
		names.add(david, "Doug");
		System.out.println(names);
		System.out.println("");
		
		for (String list : names)
			System.out.println(list);
		System.out.println(" ");
		
		ArrayList<String>names2 = new ArrayList<String>();
		for(int i = 0 ; i<names.size(); i++)
			names2.add(names.get(i));
		System.out.println("Name list two is: " + names2);
		
		System.out.println(" ");
		System.out.println("AFTER REMOVE:");
		
		names.remove(0);
		System.out.println("Name list one is: "+ names);
		System.out.println("Name list two is: "+ names2);
		}
}
