// Project8_BankAccount.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Created by Daniel Mendez on 5/9/19

#include "Account.h"
#include "SavingsAccount.h"
#include "CheckingAccount.h"
#include <iostream>

using namespace std;

int main()
{
	Account myAcct(1000);
	cout << "Account: $" << myAcct.getBalance() << endl;
	myAcct.debit(2000);
	cout << "Account after debit: $" << myAcct.getBalance() << endl;
	myAcct.debit(1000);
	myAcct.credit(5000);
	cout << "Account after debit and credit: $" << myAcct.getBalance() << endl;

	Account myAcct2(-10);
	cout << "Account2: $" << myAcct2.getBalance() << endl;

	SavingsAccount mySavings(2000, .10);
	cout << "Savings: $" << mySavings.getBalance() << endl;
	cout << "Interest from savings: $" << mySavings.calculateInterest() << endl;
	mySavings.credit(mySavings.calculateInterest());
	cout << "Savings w/ interest: $" << mySavings.getBalance() << endl;

	CheckingAccount myChecking(3000, 5);
	cout << "Checking: $" << myChecking.getBalance() << endl;
	myChecking.credit(10);
	cout << "Checking credit: $" << myChecking.getBalance() << endl;
	myChecking.debit(5);
	cout << "Checking debit: $" << myChecking.getBalance() << endl;

	return 0;
}