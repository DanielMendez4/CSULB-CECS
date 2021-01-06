candFile = open("Candidates.txt", "r")
numCandidates = int(candFile.readline())
print("Number of candidates =", numCandidates)

candidates = [ [], [] ]
for aLine in candFile:
    nameLine = aLine.split()
    if int(nameLine[0]) == 1:
        candidates[0] = candidates[0] + [nameLine[1]]
    else:
        candidates[1] = candidates[1] + [nameLine[1]]
votes = [ [0]*len(candidates[0]), [0]*len(candidates[1]) ]
print("Number of candidates in district 1:", len(candidates[0]))
print(candidates[0])
print("Number of candidates in district 2:", len(candidates[1]))
print(candidates[1])
candList = candidates[0] + candidates[1]

ballots = open("Ballots.txt", "r")
tally = ballots.read()
#Calculates the number of votes each candidate received in their respective districts
for candidate1 in range(len(candidates[0])):    #Number of votes for candidates in District 1
   freq_cand = tally.count(candidates[0][candidate1])
   votes[0][candidate1] += freq_cand
for candidate2 in range(len(candidates[1])):    #Number of votes for candidates in District 2
   freq_cand = tally.count(candidates[1][candidate2])
   votes[1][candidate2] += freq_cand
print(votes)
#Calculates the percentage of votes each candidate received in their respective districts
percentList = [ [0]*len(candidates[0]), [0]*len(candidates[1]) ]
sum_vote1 = sum(votes[0])
for percent1 in range(len(candidates[0])):  #Percentage for candidates in District 1
    percent = round(votes[0][percent1]/sum_vote1*100, 0)
    percentList[0][percent1] += percent
sum_vote2 = sum(votes[1])
for percent2 in range(len(candidates[1])):  #Percentage for candidates in District 2
    percent = round(votes[1][percent2]/sum_vote2*100, 0)
    percentList[1][percent2] += percent
print(percentList)

import turtle
def drawBar(t, height, name):
    t.begin_fill()
    t.left(90)
    t.forward(height) 
    t.write("   "+name+" "+str(height)+"%")
    t.right(90)
    t.forward(20)
    t.right(90) 
    t.forward(height)
    t.left(90)
    t.end_fill()
maxheight = 100
numbars = len(votes)
border = 10
wn = turtle.Screen()
wn.setworldcoordinates(0-border, 0-border, 55*numbars+border, maxheight+border)
wn.bgcolor("white")
daniel = turtle.Turtle()
daniel.color("black")
daniel.fillcolor("red")
daniel.pensize(3)
daniel.speed(20)

for i in range(len(candidates[0])): #Draws a bar graph for candidates in District 1
    graph_percent = percentList[0][i]
    drawBar(daniel, graph_percent, candidates[0][i])
daniel.penup()
daniel.forward(10)  #Leaves a space for two seperate bar graphs representing each District
daniel.pendown()
for j in range(len(candidates[1])): #Draws a bar graph for candidates in District 2
    graph_percent = percentList[1][j]
    drawBar(daniel, graph_percent, candidates[1][j])
    
wn.exitonclick()
