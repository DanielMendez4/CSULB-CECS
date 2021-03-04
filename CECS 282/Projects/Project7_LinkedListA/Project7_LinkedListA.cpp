// Project7_LinkedListA.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 5/1/19

#include "CircularlyLinked.h"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	CircularlyLinked CL;
	CL.addFirst(1);
	CL.addFirst(2);
	CL.addFirst(3);
	CL.addLast(4);
	cout << "Current circular linked list: ";
	CL.display();
	cout << "\nThe first element is: " << CL.first() << endl;
	cout << "The last element is: " << CL.last() << endl;
	cout << "Circular Linked List: " << CL.toString() << endl;
	cout << "Size of the circular linked list: " << CL.size() << endl;
	if (CL.isEmpty()) { cout << "The list is empty!" << endl; }
	else { cout << "The list has data!" << endl; }
	cout << "Removing first: " << CL.removeFirst() << endl;
	cout << "Removing last: " << CL.removeLast() << endl;
	cout << "Current circular linked list: ";
	CL.display();
	cout << "\nRemoving first: " << CL.removeFirst() << endl;
	cout << "Current circular linked list: ";
	CL.display();
	cout << "\nThe first element is: " << CL.first() << endl;
	cout << "Removing first: " << CL.removeFirst() << endl;
	if (CL.isEmpty()) { cout << "The list is empty!" << endl; }
	else { cout << "The list has data!" << endl; }
	return 0;
}