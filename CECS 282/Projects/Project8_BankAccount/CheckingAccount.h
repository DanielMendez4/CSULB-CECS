// CheckingAccount.h
#pragma once
#ifndef CheckingAccount_h
#define CheckingAccount_h

#include <stdio.h>
#include <string>
#include <iostream>
#include "Account.h"

using namespace std;

class CheckingAccount: public Account {
private:
	double currentFee;
public:
	// Overloaed constructor
	// currentAmt and newFee are of type double
	CheckingAccount(double currentAmt, double newFee) {
		initialBal = currentAmt;
		currentFee = newFee;
	}

	// Destructor
	~CheckingAccount() { cout << "Destructor..."; }

	// Adds money to the checking account
	// addAmt is a double
	void credit(double addAmt) { initialBal = (initialBal + addAmt) - currentFee; }

	// Removes money from the checking account
	// removeAmt is a double
	void debit(double removeAmt) {
		
		if ((removeAmt + currentFee) > initialBal) {
			cout << "Debit amount exceeded amount balance." << endl;
		}
		else {
			initialBal = initialBal - (removeAmt + currentFee);
		}
	}
};
#endif // !CheckingAccount_h