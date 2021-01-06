#This program will prompt the user to enter 2 x and 2 y coordinates
#Then program will attempt to find the slope between those points
#Authors: Daniel Mendez & John Patrick Salcedo
import math

prompt = 0
def getReal(prompt):
    """Function will prompt user to enter x and y coordinates.
       If user enters anything besides a number, program prompts user to try again"""
    while True:
        try:
            x1 = float(input("Please enter the first x coordinate-->"))
            y1 = float(input("Please enter the first y coordinate-->"))
            x2 = float(input("Please enter the second x coordinate-->"))
            y2 = float(input("Please enter the second y coordinate-->"))
        except ValueError:
            print("Sorry, I don't understand.")
            continue
        
        return x1,y1,x2,y2

def slope(lineSegment):
    """Function will calculate the slope from the points entered by user
       If the slope is undefined or infinity, program will let user know
       If the slope is valid, returns the value of the slope"""
    if (lineSegment[2]-lineSegment[0]) == 0:
        print("Sorry, but 32 bits is just not enought to represent your slope.")
    else:
        slope = (lineSegment[3]-lineSegment[1])/(lineSegment[2]-lineSegment[0])
        if math.isinf(slope):
            print("Sorry, but 32 bits is just not enough to represent your slope.")
        else:
            print("The calculated slope was %f" %(slope))
            return slope

def getLineSegment():
    """Function will call getReal(prompt) and slope(lineSegment)
       Will prompt user if they would like to try again after results are calculated"""
    again = "y"
    while again == "y":
        lineSegment = getReal(prompt)
        slope(lineSegment)
        again = input("Care to go on? (y/n)")

getLineSegment()
