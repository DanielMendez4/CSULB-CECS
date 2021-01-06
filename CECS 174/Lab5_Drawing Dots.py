#This program will draw dot on a screen upon left click
#Dot color will change upon keystroke of R,G,B,O,P,Y,b
#Authors: John Patrick Salcedo & Daniel Mendez
import turtle
import math
print("Press R for red\nPress G for green\nPress B for blue\nPress O for orange\nPress P for pink\nPress Y for yellow\nPress b for black")
global dotColor #Makes the dotColor variable global and allows for functions to access it
def listen(currentWindow, width, height):
    global dotColor
    """Set up the callback functions for a simple example of interactive graphics.
	Arguments:
	currentWindow:	The window that we are drawing on.
	width:		The width of the window.
	height:		The height of the window."""
    def drawDot(xPos, yPos):
        """Draw a dot at the given x and y position.  Make the dot the color specified in dotColor.
	Arguments:
	xPos:	The x position of the dot.
	yPos:	The y position of the dot."""
        global dotColor
        myTurtle.up()
        myTurtle.goto(xPos, yPos)
        myTurtle.down()
        myTurtle.dot(dotSize, dotColor)
        myTurtle.up()
        print ('dot planted at x coordinate: %f and y coordinate: %f' % (xPos, yPos))
    def gone():
        """Shut down the graphics window."""
        myWindow.bye()
        print("So long for now!")
    def red():
        global dotColor
        dotColor = "red"
    def green():
        global dotColor
        dotColor = "green"
    def blue():
        global dotColor
        dotColor = "blue"
    def orange():
        global dotColor
        dotColor = "orange"
    def pink():
        global dotColor
        dotColor = "pink"
    def yellow():
        global dotColor
        dotColor = "yellow"
    def black():
        global dotColor
        dotColor = "black"
    def cyan():
        global dotColor
        dotColor = "cyan"
    def purple():
        global dotColor
        dotColor = "purple"
        
    dotSize = 20
    global dotColor
    dotColor = "blue"
    myTurtle = turtle.Turtle()
    myTurtle.speed('fastest')

    currentWindow.onclick(drawDot)
    currentWindow.onkey(red, "R") #Change dot color to red
    currentWindow.onkey(green, "G") #Change dot color to green
    currentWindow.onkey(blue, "B") #Change dot color to blue
    currentWindow.onkey(orange, "O") #Change dot color to orange
    currentWindow.onkey(pink, "P") #Change dot color to pink
    currentWindow.onkey(yellow, "Y") #Change dot color to yellow
    currentWindow.onkey(black, "b") #Change dot color to black
    currentWindow.onkey(cyan, "C")
    currentWindow.onkey(purple, "p")
    currentWindow.onkey(gone, "q") #Exits the window
    currentWindow.title("Drawing Dots")
    currentWindow.setup (width, height, 0, 0)

myWindow = turtle.Screen()
screenWidth = 1000			# Default width of the screen
screenHeight = 1000			# Default height of the screen
listen(myWindow, screenWidth, screenHeight)
myWindow.listen()			# start listening for events
myWindow.mainloop()			# go into infinite loop waiting
