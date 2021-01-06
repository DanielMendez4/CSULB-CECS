import sys
print("What is your married state?")
print("You could enter: married")
print("You could enter: single")
print("You could enter: swinger")
print("You could enter: vowed religious")
a = input()
b = ["married","single","swinger","vowed religious"]
def validateString(a,b):
    def inOptions(a,b):
        if a in b:
            print(a)
            sys.exit()
    inOptions(a,b)
    
def lv_number(a,b):
    string1 = a
    string2 = b
    distance = 0
    n1 = len(string1)
    n2 = len(string2)
    if n1 >= n2:
        for i in range(n1):
            if i < n2:
                if string1[i] != string2[i]:
                    distance += 1
            else:
                distance += 1
    else:
        for i in range(n2):
            if i < n1:
                if string2[i] != string1[i]:
                    distance -= 1
            else:
                distance -= 1
    return distance

def closest(a,b):
    answer = a
    while answer != b:
        if answer in b:
            print(answer)
            sys.exit()
        options = b
        distance = []
        userInput = answer
        for option in options:
            distance.append(abs(lv_number(answer, option)))
        intList = distance
        lowest = intList[0]
        index = 0
        for i in range(len(intList)):
            if intList[i] < lowest:
                index = i
                lowest = intList[i]
            if index == 0:
                    index = b[0]
            if index == 1:
                    index = b[1]
            if index == 2:
                    index = b[2]
            if index == 3:
                    index = b[3]
        print("Do you mean:",index,"?")
        print("What is your married state?")
        print("You could enter: married")
        print("You could enter: single")
        print("You could enter: swinger")
        print("You could enter: vowed religious")
        answer = input()
        
def main():
    validateString(a,b)
    lv_number(a,b)
    closest(a,b)
main()
