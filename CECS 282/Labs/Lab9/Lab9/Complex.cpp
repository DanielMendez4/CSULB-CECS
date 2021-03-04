// Complex.cpp
#include "pch.h"
#include "Complex.h"
#include <string>
#include <iostream>

using namespace std;

Complex::Complex() {
	real = 0;
	imaginary = 0;
}

Complex::Complex(double r, double i) {
	real = r;
	imaginary = i;
}

Complex Complex::operator+(Complex c) {
	Complex temp;
	temp.real = real + c.real;
	temp.imaginary = imaginary + c.imaginary;
	return temp;
}

Complex Complex::operator*(Complex c) {
	Complex temp;
	temp.real = (real * c.real) - (imaginary * c.imaginary);
	temp.imaginary = (real * c.imaginary) + (imaginary * c.real);
	return temp;
}

Complex & Complex::operator++() {
	real++;
	imaginary++;
	return *this;
}

Complex Complex::operator++(int) {
	Complex temp = *this;
	++*this;
	return temp;
}

ostream & operator<<(ostream &out, const Complex &c) {
	out << c.real << " + i" << c.imaginary;
	return out;
}