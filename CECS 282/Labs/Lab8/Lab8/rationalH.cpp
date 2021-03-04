// rationalH.cpp
#include "pch.h"
#include "rationalH.h"
#include <iostream>

using namespace std;
// Default constructor
Rational::Rational() {
	// std::cout << "I am the constructor...\n";
	numerator = 1;
	denominator = 1;
}
// Overloaded constructor
// a is an int, b is an int
// Initializes the numerator as a, denominator as b
Rational::Rational(int a, int b) {
	// std::cout << "I am the overloaded constructor...\n";
	numerator = a;
	denominator = b;
}

// Destructor
Rational::~Rational() {
	// std::cout << "I am the destructor...\n";
}

void Rational::setNumerator(int a) {
	numerator = a;
}

void Rational::setDenominator(int a) {
	denominator = a;
}

// Gets the numerator
// Returns the numerator, int
int Rational::getNumerator() {
	return numerator;
}
// Gets the denominator
// Returns the denominator, int
int Rational::getDenominator() {
	return denominator;
}

// Adds two rational numbers
// rhs is a Rational
Rational Rational::operator+(Rational rhs) {
	Rational temp;
	temp.numerator = numerator * rhs.denominator + rhs.numerator * denominator;
	temp.denominator = denominator * rhs.denominator;
	reduce(temp.numerator, temp.denominator);
	return temp;
}

Rational operator-(Rational lhs, Rational rhs) {
	Rational temp;
	temp.numerator = lhs.numerator * rhs.denominator - rhs.numerator * lhs.denominator;
	temp.denominator = lhs.denominator * rhs.denominator;
	return temp;
}

// Prints out the numerator and the denominator in rational form
// Returns a string with the numerator and denominator in rational form
string Rational::printRationalForm() {
	string a = std::to_string(numerator);
	string b = std::to_string(denominator);
	return a + "/" + b;
}
// Prints out the rational in float form
// Returns the quotient of the numerator and denominator, float

float Rational::printRationalFloat() {
	float f1 = numerator;
	float f2 = denominator;
	return f1 / f2;
}
// Reduces the rational into its simplest form
// c is an int, d is an int
void Rational::reduce(int c, int d) {
	for (int i = denominator * numerator; i > 1; i--) {
		if ((denominator % i == 0) && (numerator % i == 0)) {
			denominator /= i;
			numerator /= i;
		}
	}
}