import turtle
import random

def drawLineGraph(t, x, y):
    if x == 0:
        t.up()
        t.goto(x, y)
        t.write(" "+str(y))
        t.down()
    t.goto(x,y)
    t.write(" "+str(y))

maxheight = 100
numpoints = 20
border = 10

wn = turtle.Screen()
wn.setworldcoordinates(0-border, 0, 20*numpoints+border, maxheight+border)
wn.bgcolor("lightblue")

daniel = turtle.Turtle()
daniel.color("green")
daniel.pensize(5)

for a in range(numpoints):
    h = random.randint(1, maxheight)
    drawLineGraph(daniel, a*20, h)

wn.exitonclick()
