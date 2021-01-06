import math

def sqrt(n):
    low = 0
    mid = 0
    up = n
    while (low <= up):
        mid = math.ceil((low + up) / 2)
        if (mid * mid == n):
            break
        elif (mid * mid < n):
            low = mid + 1
        elif (mid * mid > n):
            up = mid - 1
    return mid

def small_num(a,m):
    low = 0
    up = m - 1
    while (low <= up):
        if (low == len(a)):
            return low
        if a[low] != low:
            return low
        low += 1
    return low

#Question 1. Implementing the square root function ########################

n = int(input("Enter an integer n: "))
print("Square root of n: {}".format(sqrt(n)))

###########################################################################

#Question 2. Find the smallest missing number #############################

a1 = [0,1,3,6,8,9]
m1 = 10

a2 = [2,5,7,11]
m2 = 15

a3 = [0,1,2,3,4]
m3 = 8

a4 = [12]
m4 = 13

print("Input: a = {}, m = {}\nOutput: {}".format(a1,m1,small_num(a1,m1)))
print("Input: a = {}, m = {}\nOutput: {}".format(a2,m2,small_num(a2,m2)))
print("Input: a = {}, m = {}\nOutput: {}".format(a3,m3,small_num(a3,m3)))
print("Input: a = {}, m = {}\nOutput: {}".format(a4,m4,small_num(a4,m4)))

###########################################################################
