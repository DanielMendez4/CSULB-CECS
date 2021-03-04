package homeGrownArrayList;
/**
 * Authors: Daniel Mendez & John Patrick Salcedo
 * This program does not meet the functionality that is desired.
 * Unfortunately, we were unable to figure out how to get this code to work.
 * This is what we have though it is incomplete.
public class ArrayList {
	private String[] array;
	private int used;
	
	public Arraylist() {
		array = new String[2];
		used = 0;
	}
	
	public Arraylist(Arraylist other) {
		this();
		for (int i = 0; i < other.size(); i++) {
			this.add(other.get(i));
		}
	}
	
	public void makeLarger() {
		array = new String[array.length * 2];
		array.clone();
	}
	
	public String toString() {
		String result = String.format(array);
		return result;
	}
	
	public String get(int index) {
		if (index < 0 || index > this.size()) {
			throw new ArrayIndexOutOfBoundsException("Arraylist index out of bounds!");
		}
		return array[index];
	}
	
	public int size() {
		return array.length;
	}
	
	public void set(int index, String value) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Arraylist index out of bounds!");
		} else {
			new_array[index] = value;
		}
	}
	
	public void add(String value) {
		if (used == array.length) {
			this.makeLarger();
		}
		this.array[used++] = value;
	}
	
	public void add(int index, String value) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Arraylist index out of bounds!");
		} else {
			array[index] = value;
		}
	}
	
	public void remove(int index) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException("Arraylist index out of bounds!");
		} else {
			for (int i = index; i < this.size() - 1; i++) {
				array[i] = array[i + 1];
			}
		}
	}

	public static void main(String[] args) {
		Arraylist names = new Arraylist();
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
}*/
