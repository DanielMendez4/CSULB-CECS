// Project5_HugeInteger.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 4/10/19

#include "pch.h"
#include "HugeInt.h"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	HugeInt n1(7654321);
	HugeInt n2(7891234);
	HugeInt n3("99999999999999999999999999999");
	HugeInt n4("1");
	HugeInt n5("12341234");
	HugeInt n6("7888");
	HugeInt result;

	cout << "n1 is " << n1 << "\nn2 is " << n2 << "\nn3 is " << n3 
		<< "\nn4 is " << n4 << "\nn5 is " << n5 << "\nn6 is " << n6 
		<< "\nresult is " << result << "\n\n";

	// Relational and Equality operators
	if (n1 == n2) { cout << "n1 equals n2" << endl; }

	if (n1 != n2) { cout << "n1 is not equal to n2" << endl; }

	if (n1 < n2) { cout << "n1 is less than n2" << endl; }

	if (n1 <= n2) { cout << "n1 is less than or equal to n2" << endl; }

	if (n1 > n2) { cout << "n1 is greater than n2" << endl; }

	if (n1 >= n2) { cout << "n1 is greater than or equal to n2" << endl; }

	// Arithmetic operators
	result = n1 + n2;
	cout << n1 << " + " << n2 << " = " << result << endl;

	result = n1 + 9;
	cout << n1 << " + " << 9 << " = " << result << endl;

	result = n2 + "10000";
	cout << n2 << " + " << "10000" << " = " << result << endl;

	result = n5 * n6;
	cout << n5 << " * " << n6 << " = " << result << endl;

	result = n5 - n6;
	cout << n5 << " - " << n6 << " = " << result << endl;
	
	result = n5 / n6;
	cout << n5 << " / " << n6 << " = " << result << endl;
	
	return 0;
}