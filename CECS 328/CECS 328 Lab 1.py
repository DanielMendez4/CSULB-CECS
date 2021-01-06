import random
import time
import math

def linearSearch(a,key):
    for i in range(len(a)):
        if (a[i] == key): #Key was found in the array
            return True
    return False

def binarySearch(a,key):
    low = 0
    mid = 0
    up = len(a) - 1
    while (low <= up):
        mid = (low + up) // 2
        if a[mid] == key: #Key was found in the array
            return True
        elif a[mid] < key: #Set new 'low' bound
            low = mid + 1
        elif a[mid] > key: #Set new 'up' bound
            up = mid - 1
    return False

#Part A. Average-Case Running Time ###############
print("--- Average-Case Running Time ---")
n = input("Enter a positive integer: ")

a = []
for i in range(int(n)):
    num = random.randint(-1000,1000)
    a.append(num)

a.sort()
avg_linear = 0
avg_binary = 0
trials = 100

for i in range(trials):
    key = random.choice(a)

    start_time = time.perf_counter()
    linearSearch(a,key)
    avg_linear = avg_linear + (time.perf_counter() - start_time)

    start_time = time.perf_counter()
    binarySearch(a,key)
    avg_binary = avg_binary + (time.perf_counter() - start_time)

print("Average runtime for linear search in 100 trials: %s sec" % (avg_linear / trials))
print("Average runtime for binary search in 100 trials: %s sec" % (avg_binary / trials))
##################################################

#Part B. Worst-Case Running Time #################
print("--- Worst-Case Running Time ---")
n = input("Enter a positive integer: ")

a = []
for i in range(int(n)):
    num = random.randint(-1000,1000)
    a.append(num)

a.sort()
worst_linear = 0
worst_binary = 0

key = 5000

start_time = time.perf_counter()
linearSearch(a,key)
worst_linear = time.perf_counter() - start_time
print("Worst runtime for linear search n = 100000: %s sec" %(worst_linear))

start_time = time.perf_counter()
binarySearch(a,key)
worst_binary = time.perf_counter() - start_time
print("Worst runtime for binary search n = 100000: %s sec" %(worst_binary))

one_line_linear = worst_linear / int(n)
one_line_binary = worst_binary / math.log2(int(n))
print("Runtime for a single line using binary search n = 100000: %s sec" %(one_line_binary))

n = math.pow(10,15)
print("Worst runtime for linear search n = 10^15: %s sec" %(one_line_linear * n))
print("Worst runtime for binary search n = 10^15: %s sec" %(one_line_binary * math.log2(n)))
##################################################
