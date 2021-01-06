#This program will return the location of a word specified by the user.
#Program add user input to the sorted list if not already inside.
#Authors: Daniel Mendez & John Patrick Salcedo
class SL:

    def __init__(self):
        self.members = []
            
    def getIndex(self, word):
        """Looks for the given word in the list.
           Arguments:
           a. word – The word that the user wants to find in the list of members inside of SL.
           Returns:
           a. Boolean that is true if the word has been added to the SL instance already.
           b. The index number of where the element is in the SL list if it exists there.
           If not, then this is the index where it belongs."""
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
        """Add a new word to the sorted list.
           Arguments:
           a. word - The word to add to the sorted list.
           If the word already exists, then throw a ValueErrorr.
           The way that add works is that it first finds the location in the list where the new word should go,
           then uses the list insert method to put the new word in the right spot in the list."""
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
        """Returns a True if the members of the SL object are sorted, and False otherwise."""
        for i in range(1, len(self.members)):
            if self.members[i] < self.members[i-1]:
                return False
        return True

while True:
    filename = input("Enter the name of the file to read --> ")
    try:
        file_object = open(filename)
        break
    except FileNotFoundError:
        print("File not found!")

initial = []
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
