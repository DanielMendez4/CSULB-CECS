// Account.h
#pragma once
#ifndef Account_h
#define Account_h

#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

class Account {
protected:
	double initialBal;
public:
	// Default constructor
	Account() { initialBal = 0.00; }

	// Overloaded constructor
	// newAmt is a double
	Account(double newAmt) {
		if (newAmt < 0) {
			initialBal = 0.00;
			cout << "Initial Balance is set to 0.00 since the indicated amount is invalid!" << endl;
		}
		else {
			initialBal = newAmt;
		}
	}
	
	// Destructor
	~Account() { cout << "Destructor..."; }

	// Adds money to the initial balance
	// addAmt is a double
	void credit(double addAmt) { initialBal = initialBal + addAmt; }

	// Removes money from the initial balance
	// removeAmt is a double
	void debit(double removeAmt) {

		if (removeAmt > initialBal) {
			cout << "Debit amount exceeded account balance." << endl;
		}
		else {
			initialBal = initialBal - removeAmt;
		}
	}

	// Gets the initial balance
	// Returns the initial balance
	double getBalance() { return initialBal; }
};
#endif // !Account_h