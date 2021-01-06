import random
import time

def build_MaxHeap(a,n):
    for i in range(n-1,-1,-1):
        max_heapify(a,n,i)
    return a

def max_heapify(a,n,i):
    largest = i
    left = 2*i + 1
    right = 2*i + 2
    if (left < n) and (a[left] > a[largest]):
        largest = left
    if (right < n) and (a[right] > a[largest]):
        largest = right
    if largest != i:
        a[i], a[largest] = a[largest], a[i]
        max_heapify(a,n,largest)

def heap_sort(a):
    n = len(a)
    a = build_MaxHeap(a,n)
    for i in range(n-1,0,-1):
        a[0], a[i] = a[i], a[0]
        max_heapify(a,i,0)
    return a

def selection_sort(a):
    for i in range(len(a)):
        minimum = i
        for j in range(i+1, len(a)):
            if a[minimum] > a[j]:
                minimum = j
        a[i], a[minimum] = a[minimum], a[i]
    return a

#Part A. Average-Case Running Time ########################################
n = int(input("Enter a positive integer n: "))
avg_heap = 0
avg_selection = 0
trials = 100

for i in range(trials):
    a = []
    for i in range(n):
        num = random.randint(-100,100)
        a.append(num)
    
    start_time = time.perf_counter()
    heap_sort(a)
    avg_heap = avg_heap + (time.perf_counter() - start_time)

    start_time = time.perf_counter()
    selection_sort(a)
    avg_selection = avg_selection + (time.perf_counter() - start_time)

print("Average runtime for heap_sort in {} trials: {} sec.".format(trials, avg_heap / trials))
print("Average runtime for selection_sort in {} trials: {} sec.".format(trials, avg_selection / trials))
###########################################################################

#Part B. Print Heap Sort ##################################################
a = []
for i in range(10):
    num = random.randint(-100,100)
    a.append(num)

print(heap_sort(a))
###########################################################################
