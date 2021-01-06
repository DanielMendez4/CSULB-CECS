#This program will take a user inputted file and read it.
#Once read, calculates the number of occurances for each letter of the alphabet that appears in the file.
#Authors: Daniel Mendez % John Patrick Salcedo
alphabet = {}
#Tests whether user inputted file can be found and read.
while True:
    filename = input("Enter the name of the file to read --> ")
    try:
        file_object = open(filename)
        break
    except FileNotFoundError:
        print("File not found!")
#This loop sets up the dictionary alphabet.
setDict = open(filename, "r")
for line in setDict:
    line = line.lower()
    for char in line:
        if char.isalpha():
            alphabet[char] = 0
#This loop reads the file and adds the number of occurrences for each letter in the dictionary.
reading = open(filename, "r")
for line in reading:
    line = line.lower()
    for char in line:
        if char.isalpha():
            alphabet[char] += 1
#Gives results in a random order
for letter in alphabet:
    print("The letter: %s occurred %8d times" %(letter, alphabet[letter]))

print("")
#Sorts letters in dictionary by which one occurred the most (high to low).
complete = sorted(alphabet, key = alphabet.get, reverse = True)
#Sorts occurrences in dictionary by highest to lowest.
sortOccurrence = sorted(alphabet.values(), reverse = True)
#Gives the results in descending order (highest to lowest).
for i in range(len(complete)):
    letter = complete[i]
    occurrence = sortOccurrence[i]
    print("The letter: %s occurred %8d times" %(letter, occurrence))

print("")
#Cacluates the average and total number of occurrences.
average = sum(sortOccurrence)/len(sortOccurrence)
total = sum(sortOccurrence)
print("The average letter count is {:.2f}.\nThe total number of occurrences across all letters is {}.".format(average, total))
