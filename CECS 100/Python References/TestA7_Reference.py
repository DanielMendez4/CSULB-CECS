word = input("Enter a word: ")
Alphabet=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
for i in range(0,26):
    print(word.count(Alphabet[i]))

file_name = open(input("Enter a file name: "), "r")
read_lines = file_name.read()
Alphabet=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
for i in range(0,26): 
    print(read_lines.count(Alphabet[i]))

with open(outfilename, 'w') as outfile:
    for fname in filenames:
        with open(fname, 'r') as readfile:
            outfile.write(readfile.read() + "\n\n")

filenames = ['file1.txt', 'file2.txt', ...]
with open('path/to/output/file', 'w') as outfile:
    for fname in filenames:
        with open(fname) as infile:
            for line in infile:
                outfile.write(line)

shopList = [] 
maxLengthList = 6
while len(shopList) < maxLengthList:
    item = input("Enter your Item to the List: ")
    shopList.append(item)
    print shopList
print "That's your Shopping List"
print shopList

