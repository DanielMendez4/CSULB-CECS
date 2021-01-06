import turtle
import math
global dotColor
colorList = ["red","green","blue","orange","pink","yellow","black"]
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
    def whichColor(x, y):
        if x >= boxes[0][0] and x <= boxes[0][0]+boxes[0][2] and y <= boxes[0][1] and y >= boxes[len(boxes)-1][1]-boxes[0][3]:
            for box in boxes:
                if x >= box[0] and x <= box[0]+box[2] and y <= box[1] and y >= box[1]-box[3]:
                    global dotColor
                    dotColor = box[4]
        else:
            drawDot(x, y)
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
    def gone():
        """Shut down the graphics window."""
        myWindow.bye()
        print("So long for now!")
        
    dotSize = 20
    dotColor = 'blue'
    myTurtle = turtle.Turtle()
    myTurtle.speed('fastest')
    x = 425
    y = 450
    for color in colorList:
        drawBox(myTurtle,color,x,y)
        y = y - 50
    
    boxes = [(425,450,75,50,"red"),(425,400,75,50,"green"),(425,350,75,50,"blue"),(425,300,75,50,"orange"),(425,250,75,50,"pink"),(425,200,75,50,"yellow"),(425,150,75,50,"black")]

    currentWindow.onclick(whichColor)
    currentWindow.onkey(gone, 'q')
    currentWindow.title("Drawing Dots")
    currentWindow.setup (width, height, 0, 0)

myWindow = turtle.Screen()
screenWidth = 1000			# Default width of the screen
screenHeight = 1000			# Default height of the screen
listen(myWindow, screenWidth, screenHeight)
myWindow.listen()			# start listening for events
myWindow.mainloop()			# go into infinite loop waiting
