file_resource = input("Enter a file (Ex. file.txt): ")

print("Prompting you for a list of words to look for")
userInput = input("Next word to look for or null to exit-->")
word = []
while userInput:
    word.append(userInput)
    if userInput == None:
        break
    if userInput.islower() and userInput.isalpha():
        pass
    else:
        word.remove(userInput)
        print("Error, you need to use only lower case letters.")
        
    userInput = input("Next word to look for or null to exit-->")

word.sort()
words = 0

def wordIn(word,words):
    my_file = file_resource
    for i in range(len(word)):
        my_string = word[i]

        infile = open(my_file, "r")

        found = 0
        for line in infile:
            line = line.lower()
            line = line.strip()
            line = line.replace(",","")
            line = line.replace(".","")
            line = line.replace(";","")
            words = line.split(" ")
            found += words.count(my_string)
        infile.close()

        print("The word: %s was mentioned: %d times" %(my_string, found))

wordIn(word,words)
        
    
    
