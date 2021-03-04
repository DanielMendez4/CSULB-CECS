// Line.h
#pragma once
#ifndef Line_h
#define Line_h

#include <stdio.h>
#include <iostream>
#include <string>
#include "Point.h"

using namespace std;

template <class T>
class Line {
private:
	Point<T> p1;
	Point<T> p2;
public:
	Line() {};
	Line(Point<T> a, Point<T> b) {
		p1 = a;
		p2 = b;
	}
	Line(int x1, int y1, int x2, int y2) {
		p1.setX(x1);
		p1.setY(y2);
		p2.setX(x2);
		p2.setY(y2);
	}
	~Line() {
		//cout << "Destructor" << endl;
	}
	// Determines if two lines are perpendicular
	// L1 and L2 are Line objects
	// returns true if perpendicular, false otherwise
	bool isPerpendicular(Line<T> L1, Line<T> L2) {
		float slope1 = (float)(L1.p2.getY() - L1.p1.getY()) / (float)(L1.p2.getX() - L1.p1.getX());
		float slope2 = (float)(L2.p2.getY() - L2.p1.getY()) / (float)(L2.p2.getX() - L2.p1.getX());
		float inverseSlope1 = -1 / slope1;
		if (inverseSlope1 == slope2) { return true; }
		else { return false; }
	}
	// Determines if two lines are parallel
	// L1 and L2 are Line objects
	// returns true if parallel, false otherwise
	bool isParallel(Line<T> L1, Line<T> L2) {
		float slope1 = (float)(L1.p2.getY() - L1.p1.getY()) / (float)(L1.p2.getX() - L1.p1.getX());
		float slope2 = (float)(L2.p2.getY() - L2.p1.getY()) / (float)(L2.p2.getX() - L2.p1.getX());
		if (slope1 == slope2) { return true; }
		else { return false; }
	}
	// Determines if two lines are intersecting
	// L1 and L2 are Line objects
	// returns true if intersecting, false otherwise
	bool isIntersecting(Line<T> L1, Line<T> L2) {
		float slope1 = (float)(L1.p2.getY() - L1.p1.getY()) / (float)(L1.p2.getX() - L1.p1.getX());
		float slope2 = (float)(L2.p2.getY() - L2.p1.getY()) / (float)(L2.p2.getX() - L2.p1.getX());
		if (slope1 == slope2) { return false; }
		else {
			// ========== Line 1 ==========
			int x1 = L1.p1.getX();
			int y1 = L1.p1.getY();
			int x2 = L1.p2.getX();
			int y2 = L1.p2.getY();
			int numSlope = y2 - y1;
			int denSlope = x2 - x1;
			for (int i = numSlope * denSlope; i > 1; i--) {
				if ((numSlope % i == 0) && (denSlope % i == 0)) {
					numSlope /= i;
					denSlope /= i;
				}
			}
			int yInterNum = (y1 * denSlope) - (numSlope * x1);
			int yInterDen = denSlope;
			for (int i = yInterNum * yInterDen; i > 1; i--) {
				if ((yInterNum % i == 0) && (yInterDen % i == 0)) {
					yInterNum /= i;
					yInterDen /= i;
				}
			}
			// ========== Line 2 ==========
			int x3 = L2.p1.getX();
			int y3 = L2.p1.getY();
			int x4 = L2.p2.getX();
			int y4 = L2.p2.getY();
			int numSlope2 = y4 - y3;
			int denSlope2 = x4 - x3;
			for (int i = numSlope2 * denSlope2; i > 1; i--) {
				if ((numSlope2 % i == 0) && (denSlope2 % i == 0)) {
					numSlope2 /= i;
					denSlope2 /= i;
				}
			}
			int yInterNum2 = (y3 * denSlope2) - (numSlope2 * x3);
			int yInterDen2 = denSlope2;
			for (int i = yInterNum2 * yInterDen2; i > 1; i--) {
				if ((yInterNum2 % i == 0) && (yInterDen2 % i == 0)) {
					yInterNum2 /= i;
					yInterDen2 /= i;
				}
			}
			// ========== Check ==========
			if (slope1 < slope2) {
				int xSolveNum = (numSlope2 * denSlope) - (numSlope * denSlope2);
				int xSolveDen = (denSlope2 * denSlope);
				int ySolveNum = 0;
				int ySolveDen = 0;
				if (yInterNum2 < 0) {
					ySolveNum = (yInterNum * yInterDen2) + (yInterNum2 * yInterDen);
					ySolveDen = (yInterDen * yInterDen2);
				}
				else if (yInterNum2 > 0) {
					ySolveNum = (yInterNum * yInterDen2) - (yInterNum2 * yInterDen);
					ySolveDen = (yInterDen * yInterDen2);
				}
				else if (yInterNum2 == 0) {
					ySolveNum = yInterNum;
					ySolveDen = yInterDen;
				}
				int xCorNum = (ySolveNum * xSolveDen);
				int xCorDen = (ySolveDen * xSolveDen);
				for (int i = xCorNum * xCorDen; i > 1; i--) {
					if ((xCorNum % i == 0) && (xCorDen % i == 0)) {
						xCorNum /= i;
						xCorDen /= i;
					}
				}
				int yCorNum = (numSlope2 * xCorNum * yInterDen2) + (yInterNum2 * denSlope2 * xCorDen);
				int yCorDen = (denSlope2 * xCorDen * yInterDen2);
				for (int i = yCorNum * yCorDen; i > 1; i--) {
					if ((yCorNum % i == 0) && (yCorDen % i == 0)) {
						yCorNum /= i;
						yCorDen /= i;
					}
				}
				cout << "Intersection at (" << xCorNum << "/" << xCorDen << ", " << yCorNum << "/" << yCorDen << ")";
			}
			else if (slope1 > slope2) {
				int xSolveNum = (numSlope * denSlope2) - (numSlope2 * denSlope);
				int xSolveDen = (denSlope2 * denSlope);
				int ySolveNum = 0;
				int ySolveDen = 0;
				if (yInterNum < 0) {
					ySolveNum = (yInterNum2 * yInterDen) + (yInterNum * yInterDen2);
					ySolveDen = (yInterDen * yInterDen2);
				}
				else if (yInterNum > 0) {
					ySolveNum = (yInterNum2 * yInterDen) - (yInterNum * yInterDen2);
					ySolveDen = (yInterDen * yInterDen2);
				}
				else if (yInterNum == 0) {
					ySolveNum = yInterNum2;
					ySolveDen = yInterDen2;
				}
				int xCorNum = (ySolveNum * xSolveDen);
				int xCorDen = (ySolveDen * xSolveDen);
				for (int i = xCorNum * xCorDen; i > 1; i--) {
					if ((xCorNum % i == 0) && (xCorDen % i == 0)) {
						xCorNum /= i;
						xCorDen /= i;
					}
				}
				int yCorNum = (numSlope2 * xCorNum * yInterDen2) + (yInterNum2 * denSlope2 * xCorDen);
				int yCorDen = (denSlope2 * xCorDen * yInterDen2);
				for (int i = yCorNum * yCorDen; i > 1; i--) {
					if ((yCorNum % i == 0) && (yCorDen % i == 0)) {
						yCorNum /= i;
						yCorDen /= i;
					}
				}
				cout << "Intersection at (" << xCorNum << "/" << xCorDen << ", " << yCorNum << "/" << yCorDen << ")";
			}
			return true;
		}
	}

