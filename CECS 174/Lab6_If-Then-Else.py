#This program will draw a bullseye using dots
#If x and y coordinates of dot is between a specified band, then dot color is blue
#Else, dot color is red
#Authors: Daniel Mendez & John Patrick Salcedo
import turtle
import random
import math
# Starting place for Lab 6 - If-then-else
myTurtle = turtle.Turtle()
myTurtle.speed("fastest")
myScreen = turtle.Screen()
myScreen.title("Marking an area")
width = 1000
height = 1000
xOrigin = 0
yOrigin = 0
noDots = 2000
dotRadius = 20

myScreen.setup(width, height, xOrigin, yOrigin)
backgroundColor = 'orange'
dotColor = 'blue'
myScreen.bgcolor(backgroundColor)
myScreen.delay(0)

bands = [(0,100),(200,300),(400,500)] #List of tuples with band length
x = 0
y = 0

def inBand(x,y,bands):
    """If dot is between specifed band, then return true; if not, return false"""
    for band in bands:
        if distance >= band[0] and distance <= band[1]:
            return True
    else:
        return False

for i in range(noDots):
    xpos = random.randint(-width/2, height/2)
    ypos = random.randint(-width/2, height/2)
    print("Location - x: %f, y: %f" % (xpos, ypos))
    distance = math.sqrt(math.pow(xpos,2) + math.pow(ypos,2))
    if inBand(x,y,bands):
        dotColor = "blue"
        dotRadius = 20
    else:
        dotColor = "red"
        dotRadius = 20
    myTurtle.goto(xpos,ypos)
    myTurtle.dot(dotRadius,dotColor)
    
turtle.done()
