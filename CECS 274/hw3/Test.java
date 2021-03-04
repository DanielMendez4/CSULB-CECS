package hw3;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		
		LinkedList<String> staff = new LinkedList<String>();
		staff.addFirst("Harry");
		staff.addFirst("Diana");
		staff.addFirst("Tom");
		System.out.println(staff.removeFirst());
		System.out.println(staff.removeFirst());
		System.out.println(staff.removeFirst());
		
		Stack<String> s = new Stack<String>();
		Stack<String> s2 = new Stack<String>();
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			s.push(Character.toString(alphabet));
		}
		
		while (s.size() > 0) {
			String temp = s.pop();
			s2.push(temp);
		}
		
		while (s2.size() > 0) {
			System.out.println(s2.pop());
		}
		
		LinkedList<String> staff2 = new LinkedList<String>();
		ListIterator<String> iter = staff2.listIterator();
		iter.add("Tom");
		iter.add("Diana");
		iter.add("Harry");
		iter = staff2.listIterator();
		iter.next();
		iter.next();
		iter.add("Romeo");
		iter.next();
		iter.add("Juliet");
		iter = staff2.listIterator();
		iter.next();
		iter.remove();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		pQueue.add(10);
		pQueue.add(3);
		stack.push(40);
		stack.push(5);
		queue.add(4);
		queue.add(15);
		while (pQueue.size() > 0) {
			if (pQueue.size() == 1) {
				System.out.print(pQueue.remove() + " ");
				break;
			} else {
				int temp = pQueue.remove();
				System.out.print(pQueue.remove() + " ");
				pQueue.add(temp);
			}
		}
		
		while (queue.size() > 0) {
			if (queue.size() == 1) {
				System.out.print(queue.remove() + " ");
				break;
			} else {
				int temp = queue.remove();
				System.out.print(queue.remove() + " ");
				queue.add(temp);
			}
		}
		
		while (stack.size() > 0) {
			System.out.print(stack.pop() + " ");
		}
	}
}
