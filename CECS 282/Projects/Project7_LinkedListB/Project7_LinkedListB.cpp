// Project7_LinkedListB.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 5/1/19

#include "DoubleLinked.h"
#include <iostream>

using namespace std;

int main()
{
	DoubleLinked DL;
	DL.addFirst(1);
	DL.addFirst(2);
	DL.addLast(3);
	DL.addLast(4);
	cout << "Current double linked list: ";
	DL.display();
	cout << "\nThe first element is: " << DL.first() << endl;
	cout << "The last element is: " << DL.last() << endl;
	cout << "Double Linked List: " << DL.toString() << endl;
	cout << "Size of the double linked list: " << DL.size() << endl;
	if (DL.isEmpty()) { cout << "The list is empty!" << endl; }
	else { cout << "The list has data!" << endl; }
	cout << "Removing first: " << DL.removeFirst() << endl;
	cout << "Removing last: " << DL.removeLast() << endl;
	cout << "Current double linked list: ";
	DL.display();
	cout << "\nRemoving first: " << DL.removeFirst() << endl;
	cout << "Current double linked list: ";
	DL.display();
	cout << "\nThe first element is: " << DL.first() << endl;
	cout << "Removing first: " << DL.removeFirst() << endl;
	if (DL.isEmpty()) { cout << "The list is empty!" << endl; }
	else { cout << "The list has data!" << endl; }
	return 0;
}