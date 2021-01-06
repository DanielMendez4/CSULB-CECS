import turtle
wn = turtle.Screen()
daniel = turtle.Turtle()
adrian = turtle.Turtle()

daniel.pensize(5)
for a in [0, 1, 2, 3]:
    daniel.forward(100)
    daniel.left(90)

adrian.pensize(5)    
adrian.left(180)
for aColor in ["red", "orange", "blue", "green"]:
    adrian.color(aColor)
    adrian.forward(100)
    adrian.left(90)
    
wn.exitonclick()
