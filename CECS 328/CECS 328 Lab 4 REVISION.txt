import random
import math

def partition(a):
    pivot = a[len(a)-1]
    partArr = []
    partArr.append(pivot)
    for i in range(len(a)-1):
        if a[i] <= pivot:
            partArr.insert(partArr.index(pivot), a[i])
        elif a[i] >= pivot:
            partArr.append(a[i])
    return (partArr,partArr.index(pivot))

def quick_select(a,k):
    result = partition(a)
    partArr = result[0]
    pivIndex = result[1]
    if (k == pivIndex + 1) or (len(partArr) == 1):
        return partArr[pivIndex]
    if k < pivIndex + 1:
        return quick_select(partArr[0:pivIndex],k)
    if k > pivIndex + 1:
        return quick_select(partArr[pivIndex+1:],k-(pivIndex+1))

def median_select(a,k):
    result = []
    median = quick_select(a, math.ceil(len(a) / 2))
    
    diff = []
    binArr = []
    for i in range(len(a)):
        num = a[i] - median
        diff.append(abs(num))
        if num < 0: binArr.append(1)
        else: binArr.append(0)
        
    while k != 0:
        x = min(diff)
        if binArr[diff.index(x)] == 1:
            binArr.pop(diff.index(x))
            result.append(-diff.pop(diff.index(x)) + median)
        else:
            binArr.pop(diff.index(x))
            result.append(diff.pop(diff.index(x)) + median)
        k -= 1
        
    result.pop(0)
    return result

#1. K elements closest to the median ######################################
n = int(input("Enter a positive integer n: "))
a = []

for i in range(n):
    num = random.randint(-100,100)
    while True:
        if num in a:
            num = random.randint(-100,100)
        else:
            break
    a.append(num)
    
print(a)
k = int(input("Enter a number between 1 to n: "))
print("The k closest numbers to the median (k = {}): {}".format(k, ", ".join(map(str,median_select(a,k+1)))))

"""
Time complexity
Finding the median:                             O(n)
Finding the diff:                               O(n)
Shifting k numbers back to original value:      O(n)
T(n) = O(n) + O(n) + O(n) --> O(n)
"""
###########################################################################
