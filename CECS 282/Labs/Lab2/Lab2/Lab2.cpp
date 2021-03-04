// Lab2.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 2/5/19

#include "pch.h"
#include "employH.h"
#include <string>
#include <iostream>
using namespace std;

int main()
{
    // Object instantiation
	Employee e1;
	e1.setFirstName("Daniel");
	e1.setLastName("Mendez");
	e1.setSalary(1000);

	cout << "Employee: " << e1.getFirstName() << " " << e1.getLastName() << "\t\tSalary: " << e1.getSalary() << "\n";

	// Object instantiation
	Employee e2("Adrian", "Mendez", 2000);

	cout << "Employee: " << e2.getFirstName() << " " << e2.getLastName() << "\t\tSalary: " << e2.getSalary() << "\n";

	return 0;
}
