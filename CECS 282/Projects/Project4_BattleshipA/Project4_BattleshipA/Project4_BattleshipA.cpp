// Project4_BattleshipA.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/25/19

#include "pch.h"
#include <iostream>
#include <fstream>
#include <string>
#include <time.h>
#include <stdlib.h>

using namespace std;

// Uses an x and y coordinate to shoot a torpedo at that location
// x and y are integers, field is a character array
// Prints "HIT" if (x, y) == "#", "HIT AGAIN" if (x, y) already equals 'H' and "MISS" otherwise
void Fire(int x, int y, char field[25][25]) {
	if (field[x][y] == '#') {
		field[x][y] = 'H';
		cout << "HIT! ";
	}
	else if (field[x][y] == 'H') {
		cout << "HIT AGAIN! ";
	}
	else {
		cout << "MISS! ";
	}
}
// Determines if there are any remaining '#' characters in the character array
// field is a character array
// Returns true if there are still '#' in the character array, false otherwise
bool fleetSunk(char field[25][25]) {
	for (int i = 0; i < 25; i++) {
		for (int j = 0; j < 25; j++) {
			if (field[i][j] == '#') {
				return true;
			}
		}
	}
	return false;
}
// Runs the program
int main()
{
	srand(time(NULL));
	ifstream fin;
	fin.open("Project4 Battleship.txt", ios::in);
	string line;
	char battlefield[25][25];
	int i = 0;
	while (getline(fin, line)) {
		string complete;
		for (int s = 0; s < line.length(); s++) {
			if (line[s] != ' ') { complete += line[s]; }
		}
		for (int j = 0; j < complete.length(); j++) { battlefield[i][j] = complete[j]; }
		i++;
	}
	for (int row = 0; row < 25; row++) {
		for (int col = 0; col < 25; col++) {
			cout << battlefield[row][col];
		}
		cout << endl;
	}
	while (fleetSunk(battlefield)) {
		int x = rand() % 25;
		int y = rand() % 25;
		Fire(x, y, battlefield);
	}
	cout << "\nThe fleet was destroyed!" << endl;
	for (int row = 0; row < 25; row++) {
		for (int col = 0; col < 25; col++) {
			cout << battlefield[row][col];
		}
		cout << endl;
	}
	return 0;
}