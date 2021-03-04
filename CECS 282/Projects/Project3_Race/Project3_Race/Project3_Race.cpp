// Project3_Race.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/13/19

#include "pch.h"
#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

// Moves the tortoise a certain number of spaces
// &tortPos and move are integers
// returns tortPos, int
int moveTort(int &tortPos, int move) {
	// Fast plod
	if (move >= 1 && move <= 5) { tortPos += 3; }
	// Slip
	else if (move >= 6 && move <= 7) { tortPos -= 6; }
	// Slow plod
	else if (move >= 8 && move <= 10) { tortPos += 1; }
	// Reset position if negative
	if (tortPos < 1) { tortPos = 1; }
	return tortPos;
}

// Moves the hare a certain number of spaces
// &harePos and move are integers
// returns harePos, int
int moveHare(int &harePos, int move) {
	// Sleep
	if (move >= 1 && move <= 2) { harePos = harePos; }
	// Big hop
	else if (move >= 3 && move <= 4) { harePos += 9; }
	// Big slip
	else if (move == 5) { harePos -= 12; }
	// Small hop
	else if (move >= 6 && move <= 8) { harePos += 1; }
	// Small slip
	else if (move >= 9 && move <= 10) { harePos -= 2; }
	// Reset position if negative
	if (harePos < 1) { harePos = 1; }
	return harePos;
}

// Runs the program
int main()
{
	int tortPos = 1;
	int harePos = 1;

	int &tortRef = tortPos;
	int &hareRef = harePos;

	int *tortPtr = &tortRef;
	int *harePtr = &hareRef;

	cout << "BANG!!!!\nAND THEY'RE OFF!!!!" << endl;

	srand(time(NULL));

	while (*tortPtr < 70 && *harePtr < 70) {

		int moveType = rand() % 10 + 1;

		*tortPtr = moveTort(tortRef, moveType);
		*harePtr = moveHare(hareRef, moveType);

		for (int i = 1; i < 71; i++) {
			if ( (i == *tortPtr) && (i == *harePtr)) { cout << "OUCH!"; }
			else if (i == *tortPtr) { cout << "T"; }
			else if (i == *harePtr) { cout << "H"; }
			else { cout << "-"; }
		}
		cout << "\n";
	}
	if ( (*tortPtr > 70) && (*harePtr > 70) ) { cout << "It's a tie!"; }
	else if (*tortPtr > *harePtr) { cout << "TORTOISE WINS!!!! YAY!!!!"; }
	else if (*tortPtr < *harePtr) { cout << "Hare wins. Yuch."; }

	return 0;
}