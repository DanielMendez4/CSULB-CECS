#This program will take a list of customers along with the items they want to buy.
#Returns the customer's name and the total amount they will spend.
#Authors: Daniel Mendez & John Patrick Salcedo
booklist = {"Programming In Python 3.3 Zybook Access Code (Digital)": 65.25, \
            "Digital Design + Computer Architecture": 93.45, \
            "Big Java: Early Objects Ebook Accesscode (Digital)": 60.25, \
            "Intro To Algorithms": 103.00, \
            "Starting Out W/ C++ From Control Struct (Looseleaf)": 115.95}

def addCustomer(books, customers, name, items):
    """This function will add a new customer to the back end of a list of customers.
       All information regarding the customer will be kept for use in other functions.
       Raise ValueError if any of the titles aren't in booklist.
       Arguments
       books:     The dictionary booklist.
       customers: The running list of customers in line.
       name:      The name of the customer that you want to add.
       items:     The list of book titles that they want to buy."""
    complete = []
    customerBookList = []
    for i in range(len(items)):
        if items[i] not in booklist:
            raise ValueError("Title entered not in booklist!")
        customerBookList.append(items[i])
    complete.append(name)
    complete.append(customerBookList)
    customers.append(complete)
    
def totalBill(booklist, customers):
    """Calculates the total amount of money for each book on the customers item list
       Arguments
       books:             The dictionary booklist.
       customersBookList: The list of titles customer wants to purchase.
       Returns:           Total amount for the books"""
    total = 0
    for i in range(len(customers[0][1])):
        customerBookList = customers[0][1][i]
        total += booklist[customerBookList]
    return total
    
def serveCustomer(books, customers):
    """Serves the customer at the head of the line.
       Raise IndexError if no customers are left in the customer list
       Arguments
       books:     The dictionary booklist.
       customers: The list of customers that represents a queue.
       Removing the customer from the front of the queue is part of this function."""
    if not customers:
        raise IndexError("No customers left to serve!")
    final = customers[0][0], totalBill(booklist, customers)
    customers.pop(0)
    return final
