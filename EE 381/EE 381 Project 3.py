import numpy as np
import matplotlib.pyplot as plt
import math

def nSidedDie(p):
    n = p.size
    cs = np.cumsum(p)
    cp = np.append(0, cs)
    r = np.random.rand()
    for i in range(0, n):
        if r > cp[i] and r <= cp[i+1]:
            return i + 1

N = 10000
n = 1000
f = math.factorial
p = np.array([0.1, 0.1, 0.1, 0.3, 0.2, 0.2])

#1. Experimental Bernoulli Trials
X = np.zeros((N,1))
for i in range(0, N):
    success = 0
    for j in range(0, n):
        d1 = nSidedDie(p)
        d2 = nSidedDie(p)
        d3 = nSidedDie(p)
        if (d1 == 1) and (d2 == 2) and (d3 == 3):
            success += 1
    X[i] = success

b = range(0, 18 + 2)
sb = np.size(b)
h1, bin_edges = np.histogram(X, bins = b)
b1 = bin_edges[0:sb-1]
plt.close('all')
prob = h1 / N

plt.stem(b1, prob)
plt.title("Bernoulli Trials: PMF - Experimental Results", fontsize = 14, fontweight = 'bold')
plt.xlabel("Number of successes in n = 1000 trials", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)
plt.xticks(b1)
plt.show()

#2. Calculations using the Binomial Distribution
X1 = np.zeros((N,1))
pSuccess = .001
qFail = 1 - pSuccess
for i in range(0, N):
    x = 0
    for j in range(0, n):
        d1 = nSidedDie(p)
        d2 = nSidedDie(p)
        d3 = nSidedDie(p)
        if (d1 == 1) and (d2 == 2) and (d3 == 3):
            x += 1

    X1[i] = (f(n) // f(x) // f(n - x)) * (math.pow(pSuccess, x)) * (math.pow(qFail, n - x))

xAxis = []
for i in range(19):
    xAxis.append(i)

yAxis = []
y = np.flip(np.unique(X1))
for i in range(y.size):
    yAxis.append(y[i])
for i in range(19 - len(yAxis)):
    yAxis.append(0)

plt.close('all')
plt.stem(xAxis, yAxis)
plt.title("Bernoulli Trials: PMF - Binomial Formula", fontsize = 14, fontweight = 'bold')
plt.xlabel("Number of successes in n = 1000 trials", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)
plt.xticks(np.arange(0, 19, 1))
plt.show()

#3. Approximation of Binomial by Poisson Distribution
X2 = np.zeros((N,1))
pSuccess = .001
for i in range(0, N):
    x = 0
    for j in range(0, n):
        d1 = nSidedDie(p)
        d2 = nSidedDie(p)
        d3 = nSidedDie(p)
        if (d1 == 1) and (d2 == 2) and (d3 == 3):
            x += 1
    
    X2[i] = ((math.pow(n * pSuccess, x)) * (math.exp(-(n * pSuccess)))) / f(x)

xAxis = []
for i in range(19):
    xAxis.append(i)
    
yAxis = []
y = np.flip(np.unique(X2))
for i in range(y.size):
    yAxis.append(y[i])
for i in range(19 - len(yAxis)):
    yAxis.append(0)
    
plt.close('all')
plt.stem(xAxis, yAxis)
plt.title("Bernoulli Trials: PMF - Poisson Approximation", fontsize = 14, fontweight = 'bold')
plt.xlabel("Number of successes in n = 1000 trials", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)
plt.xticks(np.arange(0, 19, 1))
plt.show()
