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
    global customerBookList
    customers.append(name)
    for i in range(len(items)):
        if items[i] not in booklist:
            raise ValueError("Title entered not in booklist!")
    customerBookList = items

def totalBill(booklist, customerBookList):
    """Calculates the total amount of money for each book on the customers item list
       Arguments
       books:             The dictionary booklist.
       customersBookList: The list of titles customer wants to purchase.
       Returns:           Total amount for the books"""
    total = 0
    for i in range(len(customerBookList)):
        total += booklist[customerBookList[i]]
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
    for i in range(len(customers)):
        person = customers[i]
        customers.remove(person)
        i += 1
        return person, totalBill(booklist, customerBookList)
    
"""When testing...
customers = []
addCustomer(booklist, customers, 'Bob', ['Digital Design + Computer Architecture', 'Big Java: Early Objects Ebook Accesscode (Digital)'])
addCustomer(booklist, customers, 'Dave', ['Programming In Python 3.3 Zybook Access Code (Digital)', 'Big Java: Early Objects Ebook Accesscode (Digital)', 'Starting Out W/ C++ From Control Struct (Looseleaf)'])
serveCustomer(booklist, customers)
serveCustomer(booklist, customers)"""
