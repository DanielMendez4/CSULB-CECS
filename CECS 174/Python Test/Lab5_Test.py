# Example code for lecture on event handlers for Turtle Graphics
import turtle
import math
print("Press R for red\nPress G for green\nPress B for blue\nPress O for orange\nPress P for pink\nPress Y for yellow\nPress b for black")
global dotColor
def listen(currentWindow, width, height):
    global dotColor
    """Set up the callback functions for a simple example of interactive graphics.
	Arguments:
	currentWindow:	The window that we are drawing on.
	width:		The width of the window.
	height:		The height of the window."""
    def drawDot(xPos, yPos):
        """Draw a dot at the given x and y position.  Make the dot the color
specified in dotColor.
	Arguments:
	xPos:	The x position of the dot.
	yPos:	The y position of the dot.
	"""
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
        
    dotSize = 20
    global dotColor
    dotColor = "blue"
    myTurtle = turtle.Turtle()
    myTurtle.speed('fastest')

    currentWindow.onclick(drawDot)
    currentWindow.onkey(red, "R")
    currentWindow.onkey(green, "G")
    currentWindow.onkey(blue, "B")
    currentWindow.onkey(orange, "O")
    currentWindow.onkey(pink, "P")
    currentWindow.onkey(yellow, "Y")
    currentWindow.onkey(black, "b")
    currentWindow.onkey(gone, "q")
    currentWindow.title("Drawing Dots")
    currentWindow.setup (width, height, 0, 0)

myWindow = turtle.Screen()
screenWidth = 1000			# Default width of the screen
screenHeight = 1000			# Default height of the screen
listen(myWindow, screenWidth, screenHeight)
myWindow.listen()			# start listening for events
myWindow.mainloop()			# go into infinite loop waiting
