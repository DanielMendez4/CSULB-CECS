#This program counts the frequencies of the letters a to z in a text file
#Prompts user to enter a number representing how many files will be inputted
str_n = input("How many files do you want to enter? (Enter a number): ")
n = int(str_n)
fileList = [] 
while len(fileList) in range(n):
    item = input("Enter a file name to add to the list: ")
    fileList.append(item)
print("This is your file list")
print(fileList)
with open("Outfile.txt", "w") as outfile:
    for fname in fileList:
        with open(fname) as infile:
            outfile.write(infile.read()) #Opens the newly written file in read mode            
outfile = open("Outfile.txt", "r")
complete = outfile.read()
Alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
letterList = []
for letter in range(len(Alphabet)):
    freq_letter = complete.count(Alphabet[letter])
    letterList.append(freq_letter)  #Calculates the frequencies of each letter
import turtle #Draws a bar graph showing the frequencies of each letter
def drawBar(t, height):
    t.begin_fill()
    t.left(90)
    t.forward(height) 
    t.write(" "+str(height)+" "+letter)
    t.right(90)
    t.forward(40) 
    t.right(90) 
    t.forward(height)
    t.left(90)
    t.end_fill()
xs = letterList
maxheight = max(xs)
numbars = len(xs)
border = 10
wn = turtle.Screen()
wn.setworldcoordinates(0-border, 0-border, 40*numbars+border, maxheight+border)
wn.bgcolor("white")
daniel = turtle.Turtle()
daniel.color("black")
daniel.fillcolor("red")
daniel.pensize(3)
daniel.speed(20)
for i in range(26):
    letter = chr(97+i)
    total = complete.count(letter)
    drawBar(daniel, total)  
wn.exitonclick()
