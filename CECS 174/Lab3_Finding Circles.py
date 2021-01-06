import math
import turtle
x1 = int(input("Enter the first x-coordinate: "))
y1 = int(input("Enter the first y-coordinate: "))
x2 = int(input("Enter the second x-coordinate: "))
y2 = int(input("Enter the second y-coordinate: "))
x3 = int(input("Enter the third x-coordinate: "))
y3 = int(input("Enter the third y-coordinate: "))
def bisectorBetweenPoints(x1,y1,x2,y2,x3,y3):
    slope1 = (y2-y1)/(x2-x1)
    midx1 = (x1+x2)/2
    midy1 = (y1+y2)/2
    slope2 = (y3-y2)/(x3-x2)
    midx2 = (x2+x3)/2
    midy2 = (y2+y3)/2
    return slope1,midx1,midy1,slope2,midx2,midy2
def slopesIntercept(slope1,midx1,midx2,slope2,midy1,midy2):
    m1 = -1/slope1
    m2 = -1/slope2
    intercept1 = midy1-(m1*midx1)
    intercept2 = midy2-(m2*midx2)
    return m1,m2,intercept1,intercept2
def intersectionBetweenLines(m1,intercept1,m2,intercept2):
    x = (intercept1-intercept2)/(m2-m1)
    y = (m1*x)+intercept1
    return x,y
def distance(x,y,x1,y1):
    d = math.sqrt((y1-y)**2+(x1-x)**2)
    return d
wn=turtle.Screen()
def drawCircle(turtle,x,y,d):
    turtle.penup()
    turtle.goto(x1,y1)
    turtle.dot()
    turtle.goto(x2,y2)
    turtle.dot()
    turtle.goto(x3,y3)
    turtle.dot()
    turtle.goto(x1,y1)
    turtle.pendown()
    turtle.circle(d)
def main():
    slope1,midx1,midy1,slope2,midx2,midy2=bisectorBetweenPoints(x1,y1,x2,y2,x3,y3)
    m1,m2,intercept1,intercept2=slopesIntercept(slope1,midx1,midx2,slope2,midy1,midy2)
    x,y=intersectionBetweenLines(slope1,intercept1,slope2,intercept2)
    d=distance(x,y,x1,y1)
    drawCircle(turtle,x,y,d)
    return slope1,midx1,midy1,slope2,midx2,midy2,m1,m2,intercept1,intercept2,x,y,d
main()
wn.exitonclick()
