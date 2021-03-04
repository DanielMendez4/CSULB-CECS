// Lab1.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 1/24/19.

#include "pch.h"
#include <iostream>
using namespace std;

// Calculates the sum of two integers
// a is an int, b is an int
// returns the sum of a and b, int
int Sum(int a, int b)
{
	return a + b;
}

// Calculates the product of two integers
// a is an int, b is an int
// returns the product of a and b, int
int Multiply(int a, int b)
{
	return a * b;
}

// Calculates the difference of two integers
// a is an int, b is an int
// returns the difference of a and b, int
int Subtract(int a, int b)
{
	return a - b;
}

// Calculates the quotient of two integers
// a is an int, b is an int
// returns the quotient of a and b, int
int Divide(int a, int b)
{
	return a / b;
}

int getVal()
{
	int x;
	cin >> x;
	return x;
}


// Runs the program
int main()
{
	int a;
	int b;
	cout << "Please enter an integer value for a: ";
	cin >> a;
	// a = getVal();
	cout << "Please enter an integer value for b: ";
	cin >> b;
	// b = getVal();
	cout << "The sum of a + b is " << Sum(a, b) << ".\n";
	cout << "The product of a * b is " << Multiply(a, b) << ".\n";
	cout << "The difference of a - b is " << Subtract(a, b) << ".\n";
	cout << "The quotient of a / b is " << Divide(a, b) << ".\n";
	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu