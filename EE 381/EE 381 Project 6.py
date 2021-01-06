import numpy as np
import matplotlib.pyplot as plt
import math
import random

def newState(P):
    n = P.size
    cs = np.cumsum(P)
    cp = np.append(0, cs)
    r = np.random.rand()
    for i in range(0, n):
        if r <= cp[i + 1]:
            return i

def switchState(probVector):
    return newState(probVector)

def stateStep(state, P, n):
    stateArray = np.zeros((n,1))
    stateProb = state
    for i in range(0, n):
        newProb = switchState(stateProb)
        stateArray[i] = newProb
        stateProb = P[newProb]
    return stateArray

def P_to_n_power(u0, P, exponent):
    matrix = P
    for i in range(0, exponent - 1):
        matrix = np.dot(matrix, P)
    return np.dot(u0, matrix)

def drunkenStateSelect(initState):
    n = initState.size
    cs = np.cumsum(initState)
    cp = np.append(0, cs)
    r = np.random.rand()
    for i in range(0, n):
        prob = initState[i]
        if prob == 0:
            continue
        if r <= cp[i + 1]:
            return i

def currentState(state):
    x = 0
    if state == 0:
        x = 1
    if state == 1:
        x = 2
    if state == 2:
        x = 3
    if state == 3:
        x = 0
    if state == 4:
        x = 4
    return x

n = 15
N = 10000

#1. A three-state Markov Chain #####################################################################

                      #R     N     S
weatherP = np.array([ [0.33, 0.33, 0.34],   #R
                      [0.33, 0.17, 0.50],   #N
                      [0.40, 0.20, 0.40] ]) #S

probVector = np.array([0.24999, 0.00001, 0.75])

simulationArray = np.zeros((15,3))
rain = 0
nice = 0
snow = 0

for i in range(0, N):
    simulation = stateStep(probVector, weatherP, n)
    state = 0
    for i in simulation:
        if i == 0.0:
            simulationArray[state][0] += 1
        if i == 1.0:
            simulationArray[state][1] += 1
        if i == 2.0:
            simulationArray[state][2] += 1
        state += 1

    finalState = simulation[14][0]
    if finalState == 0.0:
        rain += 1
    if finalState == 1.0:
        nice += 1
    if finalState == 2.0:
        snow += 1

simulationArray = simulationArray / N

print("Experimental Count of End State")
print("Rain: " + str(rain))
print("Nice: " + str(nice))
print("Snow: " + str(snow))
print("Experimental Probability of  End State")
print("Rain: " + str(rain / N))
print("Nice: " + str(nice / N))
print("Snow: " + str(snow / N))
print(simulationArray)

print(P_to_n_power(probVector, weatherP, n))

pass1 = stateStep(probVector, weatherP, n)

plt.figure(1)
x1 = list(range(0,n))
plt.plot(x1,pass1,'*:',label = 'Current State')
plt.xticks(x1)
plt.yticks([0,1,2])
plt.title('Single Simulation of 3-State Markov Chain')
plt.xlabel('Steps Taken')
plt.ylabel('State')
plt.legend(loc = 'best')
plt.show()

probA = simulationArray[:,0]
probB = simulationArray[:,1]
probC = simulationArray[:,2]

plt.figure(1)
x1 = list(range(0,n))
plt.plot(x1,probA,'*:',label = 'Rain')
plt.plot(x1,probB,'o:',label = 'Nice')
plt.plot(x1,probC,'v:',label = 'Snow')
plt.xticks(x1)
plt.title('Experimental State Transistion Markov Chain')
plt.xlabel('Step Count')
plt.ylabel('Probability')
plt.legend(loc = 'best')
plt.show()

arrayPlot = weatherP
initCondition = probVector
stateNum = 3

W = np.array([ [0.0 for i in range(0,stateNum)] for j in range(0,n)])
W[0,:] = initCondition

for k in range(1, n):
    W[k,:] = np.dot(W[k-1,:],arrayPlot)

probA = W[:,0]
probB = W[:,1]
probC = W[:,2]

plt.figure(1)
x1 = list(range(0,n))
plt.plot(x1,probA,'*:',label = 'Rain')
plt.plot(x1,probB,'o:',label = 'Nice')
plt.plot(x1,probC,'v:',label = 'Snow')
plt.xticks(x1)
plt.title('Calculated State Transition Markov Chain')
plt.xlabel('Step Count')
plt.ylabel('Probability')
plt.legend(loc = 'best')
plt.show()

#2. The Google PageRank Algorithm ##################################################################

                     #A     B     C     D     E
