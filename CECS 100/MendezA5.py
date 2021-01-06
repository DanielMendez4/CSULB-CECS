#This program will simulate drawing a card from a deck until King of Hearts is drawn
#Program will then draw a line graph showing draws it took to get King of Hearts per game

import turtle
import random

MIN = 1
MAX = 4
MAX_2 = 13

#The drawCard function draws until a King of Hearts is obtained
def drawCard():         
    count = 0
    win = False
    while not win:
        count = count + 1
        outcome1 = random.randint(MIN, MAX)
        outcome2 = random.randint(MIN, MAX_2)
        if outcome1 == 1 and outcome2 == 13:
            win = True
    return count

#Prompts user to input how many games to play
max_games = input("Enter number of games you would like to play: ")
n = int(max_games)
count = 0
for a in range(n):
    count = drawCard()
    win = count
    print("Number of draws it took to get a King of Hearts:",win)

#The drawLineGraph plots points received from drawCard function
def drawLineGraph(t, x, y): 
    if x == 0:
        t.up()
        t.goto(x, y)
        t.write(" "+str(y))     
        t.down()
    t.goto(x,y)
    t.write(" "+str(y))
numpoints = n
maxheight = 200
border = 10

wn = turtle.Screen()
wn.setworldcoordinates(0-border, 0, n*numpoints+border, maxheight+border)
wn.bgcolor("lightblue")
daniel = turtle.Turtle()
daniel.color("red")
daniel.pensize(2)
daniel.speed(20)
for b in range(numpoints):
    h = drawCard()
    drawLineGraph(daniel, b*n, h)
    
wn.exitonclick()
