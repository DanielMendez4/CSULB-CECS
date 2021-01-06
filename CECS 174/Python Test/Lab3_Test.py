import math
import turtle
x1 = int(input("Enter the first x-coordinate: "))
y1 = int(input("Enter the first y-coordinate: "))
x2 = int(input("Enter the second x-coordinate: "))
y2 = int(input("Enter the second y-coordinate: "))
x3 = int(input("Enter the third x-coordinate: "))
y3 = int(input("Enter the third y-coordinate: "))
def bisectorBetweenPoints(x1,y1,x2,y2,x3,y3):
    global slope1
    global midx1
    global midy1
    global slope2
    global midx2
    global midy2
    slope1 = (y2-y1)/(x2-x1)
    midx1 = (x1+x2)/2
    midy1 = (y1+y2)/2
    slope2 = (y3-y2)/(x3-x2)
    midx2 = (x2+x3)/2
    midy2 = (y2+y3)/2
bisectorBetweenPoints(x1,y1,x2,y2,x3,y3)
m1 = -1/slope1
m2 = -1/slope2
intercept1 = midy1-(m1*midx1)
intercept2 = midy2-(m2*midx2)
print("Intercept 1 is",intercept1)
print("Intercept 2 is",intercept2)
def intersectionBetweenLines(slope1,intercept1,slope2,intercept2):
    global x
    global y
    x = (intercept1-intercept2)/(m2-m1)
    y = (m1*x)+intercept1
    print("The center is",x,y)
intersectionBetweenLines(slope1,intercept1,slope2,intercept2)
def distance(x,y,x1,y1):
    global d
    d = math.sqrt((y1-y)**2+(x1-x)**2)
    print("The distance is",d)
distance(x,y,x1,y1)
radius = d
john = turtle.Turtle()
wn = turtle.Screen()
def drawCircle(turtle,x,y,radius):
    turtle.penup()
    turtle.goto(x1,y1)
    turtle.dot()
    turtle.goto(x2,y2)
    turtle.dot()
    turtle.goto(x3,y3)
    turtle.dot()
    turtle.goto(x1,y1)
    turtle.pendown()
    turtle.circle(radius)
drawCircle(john,x,y,radius)
wn.exitonclick()
