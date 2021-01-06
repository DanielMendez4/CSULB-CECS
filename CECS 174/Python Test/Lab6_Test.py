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

bands = [(0,100),(200,300),(400,500)]

for i in range(noDots):
    xpos = random.randint(-width/2, height/2)
    ypos = random.randint(-width/2, height/2)
    print("Location - x: %f, y: %f" % (xpos, ypos))
    distance = math.sqrt(math.pow(xpos,2) + math.pow(ypos,2))
    if distance >= bands[0][0] and distance <= bands[0][1]:
        dotColor = "blue"
        dotRadius = 20
    elif distance >= bands[1][0] and distance <= bands[1][1]:
        dotColor = "blue"
        dotRadius = 20
    elif distance >= bands[2][0] and distance <= bands[2][1]:
        dotColor = "blue"
        dotRadius = 20
    else:
        dotColor = "red"
        dotRadius = 20
    myTurtle.goto(xpos, ypos)
    myTurtle.dot(dotRadius, dotColor)
       
turtle.done()
