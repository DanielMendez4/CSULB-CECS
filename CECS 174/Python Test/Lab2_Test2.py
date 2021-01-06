import turtle
daniel = turtle.Turtle()
wn = turtle.Screen()
def drawEyes(turtle,color,size,x,y):
    turtle.penup()
    turtle.color(color) #Sets the color for the turtle
    turtle.fillcolor(color) #Sets the color for the eyes
    turtle.goto(x,y) #Turtle moves to specified location
    turtle.begin_fill() #Turtle fills eyes with desired color
    turtle.circle(size) #Sets the size of the eyes
    turtle.end_fill() #Turtle finishes drawing the eyes
    turtle.pendown()
def drawNose(turtle,color,size,x,y):
    turtle.penup()
    turtle.color(color) #Sets the color for the turtle
    turtle.fillcolor(color) #Sets the color for the nose
    turtle.goto(x,y) #Turtle moves to specified location
    turtle.begin_fill() #Turtle fills nose with desired color
    turtle.circle(size) #Sets the size of the nose
    turtle.end_fill() #Turtle finishes drawing the nose
    turtle.pendown()
def drawMouth(turtle,color,size,extent,x,y):
    turtle.right(90) #Turtle turns 90 degrees to face south
    turtle.penup()
    turtle.color(color) #Sets the color for the turtle
    turtle.goto(x,y) #Turtle moves to specified location
    turtle.pendown()
    turtle.circle(size,extent)
def drawFace():
    drawEyes(daniel,"blue",50,200,200) #Draws one eye
    drawEyes(daniel,"blue",50,-200,200) #Draws another eye
    drawNose(daniel,"red",25,0,0) #Draws the nose in the center of the window
    drawMouth(daniel,"black",200,180,-200,0) #Draws the mouth
drawFace()
wn.exitonclick()
