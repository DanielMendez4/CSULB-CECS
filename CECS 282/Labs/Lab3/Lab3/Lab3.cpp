// Lab3.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 2/19/19

#include "pch.h"
#include <iostream>
#include <string>

using namespace std;

// Displays the menu options
void displayMenu() {
	cout << "Select your operation:\n1. +\n2. -\n3. *\n4. /\n5. %\n6. Exit\n";
}

// Gets the menu selection from the user
// returns numVal, string
string getMenuSel() {
	string menuSel;
	cin >> menuSel;
	return menuSel;
}

// Checks to see if the menu selection input is an integer
// s is a string
// returns true if s isdigit, false otherwise
bool validateMenuSel(string s) {
	for (int i = 0; i < s.length(); i++) {
		if (isdigit(s[i]) == false) {
			return false;
		}
	}
	return true;
}

// Gets the number value from the user
// returns numVal, string
string getNumVal() {
	string numVal;
	cin >> numVal;
	return numVal;
}

// Checks to see if the number value input is an integer
// t is a string
// returns true if t isdigit, false otherwise
bool validateNumVal(string t) {
	for (int i = 0; i < t.length(); i++) {
		if (isdigit(t[i]) == false) {
			return false;
		}
	}
	return true;
}

// Calculates the sum of two integers
// a and b are integers
// returns sum of a and b, int
int add(int a, int b) {
	return a + b;
}

// Calculates the difference of two integers
// a and b are integers
// returns difference of a and b, int
int subtract(int a, int b) {
	return a - b;
}

// Calculates the product of two integers
// a and b are integers
// returns product of a and b, int
int multiply(int a, int b) {
	return a * b;
}

// Calculates the quotient of two integers
// a and b are integers
// returns quotient of a and b, int
int divide(int a, int b) {
	return a / b;
}

// Calculates the modulus of two integers
// a and b are integers
// returns modulus of a and b, int
int modulus(int a, int b) {
	return a % b;
}

// Runs the program
int main()
{
	string response;
	int decision;

	string num1;
	string num2;
	int x;
	int y;

	cout << "Welcome to my calculator! ";
	displayMenu();
	cout << "Operation: ";
	response = getMenuSel();
	while (!validateMenuSel(response)) {
		cout << "Invalid input! Please enter an integer: ";
		response = getMenuSel();
	}
	decision = stoi(response);

	while (decision != 6) {
		
		if (decision == 1) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);
			cout << "Enter an integer for y: ";
			num2 = getNumVal();
			while (!validateNumVal(num2)) {
				cout << "Invalid input! Please enter an integer: ";
				num2 = getNumVal();
			}
			y = stoi(num2);
			cout << x << " + " << y << " = " << add(x, y) << "\n";
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}
		else if (decision == 2) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);
			cout << "Enter an integer for y: ";
			num2 = getNumVal();
			while (!validateNumVal(num2)) {
				cout << "Invalid input! Please enter an integer: ";
				num2 = getNumVal();
			}
			y = stoi(num2);
			cout << x << " - " << y << " = " << subtract(x, y) << "\n";
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}
		else if (decision == 3) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);
			cout << "Enter an integer for y: ";
			num2 = getNumVal();
			while (!validateNumVal(num2)) {
				cout << "Invalid input! Please enter an integer: ";
				num2 = getNumVal();
			}
			y = stoi(num2);
			cout << x << " * " << y << " = " << multiply(x, y) << "\n";
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}
		else if (decision == 4) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);
			cout << "Enter an integer for y: ";
			num2 = getNumVal();
			while (!validateNumVal(num2)) {
				cout << "Invalid input! Please enter an integer: ";
				num2 = getNumVal();
			}
			y = stoi(num2);
			cout << x << " / " << y << " = " << divide(x, y) << "\n";
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}
		else if (decision == 5) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);
			cout << "Enter an integer for y: ";
			num2 = getNumVal();
			while (!validateNumVal(num2)) {
				cout << "Invalid input! Please enter an integer: ";
				num2 = getNumVal();
			}
			y = stoi(num2);
			cout << x << " % " << y << " = " << modulus(x, y) << "\n";
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}
		else {
			cout << "Invalid selection! Please try again!\n";
			displayMenu();
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}
		if (decision == 6) {
			cout << "Shutting down...";
		}
	}
	return 0;
}