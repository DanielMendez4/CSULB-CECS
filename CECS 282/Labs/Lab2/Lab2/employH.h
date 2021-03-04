// employH.h
#pragma once
#ifndef employH_h
#define employH_h

#include <string>
#include <stdio.h>
#include <iostream>

using namespace std;

class Employee {
private:
	std::string fname;
	std::string lname;
	int salary;
public:
	Employee();
	Employee(string f, string l, int x);
	~Employee();

	void setFirstName(string g);
	void setLastName(string m);
	void setSalary(int y);

	string getFirstName();
	string getLastName();
	int getSalary();
};

#endif /*employH_h*/