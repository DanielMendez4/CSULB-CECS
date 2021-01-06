#This program utilizes the turtle module to draw a face
#The face consists of 2 eyes, a nose, and a mouth
#Authors: Daniel Mendez & John Patrick Salcedo
import turtle
daniel = turtle.Turtle()
wn = turtle.Screen()
def drawCircle(turtle,color,size,x,y):
    turtle.penup()
    turtle.color(color) #Sets the for the turtle
    turtle.fillcolor(color) #Sets the color for the eyes and nose
    turtle.goto(x,y) #Turtle moves to specified location
    turtle.begin_fill()
    turtle.circle(size)
    turtle.end_fill()
    turtle.pendown()
def drawMouth(turtle,color,size,extent,x,y):
    turtle.right(90)
    turtle.penup()
    turtle.color(color)
    turtle.goto(x,y)
    turtle.pendown()
    turtle.circle(size,extent)
def drawFace():
    drawCircle(daniel,"blue",50,200,200) #Draws one eye
    drawCircle(daniel,"blue",50,-200,200) #Draws another eye
    drawCircle(daniel,"red",25,0,0) #Draws the nose in the center of the window
    drawMouth(daniel,"black",200,180,-200,0) #Draws the mouth
drawFace()
wn.exitonclick()

