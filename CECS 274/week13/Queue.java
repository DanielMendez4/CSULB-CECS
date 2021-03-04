package week13;

import java.util.NoSuchElementException;

public class Queue {
	
	private Node head;
	private Node tail;
	
	// Initializes empty queue
	public Queue() {
		head = null;
		tail = null;
	}
	
	/**
	 * Adds element to the queue
	 * @param data - new data
	 * **/
	public void add(Object data) { // Basically addLast
		Node newNode = new Node();
		newNode.data = data;
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}
	
	/**
	 * Removes top element in the queue
	 * @return removed element
	 * **/
	public Object remove() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Object temp = head.data;
		head = head.next;
		return temp;
	}
	
	/**
	 * Get first element of the queue
	 * **/
	public Object peek() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}
	
	// Inner class
	class Node {
		public Object data;
		public Node next;
	}
	
	

}
