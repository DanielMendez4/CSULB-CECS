import turtle
wn = turtle.Screen()
wn.bgcolor("lightblue")

ben = turtle.Turtle()
ben.color("red")
ben.pensize(10)

jerry = turtle.Turtle()

ben.forward(80)
ben.left(120)
ben.forward(80)
ben.left(120)
ben.forward(80)
ben.left(120)

ben.right(180)
ben.forward(80)

jerry.forward(50)
jerry.left(90)
jerry.forward(50)
jerry.left(90)
jerry.forward(50)
jerry.left(90)
jerry.forward(50)
jerry.left(90)

wn.exitonclick()
