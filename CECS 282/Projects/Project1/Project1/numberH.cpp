// numberH.cpp
#include "pch.h"
#include "numberH.h"
#include <iostream>

using namespace std;

// Default constructor
Rational::Rational() {
	// std::cout << "I am the constructor...\n";
	numerator = 1;
	denominator = 4;
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

// Calculates the sum of two rationals
// O1 is a Rational object, O2 is a Rational object
void Rational::add(Rational O1, Rational O2) {
	numerator = O1.numerator * O2.denominator + O2.numerator * O1.denominator;
	denominator = O1.denominator * O2.denominator;
	reduce(numerator, denominator);
}

// Calculates the difference of two rationals
// O is a Rational object
// Returns the difference of the default rational and O, Rational
Rational Rational::subtract(Rational O) {
	numerator = numerator * O.denominator  - O.numerator * denominator;
	denominator = denominator * O.denominator;
	reduce(numerator, denominator);
	O = Rational(numerator, denominator);
	return O;
}

// Calculates the product of two rationals
// O1 is a Rational object, O2 is a Rational object
void Rational::multiply(Rational O1, Rational O2) {
	numerator = O1.numerator * O2.numerator;
	denominator = O1.denominator * O2.denominator;
	reduce(numerator, denominator);
}

// Calculates the quotient of two rationals
// O1 is a Rational object, O2 is a Rational object
void Rational::divide(Rational O1, Rational O2) {
	numerator = O1.numerator * O2.denominator;
	denominator = O1.denominator * O2.numerator;
	reduce(numerator, denominator);
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