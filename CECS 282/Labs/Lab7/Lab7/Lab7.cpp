// Lab7.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/19/19

#include "pch.h"
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	ifstream fin;

	fin.open("CECS 282 Lab7 TextSample.txt", ios::in);

	char myChar;
	
	while ( !fin.eof() ) {
		fin.get(myChar);
		cout << myChar;
		
	}
	return 0;
}