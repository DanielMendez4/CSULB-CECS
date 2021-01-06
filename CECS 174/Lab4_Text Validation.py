#This program will prompt the user to enter their martial status indicated by the options presented
#If user enters one of the options, program will print user reponse
#If not, program guesses what the user meant and prompts user to enter something new
#Program ends until user input matches one of the options
#Authors: John Patrick Salcedo & Daniel Mendez
import sys
print("What is your married state?")
print("You could enter: married")
print("You could enter: single")
print("You could enter: swinger")
print("You could enter: vowed religious")
a = input()
b = ["married","single","swinger","vowed religious"]
answer = a
def validateString(a,b):
    """Function takes user input"""
    def inOptions(b,answer):
        """Determines whether user input is valid"""
        if answer in b: #If user input matches one of the options, program prints user input and terminates
            print(answer)
            sys.exit()
    inOptions(b,answer)
def lv_number(b,answer):
    """Return the Levenshtein distance as an integer between two strings"""
    string1 = answer
    string2 = b
    distance = 0
    n1 = len(string1)
    n2 = len(string2)
    if n1 >= n2:
        for i in range(n1):
            if i < n2:
                if string1[i] != string2[i]:
                    distance += 1
            else:
                distance += 1
    else:
        for i in range(n2):
            if i < n1:
                if string2[i] != string1[i]:
                    distance -= 1
            else:
                distance -= 1
    return distance
def closest(b,answer):
    """Takes user input and compares it to options prompted by the program.
       Program will then try to determine what the user meant."""
    answer = a
    while answer != b: #This while loop will keep prompting user input until it matches one of the options
        if answer in b:
            print(answer)
            sys.exit()
        options = b
        distance = []
        userInput = answer
        for option in options:
            distance.append(abs(lv_number(answer, option)))
        intList = distance
        lowest = intList[0]
        index = 0
        for i in range(len(intList)):
            if intList[i] < lowest:
                index = i
                lowest = intList[i]
            if index == 0: #Program determines what the user meant depending on the index
                    index = "married?"
            if index == 1:
                    index = "single?"
            if index == 2:
                    index = "swinger?"
            if index == 3:
                    index = "vowed religious?"
        print("Do you mean:",index)
        print("What is your married state?")
        print("You could enter: married")
        print("You could enter: single")
        print("You could enter: swinger")
        print("You could enter: vowed religious")
        answer = input()
def main():
    validateString(a,b)
    lv_number(b,answer)
    closest(b,answer)
main()
