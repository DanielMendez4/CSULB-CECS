// Lab5.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 3/7/19

#include "pch.h"
#include <iostream>

using namespace std;

// Moves to the right a certain number of spaces
// &x and spaces are integers
// returns x + spaces
int moveRight(int &x, int spaces) { return x + spaces; }

// Moves to the left a certain number of spaces
// &x and spaces are integers
// returns x - spaces
int moveLeft(int &x, int spaces) { return x - spaces; }

// Moves down a certain number of spaces
// &y and spaces are integers
// returns y - spaces
int moveDown(int &y, int spaces) { return y - spaces; }

// Moves up a certain number of spaces
// &y and spaces are integers
// returns y + spaces
int moveUp(int &y, int spaces) { return y + spaces; }

// Runs the program
int main()
{
	int posX = 0;
	int posY = 0;

	int &refX = posX;
	int &refY = posY;

	cout << "Starting position: (" << refX << ", " << refY << ")" << "\n\n";

	// move right 4
	refX = moveRight(refX, 4);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move up 2
	refY = moveUp(refY, 2);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move left 4
	refX = moveLeft(refX, 4);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move up 2
	refY = moveUp(refY, 2);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move right 6
	refX = moveRight(refX, 6);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move down 4
	refY = moveDown(refY, 4);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move right 2
	refX = moveRight(refX, 2);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move up 7
	refY = moveUp(refY, 7);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move right 2
	refX = moveRight(refX, 2);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move up 2
	refY = moveUp(refY, 2);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move right 5
	refX = moveRight(refX, 5);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move up 2
	refY = moveUp(refY, 2);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move left 9
	refX = moveLeft(refX, 9);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move down 1
	refY = moveDown(refY, 1);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move left 6
	refX = moveLeft(refX, 6);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	// move up 1
	refY = moveUp(refY, 1);
	cout << "Current Position: (" << refX << ", " << refY << ")" << "\n";

	cout << "\nEnding Position: (" << refX << ", " << refY << ")" << "\n";

	return 0;
}
