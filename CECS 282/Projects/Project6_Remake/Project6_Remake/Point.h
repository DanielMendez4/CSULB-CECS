// Point.h
#pragma once
#ifndef Point_h
#define Point_h

#include <stdio.h>
#include <iostream>

using namespace std;

template <class T>
class Point {
private:
	T x;
	T y;
public:
	Point() {}
	Point(T a, T b) {
		x = a;
		y = b;
	}
	~Point() {
		//cout << "Destructor" << endl;
	}
	void setX(T a) { x = a; }
	void setY(T b) { y = b; }
	T getX() { return x; }
	T getY() { return y; }

	friend istream & operator>>(istream &in, Point &p) {
		cout << "Enter the x-coordinate: ";
		in >> p.x;
		cout << "Enter the y-coordinate: ";
		in >> p.y;
		return in;
	}

	friend ostream & operator<<(ostream &out, const Point &p) {
		out << "(" << p.x << ", " << p.y << ")";
		return out;
	}
};
#endif // !Point_h