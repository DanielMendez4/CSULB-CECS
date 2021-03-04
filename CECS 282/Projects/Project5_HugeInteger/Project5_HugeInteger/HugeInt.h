// HugeInt.h
#pragma once
#ifndef HugeInt_h
#define HugeInt_h

#include <string>
#include <stdio.h>
#include <iostream>

using namespace std;

class HugeInt {
private:
	int intNum;
	string strNum;
public:
	HugeInt();
	HugeInt(int);
	HugeInt(string);

	friend istream & operator>>(istream &in, HugeInt &a);
	friend ostream & operator<<(ostream &out, const HugeInt &a);
	friend HugeInt operator+(HugeInt a, HugeInt b);
	friend HugeInt operator+(HugeInt a, int x);
	friend HugeInt operator+(HugeInt a, string s);
	friend HugeInt operator-(HugeInt a, HugeInt b);
	friend HugeInt operator*(HugeInt a, HugeInt b);
	friend HugeInt operator/(HugeInt a, HugeInt b);
	friend HugeInt operator%(HugeInt a, HugeInt b);

	bool operator==(HugeInt b);
	bool operator!=(HugeInt b);
	bool operator>(HugeInt b);
	bool operator<(HugeInt b);
	bool operator>=(HugeInt b);
	bool operator<=(HugeInt b);
};
#endif /*HugeInt_h*/