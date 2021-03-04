// SavingsAccount.h
#pragma once
#ifndef SavingsAccount_h
#define SavingsAccount_h

#include <stdio.h>
#include <string>
#include <iostream>
#include "Account.h"

using namespace std;

class SavingsAccount: public Account {
private:
	double currentInterest;
public:
	// Overloaded constructor
	// currentAmt and newInterest are of type double
	SavingsAccount(double currentAmt, double newInterest) {
		initialBal = currentAmt;
		currentInterest = newInterest;
	}

	// Destructor
	~SavingsAccount() { cout << "Destructor..."; }

	// Calculate the interest
	// Returns the initial balance multiplied by the current interest rate
	double calculateInterest() { return initialBal * currentInterest; }
};
#endif // !SavingsAccount_h
