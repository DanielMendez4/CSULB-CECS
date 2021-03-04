// Project2_Calculator.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 2/25/19

#include "pch.h"
#include <iostream>
#include <string>

using namespace std;

// Displays the menu options
void displayMenu() {

	cout << "Select your operation:\n1. +\n2. -\n3. *\n4. /\n5. %\n6. AND\n7. OR\n8. NOR\n9. XOR\n10. 2's Complement\n11. 1's Complement\n12. Exit\n";
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

// Performs AND on two integers
// a and b are integers
// returns the AND of a and b, int
int AND(int a, int b) {

	int binaryNum1 = 0;
	int r1;
	int i = 1;
	while (a != 0) {
		r1 = a % 2;
		a /= 2;
		binaryNum1 += r1 * i;
		i *= 10;
	}
	string binaryString1 = to_string(binaryNum1);

	int binaryNum2 = 0;
	int r2;
	int j = 1;
	while (b != 0) {
		r2 = b % 2;
		b /= 2;
		binaryNum2 += r2 * j;
		j *= 10;
	}
	string binaryString2 = to_string(binaryNum2);

	int strDiff;
	if (binaryString1.length() < binaryString2.length()) {

		strDiff = binaryString2.length() - binaryString1.length();
	}
	else if (binaryString1.length() > binaryString2.length()) {

		strDiff = binaryString1.length() - binaryString2.length();
	}

	string ANDstring = "";
	int ANDStrLength;

	if (binaryString1.length() < binaryString2.length()) {

		ANDStrLength = binaryString2.length();
	}
	else {
		ANDStrLength = binaryString1.length();
	}

	for (int k = 0; k < ANDStrLength; k++) {

		if (binaryString1[k] == '1' && binaryString2[k] == '1') {
			ANDstring = ANDstring + '1';
		}
		else {
			ANDstring = ANDstring + '0';
		}
	}
	int ANDStringConvert = stoi(ANDstring);
	int decimalVal = 0;
	int base = 1;
	int temp = ANDStringConvert;

	while (temp) {

		int lastDigit = temp % 10;
		temp = temp / 10;
		decimalVal += lastDigit * base;
		base = base * 2;
	}
	return decimalVal;
}

// Performs OR on two integers
// a and b are integers
// returns the OR of a and b, int
int OR(int a, int b) {

	int binaryNum1 = 0;
	int r1;
	int i = 1;
	while (a != 0) {
		r1 = a % 2;
		a /= 2;
		binaryNum1 += r1 * i;
		i *= 10;
	}
	string binaryString1 = to_string(binaryNum1);

	int binaryNum2 = 0;
	int r2;
	int j = 1;
	while (b != 0) {
		r2 = b % 2;
		b /= 2;
		binaryNum2 += r2 * j;
		j *= 10;
	}
	string binaryString2 = to_string(binaryNum2);

	int strLength;
	if (binaryString1.length() < binaryString2.length()) {
		strLength = binaryString2.length();
	}
	else {
		strLength = binaryString1.length();
	}

	string ORstring = "";
	int ORStrLength;

	if (binaryString1.length() < binaryString2.length()) {

		ORStrLength = binaryString2.length();
	}
	else {
		ORStrLength = binaryString1.length();
	}

	for (int k = 0; k < ORStrLength; k++) {

		if (binaryString1[k] == '0' && binaryString2[k] == '0') {
			ORstring = ORstring + '0';
		}
		else {
			ORstring = ORstring + '1';
		}
	}
	int ORStringConvert = stoi(ORstring);
	int decimalVal = 0;
	int base = 1;
	int temp = ORStringConvert;

	while (temp) {

		int lastDigit = temp % 10;
		temp = temp / 10;
		decimalVal += lastDigit * base;
		base = base * 2;
	}
	return decimalVal;
}

// Performs NOR on two integers
// a and b are integers
// returns the NOR of a and b, int
int NOR(int a, int b) {

	int binaryNum1 = 0;
	int r1;
	int i = 1;
	while (a != 0) {
		r1 = a % 2;
		a /= 2;
		binaryNum1 += r1 * i;
		i *= 10;
	}
	string binaryString1 = to_string(binaryNum1);

	int binaryNum2 = 0;
	int r2;
	int j = 1;
	while (b != 0) {
		r2 = b % 2;
		b /= 2;
		binaryNum2 += r2 * j;
		j *= 10;
	}
	string binaryString2 = to_string(binaryNum2);

	int strLength;
	if (binaryString1.length() < binaryString2.length()) {
		strLength = binaryString2.length();
	}
	else {
		strLength = binaryString1.length();
	}

	string NORstring = "";
	int NORStrLength;

	if (binaryString1.length() < binaryString2.length()) {

		NORStrLength = binaryString2.length();
	}
	else {
		NORStrLength = binaryString1.length();
	}

	for (int k = 0; k < NORStrLength; k++) {

		if (binaryString1[k] == '0' && binaryString2[k] == '0') {
			NORstring = NORstring + '0';
		}
		else {
			NORstring = NORstring + '1';
		}
	}

	for (int i = 0; i < NORstring.length(); i++) {
		if (NORstring[i] == '0') {
			NORstring[i] = '1';
		}
		else {
			NORstring[i] = '0';
		}
	}
	int NORStringConvert = stoi(NORstring);
	int decimalVal = 0;
	int base = 1;
	int temp = NORStringConvert;

	while (temp) {

		int lastDigit = temp % 10;
		temp = temp / 10;
		decimalVal += lastDigit * base;
		base = base * 2;
	}
	return decimalVal;
}

// Performs XOR on two integers
// a and b are integers
// returns the XOR of a and b, int
int XOR(int a, int b) {

	int binaryNum1 = 0;
	int r1;
	int i = 1;
	while (a != 0) {
		r1 = a % 2;
		a /= 2;
		binaryNum1 += r1 * i;
		i *= 10;
	}
	string binaryString1 = to_string(binaryNum1);

	int binaryNum2 = 0;
	int r2;
	int j = 1;
	while (b != 0) {
		r2 = b % 2;
		b /= 2;
		binaryNum2 += r2 * j;
		j *= 10;
	}
	string binaryString2 = to_string(binaryNum2);

	int strLength;
	if (binaryString1.length() < binaryString2.length()) {
		strLength = binaryString2.length();
	}
	else {
		strLength = binaryString1.length();
	}

	string XORstring = "";
	int XORStrLength;

	if (binaryString1.length() < binaryString2.length()) {

		XORStrLength = binaryString2.length();
	}
	else {
		XORStrLength = binaryString1.length();
	}

	for (int k = 0; k < XORStrLength; k++) {

		if ((binaryString1[k] == '1' && binaryString2[k] == '1') || (binaryString1[k] == '0' && binaryString2[k] == '0')) {
			XORstring = XORstring + '0';
		}
		else {
			XORstring = XORstring + '1';
		}
	}
	int XORStringConvert = stoi(XORstring);
	int decimalVal = 0;
	int base = 1;
	int temp = XORStringConvert;

	while (temp) {

		int lastDigit = temp % 10;
		temp = temp / 10;
		decimalVal += lastDigit * base;
		base = base * 2;
	}
	return decimalVal;
}

// Calculates 2's complement of an integer
// a is an integer
// returns the 2's complement of a, int
int TwosComplement(int a) {
	
	int binaryNum = 0;
	int r;
	int i = 1;

	while (a != 0) {
		r = a % 2;
		a /= 2;
		binaryNum += r * i;
		i *= 10;
	}
	string binaryString = to_string(binaryNum);

	for (int i = 0; i < binaryString.length(); i++) {
		if (binaryString[i] == '0') {
			binaryString[i] = '1';
		}
		else {
			binaryString[i] = '0';
		}
	}
	int binaryStringConvert = stoi(binaryString);
	int decimalVal = 0;
	int base = 1;
	int temp = binaryStringConvert;

	while (temp) {

		int lastDigit = temp % 10;
		temp = temp / 10;
		decimalVal += lastDigit * base;
		base = base * 2;
	}
	return decimalVal + 1;
}

// Calculate 1's complement of an integer
// a is an integer
// returns the 1's complement of a, int
int OnesComplement(int a) {

	int binaryNum = 0;
	int r;
	int i = 1;

	while (a != 0) {
		r = a % 2;
		a /= 2;
		binaryNum += r * i;
		i *= 10;
	}
	string binaryString = to_string(binaryNum);

	for (int i = 0; i < binaryString.length(); i++) {
		if (binaryString[i] == '0') {
			binaryString[i] = '1';
		}
		else {
			binaryString[i] = '0';
		}
	}
	int binaryStringConvert = stoi(binaryString);
	int decimalVal = 0;
	int base = 1;
	int temp = binaryStringConvert;

	while (temp) {

		int lastDigit = temp % 10;
		temp = temp / 10;
		decimalVal += lastDigit * base;
		base = base * 2;
	}
	return decimalVal;
}

// Converts an integer to binary
// result is an integer
// returns the binary representation of result, int
int convertBinary(int result) {

	int binaryNum = 0;
	int r;
	int i = 1;

	while (result != 0) {
		r = result % 2;
		result /= 2;
		binaryNum += r * i;
		i *= 10;
	}
	return binaryNum;
}

// Converts an integer to hexadecimal
// result is an integer
// returns the hexadecimal representation of result, string
string convertHex(int result) {

	string hexNum = "";
	int r;
	char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	while (result > 0) {
		r = result % 16;
		hexNum = hex[r] + hexNum;
		result = result / 16;
	}
	return hexNum;
}

// Converts an integer to octal
// result is an integer
// returns the octal representation of result, int
int convertOctal(int result) {

	int octalNum = 0;
	int r;
	int i = 1;

	while (result != 0) {
		r = result % 8;
		result /= 8;
		octalNum += r * i;
		i *= 10;
	}
	return octalNum;
}

int main()
{
	string response;
	int decision;
	int conversion;

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

	while (decision != 12) {

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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " + " << y << " = " << add(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " + " << y << " = " << convertBinary(add(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " + " << y << " = " << convertOctal(add(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " + " << y << " = " << convertHex(add(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " - " << y << " = " << subtract(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " - " << y << " = " << convertBinary(subtract(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " - " << y << " = " << convertOctal(subtract(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " - " << y << " = " << convertHex(subtract(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " * " << y << " = " << multiply(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " * " << y << " = " << convertBinary(multiply(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " * " << y << " = " << convertOctal(multiply(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " * " << y << " = " << convertHex(multiply(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " / " << y << " = " << divide(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " / " << y << " = " << convertBinary(divide(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " / " << y << " = " << convertOctal(divide(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " / " << y << " = " << convertHex(divide(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " % " << y << " = " << modulus(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " % " << y << " = " << convertBinary(modulus(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " % " << y << " = " << convertOctal(modulus(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " % " << y << " = " << convertHex(modulus(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}

		else if (decision == 6) {
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " AND " << y << " = " << AND(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " AND " << y << " = " << convertBinary(AND(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " AND " << y << " = " << convertOctal(AND(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " AND " << y << " = " << convertHex(AND(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}

		else if (decision == 7) {
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " OR " << y << " = " << OR(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " OR " << y << " = " << convertBinary(OR(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " OR " << y << " = " << convertOctal(OR(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " OR " << y << " = " << convertHex(OR(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}

		else if (decision == 8) {
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " NOR " << y << " = " << NOR(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " NOR " << y << " = " << convertBinary(NOR(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " NOR " << y << " = " << convertOctal(NOR(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " NOR " << y << " = " << convertHex(NOR(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}

		else if (decision == 9) {
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

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << x << " XOR " << y << " = " << XOR(x, y) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << x << " XOR " << y << " = " << convertBinary(XOR(x, y)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << x << " XOR " << y << " = " << convertOctal(XOR(x, y)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << x << " XOR " << y << " = " << convertHex(XOR(x, y)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}

		else if (decision == 10) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Performing 2's Complement on " << x << " = " << TwosComplement(x) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << "Performing 2's Complement on " << x << " = " << convertBinary(TwosComplement(x)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << "Performing 2's Complement on " << x << " = " << convertOctal(TwosComplement(x)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << "Performing 2's Complement on " << x << " = " << convertHex(TwosComplement(x)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
			cout << "Operation: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			decision = stoi(response);
		}

		else if (decision == 11) {
			cout << "Enter an integer for x: ";
			num1 = getNumVal();
			while (!validateNumVal(num1)) {
				cout << "Invalid input! Please enter an integer: ";
				num1 = getNumVal();
			}
			x = stoi(num1);

			cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
			cout << "Conversion: ";
			response = getMenuSel();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getMenuSel();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Performing 1's Complement on " << x << " = " << OnesComplement(x) << " (Decimal)\n";
					break;
				}
				else if (conversion == 2) {
					cout << "Performing 1's Complement on " << x << " = " << convertBinary(OnesComplement(x)) << " (Binary)\n";
					break;
				}
				else if (conversion == 3) {
					cout << "Performing 1's Complement on " << x << " = " << convertOctal(OnesComplement(x)) << " (Octal)\n";
					break;
				}
				else if (conversion == 4) {
					cout << "Performing 1's Complement on " << x << " = " << convertHex(OnesComplement(x)) << " (Hexadecimal)\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					cout << "Show result as:\n1. Decimal\n2. Binary\n3. Octal\n4. Hexadecimal\n";
					cout << "Conversion: ";
					response = getMenuSel();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getMenuSel();
					}
					conversion = stoi(response);
				}
			}
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
	}
	if (decision == 12) {
		cout << "Shutting down calculator...";
	}
	return 0;
}