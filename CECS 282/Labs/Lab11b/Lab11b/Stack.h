// Stack.h
#pragma once
#ifndef Stack_h
#define Stack_h

#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

template <typename T>
class Stack {
private:
	T stack[5];
	int count;
public:
	// Constructor
	Stack() {
		stack[10];
		count = 0;
	}
	// Destructor
	~Stack() { cout << "Destructor..."; }
	// Adds a value to the stack
	// value can be any type relating to the stack
	void push(T value) {
		for (int i = (sizeof(stack) / sizeof(stack[0])) - 1; i > 0 ; i--) {
			stack[i] = stack[i - 1];
		}
		stack[0] = value;
		count++;
	}
	// Removes element from the top of the stack
	// Returns the element that was removed
	T pop() {
		T temp = stack[0];
		for (int i = 0; i < (sizeof(stack) / sizeof(stack[0])) - 1; i++) {
			stack[i] = stack[i + 1];
		}
		count--;
		return temp;
	}
	// Shows the top element
	// Returns the top element
	T peek() {
		return stack[0];
	}
	// Checks to see if the stack is empty
	// returns true if empty, false otherwise
	bool isEmpty() {
		return stack[0] == NULL;
	}
	// Prints the stack
	void printStack() {
		for (int i = 0; i < count; i++) {
			cout << stack[i] << endl;
		}
	}
};

#endif // !Stack_h
