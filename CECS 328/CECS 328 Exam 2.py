
#Problem 1. ######################################z
def smallest_num_index(a):
    min = a[0]
    if min < a[len(a)-1] or len(a) == 1:
        return a.index(min)
    else:
        min = a[len(a)-1]
    for i in range(len(a)-2,-1,-1):
        if min > a[i]:
            min = a[i]
        elif min < a[i]:
            return a.index(min)

a1 = [2,5,8,10,12,0,1]
print(a1)
print("Index of smallest number: {}".format(smallest_num_index(a1)))

a2 = [1,6,9,10]
print(a2)
print("Index of smallest number: {}".format(smallest_num_index(a2)))

a3 = [20,30,40,1,5,10]
print(a3)
print("Index of smallest number: {}".format(smallest_num_index(a3)))
##################################################

#Problem 2. ######################################
def build_MaxHeap(a):
    for i in range(len(a)-1,-1,-1):
        max_heapify(a,len(a),i)
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
    a = build_MaxHeap(a)
    n = len(a)
    for i in range(n-1,0,-1):
        a[0], a[i] = a[i], a[0]
        max_heapify(a,i,0)
    return a

def merge_array_sort(matrix):
    a = []
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            a.append(matrix[i][j])
    return heap_sort(a)

matrix = [[8,4,2,0],[20,15,5,3],[10,7,6,1]]
print(merge_array_sort(matrix))
##################################################
