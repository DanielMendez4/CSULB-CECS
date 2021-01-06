infile = open("Scores.txt", "r")

print("StudentID   Name", end=' ')
for i in range(1,7):
    print("\t["+str(i)+"]", end=' ')
print("\tAverage")

for aStudent in infile:
    term = aStudent.split()
    print("{}  {}".format(term[0], term[1]), end=' ')
    sum = 0
    for i in range(2,8):
        print("\t{}".format(term[i]), end=' ')
        sum = sum + int(term[i])
    avg = sum / 6
    print("\t{:.2f}".format(avg))

infile.close()
