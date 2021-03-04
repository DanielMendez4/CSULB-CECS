// Lab10.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 4/16/19

#include "pch.h"
#include "List.h"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	List L1;
	cout << "Beginning of the list" << endl;
	L1.add("My");
	L1.add("name");
	L1.add("is");
	L1.add("Daniel");
	cout << L1.to_string() << endl;
	
	L1.deleteTail();
	cout << L1.to_string() << endl;


	return 0;
}