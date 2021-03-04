// rationalH.h
#pragma once
#ifndef rationalH_h
#define rationalH_h

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
	Rational(int ,int);
	~Rational();
	void setNumerator(int);
	void setDenominator(int);
	int getNumerator();
	int getDenominator();

	Rational operator+(Rational rhs);
	friend Rational operator-(Rational lhs, Rational rhs);
	void multiply(Rational lhs, Rational rhs);
	void divide(Rational lhs, Rational rhs);
	string printRationalForm();
	float printRationalFloat();
	void reduce(int c, int d);
};
#endif /*numberH_h*/