	friend istream & operator>>(istream &in, Line<T> &line) {
		cout << "Enter the x-coordinate for p1: ";
		in >> line.p1.setX(in);
		cout << "Enter the y-coordinate for p1: ";
		in >> line.p1.setY(in);
		cout << "Enter the x-coordinate for p2: ";
		in >> line.p2.setX(in);
		cout << "Enter the y-coordinate for p2: ";
		in >> line.p2.setY(in);
		return in;
	}

	friend ostream & operator<<(ostream &out, Line<T> & line) {
		out << "P = " << line.p1 << endl;
		out << "Q = " << line.p2 << endl;
		int x1 = line.p1.getX();
		int y1 = line.p1.getY();
		int x2 = line.p2.getX();
		int y2 = line.p2.getY();
		int numSlope = y2 - y1;
		int denSlope = x2 - x1;
		for (int i = numSlope * denSlope; i > 1; i--) {
			if ((numSlope % i == 0) && (denSlope % i == 0)) {
				numSlope /= i;
				denSlope /= i;
			}
		}
		string a = to_string(numSlope);
		string b = to_string(denSlope);
		int yInterNum = (y1 * denSlope) - (numSlope * x1);
		int yInterDen = denSlope;
		for (int i = yInterNum * yInterDen; i > 1; i--) {
			if ((yInterNum % i == 0) && (yInterDen % i == 0)) {
				yInterNum /= i;
				yInterDen /= i;
			}
		}
		string c = to_string(yInterNum);
		string d = to_string(yInterDen);
		out << "y = " << a << "/" << b << "x + " << c << "/" << d << endl;
		return out;
	}
};
#endif // !Line_h
