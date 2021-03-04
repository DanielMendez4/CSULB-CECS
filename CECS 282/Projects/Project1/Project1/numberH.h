// numberH.h
#pragma once
#ifndef numberH_h
#define numberH_h

#include <string>
#include <stdio.h>
#include <iostream>

using namespace std;

class Rational {
private:
	int numerator;
	int denominator;
public:
	Rational();
	Rational(int a, int b);
	~Rational();

	void add(Rational O1, Rational O2);
	Rational subtract(Rational O);
	void multiply(Rational O1, Rational O2);
	void divide(Rational O1, Rational O2);

	string printRationalForm();
	float printRationalFloat();

	void reduce(int c, int d);
	int getNumerator();
	int getDenominator();
};
#endif /*numberH_h*/
