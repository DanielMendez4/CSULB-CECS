class SL:

    def __init__(self):
        self.members = []
            
    def getIndex(self, word):
        lower = 0
        upper = len(self.members) - 1
        found = False
        while lower <= upper and found == False:
            mid = int((lower + upper)/2)
            if nextWord == self.members[mid]:
                found = True
            elif self.members[mid] < nextWord:
                lower = mid + 1
            else:
                upper = mid - 1
                
        if found == True:
            index = mid
        else:
            index = lower
 
        return found, index

    def add(self, word):
        if len(self.members) == 0:
            self.member.append(nextWord)
        else:
            found, index = self.getIndex(nextWord)
            try:
                result = True / found
                print("Error, cannot add redundant element!")
            except ZeroDivisionError:
                self.members.insert(index, nextWord)

    def testSorted(self):
        for i in range(1, len(self.members)):
            if self.members[i] < self.members[i-1]:
                return False
        return True
        
initial = []

while True:
    filename = input("Enter the name of the file to read --> ")
    try:
        file_object = open(filename)
        break
    except FileNotFoundError:
        print("File not found!")

reading = open(filename, "r")
for line in reading:
    line = line.strip()
    initial.append(line)

words = SL()

while initial:
    minimum = initial[0]
    for i in initial:
        if i < minimum:
            minimum = i
    words.members.append(minimum)
    initial.remove(minimum)

while True:
    nextWord = input("Enter the next word to search for or null to exit --> ")
    if len(nextWord) == 0:
        break
    else:
        found, index = words.getIndex(nextWord)
        if not found:
            print("Could not find it, but it would be positioned:", index)
            words.add(nextWord)
        else:
            print("Found at element:", index)
            words.add(nextWord)
