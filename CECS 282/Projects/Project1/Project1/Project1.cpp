// Project1_RationalTester.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 2/11/19
// Source for the reducing algorithm: https://www.daniweb.com/programming/software-development/threads/343139/creating-a-method-to-reduce-fractions 

#include "pch.h"
#include "numberH.h"
#include <string>
#include <iostream>

using namespace std;

// Runs the program
int main()
{
	int x;
	int y;
	cout << "Enter an integer for the numerator: ";
	cin >> x;
	cout << "Enter an integer for the denominator: ";
	cin >> y;
	while (y == 0) {
		if (y == 0) {
			cout << "The denominator can't be zero! Please try again: ";
			cin >> y;
		}
	}

	// Object Instantiation
	Rational r1;
	Rational r2(x, y);
	Rational result;
	Rational result2;

	result.add(r1, r2);
	cout << r1.getNumerator() << "/" << r1.getDenominator() << " + " << r2.getNumerator() << "/" << r2.getDenominator() << " = " << result.printRationalForm() << "\tFloat: " << result.printRationalFloat() << "\n";
	
	result2.subtract(r2);
	cout << r1.getNumerator() << "/" << r1.getDenominator() << " - " << r2.getNumerator() << "/" << r2.getDenominator() << " = " << result2.printRationalForm() << "\tFloat: " << result2.printRationalFloat() << "\n";
	
	result.multiply(r1, r2);
	cout << r1.getNumerator() << "/" << r1.getDenominator() << " * " << r2.getNumerator() << "/" << r2.getDenominator() << " = " << result.printRationalForm() << "\tFloat: " << result.printRationalFloat() << "\n";
	
	result.divide(r1, r2);
	cout << r1.getNumerator() << "/" << r1.getDenominator() << " / " << r2.getNumerator() << "/" << r2.getDenominator() << " = " << result.printRationalForm() << "\tFloat: " << result.printRationalFloat() << "\n";
}
