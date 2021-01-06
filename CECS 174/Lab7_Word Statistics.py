#This program will prompt user for a text file
#Then program will prompt user to enter a list of words to look for in the text file
#Authors: Daniel Mendez & John Patrick Salcedo
file_resource = input("Enter a file (Ex. file.txt): ") #Prompts user for text file

print("Prompting you for a list of words to look for")
userInput = input("Next word to look for or null to exit-->") #Prompts user for word to look for
word = []
while userInput:
    word.append(userInput)
    if userInput == None: #If user presses the enter key, loop terminates
        break
    if userInput.islower() and userInput.isalpha(): #Detects if user input is in lower case letters
        pass
    else:
        word.remove(userInput) #If input is anything else besides lower case letters, remove word and prompt
        print("Error, you need to use only lower case letters.")
        
    userInput = input("Next word to look for or null to exit-->")

word.sort() #Sorts list in alphabetical order
words = 0

def wordIn(word,words):
    """Will give how many times a word from the list created by the user appears in the given text file"""
    my_file = file_resource
    for i in range(len(word)): #For i in the range of the length of the list words, find how many times each word appears
        my_string = word[i]
        infile = open(my_file, "r")
        found = 0
        for line in infile: #This loop will remove non alpha characters and count occurances
            line = line.lower()
            line = line.strip()
            line = line.replace(",","")
            line = line.replace(".","")
            line = line.replace(";","")
            words = line.split(" ")
            found += words.count(my_string) #Shows how many times word was found in text file
        infile.close()

        print("The word: %s was mentioned: %d times" %(my_string, found))

wordIn(word,words)
        
    
    
