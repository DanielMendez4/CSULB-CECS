import turtle
import string
#afile = open(input("Please input the name of your file"), "r")
done = "no"
while done != "y" and done != "Y":
    afile = open(input("Please input the name of your file: "), "r")
    done = input("Are you done? Y or N:")
    incomplete = afile.read()
    read = ' '
    read = incomplete + read
    print(read)

read = read.lower() # This allows to sum both the upper and lower case letters

def drawBar(t, height):
    t.begin_fill()
    t.left(90) # turn left 90 degree
    t.forward(height) # move forward for a distance = height
    t.write(" " + str(height)+ " " + letter) # write height & letter
    t.right(90) # turn right 90 degree
    t.forward(40) # move forward for a distance = 40
    t.right(90) # turn right 90 degree
    t.forward(height) # move forward for a distance = height
    t.left(90)
    t.end_fill()
    
wn = turtle.Screen()
border = 10
wn.setworldcoordinates(0-border, 0-border, 40*26+border, 100+border)
wn.bgcolor("white")
tess = turtle.Turtle() # create tess and set some attributes
tess.color("black")
tess.fillcolor("pink")

for i in range(26):
    letter = chr(97+i)
    total = read.count(letter)
    drawBar(tess,total)
wn.exitonclick()
