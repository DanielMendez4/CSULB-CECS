package project5;

public interface DemoIterator {
	
	/**
	 * Advances the iterator past the next element
	 * @return the data of the element that was just traversed
	 * @throws NoSuchElementException if there is no element to traverse
	 * **/
	public Object next();
	
	/**
	 * Determines if there is a next element
	 * @return true if there is a next element, false otherwise
	 * **/
	public boolean hasNext();
	
	/**
	 * Advances the iterator before the current element
	 * @return the data of the element before the current element
	 * @throws NoSuchElementException if there is no previous element
	 * **/
	public Object previous();
	
	/**
	 * Determines if there is a previous element
	 * @return true if there is a previous element, false otherwise
	 * **/
	public boolean hasPrevious();
	
	/**
	 * Adds a new element to the end of the linked list
	 * **/
	public void add(Object element);
	
	/**
	 * Removes an element from the end of the linked list, may only be called after a call to next() method
	 * @throws IllegalStateException if this method is called more than once in a row
	 * **/
	public Object remove();
	
	/**
	 * Sets the data for a current element
	 * **/
	public void set(Object element);

}
