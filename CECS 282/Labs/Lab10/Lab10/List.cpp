// List.cpp
#include "pch.h"
#include "List.h"
#include <string>
#include <iostream>

using namespace std;

List::List() {
	head = NULL;
	tail = NULL;
}

List::~List() {
	Node * n = this->head;
	Node * current = NULL;
	while (n) {	// begin removing elements from the list
		current = n;
		n = n->next;
		delete(current);
	}
	head = tail = NULL;
}

int List::size() {
	int size = 0;
	Node * current = new Node;
	current = head;
	while (current != NULL) {
		size++;
		current = current->next;
	}
	return size;
}

void List::add(string value) {
	Node * temp = new Node;
	temp->data = value;
	temp->next = NULL;
	if (head == NULL) {
		head = temp;
		tail = temp;
		temp = NULL;
	}
	else {
		tail->next = temp;
		tail = temp;
	}
}

void List::addHead(string value) {

}

void List::addPos(int pos, string value) {
	if (pos < 0 or pos > this->size()) {
		cout << "Out of range, insertion impossible!" << endl;
	}
	else {
		Node * previous = new Node;
		Node * current = new Node;
		Node * newest = new Node;
		current = head;
		for (int i = 0; i < pos; i++) {
			previous = current;
			current = current->next;
		}
		newest->data = value;
		previous->next = newest;
		newest->next = current;
	}
}

string List::deleteTail() {
	string deleteStr = "";
	Node * current = new Node;
	Node * previous = new Node;
	current = head;
	while (current->next != NULL) {
		previous = current;
		current = current->next;
	}
	tail = previous;
	previous->next = NULL;
	deleteStr = current->data;
	delete(current);
	return deleteStr;
}

string List::to_string() {
	string str = "";
	Node * temp = new Node;
	temp = head;
	while (temp != NULL) {
		str = str + temp->data + " ";
		temp = temp->next;
	}
	return str;
}