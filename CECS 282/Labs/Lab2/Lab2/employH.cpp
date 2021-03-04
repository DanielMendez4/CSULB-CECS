// employH.cpp
#include "pch.h"
#include "employH.h"
#include <iostream>

using namespace std;

Employee::Employee() {
	std::cout << "I am the constructor...\n";
	fname = "";
	lname = "";
	salary = 0;
}

Employee::Employee(string f, string l, int s) {
	std::cout << "I am the overloaded constructor...\n";
	fname = f;
	lname = l;
	salary = s;
}

Employee::~Employee() {
	std::cout << "I am the destructor...\n";
}

void Employee::setFirstName(string f) {
	fname = f;
}

void Employee::setLastName(string l) {
	lname = l;
}

void Employee::setSalary(int x) {
	salary = x;
}

string Employee::getFirstName() {
	return fname;
}

string Employee::getLastName() {
	return lname;
}

int Employee::getSalary() {
	return salary;
}