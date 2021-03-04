package project5;

import java.util.NoSuchElementException;

public class DLinkedList {
	
	private Node first;
	private Node last;
	
	// Constructs an empty doubly linked list
	public DLinkedList() {
		first = null;
		last = null;
	}
	
	/*---- Instance methods of DLinkedList ----*/
	
	/**
	 * Adds element to the front of the list
	 * @param element - element to be added
	 * **/
	public void addFirst(Object element) {
		Node newNode = new Node(element);
		if (first == null) {
			first = newNode;
		} else if (last == null) {
			last = first;
			first = newNode;
			first.next = last;
			last.previous = first;
		} else {
			newNode.next = first;
			first.previous = newNode;
			first = newNode;
		}
	}
	
	/**
	 * Adds element to the end of the list
	 * @param element - element to be added
	 * **/
	public void addLast(Object element) {
		Node newNode = new Node(element);
		if (last == null) {
			last = newNode;
		}
		last.next = newNode;
		newNode.previous = last;
		last = newNode;
	}
	
	/**
	 * Gets the first element in the doubly linked list
	 * @return first element in doubly linked list
	 * **/
	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	/**
	 * Gets the last element in the doubly linked list
	 * @return last element in the doubly linked list
	 * **/
	public Object getLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		return last.data;
	}
	
	/**
	 * Removes the first element in the doubly linked list
	 * @return the removed element
	 * **/
	public Object removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Object temp = first.data;
		if (first.next == last) {
			first = last;
			first.previous = null;
		} else {
			first = first.next;
			first.previous.next = null;
			first.previous = null;
		}
		return temp;
	}
	
	/**
	 * Removes the last element in the doubly linked list
	 * @return the removed element
	 * **/
	public Object removeLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		Object temp = last.data;
		if (last.previous == first) {
			last = null;
			first.next = null;
		} else {
			last = last.previous;
			last.next.previous = null;
			last.next = null;
		}
		return temp;
	}
	
	/**
	 * Returns an iterator for iterating through this list
	 * @return a new iterator
	 * **/
	public ListIterator listIterator() {
		return new LinkedListIterator();
	}
	
	/**
	 * Checks to see if a certain element is in the doubly linked list
	 * @return true if the element is in the list; false otherwise
	 * **/
	public boolean contains(Object element) {
		Node current = first;
		while (current != null) {
			if (current.data == element) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	/*---- INNER CLASSES (i.e. PRIVATE CLASSES) ----*/
	
	class Node {
		
		public Object data;
		public Node next;
		public Node previous;
		
		// Constructor for a new node
		Node(Object newNode) {
			data = newNode;
			next = null;
			previous = null;
		}
	}
	
	class LinkedListIterator implements ListIterator {
		
		private Node position;
		private Node previous;
		private boolean isNext;
		//private boolean isPrevious;
		
		// Constructs an iterator that points to the front of the linked list
		public LinkedListIterator() {
			position = null;
			previous = null;
			isNext = false;
			//isPrevious = false;
		}
		
		/**
		 * Advances the iterator past the next element
		 * @return the data of the element that was just traversed
		 * @throws NoSuchElementException if there is no element to traverse
		 * **/
		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (position == null) {
				position = first;
				isNext = true;
				return position.data;
			}
			previous = position;
			position = position.next;
			isNext = true;
			return position.data;
		}
		
		/**
		 * Determines if there is a next element
		 * @return true if there is a next element, false otherwise
		 * **/
		@Override
		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}
		
		/**
		 * Advances the iterator before the current element
		 * @return the data of the element before the current element
		 * @throws NoSuchElementException if there is no previous element
		 * **/
		@Override
		public Object previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (position == null) {
				position = last;
				isNext = true;
				return position.data;
			}
			Object temp = position.data;
			position = previous;
			previous = position.previous;
			
			isNext = true;
			//isPrevious = true;
			return temp;
		}
		
		/**
		 * Determines if there is a previous element
		 * @return true if there is a previous element, false otherwise
		 * **/
		@Override
		public boolean hasPrevious() {
			if (position == null) {
				return last != null;
			} else {
				return previous != null;
			}
		}
		
		/**
		 * Adds a new element to the end of the linked list
		 * **/
		@Override
		public void add(Object element) {
			if (position == null) {
				addFirst(element);
			} else if (last == null) {
				addLast(element);
			} else {
				Node newNode = new Node(element);
				newNode.next = position.next;
				position.next.previous = newNode;
				newNode.previous = position;
				position.next = newNode;
				position = newNode;
			}
			isNext = false;
		}
		
		/**
		 * Removes an element from the end of the linked list, may only be called after a call to next() method
		 * @throws IllegalStateException if this method is called more than once in a row
		 * **/
		@Override
		public Object remove() {
			if (!isNext) {
				throw new IllegalStateException();
			}
			isNext = false;
			
			Node current = position.next;
			
			if (position == first) {
				Object temp = position.data;
				removeFirst();
				return temp;
			}
			if (position.next == null) {
				Object temp = position.data;
				removeLast();
				return temp;
			} else {
				Object temp = position.data;
				previous.next = position.next;
				current.previous = previous;
				current = null;
				position.previous = null;
				return temp;
			}
		}
		
		/**
		 * Sets the data for a current element
		 * **/
		@Override
		public void set(Object element) {
			if (!isNext) {
				throw new IllegalStateException();
			}
			position.data = element;
			position.next = null;
		}
	}
}
