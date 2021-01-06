#This program will take a text file, scramble it, and create a new scrambled text file
#Authors: Daniel Mendez & John Patrick Salcedo
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
    """If the word is less than or equal to 3 characters, it will remain unscrambled.
       Words greater than 3 characters will be scrambled, keeping the first and last character of that word"""
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
                    letterList.remove(letterList[removeLetter]) #Removes a random letter from the word
                    insertLetter = random.randint(1, wordLength-2)
                    position = insertLetter
                    letterList.insert(position, removedLetter) #Inserts the letter removed previously in random position
                letterList = "".join(letterList) #Brings the word back into a string
                final.append(letterList)

scramble(complete)
final = " ".join(final)

with open("sample.txt", "w") as outfile: #Creates a new file with the scrambled words
    outfile.write(final)
outfile.close()
