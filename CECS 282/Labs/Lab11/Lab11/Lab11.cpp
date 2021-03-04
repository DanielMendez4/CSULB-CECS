// Lab11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 4/25/19

#include "pch.h"
#include "Stack.h"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	Stack<int> S1;
	cout << "Initializing stack..." << endl;
	S1.push(1);
	S1.push(2);
	S1.push(3);
	S1.push(4);
	S1.push(5);

	S1.printStack();

	cout << "Top of the stack: " << S1.peek() << endl;

	cout << "Popping... " << S1.pop() << endl;
	cout << "Popping... " << S1.pop() << endl;

	cout << "Top of the stack: " << S1.peek() << endl;

	cout << "Popping... " << S1.pop() << endl;

	if (S1.isEmpty()) {
		cout << "The stack is empty!" << endl;
	}
	else {
		cout << "The stack still has data!" << endl;
	}

	cout << "Popping... " << S1.pop() << endl;
	cout << "Popping... " << S1.pop() << endl;


	if (S1.isEmpty()) {
		cout << "The stack is empty!" << endl;
	}
	else {
		cout << "The stack still has data!" << endl;
	}

	cout << "Popping... " << S1.pop() << endl;

	return 0;
}