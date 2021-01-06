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
            
outfile = open("Outfile.txt", "r")
complete = outfile.read()

Alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
for letter in range(1):
    freq_a = complete.count(Alphabet[letter])
    print("The frequency of a is:", freq_a)
for letter in range(1,2):
    freq_b = complete.count(Alphabet[letter])
    print("The frequency of b is:", freq_b)
for letter in range(2,3):
    freq_c = complete.count(Alphabet[letter])
    print("The frequency of c is:", freq_c)
for letter in range(3,4):
    freq_d = complete.count(Alphabet[letter])
    print("The frequency of d is:", freq_d)
for letter in range(4,5):
    freq_e = complete.count(Alphabet[letter])
    print("The frequency of e is:", freq_e)
for letter in range(5,6):
    freq_f = complete.count(Alphabet[letter])
    print("The frequency of f is:", freq_f)
for letter in range(6,7):
    freq_g = complete.count(Alphabet[letter])
    print("The frequency of g is:", freq_g)
for letter in range(7,8):
    freq_h = complete.count(Alphabet[letter])
    print("The frequency of h is:", freq_h)
for letter in range(8,9):
    freq_i = complete.count(Alphabet[letter])
    print("The frequency of i is:", freq_i)
for letter in range(9,10):
    freq_j = complete.count(Alphabet[letter])
    print("The frequency of j is:", freq_j)
for letter in range(10,11):
    freq_k = complete.count(Alphabet[letter])
    print("The frequency of k is:", freq_k)
for letter in range(11,12):
    freq_l = complete.count(Alphabet[letter])
    print("The frequency of l is:", freq_l)
for letter in range(12,13):
    freq_m = complete.count(Alphabet[letter])
    print("The frequency of m is:", freq_m)
for letter in range(13,14):
    freq_n = complete.count(Alphabet[letter])
    print("The frequency of n is:", freq_n)
for letter in range(14,15):
    freq_o = complete.count(Alphabet[letter])
    print("The frequency of o is:", freq_o)
for letter in range(15,16):
    freq_p = complete.count(Alphabet[letter])
    print("The frequency of p is:", freq_p)
for letter in range(16,17):
    freq_q = complete.count(Alphabet[letter])
    print("The frequency of q is:", freq_q)
for letter in range(17,18):
    freq_r = complete.count(Alphabet[letter])
    print("The frequency of r is:", freq_r)
for letter in range(18,19):
    freq_s = complete.count(Alphabet[letter])
    print("The frequency of s is:", freq_s)
for letter in range(19,20):
    freq_t = complete.count(Alphabet[letter])
    print("The frequency of t is:", freq_t)
for letter in range(20,21):
    freq_u = complete.count(Alphabet[letter])
    print("The frequency of u is:", freq_u)
for letter in range(21,22):
    freq_v = complete.count(Alphabet[letter])
    print("The frequency of v is:", freq_v)
for letter in range(22,23):
    freq_w = complete.count(Alphabet[letter])
    print("The frequency of w is:", freq_w)
for letter in range(23,24):
    freq_x = complete.count(Alphabet[letter])
    print("The frequency of x is:", freq_x)
for letter in range(24,25):
    freq_y = complete.count(Alphabet[letter])
    print("The frequency of y is:", freq_y)
for letter in range(25,26):
    freq_z = complete.count(Alphabet[letter])
    print("The frequency of z is:", freq_z)

import turtle

def drawBar(t, height):
    t.begin_fill()
    t.left(90)
    t.forward(height) 
    t.write("  "+str(height)) 
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

for i in xs:
    drawBar(daniel, i)
    
wn.exitonclick()

