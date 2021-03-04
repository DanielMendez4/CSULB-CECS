package exam2;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public Queue() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		if (tail == null) { head = newNode; }
		else { tail.next = newNode; }
		tail = newNode;
	}
	
	public T remove() {
		if (head == null) { throw new NoSuchElementException(); }
		T temp = head.data;
		head = head.next;
		return temp;
	}
	
	public T peek() {
		if (head == null) { throw new NoSuchElementException(); }
		return head.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	private static class Node<T> {
		private T data;
		private Node<T> next;
	}
}