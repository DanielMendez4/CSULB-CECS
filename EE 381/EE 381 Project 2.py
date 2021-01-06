import numpy as np

def nSidedDie(p):
    n = p.size
    cs = np.cumsum(p)
    cp = np.append(0, cs)
    r = np.random.rand()
    for i in range(0, n):
        if r > cp[i] and r <= cp[i+1]:
            return i + 1

# p0 = 0.35   p1 = 0.65   e0 = 0.04   e1 = 0.07
N = 100000
p = np.array([0.35, 0.65])  # p0, p1
e0 = np.array([0.96, 0.04]) # e0
e1 = np.array([0.07, 0.93]) # e1

#1. Probability of erroneous transmission ##########################################################
errors1 = 0
for i in range(0, N):
    S = nSidedDie(p) - 1
    if S == 1:
        R = nSidedDie(e1) - 1
    if S == 0:
        R = nSidedDie(e0) - 1
    if R != S:
        errors1 += 1

errorProb = errors1 / N
print("Probability of transmission error: " + str(errorProb))

#2. Conditional probability: P(R = 1 | S = 1) ######################################################
success1 = 0
condition1 = 0
for i in range(0, N):
    S = nSidedDie(p) - 1
    if S == 1:
        R = nSidedDie(e1) - 1
        condition1 += 1
    if R == 1 and S == 1:
        success1 += 1
        
condProb1 = success1 / condition1
print("Conditional probability P(R = 1 | S = 1): " + str(condProb1))

#3. Conditional probability: P(S = 1 | R = 1) ######################################################
success2 = 0
condition2 = 0
for i in range(0, N):
    S = nSidedDie(p) - 1
    if S == 1:
        R = nSidedDie(e1) - 1
        if R == 1:
            condition2 += 1
    if S == 0:
        R = nSidedDie(e0) - 1
        if R == 1:
            condition2 += 1
    if S == 1 and R == 1:
        success2 += 1
    
condProb2 = success2 / condition2
print("Conditional probability P(S = 1 | R = 1): " + str(condProb2))

#4. Enhanced transmission method ###################################################################
success3 = 0
errors2 = 0
for i in range(0, N):
    S = nSidedDie(p) - 1
    if S == 1:
        R1 = nSidedDie(e1) - 1
        R2 = nSidedDie(e1) - 1
        R3 = nSidedDie(e1) - 1
        R = (R1, R2, R3)
        if R.count(1) >= 2:
            D = 1
        else:
            D = 0
    if S == 0:
        R1 = nSidedDie(e0) - 1
        R2 = nSidedDie(e0) - 1
        R3 = nSidedDie(e0) - 1
        R = (R1, R2, R3)
        if R.count(0) >= 2:
            D = 0
        else:
            D = 1
    if D != S:
        errors2 += 1
    else:
        success3 += 1

print("Number of successes: " + str(success3))
errorProb2 = errors2 / N
print("Probability of error with enhanced transmission: " + str(errorProb2))
