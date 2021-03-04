#pragma once
#ifndef List_h
#define List_h

#include <stdio.h>
#include <string>

using namespace std;

struct Node {
	string data;
	Node * next;
};

class List {
private:
	Node * head;
	Node * tail;
public:
	List();
	~List();
	int size();

	void add(string);
	void addHead(string);
	void addPos(int, string);

	string deleteHead();
	string deleteTail();
	string deletePos(int);

	void display();
	string to_string();
};
#endif /*List_h*/