candFile = open("Candidates.txt", "r")
numCandidates = int(candFile.readline())
print("Number of candidates = ", numCandidates)

candidates = [ [], [] ]
for aLine in candFile:
    nameLine = aLine.split()
    if int(nameLine[0]) == 1:
        candidates[0] = candidates[0] + [nameLine[1]]
    else:
        candidates[1] = candidates[1] + [nameLine[1]]
print("Number of candidates in district 1: ", len(candidates[0]))
print(candidates[0])
print("Number of candidates in district 2: ", len(candidates[1]))
print(candidates[1])
candList = candidates[0] + candidates[1]

ballots = open("Ballots.txt", "r")
tally = ballots.read()

voteList = []
for candidate in range(len(candList)):
    freq_cand = tally.count(candList[candidate])
    voteList.append(freq_cand)

sum_vote = sum(voteList)
percentList = []
for percent in range(len(voteList)):
    calculate_percent = tally.count(candList[percent])/sum_vote*100
    percentList.append(int("{:.0f}".format(calculate_percent)))
                       
import turtle
def drawBar(t, height):
    t.begin_fill()
    t.left(90)
    t.forward(height) 
    t.write(" "+str(height)+"%")
    t.right(90)
    t.forward(40)
    t.right(90) 
    t.forward(height)
    t.left(90)
    t.end_fill()
xs = percentList
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

for i in xs:
    drawBar(daniel, i)
    
wn.exitonclick()
