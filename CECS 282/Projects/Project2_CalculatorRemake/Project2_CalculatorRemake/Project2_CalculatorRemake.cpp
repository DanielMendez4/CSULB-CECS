// Project2_CalculatorRemake.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/4/19

#include "pch.h"
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

// Displays the menu options
void displayMenu() {
	cout << "Select your operation:\n\t1. +\n\t2. -\n\t3. *\n\t4. /\n\t5. %\n\t6. AND\n\t7. OR\n\t8. NOR\n\t9. XOR\n\t10. 2's Complement\n\t11. 1's Complement\n\t12.Exit\nOperation: "; }

// Gets user input
// returns userInput, string
string getUserInput() {
	string userInput;
	cin >> userInput;
	return userInput;
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

// Displays conversion options
void displayConversion() {
	cout << "\t1. Decimal\n\t2. Binary\n\t3. Octal\n\t4. Hexadecimal\nConversion: "; }

// Checks to see if user input is a valid decimal
// s is a string
// returns true if s is a decimal, false otherwise
bool validateDecimal(string s) {
	for (int i = 0; i < s.length(); i++) {
		if (isdigit(s[i]) == false) {
			return false;
		}
	}
	return true;
}

// Checks to see if user input is in binary
// s is a string
// returns true if s is binary, false otherwise
bool validateBinary(string s) {
	for (int i = 0; i < s.length(); i++) {
		if ( (s[i] == '1') || (s[i] == '0') ) {
			return true;
		}
	}
	return false;
}

// Checks to see if user input is in octal
// s is a string
// returns true if s is octal, false otherwise
bool validateOctal(string s) {
	for (int i = 0; i < s.length(); i++) {
		if ( (s[i] < '0') || (s[i] > '7') ) {
			return false;
		}
	}
	return true;
}

// Checks to see if user input is in hexadecimal
// s is a string
// returns true if s is hexadecimal, false otherwise
bool validateHex(string s) {
	for (int i = 0; i < s.length(); i++) {
		if (s[i] != '0' && s[i] != '1' && s[i] != '2' && s[i] != '3' && s[i] != '4' && s[i] != '5' && s[i] != '6' && s[i] != '7' && s[i] != '8' && s[i] != '9' && s[i] != 'A' && s[i] != 'B' && s[i] != 'C' && s[i] != 'D' && s[i] != 'E' && s[i] != 'F') {
			return false;
		}
	}
	return true;
}

// Converts binary to deciaml
// n is an integer
// returns decVal, int
int binaryToDec(int n) {
	int num = n;
	int decVal = 0;
	int base = 1;
	int temp = num;
	while (temp) {
		int lastDigit = temp % 10;
		temp = temp / 10;
		decVal += lastDigit * base;
		base = base * 2;
	}
	return decVal;
}

// Converts octal to deciaml
// n is an integer
// returns decVal, int
int octalToDec(int n) {
	int num = n;
	int decVal = 0;
	int base = 1;
	int temp = num;
	while (temp) {
		int lastDigit = temp % 10;
		temp = temp / 10;
		decVal += lastDigit * base;
		base = base * 8;
	}
	return decVal;
}

// Converts hexadecimal to deciaml
// hexVal is a char array
// returns decVal, int
int hexToDec(char hexVal[]) {
	int len = strlen(hexVal);
	int base = 1;
	int decVal = 0;
	for (int i = len - 1; i >= 0; i--) {
		if (hexVal[i] >= '0' && hexVal[i] <= '9') {
			decVal += (hexVal[i] - 48) * base;
			base = base * 16;
		}
		else if (hexVal[i] >= 'A' && hexVal[i] <= 'F') {
			decVal += (hexVal[i] - 55) * base;
			base = base * 16;
		}
	}
	return decVal;
}

// Converts an integer to binary
// n is an integer
// returns binNum, int
int convertToBinary(int n) {
	int binNum = 0;
	int r;
	int i = 1;
	while (n != 0) {
		r = n % 2;
		n /= 2;
		binNum += r * i;
		i *= 10;
	}
	return binNum;
}

// Converts an integer to octal
// n is an integer
// returns octNum, int
int convertToOctal(int n) {
	int octNum = 0;
	int r;
	int i = 1;
	while (n != 0) {
		r = n % 8;
		n /= 8;
		octNum += r * i;
		i *= 10;
	}
	return octNum;
}

// Converts an integer to hexadecimal
// n is an integer
// returns hexNum, string
string convertToHex(int n) {
	string hexNum = "";
	int r;
	char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	while (n > 0) {
		r = n % 16;
		hexNum = hex[r] + hexNum;
		n = n / 16;
	}
	return hexNum;
}

// Calculates the sum of two integers
// a and b are integers
// returns sum of a and b, int
int add(int a, int b) { return a + b; }

// Calculates the difference of two integers
// a and b are integers
// returns difference of a and b, int
int subtract(int a, int b) { return a - b; }

// Calculates the product of two integers
// a and b are integers
// returns product of a and b, int
int multiply(int a, int b) { return a * b; }

// Calculates the quotient of two integers
// a and b are integers
// returns quotient of a and b, int
int divide(int a, int b) { return a / b; }

// Calculates the modulus of two integers
// a and b are integers
// returns modulus of a and b, int
int modulus(int a, int b) { return a % b; }

// Performs AND on two integers
// a and b are integers
// returns AND of a and b, int
int AND(int a, int b) { return a & b; }

// Performs OR on two integers
// a and b are integers
// returns OR of a and b, int
int OR(int a, int b) { return a | b; }

// Performs NOR on two integers
// a and b are integers
// returns NOR of a and b, int
int NOR(int a, int b) {
	string resultOR = to_string(convertToBinary(OR(a, b)));
	for (int i = 0; i < resultOR.length(); i++) {
		if (resultOR[i] == '0') { resultOR[i] = '1'; }
		else { resultOR[i] = '0'; }
	}
	int resultNOR = stoi(resultOR);
	return binaryToDec(resultNOR);
}

// Performs XOR on two integers
// a and b are integers
// returns XOR of a and b, int
int XOR(int a, int b) { return a ^ b; }

// Performs 1's complement of an integer
// a is an integer
// returns the 1's complement of a, int
int OnesComplement(int a) {
	string binStr = to_string(convertToBinary(a));
	for (int i = 0; i < binStr.length(); i++) {
		if (binStr[i] == '0') { binStr[i] = '1'; }
		else { binStr[i] = '0'; }
	}
	int resultOnes = stoi(binStr);
	int decVal = binaryToDec(resultOnes);
	return decVal;
}

// Performs 2's complement of an integer
// a is an integer
// returns the 2's complement of a, int
int TwosComplement(int a) { return OnesComplement(a) + 1; }

// Runs the program
int main()
{
	string response;
	int decision;
	int conversion;

	string num1;
	string num2;
	int x;
	int y;
	char xHex[32];
	char yHex[32];

	cout << "Welcome to My Calculator! ";
	displayMenu();
	response = getUserInput();
	while (!validateMenuSel(response)) {
		cout << "Invalid input! Please enter an integer: ";
		response = getUserInput();
	}
	decision = stoi(response);

	while (decision != 12) {
		// ADDITION--------------------------------------------------------------------------------
		if (decision == 1) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " + " << num2 << " = " << add(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " + " << num2 << " = " << convertToBinary(add(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " + " << num2 << " = " << convertToOctal(add(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " + " << num2 << " = " << convertToHex(add(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// SUBTRATION------------------------------------------------------------------------------
		else if (decision == 2) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " - " << num2 << " = " << subtract(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " - " << num2 << " = " << convertToBinary(subtract(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " - " << num2 << " = " << convertToOctal(subtract(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " - " << num2 << " = " << convertToHex(subtract(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// MULTIPLICATION--------------------------------------------------------------------------
		else if (decision == 3) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " * " << num2 << " = " << multiply(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " * " << num2 << " = " << convertToBinary(multiply(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " * " << num2 << " = " << convertToOctal(multiply(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " * " << num2 << " = " << convertToHex(multiply(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// DIVISION--------------------------------------------------------------------------------
		else if (decision == 4) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " / " << num2 << " = " << divide(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " / " << num2 << " = " << convertToBinary(divide(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " / " << num2 << " = " << convertToOctal(divide(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " / " << num2 << " = " << convertToHex(divide(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// MODULUS---------------------------------------------------------------------------------
		else if (decision == 5) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " % " << num2 << " = " << modulus(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " % " << num2 << " = " << convertToBinary(modulus(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " % " << num2 << " = " << convertToOctal(modulus(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " % " << num2 << " = " << convertToHex(modulus(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// AND-------------------------------------------------------------------------------------
		else if (decision == 6) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " & " << num2 << " = " << AND(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " & " << num2 << " = " << convertToBinary(AND(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " & " << num2 << " = " << convertToOctal(AND(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " & " << num2 << " = " << convertToHex(AND(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// OR--------------------------------------------------------------------------------------
		else if (decision == 7) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " | " << num2 << " = " << OR(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " | " << num2 << " = " << convertToBinary(OR(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " | " << num2 << " = " << convertToOctal(OR(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " | " << num2 << " = " << convertToHex(OR(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// NOR-------------------------------------------------------------------------------------
		else if (decision == 8) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " ~| " << num2 << " = " << NOR(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " ~| " << num2 << " = " << convertToBinary(NOR(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " ~| " << num2 << " = " << convertToOctal(NOR(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " ~| " << num2 << " = " << convertToHex(NOR(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// XOR-------------------------------------------------------------------------------------
		else if (decision == 9) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Choose a system for y:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for y: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num2 = response + " (Decimal)";
					y = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for y: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num2 = response + " (Binary)";
					y = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for y: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num2 = response + " (Octal)";
					y = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for y: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num2 = response + " (Hexadecimal)";
					strcpy_s(yHex, response.c_str());
					y = hexToDec(yHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << num1 << " ^ " << num2 << " = " << XOR(x, y) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << num1 << " ^ " << num2 << " = " << convertToBinary(XOR(x, y)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << num1 << " ^ " << num2 << " = " << convertToOctal(XOR(x, y)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << num1 << " ^ " << num2 << " = " << convertToHex(XOR(x, y)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// TWOS------------------------------------------------------------------------------------
		else if (decision == 10) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Two's Complement of " << num1 << " = " << TwosComplement(x) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << "Two's Complement of " << num1 << " = " << convertToBinary(TwosComplement(x)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << "Two's Complement of " << num1 << " = " << convertToOctal(TwosComplement(x)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << "Two's Complement of " << num1 << " = " << convertToHex(TwosComplement(x)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		// ONES------------------------------------------------------------------------------------
		else if (decision == 11) {
			cout << "Choose a system for x:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "Enter an integer for x: ";
					response = getUserInput();
					while (!validateDecimal(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					num1 = response + " (Decimal)";
					x = stoi(response);
					break;
				}
				else if (conversion == 2) {
					cout << "Enter a binary for x: ";
					response = getUserInput();
					while (!validateBinary(response)) {
						cout << "Invalid input! Please enter a binary: ";
						response = getUserInput();
					}
					num1 = response + " (Binary)";
					x = binaryToDec(stoi(response));
					break;
				}
				else if (conversion == 3) {
					cout << "Enter an octal for x: ";
					response = getUserInput();
					while (!validateOctal(response)) {
						cout << "Invalid input! Please enter a octal: ";
						response = getUserInput();
					}
					num1 = response + " (Octal)";
					x = octalToDec(stoi(response));
					break;
				}
				else if (conversion == 4) {
					cout << "Enter a hexadecimal for x: ";
					response = getUserInput();
					while (!validateHex(response)) {
						cout << "Invalid input! Please enter a hexadecimal: ";
						response = getUserInput();
					}
					num1 = response + " (Hexadecimal)";
					strcpy_s(xHex, response.c_str());
					x = hexToDec(xHex);
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "Show result as:\n";
			displayConversion();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			conversion = stoi(response);
			while (true) {
				if (conversion == 1) {
					cout << "One's Complement of " << num1 << " = " << OnesComplement(x) << " in Decimal\n";
					break;
				}
				else if (conversion == 2) {
					cout << "One's Complement of " << num1 << " = " << convertToBinary(OnesComplement(x)) << " in Binary\n";
					break;
				}
				else if (conversion == 3) {
					cout << "One's Complement of " << num1 << " = " << convertToOctal(OnesComplement(x)) << " in Octal\n";
					break;
				}
				else if (conversion == 4) {
					cout << "One's Complement of " << num1 << " = " << convertToHex(OnesComplement(x)) << " in Hexadecimal\n";
					break;
				}
				else {
					cout << "Invalid selection! Please try again!\n";
					displayConversion();
					response = getUserInput();
					while (!validateMenuSel(response)) {
						cout << "Invalid input! Please enter an integer: ";
						response = getUserInput();
					}
					conversion = stoi(response);
				}
			}
			cout << "\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
		//-----------------------------------------------------------------------------------------
		else {
			cout << "\nInvalid selection! Please try again!\n";
			displayMenu();
			response = getUserInput();
			while (!validateMenuSel(response)) {
				cout << "Invalid input! Please enter an integer: ";
				response = getUserInput();
			}
			decision = stoi(response);
		}
	}
	if (decision == 12) { cout << "Shutting down calculator..."; }
	return 0;
}