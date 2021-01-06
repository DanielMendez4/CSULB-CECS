graph = {
'a':['c', 'd'],
'b':['c', 'e'],
'c':['a', 'b', 'd'],
'd':['c', 'e', 'f'],
'e':['b', 'd', 'f'],
'f':['d', 'e', 'h'],
'g':[],
'h':['f']
}

class Vertex:
    def __init__(self,cost,parent,hasParent,adj):
        self.cost = cost
        self.parent = parent
        self.hasParent = hasParent
        self.adj = adj

    def printAdj(self):
        print(", ".join(map(str,self.adj)))

a = Vertex(0,None,False,None)
b = Vertex(0,None,False,None)
c = Vertex(0,None,False,None)
d = Vertex(0,None,False,None)
e = Vertex(0,None,False,None)
f = Vertex(0,None,False,None)
g = Vertex(0,None,False,None)
h = Vertex(0,None,False,None)

a.adj = [c,d]
b.adj = [c,e]
c.adj = [a,b,d]
d.adj = [c,e,f]
e.adj = [b,d,f]
f.adj = [d,e,h]
g.adj = []
h.adj = [f]

"""
fifo = []

def BFS(v):
    v.cost = 0
    v.parent = v
    fifo.append(v)
    while not fifo:
        temp = fifo.pop(0)
        print(temp.cost)
        for a in temp.adj:
            if a.hasParent == False:
                a.parent = temp
                a.hasParent = True
                a.cost = temp.cost + 1
                fifo.append(a)
        print(temp.cost)

BFS(a)
"""

adjList = []
for i in range(len(graph)):
    temp = []
    neighbors = graph[chr(97+i)]
    for j in range(len(graph)):
        if chr(97+j) in neighbors:
            temp.append(1)
        else:
            temp.append(0)
    adjList.append(temp)

print(" "*2 + "a" + " "*2 + "b" + " "*2 + "c" + " "*2 + "d" + " "*2 + "e" + " "*2 + "f" + " "*2 + "g" + " "*2 + "h")
for i in range(len(adjList)):
    print(chr(97+i) + " " + ", ".join(map(str,adjList[i])))

#Part A. BFS ##############################################################
"""
def BFS(v):
    fifo = []
    cost = 0
    temp = None
    fifo.append(v)
    while (len(fifo) != 0):
        temp = fifo.pop(0)
"""

"""
# function to find the shortest path 
def find_shortest_path(graph, start, end, path =[]): 
        path = path + [start] 
        if start == end: 
            return path 
        shortest = None
        for node in graph[start]: 
            if node not in path: 
                newpath = find_shortest_path(graph, node, end, path) 
                if newpath: 
                    if not shortest or len(newpath) < len(shortest): 
                        shortest = newpath 
        return shortest
"""
#Part B. Bipartite ########################################################
