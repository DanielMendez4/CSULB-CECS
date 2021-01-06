import math

prompt = 0
def getReal(prompt):
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
    again = "y"
    while again == "y":
        lineSegment = getReal(prompt)
        slope(lineSegment)
        again = input("Care to go on? (y/n)")

getLineSegment()
