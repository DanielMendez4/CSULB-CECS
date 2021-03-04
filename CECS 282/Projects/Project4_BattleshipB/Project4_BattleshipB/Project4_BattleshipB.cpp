// Project4_BattleshipB.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/25/19

#include "pch.h"
#include <iostream>
#include <string>
#include <time.h>
#include <stdlib.h>

using namespace std;

// Fills a 15 x 15 2D array with '~' characters
// field is a 2D character array
void generateBattlefield(char field[15][15]) {
	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 15; j++) {
			field[i][j] = '~';
		}
	}
}

// Determines whether the direction of the ship is valid
// field is a character array, x, y, direction, and shipLength are integers
// Returns true if the direction is valid, false otherwise
bool validateDirection(char field[15][15], int x, int y, int direction, int shipLength) {
	if (direction == 1) {		// Up
		if (x - shipLength <= 0) { return false; }
		for (int i = 0; i < shipLength; i++) {
			if (field[x - i][y] == '#') { return false; }
		}
	}
	else if (direction == 2) {	// Right
		if (y + shipLength > 14) { return false; }
		for (int i = 0; i < shipLength; i++) {
			if (field[x][y + i] == '#') { return false; }
		}
	}
	else if (direction == 3) {	// Down
		if (x + shipLength > 14) { return false; }
		for (int i = 0; i < shipLength; i++) {
			if (field[x + i][y] == '#') { return false; }
		}
	}
	else if (direction == 4) {	// Left
		if (y - shipLength <= 0) { return false; }
		for (int i = 0; i < shipLength; i++) {
			if (field[x][y - i] == '#') { return false; }
		}
	}
	return true;
}

// Places a ship of specified length at a specifed location
// field is a character array, xShip and yShip are integer arrays, indexX, indexY, and shipLength are integers
void shipBuilder(char field[15][15], int xShip[14], int indexX, int yShip[14], int indexY, int shipLength) {
	int x = rand() % 15;
	int y = rand() % 15;
	int direction = rand() % 4 + 1;

	while (field[x][y] == '#') {
		x = rand() % 15;
		y = rand() % 15;
	}
	xShip[indexX] = y;
	yShip[indexY] = x;
	indexX++;
	indexY++;
	while (!validateDirection(field, x, y, direction, shipLength)) { direction = rand() % 4 + 1; }
	if (direction == 1) {		// Up
		for (int i = 0; i < shipLength; i++) {
			field[x - i][y] = '#';
			if (i != 0) {
				xShip[indexX] = y;
				yShip[indexY] = x - i;
				indexX++;
				indexY++;
			}
		}
	}
	else if (direction == 2) {	// Right
		for (int i = 0; i < shipLength; i++) {
			field[x][y + i] = '#';
			if (i != 0) {
				xShip[indexX] = y + i;
				yShip[indexY] = x;
				indexX++;
				indexY++;
			}
		}
	}
	else if (direction == 3) { // Down
		for (int i = 0; i < shipLength; i++) {
			field[x + i][y] = '#';
			if (i != 0) {
				xShip[indexX] = y;
				yShip[indexY] = x + i;
				indexX++;
				indexY++;
			}
		}
	}
	else if (direction == 4) { // Left
		for (int i = 0; i < shipLength; i++) {
			field[x][y - i] = '#';
			if (i != 0) {
				xShip[indexX] = y - i;
				yShip[indexY] = x;
				indexX++;
				indexY++;
			}
		}
	}
}

// Determines whether user input for row is valid
// s is a string
// Returns true if string is valid, false otherwise
bool validateRow(string s) {
	for (int i = 0; i < s.length(); i++) {
		if (isdigit(s[i]) == false) {
			return false;
		}
		int a = stoi(s);
		if ((a < 1) || (a > 15)) {
			return false;
		}
	}
	return true;
}

// Determines whether user input for column is valid
// c is a character
// Returns true if character is valid, false otherwise
bool validateColumn(char c) {
	toupper(c);
	if ((c < 'A') || (c > 'O')) {
		return false;
	}
	return true;
}

// Uses an x and y coordinate to shoot a torpedo at that location
// x and y are integers, field is a character array
// Prints "HIT" if (x, y) == '#', "HIT AGAIN" if (x, y) already equals 'H' and "MISS" otherwise
void Fire(int x, int y, char field[15][15]) {
	if (field[x][y] == '#') {
		field[x][y] = 'H';
		cout << "HIT!" << endl;
	}
	else if (field[x][y] == 'H') {
		cout << "HIT AGAIN!" << endl;
	}
	else {
		cout << "MISS!" << endl;
	}
}

// Determines if there are any remaining '#' characters in the character array
// field is a character array
// Returns true if there are still '#' in the character array, false otherwise
bool FleetSunk(char field[15][15]) {
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
	int xShip[14];
	int yShip[14];
	char battlefield[15][15];

	static int indexX = 0;
	static int indexY = 0;

	generateBattlefield(battlefield);
	shipBuilder(battlefield, xShip, indexX, yShip, indexY, 2);
	shipBuilder(battlefield, xShip, indexX, yShip, indexY, 2);
	shipBuilder(battlefield, xShip, indexX, yShip, indexY, 3);
	shipBuilder(battlefield, xShip, indexX, yShip, indexY, 3);
	shipBuilder(battlefield, xShip, indexX, yShip, indexY, 4);

	cout << "\tABCDEFGHIJKLMNO" << endl;
	for (int i = 0; i < 15; i++) {
		cout << i + 1 << "\t";
		for (int j = 0; j < 15; j++) {
			cout << battlefield[i][j];
		}
		cout << endl;
	}
	cout << endl;

	string response;
	int count = 0;

	while (FleetSunk(battlefield)) {
		if (count == 60) { break; }
		else {
			cout << "Enter an x-coordinate from 1 - 15: ";
			cin >> response;
			while (!validateRow(response)) {
				cout << "Invalid input or out of range! Please enter an integer from 1 - 15: ";
				cin >> response;
			}
			int x = stoi(response) - 1;

			cout << "Enter a character from A - O: ";
			cin >> response;
			while (!validateColumn(response[0])) {
				cout << "Invalid input or out of range! Please enter an character from A - O: ";
				cin >> response;
			}
			int y = (int)response[0] - 65;
			Fire(x, y, battlefield);
			for (int i = 0; i < 15; i++) {
				cout << i + 1 << "\t";
				for (int j = 0; j < 15; j++) {
					cout << battlefield[i][j];
				}
				cout << endl;
			}
		}
		count++;
	}
	cout << endl;
	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 15; j++) {
			cout << battlefield[i][j];
		}
		cout << endl;
	}
	cout << endl;
	if (count < 61) {
		cout << "You sunk the whole fleet!";
	}
	else {
		cout << "You lost!";
	}
	return 0;
}