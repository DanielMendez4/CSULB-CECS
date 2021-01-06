import random

#Returns a partitioned array and the index of the pivot as a tuple
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

def max_select(a,k):
    result = []
    if (len(a) == k) or (len(a) < k):
        for i in range(len(a)):
            x = max(a)
            result.append(a.pop(a.index(x)))
    if len(a) > k:
        while k != 0:
            x = max(a)
            result.append(a.pop(a.index(x)))
            k -= 1
    return result

#Part A. Quick Select to find kth least element ###########################
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
print("The kth least element (k = {}) is: {} \n".format(k, quick_select(a,k)))
###########################################################################

#Part B. Return max k numbers from unsorted array #########################
a = [4,2,0,10,1,6]
k = 3

print("Original unsorted array: [{}]".format(", ".join(map(str,a))))
print("Max k number(s) (k = {}): [{}]".format(k, " ".join(map(str,max_select(a,k)))))
###########################################################################
