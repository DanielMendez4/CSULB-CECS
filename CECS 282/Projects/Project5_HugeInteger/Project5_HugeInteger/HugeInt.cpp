// HugeInt.cpp
#include "pch.h"
#include "HugeInt.h"
#include <string>
#include <iostream>

using namespace std;

// Default constructor
HugeInt::HugeInt() {
	intNum = 1;
	strNum = "";
}
// Overloaded constructor
// x is an integer
HugeInt::HugeInt(int x) {
	intNum = x;
	strNum = "";
}
// Overloaded constructor
// s is a string
HugeInt::HugeInt(string s) {
	intNum = NULL;
	strNum = s;
}

// Friend functions
istream & operator>>(istream &in, HugeInt &a) {
	return in;
}

ostream & operator<<(ostream &out, const HugeInt &a) {
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		out << temp;
		return out;
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		out << temp;
		return out;
	}
}
// Adds two HugeInt objects
// a and b are HugeInt objects
// returns a HugeInt object
HugeInt operator+(HugeInt a, HugeInt b) {
	HugeInt temp;
	int x = 0;
	int y = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	temp.intNum = x + y;
	return temp;
}

HugeInt operator+(HugeInt a, int x) {
	HugeInt temp;
	int c = 0;
	int d = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		c = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		c = stoi(temp);
	}
	string num2 = to_string(x);
	if (num2.length() > 40) { num2.erase(40); }
	int digits2[40] = { 0 };
	for (int i = 0; i < num2.length(); i++) {
		int reinsert = num2[i] - '0';
		digits2[i] = reinsert;
	}
	string temp2 = "";
	for (int i = 0; i < num2.length(); i++) { temp2 += to_string(digits2[i]); }
	d = stoi(temp2);
	temp.intNum = c + d;
	return temp;
}

HugeInt operator+(HugeInt a, string s) {
	HugeInt temp;
	int c = 0;
	int d = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		c = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		c = stoi(temp);
	}
	string num2 = s;
	if (num2.length() > 40) { num2.erase(40); }
	int digits2[40] = { 0 };
	for (int i = 0; i < num2.length(); i++) {
		int reinsert = num2[i] - '0';
		digits2[i] = reinsert;
	}
	string temp2 = "";
	for (int i = 0; i < num2.length(); i++) { temp2 += to_string(digits2[i]); }
	d = stoi(temp2);
	temp.intNum = c + d;
	return temp;
}

// Subtracts two HugeInt objects
// a and b are HugeInt objects
// returns a HugeInt object
HugeInt operator-(HugeInt a, HugeInt b) {
	HugeInt temp;
	int x = 0;
	int y = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	temp.intNum = x - y;
	return temp;
}
// Multiplys two HugeInt objects
// a and b are HugeInt objects
// returns a HugeInt object
HugeInt operator*(HugeInt a, HugeInt b) {
	HugeInt temp;
	int x = 0;
	int y = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	temp.intNum = x * y;
	return temp;
}
// Divides two HugeInt objects
// a and b are HugeInt objects
// returns a HugeInt object
HugeInt operator/(HugeInt a, HugeInt b) {
	HugeInt temp;
	int x = 0;
	int y = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	temp.intNum = x / y;
	return temp;
}
// Modulus two HugeInt objects
// a and b are HugeInt objects
// returns a HugeInt object
HugeInt operator%(HugeInt a, HugeInt b) {
	HugeInt temp;
	int x = 0;
	int y = 0;
	if (a.intNum != NULL) {
		string num = to_string(a.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (a.strNum != "") {
		string num = a.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	temp.intNum = x % y;
	return temp;
}
// Member functions

// Chekcs to see if two HugeInt objects are equal
// b is a HugeInt object
// returns true if equal, false otherwise
bool HugeInt::operator==(HugeInt b) {
	int x = 0;
	int y = 0;
	if (intNum != NULL) {
		string num = to_string(intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (strNum != "") {
		string num = strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (x == y) { return true; }
	else { return false; }
}
// Checks to see if two HugeInt objects are not equal
// b is a HugeInt object
// returns true if not equal, false otherwise
bool HugeInt::operator!=(HugeInt b) {
	int x = 0;
	int y = 0;
	if (intNum != NULL) {
		string num = to_string(intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (strNum != "") {
		string num = strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (x != y) { return true; }
	else { return false; }
}
// Chekcs to see if one HugeInt object is greater than the other
// b is a HugeInt object
// returns true if greater, false otherwise
bool HugeInt::operator>(HugeInt b) {
	int x = 0;
	int y = 0;
	if (intNum != NULL) {
		string num = to_string(intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (strNum != "") {
		string num = strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (x > y) { return true; }
	else { return false; }
}
// Chekcs to see if one HugeInt object is less than the other
// b is a HugeInt object
// returns true if less, false otherwise
bool HugeInt::operator<(HugeInt b) {
	int x = 0;
	int y = 0;
	if (intNum != NULL) {
		string num = to_string(intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (strNum != "") {
		string num = strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (x < y) { return true; }
	else { return false; }
}
// Chekcs to see if one HugeInt object is greater than or equal to the other
// b is a HugeInt object
// returns true if greater or equal to, false otherwise
bool HugeInt::operator>=(HugeInt b) {
	int x = 0;
	int y = 0;
	if (intNum != NULL) {
		string num = to_string(intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (strNum != "") {
		string num = strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (x >= y) { return true; }
	else { return false; }
}
// Chekcs to see if one HugeInt object is less than or equal to the other
// b is a HugeInt object
// returns true if less or equal to, false otherwise
bool HugeInt::operator<=(HugeInt b) {
	int x = 0;
	int y = 0;
	if (intNum != NULL) {
		string num = to_string(intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (strNum != "") {
		string num = strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		x = stoi(temp);
	}
	if (b.intNum != NULL) {
		string num = to_string(b.intNum);
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (b.strNum != "") {
		string num = b.strNum;
		if (num.length() > 40) { num.erase(40); }
		int digits[40] = { 0 };
		for (int i = 0; i < num.length(); i++) {
			int reinsert = num[i] - '0';
			digits[i] = reinsert;
		}
		string temp = "";
		for (int i = 0; i < num.length(); i++) { temp += to_string(digits[i]); }
		y = stoi(temp);
	}
	if (x <= y) { return true; }
	else { return false; }
}