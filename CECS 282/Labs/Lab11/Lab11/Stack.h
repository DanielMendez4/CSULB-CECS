// Stack.h
#pragma once
#ifndef Stack_h
#define Stack_h

#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

template <typename T>
struct Node {
	T data;
	Node * next;
};

template <typename T>
class Stack {
private:
	Node<T> * head;
public:
	// Constructor
	Stack() { head = NULL; }
	// Destructor
	~Stack() {
		Node<T> * n = this->head;
		Node<T> * current = NULL;
		while (n) {
			current = n;
			n = n->next;
			delete(current);
		}
		head = NULL;
	}
	// Adds a new element to the top of the stack
	// Value can be any type related to the stack
	void push(T value) {
		Node<T> * newHead = new Node<T>;
		newHead->data = value;
		newHead->next = NULL;
		if (head == NULL) {
			head = newHead;
		}
		else {
			Node<T> * temp = head;
			newHead->next = temp;
			head = newHead;
		}
	}
	// Removes the top element from the stack
	// Returns the element that was popped
	T pop() {
		if (isEmpty()) {
			cout << "Stack is empty..." << endl;
			return -1;
		}
		else {
			Node<T> * temp = head;
			head = head->next;
			return temp->data;
		}
	}
	// Shows the top of the stack
	// Returns the element at the top of the stack
	T peek() { return head->data; }
	// Checks if the stack is empty
	// Returns true if the head is null, false otherwise
	bool isEmpty() { return head == NULL; }
	// Prints the stack
	void printStack() {
		Node<T> * temp = new Node<T>;
		temp = head;
		while (temp != NULL) {
			cout << temp->data << "\n";
			temp = temp->next;
		}
	}
};
#endif // !Stack_h
