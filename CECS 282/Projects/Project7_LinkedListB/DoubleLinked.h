// DoubleLinked.h
#pragma once
#ifndef DoubleLinked_h
#define DoubleLinked_h

#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

struct Node {
	int data;
	Node* next;
	Node* prev;
};

class DoubleLinked {
private:
	Node* head;
	Node* tail;
public:
	// Constructor
	DoubleLinked() {
		head = NULL;
		tail = NULL;
		/*head = new Node;
		tail = new Node;
		head->data = NULL;
		head->next = tail->prev;
		tail->prev = head->next;*/
	}
	// Destructor
	~DoubleLinked() { cout << "Destructor..." << endl; }
	// Gets the size of the doubly linked list
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
	// Checks the last element of the list
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
		else if (tail == NULL) {
			tail = head;
			head = newHead;
			head->next = tail;
			tail->prev = head;
		}
		else {
			newHead->next = head;
			head->prev = newHead;
			head = newHead;
		}
	}
	// Adds an element to the end of the list
	// Value is an integer
	void addLast(int value) {
		Node* newTail = new Node;
		newTail->data = value;
		newTail->next = NULL;
		if (tail == NULL) {
			tail = newTail;
		}
		tail->next = newTail;
		newTail->prev = tail;
		tail = newTail;
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
		if (head->next == tail) {
			head = tail;
			head->prev = NULL;
		}
		else if (head == tail) {
			head = NULL;
			tail = NULL;
		}
		else {
			head = head->next;
			head->prev->next = NULL;
			head->prev = NULL;
		}
		return temp->data;
	}
	// Removes the last element from the list
	// Returns the removed element as an integer
	int removeLast() {
		if (tail == NULL) {
			cout << "tail is null..." << endl;
			return 0;
		}
		Node* temp = new Node;
		temp = tail;
		if (tail->prev == head) {
			tail = NULL;
			head->next = NULL;
		}
		else if (tail == head) {
			tail = NULL;
			head = NULL;
		}
		else {
			tail = tail->prev;
			tail->next->prev = NULL;
			tail->next = NULL;
		}
		return temp->data;
	}
	// Displays the double linked list
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
	// Shows the double linked list as a string
	// Returns double linked list as a string
	string toString() {
		string dLinked = "";
		Node* temp = new Node;
		temp = head;
		while (temp != NULL) {
			if (temp == tail) {
				dLinked = dLinked + to_string(temp->data);
				break;
			}
			dLinked = dLinked + to_string(temp->data) + " ";
			temp = temp->next;
		}
		return dLinked;
	}
};
#endif // !DoubleLinked_h