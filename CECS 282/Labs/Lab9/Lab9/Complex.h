// Complex.h
#pragma once
#ifndef Complex_h
#define Complex_h

#include <string>
#include <stdio.h>
#include <iostream>

using namespace std;

class Complex {
private:
	double real;
	double imaginary;
public:
	Complex();
	Complex(double r, double i);

	Complex operator+(Complex c2);
	Complex operator*(Complex c2);
	Complex & operator++();
	Complex operator++(int);
	friend ostream & operator<<(ostream &out, const Complex &c);
};

#endif // !Complex_h
