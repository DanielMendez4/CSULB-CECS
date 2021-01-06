def wordIn(word, words):
    stripped = ""
    for char in word:
        if (ord(char) >= 97) and (ord(char) <= 122):
            stripped = stripped + char
        elif (ord(char) >= 65) and (ord(char) <= 90):
            stripped = stripped + chr(ord(char)+32)
    return (stripped in words, stripped)

filename = "GettysburgAddress.txt"
file_resource = open(filename)
print("Prompting you for a list of words to look for.")
specialWords = []
wordStats = {}
while True:
    nextWord = input("Next word to look for or null to exit-->")
    lowercase = True
    for character in nextWord:
        if not (97 <= ord(character) <= 122):
            print("Error, you need to use only lower case letters.")
            lowercase = False
            break
    if nextWord == "":
        break
    elif lowercase:
        specialWords.append(nextWord)
        wordStats[nextWord] = 0
specialWords.sort()
for line in file_resource:
    line = line.strip()
    words = line.split(" ")
    for word in words:
        (foundIt, stripped) = wordIn(word, specialWords)
        if foundIt:
            wordStats[stripped] = wordStats[stripped] + 1
file_resource.close()
for word in specialWords:
    print("The word: %s was mentioned: %d times" %(word, wordStats[word]))
