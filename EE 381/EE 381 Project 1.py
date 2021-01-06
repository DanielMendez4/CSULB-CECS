import numpy as np
import matplotlib.pyplot as plt

#1. Function for n-sided die #########################################
def nSidedDie(p):
    n = p.size
    cs = np.cumsum(p)
    cp = np.append(0, cs)
    r = np.random.rand()
    for i in range(0, n):
        if r > cp[i] and r <= cp[i+1]:
            return i + 1

N = 10000
s = np.zeros((N,1))
p = np.array([0.10, 0.15, 0.20, 0.35, 0.20])
for i in range(0, N):
    r = nSidedDie(p)
    s[i] = r

b = range(1, p.size + 2)
sb = np.size(b)
h1, bin_edges = np.histogram(s, bins = b)
b1 = bin_edges[0:sb-1]
plt.close('all')
prob = h1 / N

plt.stem(b1, prob)
plt.title("PMF for n-sided die", fontsize = 14, fontweight = 'bold')
plt.xlabel("Number on the face of the die", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)
plt.xticks(b1)
plt.show()

#2. Number of rolls needed to get a "7" with two dice ################
def twoDieRoll():
    rollTotal = 0
    numRolls = 0
    while (rollTotal != 7):
        d1 = np.random.randint(1,7)
        d2 = np.random.randint(1,7)
        numRolls += 1
        rollTotal = d1 + d2
    return numRolls

N = 100000
s = np.zeros((N,1))
for i in range(0, N):
    r = twoDieRoll()
    s[i] = r

b = range(1, 30 + 2)
sb = np.size(b)
h1, bin_edges = np.histogram(s, bins = b)
b1 = bin_edges[0:sb-1]
plt.close('all')
prob = h1 / N

plt.stem(b1, prob)
plt.title("PMF for sum of two dice equal to 7", fontsize = 14, fontweight = 'bold')
plt.xlabel("Number of rolls", fontsize = 14)
plt.ylabel("Probability of sum equal to 7", fontsize = 14)
plt.xticks(b1)
plt.show()

#3. Probability of getting 50 heads when tossing 100 coins ###########
def coinToss():
    heads = 0
    success = False
    for i in range(0, 100):
        coin = np.random.randint(0,2)
        if coin == 1:
            heads += 1
    if heads == 50:
        success = True
    return success

N = 100000
success = 0
for i in range(0, N):
    if coinToss() == True:
        success += 1

prob = success / N
print("Probability of getting exactly 50 heads after tossing 100 coins in N experiments: " + str(prob))

#4. The Password Hacking Problem #####################################
N = 1000
n = 26 ** 4
m = 70000
k = 9
# Part 1
success1 = 0
for i in range(0, N):
    password = np.random.randint(0, n)
    H = np.random.randint(0, n, m)
    if password in H:
        success1 += 1

prob1 = success1 / N
print("Probability that the hacker is successful when m = 70000: " + str(prob1))
#Part 2
success2 = 0
new_m = k * m
for i in range(0, N):
    password = np.random.randint(0, n)
    H = np.random.randint(0, n, new_m)
    if password in H:
        success2 += 1

prob2 = success2 / N
print("Probability that the hacker is successful when k * m = 630000: " + str(prob2))
#Part 3
success3 = 0
final_m = 318500
for i in range(0, N):
    password = np.random.randint(0, n)
    H = np.random.randint(0, n, final_m)
    if password in H:
        success3 += 1

prob3 = success3 / N
print("Probability that the hacker is successful when m = 315000: " + str(prob3))
