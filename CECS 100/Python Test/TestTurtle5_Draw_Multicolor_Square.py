import turtle
"""def drawMulticolorSquare(t, sz):
    for i in ['red', 'purple', 'hotpink', 'blue']:
        t.color(i)
        t.forward(sz)
        t.left(90)
wn = turtle.Screen()
daniel = turtle.Turtle()
daniel.pensize(3)
daniel.speed(20)
size = 20
for i in range(20):
    drawMulticolorSquare(daniel, size)
    size = size + 10
    daniel.forward(10)
    daniel.right(18)
wn.exitonclick()"""

colorList = ["red","green","blue","orange","pink","yellow","black"]
def drawBox(turtle,color,x,y):
    myTurtle.up()
    myTurtle.fillcolor(color)
    myTurtle.goto(x,y)
    myTurtle.begin_fill()
    myTurtle.down()
    myTurtle.forward(75)
    myTurtle.right(90)
    myTurtle.forward(50)
    myTurtle.right(90)
    myTurtle.forward(75)
    myTurtle.right(90)
    myTurtle.forward(50)
    myTurtle.right(90)
    myTurtle.end_fill()
    myTurtle.down()

myTurtle = turtle.Turtle()
myTurtle.speed('fastest')
x = 225
y = 250
for color in colorList:
    drawBox(myTurtle,color,x,y)
    y = y - 50
