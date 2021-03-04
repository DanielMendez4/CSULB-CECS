// CircularlyLinked.h
#pragma once
#ifndef CircularlyLinked_h
#define CircularlyLinked_h

#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

struct Node {
	int data;
	Node* next;
};

class CircularlyLinked {
private:
	Node* head;
	Node* tail;
public:
	// Constructor
	CircularlyLinked() {
		head = NULL;
		tail = NULL;
	}
	// Destructor
	~CircularlyLinked() { cout << "Destructor..." << endl; }
	// Gets the size of the circular linked list
	// Returns the size as an integer
	int size() {
		int size = 0;
		Node* current = new Node;
		current = head;
		while (current != NULL) {
			size++;
			current = current->next;
		}
		return size;
	}
	// Checks to see if the list is empty
	// Returns true if empty, false otherwise
	bool isEmpty() {
		if ((head == NULL) & (tail == NULL)) { return true; }
		else { return false; }
	}
	// Checks the first element of the list
	// Returns the first element of the list as an integer
	int first() {
		if (head == NULL) {
			cout << "Head is null..." << endl;
			return 0;
		}
		return head->data;
	}
	// Checks to see the last element of the list
	// Returns the last element of the list as an integer
	int last() {
		if (tail == NULL) {
			cout << "Tail is null..." << endl;
			return 0;
		}
		return tail->data;
	}
	// Adds an element to the front of the list
	// Value is an integer
	void addFirst(int value) {
		Node* newHead = new Node;
		newHead->data = value;
		newHead->next = NULL;
		if (head == NULL) {
			head = newHead;
		}
		else {
			Node* temp = head;
			newHead->next = temp;
			head = newHead;
		}
	}
	// Adds an element to the end of the list
	// Value is an integer
	void addLast(int value) {
		Node* newTail = new Node;
		newTail->data = value;
		newTail->next = head;
		if (tail == NULL) {
			tail = newTail;
		}
		else {
			Node* temp = tail;
			newTail->next = head;
			tail = newTail;
		}
	}
	// Removes the first element from the list
	// Returns the removed element as an integer
	int removeFirst() {
		if (head == NULL) {
			cout << "Head is null..." << endl;
			return 0;
		}
		Node* temp = new Node;
		temp = head;
		head = head->next;
		return temp->data;
	}
	// Removes the last element from the list
	// Returns the removed element as an integer
	int removeLast() {
		if (tail == NULL) {
			cout << "Tail is null..." << endl;
			return 0;
		}
		Node* temp = new Node;
		temp = tail;
		tail = tail->next;
		tail->next = head;
		return temp->data;
	}
	// Displays the circular linked list
	void display() {
		Node* temp = new Node;
		temp = head;
		while (temp != NULL) {
			if (temp == tail) {
				cout << temp->data;
				break;
			}
			cout << temp->data << " ";
			temp = temp->next;
		}
	}
	// Shows the circular linked list as a string
	// Returns circular linked list as a string
	string toString() {
		string circularLink = "";
		Node* temp = new Node;
		temp = head;
		while (temp != NULL) {
			if (temp == tail) {
				circularLink = circularLink + to_string(temp->data);
				break;
			}
			circularLink = circularLink + to_string(temp->data) + " ";
			temp = temp->next;
		}
		return circularLink;
	}
};
#endif // !CircularlyLinked_h