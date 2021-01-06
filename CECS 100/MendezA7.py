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
            outfile.write(infile.read())
#Opens the newly written file in read mode            
outfile = open("Outfile.txt", "r")
complete = outfile.read()

Alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
for letter in range(1):
    freq_a = complete.count(Alphabet[letter])
for letter in range(1,2):
    freq_b = complete.count(Alphabet[letter])
for letter in range(2,3):
    freq_c = complete.count(Alphabet[letter])
for letter in range(3,4):
    freq_d = complete.count(Alphabet[letter])
for letter in range(4,5):
    freq_e = complete.count(Alphabet[letter])
for letter in range(5,6):
    freq_f = complete.count(Alphabet[letter])
for letter in range(6,7):
    freq_g = complete.count(Alphabet[letter])
for letter in range(7,8):
    freq_h = complete.count(Alphabet[letter])
for letter in range(8,9):
    freq_i = complete.count(Alphabet[letter])
for letter in range(9,10):
    freq_j = complete.count(Alphabet[letter])
for letter in range(10,11):
    freq_k = complete.count(Alphabet[letter])
for letter in range(11,12):
    freq_l = complete.count(Alphabet[letter])
for letter in range(12,13):
    freq_m = complete.count(Alphabet[letter])
for letter in range(13,14):
    freq_n = complete.count(Alphabet[letter])
for letter in range(14,15):
    freq_o = complete.count(Alphabet[letter])
for letter in range(15,16):
    freq_p = complete.count(Alphabet[letter])
for letter in range(16,17):
    freq_q = complete.count(Alphabet[letter])
for letter in range(17,18):
    freq_r = complete.count(Alphabet[letter])
for letter in range(18,19):
    freq_s = complete.count(Alphabet[letter])
for letter in range(19,20):
    freq_t = complete.count(Alphabet[letter])
for letter in range(20,21):
    freq_u = complete.count(Alphabet[letter])
for letter in range(21,22):
    freq_v = complete.count(Alphabet[letter])
for letter in range(22,23):
    freq_w = complete.count(Alphabet[letter])
for letter in range(23,24):
    freq_x = complete.count(Alphabet[letter])
for letter in range(24,25):
    freq_y = complete.count(Alphabet[letter])
for letter in range(25,26):
    freq_z = complete.count(Alphabet[letter])
    #Prints the frequencies of each letter

import turtle
#Draws a bar graph showing the frequencies of each letter
def drawBar(t, height):
    t.begin_fill()
    t.left(90)
    t.forward(height) 
    t.write(" " + str(height) + " " + letter)
    t.right(90)
    t.forward(40) 
    t.right(90) 
    t.forward(height)
    t.left(90)
    t.end_fill()

xs = [freq_a, freq_b, freq_c, freq_d, freq_e, freq_f, freq_g, freq_h, freq_i, freq_j, freq_k, freq_l, freq_m, freq_n, freq_o, freq_p, freq_q, freq_r, freq_s, freq_t, freq_u, freq_v, freq_w, freq_x, freq_y, freq_z]
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

for i in range(26):
    letter = chr(97+i)
    total = complete.count(letter)
    drawBar(daniel, total)
    
wn.exitonclick()
