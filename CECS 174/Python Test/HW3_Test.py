import random

file_resource = open("input.txt")
complete = []
for line in file_resource:
    line = line.strip()
    words = line.split(" ")
    complete.append(words)
file_resource.close()

final = []
def scramble(complete):
    for i in range(len(complete)):
        scrambleList = complete[i]
        for j in range(len(scrambleList)):
            scrambleWord = scrambleList[j]
            if len(scrambleWord) <= 3:
                final.append(scrambleWord)
            else:
                letterList = list(scrambleWord)
                wordLength = len(letterList)
                for k in range(len(letterList)):
                    removeLetter = random.randint(1, wordLength-2)
                    removedLetter = letterList[removeLetter]
                    letterList.remove(letterList[removeLetter]
                    insertLetter = random.randint(1, wordLength-2)
                    position = insertLetter
                    letterList.insert(position, removedLetter)
                letterList = "".join(letterList)
                final.append(letterList)

scramble(complete)
final = " ".join(final)

with open("sample.txt", "w") as outfile: 
    outfile.write(final)
outfile.close()
