// Lab6.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/12/19

#include "pch.h"
#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

// Generates a random dice roll
// returns a random number between 1 and 6 inclusive
int diceRoll() { return rand() % 6 + 1; }

// Sets the content of the array
// num[] and x are integers
// Adds 1 to the specified array index
void setContent(int num[], int x) { num[x - 1]++; }

// Prints the array
void printArray(int num[]) {

	for (int i = 0; i < 6; i++) {
		cout << "Frequency of " << i + 1 << ": " << num[i] << endl;
	}
}

// Runs the program
int main()
{
	srand(time(NULL));

	int dice[] = { 0,0,0,0,0,0 };

	int a = 0;

	while (a < 5000) {

		int roll = diceRoll();
		setContent(dice, roll);
		a++;
	}
	printArray(dice);

	return 0;
}
