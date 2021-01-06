max_games = input("Enter number of games you would like to play: ")
n = int(max_games)

import turtle

def drawLineGraph(t, x, y):
    if x == 0:
        t.up()
        t.goto(x, y)
        t.write(" "+str(y))
        t.down()
    t.goto(x,y)
    t.write(" "+str(y))

numpoints = n
maxheight = 100
border = 10

wn = turtle.Screen()
wn.setworldcoordinates(0-border, 0, n*numpoints+border, maxheight+border)
wn.bgcolor("lightblue")

daniel = turtle.Turtle()
daniel.color("red")
daniel.pensize(2)

for b in range(numpoints):
    h = 100
    drawLineGraph(daniel, b*n, h)

wn.exitonclick()
