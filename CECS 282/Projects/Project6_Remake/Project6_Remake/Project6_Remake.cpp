// Project6_Remake.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 4/22/19

#include "pch.h"
#include "Point.h"
#include "Line.h"
#include <iostream>

using namespace std;

int main()
{
	Point<int> p1(10, 0);
	Point<int> p2(0, 0);
	Point<int> p3(5, 5);
	Point<int> p4(4, 8);
	Point<int> p5(7, 4);
	Point<int> p6(2, 2);
	Line<int> result(0, 0, 0, 0);

	Line<int> L1(p2, p3);
	cout << "Line 1\n" << L1 << endl;

	Line<int> L2(p6, p3);
	cout << "Line 2\n" << L2 << endl;
	
	if (result.isParallel(L1, L2)) {
		cout << "L1 and L2 are parallel\n" << endl;
	}
	else {
		cout << "L1 and L2 are not parallel\n" << endl;
	}

	Line<int> L3(p3, p1);
	cout << "Line 3\n" << L3 << endl;

	if (result.isPerpendicular(L1, L3)) {
		cout << "L1 and L3 are perpendicular\n" << endl;
	}
	else {
		cout << "L1 and L3 are not perpendicular\n" << endl;
	}

	Line<int> L4(p4, p5);

	if (result.isIntersecting(L1, L4)) {
		cout << " for L1 and L4\n";
	}
	else {
		cout << "L1 and L4 don't intersect\n" << endl;
	}

	return 0;
}