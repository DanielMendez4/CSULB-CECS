// Lab11b.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 4/25/19

#include "pch.h"
#include "Stack.h"
#include <iostream>

int main()
{
	Stack<int> S1;
	S1.push(1);
	S1.push(2);
	S1.push(3);

	S1.printStack();

	S1.pop();

	S1.printStack();

	return 0;
}