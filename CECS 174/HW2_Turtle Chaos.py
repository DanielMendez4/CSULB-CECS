#This program is supposed to draw random polygons within a given area
#Each side of the polygon has a differnt color
#Each polygon has a random fill color
#Authors: Daniel Mendez & John Patrick Salcedo
import turtle
import random

ngons = int(input("How many polygons do you want to be drawn?: ")) #How many polygons will be drawn
maxLength = int(input("Enter a number for the maximum length: ")) #Maximum length of each side of a polygon
t = turtle.Turtle()
t.speed("fastest")
wn = turtle.Screen()
wn.title("Drawing Polygons")
screenWidth = 1000
screenHeight = 1000
xOrigin = 0
yOrigin = 0
wn.setup(screenWidth, screenHeight, xOrigin, yOrigin)
wn.delay(0)

lineColor = (0, 0, 0)
fillColor = (0, 0, 0)
topLeftX = -400
topLeftY = 400
width = 800
height = 800
startX = 0
startY = 0
steps = 0

def randomPolygon(turtle,lineColor,fillColor,topLeftX,topLeftY,width,height,startX,startY,maxLength):
    """Sets up the starting point of the polygon and draws the polygon"""
    t.up()
    steps = random.randint(5, 10)
    startX = random.randint(-width/2, height/2)
    startY = random.randint(-width/2, height/2)
    t.goto(startX, startY)
    t.down()
    t.begin_fill()
    for i in range(steps):
        lineColor = (random.random(), random.random(), random.random())
        t.pencolor(lineColor)
        t.setheading(random.randint(0, 359))
        t.forward(random.random() * maxLength)
    t.goto(startX, startY)
    t.end_fill()
    
def randomPolygons(turtle,topLeftX,topLeftY,width,height,ngons,maxLength):
    """Calls randomPolygon to draw the polygons"""
    for i in range(ngons):
        fillColor = (random.random(), random.random(), random.random())
        t.fillcolor(fillColor)
        randomPolygon(turtle,lineColor,fillColor,topLeftX,topLeftY,width,height,startX,startY,maxLength)

randomPolygons(turtle,topLeftX,topLeftY,width,height,ngons,maxLength)
wn.exitonclick()