pageP = np.array([   [0.00, 1.00, 0.00, 0.00, 0.00],   #A
                     [0.50, 0.00, 0.50, 0.00, 0.00],   #B
                     [0.33, 0.33, 0.00, 0.00, 0.33],   #C
                     [1.00, 0.00, 0.00, 0.00, 0.00],   #D
                     [0.00, 0.33, 0.33, 0.33, 0.00]])  #E

v1 = np.array([[0.20, 0.20, 0.20, 0.20, 0.20]])
v2 = np.array([[0.00, 0.00, 0.00, 0.00, 1.00]])
n1 = 20

sim1 = []
sim1.append([0.20, 0.20, 0.20, 0.20, 0.20])
for n in range(0, n1):
    sim1.append(P_to_n_power(v1, pageP, n)[0])
print(sim1)
sim1Array = np.array(sim1)

probA = sim1Array[:,0]
probB = sim1Array[:,1]
probC = sim1Array[:,2]
probD = sim1Array[:,3]
probE = sim1Array[:,4]

plt.figure(1)
x1 = list(range(0, n1 + 1))
plt.plot(x1,probA,'*:',label = 'Page A')
plt.plot(x1,probB,'o:',label = 'Page B')
plt.plot(x1,probC,'v:',label = 'Page C')
plt.plot(x1,probD,'*:',label = 'Page D')
plt.plot(x1,probE,'o:',label = 'Page E')
plt.xticks(x1)
plt.title('Page Rank Probability from v1')
plt.xlabel('Step Count')
plt.ylabel('Probability')
plt.legend(loc = 'best')
plt.show()

#--------------------------------------------------------------------------
sim2 = []
sim2.append([0.00, 0.00, 0.00, 0.00, 1.00])
for n in range(0, n1):
    sim2.append(P_to_n_power(v2, pageP, n)[0])
print(sim2)
sim2Array = np.array(sim2)

probA = sim2Array[:,0]
probB = sim2Array[:,1]
probC = sim2Array[:,2]
probD = sim2Array[:,3]
probE = sim2Array[:,4]

plt.figure(1)
x1 = list(range(0, n1 + 1))
plt.plot(x1,probA,'*:',label = 'Page A')
plt.plot(x1,probB,'o:',label = 'Page B')
plt.plot(x1,probC,'v:',label = 'Page C')
plt.plot(x1,probD,'*:',label = 'Page D')
plt.plot(x1,probE,'o:',label = 'Page E')
plt.xticks(x1)
plt.title('Page Rank Probability from v2')
plt.xlabel('Step Count')
plt.ylabel('Probability')
plt.legend(loc = 'best')
plt.show()

#3. Simulate a five-state absorbing Markov Chain ###################################################

                      #1     2     3     0     4
drunkenP = np.array([ [0.00, 0.33, 0.00, 0.66, 0.00],   #1
                      [0.60, 0.00, 0.40, 0.00, 0.00],   #2
                      [0.00, 0.30, 0.00, 0.00, 0.70],   #3
                      [0.00, 0.00, 0.00, 1.00, 0.00],   #0
                      [0.00, 0.00, 0.00, 0.00, 1.00] ]) #4

r = random.randint(0,2)
stateProb = drunkenP[r]

states = []

for i in range(0,n):
    nextState = drunkenStateSelect(stateProb)
    print("Current State: " + str(currentState(nextState)))
    states.append(currentState(nextState))
    stateProb = drunkenP[nextState]

plt.figure(1)
x1 = list(range(1, n + 1))
plt.plot(x1,states,'.--')
plt.xticks(x1)
plt.yticks([0,1,2,3,4])
plt.title('5-State Absorbing Markov Chain')
plt.xlabel('Step Count')
plt.ylabel('State')
plt.show()

#4. Compute the probability of absorption using the simulated chain ################################

                      #1     2     3     0     4
drunkenP = np.array([ [0.00, 0.34, 0.00, 0.66, 0.00],   #1
                      [0.60, 0.00, 0.40, 0.00, 0.00],   #2
                      [0.00, 0.30, 0.00, 0.00, 0.70],   #3
                      [0.00, 0.00, 0.00, 1.00, 0.00],   #0
                      [0.00, 0.00, 0.00, 0.00, 1.00] ]) #4

initialProb = np.array([[0.00, 0.00, 1.00, 0.00, 0.00]])

initialState = initialProb[0]
simulation = 0
for i in range(0, N):
    stateProb = initialState
    while True:
        nextState = drunkenStateSelect(stateProb)
        stateProb = drunkenP[nextState]
        if (nextState == 3) or (nextState == 4):
            if nextState == 3:
                simulation += 1
            break

stateZeroAbsorbProb = simulation / N
stateFourAbsorbProb = (N - simulation) / N

print(stateZeroAbsorbProb)
print(stateFourAbsorbProb)
