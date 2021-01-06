import turtle
wn = turtle.Screen()
wn.bgcolor("lightblue")
daniel = turtle.Turtle()
daniel.color("green")
daniel.shape("turtle")

print(list(range(5, 60, 2)))
daniel.up()
for size in range(5, 60, 2):
    daniel.stamp()
    daniel.forward(size)
    daniel.right(24)

wn.exitonclick()
