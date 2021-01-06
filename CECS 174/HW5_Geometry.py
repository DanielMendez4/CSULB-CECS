#This program will calculate the area of shapes in a dictionary.
#Authors: Daniel Mendez & John Patrick Salcedo
import math
def sphere(radius):
    return (4/3) * math.pi * math.pow(radius, 3)
def rectangle(width,length):
    return width * length
def prism(width,length,depth):
    return width * length * depth
def circle(radius):
    return math.pi * math.pow(radius, 2)
functions = {sphere: 1, rectangle: 2, prism: 3, circle: 1}
def geometry(functions,function,arguments):
    """This function will calculate the area of a given shape"""
    shape = function
    x = len(arguments)
    if x == 0:
        raise ValueError("Insufficeint arguments passed in!")
    elif x == functions[sphere] or x == functions[circle]: #Checks for 1 argument
        if shape == sphere: #Checks if function parameter is sphere
            ans = sphere(arguments[0])
        elif shape == circle: #Checks if function parameter is circle
            ans = circle(arguments[0])
    elif x == functions[rectangle]: #Checks for 2 arguments
        if shape == rectangle: #Checks if function parameter is rectangle
            ans = rectangle(arguments[0],arguments[1])
    elif x == functions[prism]: #Checks for 3 arguments
        if shape == prism: #Checks if function parameter is prism
            ans = prism(arguments[0],arguments[1],arguments[2])
    else:
         raise ValueError("Too many arguments!")
    return ans
names = {"sphere": sphere, "rectangle": rectangle, "prism": prism, "circle": circle}
def geometryString(names,functions,name,arguments):
    """This function will call geometry function with the proper arguments.
       Uses the parameter name instead, which is a text string, to assign a function"""
    function = name
    if function == "sphere":
        function = names["sphere"]
    elif function == "rectangle":
        function = names["rectangle"]
    elif function == "prism":
        function = names["prism"]
    elif function == "circle":
        function = names["circle"]
    return geometry(functions,function,arguments)
