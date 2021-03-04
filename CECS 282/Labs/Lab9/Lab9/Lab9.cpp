// Lab9.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 4/9/19

#include "pch.h"
#include "Complex.h"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	Complex c1;
	Complex c2(2.00, 3.00);
	Complex c3(1.5, 2.5);

	c1 = c2 + c3;
	cout << "(" << c2 << ") + (" << c3 << ") = " << c1 << endl;

	c1 = c2 * c3;
	cout << "(" << c2 << ") * (" << c3 << ") = " << c1 << endl;

	cout << "(" << c2 << ")++ = ";
	cout << ++c2;
	return 0;
}