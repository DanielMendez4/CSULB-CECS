import math
import random

def partition(a):
    pass

def quick_sort(a):
    pass
        
def MPSS(a):
    S_L = []
    S_R = []

    sum_L = 0
    for i in range(len(a[0:len(a)//2])-1, -1, -1):
        sum_L += a[0:len(a)//2][i]
        S_L.insert(0,sum_L)

    sum_R = 0
    for i in range(len(a[len(a)//2:])):
        sum_R += a[len(a)//2:][i]
        S_R.append(sum_R)

    S_L.sort()
    S_R.sort(reverse = True)
    
    i = 0
    j = 0
    s_min = math.inf

    while(i != len(S_L) and j != len(S_R)):
        s = S_L[i] + S_R[j]
        if s <= 0:
            i += 1
        elif s < s_min:
            s_min = s
            j += 1
        elif s > s_min:
            j += 1
            
    MPSS_mid = s_min
    return MPSS_mid

#Calculate MPSS ###########################################################
n = int(input("Enter a positive integer n: "))
a = []

for i in range(n):
    num = random.uniform(-20,20)
    a.append(num)

print(a)
print("MPSS of the above array is: {}".format(str(MPSS(a))))
###########################################################################
