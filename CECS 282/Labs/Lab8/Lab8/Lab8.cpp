// Lab8.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/21/19

#include "pch.h"
#include "rationalH.h"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	// Object Instantiation
	Rational R1, R2, R3;
	cout << "Initial value: " << R1.printRationalForm() << "\n";
	R1 = R3 + R2;
	cout << "R3 + R2 = " << R1.printRationalForm() << "\tFloat: " << R1.printRationalFloat() << "\n";
	R1 = R3 - R2;
	cout << "R3 - R2 = " << R1.printRationalForm() << "\tFloat: " << R1.printRationalFloat() << "\n";
	return 0;
}