import turtle
wn = turtle.Screen()
daniel = turtle.Turtle()

daniel.pensize(5)
for a in range(4):
    daniel.forward(100)
    daniel.left(90)

wn.exitonclick()
